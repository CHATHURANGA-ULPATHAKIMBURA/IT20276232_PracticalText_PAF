<%@ 
	page language="java" contentType="text/html; charset=ISO-8859-1"
    	pageEncoding="ISO-8859-1"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/UserAssign.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/UserAssign.js"></script>
<title>User Assign Management</title>
</head>
<body onload="registerdCus()">

<br>
<h1 class="companiName">Electro Gird (PVT)Ltd</h1>
<h2 class="companiName">Registered Customers Details</h2><br><br>

		<div id="alertSuccess" class="container alert alert-success"></div><br>
		<div id="alertError" class="container alert alert-danger"></div>
		
		<div id="regiCus" class="regiCus">
		</div>
</body>
</html>