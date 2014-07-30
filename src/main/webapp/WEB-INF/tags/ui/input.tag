<%@ tag language="java" pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui"%>
<%@ attribute name="field" required="true"%>
<%@ attribute name="label"%>
<%@ attribute name="hint"%>
<%@ attribute name="maxlength" type="Integer"%>
<%@ attribute name="cssClass"%>
<%@ attribute name="required" type="Boolean"%>
<div class="control-group">
 <ui:label field="${field}" label="${label}" required="${required}" />
 <div class="controls">
  <form:input path="${field}" maxlength="${maxlength}"
   cssClass="${cssClass}" />
  <div>
   <small>${hint}</small>
  </div>
 </div>
</div>
