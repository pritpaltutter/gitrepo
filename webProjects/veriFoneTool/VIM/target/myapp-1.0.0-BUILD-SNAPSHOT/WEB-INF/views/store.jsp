
 <script>
$(document).ready(function(){
	

	 
	 $("#employeeNameSearch").autocomplete({
		
		source: function(request, response) { 
			
			 $.ajax({
				 
				 url: "getAllEmployeeNames",
				 contentType: "application/json; charset=utf-8",
				 dataType: "json",
				 
				 data: {
				 q: request.term
				 },
				 
				 success: function( data ) {
				 response( data );
				 },
				 
				 minLength: 3,
				 select: function(event, ui) {
				     $("#employeeNameSearch").val(ui.item.value);
				    }  
			 });
			 }
		}); 

	
});
</script>

<div  id="deleteEmployeeDiv" class="deleteEmployeeDiv" >
    <h3>Inventory Management System!</h3>
  
     	 <!-- USERNAME -->
		<div class="form-group" >
   			 <label>Employee Name</label>
   			  <!-- <input id="employeeNameSearch" />	 -->
   			 
   			<input type="text" name="employeeNameSearch"  class="form-control" placeholder="Enter Name"
   			 id="employeeNameSearch" ></input>
		</div>
		
        <button id="deleteEmployeeButton" type="button" class="btn btn-primary">Delete Employee</button>
		
  </div>
