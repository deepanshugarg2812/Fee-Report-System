<%@page import="com.main.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Student</title>

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

	ArrayList<Student> ar =(ArrayList)request.getAttribute("list");
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
		<h2 class="text-center my-5">View Student</h2>
		
		<% if(request.getAttribute("error")!=null) { %>
		<div class="container" style="margin:20">
			<h4 class="text-center"><%=request.getAttribute("error") %></h4>
		</div>
		<%}%>
		
		<div class="container" style="margin-top: 20">
			<table class="table table-dark">
			  <thead>
			    <tr>
			      <th scope="col">Id no</th>
			      <th scope="col">Name</th>
			      <th scope="col">Email</th>
			      <th scope="col">Gender</th>
			      <th scope="col">Course</th>
			      <th scope="col">Fee Total</th>
			      <th scope="col">Fee Paid</th>
			      <th scope="col">Fee due</th>
			      <th scope="col">Address</th>
			      <th scope="col">Phone</th>
			   	  <th scope="col">Update</th>
			      <th scope="col">Delete</th>
			    </tr>
			  </thead>
			  <tbody>
			<%
				for(int i=0;i<ar.size();i++){
					%>
						    <tr>
						      <td><%= ar.get(i).getId() %></td>
						      <td><%= ar.get(i).getName() %></td>
						      <td><%= ar.get(i).getEmail() %></td>
						      <td><%= ar.get(i).getGender() %></td>
						      <td><%= ar.get(i).getCourse() %></td>
						      <td><%= ar.get(i).getFeeTotal() %></td>
						      <td><%= ar.get(i).getFeePaid() %></td>
						      <td><%= ar.get(i).getFeeDue() %></td>
						      <td><%= ar.get(i).getAddress() %></td>
						      <td><%= ar.get(i).getPhone() %></td>
						      <td><button class="btn btn-primary"><a href="updatestudent?id=<%= ar.get(i).getId() %>" style="color: white;">Update</a></button></td>
						      <td><button class="btn btn-primary"><a href="deletestudent?id=<%= ar.get(i).getId() %>" style="color: white;">Delete</a></button></td>
						    </tr>
					<%
				}
			%>
			 </tbody>
			</table>
		</div>
	</div>

</body>
</html>