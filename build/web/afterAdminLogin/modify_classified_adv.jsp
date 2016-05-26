<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div align="center" style="margin-top: 100px">
    <h3>Accessory Brand Record</h3>
</div>

<html:form action="modifyClassifiedAdv">
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
                            <td>Classified Image Id ::</td>
                            <td><input type="text" name="classified_image_id" value="<bean:write name="ClassifiedAdvBean" property="classified_image_id"/>"/></td>
                        </tr>
                        <tr>
                            <td>Classified Id ::</td>
                            <td><input type="text" name="classified_id" value="<bean:write name="ClassifiedAdvBean" property="classified_id"/>"/></td>
                        </tr>  
                        <tr>                           
                            <td>Classified Small Image ::</td>
                            <td><input type="text" name="classified_small_image" value="<bean:write name="ClassifiedAdvBean" property="classified_small_image"/>"/></td>
                        </tr>
                        <tr>
                            <td>Classified Large Image ::</td>
                            <td><input type="text" name="classified_large_image" value="<bean:write name="ClassifiedAdvBean" property="classified_large_image"/>"/></td>
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