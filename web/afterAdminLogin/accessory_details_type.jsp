<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Accessory Type Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="AccessoryTypeBean" name="AccessoryTypeBean" property="listOfAccessoryType">
                <tr>
                    <td>
                        <bean:write name="AccessoryTypeBean" property="accessory_id"/>
                    </td>
                    <td>
                        <bean:write name="AccessoryTypeBean" property="accessory_name"/>
                    </td>
                    <td>
                        <bean:write name="AccessoryTypeBean" property="access_posting_date"/>
                    </td>
                    
                    <td>
                        <a href="deleteAccessoryRecord.do?accessory_id=<bean:write name="AccessoryTypeBean" property="accessory_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyAccessoryRecord.do?accessory_id=<bean:write name="AccessoryTypeBean" property="accessory_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addAccessoryTypeRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>