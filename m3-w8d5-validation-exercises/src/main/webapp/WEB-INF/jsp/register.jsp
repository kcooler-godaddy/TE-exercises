<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="pageTitle" value="Register"/>
<%@include file="common/header.jspf" %>

<h2>New User Registration</h2>

<c:url value="/doRegister" var="doRegisterURL"/>
<form:form action="${doRegisterURL}" method="POST" modelAttribute="registration">
	<label for="firstName">First Name:</label>
	<form:input path="firstName"/>
	<form:errors path="firstName" cssClass="error"/>
	
	<label for="lastName">Last Name:</label>
	<form:input path="lastName"/>
	<form:errors path="lastName" cssClass="error"/>
	
	<label for="email">Email:</label>
	<form:input path="email"/>
	<form:errors path="email" cssClass="error"/>
	
	<label for="confirmEmail">Confirm Email:</label>
	<form:input path="confirmEmail"/>
	<form:errors path="confirmEmail" cssClass="error"/>
	<form:errors path="emailMatch" cssClass="error"/>
	
	<label for="password">Password:</label>
	<form:input path="password"/>
	<form:errors path="password" cssClass="error"/>
	
	<label for="confirmPassword">Confirm Password:</label>
	<form:input path="confirmPassword"/>
	<form:errors path="confirmPassword" cssClass="error"/>
	<form:errors path="passwordMatch" cssClass="error"/>
	
	<label for="birthday">Birthday: mm/dd/yyy</label>
	<form:input path="birthday"/>
	<form:errors path="birthday" cssClass="error"/>
	
	<label for="numberOfTickets"># of Tickets:</label>
	<form:input path="numberOfTickets"/>
	<form:errors path="numberOfTickets" cssClass="error"/>
	
	<input type="submit" value="Submit"/>
</form:form>


<%@include file="common/footer.jspf" %>