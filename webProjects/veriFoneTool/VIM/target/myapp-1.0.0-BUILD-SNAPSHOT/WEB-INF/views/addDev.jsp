
<style>

.addDeviceDiv{
	
   padding-top:0%;
   padding-left:50%;
   float: left;  
   height: 90%;
   width: 110%; 
	
}

</style>
 
 <script>
$(document).ready(function(){
	
	$("#addDeviceButton").click(function() {
		
		var deviceName = $("#deviceName").val();
		var partName = $("#partName").val();
		var serialNumber = $("#serialNumber").val();
		var bondNumber = $("#bondNumber").val();
		var bondDate = $("#bondDate").val();
		var remark = $("#remark").val();
		var additionalDescription = $("#additionalDescription").val();
		
		
		var deviceInfo = deviceName + ";" + partName + ";" + serialNumber + ";" + bondNumber + ";" + bondDate + ";" + remark +
		";" + additionalDescription ;
		
		$.ajax({
			url : "addDevice",
			type : "POST",
			data : "deviceInfo="+ deviceInfo, //Stringified Json Object
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

<div  id="addDeviceDiv" class="addDeviceDiv" style="padding-left:10%;" >
<div class="addDeviceDivLeftDiv">
    <h3>Add device In Store!</h3>
  
     	 <!-- DEVICE NAME -->
		<div class="form-group " >
   			 <label>Device Name</label>
   			 <input type="text" name="deviceName"   class="form-control" style="width: 25%;" placeholder="Device Name"
   			 id="deviceName"></input>
   			
		</div>
		
		<!-- PART NAME -->
		<div class="form-group" >
   			 <label>Part Name</label>
   			 <input type="text" name="partName"  class="form-control"  style="width: 25%;" placeholder="Part Name"
   			 id="partName" ></input>
   			
		</div>
		
		<!-- serial Number -->
		<div class="form-group" >
   			 <label>Serial Number</label>
   			 <input type="text" name="serialNumber"  class="form-control"  style="width: 25%;" placeholder="Serial Number"
   			 id="serialNumber" ></input>
   			
		</div>
		
		<!-- bondNumber -->
		<div class="form-group" >
   			 <label>Bond Number</label>
   			 <input type="text" name="bondNumber"  class="form-control"  style="width: 25%;" placeholder="Bond Number"
   			 id="bondNumber" ></input>
   			
		</div>
		
		<!-- bondDate -->
		<div class="form-group" >
   			 <label>Bond Date</label>
   			 <input type="text" name="bondDate"  class="form-control"  style="width: 25%;" placeholder="Bond Date"
   			 id="bondDate" ></input>
   			
		</div>
		
		<!-- remark -->
		<div class="form-group" >
   			 <label>Remarks</label>
   			 <input type="text" name="remark"  class="form-control"  style="width: 25%;" placeholder="Remarks"
   			 id="remark" ></input>
   			
		</div>
		
		<!-- additionalDescription -->
		<div class="form-group" >
   			 <label>Additional Description</label>
   			 <input type="text" name="additionalDescription"  class="form-control"  style="width: 25%;" placeholder="Additional Description"
   			 id="additionalDescription" ></input>
   			
		</div>
		
        
        <button id="addDeviceButton" type="button" class="btn btn-primary">Add Device</button>
		</div>
  </div>
