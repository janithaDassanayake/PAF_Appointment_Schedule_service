package com;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.AppoinmentTypeBean;
import model.AppoinmentSchedule;

/**
 * Servlet implementation class SceduleAPI
 */
@WebServlet("/SceduleAPI")
public class SceduleAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AppoinmentSchedule appoinmentSchedule = new AppoinmentSchedule();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SceduleAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String output = appoinmentSchedule.addSchedule(
				request.getParameter("Date"),
				request.getParameter("Start_Time"),
				request.getParameter("End_Time"),
				request.getParameter("D_id"),
				request.getParameter("H_id"),
				request.getParameter("App_id"));
				response.getWriter().write(output); 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map paras = getParasMap1(request);
		 String output = appoinmentSchedule.updateAppointmentSchedule(paras.get("hidScheduleIDSave").toString(),
		 paras.get("Date").toString(),
		 paras.get("Start_Time").toString().replace("%3A",":"),
		 paras.get("End_Time").toString().replace("%3A",":"),
		 paras.get("D_id").toString(),
		 paras.get("H_id").toString(),
		 paras.get("App_id").toString());
		 response.getWriter().write(output); 
		
	}


	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		Map paras = getParasMap1(request);
		System.out.println(paras.get("Schedule_id "));
		String output = appoinmentSchedule.deleteSchedule(paras.get("Schedule_id ").toString());
		System.out.println("error point "+output);
		response.getWriter().write(output);	
	}
	
	
	
	private static Map getParasMap1(HttpServletRequest request)
	{
	 Map<String, String> map = new HashMap<String, String>();
	try
	 {
	 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
	 String queryString = scanner.hasNext() ?
	 scanner.useDelimiter("\\A").next() : "";
	 scanner.close();
	 String[] params = queryString.split("&");
	 for (String param : params)
	 { 
		 String[] p = param.split("=");
		 map.put(p[0], p[1]);
		 }
		 }
		catch (Exception e)
		 {
		 }
		return map;
		}


}
