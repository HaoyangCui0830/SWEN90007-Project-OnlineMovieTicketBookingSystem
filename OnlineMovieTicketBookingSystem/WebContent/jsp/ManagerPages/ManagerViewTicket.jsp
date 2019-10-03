<%@page import="domain.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Single Ticket Info</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<% Ticket ticket= (Ticket)request.getAttribute("ticket");
	        if(ticket!=null){%>
	        <div class="text-center">
	        <ul class="list-group">
			<li class="list-group-item disabled">Ticket No: <%= ticket.getTicket_id() %> </li>
			<li class="list-group-item disabled">Customer Name: <%= ticket.getCustomerName() %></li>
			<li class="list-group-item disabled">Movie ID: <%= ticket.getMovie().getMovieId() %></li>
			<li class="list-group-item disabled">Movie Name: <%= ticket.getMovie().getName() %></li>
			<li class="list-group-item disabled">Session: <%= ticket.getSession().getSessionId() %></li>
			<li class="list-group-item disabled">number of seats: <%= ticket.getSeatNumber() %></li>
		  

			</ul>
			</div>
	        <%}
	  %>
	  
	  
	  <div class="text-center">
	  <button  type="button" class="btn btn-dark centered" 
	onclick="javascript:location.href='FrontServlet?command=ManagerViewAllTickets'">Back</button>
	</div>
	<script src="js/bootstrap.js"></script>
</body>
</html>