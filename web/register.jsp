<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#username").attr("placeholder", "Please sign in with your E-mail");
        $("#password").attr("placeholder", "Password");
        $("#fullname").attr("placeholder", "fullname");
        $("#mob").attr("placeholder", "Mobile Phone");
        $("#address").attr("placeholder", "Address");
        $("#pincode").attr("placeholder", "must be digits");
        $("#ans").attr("placeholder", "Answer");
    });
</script>
<script type="text/javascript">

    function GetXmlHttpObject() {
        var isIE7 = navigator.userAgent.toLowerCase().indexOf('msie 7') != -1;
        var isIE6 = navigator.userAgent.toLowerCase().indexOf('msie 6') != -1;
        var xmlHttp;
        if (isIE7) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        else if (isIE6) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        else {
            xmlHttp = new XMLHttpRequest();
        }
        return xmlHttp;
    }

    function fetchDistrictList(state) {
        var st = state.value;
        //alert(st);
        var ajaxRequest = new GetXmlHttpObject();
        ajaxRequest.open('POST', 'AjaxServlet?service=RetreiveSubCategoryList', true);
        ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        ajaxRequest.onreadystatechange = function () {
            if (ajaxRequest.readyState == 4) {
                if (ajaxRequest.status == 200) {
                    var resultString = ajaxRequest.responseText;
                    if (resultString != '') {
                        var targetOptions = document.getElementsByName('districtid')[0].options;

                        if (targetOptions.length == 1 && targetOptions.value != "") {
                            targetOptions.length = 0;
                        }
                        document.getElementById('districtid').innerHTML = "";
                        var resultStringSplitArr = new Array();
                        resultStringSplitArr = resultString.split('#');
                        //alert(resultStringSplitArr);

                        for (var r = 0; r < resultStringSplitArr.length; r++) {
                            var resultStringArr = new Array();
                            resultStringArr = resultStringSplitArr[r].split('.');
                            //alert(resultStringArr);
                            for (var i = 0; i < resultStringArr.length - 1; i++) {

                                targetOptions[r + 1] = new Option(resultStringArr[i + 1], resultStringArr[i]);
                                //alert(resultStringArr[i]);
                                //alert(resultStringArr[i+1]);

                            }
                        }
                    }
                }
            }
        }
        ajaxRequest.send("Category=" + st);

    }
</script>

<div class="container well" style="width: 500px;">
    <h1 class="page-header">Signup here</h1>
    <html:form action="register">
        <div class="form-group">
            <label>Full Name</label>
            <html:text property="fullname" styleId="fullname" styleClass="form-control" />
            <div style="color: red;"><html:errors property="fullname"/></div> 
        </div>
        <div class="form-group">
            <label>Mobile</label>
            <html:text property="mob" styleId="mob" styleClass="form-control"/>
            <div style="color: red;"><html:errors property="mob"/></div>            
        </div>
        <div class="form-group">
            <label>Gender</label>
            <div>
                <html:radio property="gender" styleId="gender" value="Male"/> Male
            </div>
            <div>
                <html:radio property="gender" styleId="gender" value="Female"/> Female
            </div>
            
            <div style="color: red;"><html:errors property="gender"/></div>            
        </div>
        <div class="form-group">
            <label>Nationality</label>
            <html:select property="nationality" styleId="nationality" styleClass="form-control">
                <html:option value="">choose nationality</html:option>
                <html:option value="indian">Indian</html:option>
                <html:option value="others">Others</html:option>
            </html:select>
            <div style="color: red;"><html:errors property="nationality"/></div>            
        </div>
        <div class="form-group">
            <label>Username</label>
            <html:text property="username" styleId="username" styleClass="form-control"/>
            <div style="color: red;"><html:errors property="username"/></div>            
        </div>
        <div class="form-group">
            <label>Password</label>
            <html:password property="password" styleId="password" styleClass="form-control"/>
            <div style="color: red;"><html:errors property="password"/></div>            
        </div>
        <div class="form-group">
            <label>Address</label>
            <html:textarea property="address" styleId="address" styleClass="form-control" />
            <div style="color: red;"><html:errors property="address"/></div>            
        </div>
        <div class="form-group">
            <label>State & District</label>
            <div class="row">
                <div class="col-md-6">
                    <html:select property="stateid" styleId="statelist" onchange="fetchDistrictList(this)" styleClass="form-control">
                        <html:option value="">select state</html:option>                        
                        <html:option value="1" >West Bengal</html:option>
                        <html:option value="2" >Assam</html:option>
                    </html:select>
                        <div style="color: red;"><html:errors property="stateid"/></div>            
                </div>
                <div class="col-md-6">
                    <html:select property="districtid" styleId="districtid" styleClass="form-control">
                        <html:option value="">select district</html:option>
                    </html:select>
                        <div style="color: red;"><html:errors property="districtid"/></div>            
                </div>
            </div>
            
            
        </div>
        <div class="form-group">
            <label>Pincode</label>
            <html:text property="pincode" styleId="pincode" styleClass="form-control"/>
            <div style="color: red;"><html:errors property="pincode"/></div>            
        </div>
        <div class="form-group">
            <label>Security Question</label>
            <html:select property="secure" styleId="secure" styleClass="form-control">
                <html:option value="">--Select your Security Question--</html:option>
               <html:option value="1">what is your first school name?</html:option>                        
               <html:option value="2" >what is your favorite food?</html:option>
               <html:option value="3" >what is your favorite color?</html:option>
               <html:option value="4" >what is your favorite holiday destination?</html:option>
               <html:option value="5" >what is your favorite pet?</html:option>
           </html:select>
            <div style="color: red;"><html:errors property="secure"/></div>            
        </div>
        
         <div class="form-group">
            <label>Answer</label>
            <html:text property="ans" styleId="ans" styleClass="form-control"/>
            <div style="color: red;"><html:errors property="ans"/></div>            
        </div>
        <html:submit styleClass="btn btn-primary btn-block" />
    </html:form>        
</div>
        
