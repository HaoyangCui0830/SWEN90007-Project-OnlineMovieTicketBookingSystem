<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.Movie"%> 
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
	  
	  <div class="text-center">
	  <button  type="button" class="btn btn-dark centered" 
	onclick="javascript:location.href='FrontServlet?command=CustomerViewAllMovies'">Back</button>
	</div>
	<script src="js/bootstrap.js"></script>
</body>
</html>