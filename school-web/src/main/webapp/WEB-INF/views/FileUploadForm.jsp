<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html xmlns="http://www.w3.org//xhtml">

	<head>
		<title>File Upload with Spring 3 MVC</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf8">
	</head>

	<body>
		<h1>
			File Upload Form
		</h1>
		<br />

		<form:form commandName="FORM" enctype="multipart/form-data"
			action="FileUploadForm" method="POST">
			<table>
				<tr>
					<td colspan="2" style="color: red;">
						<form:errors path="*" cssStyle="color : red;" />						
						${errors}
					</td>
				</tr>

				<tr>
					<td>
						Name :
					</td>
					<td>					
						<input type="file" id="file" value=""  name="file" />
						
					</td>
				</tr>

				<tr>
					<td colspan="2">
						<input type="submit" value="Upload File" />
					</td>
				</tr>
			</table>
		</form:form>

	</body>

</html>
