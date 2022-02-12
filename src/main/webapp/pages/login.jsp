<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
</head>
<body>
	<center>
		<h1>Learner's Academy</h1>
			<div class="container fluid">
		<div>
			<h4>Login Form</h4>
			<form action="/LearnersAcademyAdministrativePortal/login" class="was-validated">
				<div class="form-group">
					<label for="email">Username</label> <input type="text"
						class="form-control" id="email" name="username"
						placeholder="Enter your username" required />
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field</div>
				</div>
				<div class="form-group">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="Enter your password" required minlength="3" />
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Please fill out this field</div>
				</div>
				<div class="form-group form-check">
					<label class="form-check-label"></label><input type="checkbox"
						class="form-check-input" name="remember" required /> I agree
					terms and conditions.
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Check this checkbox to
						continue.</div>
				</div>
				<button type="submit" class="btn btn-primary">Login</button>
			</form>
			<hr />
		</div>
	</div>
	</center>
</body>
</html>