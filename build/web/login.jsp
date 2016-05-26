<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function (){
    $("form").form();
});
</script>

<script>
    $(document).ready(function () {
        $("#username").attr("placeholder", "Email id");
    });
</script>
<script>
    $(document).ready(function () {
        $("#password").attr("placeholder", "Password");
    });
</script>

    
    
    <div class="well container" style="width: 500px;">
        <h1 class="page-header">Signin</h1>
    <html:form action="userLogin">
        <div class="form-group">
            <label>Username</label>
            <html:text property="username" styleClass="form-control" styleId="username"/>
            <div class="help-block" style="color: red;"><html:errors property="username"/></div>
        </div>
        <div class="form-group">
            <label>Password</label>
            <html:password property="password" styleClass="form-control" styleId="password"/>
            <div class="help-block" style="color: red;"><html:errors property="password"/></div>
        </div>
        <html:submit styleClass="btn btn-primary btn-block"/>
    </html:form>            
        <div class="row">
            <!--<div class="col-md-3"></div>-->
            <div class="text-center" style="padding: 10px 0px;">
                <label class="label label-info">Can't remember your password? </label> <a href="forgotLink.do"><i class="glyphicon glyphicon-question-sign"></i> Click here!</a>
                <label class="label label-success">Create new account </label> <a href="registerLink.do"><i class="glyphicon glyphicon-user"></i> here!</a>
            </div>
        </div>
        
    </div>

    
    
    

            
                
<script>

    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
    
</script>
  


  
