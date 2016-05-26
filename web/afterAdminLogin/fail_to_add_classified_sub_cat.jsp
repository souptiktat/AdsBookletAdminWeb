<%-- 
    Document   : fail_to_add_classified_sub_cat
    Created on : May 16, 2016, 5:19:10 PM
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
        <%@include file="add_new_classified_sub_cat.jsp" %>
    </body>
</html>