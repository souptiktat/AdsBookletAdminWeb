<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div align="center" style="margin-top: 100px">
    <h3>Add New Data of Accessory Brand Record</h3>
</div>

<html:form action="addAccessoryBrand">
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
                            
                            <td>Accessory Brand Id ::</td>
                            <td><html:text property="accessry_brand_id" /></td>
                        </tr>
                        <tr>
                            <td>Accessory Brand Name ::</td>
                            <td><html:text property="accessoty_brand_name"/></td>
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
