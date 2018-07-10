<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Search Actors Form"/>

<%@include file="common/header.jspf"%>

<c:url value="/actorList" var="formAction" />
<form method="GET" action="${formAction}">
	<label for="actorSearch">Search Actor by Last Name: </label>
	<input type="text" id="actorSearch" name="actorSearch" />
	<input type="submit" value="Submit" />
</form>

<%@include file="common/footer.jspf"%>