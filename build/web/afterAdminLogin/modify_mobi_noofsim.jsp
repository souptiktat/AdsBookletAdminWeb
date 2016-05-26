<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Mobile No of Sim Record</h3>
</div>

<html:form action="modifyMobiNoofsim">
    <table bgcolor="#8ad0ff" align="center" width="800px">
        <tr>
            <td>
                <table border="0" align="center">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>                           
                            <td>No of sim Id ::</td>
                            <td><input type="text" name="noof_id" value="<bean:write name="MobiNoofsimBean" property="noof_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>No of sim Name ::</td>
                            <td><input type="text" name="noof_name" value="<bean:write name="MobiNoofsimBean" property="noof_name"/>"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><html:submit/></td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
    </table>
</html:form>