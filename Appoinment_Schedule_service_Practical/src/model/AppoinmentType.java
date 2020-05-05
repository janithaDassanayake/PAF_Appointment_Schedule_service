package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import beans.AppoinmentTypeBean;
import util.DBconnection;



public class AppoinmentType {
	
	
	DBconnection dbObj = new DBconnection();

	//===================== View Appointment Types ==========================
	
	
	public String viewAppointmentTypes() {

		String output = "";
		
		AppoinmentTypeBean  TypeRead = new AppoinmentTypeBean();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			
			output = "<table border='1'><tr><th>Appointment</th><th>Type</th>"
					 + "<th>Description</th><th>App ID</th><th>Update</th><th>Remove</th></tr>"; 

			String query = "select * from appointment_type";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {

				TypeRead.setAppointment_Id(rs.getInt("Appointment_Id"));
				TypeRead.setAppointment_Type(rs.getString("Appointment_Type"));
				TypeRead.setAppointment_Name(rs.getString("Appointment_Name"));
				TypeRead.setAppointment_Desc(rs.getString("Appointment_Desc"));
				

				// Add into the html table
				output += "<tr><td><input id='hidtypeIDUpdate' name='hidtypeIDUpdate' type='hidden' value='" + TypeRead.getAppointment_Id() + "'>" + TypeRead.getAppointment_Type() + "</td>";
				output += "<td>" + TypeRead.getAppointment_Name()+ "</td>";
				output += "<td>" + TypeRead.getAppointment_Desc()+ "</td>";
				output += "<td>" + TypeRead.getAppointment_Id()+ "</td>";
			
			
				output += "<td><input name='btnUpdate' type='button'value='Update'class='btnUpdate btn btn-warning'></td> "
						+ "<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-typeid='" + TypeRead.getAppointment_Id() + "'>" + "</td></tr>";
			
			}
			con.close();
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Doctors Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	

//==========================Add appointment type===================================


	public String addAppointmentType(String type, String name, String desc)
	{
		String output = "";
			 
		try
		{
			Connection con = dbObj.connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for inserting.";
			}
			 
			// create a prepared statement
			String query = " INSERT INTO appointment_type (Appointment_Type, Appointment_Name, Appointment_Desc) VALUES (?, ?, ?)";
			
			 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			// binding values
			preparedStmt.setString(1, type);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, desc);
			 
			// execute the statement
			preparedStmt.execute();
			con.close();
			 
			String newType = viewAppointmentTypes();
			output = "{\"status\":\"success\", \"data\": \"" + newType + "\"}";
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while inserting the Appoinment Type\"}";
			 
			System.err.println(e.getMessage());
			 
		}
			 
		return output;
			
	} 


		//============================= Update Appointment Type ==============================
		
	

	public String updateAppointmentType(String ID, String type, String name, String desc)
	{
			 
		String output = "";
			 
		try
		{
			Connection con = dbObj.connect();
			
			if (con == null)
			{
				return "Error while connecting to the database for updating.";
			}
			 
			// create a prepared statement
			String query = "UPDATE appointment_type SET Appointment_Type=?,Appointment_Name=?,Appointment_Desc=? WHERE appointment_Id =?";
			 
			PreparedStatement preparedStmt = con.prepareStatement(query);
			 
			// binding values
			preparedStmt.setString(1, type);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, desc);
			preparedStmt.setInt(4, Integer.parseInt(ID));
			 
			// execute the statement
			preparedStmt.execute();
			con.close();
			 
			String newType = viewAppointmentTypes();
			output = "{\"status\":\"success\", \"data\": \"" +newType + "\"}";
			 
		}
		catch (Exception e)
		{
			output = "{\"status\":\"error\", \"data\": \"Error while updating the Appoinment Type.\"}";
			 
			System.err.println(e.getMessage());
		}
			
		return output;
			 
	} 
	

	
	
	

	//============================= Delete Appointment Type ==============================	
		
			
			public String deleteAppointmentTypes(String typeID)
			{
				String output = "";
			 
				try
				{
					Connection con = dbObj.connect();
					
					if (con == null)
					{
						return "Error while connecting to the database for deleting.";
					} 
			
					// create a prepared statement
					String query = "delete from appointment_type where appointment_Id=?";
					
					PreparedStatement preparedStmt = con.prepareStatement(query);
			 
					// binding values
					preparedStmt.setString(1, typeID);
					preparedStmt.execute();
					con.close();
			
					String newType = viewAppointmentTypes();
					output = "{\"status\":\"success\", \"data\": \"" + newType + "\"}";
			 
				}
				catch (Exception e)
				{
					output = "{\"status\":\"error\", \"data\":\"Error while deleting the Appoinment Type.\"}";
					System.err.println(e.getMessage());
			 
				}
			 
				return output;
			 
			}
			


			//====================================search type by ID ===================================
	
			/*

			//view list of appointment types	
			public List<AppoinmentTypeBean> viewTypes() {
				
				return	viewTypes(0);

			}
			
			//show the type by ID
			public AppoinmentTypeBean ShowTypeById(int id) {
			List<AppoinmentTypeBean> list =viewTypes(id);
				if(!list.isEmpty()) {
					return	list.get(0);
				}
				return null;
			}
			
			
				
			//view method
			public List<AppoinmentTypeBean> viewTypes(int id) {
					List <AppoinmentTypeBean> TypeList = new ArrayList<>();
					
				try 
				{
					Connection con = dbObj.connect();
					if (con == null) {
						
						System.out.println("Error While reading from database");
						return TypeList;
					}

					String query;
					
					if(id==0) {
					query = "select * from appointment_type";
					}
					else {
						query = "select * from appointment_type where appointment_Id="+id;	
					}
					Statement stmt = con.createStatement();
					ResultSet results = stmt.executeQuery(query);

					while (results.next()) {
						AppoinmentTypeBean type = new AppoinmentTypeBean(
												results.getInt("appointment_Id"),
												results.getString("Appointment_Type"),
												results.getString("Appointment_Name"),
												results.getString("Appointment_Desc")	
											);
						TypeList.add(type);
					}
					con.close();
				}
				catch (Exception e) {
					System.out.println("Error While Reading");
					System.err.println(e.getMessage());
				}
				
				return TypeList;
			}
			
			
			
			
			*/
			
			
			
			
}