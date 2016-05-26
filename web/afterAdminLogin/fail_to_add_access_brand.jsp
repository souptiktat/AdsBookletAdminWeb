<%-- 
    Document   : fail_to_add_access_brand
    Created on : May 12, 2016, 6:55:43 PM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h6><%= request.getAttribute("message") %></h6>
        <%@include file="add_new_accessory_brand.jsp" %>
    </body>
</html>
