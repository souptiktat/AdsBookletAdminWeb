<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css"> 
    <html:base/>
<style type="text/css">

dl {
  font:normal 12px/15px Arial;
  width: 350px;
}
dt {
  clear: both;
  float:left;
  width: 130px;
  padding: 4px 0 2px 0;
  text-align: left;
}
dd {
  float: left;
  width: 200px;
  margin: 0 0 8px 0;
  padding-left: 6px;
  position: relative;
}
.hint {
  display:none;
  position: absolute;
  right: -250px;
  width: 200px;
  margin-top: -4px;
  border: 1px solid #c93;
  padding: 10px 12px;
  /* background: #ffc url(<%=request.getContextPath()%>/images/pointer.gif) -100px -100px no-repeat; */
  background: #ffc url(pointer.gif) -100px -100px no-repeat;
}
.hint.hint-pointer {
    position: absolute;
    left: -10px;
    top: 5px;
    width: 10px;
    height: 19px;
    background: url(pointer.gif) left top no-repeat;
}
 </style>

 <script type="text/javascript">
 function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      oldonload();
      func();
    }
  }
}

function prepareInputsForHints() {
  var inputs = document.getElementsByTagName("input");
  for (var i=0; i<inputs.length; i++){
    inputs[i].onfocus = function () {
      this.parentNode.getElementsByTagName("span")[0].style.display = "inline";
    }
    inputs[i].onblur = function () {
      this.parentNode.getElementsByTagName("span")[0].style.display = "none";
    }
  }
  var inputs = document.getElementsByTagName("input");
  for (var i=0; i<inputs.length; i++){
    inputs[i].onfocus = function () {
      this.parentNode.getElementsByTagName("span")[0].style.display = "inline";
    }
    inputs[i].onblur = function () {
      this.parentNode.getElementsByTagName("span")[0].style.display = "none";
    }
  }
  var selects = document.getElementsByTagName("select");
  for (var k=0; k<selects.length; k++){
    selects[k].onfocus = function () {
      this.parentNode.getElementsByTagName("span")[0].style.display = "inline";
    }
    selects[k].onblur = function () {
      this.parentNode.getElementsByTagName("span")[0].style.display = "none";
    }
  }
}
addLoadEvent(prepareInputsForHints);
    </script>

<body bgcolor="#f1f1f1">

    <center>
        <table bgcolor="#FFFFFF" width="943px" height="970px" border="1" cellspacing="0" cellpadding="0">
            <tr>
                <td colspan="3">
                    <img src="<%=request.getContextPath()%>/images/animated templete image2.gif" alt="a image" width="943;" height="200px;"/>
                     <tiles:insert attribute="header" />
                </td>
            </tr>
             <tr>
                    <td width="157px" height="584px" valign="top"><tiles:insert attribute="adminleftmenu" /></td>

                    <td width="609px" valign="top"><tiles:insert attribute="body" /></td>

            </tr>
            <tr>
                    <td height="177px" colspan="3"><tiles:insert attribute="footer" /></td>
            </tr>
        </table>
    </center>


    </body>
</html>
