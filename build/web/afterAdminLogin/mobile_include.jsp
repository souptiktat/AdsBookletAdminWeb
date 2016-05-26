<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Mobile Include Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="MobiIncludeBean" name="MobiIncludeBean" property="listOfMobiIncludes">
                <tr>
                    <td>
                        <bean:write name="MobiIncludeBean" property="includ_tab_id"/>
                    </td>
                    <td>
                        <bean:write name="MobiIncludeBean" property="mobile_adv_id"/>
                    </td>      
                    <td>
                        <bean:write name="MobiIncludeBean" property="includ_id"/>
                    </td>
                    <td>
                        <a href="deleteMobiInclude.do?includ_tab_id=<bean:write name="MobiIncludeBean" property="includ_tab_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyMobiIncludeRecord.do?includ_tab_id=<bean:write name="MobiIncludeBean" property="includ_tab_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addMobiIncludeRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>