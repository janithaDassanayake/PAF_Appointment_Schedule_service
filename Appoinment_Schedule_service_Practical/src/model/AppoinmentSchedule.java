package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import beans.ScheduleBean;
import beans.AppoinmentTypeBean;
import util.DBconnection;

public class AppoinmentSchedule {

	DBconnection dbObj = new DBconnection();
	
	
	//========================= View All Schedule ==========================
	

	public String ReadAllSchedule() {

		String output = "";
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Day</th><th>Starttime</th>"
					 + "<th>Endtime</th><th>Doctor ID</th><th>Hospital ID</th><th>Appointmet Type ID</th><th>Update</th><th>Remove</th></tr>"; 

			String query = "select * from appointment_scheduling";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			// iterate through the rows in the result set
			while (rs.next()) {
				int schedule_id = rs.getInt("Schedule_id");
				String date = rs.getString("Date");
				String start_time = rs.getString("Start_Time");
				String end_time = rs.getString("End_Time");
				int d_id = rs.getInt("D_id");
				int h_id = rs.getInt("H_id");
				int app_id = rs.getInt("App_id");
			

				// Add into the html table
				output += "<tr><td><input id='hidScheduleIDUpdate' name='hidScheduleIDUpdate' type='hidden' value='" +schedule_id+ "'>" +date+ "</td>";
				output += "<td>" + start_time + "</td>";
				output += "<td>" + end_time + "</td>";
				output += "<td>" + d_id + "</td>";
				output += "<td>" + h_id + "</td>";
				output += "<td>" + app_id + "</td>";


				output += "<td><input name='btnUpdate' type='button'value='Update'class='btnUpdate btn btn-secondary'></td> "
						+ "<td><input name='btnRemove' type='button' value='Remove'class='btnRemove btn btn-danger' data-itemid='"+schedule_id+"'>" + "</td></tr>";
				
			}

			con.close();
			// Complete the html table
			output += "</tr></table>";

		} catch (Exception e) {
			output = "Error while reading the Schedule Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	
	
	
	
	
	
	public String viewAllSchedule() {

		String output = "";
		
		ScheduleBean appScheduling = new ScheduleBean();
		AppoinmentTypeBean  TypeRead = new AppoinmentTypeBean();
		
		try {
			Connection con = dbObj.connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			// Prepare the html table to be displayed
		
			output = "<table border='1'><tr><th>Schedule Id</th>"
					+ "<th>appoinment Type</th>" 
					+ "<th>Doctor Name</th>" 
					+ "<th>Hospital Name</th>" 
					+ "<th>Day</th>" 
					+ "<th>Start Time</th>" 
					+ "<th>End Time</th>"
					+ "<th>Doctor Id</th>"
					+ "<th>Hostpital Id</th>"
					+ "<th>Appointment Id</th></tr>";

			
			
						String query = "select s.Schedule_id,a.Appointment_Type,d.DoctorName,h.Hospital_Name,s.Date,s.Start_Time,s.End_Time,s.D_id,s.H_id,s.App_id "
								+ "from appointment_scheduling s ,appointment_type a , doctor d, hostpital h "
								+ "WHERE s.App_id=a.appointment_Id AND s.D_id=d.Doctor_Id AND s.H_id=h.hospital_Id";
						
						Statement stmt = con.createStatement();
						ResultSet rs = stmt.executeQuery(query);

						// iterate through the rows in the result set
						while (rs.next()) {
							
							String docname = rs.getString("DoctorName");
							String Hosname = rs.getString("Hospital_Name");
							appScheduling.setSchedule_id(rs.getInt("Schedule_id"));
							
							TypeRead.setAppointment_Type(rs.getString("Appointment_Type"));
							
							appScheduling.setDate(rs.getString("Date"));
							//appScheduling.setStart_Time(rs.getString("Start_Time"));
							//appScheduling.setEnd_Time(rs.getTime("End_Time"));
							appScheduling.setStart_Time(rs.getString("Start_Time"));
							appScheduling.setEnd_Time(rs.getString("End_Time"));
							appScheduling.setD_id(rs.getInt("D_id"));
							appScheduling.setH_id(rs.getInt("H_id"));
							appScheduling.setApp_id(rs.getInt("App_id"));
							
							

							// Add into the html table
			            	output += "<tr><td>" + appScheduling.getSchedule_id() + "</td>";
			 				output += "<td>" + TypeRead.getAppointment_Type()+ "</td>";
			 				output += "<td>" + docname+ "</td>";
			 				output += "<td>" + Hosname+ "</td>";
							output += "<td>" + appScheduling.getDate() + "</td>";
							output += "<td>" + appScheduling.getStart_Time()+ "</td>";
							output += "<td>" + appScheduling.getEnd_Time()+ "</td>";
							output += "<td>" + appScheduling.getD_id()+ "</td>";
							output += "<td>" + appScheduling.getH_id()+ "</td>";
							output += "<td>" + appScheduling.getApp_id()+ "</td>";

						}

						con.close();
						// Complete the html table
						output += "</tr></table>";

					} catch (Exception e) {
						output = "Error while reading the Schedule Details.";
						System.err.println(e.getMessage());
					}

		return output;
	}
	
	
	

	//====================== Add In To Appointment Scheduling ========================
	
		public String addSchedule(String date, String start_time, String end_time, String d_id, String h_id, String app_id) {

		
			String output = "";
			try {

				Connection con = dbObj.connect();

				if (con == null) {
					return "Error while connecting to the database";
				}
	
				// create a prepared statement
				String query = " INSERT INTO appointment_scheduling (Date, Start_Time, End_Time, D_id, H_id, App_id) VALUES (?, ?, ?, ?, ?,?)";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				
				// binding values
				preparedStmt.setString(1, date);
				preparedStmt.setString(2, start_time);
				preparedStmt.setString(3, end_time);
				preparedStmt.setInt(4,Integer.parseInt(d_id));
				preparedStmt.setInt(5,Integer.parseInt(h_id));
				preparedStmt.setInt(6,Integer.parseInt(app_id));
							
	
				preparedStmt.execute();
				con.close();
				
				String newSchedule = ReadAllSchedule();
				output = "{\"status\":\"success\", \"data\": \"" + newSchedule + "\"}";

			} catch (Exception e) {
				output = "{\"status\":\"error\", \"data\": \"Error while inserting the Schedule.\"}";
				System.err.println(e.getMessage());
			}

			System.out.print(output);
			return output;
		}
		
		
		
	
		
		
		
		//============================= Update Appointment Scheduling ==============================
		
		public String updateAppointmentSchedule(String schedule_id , String date, String startTime, String endTime, String d_id, String h_id, String app_id) {

			String output = "";

			try {
				Connection con = dbObj.connect();
				if (con == null) {
					return "Error while connecting to the database for updating.";
				}
				// create a prepared statement
				String query = "UPDATE appointment_scheduling SET Date =?,Start_Time =?,End_Time =?,D_id =?,H_id =?,App_id =? WHERE Schedule_id =?";
				PreparedStatement preparedStmt = con.prepareStatement(query);

				// binding values

				preparedStmt.setString(1, date);
				preparedStmt.setString(2, startTime);
				preparedStmt.setString(3, endTime);
				preparedStmt.setInt(4,Integer.parseInt(d_id));
				preparedStmt.setInt(5,Integer.parseInt(h_id));
				preparedStmt.setInt(6,Integer.parseInt(app_id));
				preparedStmt.setInt(7, Integer.parseInt(schedule_id));
				// execute the statement
				preparedStmt.execute();
				con.close();
				
				String newSchedule = ReadAllSchedule();
				output = "{\"status\":\"success\", \"data\": \"" +newSchedule + "\"}";
				 
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while updating the Schedule.\"}";
				 
				System.err.println(e.getMessage());
			}
				
			return output;
				 
		} 
		
		
		
		
		
		public String deleteSchedule(String Schedule_id)
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
				String query = "DELETE FROM appointment_scheduling WHERE Schedule_id=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
		 
				preparedStmt.setString(1, Schedule_id);
				preparedStmt.execute();
				con.close();
		
				String newSchedule = ReadAllSchedule();
				output = "{\"status\":\"success\", \"data\": \"" + newSchedule + "\"}";
		 
			}
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\":\"Error while deleting the Schedule.\"}";
				System.err.println(e.getMessage());
		 
			}
		 
			return output;
		 
		}
	
	}
		
