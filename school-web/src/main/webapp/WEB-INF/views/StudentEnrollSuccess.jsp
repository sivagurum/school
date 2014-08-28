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
					<td>Student Id :</td>
					<td>${studentEnroll.id}</td>
				</tr>
				<tr>
					<td>Student Name :</td>
					<td>${studentEnroll.name}</td>
				</tr>
				<tr>
					<td>Student age :</td>
					<td>${studentEnroll.age}</td>
				</tr>
				<tr>
					<td>Student Address :</td>
					<td>${studentEnroll.address}</td>
				</tr>				
			</table>
		</div>
	</tiles:putAttribute>
</tiles:insertDefinition>