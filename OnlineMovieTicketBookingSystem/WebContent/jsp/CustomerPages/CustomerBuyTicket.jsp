<%@page import="domain.User"%>
<%@page import="domain.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="domain.Session"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Buy tickets</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<%	User user = (User)request.getSession().getAttribute("user") ;
	//System.out.println(user);
domain.Session session1 =  (domain.Session)request.getAttribute("sessioninfo");
	Movie movie= new Movie();
	movie.setMovieId(session1.getMovieId());
System.out.println("test in frontend" + session1.getMovieId());
	        if(session1!=null){%>
<form action="FrontServlet?command=CustomerConfirmTicket" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Name</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieName" value="<%=movie.getName() %>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Id</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieId" value="<%=movie.getMovieId() %>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Session Id</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionId" value="<%=session1.getSessionId()%>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Start Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionStartTime" value="<%=session1.getTimeRange().getStartTime()%>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">End Time</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="sessionEndTime" value="<%=session1.getTimeRange().getEndTime()%>" readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Customer Name</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="CustomerName" value=<%=user.getUsername()%> readOnly="true">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Cinema</span>
  </div>
  <select id="cinema" name="cinema">
  <option value="1">Melbourne IMAX</option>
  <option value="2">Syndey IMAX</option>
  </select>
</div>

<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">number of tickets</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="ticketAmount" value="<%=1%>">
</div>

<div class="text-center">
	<button  type="button" class="btn btn-secondary centered" onclick="javascript:location.href='FrontServlet?command=CustomerHome'" >Back</button>
	<input type="submit" value="Confirm and buy" class="btn btn-success centered"></input>
	</div>
</form>
<%}
	  %>
</body>
</html>