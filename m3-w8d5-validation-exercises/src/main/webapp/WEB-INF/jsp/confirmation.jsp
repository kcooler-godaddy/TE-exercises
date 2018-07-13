<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Confirmation"/>
<%@include file="common/header.jspf" %>

<h2>Confirmation</h2>

<p>You have successfully ${confirmationAction}.</p>

<%@include file="common/footer.jspf" %>