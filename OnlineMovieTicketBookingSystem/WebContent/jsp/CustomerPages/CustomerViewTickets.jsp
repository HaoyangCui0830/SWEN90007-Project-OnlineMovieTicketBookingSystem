<%@page import="domain.Ticket"%>
<%@page import="domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.Movie"%> 
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View my tickets</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%
	List<Ticket> list = (List<Ticket>)request.getAttribute("tickets");
%>
	<table border ="1" width="500" align="center" class="table table-borderless table-dark centered"> 
	 <tr> 
          <th><b>Movie Name</b></th> 
          <th><b>Cinema</b></th> 
          <th><b>Start Time</b></th> 
          <th><b>End Time</b></th> 
          <th><b>Seats</b></th> 
         </tr>
         	<%if(list==null) {
         		out.print("sorry, you don't have any ticket");
         	}%> 
			<%
	        if(list!=null)
	        for(Ticket s: list){%>
	            <tr> 
	                <td><%=s.getMovie().getName()%></td> 
	                <td><%=s.getCinema().getName()%></td> 
	                <td><%=s.getSession().getTimeRange().getStartTime()%></td> 
	                <td><%=s.getSession().getTimeRange().getEndTime()%></td> 
					<td><%=s.getSeatNumber()%></td> 
	            </tr> 
	        <%}
	        %>
	</table>
	<div class="text-center">
	<button  type="button" class="btn btn-dark centered" 
	onclick="javascript:location.href='FrontServlet?command=CustomerHome'">Back</button>
	</div>
	<script src="js/bootstrap.js"></script>
</body>
</html>