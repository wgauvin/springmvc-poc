<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="common" tagdir="/WEB-INF/tags/common"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>

<ui:form modelAttribute="payment" method="post" formClass="form-horizontal">
<div>
  <legend>Payment Details</legend>
  <ui:input field="amount" hint="Amount you wish to pay." label="Payment Amount" required="true"/>
</div>
<div>
  <legend>Card Details</legend> 
  <ui:creditcard field="creditCard" />
</div>
</ui:form>
