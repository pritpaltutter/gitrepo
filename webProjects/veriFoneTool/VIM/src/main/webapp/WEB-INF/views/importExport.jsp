<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="resources/css/importExport.css">


 <script>
$(document).ready(function(){
	
	
	
	
	
	
	
	
	/* ----------------------------Restore DB script-------------------------------- */
	 
	$("#restoreDB").click(function() {
	 
		
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
<div><h3>Select file to restore DB</h3></div>
    
 

<form action="UploadServlet" method="post"
                        enctype="multipart/form-data">
<input type="file" name="file" size="50" />
<br />

        <button id="restoreDB" type="button" class="btn btn-primary" disabled="disabled">Start Restore</button>
        <br>
        
        ----OR----
        <br>
        <button id="restoreDB" type="button" class="btn btn-primary" disabled="disabled">Start Backup</button>
		
</form>
		
  </div>
