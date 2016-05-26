<%@taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="tiles" uri="http://struts.apache.org/tags-tiles" %>

<h3 align="center" style="background-color: #8AD0FF">Admin Forgot Password</h3>
<div style="color:red">
    <% String msg = (String) request.getAttribute("msg2");
        if (msg != null || msg == " ") {
            out.println(msg);
        }
    %>
</div>


<!--<script language="JavaScript1.1" type="text/javascript">

    function clearForm() {
        document.forms["AdminForgotPasswordForm"].elements["admin_login.username"].value = "";
        document.forms["AdminForgotPasswordForm"].elements["admin_login.password"].value ="";                
        document.forms["AdminForgotPasswordForm"].elements["admin_login.cpassword"].value = "";  
               
        document.personForm.elements["btnAddresses"].disabled = true;
        document.personForm.elements["btnMobilePhones"].disabled = true;
        document.personForm.elements["btnInsert"].disabled = false;
        document.personForm.elements["btnUpdate"].disabled = true;
        document.personForm.elements["btnDelete"].disabled = true;
    }

</script>-->
<html:form action="adminpassword">
    <table align="center">
        <tr>
            <td><b>Admin Login :</b></td>
            <td><html:text property="username" /></td>
            <td><html:errors property="username" /></td>

        </tr>
        <tr>
            <td><b>Admin Password:</b></td>
            <td><html:password property="password" /></td>
            <td><html:errors property="password" /></td>
        </tr>

        <tr>
            <td><b>Confirm Password:</b></td>
            <td><html:password property="cpassword"/></td>
            <td><html:errors property="cpassword" /></td>
        </tr>
        <tr>
            <td></td>
            <td><html:submit/>
                <html:reset onclick="clearForm()"/></td>
        </tr>
    </table>
</html:form>
