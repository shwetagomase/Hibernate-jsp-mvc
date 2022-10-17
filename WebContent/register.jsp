<%@page import="controller.StudentDao"%>
<%@page import="model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name=request.getParameter("name");
String course=request.getParameter("course");

Student s=new Student(name, course);
boolean x=new StudentDao().insert(s);
if(x)
{
	out.print("inserted");
	
}
else
{
	out.print("not inserted");
}

%>
</body>
</html>