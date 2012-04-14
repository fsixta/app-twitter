<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="title">
	API documentation
</div>

<c:forEach var="resources" items="${resourcesList}">
	<div class="stdTextBlock">
		<h3>Resource group <a href="${resources.base}" target="twitter">${resources.base}</a>:</h3>

		<ul>
			<c:forEach var="resource" items="${resources.resource}">
				<li><p><a href="detail?id=${resource.refId}">${resource.path}</a></p></li>
			</c:forEach>
		</ul>
	</div>
</c:forEach>
