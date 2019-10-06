<!DOCTYPE html>
<%@page import="domain.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>Online Movie Ticket Booking</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<% User user = (User)request.getSession().getAttribute("user");
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">Online Movie Ticket Booking System</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <%if(user==null) {%>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=Login'">Login</a>
	      </li> 
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=CustomerViewAllMovies'">View Movies<span class="sr-only">(current)</span></a>
	      </li>
	      <%} %>
	      
	      <%if(user!=null && user.getRole().equals("manager")) {%>
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerViewAllMovies'">View Movies<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerAddMovie'">Add Movie</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerViewAllTickets'">View All tickets</a>
	      </li>
	      <%} %>
	      
	      <%if(user!=null && user.getRole().equals("customer")) {%>
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=CustomerViewAllMovies'">View Movies<span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=CustomerViewTickets'">View my ticket<span class="sr-only">(current)</span></a>
	      </li>
	      <%} %>
	    </ul>
	    <span class="navbar-text">
	     Welcome: <%if(user!=null){
	    	 out.print(user.getLastNameString());
	     }else{
	    	 out.print("visitor");
	     } %>
	     <% if(user!=null){%>
	     <a href="FrontServlet?command=Logout">Log out</a>
	     <%} %>
	    </span>
	  </div>
	</nav>
	<img src="img/cinema_image.jpg" class="img-rounded" alt="Cinque Terre" style="width:100%; opacity: 0.6;">
	
	<script src="js/bootstrap.js"></script>
</body>
</html>