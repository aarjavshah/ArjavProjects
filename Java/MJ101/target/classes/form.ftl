<html>
<head><title>Welcome</title></head>
<body>
<h3>
<form action="/chooseColor" method="post">
<#list colors as color>
	<p>
		<input type="radio" name="color" value="${color}">${color}</input>
	</p>
</#list>
<input type="submit" name="submit" />
</form>
</body>
</html>