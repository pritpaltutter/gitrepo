<link rel="stylesheet" href="resources/css/assignDevToEmployee.css">
 <script>
$(document).ready(function(){ 
	
	
	/* keep selected device/employee label and value to perform operations */
	
	
	var selectedDeviceValue = "";
	var selectedEmployeeValue = "";
	
	/*-------------------------------------------------------------------  */
	
	$('#employeeNameSearch').bind('input',function(){ 
        
      if($("#employeeNameSearch").val() ) {
			if($("#deviceNameSearch").val() ) {
			$("#assignButton").prop('disabled', false);
			}
	    }else {
	    	 if(!$("#employeeNameSearch").val() ) {
	    		 
	    			$("#assignButton").prop('disabled', true);
	    	 }
	    }
     });
	
	$('#deviceNameSearch').bind('input',function(){ 
        
	      if($("#deviceNameSearch").val() ) {
				if($("#employeeNameSearch").val() ) {
				$("#assignButton").prop('disabled', false);
				}
		    }else {
		    	 if(!$("#deviceNameSearch").val() ) {
		    		 
		    			$("#assignButton").prop('disabled', true);
		    	 }
			}
	     });
	
	
	function enableAssignButton(){
		
		if($("#employeeNameSearch").val() ) {
			
			if($("#deviceNameSearch").val() ) {
				
			$("#assignButton").prop('disabled', false);
			
			}
	    }
	}
	

	/* ---------------------------------- Assign Dev to Employee search device --------------------------------- */

	$("#employeeNameSearch").autocomplete({
			
		source: function(request, response) { 
			
			 $.ajax({
				 
				 url: "getAllEmployeeNames",
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
				 }});},	 	 
				 minLength: 3,
				 select: function(event, ui) {
					 
					 $( this ).val(ui.item.label);
					 selectedEmployeeValue = ui.item.value;
					 selectedEmployeeLabel = ui.item.label;
					 enableAssignButton();
					 
					 return false;
				    },
				 open: function() {
				        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
				      },
				 close: function() {
				        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
				      }
			
				      
		}); 



	/* ----------------------------------  search device --------------------------------- */

	$("#deviceNameSearch").autocomplete({
			
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
					 }});},	 	 
					 minLength: 3,
					 select: function(event, ui) {
						 
						 $( this ).val(ui.item.label);
						 selectedDeviceValue = ui.item.value;
						 selectedDeviceLabel = ui.item.label;
						 
						 enableAssignButton();
						 
						 return false;
					    },
					 open: function() {
					        $( this ).removeClass( "ui-corner-all" ).addClass( "ui-corner-top" );
					      },
					 close: function() {
					        $( this ).removeClass( "ui-corner-top" ).addClass( "ui-corner-all" );
					      }
				
			}); 

	/* ----------------------------------  check device avalilibility  --------------------------------- */

	$("#checkAvailibilityLink").click(function() {
		 

		 var deviceNameToSearch = $("#deviceNameSearch").val();
		
			$.ajax({
				url : "checkDeviceAvailibity",
				type : "GET",
				data : "deviceNameToSearch="+deviceNameToSearch, //Stringified Json Object
				success : function(data) {
					var NumberOfFreeDevices = parseInt(data, 10);
					if(NumberOfFreeDevices > 0){
						$("#displayNumberOfFreeDeviceText").html(NumberOfFreeDevices + "Devices available in store");
						
					}else{
						$("#displayNumberOfFreeDeviceText").html("No devices available in store");
					}
				},
				error : function() {
					alert("error");
				},
				complete : function() {}
			}); 
		});

	/* ----------------------------------  Assign device   --------------------------------- */
	
	function assignDeviceToEmployee(){
		
		 var employeeAndDevice = selectedEmployeeValue+ ";" + selectedDeviceValue;
		 
			
			$.ajax({
				url : "assignDeviceToEmployee",
				type : "POST",
				data : "employeeAndDevice="+employeeAndDevice, //Stringified Json Object
				success : function(data) {
					$("#dynamicPage").html(data);
				},
				error : function() {
					alert("error");
				},
				complete : function() {}
			}); 
		
	}
	

	$("#assignButton").click(function() {
		
		 var deviceNameToSearch = $("#deviceNameSearch").val();
			
			$.ajax({
				url : "checkDeviceAvailibity",
				type : "GET",
				data : "deviceNameToSearch="+deviceNameToSearch, //Stringified Json Object
				success : function(data) {
					var NumberOfFreeDevices = parseInt(data, 10);
					if(NumberOfFreeDevices > 0){
						
						assignDeviceToEmployee();
						
					}else{
						$("#displayNumberOfFreeDeviceText").html( deviceNameToSearch +" is not available in store");
					}
				},
				error : function() {
					alert("error");
				},
				complete : function() {}
			}); 
		 
		
		});

});
</script>

<div  id="assignDeviceToEmployeeDiv" class="assignDeviceToEmployeeDiv" >
    
    <div class="headerText" id="headerText"><h3 >Assign Device To Employee!</h3></div> 
  
  
  <div class="topContent">
  <div class="leftContent" >
     	 <!-- USERNAME -->
		<div class="form-group leftContent-userSection" >
   			 <label>Employee Name</label>
   			  <!-- <input id="employeeNameSearch" />	 -->
   			 
   			<input type="text" name="employeeNameSearch"  class="form-control" placeholder="Enter Name"
   			 id="employeeNameSearch" ></input>
   			 
   			
		</div>
		</div>
		
		<div class="rightContent" >
		 <!-- DEVICE -->
		<div class="form-group rightContent-deviceSection" >
   			 <label>Device Name</label>   			 
   			<input type="text" name="deviceNameSearch"  class="form-control" placeholder="Enter Device Name"
   			 id="deviceNameSearch"></input>
		</div>
		<div class="rightContent-checkAvailibilitySection">
		
		 <a class="checkAvailibilityLink" id="checkAvailibilityLink" href="#"
			style="border: solid 0px #e0e0e0">Check Availibility</a>
		</div>
		</div>
		
	</div>	
	
	<div class="bottomContent">
	
	<div  id="displayNumberOfFreeDevice" class="displayNumberOfFreeDevice">
	<label class="col-lg-4" style="font-size: 153%;" id="displayNumberOfFreeDeviceText"></label>
	</div>
	
	 <div class="assignButtonDiv" >
   		 <button id="assignButton" type="button" class="btn btn-primary btn-lg btn-block" disabled="disabled">Assign</button>
   	 </div>
	</div>
        
		
  </div>
