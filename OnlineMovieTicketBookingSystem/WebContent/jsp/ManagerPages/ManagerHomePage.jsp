<!DOCTYPE html>
<%@page import="domain.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>Online Movie Ticket Booking</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<% User user = (User)request.getSession().getAttribute("user");
%>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
	  <a class="navbar-brand" href="javascript:location.href='FrontServlet?command=ManagerHome'">Online Movie Ticket Booking System</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerViewAllMovies'">View Movies<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerAddMovie'">Add Movie</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerViewAllTickets'">View All tickets</a>
	      </li>
	      <%/* <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=CustomerHome'">Login as Customer</a>
	      </li>
	      */%>
	    </ul>
	    <span class="navbar-text">
	     Welcome: ${user.lastNameString}
	     <a href="FrontServlet?command=Logout">Log out</a>
	    </span>
	  </div>
	</nav>
	<img src="img/manager.jpg" class="img-rounded" alt="Cinque Terre" style="width:100%; opacity: 0.6;">
	
	<script src="js/bootstrap.js"></script>
</body>
</html>