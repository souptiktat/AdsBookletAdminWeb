<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Classified Category Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="ClassifiedAdvBean" name="ClassifiedAdvBean" property="listOfClassifiedAdv">
                <tr>
                    <td>
                        <bean:write name="ClassifiedAdvBean" property="classified_image_id"/>
                    </td>
                    <td>
                        <bean:write name="ClassifiedAdvBean" property="classified_id"/>
                    </td>    
                    <td>
                        <bean:write name="ClassifiedAdvBean" property="classified_small_image"/>
                    </td>
                    <td>
                        <bean:write name="ClassifiedAdvBean" property="classified_large_image"/>
                    </td>   
                    <td>
                        <a href="deleteClassifiedAdvRecord.do?classified_image_id=<bean:write name="ClassifiedAdvBean" property="classified_image_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyClassifiedAdvRecord.do?classified_image_id=<bean:write name="ClassifiedAdvBean" property="classified_image_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addClassifiedAdv.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>