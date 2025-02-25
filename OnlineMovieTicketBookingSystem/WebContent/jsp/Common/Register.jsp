<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
<% String msg = (String)request.getAttribute("msg");
	if(msg!=null){
		out.print(msg);
	}

%>
<form action="FrontServlet?command=Register" method="POST">
<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">UserName</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="username">
</div>

<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Password</span>
  </div>
  <input type="password" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="password" >
</div>

<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">Confirm Password</span>
  </div>
  <input type="password" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="password2" >
</div>

<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">FirstName</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="firstName">
</div>

<div class="input-group input-group-lg">
  <div class="input-group-prepend">
    <span class="input-group-text" id="inputGroup-sizing-lg">LastName</span>
  </div>
  <input type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" name="lastName">
</div>

<div class="text-center">
	<button  type="button" class="btn btn-secondary centered" onclick="javascript:location.href='FrontServlet?command=ToHomePage'" >back</button>
	<input type="submit" value="submit" class="btn btn-success centered"></input>
	</div>
</form>

</body>
</html>