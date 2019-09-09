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
<form action="ManagerAddMovieServlet" method="get">
Movie Name:  <input type="text" name = "movieName" placeholder="movie name"><br>
Movie Length:  <input type="length" name = "movieLength" placeholder="how many minutes"><br>
Movie Price:  <input type="price" name = "moviePrice" placeholder="how many dollars"><br>
<input type="submit" value="submit">

</form>>

</body>
</html>