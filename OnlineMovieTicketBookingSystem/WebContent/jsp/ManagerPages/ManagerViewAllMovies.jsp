<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.Movie"%> 
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Movies</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>

	<table border ="1" width="500" align="center" class="table table-borderless table-dark centered"> 
	 <tr> 
          <th><b>Movie Name</b></th> 
          <th><b>Moive Length</b></th> 
          <th><b>Movie Price</b></th> 
         </tr> 
		<%List<Movie> std =  
	            (List<Movie>)request.getAttribute("movies");
	        if(std!=null)
	        for(Movie s:std){%>
	            <tr> 
	                <td><%=s.getName()%></td> 
	                <td><%=s.getLength()%></td> 
	                <td><%=s.getPrice()%></td> 
	                <td><button  type="button" class="btn btn-success"
	                onclick="javascript:location.href='FrontServlet?command=ManagerViewMovie&movieId=<%=s.getMovieId()%>'">View</button></td>
	                <td><button  type="button" class="btn btn-warning"
	                onclick="javascript:location.href='FrontServlet?command=ManagerEditMovie&movieId=<%=s.getMovieId()%>'">Edit</button></td>
	                <td><button  type="button" class="btn btn-danger"
	                onclick="javascript:location.href='FrontServlet?command=ManagerDeleteMovie&movieId=<%=s.getMovieId()%>'"
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