<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div align="center" style="margin-top: 100px">
    <h3>Add New Data of Post Accessory Record</h3>
</div>

<html:form action="addPostAccessoryInfo">
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
                            <td><html:text property="accessory_adv_id" /></td>
                        </tr>
                        <tr>
                            <td>Accessory Image Id ::</td>
                            <td><html:text property="access_img_id"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Title ::</td>
                            <td><html:text property="access_title"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Condition ::</td>
                            <td><html:text property="access_condition"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Brand Id ::</td>
                            <td><html:text property="accessry_brand_id"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Id ::</td>
                            <td><html:text property="accessory_id"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Description ::</td>
                            <td><html:text property="access_descript"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Type of Advertisement ::</td>
                            <td><html:text property="access_typof_ad"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Price ::</td>
                            <td><html:text property="access_price"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Expected Price ::</td>
                            <td><html:text property="access_xpect_price"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Posting Date ::</td>
                            <td><html:text property="access_posting_date"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Sub-Category Id ::</td>
                            <td><html:text property="access_subcat_id"/></td>
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
