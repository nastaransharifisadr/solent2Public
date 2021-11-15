<%-- 
    Document   : jspexample2
    Created on : 22-Jul-2021, 11:16:28
    Author     : admin
    THIS EXAMPLE SHOWS HOW OBJECTS CAN BE STORED IN THE SESSION OBJECT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%
    // retrieve the stored users list from the session
    List<String> users = (List<String>) session.getAttribute("users");
    if (users == null) {
        users = new ArrayList<String>();
        session.setAttribute("users", users);
    }

    String name = request.getParameter("userName");

    // find what action to perform on the page
    String action = request.getParameter("action");

    if ("removeUser".equals(action)) {
        users.remove(name);
    } else if ("addUser".equals(action)) {
        users.add(name);
    }

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Example 3b</title>
    </head>
    <body>
        <h1>JSP Example 3b: User table</h1>

        <h2>user list</h2>
        <% for (String user : users) {%>
        
        <p><%=user%></p>
        <form action="./jspexample3.jsp" method="get">
            <input type="hidden" name="userName" value="<%=user%>">
            <button type="submit" name="action" value="removeUser" >remove name from list</button>
        </form> 
        <%
            }
        %>
        <h2>commands</h2>
        <form action="./jspexample3.jsp" method="get">
            <p>user name <input type="text" name="userName" value=""></p>
            <button type="submit" name="action" value="addUser" >add name to list</button>
        </form> 
        <br>
        
        <a href="./" >back to index page</a>
    </body>
</html>