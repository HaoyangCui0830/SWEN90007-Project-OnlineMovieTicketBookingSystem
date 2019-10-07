<%@page import="domain.Ticket"%>
<%@page import="domain.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="domain.Session"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ticket</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%
	 Ticket ticket = (Ticket)request.getAttribute("ticket");      
	 System.out.println(ticket);       
	  if(ticket!=null){%>
<form action="FrontServlet?command=ManagerUpdateTicket" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Ticket ID</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="ticketId" value="<%=ticket.getTicket_id()%>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Name</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieName" value="<%=ticket.getMovie().getName() %>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie ID</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieId" value="<%=ticket.getMovie().getMovieId() %>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Session Id</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionId" value="<%=ticket.getSession().getSessionId() %>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Start Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionStartTime" value="<%=ticket.getSession().getTimeRange().getStartTime()%>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">End Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionEndTime" value="<%=ticket.getSession().getTimeRange().getEndTime()%>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Customer Name</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="customerName" value="<%=ticket.getCustomerName() %>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Cinema</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="cinema" value="<%=ticket.getCinema().getName() %>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Cinema ID</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="cinemaId" value="<%=ticket.getCinema().getCinemaId() %>" >
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">number of tickets</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="ticketAmount" value="<%=ticket.getSeatNumber()%>" >
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend"> 
    <span class="input-group-text" id="inputGroup-sizing-lg">Total price (<%= ticket.getMovie().getPrice()%> * <%=ticket.getSeatNumber() %>)</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="ticketAmount" value="<%=ticket.getSeatNumber()*ticket.getMovie().getPrice()%>" readOnly="true">
</div>
<div class="text-center">
	<button  type="button" class="btn btn-secondary centered" onclick="javascript:location.href='FrontServlet?command=ManagerViewAllTickets'" >Cancel</button>
	<input type="submit" value="update" class="btn btn-success centered"></input>
	</div>
</form>
<%}
	  %>
</body>
</html>