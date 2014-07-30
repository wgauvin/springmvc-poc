<%@ tag language="java" pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="method" required="true" rtexprvalue="false"%>
<%@ attribute name="formClass" rtexprvalue="false"%>
<%@ attribute name="modelAttribute" required="true" rtexprvalue="true"%>

<form:form method="${method}" modelAttribute="${modelAttribute}" cssClass="${formClass}">

 <input type="hidden" id="sessionId" name="sessionId" value="${pageContext.session.id}"/>
 <input type="hidden" id="nonce" name="nonce" value="${nonce}"/>

 <jsp:doBody />

</form:form>
