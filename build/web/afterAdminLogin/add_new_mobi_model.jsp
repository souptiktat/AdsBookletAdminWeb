<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<div align="center" style="margin-top: 100px">
    <h3>Add New Data of Mobile Model</h3>
</div>

<html:form action="addMobiModelInfo">
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
                            <td>Mobile Model Id ::</td>
                            <td><html:text property="model_id" /></td>
                        </tr>
                        <tr>
                            <td>Mobile Brand Id ::</td>
                            <td><html:text property="brand_id"/></td>
                        </tr>
                        <tr>
                            <td>Mobile Model Name ::</td>
                            <td><html:text property="model_name"/></td>
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