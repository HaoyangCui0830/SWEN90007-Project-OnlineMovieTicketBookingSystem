<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="servlet.ManagerViewMovieServlet"%> 
<%@page import="domain.Movie"%> 
<%@page import="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Movie Ticket Booking</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
	
	<table border ="1" width="500" align="center"> 
         <tr bgcolor="00FF7F"> 
          <th><b>Movie Name</b></th> 
          <th><b>Moive Length</b></th> 
          <th><b>Movie Price</b></th> 
         </tr> 
        
        <%List<Movie> std =  
            (List<Movie>)request.getAttribute("movies");
        if(std!=null)
        for(Movie s:std){%>
            <tr> 
                <td><%=s.getName()%></td> 
                <td><%=s.getLength()%></td> 
                <td><%=s.getPrice()%></td> 
            </tr> 
            
        <%}
        %>
             
        </table>  
<button onclick="javascript:location.href='ManagerViewMovieServlet'" type="button" class="btn btn-info" style="
	            width: 30%;margin: 20% 35% 0 35%;height: 60px;"><i class="iconfont">&#xe601;</i>&nbsp;View all the Movies!</button>
	<script src="js/bootstrap.js"></script>
</body>
</html>