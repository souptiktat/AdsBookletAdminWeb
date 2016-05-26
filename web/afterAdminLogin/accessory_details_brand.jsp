<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<body bgcolor="#8ad0ff">
    <div align="center">
        <h4>All Accessory Brand Details</h4>
        <table border="1" cellpadding="2" cellspacing="2" width="100%">
            <logic:iterate id="AccessoryBrandBean" name="AccessoryBrandBean" property="listOfAccessoryBrand">
                <tr>
                    <td>
                        <bean:write name="AccessoryBrandBean" property="accessry_brand_id"/>
                    </td>
                    <td>
                        <bean:write name="AccessoryBrandBean" property="accessoty_brand_name"/>
                    </td>                    
                    <td>
                        <a href="deleteAccessoryBrandRecord.do?accessry_brand_id=<bean:write name="AccessoryBrandBean" property="accessry_brand_id" /> " onclick="return confirm('Are you sure to delete ?')">Delete</a>
                    </td>
                    <td>
                        <a href="modifyAccessoryBrandRecord.do?accessry_brand_id=<bean:write name="AccessoryBrandBean" property="accessry_brand_id"/> " onclick="return confirm('Are you sure to modify the existing data ?')">Modify</a>
                    </td>
                </tr>
            </logic:iterate>
        </table>
        <h4><a href="addAccessoryBrandRecord.do" onclick="return confirm('Are you sure to add data in the database?')">Add New Rows..</a></h4> 
    </div>
</body>