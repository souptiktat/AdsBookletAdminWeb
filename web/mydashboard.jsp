<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Idea View</title>

    </head>
    <body>
    <center>
        <h4 style="color: rosybrown">My Dashboard</h4>
    </center>

    <logic:iterate id="myList" name="classifiedIndiaFormBean" property="mydashList">
        <p style="float: right">Ad Posting Date:<bean:write name="myList" property="classifiedPostingDate"></bean:write></p>

            <table>
                <tr>
                    <td>
                        Ads Id:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedId"></bean:write>
                    </td>
                <tr>
                    <td>
                        Category Name:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedCategoryName"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Sub-Category Name:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedSubCategoryName"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Subject:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedSubject"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Person to Contact:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedContactPerson"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Contact mail:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedEmailId"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Contact No.:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedPrimaryContact"></bean:write><br>
                    <bean:write name="myList" property="classifiedSecondaryContact"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Company Website:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedWebUrl"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Ad Expire Date:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedExpireDate"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Ad Expire-warning Date:
                    </td>
                    <td>
                    <bean:write name="myList" property="classifiedExpireWarrningDate"></bean:write>
                    </td>
                </tr>
                <tr>
                    <td>
                        Image:
                    </td>
                    <td>
                        <img alt="myboard" src="myhome/<bean:write name="myList" property="classifiedImageId"/>.jpg" style="width: 200px; height: 150px">
                </td>
                <bean:write name="myList" property="classifiedImageId"/>
        </table>
        <p><a href="mydashedit.do?adsid=<bean:write name="myList" property="classifiedId"></bean:write>" style="text-decoration: none;"><b>edit</b></a></p>
            <p>----------------------------------------------------------------------------------------------------</p>
    </logic:iterate>
</body>
</html>
