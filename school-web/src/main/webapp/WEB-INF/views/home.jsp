<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:insertDefinition name="defaultTemplate">
	<tiles:putAttribute name="body">
		<div class="body">
			<h1>Home page !</h1>
 
            <p>The time on the server is ${serverTime}.</p>
            
            <p>This is Home Page</P>
		</div>
	</tiles:putAttribute>	
</tiles:insertDefinition>