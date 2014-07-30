<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:form modelAttribute="credentials" method="post" formClass="form-horizontal">
 <ui:input field="username" label="Username" hint="Enter user name." />
 <ui:password field="password" label="Password" hint="Enter password." />
 <ui:formActions>
   <ui:submit label="Log In"/>
 </ui:formActions>
</ui:form>
<div id="login-msg"></div>
