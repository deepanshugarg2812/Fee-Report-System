<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accountant</title>

<!-- Bootstrap including step -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="./resources/js/accountant.js" type="text/javascript"></script>

</head>
<body onload="oninitialize()">

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
	
	<img id="imgage" src="./resources/images/accountant3.jpeg" />

</body>
</html>