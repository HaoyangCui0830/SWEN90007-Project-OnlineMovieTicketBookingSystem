<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="domain.Movie"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%Movie movie =  
	            (Movie)request.getAttribute("movie");
	        if(movie!=null){%>
<form action="FrontServlet?command=ManagerSubmitNewSession" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Id</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieId" value="${movie.getMovieId()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Start Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionStartTime" value="${s.getTimeRange().getStartTime()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">End Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionEndTime" value="${s.getTimeRange().getEndTime()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Total Seats</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionTotalSeats" value="${s.getSeats()}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Available Seats</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionAvailableSeats" value="${s.getAvailableSeats()}">
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