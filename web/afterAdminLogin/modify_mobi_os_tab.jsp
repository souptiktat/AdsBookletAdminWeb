<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Mobile OS Tab Record</h3>
</div>

<html:form action="modifyMobiOSTab">
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
                            <td>OS Tab Id ::</td>
                            <td><input type="text" name="os_id" value="<bean:write name="MobiOSTabBean" property="os_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>OS Tab Name ::</td>
                            <td><input type="text" name="os_name" value="<bean:write name="MobiOSTabBean" property="os_name"/>"/></td>
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