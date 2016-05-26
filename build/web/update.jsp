<%-- 
    Document   : update
    Created on : 16 Nov, 2015, 6:37:56 PM
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
        <jsp:useBean id="classifiedIndiaFormBean" class="com.classifiedindia.formbean.ClassifiedIndiaFormBean" scope="session"/>

        <h1><%=classifiedIndiaFormBean.getClassifiedSubCategory()%></h1>
    </body>
</html>
