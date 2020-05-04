<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Appointment Service</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link  rel="stylesheet"  href="Views/styles/schedule.css"/>
<script src="Components/jquery-3.4.1.min.js"></script>

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
      <a class="nav-link" href="#">Home</a>
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
   
<form>   
<hr/>	       
<div class="row">
  <div class="column">
    <div class="card">
     <a href="AppointmentType.jsp">
      <img src="Views/images/s2.png" style="width:100%">
      </a>
      <div class="container">
        <p align="center">  <a href="AppointmentType.jsp"><b>Click Here To Create Appointment Types</b></a> </p>	
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
     <a href="AppoinmentSchedule.jsp">
      <img src="Views/images/s1.png"  style="width:100%">
      </a>
      <div class="container">
         <p align="center">  <a  href="AppoinmentSchedule.jsp"><b>Click Here To Create Schedules</b></a> </p>
      </div>
    </div>
  </div>
  <div class="column">
    <div class="card">
    <a href="ViewAppoinmentSummary.jsp">
      <img src="Views/images/s11.png" style="width:100%">
      </a>
      <div class="container">
         <p align="center">  <a href="ViewAppoinmentSummary.jsp"><b>Click Here To View Schedule Summary</b></a> </p>
      </div>
    </div>
  </div>
</div>
</form>

      <hr/>

</body>
</html>