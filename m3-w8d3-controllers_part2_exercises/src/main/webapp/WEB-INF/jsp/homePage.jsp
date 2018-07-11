<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Squirrel Cigar Parties for Dummies</title>
	</head>
	<body>
		<c:url value="/writeReview" var="writeReviewURL"/>
		<img src="img/forDummies.png" alt="Cover of book"/>
		<header>
			<h1>Reviews</h1>
			<a href="${writeReviewURL}"><h2>Submit a New Review</h2></a>
		</header>
		<div>
			<c:forEach var="review" items="${reviews}">
				<div>
					<hr/>
					<div><span style="font-weight:bold;">${review.title}</span> (${review.username})</div>
					<div>
						${review.dateSubmitted }
					</div>
					<div>
						<c:forEach begin="1" end="${review.rating}">
							<img src="img/star.png" alt="star"/>
						</c:forEach>
					</div>
					<div><p>${review.text}</p></div>
				</div>
			</c:forEach>
		</div>
		
		
		
	</body>
</html>