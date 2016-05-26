<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Classified Sub Category Record</h3>
</div>

<html:form action="modifyClassifiedSubCat">
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
                            <td>Classified Sub Category Id ::</td>
                            <td><input type="text" name="classified_sub_category_id" value="<bean:write name="ClassifiedSubCategoryBean" property="classified_sub_category_id"/>"/></td>
                        </tr>
                        <tr>                           
                            <td>Classified Category Id ::</td>
                            <td><input type="text" name="classified_category_id" value="<bean:write name="ClassifiedSubCategoryBean" property="classified_category_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Classified Sub Category Name ::</td>
                            <td><input type="text" name="classified_sub_category_name" value="<bean:write name="ClassifiedSubCategoryBean" property="classified_sub_category_name"/>"/></td>
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