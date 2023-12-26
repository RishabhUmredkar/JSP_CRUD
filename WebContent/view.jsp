<%@page import="java.util.List"%>
<%@page import="Dao.UserDao"%>
<%@page import="Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Users</title>
</head>
<body>
    <% 
        UserDao ud = new UserDao();
        List<User> userList = ud.getallUser();
    %>

    <table border="1">
        <thead>
            <tr>
                <td>User ID</td>
                <td>UserName</td>
                <td>Email</td>
                <td>Password</td>
                <td>Action</td>
            </tr>
        </thead>
        <tbody>
            <% if (userList != null && !userList.isEmpty()) {
                for (User user : userList) {
            %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getUname() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getPass() %></td>
                        <td>
                            <a href="edit.jsp?id=<%= user.getId() %>">Edit</a>
                            <a href="delete.jsp?id=<%= user.getId() %>">Delete</a>
                        </td>
                    </tr>
            <%
                }
            } else {
            %>
                <tr>
                    <td colspan="5">No users found.</td>
                </tr>
            <%
            }
            %>
        </tbody>
    </table>
</body>
</html>
