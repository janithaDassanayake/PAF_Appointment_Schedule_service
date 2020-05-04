package beans;

import java.sql.Date;
import java.sql.Time;

public class ScheduleBean {

	private int Schedule_id;
	private String Date;
	private String Start_Time;
	private String End_Time;
	private int D_id;
	private int H_id;
	private int App_id;

	public ScheduleBean() {

	}

	public ScheduleBean(int schedule_id, String date, String start_Time, String end_Time, int d_id, int h_id, int app_id) {
		Schedule_id = schedule_id;
		Date = date;
		Start_Time = start_Time;
		End_Time = end_Time;
		D_id = d_id;
		H_id = h_id;
		App_id = app_id;
	}

	public int getSchedule_id() {
		return Schedule_id;
	}

	public void setSchedule_id(int schedule_id) {
		Schedule_id = schedule_id;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStart_Time() {
		return Start_Time;
	}

	public void setStart_Time(String start_Time) {
		Start_Time = start_Time;
	}

	public String getEnd_Time() {
		return End_Time;
	}

	public void setEnd_Time(String end_Time) {
		End_Time = end_Time;
	}

	public int getD_id() {
		return D_id;
	}

	public void setD_id(int d_id) {
		D_id = d_id;
	}

	public int getH_id() {
		return H_id;
	}

	public void setH_id(int h_id) {
		H_id = h_id;
	}

	public int getApp_id() {
		return App_id;
	}

	public void setApp_id(int app_id) {
		App_id = app_id;
	}

}