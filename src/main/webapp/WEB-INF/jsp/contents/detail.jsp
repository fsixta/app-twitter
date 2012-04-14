<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty resource}">
		<div class="title">
			API documentation - resource detail
		</div>
		<div class="stdTextBlock">
			<h3>Name:</h3>
			<p style="font-weight:bold">${resource.path}</p>
		</div>
		<div class="stdTextBlock">
			<h3>Parameters:</h3>

			<ul>
			<c:forEach var="par" items="${resource.param}">
				<li>
					<p style="font-weight:bold">${par.name}</p>
					<p>${par.doc}</p>
					<p>Type: ${par.type}</p>
					<p>Required: ${par.required}</p>
				</li>
			</c:forEach>
			</ul>
		</div>
		<div class="stdTextBlock">
			<h3>Methods:</h3>

			<ul>
			<c:forEach var="method" items="${resource.method}">
				<li>
					<p style="font-weight:bold">${method.id}</p>
					<p>${method.doc}</p>
				</li>
			</c:forEach>
			</ul>
		</div>

		<div style="text-align:right">
			<a href="docMain">Back</a>
		</div>
	</c:when>
	<c:otherwise>
		<div class="errorTitle">
			API documentation ERROR
		</div>

		<div class="stdTextBlock">
			<p>Resource cannot be found. Probably an invalid resource ID has been passed.</p>
			<br>
			<p>Go back to the <a href="docMain">API documentation page</a>.</p>
		</div>
		<div class="cleaner" style="height:40px" />
	</c:otherwise>
</c:choose>

<%--c:forEach var="resources" items="${resourcesList}">
	<div class="stdTextBlock">
		<h3>Resource group <a href="${resources.base}" target="twitter">${resources.base}</a>:</h3>

		<c:forEach var="resource" items="${resources.resource}">
			<p><a href="detail?id=${resource.refId}">${resource.path}</a></p>
		</c:forEach>
	</div>
</c:forEach--%>
