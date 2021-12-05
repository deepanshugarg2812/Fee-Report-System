<%@page import="com.main.Accountant"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Bean for the accountants -->    
<jsp:useBean id="obj" class="com.main.ViewAccountant" scope="page"></jsp:useBean>

<% obj.getConnection(application); %>

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

	//Call method to store the total count in count var
	obj.getNoOfPages();
	
	ArrayList<Accountant> ar = obj.getAccountant();
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
		
	<div class="container" style="margin-top: 20">
		<h1 class="text-center">Accountant List</h1>
	</div>
	
	<div class="container" style="margin-top: 20">
	<table class="table table-dark">
	  <thead>
	    <tr>
	      <th scope="col">Sr no</th>
	      <th scope="col">Accountant Id</th>
	      <th scope="col">Username</th>
	    </tr>
	  </thead>
	  <tbody>
	<%
		for(int i=0;i<ar.size();i++){
			%>
				    <tr>
				      <th scope="row"><%= i %></th>
				      <td><%= ar.get(i).accountantId %></td>
				      <td><%= ar.get(i).accountantUsername %></td>
				    </tr>
			<%
		}
	%>
	 </tbody>
	</table>
	</div>

</body>
</html>