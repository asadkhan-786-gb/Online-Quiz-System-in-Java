<%--Document: updatestudentnow--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@page import="oes.model.StudentsDao"%>
<%@page import="oes.db.Students"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	
<title>Updating Students Info</title>
</head>
<body>
<%
		String newuserid = request.getParameter("uname");
        String newpassword = request.getParameter("pass");
        String newname = request.getParameter("name");
        String originaluid = request.getParameter("usernameoriginal");
		int status = StudentsDao.doUpdateNowRecord(originaluid,newuserid,newpassword,newname);
		if(status > 0)
		{ 
			response.sendRedirect("StudentList.jsp");
		}
		else if(status == -1)
		{
			
			out.print("error from databse");
			
		}
		else
		{
			out.print("excepion occured");
		}
		
	%>
</body>
</html>