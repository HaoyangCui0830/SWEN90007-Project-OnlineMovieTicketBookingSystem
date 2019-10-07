<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Movie Ticket Booking</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
	  <a class="navbar-brand" href="javascript:location.href='FrontServlet?command=CustomerHome'">Online Movie Ticket Booking System</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarText">
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=CustomerViewAllMovies'">View Movies<span class="sr-only">(current)</span></a>
	      </li>
	    </ul>
	    
	    <ul class="navbar-nav mr-auto">
	      <li class="nav-item active">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=CustomerViewTickets'">View my ticket<span class="sr-only">(current)</span></a>
	      </li>
	    </ul>
	    <span class="navbar-text">
	      Welcome: ${user.lastNameString}
	      <a href="FrontServlet?command=Logout">Log out</a>
	    </span>
	  </div>
	</nav>
	
	<script src="js/bootstrap.js"></script>
</body>
</html>