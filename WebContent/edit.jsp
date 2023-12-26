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

User u =null;

u = new UserDao().getoneUser(id);

%>
<form action="update.jsp">
              <div>
                <input type="text"  name="id"  value=<%= u.getId() %> placeholder="Id" readonly="readonly" />
              </div>
              <div>
                <input type="text"  name="uname"  value=<%= u.getUname() %>  placeholder="Id" />
              </div>
              <div>
                <input type="text"  name="email"  value=<%= u.getEmail() %>  placeholder="Id" />
              </div>
              <div>
                <input type="text"  name="pass"  value=<%= u.getPass() %>  placeholder="Id" />
              </div>
            

              <div class="btn_box">
                <button>Update</button>
              </div>
            </form>


</body>
</html>