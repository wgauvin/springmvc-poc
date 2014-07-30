<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>
 <head>
  <title>Spring MVC + Tiles Demo - <tiles:insertAttribute name="title"/></title>
  <common:base />
  <tiles:insertAttribute name="script" />
 </head>
 <body>
  <h1><tiles:insertAttribute name="title"/></h1>
  <tiles:insertAttribute name="body" />
 </body>
</html>
