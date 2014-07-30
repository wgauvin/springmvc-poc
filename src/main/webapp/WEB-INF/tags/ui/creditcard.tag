<%@ tag language="java" pageEncoding="US-ASCII"%>
<%@ taglib prefix="ui" tagdir="/WEB-INF/tags/ui" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ attribute name="field" required="true"%>

<ui:input field="${field}.cardHolder" label="Card Holder" hint="Name as it appears on card." required="true"/>
<ui:input field="${field}.cardNumber" label="Card Number" hint="Card number."  required="true"/>

<div class="control-group">
 <ui:label field="${field}.expiryMonth" label="Expiry Date" required="true"/>
 <div class="controls controls-row">
   <form:select path="${field}.expiryMonth" items="${validExpiryMonths}" cssClass="span1"/>
   <form:select path="${field}.expiryYear" items="${validExpiryYears}" cssClass="span2"/>
 </div>
</div>

<ui:input field="${field}.securityCode" label="Security Code" hint="Last 3 digits on back of card." maxlength="3" cssClass="span1" required="true"/>
