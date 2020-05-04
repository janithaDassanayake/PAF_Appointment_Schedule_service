<%@page import="model.AppoinmentSchedule"%>
<%@page import="model.AppoinmentType"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
      <a class="nav-link dropdown-toggle" href="ScheduleHome.jsp" id="navbardrop" data-toggle="dropdown">
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
  
 <br>

	<div class="container">
		<div class="row">
			<div class="col-md-3">

				<h1 id="heading">Add Schedule</h1>

				
				<form id="formSchedule" name="formSchedule">


					Day: <select class="form-control form-control-sm" id='Date'name="Date">
						<option selected value=''> Choose Date </option>
						<option value='Sunday'>Sunday</option>
						<option value='Monday'>Monday</option>
						<option value='Tuesday'>Tuesday</option>
						<option value='Wednesday'>Wednesday</option>
						<option value='Thursday'>Thursday</option>
						<option value='Friday'>Friday</option>
						<option value='Saturday'>Saturday</option>
					</select> 
					<br> 
					
					Start Time: <input id="Start_Time" name="Start_Time"
						type="time" class="form-control form-control-sm">
						
						 <br>


					Start Time: <input id="End_Time" name="End_Time" type="time"
						class="form-control form-control-sm" >
						
						 <br>
				    Doctor ID: <input id="D_id" name="D_id" type="number"
						class="form-control form-control-sm">
						
					    <br>
					 Hospital ID:<input id="H_id" name="H_id" type="number"
						class="form-control form-control-sm">
						
						 <br>

					Appointment Type ID:
					<input id="App_id" name="App_id" type="number"
						class="form-control form-control-sm"> 
						
					<br> 
				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary" style="width:255px">
 					
 					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
					
					</form>
					
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
				<br>
			</div>

			<div class="col-md-9">
				<div class="container">
					
					<center> <h3>Appointment Schedule Action</h3></center> 
					<br>
					<div id="divItemsGrid1" class="table table-striped">
						<%
						AppoinmentSchedule AppoinmtmentObj = new AppoinmentSchedule();
						out.print(AppoinmtmentObj.ReadAllSchedule());
						%>
					</div>
				</div>
			</div>
		</div>
				
	</div>
</body>
</html>