<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#username").attr("placeholder", "Please sign in with your E-mail");
    });
</script>

<script>
    $(document).ready(function () {
        $("#ans").attr("placeholder", "Answer");
    });
</script>



            <div style="color: red" align="center">
            <% String msg = (String)request.getAttribute("message");
            
             if(msg!=null || msg=="")
                 out.println(msg);
            %>
            </div>



<html:form action="forgotpath" method="post">
    
    <table align="center" >
        
        <tr></tr>
        
        <tr>
            <td>Username:</td>
            <td><html:text property="username" styleId="username" style="width: 200px"/></td><td><html:errors property="username"/></td>
         
        
        </tr>
        <tr></tr>
        <tr></tr>
        
        <td class="td1">Choose Security Question:</td>
            <td class="td">
                <html:select property="secure" styleId="secure">
                     <html:option value="">--Select your Security Question--</html:option>
                    <html:option value="1">what is your first school name?</html:option>                        
                    <html:option value="2" >what is your favorite food?</html:option>
                    <html:option value="3" >what is your favorite color?</html:option>
                    <html:option value="4" >what is your favorite holiday destination?</html:option>
                    <html:option value="5" >what is your favorite pet?</html:option>
                </html:select><td><html:errors property="secure"/></td>
          
           
        
        </tr>
        <tr></tr>
        <tr></tr>
        
        <tr>
            <td class="td1">Answer:</td>
            <td class="td"><html:text property="ans" styleId="ans"/></td><td><html:errors property="ans"/></td>
        </tr>
        
        
        
    </table>
            
            <table align="center">
        <tr>
            <td><html:submit/></td>
        </tr>

        
       
    </table>

</html:form>