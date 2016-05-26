<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Classified Category Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="ClassifiedCategoryBean" name="ClassifiedCategoryBean" property="listOfClassifiedCategory">
                <tr>
                    <td>
                        <bean:write name="ClassifiedCategoryBean" property="classified_category_id"/>
                    </td>
                    <td>
                        <bean:write name="ClassifiedCategoryBean" property="classified_category_name"/>
                    </td>                    
                    <td>
                        <a href="deleteClassifiedCategoryRecord.do?classified_category_id=<bean:write name="ClassifiedCategoryBean" property="classified_category_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyClassifiedCategoryRecord.do?classified_category_id=<bean:write name="ClassifiedCategoryBean" property="classified_category_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addClassifiedCategoryRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>