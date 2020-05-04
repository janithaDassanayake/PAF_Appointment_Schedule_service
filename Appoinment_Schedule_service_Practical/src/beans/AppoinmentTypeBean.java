package beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AppoinmentTypeBean {

	private int Appointment_Id;
	private String Appointment_Type;
	private String Appointment_Name;
	private String Appointment_Desc;

	public AppoinmentTypeBean() {

	}

	public AppoinmentTypeBean(int Appointment_Id, String Appointment_Type, String Appointment_Name,
			String Appointment_Desc) {

		this.Appointment_Id = Appointment_Id;
		this.Appointment_Type = Appointment_Type;
		this.Appointment_Name = Appointment_Name;
		this.Appointment_Desc = Appointment_Desc;
	}

	public int getAppointment_Id() {
		return Appointment_Id;
	}

	public void setAppointment_Id(int appointment_Id) {
		Appointment_Id = appointment_Id;
	}

	public String getAppointment_Type() {
		return Appointment_Type;
	}

	public void setAppointment_Type(String appointment_Type) {
		Appointment_Type = appointment_Type;
	}

	public String getAppointment_Name() {
		return Appointment_Name;
	}

	public void setAppointment_Name(String appointment_Name) {
		Appointment_Name = appointment_Name;
	}

	public String getAppointment_Desc() {
		return Appointment_Desc;
	}

	public void setAppointment_Desc(String appointment_Desc) {
		Appointment_Desc = appointment_Desc;
	}

}
