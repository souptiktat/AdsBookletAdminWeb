<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html>
<head>
<title><bean:message key="welcome.title"/></title>
<html:base/>
</head>

<body bgcolor="white">

<p align="center"><font size="3" color="red">Sorry your UserId/Password is incurrect</font></p>
<center><p><html:link page="/login.do"><font size="3" color="blue">Retry click here!</font></html:link></p></center>
</body>
</html:html>