<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Post Accessory Record</h3>
</div>

<html:form action="modifyPostAccessory">
    <table bgcolor="#8ad0ff" align="center" width="800px">
        <tr>
            <td>
                <table border="0" align="center">
                    <thead>
                        <tr>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>                           
                            <td>Accessory Advertisement Id ::</td>
                            <td><input type="text" name="accessory_adv_id" value="<bean:write name="PostAccessoryBean" property="accessory_adv_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Image Id ::</td>
                            <td><input type="text" name="access_img_id" value="<bean:write name="PostAccessoryBean" property="access_img_id"/>"/></td>
                        </tr>          
                        <tr>
                            <td>Accessory Title ::</td>
                            <td><input type="text" name="access_title" value="<bean:write name="PostAccessoryBean" property="access_title"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Condition ::</td>
                            <td><input type="text" name="access_condition" value="<bean:write name="PostAccessoryBean" property="access_condition"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Brand Id ::</td>
                            <td><input type="text" name="accessry_brand_id" value="<bean:write name="PostAccessoryBean" property="accessry_brand_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Id ::</td>
                            <td><input type="text" name="accessory_id" value="<bean:write name="PostAccessoryBean" property="accessory_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Description ::</td>
                            <td><input type="text" name="access_descript" value="<bean:write name="PostAccessoryBean" property="access_descript"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Type of Advertisement ::</td>
                            <td><input type="text" name="access_typof_ad" value="<bean:write name="PostAccessoryBean" property="access_typof_ad"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Price ::</td>
                            <td><input type="text" name="access_price" value="<bean:write name="PostAccessoryBean" property="access_price"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Expected Price ::</td>
                            <td><input type="text" name="access_xpect_price" value="<bean:write name="PostAccessoryBean" property="access_xpect_price"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Posting Date ::</td>
                            <td><input type="text" name="access_posting_date" value="<bean:write name="PostAccessoryBean" property="access_posting_date"/>"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Sub-Category Id ::</td>
                            <td><input type="text" name="access_subcat_id" value="<bean:write name="PostAccessoryBean" property="access_subcat_id"/>"/></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><html:submit/></td>
                        </tr>
                    </tbody>
                </table>
            </td>
        </tr>
    </table>
</html:form>
