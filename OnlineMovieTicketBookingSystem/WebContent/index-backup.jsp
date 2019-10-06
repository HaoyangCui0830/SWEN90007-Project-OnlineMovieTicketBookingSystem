<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Movie Ticket Booking</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">Online Movie Ticket Booking System</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavDropdown">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=Login'">Login</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" onclick="javascript:location.href='FrontServlet?command=ManagerHome'">Login as Cinema Manager</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link"onclick="javascript:location.href='FrontServlet?command=CustomerHome'">Login as Customer</a>
	      </li>
	    </ul>
	  </div>
	</nav>
	<img src="img/cinema_image.jpg" class="img-rounded" alt="Cinque Terre" style="width:100%; opacity: 0.6;">
	
	<script src="js/bootstrap.js"></script>
</body>
</html>