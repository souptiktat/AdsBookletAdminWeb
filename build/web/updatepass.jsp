<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html:form action="updatepass">
            <h2 align="center">update password!!</h2>
            <table align="center">
<tr>
            <td>Enter New Password:</td>
            <td><html:password property="newpassword" styleId="password1" style="width: 200px"/></td><td><html:errors property="password1"/></td>
            <td><html:errors property="newpassword" /></td>
           </tr>
            <tr></tr>
            <tr></tr>
            <tr>
            <td>Confirm Password:</td>
            <td><html:password property="confirmpassword" styleId="password2" style="width: 200px"/></td><td><html:errors property="password2"/></td>

</tr>

</table>
<table align="center">
                <tr>
                    <td><html:submit/></td>
                </tr>
</table>
</html:form>

