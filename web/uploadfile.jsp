
        <style>
    .td1 {
        font-size: medium;
        width: 60%;
        color: blue;
        
    }
    .td {
        padding-left: 10px;
        //font-size: 30px;
        //color: blue;
        //width: 40%;
    }
</style>
   
        <h2><b style="color: #400; font-size: 17px; font-family: cursive; padding-left: 10px">Upload Image For Your Ads <span style="color: red">*</span>First</b></h2>
    <center>
        <form method="post" action="UploadServlet" enctype="multipart/form-data">
            <table style="width: 80%; padding: 0px 20px 0px 20px">
                <tr><td></td>
                    <td class="td"><b style="color: green; font-size: 11px">Image with your Ads will get 50% more response</b></td>
                </tr>
                <tr>
                <td class="td1">Upload Image:</td>
                <td class="td1"><input type="file" name="dataFile" id="fileChooser" style="padding: 10px 5px 10px 5px"/></td>
                </tr>
                <tr>
                    <td class="td1"></td>
                    <td class="td"><input type="submit" value="Upload"  style="color: white; background-color: darkslategray" /></td>
                </tr>
                <tr><td></td><td align="center"><h4 align="center">
                     <% String msg = (String)request.getAttribute("message"); %>
                        <% if( msg != null) { 
                         out.print(msg);
                        } %>
                    </h4></td></tr>
                
            </table>
            
             </form>
    </center>
    
    <% String subcategory = (String)session.getAttribute("subcategory"); %>
    <%--<% out.print(subcategory); %> --%>
    <% if(subcategory.equals("1")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("2")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("3")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("4")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("5")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("6")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("7")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("8")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("9")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("10")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("11")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("12")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("13")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("14")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("15")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("16")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("17")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("18")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("19")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("20")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("21")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("22")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("23")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("24")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("25")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("26")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("27")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("28")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("29")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("30")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("31")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("32")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("33")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("34")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("35")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("36")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("37")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("38")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <%--<% } else if(subcategory.equals("39")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("40")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("41")) { %>
    <%@include file="category/carsbikes.jsp" %>
    <% } else if(subcategory.equals("42")) { %>
    <%@include file="category/carsbikes.jsp" %>--%>
    <% } else if(subcategory.equals("43")) { %>
    <%@include file="category/mobiles/mobilephones.jsp" %>
    <% } else if(subcategory.equals("44")) { %>
    <%@include file="category/mobiles/accessories.jsp" %>
    <% } else if(subcategory.equals("45")) { %>
    <%@include file="category/mobiles/tablets.jsp" %>
    <% } %>
    
    
   
