

 <script>
$(document).ready(function(){
	
	
	
	/* -----------------------------disable when empty input ------------------------------------------------ */
	$('#employeeAndDeviceSearch').bind('input',function(){ 
        
	      if($("#employeeAndDeviceSearch").val() ) {
				$("#employeeAndDeviceSearchButton").prop('disabled', false);
				
		    }else {
		    	 if(!$("#employeeAndDeviceSearch").val() ) {		 
		    			$("#employeeAndDeviceSearchButton").prop('disabled', true);
		    	 }
		    }
	     });
	
	
	/* -----------------------------search the input value and populate in table --------------------------------- */
	
	/* -------------------------------------------------------------------------------------------------------------- */
	
	$("#employeeAndDeviceSearch").autocomplete({
		
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
	
	
	
});
</script>

<script type="text/javascript">

angular.module("myApp")
.controller("myController", function($scope) {
  
    $http.get("employeeAndDeviceSearch").
    success(function(data) {
        $scope.devices = data;
        
        alert("success");
    });

});
</script>

<div   id="employeeAndDeviceSearchDiv" class="employeeAndDeviceSearchDiv" style=" height: 100%; width: 100%; ">
  
     	 <!-- EMPLOYEE OR DEVICE SEARCH -->
	    <div id="searchInputAndButton" class="searchInputAndButton" style="  padding-left:5%; float:left; height: 30%; width: 50%; ">
	    
		<div style="padding-bottom:2%;">
		<input type="text"  class="form-control" name="employeeAndDeviceSearch"  placeholder="Enter Employee Name Or Device Name"
   			 id="employeeAndDeviceSearch" ></input>
		</div>
		
		<div style=" padding-bottom:10%; width: 50%">
		 <button id="employeeAndDeviceSearchButton" disabled="disabled"  type="button" class="btn btn-primary btn-lg btn-block">Search</button>
		</div>
		
		</div>
		
		
		<div data-ng-controller="myController" id="searchTableContainer" class="searchTableContainer table-responsive" style=" padding-left:5%; float:left; height: 100%; width: 100%; ">	
		
        <table  id="searchTable" class="table" data-ng-table >
                 <tr data-ng-repeat="device in devices">
            <td data-title="'Name'">{{device.deviceId}}</td>
            <td data-title="'Age'">{{device.deviceName}}</td>
            <td data-title="'Name'">{{device.partNumber}}</td>
            <td data-title="'Age'">{{device.serialNumber}}</td>
            <td data-title="'Name'">{{device.bondNumber}}</td>
            <td data-title="'Age'">{{device.remark}}</td>
            </tr>     
       </table>
		</div>
       
		
  </div>
