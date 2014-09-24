<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="menu">
Menu
	<ul>
		<li>
			<spring:url value="/home" var="homeUrl" htmlEscape="true"/>
			<a href="${homeUrl}">Home</a>
		</li>
		<li>
			<spring:url value="/about" var="aboutUrl" htmlEscape="true"/>
			<a href="${aboutUrl}">About</a>
		</li>
		<li>
			<spring:url value="/schoolEnroll" var="schoolEnrollUrl" htmlEscape="true"/>
			<a href="${schoolEnrollUrl}">School Enroll</a>
		</li>
		<li>
			<spring:url value="/studentEnroll" var="studentEnrollUrl" htmlEscape="true"/>
			<a href="${studentEnrollUrl}">Student Enroll</a>
		</li>
		<li>
			<spring:url value="/FileUploadForm" var="fileUploadFormUrl" htmlEscape="true"/>
			<a href="${fileUploadFormUrl}">File Upload</a>
		</li>
		<li>
			<spring:url value="/fileDownload/upload/nature/jpg" var="fileDownloadFormUrl" htmlEscape="true"/>
			<a href="${fileDownloadFormUrl}">File Download</a>
		</li>				
	</ul>
</div>