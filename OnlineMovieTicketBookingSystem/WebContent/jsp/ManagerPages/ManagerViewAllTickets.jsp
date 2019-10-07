<%@page import="domain.Ticket"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.Movie"%> 
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Tickets</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>

	<table border ="1" width="500" align="center" class="table table-borderless table-dark centered"> 
	 <tr> 
	 
          <th><b>Ticket No</b></th> 
          <th><b>Movie Name</b></th> 
          <th><b>Customer Name</b></th> 
         </tr> 
		<%List<Ticket> std =  
	            (List<Ticket>)request.getAttribute("tickets");
	        if(std!=null)
	        for(Ticket s:std){%>
	            <tr> 
	                <td><%=s.getTicket_id()%></td> 
	                <td><%=s.getMovie().getName()%></td> 
	                <td><%=s.getCustomerName()%></td> 
	                <td><button  type="button" class="btn btn-success"
	                onclick="javascript:location.href='FrontServlet?command=ManagerViewTicket&ticketId=<%=s.getTicket_id()%>'">View</button></td>
	                <td><button  type="button" class="btn btn-warning"
	                onclick="javascript:location.href='FrontServlet?command=ManagerEditTicket&ticketId=<%=s.getTicket_id()%>'">Edit</button></td>
	                <td><button  type="button" class="btn btn-danger"
	                onclick="javascript:location.href='FrontServlet?command=ManagerDeleteTicket&ticketId=<%=s.getTicket_id()%>'"
	                >Delete</button></td>
	            </tr> 
	        <%}
	        %>
	</table>
	<div class="text-center">
	<button  type="button" class="btn btn-dark centered" 
	onclick="javascript:location.href='FrontServlet?command=ManagerHome'">Back</button>
	</div>
	<script src="js/bootstrap.js"></script>
</body>
</html>