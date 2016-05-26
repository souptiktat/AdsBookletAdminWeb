<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>   
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css"> 

</head
    <body bgcolor="#f1f1f1">

        <center>
            <table bgcolor="#FFFFFF" width="943px" height="900px" cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="3" width="943px">
                        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
              <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>

            <!-- Wrapper for slides -->
          <div class="carousel-inner" role="listbox">
              <div class="item active">
                <img src="<%=request.getContextPath()%>/images/animated templete image2.gif" alt="Chania">
              </div>

              <div class="item">
                <img src="<%=request.getContextPath()%>/images/classified.jpg" alt="Chania" />
              </div>
              <div class="item">
                <img src="<%=request.getContextPath()%>/images/banner1.jpg" alt="Chania" />
              </div>
          </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
              <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

                        <tiles:insert attribute="header" />
                    </td>
                </tr>
                <tr>
                    <td width="190px" height="700px" valign="top">
                        <tiles:insert attribute="leftmenu" /><img src="<%=request.getContextPath()%>/images/ad.jpg" alt="a image" width="190px"/></td>
                    <td width="609px" valign="top" style="padding: 10px"><tiles:insert attribute="body" /></td>
                    <td width="157px" height="700" valign="top">
                        <img src="<%=request.getContextPath()%>/images/333.jpg" alt="a image" />
                        <tiles:insert attribute="rightmenu"/></td>
                </tr>
                <tr>
                    <td height="25" colspan="3"><tiles:insert attribute="footer" /></td>
                </tr>
            </table>
        </center>
                <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    </body>
</html>
