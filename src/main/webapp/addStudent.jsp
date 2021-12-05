<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>

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
		        <a class="nav-link" href="accountant.jsp">Home</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="addStudent.jsp">Add Student</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="viewstudents">View Student</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="#">Update Student</a>
		      </li>
		      <li class="nav-item active">
		        <a class="nav-link" href="logoutusers">Logout</a>
		      </li>
	    </ul>
	  </div>
	</nav>
	
	<div class="container" style="margin-top : 20">
		<h2 class="text-center my-5">Add Student</h2>
		
		<% if(request.getAttribute("error")!=null) { %>
		<div class="container" style="margin:20">
			<h4 class="text-center"><%=request.getAttribute("error") %></h4>
		</div>
		<%}%>
		
		<form method="post" action="addstudent">
			<div class="form-group">
			<label>Name</label>
				<input type="text" id="name" placeholder="Enter the name of student" name="name" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Email</label>
				<input type="email" placeholder="Enter the email of student" name="email" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Gender</label>
				<div class="custom-control custom-radio">
				  <input type="radio" id="customRadio1" name="customRadio" value="male" class="custom-control-input">
				  <label class="custom-control-label" for="customRadio1">Male</label>
				</div>
				<div class="custom-control custom-radio">
				  <input type="radio" id="customRadio2" name="customRadio" value="female" class="custom-control-input">
				  <label class="custom-control-label" for="customRadio2">Female</label>
				</div>
			</div>
			
			<div class="form-group">
				<label>Course</label>
				<select class="custom-select" name="course">
				  <option value="Java" selected>Java</option>
				  <option value="C++">C++</option>
				  <option value="Operating system">Operating system</option>
				  <option value="Data structures">Data structures</option>
				</select>
			</div>
			
			<div class="form-group">
			<label>Fee total</label>
				<input type="text" placeholder="Enter the total fee" name="fee" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Fee Paid</label>
				<input type="text" placeholder="Enter the total fee paid" name="paid" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Fee due</label>
				<input type="text" placeholder="Enter the total fee due" name="due" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Address</label>
				<input type="text" placeholder="Enter the address" name="address" class="form-control">
			</div>
			
			<div class="form-group">
			<label>Phone number</label>
				<input type="text" placeholder="Enter the phone number" name="phone" class="form-control">
			</div>
			
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Add student</button>
			</div>
		</form>
	</div>

</body>
</html>