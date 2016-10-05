<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" %>
<html >
<head>
<title>VIM</title>	

<script src="resources/js/jquery-2.1.1.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="resources/css/jquery-ui.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/home.css">
<link rel="stylesheet" href="resources/css/bootstrap-glyphicons.css">

<style type="text/css">

.container{
width: 100%;
height: 91%;

}

.footer {
	color: #F2F2F2;
	background: #00BFFF;
	border-top: 1px solid #000;
	width: 100%;
	}
	
	.aboveFooter{
	
	width: 100%;
	height: 10%;
	}
	
	.header {
	color: #F2F2F2;
	background: #00BFFF;
	padding: 17px 0 18px 0;
	border-top: 1px solid #000;
	height: 5%;
	width: 100%;
	}
	
	.link{
	color: #F2F2F2;
	 font-weight: bold;
	
	}
	
	.imageContainer{
   padding-left:84%;
   float: left;  
   height: 50%;
   width: 10%; 
	}
	


</style>
</head>
<body >

<script>



$(document).ready(function(){
	
	$("#searchTableContainer").hide();
	
	$("#loadAddEmployeePage").click(function() {
		
		$.ajax({
			url : "loadAddEmployeePage",
			type : "GET",
			data : "loadAddEmployeePage=loadAddEmployeePage", //Stringified Json Object
			success : function(data) {
				$("#dynamicPage").html(data);
			},
			error : function() {
				alert("error");
			},
			complete : function() {}
		});
	});
	
$("#loadDeleteEmployeePage").click(function() {
		
		$.ajax({
			url : "loadDeleteEmployeePage",
			type : "GET",
			data : "loadDeleteEmployeePage=loadDeleteEmployeePage", //Stringified Json Object
			success : function(data) {
				$("#dynamicPage").html(data);
			},
			error : function() {
				alert("error");
			},
			complete : function() {}
		});
	});
		
/* --------------------------------device script below------------------------------------------- */
		
$("#loadAddDevicePage").click(function() {
	
	$.ajax({
		url : "loadAddDevicePage",
		type : "GET",
		data : "loadAddDevicePage=loadAddDevicePage", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});

$("#loadUpdateDevicePage").click(function() {
	
	$.ajax({
		url : "loadUpdateDevicePage",
		type : "GET",
		data : "loadUpdateDevicePage=loadUpdateDevicePage", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});





$("#importExportPage").click(function() {
	
	$.ajax({
		url : "importExportPage",
		type : "GET",
		data : "importExportPage=importExportPage", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});


$("#adminEdit").click(function() {
	
	$.ajax({
		url : "adminEdit",
		type : "GET",
		data : "adminEdit=adminEdit", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});


$("#logIssue").click(function() {
	
	$.ajax({
		url : "adminEdit",
		type : "GET",
		data : "adminEdit=adminEdit", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});







/* --------------------------------store script below------------------------------------------- */


$("#loadStorePage").click(function() {
	
	$.ajax({
		url : "loadStorePage",
		type : "GET",
		data : "loadStorePage=loadStorePage", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});



/* --------------------------------	Assign device to employee script below------------------------------------------- */

$("#loadAssignDeviceToEmployeePage").click(function() {
	
	$.ajax({
		url : "loadAssignDeviceToEmployeePage",
		type : "GET",
		data : "loadAssignDeviceToEmployeePage=loadAssignDeviceToEmployeePage", //Stringified Json Object
		success : function(data) {
			$("#dynamicPage").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});


$("#loadSearchPage").click(function() {
	
	$.ajax({
		url : "loadSearchPage",
		type : "GET",
		data : "loadSearchPage=loadSearchPage", //Stringified Json Object
		success : function(data) {
			$("#maincontantContainer").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});


$("#loadHomePage").click(function() {
	alert("Loading Home Page");
	$.ajax({
		url : "loadHomePage",
		type : "GET",
		data : "loadHomePage=loadHomePage", //Stringified Json Object
		success : function(data) {
			$("#maincontantContainer").html("");
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});

$("#loadLoginPage").click(function() {
	
	$.ajax({
		url : "loadLoginPage",
		type : "GET",
		data : "loadLoginPage=loadLoginPage", //Stringified Json Object
		success : function(data) {
			$("#container").html(data);
		},
		error : function() {
			alert("error");
		},
		complete : function() {}
	});
});



});

</script>

<!-- CONTAINER DIV STARTS HERE  -->
<div class="container" id="container"> 

<!-- HEADER DIV STARTS HERE  -->
<div class="header" id="header">

        <a id="loadHomePage" class="link" href="#"
			style="border: solid 0px #e0e0e0"> Home</a>
			
		<a id="loadLoginPage" class="link" href="#"
			style= "padding-left:95% ; border: solid 0px #e0e0e0"> Logout</a>

</div>

<!-- MAIN CONTENT CONTAINER DIV STARTS HERE  -->
<div id="maincontantContainer" class="maincontantContainer">

<!-- LEFT MENU DIV STARTS HERE  -->
<div class="leftMenu" id="leftMenu">
        
        <a id="loadSearchPage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-search"> </span> Search 
        </a>
        <a id="loadAddEmployeePage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-user"> </span> Add Employee 
        </a>
         <a id="loadDeleteEmployeePage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-user"> </span> Delete Employee 
        </a>
         <a id="loadAddDevicePage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon glyphicon-phone"> </span> Add Device 
        </a>
         <a id="loadUpdateDevicePage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-edit"> </span> Edit Device Record 
        </a>
         
        <a id="loadAssignDeviceToEmployeePage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-user"> </span>
            <span class="glyphicon glyphicon-resize-horizontal"></span>
            <span class="glyphicon glyphicon glyphicon-phone"> </span>
             Assign Device to Employee 
        </a>
        <a id="importExportPage" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-transfer"> </span> Backup-Restore 
        </a>
        
        <a id="adminEdit" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-pencil"> </span> Admin Edit 
        </a>
        
         <a id="logIssue" href="#" class="list-group-item">
            <span class="glyphicon glyphicon-warning-sign"> </span> Log Issue 
        </a>
        
</div>

<!-- MAIN CONTENT DIV STARTS HERE  -->
<div class="mainContent" id="mainContent" >

<!-- TESTING BELOW  -->



<!-- THIS IS WHERE WE WILL INJECT OUR CONTENT ============================== -->
    <div id="dynamicPage"></div>
   
</div>



</div>

<!-- FOOTER DIV STARTS HERE  -->
<div class="aboveFooter" id="aboveFooter">
<div class="imageContainer">
 <img src="resources/images/verifone-logo.jpg" style="width:304px;height:60px; padding-left:0%;">
</div>
</div>

<div class="footer" id="footer">

</div>
 </div>

</body>
</html>
