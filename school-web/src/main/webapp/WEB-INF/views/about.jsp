<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
    	<div>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				Welcome : ${pageContext.request.userPrincipal} | <a
					href="<c:url value="j_spring_security_logout" />">Logout</a>
			</h2>
		</c:if>
		</div>

		<div class="body">
            <h1>About page !</h1>
 
            <p>This is a simple example of Tiles 3 integration with Spring Framework.</p>
            <p>Uses Tiles 3.0.3 and springframework 3.2.7.</P>
        </div>
 
 
 
    </tiles:putAttribute>
</tiles:insertDefinition>