<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Mobile Brand Record</h3>
</div>

<html:form action="modifyMobiInclude">
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
                            <td>Mobile Include Tab Id ::</td>
                            <td><input type="text" name="includ_tab_id" value="<bean:write name="MobiIncludeBean" property="includ_tab_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Mobile Advance Id ::</td>
                            <td><input type="text" name="mobile_adv_id" value="<bean:write name="MobiIncludeBean" property="mobile_adv_id"/>"/></td>
                        </tr>          
                        <tr>
                            <td>Mobile Include Id ::</td>
                            <td><input type="text" name="includ_id" value="<bean:write name="MobiIncludeBean" property="includ_id"/>"/></td>
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
