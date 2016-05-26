<%-- 
    Document   : forward
    Created on : 21 Dec, 2015, 4:42:39 PM
    Author     : Sunit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= request.getAttribute("message") %></h1>
    </body>
</html>
