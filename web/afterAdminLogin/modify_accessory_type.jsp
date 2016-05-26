<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Accessory Type Record</h3>
</div>

<html:form action="modifyAccessoryTypeRecord">
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
                            <td>Accessory Id ::</td>
                            <td><input type="text" name="accessory_id" value="<bean:write name="AccessoryTypeBean" property="accessory_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Name ::</td>
                            <td><input type="text" name="accessory_name" value="<bean:write name="AccessoryTypeBean" property="accessory_name"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Posting Date ::</td>
                            <td><input type="text" name="access_posting_date" value="<bean:write name="AccessoryTypeBean" property="access_posting_date"/>"/></td>
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