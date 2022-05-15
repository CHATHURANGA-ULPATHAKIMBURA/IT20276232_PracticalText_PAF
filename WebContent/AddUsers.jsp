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
<body onload="getdataUser()">

<br>
<h1 class="companiName">Electro Gird (PVT)Ltd</h1>
<h2 class="companiName">Add Customers Details</h2><br><br>

		<div id="alertSuccess" class="container alert alert-success"></div><br>
		<div id="alertError" class="container alert alert-danger"></div>
	
<div class="aCalculatBillForm">		
<form id="userAddForms">
 
  <div class="row justify-content-between text-left CalculatBillForm" >
    <div class="colum1">
  
	    <div class="mb-3">
	      <label for="disabledTextInput" class="form-label">User ID :</label>
	      <input type="text" id="UserID" name="UserID" class="UserID form-control">
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Full name :</label>
	      <input type="text" id="FullName" name="FullName" class="FullName form-control" disabled>
	      <input type="hidden" id="FullName" name="FullName" class="FullName form-control" >
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Address :</label>
	      <input type="text" id="Address" name="Address" class="Address form-control" disabled>
	      <input type="hidden" id="Address" name="Address" class="Address form-control" >
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">City :</label>
	      <input type="text" id="City" name="City" class="City form-control" disabled>
	      <input type="hidden" id="City" name="City" class="City form-control" >
	    </div>
    </div>
      

    <div class="colum2">
    	<div class="mb-3">
	      <label for="disabledSelect" class="form-label">Mobile Number :</label>
	      <input type="text" id="MobileNumber" name="MobileNumber" class="MobileNumber form-control" disabled>
	      <input type="hidden" id="MobileNumber" name="MobileNumber" class="MobileNumber form-control" >
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Email :</label>
	      <input type="text" id="Email" name="Email" class="Email form-control" disabled>
	      <input type="hidden" id="Email" name="Email" class="Email form-control" >
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Password :</label>
	      <input type="text" id="Password" name="Password" class="Password form-control">
	    </div>
	    <div class="mb-3">
	      <label for="disabledSelect" class="form-label">Power Plant :</label>
	      <input type="text" id="PowerPalnt" name="PowerPalnt" class="PowerPalnt form-control" >
	    </div>
    </div>
</div>
 
<input type="button" id="addusers" name="addusers" value="Add User" class="addusers btn btn-primary BilBut">
</form><br>
</div>	

</body>
</html>