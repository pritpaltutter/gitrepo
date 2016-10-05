<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <script src="//code.jquery.com/jquery-1.10.2.js"></script>
 <script>
$(document).ready(function(){
	
	$("#addEmployeeButton").click(function() {
		
		var empName = $("#addEmployeeName").val();
		var cubNumber = $("#addEmployeeCubNumber").val();
		var employeeNameAndCubNumber = empName + ";" + cubNumber ;
		
		$.ajax({
			url : "addEmployee",
			type : "POST",
			data : "employeeNameAndCubNumber="+ employeeNameAndCubNumber, //Stringified Json Object
			success : function(data) {
				$("#dynamicPage").html(data);
			},
			error : function() {
				alert("error");
			},
			complete : function() {}
		});

	});	
	
});
</script>

<div  id="addEmployeeDiv" class="addEmployeeDiv" >
    <h3>Inventory Management System!</h3>
  
     	 <!-- USERNAME -->
		<div class="form-group" >
   			 <label>Employee Name</label>
   			 <input type="text" name="employeeName"  class="form-control" placeholder="Enter Name"
   			 id="addEmployeeName" ></input>
   			
		</div>
		
		 <!-- CUBICAL NUMBER -->
		<div class="form-group" >
   			 <label>Cubical Number</label>
   			 <input type="text"  name="employeeCubicalNumber" class="form-control" placeholder="Enter Cubical Number"
   			 id="addEmployeeCubNumber" ></input>
		</div>
        
        <button id="addEmployeeButton" type="button" class="btn btn-primary">Add Employee</button>
		
  </div>
