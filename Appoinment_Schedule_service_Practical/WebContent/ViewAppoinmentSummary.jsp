<%@page import="model.AppoinmentSchedule"%>
<%@page import="model.AppoinmentType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Service</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.4.1.min.js"></script>
<script src="Components/Schedule.js"></script>


	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">IT17167710+</a>

  <!-- Links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="ScheduleHome.jsp">Home</a>
    </li>
    
    <li class="nav-item">
      <a class="nav-link" href="AppointmentType.jsp">Appointments</a>
    </li>

   <li class="nav-item">
      <a class="nav-link" href="AppoinmentSchedule.jsp">Schedules</a>
    </li>
	
    <!-- Dropdown -->
    <li class="nav-item dropdown" style="margin-left: 700px">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Schedule Dropdown 
      </a>
      	<div class="dropdown-menu">
        <a class="dropdown-item" href="AppointmentType.jsp">Define Appointments</a>
        <a class="dropdown-item" href="AppoinmentSchedule.jsp">Create Schedules</a>
        <a class="dropdown-item" href="ViewAppoinmentSummary.jsp">View Summary Schedules</a>
      </div>
    </li>
  </ul>
</nav>
<br>
  

				<div class="container">
					
					<h2 align="center">Appointment Schedule List</h2>
					<br>
					<div id="divItemsGrid1" class="table table-striped table-dark">
						<%
							AppoinmentSchedule AppoinmtmentObj1 = new AppoinmentSchedule();
						out.print(AppoinmtmentObj1.viewAllSchedule());
						%>
					</div>
				</div>


</body>
</html>