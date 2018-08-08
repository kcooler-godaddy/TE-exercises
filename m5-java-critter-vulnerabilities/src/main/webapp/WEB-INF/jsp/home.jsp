<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Latest Messages</h2>
<ol class="message-list">
	<c:forEach items="${messages}" var="message">
		<li class="message">
			<c:url var="messageHref" value="/messages">
				<c:param name="userName" value="${message.fromUsername}" />
			</c:url>
			<span class="username"><a href="${messageHref}"><c:out value="${message.fromUsername}"/></a></span>
			<span class="message-text"><c:out value="${message.text}"/></span>
			<time class="timeago" datetime="${message.createTime}"><c:out value="${message.createTime}"/></time>
			
			<c:if test="${currentUser.equals(message.fromUsername)}">
				<c:url var="doDeleteURL" value="/doDelete">
					<c:param name="id" value="${message.id}" />
				</c:url>
				<span class="delete-btn"><a href="${doDeleteURL}">Delete</a></span>
			</c:if>
			
		</li>
	</c:forEach>
</ol>
		
<c:import url="/WEB-INF/jsp/footer.jsp" />
		