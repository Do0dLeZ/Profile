<%@ page import="servlets.LoginServlet" %><%--
  Created by IntelliJ IDEA.
  User: kolom
  Date: 28.09.2017
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
    <% String user = (String) session.getAttribute("user_login");%>
    <% if (user == null || user.isEmpty()) { %>
        <form action="/login" method="post">
            <input type="text" name="login" placeholder="Enter login..."><br/>
            <input type="password" name="password" placeholder="Enter password..."><br/>
            <input type="submit" value="Login">
        </form>
    <%} else {%>
        <form action="/login?login=<%= user%>" method="get"></form>
    <%}%>
    <% if (LoginServlet.access.equals("denied")){%>
        Wrong password. Try again.
    <%}%>
</body>
</html>
