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
Input movie ID to delete it?<br/>


<br/>
<form action="Movie!deleteMovie.do" method="post">
Movie ID:  <input type="movieId" name = "movieId" placeholder="movie name"><br>
<input type="submit" value="submit">

</form>>

</body>
</html>