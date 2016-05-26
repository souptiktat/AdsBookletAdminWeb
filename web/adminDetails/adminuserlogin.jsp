<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<h3 align="center" style="background-color: #8AD0FF">Admin Login</h3>
<div style="color:red">
    <% String msg = (String) request.getAttribute("msg1");
        if (msg != null || msg == " ") {
            out.println(msg);
        }
    %>
</div>
<html:form action="adminuserlogin">
    <table align="center">
        <tr>
            <td><b>Admin Login:</b></td>
            <td><html:text property="username" /></td>
            <td><html:errors property="username" /></td>


        </tr>
        <tr>
            <td><b>Admin Password:</b></td>
            <td><html:password property="password" /></td>
            <td><html:errors property="password" /></td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/>
                <html:reset/></td>
        </tr>
        
    </table>
</html:form>
<div>
    <center><a href="forgotpasswordLink.do" style="text-decoration: none">Forgot Password</a></center>
</div>
