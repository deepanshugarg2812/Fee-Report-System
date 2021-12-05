<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<!-- Bootstrap including step -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>

<%
	if(session.getAttribute("usertype")!=null){
		response.sendRedirect(session.getAttribute("usertype")+".jsp");
	}
%>

	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" style="color: white;">Fee Report</a>
		<div>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item" style="color: white;"><a class="nav-link" href="index.jsp">Home</a></li>
			</ul>
		</div>
	</nav>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-5 m-1">
				<h2 class="text-center">
					Admin Login
				</h2>
				
				<form method="post" action="loginadmin">
					<div class="form-group">
						<input type="text" class="form-control my-1" name="username" placeholder="Enter username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control my-1" name="password" placeholder="Enter password">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
			
			
			
			<div class="col-5 offset-2 m-1">
				<h2 class="text-center">
					Accountant Login
				</h2>
				
				<form method="post" action="loginaccountant">
					<div class="form-group">
						<input type="text" class="form-control my-1" name="username" placeholder="Enter username">
					</div>
					<div class="form-group">
						<input type="password" class="form-control my-1" name="password" placeholder="Enter password">
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>