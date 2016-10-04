
 <script>
$(document).ready(function(){
	

    $("#deleteEmployeeButton").click(function() {
		
		var empName = $("#employeeNameSearch").val();
		
		$.ajax({
			url : "deleteEmployee",
			type : "GET",
			data : "empName="+ empName, //Stringified Json Object
			success : function(data) {
				$("#dynamicPage").html(data);
			},
			error : function() {
				alert("error");
			},
			complete : function() {}
		});

	});	
	 
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



	
});
</script>

<div  id="deleteEmployeeDiv" class="deleteEmployeeDiv" >
    <h3>Delete Employee!</h3>
  
     	 <!-- USERNAME -->
		<div class="form-group" >
   			 <label>Employee Name</label>
   			 	 
   			<input type="text" name="employeeNameSearch"  class="form-control" placeholder="Enter Name"
   			 id="employeeNameSearch" ></input>
		</div>
		
        <button id="deleteEmployeeButton" type="button" class="btn btn-primary">Delete Employee</button>
  </div>
