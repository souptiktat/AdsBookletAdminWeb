<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:form action="search.do">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <center>
        <font style="color:maroon; font-weight:bold"></font>  
        <p style="background-color:silver">Ads Classified India</p>

        <div class="clear"></div>
        <div style="text-align:left; line-height:20px; width:550px;color:#000000"><font color="green"> Ads Classified India serves as a link to host an advertisement  .Through this website customer  can post advertisement  as well as  can locate a desired advetise in a proper way, depending on the requirements concerned. Along with all these the website provides provisions for even the advertisement  to get easy access to  interested in collaborating about it.</font>
            </div>
        <div class="clear"></div>
        <p>
            <div class="row" style="width: 90%;">
                <div class="col-md-1"></div>
                <div class="col-md-5">            
                    <html:text property="searchWord" styleClass="form-control" styleId="word" />
                </div>
                <div class="col-md-5">            
                    <html:select property="tablename" styleClass="form-control">
                        <html:option value="categories">Categories</html:option>
                        <html:option value="posts">Posts</html:option>
                    </html:select>
                </div>
            </div> 
            <div class="row" style="padding: 10px;">
                <div class="col-md-2"></div>
                <div class="col-md-8"><html:submit value="Search" styleClass="btn btn-info btn-block" /></div>
            </div>

        </p>
    </center>
</html:form>
<script>
//    $(document).ready(function () {
//        $("#word").attr("placeholder", "search requirement");
//    });
    document.getElementById("word").setAttribute("placeholder", "Search Keyword");
</script>
