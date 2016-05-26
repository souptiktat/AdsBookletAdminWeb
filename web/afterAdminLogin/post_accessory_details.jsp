<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Post Accessory Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="PostAccessoryBean" name="PostAccessoryBean" property="listOfPostAccessory">
                <tr>
                    <td>
                        <bean:write name="PostAccessoryBean" property="accessory_adv_id"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_img_id"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_title"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_condition"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="accessry_brand_id"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="accessory_id"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_descript"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_typof_ad"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_price"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_xpect_price"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_posting_date"/>
                    </td>
                    <td>
                        <bean:write name="PostAccessoryBean" property="access_subcat_id"/>
                    </td>
                    <td>
                        <a href="deletePostAccessory.do?accessory_adv_id=<bean:write name="PostAccessoryBean" property="accessory_adv_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyPostAccessoryRecord.do?accessory_adv_id=<bean:write name="PostAccessoryBean" property="accessory_adv_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addPostAccessoryRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>