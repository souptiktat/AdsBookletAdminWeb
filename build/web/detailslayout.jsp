<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body bgcolor="#f1f1f1">
    <center>
        <table bgcolor="#FFFFFF" width="943" height="auto" border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="3">
                    <img src="<%=request.getContextPath()%>/images/animated templete image2.gif" alt="a image" width="943;" height="200px;"/>
                     <tiles:insert attribute="header" />
                </td>
            </tr>
             <tr>
                    
                    <td width="1000px" valign="top"><tiles:insert attribute="body" /></td>
                   
            </tr>
            <tr>
                    <td height="177" colspan="3"><tiles:insert attribute="footer" /></td>
            </tr>
        </table>
    </center>
     

    </body>
</html>
