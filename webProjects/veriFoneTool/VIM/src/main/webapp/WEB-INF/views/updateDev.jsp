<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="resources/css/updateDev.css">


 <script>
$(document).ready(function(){
	
	var selectedDeviceValue = "";
	
	 $("#deviceSerialNumber").autocomplete({
		
		source: function(request, response) { 
			
			 $.ajax({
				 
				 url: "getAllDeviceNames",
				 contentType: "application/json; charset=utf-8",
				 dataType: "json",
				 
				 data: {
					 term: request.term
				 },
				 
				 success: function( data ) {
                response($.map(data, function (item) {
                    return {
                        label:item.label,
                        value:item.value
                    };
                }));
				 }});
			 },	 	 
				 minLength: 1,
				 select: function(event, ui) {
					 
					 $( this ).val(ui.item.label);
					 selectedDeviceValue = ui.item.value;
					 selectedDeviceLabel = ui.item.label;
					 
					 enableDeleteButton();
					 
					 return false;
				    }
		});  
	
	
	
	/* -----------------------------disable button script-------------------------------------------------- */
	
/* 
	$('#deviceSerialNumber').bind('input',function(){ 
        
	      if($("#deviceSerialNumber").val() ) {	
			$("#deleteDeviceButton").prop('disabled', false);
				
		    }else {
		    	 if(!$("#deviceSerialNumber").val() ) {
		    			$("#deleteDeviceButton").prop('disabled', true);
		    	 }
		    }
	     }); */
	
	
	
	
	/* ----------------------------delete device script-------------------------------- */
	 
	$("#deleteDeviceButton").click(function() {
	 
		
	  var deviceNameToSearch = selectedDeviceValue;
	
		$.ajax({
			url : "deleteDevice",
			type : "GET",
			data : "deviceNameToSearch="+deviceNameToSearch, //Stringified Json Object
			success : function(data) {
				
			},
			error : function() {
				alert("error");
			},
			complete : function() {}
		});  
	});
	
	
	/* ----------------------------------  search device --------------------------------- */
	

function enableDeleteButton(){
		
		if($("#deviceSerialNumber").val() ) {
					
			$("#deleteDeviceButton").prop('disabled', false);
	    }
	}
	
});
</script>

<div  id="deleteDeviceDiv" class="deleteDeviceDiv" >
<div><h3>Update Device!</h3></div>
    
  
     	 <!-- Device Name -->
		<div class="form-group" >
   			 <label>Enter Device Serial Number</label>
   		
   			 
   			<input type="text"   class="form-control" placeholder="Enter Device Name"
   			 id="deviceSerialNumber" ></input>
		</div>
		
        <button id="deleteDeviceButton" type="button" class="btn btn-primary" disabled="disabled">Update Device</button>
		
  </div>
