<%-- 
    Document   : fail_to_add_classified_adv
    Created on : May 13, 2016, 6:23:39 PM
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
        <%@include file="add_new_classified_adv.jsp" %>
    </body>
</html>
