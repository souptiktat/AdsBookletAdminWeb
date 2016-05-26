<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
<title>JQuery Datepicker</title>

<link rel="stylesheet" href="ui.datepicker.css"/>


<script type="text/javascript" src="jq.js"></script>
<script type="text/javascript" src="jq.date.js"></script>
<script type="text/javascript">

$(document).ready(function() {

	$('#trip input#postingdate, #trip input#postingexpiredate, #trip input#postingwarningdate').datepicker({ dateFormat: 'dd/mm/yy', showOn: 'button', buttonImage: 'calendar.gif', buttonImageOnly: true }); // format: Thurs, Jan 31, 2008, only show when the user clicks the calendar

});

</script>

<script type="text/javascript">

function GetXmlHttpObject() {
    var isIE7 = navigator.userAgent.toLowerCase().indexOf('msie 7') != -1;
    var isIE6 = navigator.userAgent.toLowerCase().indexOf('msie 6') != -1;
    var xmlHttp;
	if (isIE7){
		 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else if(isIE6){
		 xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	else{
		 xmlHttp = new XMLHttpRequest();
	}
  return xmlHttp;
}

function fetchSubCategoryList(category){

        var cat = category.value;
       // alert(cat);
        var ajaxRequest = new GetXmlHttpObject();
	ajaxRequest.open('POST','AjaxServlet?service=RetreiveSubCategoryList',true);
	ajaxRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	ajaxRequest.onreadystatechange = function(){
            if (ajaxRequest.readyState == 4) {
               if (ajaxRequest.status == 200) {
                   var resultString =ajaxRequest.responseText;
                    if(resultString != ''){
                       var targetOptions =document.getElementsByName('classifiedSubCategory')[0].options;
                     
	               if (targetOptions.length==1 && targetOptions.value!=""){
		               targetOptions.length = 0;
	              }
                       document.getElementById('classifiedSubCategory').innerHTML = "";
                       var resultStringSplitArr = new Array();
                       resultStringSplitArr = resultString.split('-');
                     //  alert(resultStringSplitArr);

                       for( var r = 0; r<resultStringSplitArr.length; r++){
                                   var resultStringArr = new Array();
                                       resultStringArr = resultStringSplitArr[r].split(',');
                                     //  alert(resultStringArr);
                                       for( var i = 0; i<resultStringArr.length-1; i++){
                                       
                                        targetOptions[r + 1] = new Option(resultStringArr[i+1], resultStringArr[i]);
                                       // alert(resultStringArr[i]);
                                       // alert(resultStringArr[i+1]);

                                      }
                       }
                   }
               }
            }
	}
	ajaxRequest.send("Category="+cat);

 }
</script>



</head>

<html:form action="update" styleId="trip">
<jsp:useBean id="classifiedIndiaFormBean" class="com.classifiedindia.formbean.ClassifiedIndiaFormBean" scope="request"/>
<h2><b style="color: brown; font-size: 20px; font-family: cursive; padding: 20px">Edit your Ads</b></h2>
<table style="width:421px;height:551px; padding: 10px" >
   <tr>
                <td width="185"> Category:<font color='red'>* </font></td>

                <td>
                <html:select property="classifiedCategory" styleId="classifiedCategory" onchange="fetchSubCategoryList(this)">
                    <html:option value='<%=classifiedIndiaFormBean.getClassifiedCategory()%>'><%=classifiedIndiaFormBean.getClassifiedCategoryName()%></html:option>                        
                        <html:option value="1" > Home & Lifestyle</html:option>
                        <html:option value="2" > Electronics Appliances</html:option>
                        <html:option value="3" > Mobiles & Tablets</html:option>
                        <html:option value="4" > Entertainment</html:option>
                        <html:option value="5" > Cars & Bikes</html:option>
                        <html:option value="6" > Real Estate</html:option>
                        <html:option value="7" > Jobs</html:option>
                        <html:option value="8" > Services</html:option>
                        <html:option value="9" > Education & Learning</html:option>
                        <html:option value="10" > Community & Events</html:option>
                        <html:option value="11" > Matrimonial</html:option>
                        <html:option value="12" > Pets & Pets care</html:option>

                    </html:select>

                </td>
            </tr>
            <tr>
                <td width="185">Sub Category:<font color='red'>* </font></td>
                <td><html:select property="classifiedSubCategory" styleId="classifiedSubCategory">
                <html:option value='<%=classifiedIndiaFormBean.getClassifiedSubCategory()%>'><%=classifiedIndiaFormBean.getClassifiedSubCategoryName()%></html:option>
                    </html:select>
                </td>
</tr> 
   <%-- <tr>
            <td>Category:<font color='red'>* </font></td>
            <td><html:text property="classifiedCategoryName" value='<%=classifiedIndiaFormBean.getClassifiedCategoryName()%>' readonly="true" style="color: grey" /> </td>
        </tr>
        <tr>
            <td>Sub-category:<font color='red'>* </font></td>
            <td><html:text property="classifiedSubCategoryName" value='<%=classifiedIndiaFormBean.getClassifiedSubCategoryName()%>' readonly="true" style="color: grey" /> </td>
        </tr>--%>
            <tr>
                <td>Subject:<font color='red'>* </font></td>
                <td><html:textarea property="classifiedSubject" rows="10" value='<%=classifiedIndiaFormBean.getClassifiedSubject()%>' /> </td>
            </tr>
            <tr>
                <td>Primary Contact :<font color='red'>* </font></td>
                <td><html:text property="classifiedPrimaryContact" value='<%=classifiedIndiaFormBean.getClassifiedPrimaryContact()%>' /> </td>
            </tr>
            
            <tr>
                <td>Secondary Contact :<font color='red'>* </font></td>
                <td><html:text property="classifiedSecondaryContact" value='<%=classifiedIndiaFormBean.getClassifiedSecondaryContact()%>' /> </td>
            </tr>
            <tr>
                <td>Contact Person:<font color='red'>* </font></td>
                <td><html:text property="classifiedContactPerson" value='<%=classifiedIndiaFormBean.getClassifiedContactPerson()%>' /> </td>
            </tr>
            <tr>
                <td>Email Id:<font color='red'>* </font></td>
                <td><html:text property="classifiedEmailId" value='<%=classifiedIndiaFormBean.getClassifiedEmailId()%>' readonly="true" /> </td>
            </tr>
            <tr>
                <td>Web Url:<font color='red'>* </font></td>
                <td><html:text property="classifiedWebUrl" value='<%=classifiedIndiaFormBean.getClassifiedWebUrl()%>' /> </td>
            </tr>
            <tr>
                <td>Active De-active Status:<font color='red'>* </font></td>
                <td><html:select property="classifiedActiveDeactiveStatus">
                        <html:option value="">-:Select Option:-</html:option>
                        <html:option value="1">True</html:option>
                        <html:option value="0">False</html:option>
                    </html:select>
                    </td>
            </tr>
            <tr>
                <td>Booking Duration:<font color='red'>* </font></td>
                <td><html:select property="classifiedBookingDuration">
                        <html:option value="">-:Select Option:-</html:option>
                        <html:option value="1">1</html:option>
                        <html:option value="2">2</html:option>
                        <html:option value="3">3</html:option>
                        <html:option value="4">4</html:option>
                        <html:option value="5">5</html:option>
                        <html:option value="6">6</html:option>
                        <html:option value="7">7</html:option>
                        <html:option value="8">8</html:option>
                        <html:option value="9">9</html:option>
                        <html:option value="10">10</html:option>
                        <html:option value="11">11</html:option>
                    </html:select>
                    </td>
            </tr>
            <tr>
                <td>Posting Expire Date:<font color='red'>* </font></td>
                <td><html:text property="classifiedExpireDate" styleId="postingexpiredate" value='<%=classifiedIndiaFormBean.getClassifiedExpireDate()%>'/> </td>
            </tr>
            <tr>
                <td>Posting Warning  date:</td>
                <td><html:text property="classifiedExpireWarrningDate" styleId="postingwarningdate" value='<%=classifiedIndiaFormBean.getClassifiedExpireWarrningDate()%>'/> </td>
            </tr>
            <tr>
                <td>Payment Category:<font color='red'>* </font></td>
                <td><html:select property="classifiedPaymentCategory">
                        <html:option value="">-:Select Option:-</html:option>
                        <html:option value="Free">Free</html:option>
                        <html:option value="ByCash">By Cash</html:option>
                        <html:option value="Online">Online</html:option>
                        <html:option value="ByDraft">By Draft</html:option>
                    </html:select>
                    </td>
            </tr>
</table>
            <table>
            <tr>
                <td style="width: 180px"></td>
                <td><input type="submit" value="update"></td>
            </tr>
</table>
    </html:form>


