<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Welcome</title>
</head>
<body>
    <h2>Welcome</h2>
    <% 
        // Retrieve session attribute
        String username = (String) session.getAttribute("username");
        if (username != null) {
    %>
            <p>Welcome, <%= username %>!</p>
    <% 
        } else {
    %>
            <p>No user logged in.</p>
    <% 
        }
    %>
</body>
</html>
