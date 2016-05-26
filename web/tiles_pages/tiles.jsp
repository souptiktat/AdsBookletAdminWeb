<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<tiles:insert page="/tiles_pages/layout.jsp"  flush="true">
  <tiles:put name="title" value="Tiles"/>
  <tiles:put name="header" value="/tiles_pages/header.jsp"/>
  <tiles:put name="leftmenu" value="/tiles_pages/leftmenu.jsp"/>
  <tiles:put name="body" value="/tiles_pages/body.jsp"/>
  <tiles:put name="footer" value="/tiles_pages/footer.jsp"/>
  <tiles:put name="rightmenu" value="/tiles_pages/rightmenu.jsp"/>
</tiles:insert>