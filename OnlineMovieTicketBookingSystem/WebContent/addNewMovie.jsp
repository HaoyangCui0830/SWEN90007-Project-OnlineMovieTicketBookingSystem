<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add a movie</title>
</head>
<body>
what movie do you want to add ?<br/>


<br/>
<form action="Movie!insertMovie.do" method="post">
Movie ID:  <input type="text" name = "movieId" placeholder="movie name"><br>
Movie Name:  <input type="text" name = "name" placeholder="movie name"><br>
Movie Length:  <input type="text" name = "length" placeholder="how many minutes"><br>
Movie Price:  <input type="text" name = "price" placeholder="how many dollars"><br>
<input type="submit" value="submit">

</form>>

</body>
</html>