<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div align="center" style="margin-top: 100px">
    <h3>Add New Data of Accessory Type Record</h3>
</div>

<html:form action="addAccessoryType">
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
                            
                            <td>Accessory Id ::</td>
                            <td><html:text property="accessory_id" /></td>
                        </tr>
                        <tr>
                            <td>Accessory Name ::</td>
                            <td><html:text property="accessory_name"/></td>
                        </tr>
                        <tr>
                            <td>Accessory Posting Date ::</td>
                            <td><html:text property="access_posting_date"/></td>  
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
