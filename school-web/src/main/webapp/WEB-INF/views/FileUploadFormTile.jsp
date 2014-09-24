<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<form:form modelAttribute="FORM" enctype="multipart/form-data" action="FileUploadForm" method="POST">
				<table>
					<tr>
						<td colspan="2" style="color:red;">
							<form:errors path="*" cssClass="errorblock" element="div" />
							${errors}
						</td>
						<td colspan="2" style="color:green;">
							${success}
						</td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><form:input type="file" path="file" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Upload File"></td>
					</tr>
				</table>			
			</form:form>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>