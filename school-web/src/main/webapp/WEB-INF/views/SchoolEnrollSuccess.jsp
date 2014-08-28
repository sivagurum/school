<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<table>
				<tr>
					<td><h2>School Enrollment</h2></td>
				</tr>
			</table>
			<table>
				<tr>
					<td>School Id :</td>
					<td>${schoolEnroll.schId}</td>
				</tr>
				<tr>
					<td>School Name :</td>
					<td>${schoolEnroll.schName}</td>
				</tr>
				<tr>
					<td>School Address :</td>
					<td>${schoolEnroll.schAddress}</td>
				</tr>
				<tr>
					<td>School Start Date :</td>
					<td>${schoolEnroll.schStartDate}</td>
				</tr>
				<tr>
					<td>School Certification Details :</td>
					<td>
						<c:forEach items="${schoolEnroll.schCertifications}" var="cert">
							[<c:out value="${cert}" />]
		 				</c:forEach>
		 			</td>
				</tr>
				<tr>
					<td>Record Creation Date :</td>
					<td>${schoolEnroll.timeStamp}</td>
				</tr>
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>