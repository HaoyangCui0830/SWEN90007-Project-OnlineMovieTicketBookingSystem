<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.Movie"%> 
<%@page import="domain.ThreeDMovie"%> 
<%@page import="domain.Session"%> 
<%@page import="domain.Cinema"%> 
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Single Movie Info</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<%Movie movie =  
	            (Movie)request.getAttribute("movie");
	        if(movie!=null){%>
	        <div class="text-center">
	        <ul class="list-group">
			  <li class="list-group-item disabled">Movie: ${movie.getName()}</li>
			  <li class="list-group-item">Length: ${movie.getLength()}</li>
			  <li class="list-group-item">Price: ${movie.getPrice()}</li>
			</ul>
			</div>
	        <%}
	  %>
	  
	  
	  <table border ="1" width="500" align="center" class="table table-borderless table-dark centered"> 
		 <tr> 
		 	  <th><b>Session No.</b></th> 
	          <th><b>Start time</b></th> 
	          <th><b>End time</b></th> 
	          <th><b>Total Seat</b></th> 
	          <th><b>Available Seat</b></th> 
	         </tr> 
			<%List<Session> sessions =  
		            (List<Session>)request.getAttribute("session");
		        if(sessions!=null)
		        for(Session s:sessions){%>
		            <tr> 
		            	<td><%=s.getSessionId()%></td> 
		                <td><%=s.getTimeRange().getStartTime()%></td> 
		                <td><%=s.getTimeRange().getEndTime()%></td> 
		                <td><%=s.getSeats()%></td> 
		                <td><%=s.getAvailableSeats()%></td>
		                <td><button  type="button" class="btn btn-warning"
		                onclick="javascript:location.href='FrontServlet?command=ManagerEditSession&sessionId=<%=s.getSessionId()%>'">Edit</button></td>
		                <td><button  type="button" class="btn btn-danger"
		                onclick="javascript:location.href='FrontServlet?command=ManagerDeleteSession&sessionId=<%=s.getSessionId()%>'"
		                >Delete</button></td>
		            </tr> 
		        <%}
		        %>
		</table>
	  
	  
	  <%ThreeDMovie threeDmovie =  
	            (ThreeDMovie)request.getAttribute("threeDMovie");
	        if(threeDmovie.getHasFreeGlasses()!=null){%>
	        <div class="text-center">
	        <ul class="list-group">
			  <li class="list-group-item">This is a 3D Movie</li>
			  <li class="list-group-item">With 3D Glasses: <%=threeDmovie.getHasFreeGlasses()%></li>
			</ul>
			</div>
	        <%}
	  %>
	  
	  <table border ="1" width="500" align="center" class="table table-borderless table-dark centered"> 
		 <tr> 
		 	  <th class="text-center"><b class="text-center">On Showing Cinema</b></th> 
	         </tr> 
			<%List<Cinema> cinemas =  
		            (List<Cinema>)request.getAttribute("cinema");
		        if(cinemas!=null)
		        for(Cinema s:cinemas){%>
		            <tr> 
		            	<td class="text-center"><%=s.getName()%></td> 
		            </tr> 
		        <%}
		        %>
		</table>
	  
	  
	  <div class="text-center">
	  <button  type="button" class="btn btn-dark centered" 
	onclick="javascript:location.href='FrontServlet?command=ManagerViewAllMovies'">Back</button>
	</div>
	<script src="js/bootstrap.js"></script>
</body>
</html>