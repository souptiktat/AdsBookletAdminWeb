<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<html:form action="search.do">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        $("#word").attr("placeholder", "search requirement");
    });
</script>
    <center>
        <font style="color:maroon; font-weight:bold"></font>  
        <p style="background-color:silver">Ads Classified India</p>

        <div class="clear"></div>
        <div style="text-align:left; line-height:20px; width:550px;color:#000000"><font color="green"> Ads Classified India serves as a link to host an advertisement  .Through this website customer  can post advertisement  as well as  can locate a desired advetise in a proper way, depending on the requirements concerned. Along with all these the website provides provisions for even the advertisement  to get easy access to  interested in collaborating about it.</font>
            </div>
        <div class="clear"></div>
        <p>
            <html:text property="searchWord" styleId="word" style="width: 200px" />
                <html:submit value="Search" style="background-color: darkslategray; color: white"></html:submit>
            </p>
    </center>
</html:form>
