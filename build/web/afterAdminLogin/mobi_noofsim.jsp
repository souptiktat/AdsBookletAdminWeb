<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Mobile Sim Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="MobiNoofsimBean" name="MobiNoofsimBean" property="listOfMobiNoofsim">
                <tr>
                    <td>
                        <bean:write name="MobiNoofsimBean" property="noof_id"/>
                    </td>
                    <td>
                        <bean:write name="MobiNoofsimBean" property="noof_name"/>
                    </td>
                    <td>
                        <a href="deleteMobiNoofsim.do?noof_id=<bean:write name="MobiNoofsimBean" property="noof_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyMobiNoofsimRecord.do?noof_id=<bean:write name="MobiNoofsimBean" property="noof_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addMobiNoofsimRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>