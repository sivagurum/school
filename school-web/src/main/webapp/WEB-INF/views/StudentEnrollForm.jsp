<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<form:form method="POST" action="save" commandName="studentEnroll">
				<form:errors path="*" cssClass="errorblock" element="div" />
				<table><tr><td><h2>Student Enrollment</h2></td></tr></table>
				<table>				
					<tr>
						<td>Student Id :</td>
						<td><form:input path="id" /></td>
						<td><form:errors path="id" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Student Name :</td>
						<td><form:input path="name" /></td>
						<td><form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Student Age :</td>
						<td><form:input path="age" /></td>
						<td><form:errors path="age" cssClass="error" /></td>
					</tr>
					<tr>
						<td>Student Address :</td>
						<td><form:textarea path="address" /></td>
						<td><form:errors path="address" cssClass="error" /></td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" /></td>
					</tr>					
				</table>				
			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>