
<script src="resources/js/jquery-2.1.1.js"></script>
<script src="resources/js/jquery-ui.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.26/angular.min.js"></script>
<style>

table tr th {
  width: 25%;
}
</style>
<script>


function myController($scope,$http) {
    $scope.name = "";
    $scope.typeValue = "";
    $scope.myvalue = false;
   
    
    if($scope.name ==""){
		
    	 $scope.devices = "";
	}
   
    
    $scope.test = function(){
    	
    	var name = $scope.name;
    	var type = $scope.typeValue;
    	
    	if(type==""){
    		
    		type = "employee";
    	}
    	
    	$http.post("employeeAndDeviceSearch/"+type+"/"+name, name).
    	  success(function(data, status, headers, config) {
    		  
    		  $scope.devices = data;
    		  $scope.myvalue = true;
    		 
    		 	
    	  }).
    	  error(function(data, status, headers, config) {
    		  
    	  });
    };
  
}  

$(document).ready(function(){ 
	
	
	$("#deviceTable").hide();
	
	$('#employeeNameSearch').bind('input',function(){ 
        
	      if($("#employeeNameSearch").val() ) {
				$("#searchButton").prop('disabled', false);  
				$("#deviceTable").show();
				
		    }else {
		    	 if(!$("#employeeNameSearch").val() ) {		 
		    			$("#searchButton").prop('disabled', true);
		    			$("#deviceTable").hide();
		    			
		    	 }
		    }
	      
	     });
	
});


</script>

<div data-ng-app="" data-ng-controller="myController">

<label>Search Employee/Device :</label> 
<input style="width:20%;" id="employeeNameSearch" name="employeeNameSearch"  class="form-control" placeholder="Enter Employee/Device Name" type="text" data-ng-model="name"><br>


<button type="button" class="btn btn-primary" data-ng-click="test()"  disabled="disabled" id="searchButton">Search</button>
<input  id="employeeRadio" type="radio" data-ng-model="typeValue"  value="employee" >Employee
<input id="deviceRadio" type="radio" data-ng-model="typeValue"   value="device">Device

<div id="tableContainer" style="padding-top:03%;  width: 90%; " data-ng-show="myvalue">

<table id="deviceTable" class="table table-condensed table-bordered table-striped table-hover responsive" hidden="true">
<thead>
    <tr>
      <th class="col-sm-1">Device Id</th>
      <th class="col-md-2">Device Name</th>
      <th class="col-md-2">Part Number</th>
      <th class="col-md-2">Serial Number</th>
      <th class="col-md-2">Bond Number</th>
      <th class="col-md-2">Bond Date</th>
      <th class="col-md-2">Remarks</th>
      <th class="col-sm-1">Working</th>
    </tr>
  </thead>
 <tbody>
    <tr data-ng-repeat="device in devices">
        <td >{{device.deviceId}}</td>
        <td >{{device.deviceName}}</td>
        <td >{{device.partNumber}}</td>
        <td >{{device.serialNumber}}</td>
        <td >{{device.bondNumber}}</td>
        <td >{{device.bondDate}}</td>
        <td >{{device.remark}}</td>
        <td >{{device.work}}</td>
    </tr>
    </tbody>
</table>

</div>
</div >


