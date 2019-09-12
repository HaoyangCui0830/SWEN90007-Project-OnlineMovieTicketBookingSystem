<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Movie</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<form action="FrontServlet?command=ManagerSubmitNewMovie" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Name</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieName" value="${movie.movieName}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Movie Length</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="movieLength" value="${movie.movieLength}">
</div>
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Price</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="moviePrice" value="${movie.moviePrice}">
</div>

<div class="text-center">
	<button  type="button" class="btn btn-secondary centered" onclick="javascript:location.href='FrontServlet?command=ManagerHome'" >Back</button>
	<input type="submit" value="Submit" class="btn btn-success centered"></input>
	</div>
</form>
</body>
</html>