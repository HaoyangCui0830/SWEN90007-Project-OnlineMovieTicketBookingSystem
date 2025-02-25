<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="domain.Movie"%> 
    <%@page import="domain.Cinema"%> 
    <%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Movie</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%Movie movie =  
	            (Movie)request.getAttribute("movie");
	        if(movie!=null){%>
<form action="FrontServlet?command=ManagerUpdateExistedMovie" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">MovieId</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieId" value="${movie.getMovieId()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Name</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieName" value="${movie.getName()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Length</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieLength" value="${movie.getLength()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Price</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="moviePrice" value="${movie.getPrice()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">isThreeD</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="isThreeD" value="">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">withFreeGlasses</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="withFreeGlasses" value="">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Show in Melbourne</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="showInMelbourne" value="">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Show in Sydney</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="showInSydney" value="">
</div>
<div class="text-center">
	<button  type="button" class="btn btn-secondary centered" onclick="javascript:location.href='FrontServlet?command=ManagerHome'" >Back</button>
	<input type="submit" value="Submit" class="btn btn-success centered"></input>
	</div>
</form>
<%}
	  %>


</body>
</html>