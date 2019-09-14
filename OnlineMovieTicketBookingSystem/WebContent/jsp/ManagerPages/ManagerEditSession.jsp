<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="domain.Session"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Session</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%domain.Session session1 =  (domain.Session)request.getAttribute("sessioninfo");
System.out.println("test in frontend" + session1.getMovieId());
	        if(session1!=null){%>
<form action="FrontServlet?command=ManagerUpdateExistedSession" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Id</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieId" value="<%=session1.getMovieId()%>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Session Id</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionId" value="<%=session1.getSessionId()%>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Start Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionStartTime" value="<%=session1.getTimeRange().getStartTime()%>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">End Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionEndTime" value="<%=session1.getTimeRange().getEndTime()%>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Total Seats</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionTotalSeats" value="<%=session1.getSeats()%>">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Available Seats</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionAvailableSeats" value="<%=session1.getAvailableSeats()%>">
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