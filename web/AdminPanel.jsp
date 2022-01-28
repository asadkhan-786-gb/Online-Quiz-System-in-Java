<%--Document : AdminPanel--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
<% if(session.getAttribute("username") !=null)
	{
	
	}
else
{
	String msg2 = "Please Login as Admin to Continue";
	response.sendRedirect("AdminLogin.jsp?msg2="+msg2);
}
	%>
<div height="250" width=100% style="background-color: yellow">
  <marquee behavior="alternate">
     <h1> <font  color ="green">Welcome   <%out.println(session.getAttribute("username")); %></font></h1>
  </marquee>
</div>
<center>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6"><center><input onclick="location.href='StudentList.jsp';" type="button" value="Add/Update Student" class="btn btn-outline-primary btn-lg btn-block"></center> </div>
      <div class="col-sm-6"><center><input onclick="location.href='InstructionList.jsp';" type="button" value="Add/Update Instructions" class="btn btn-outline-primary btn-lg btn-block"></center></div>
    </div>  
  </div>
  <pre>
  </pre>
   <div class="container-fluid">
    <div class="row">
      <div class="col-sm-6"><center><input onclick="location.href='QuestionList.jsp'"type="button" value="Add/Update Question" class="btn btn-outline-primary btn-lg btn-block"></center></div>
      <div class="col-sm-6"><center><input onclick="location.href='oes.controller.LogoutAdmin'"type="button" value="Logout" class="btn btn-outline-primary btn-lg btn-block"></center></div>
    </div>  
  </div>
  </center>
</body>
</html>


