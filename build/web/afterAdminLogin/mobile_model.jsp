<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Mobile Model Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="MobiModelBean" name="MobiModelBean" property="listMobiModel">
                <tr>
                    <td>
                        <bean:write name="MobiModelBean" property="model_id"/>
                    </td>
                    <td>
                        <bean:write name="MobiModelBean" property="brand_id"/>
                    </td>      
                    <td>
                        <bean:write name="MobiModelBean" property="model_name"/>
                    </td>
                    <td>
                        <a href="deleteMobiModel.do?model_id=<bean:write name="MobiModelBean" property="model_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyMobiModelRecord.do?model_id=<bean:write name="MobiModelBean" property="model_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addMobiModelRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>