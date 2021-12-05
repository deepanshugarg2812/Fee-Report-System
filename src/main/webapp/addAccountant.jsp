<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Accountant</title>

<!-- Bootstrap including step -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>

<%
	if(session.getAttribute("userid")==null){
		response.sendRedirect("index.jsp");
	}
%>
	
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
	  <a class="navbar-brand" href="#">Fee Report</a>
	  <div class="collapse navbar-collapse">
	    <ul class="navbar-nav ml-auto">
		    <li class="nav-item active">
		        <a class="nav-link" href="admin.jsp">Home</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="addAccountant.jsp">Add Accountant</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="viewAccountant.jsp">View Accountant</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="logoutusers">Logout</a>
		      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container" style="margin-top: 10">
		<div class="text-center">
			<h2>Add Accountant</h2>
		</div>
		<form method="post" action="addaccountant">
			<div class="form-group">
				<input type="text" name="userid" placeholder="Enter the user id" class="form-control">
			</div>
			
			<div class="form-group">
				<input type="text" name="username" placeholder="Enter the username" class="form-control">
			</div>
			
			<div class="form-group">
				<input type="password" name="password" placeholder="Enter the password" class="form-control">
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Add Accountant</button>
			</div>
		</form>
	</div>
	
</body>
</html>