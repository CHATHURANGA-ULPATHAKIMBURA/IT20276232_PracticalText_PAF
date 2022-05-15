$(document).ready(function()
{
		if ($("#alertSuccess").text().trim() == "")
		{
 				$("#alertSuccess").hide();
 		}
 		$("#alertError").hide();
});


$(document).on("click", "#reCus", function(event)
{	 
	window.location.href="RegisteredCusromers.jsp";
});


$(document).on("click", "#ViewUser", function(event)
{	 
	window.location.href="ViweAllUser.jsp";
});


$(document).on("click", "#adUser", function(event)
{	 
	 var fullName = $(this).closest("tr").find('td:eq(1)').text();
	 var address = $(this).closest("tr").find('td:eq(2)').text();
	 var city = $(this).closest("tr").find('td:eq(3)').text();
	 var mobileNumber = $(this).closest("tr").find('td:eq(4)').text();
	 var email = $(this).closest("tr").find('td:eq(5)').text();

	 localStorage.setItem("fullName", fullName);
	 localStorage.setItem("address", address);
	 localStorage.setItem("city", city);
	 localStorage.setItem("mobileNumber", mobileNumber);
	 localStorage.setItem("email", email);
	 
	window.location.href="AddUsers.jsp";
});

//Get Customer View============================================
function registerdCus(){
	$.ajax(
 	{
 		url : "http://localhost:8080/IT20276232_PracticalTest_PAF/ElectroG/UserAssing/Pending",
 		type : "GET",
 		dataType : "text",
 		complete : function(response, status)
 		{
 				onGetCusCompleat(response.responseText, status);
 		}
 	});
}

//Get user View============================================
function viewAll(){
	$.ajax(
 	{
 		url : "http://localhost:8080/IT20276232_PracticalTest_PAF/ElectroG/UserAssing/",
 		type : "GET",
 		dataType : "text",
 		complete : function(response, status)
 		{
 				onGetuserCompleat(response.responseText, status);
 		}
 	});
}


//Get data============================================
function getdataUser(){

	var fullName = localStorage.getItem("fullName");
	var address = localStorage.getItem("address");
	var city = localStorage.getItem("city");
	var mobileNumber = localStorage.getItem("mobileNumber");
	var email = localStorage.getItem("email");
	
	$(".FullName").val(fullName);
	$(".Address").val(address); 
	$(".City").val(city); 
	$(".MobileNumber").val(mobileNumber); 
	$(".Email").val(email); 
}

//Insert data============================================
$(document).on("click", "#addusers", function(event)
{
// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
	 
	// Form validation-------------------
	var status = validateFormadd(); 
	if (status != true) { 
		 $("#alertError").text(status); 
		 $("#alertError").show(); 
		 return; 
	} 
	
	// If valid------------------------
	$.ajax(
 	{
 		url : "http://localhost:8080/IT20276232_PracticalTest_PAF/ElectroG/UserAssing/Add",
 		type : "POST",
 		data : $("#userAddForms").serialize(),  
 		dataType : "text",
 		complete : function(response, status)
 		{
 				onAddGetCompleat(response.responseText, status);
 		}
 	});
});


//Delete =============================================
$(document).on("click", ".delUser", function(event)
{	
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 

	 var del = "<UserData><CustomersID>"+$(this).closest("tr").find('td:eq(0)').text()+"</CustomersID></UserData>"
	$.ajax(
 	{
 		url : "http://localhost:8080/IT20276232_PracticalTest_PAF/ElectroG/UserAssing/Pending/Delete",
 		type : "Delete",
 		data : del,   
 		contentType: "application/xml",  
 		dataType : "text",
 		complete : function(response, status)
 		{
 				onuserdeleteCompleat(response.responseText, status);
 		}
 	});
});


$(document).on("click", "#upuser", function(event)
{	 
	 var userId = $(this).closest("tr").find('td:eq(1)').text();
	 var fullname = $(this).closest("tr").find('td:eq(2)').text();
	 var city = $(this).closest("tr").find('td:eq(4)').text();
	 var powerplant = $(this).closest("tr").find('td:eq(7)').text();
	 
	 localStorage.setItem("userId", userId);
	 localStorage.setItem("fullName", fullname);
	 localStorage.setItem("city", city);
	 localStorage.setItem("powerplant", powerplant);
	 
	window.location.href="userUpdate.jsp";
});

function getUserDataa(){
	
	var fullName = localStorage.getItem("fullName");
	var userId = localStorage.getItem("userId");
	var city = localStorage.getItem("city");
	var powerplant = localStorage.getItem("powerplant");
	
	$(".FullName").val(fullName);
	$(".UserID").val(userId);
	$(".City").val(city); 
	$(".PowerPalnt").val(powerplant); 
}

$(document).on("click", "#upuserr", function(event)
{
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 
	 
	// Form validation-------------------
	var status = validateFormup(); 
	if (status != true) { 
		 $("#alertError").text(status); 
		 $("#alertError").show(); 
		 return; 
	} 
	
	// If valid------------------------
	var data = "{'UserID':'"+$(".UserID").val()+"', 'PowerPalnt':'"+$(".PowerPalnt").val()+"'}";
	$.ajax(
 	{
 		url : "http://localhost:8080/IT20276232_PracticalTest_PAF/ElectroG/UserAssing/Update",
 		type : "PUT",
 		contentType: "application/json",  
 		data : data,  
 		dataType : "text",
 		complete : function(response, status)
 		{
 				onUpGetCompleat(response.responseText, status);
 		}
 	});
});


function validateFormadd() { 
	
	if ($("#UserID").val().trim() == "") { 
		return "Insert User ID."; 	
	}

	if ($("#Password").val().trim() == "") { 
		return "Insert Password."; 	
	}
	
	if ($("#PowerPalnt").val().trim() == "") { 
		return "Insert PowerPalnt."; 	
	}
	
	return true; 
}

function validateFormup() { 
	
	if ($("#UserID").val().trim() == "") { 
		return "Insert User ID."; 	
	}
	
	if ($("#PowerPalnt").val().trim() == "") { 
		return "Insert PowerPalnt."; 	
	}
	
	return true; 
}

function onGetCusCompleat(response, status)
{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 
 			if (resultSet.status.trim() == "success")
 			{
 					$("#alertSuccess").text("Successfully Read.");
 					$("#alertSuccess").show();
 
 					$("#regiCus").html(resultSet.data);
 			} else if (resultSet.status.trim() == "error")
 			{
 					$("#alertError").text(resultSet.data);
 					$("#alertError").show();
 			}
 
 		} else if (status == "error")
 		{
 			$("#alertError").text("Error while reading the item.");
 			$("#alertError").show();
 		} else
 		{
 			$("#alertError").text("Unknown error while reading..");
 			$("#alertError").show();
 		} 
 		
 		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}


function onAddGetCompleat(response, status)
{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 
 			if (resultSet.status.trim() == "success")
 			{
 					$("#alertSuccess").text("Successfully Add.");
 					$("#alertSuccess").show();
 
 					$("#billView").html(resultSet.data);
 			} else if (resultSet.status.trim() == "Error while Create User")
 			{
 					$("#alertError").text("Error while Create User");
 					$("#alertError").show();
 			}
 
 		} else if (status == "error")
 		{
 			$("#alertError").text("Error while Add the item.");
 			$("#alertError").show();
 		} else
 		{
 			$("#alertError").text("Unknown error while Add..");
 			$("#alertError").show();
 		} 
 		
 		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}



function onuserdeleteCompleat(response, status)
{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);

 			if (resultSet.status.trim() == "success")
 			{
 					$("#alertSuccess").text("Successfully Delete.");
 					$("#alertSuccess").show();
 
 					$("#lostView").html(resultSet.data);
 			} else if (resultSet.status.trim() == "Error while Delete")
 			{
 					$("#alertError").text("Error while Delete");
 					$("#alertError").show();
 			}
 
 		} else if (status == "error")
 		{
 			$("#alertError").text("Error while Deleting the item.");
 			$("#alertError").show();
 		} else
 		{
 			$("#alertError").text("Unknown error while Deleting..");
 			$("#alertError").show();
 		} 
 		
 		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}


function onGetuserCompleat(response, status)
{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 
 			if (resultSet.status.trim() == "success")
 			{
 					$("#alertSuccess").text("Successfully Read.");
 					$("#alertSuccess").show();
 
 					$("#VAll").html(resultSet.data);
 			} else if (resultSet.status.trim() == "error")
 			{
 					$("#alertError").text(resultSet.data);
 					$("#alertError").show();
 			}
 
 		} else if (status == "error")
 		{
 			$("#alertError").text("Error while reading the item.");
 			$("#alertError").show();
 		} else
 		{
 			$("#alertError").text("Unknown error while reading..");
 			$("#alertError").show();
 		} 
 		
 		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}

function onUpGetCompleat(response, status)
{
		if (status == "success")
 		{
 			var resultSet = JSON.parse(response);
 
 			if (resultSet.status.trim() == "success")
 			{
 					$("#alertSuccess").text("Successfully Update.");
 					$("#alertSuccess").show();
 
 					$("#VAll").html(resultSet.data);
 			} else if (resultSet.status.trim() == "Error while Update User")
 			{
 					$("#alertError").text("Error while Update User");
 					$("#alertError").show();
 			}
 
 		} else if (status == "error")
 		{
 			$("#alertError").text("Error while reading the item.");
 			$("#alertError").show();
 		} else
 		{
 			$("#alertError").text("Unknown error while reading..");
 			$("#alertError").show();
 		} 
 		
 		$("#hidItemIDSave").val("");
 		$("#formItem")[0].reset();
}
