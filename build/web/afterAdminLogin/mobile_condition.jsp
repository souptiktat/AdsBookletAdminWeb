<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Mobile Condition Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="MobiConditionBean" name="MobiConditionBean" property="listOfMobileCond">
                <tr>
                    <td>
                        <bean:write name="MobiConditionBean" property="cond_id"/>
                    </td>
                    <td>
                        <bean:write name="MobiConditionBean" property="cond_name"/>
                    </td>                    
                    <td>
                        <a href="deleteMobiCondition.do?cond_id=<bean:write name="MobiConditionBean" property="cond_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyMobileCondRecord.do?cond_id=<bean:write name="MobiConditionBean" property="cond_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addMobileCondition.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>