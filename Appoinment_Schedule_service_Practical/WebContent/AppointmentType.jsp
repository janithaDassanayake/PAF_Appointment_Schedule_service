<%@page import="model.AppoinmentType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Appointment Service </title>
		<link rel="stylesheet" href="Views/bootstrap.min.css">
		<script src="Components/jquery-3.4.1.min.js"></script>
		<script src="Components/AppointmentType.js"></script>
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
        Schedule Drop down 
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
  


<br>
	<div class="container">
		<div class="row">
			<div class="col-md-4">

				<h3 id="heading">Add Appointment Type</h3>
				<br>
					<form id="formtype" name="formtype">
 					
 					Appointment Type:
 					<input id="Appointment_Type" name="Appointment_Type" type="text" class="form-control form-control-sm" > <br> 
 					
 					
 					Appointment Name:
 					<input id="Appointment_Name" name="Appointment_Name" type="text" class="form-control form-control-sm"> <br> 
 				
 				
 					Appointment Discription :
 					<input id="Appointment_Desc" name="Appointment_Desc" type="text" class="form-control form-control-sm"> <br>
 					
 					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary" style="width:350px">
 					
 					<input type="hidden" id="hidtypeIDSave" name="hidtypeIDSave" value="">
					
					</form>
					
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
					
		
				</div>

			<div class="col-md-8">
					<h4 align="center">Appointment Type Table</h4>
						<br>
							<div id="divtypeGrid" class="table table-striped">
							 <%
							 AppoinmentType AppoinmtmentObj = new AppoinmentType();
							 out.print(AppoinmtmentObj.viewAppointmentTypes());
							 %>
						</div>
				</div>
			</div>
 			
 			
 			
						
				</div>

	</body>
</html>