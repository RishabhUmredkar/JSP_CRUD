<%@page import="Dao.UserDao"%>
<%@page import="Model.User"%>
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
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("uname");
String email = request.getParameter("email");
String pass = request.getParameter("pass");

User u = new User(id,name, email, pass);

int a = new UserDao().delete(id);

if(a>0){
	response.sendRedirect("view.jsp");
}else{
	response.sendRedirect("view.jsp");
}
%>

</body>
</html>