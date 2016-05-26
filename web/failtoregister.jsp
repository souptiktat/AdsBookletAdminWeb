<%-- 
    Document   : failtoregister
    Created on : Dec 28, 2015, 4:23:43 PM
    Author     : Sneha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
    </head>
    <body>
        <h6><%= request.getAttribute("message") %></h6>
        <%@include file="register.jsp" %>
    </body>
</html>
