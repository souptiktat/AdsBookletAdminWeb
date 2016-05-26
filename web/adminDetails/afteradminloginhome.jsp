<%@page import="java.io.*"%>
<%@page import="java.sql.*"%>
<%@page import="javax.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.naming.*"%>
<%@page import="javax.servlet.*"%>

<%
//getting value
String username=request.getParameter("username");
String password=request.getParameter("password");
//String usertype=request.getParameter("usertype");
%>

<html>
<head>
<title>Success</title>
</head>
<body>
    <p><b> Hi ! <%=username%></b><p>
<p align="center"><font size="3" color="#000080"><b>You Are Successfully Logged in !</b> <font color="red"></font></font></p>
<p align="center"><b>Click <a style="text-decoration: none" href="/adminuserlogin.do">here</a> to logout</b></p>
</body>
</html>