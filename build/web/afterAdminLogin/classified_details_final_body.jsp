<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>


    
<logic:iterate id="help" name="ClassifiedCategoryBean" property="service">
        <bean:write name="help" property="classified_category_id"/>
        <bean:write name="help" property="classified_category_name"/>
</logic:iterate>