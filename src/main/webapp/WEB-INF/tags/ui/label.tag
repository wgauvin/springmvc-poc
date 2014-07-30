<%@ tag language="java" pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="field" required="true"%>
<%@ attribute name="required" type="Boolean"%>
<%@ attribute name="label" %>
<form:label path="${field}" cssClass="control-label"><c:if test="${not empty required && required}"><span class="required">* </span></c:if>${label}</form:label>
