<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h6><%= request.getAttribute("message") %></h6>
        <%@include file="add_new_mobi_os_tab.jsp" %>
    </body>
</html>