<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<form:form method="POST" commandName="schoolEnroll">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table><tr><td><h2>School Enrollment</h2></td></tr></table>
				<table>				
					<tr>
						<td>School Id :</td>
						<td><form:input path="schId" /></td>
						<td><form:errors path="schId" cssClass="error" /></td>
					</tr>
					<tr>
						<td>School Name :</td>
						<td><form:input path="schName" /></td>
						<td><form:errors path="schName" cssClass="error" /></td>
					</tr>
					<tr>
						<td>School Address :</td>
						<td><form:textarea path="schAddress" /></td>
						<td><form:errors path="schAddress" cssClass="error" /></td>
					</tr>
					<tr>
						<td>School Start Date :</td>
						<td><form:input path="schStartDate" /></td>
						<td><form:errors path="schStartDate" cssClass="error" /></td>
					</tr>
					<tr>
						<td>School Certifications :</td>
						<td><form:select items="${schCertificationList}"
								path="schCertifications" /></td>
						<td><form:errors path="schCertifications" cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" /></td>
					</tr>
					<form:hidden path="timeStamp" />
				</table>				
			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>