<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Mobile OS Tab Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="MobiOSTabBean" name="MobiOSTabBean" property="listOfMobiOSTab">
                <tr>
                    <td>
                        <bean:write name="MobiOSTabBean" property="os_id"/>
                    </td>
                    <td>
                        <bean:write name="MobiOSTabBean" property="os_name"/>
                    </td>                    
                    <td>
                        <a href="deleteMobiOSTab.do?os_id=<bean:write name="MobiOSTabBean" property="os_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyMobiOSTabRecord.do?os_id=<bean:write name="MobiOSTabBean" property="os_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addMobiOSTabRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>