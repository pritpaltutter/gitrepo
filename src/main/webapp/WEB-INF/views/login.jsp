<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>VIM</title>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/login.css">

</head>
<body>

	<div class="col-sm-2 login" id="form">
		<h3>VeriFone Inventory Login</h3>

		<form:form name="userForm" method="post" action="login"
			commandName="login">

			<!-- USERNAME -->
			<div class="form-group">
				<label>Username</label>
				<form:input type="text" name="username" path="userName"
					class="form-control"></form:input>
				<form:errors path="userName" cssClass="error" />
			</div>

			<!-- PASSWORD -->
			<div class="form-group">
				<label>Password</label>
				<form:input type="password" path="password" name="password"
					class="form-control"></form:input>
				<form:errors path="password" cssClass="error" />
			</div>

			<button type="submit" class="btn btn-primary">Login</button>

		</form:form>
	</div>



	<!-- FOOTER DIV STARTS HERE  -->
	<div class="aboveFooter" id="aboveFooter">
		<div class="imageContainer">
			<img src="resources/images/verifone-logo.jpg"
				style="position: fixed; bottom: 0px; right: 0px; width: 17%; height: 8%;">
		</div>
	</div>

</body>
</html>