$(document).ready(function()
{
	$("#alertSuccess").hide();
	$("#alertError").hide();
});

//SAVE ============================================
$(document).on("click", "#btnSave", function(event)
{
	// Clear alerts---------------------
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	// Form validation-------------------
	var status = validateItemForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT";

	$.ajax(
	{
		url : "SceduleAPI",
		type : type,
		data : $("#formSchedule").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			 onItemSaveComplete(response.responseText, status);
			 //console.log("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		}
	});
});


function onItemSaveComplete(response, status)
{
	// console.log("Ffffffffffffffffffffffffffffffffffffff");
	
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
 
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divScheduleGrid1").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while saving.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while saving..");
		$("#alertError").show();
	}
	$("#hidItemIDSave").val("");
	$("#formSchedule")[0].reset();
}

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());
	$("#Date").val($(this).closest("tr").find('td:eq(0)').text());
	$("#Start_Time").val($(this).closest("tr").find('td:eq(1)').text());
	$("#End_Time").val($(this).closest("tr").find('td:eq(2)').text());
	$("#D_id").val($(this).closest("tr").find('td:eq(3)').text());
	$("#H_id").val($(this).closest("tr").find('td:eq(4)').text());
	$("#App_id").val($(this).closest("tr").find('td:eq(5)').text());
	
}); 

//REMOVE==========================================
$(document).on("click", ".btnRemove", function(event)
		{console.log("Schedule_id =" + $(this).data("itemid"))
		 $.ajax(
		 {
		 url : "SceduleAPI",
		 type : "DELETE",
		 data : "Schedule_id =" + $(this).data("itemid"),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onItemDeleteComplete1(response.responseText, status);
		 }
		 
		 });
		});

function onItemDeleteComplete1(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divScheduleGrid1").html(resultSet.data);
		} else if (resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error")
	{
		$("#alertError").text("Error while deleting.");
		$("#alertError").show();
	} else
	{
		$("#alertError").text("Unknown error while deleting..");
		$("#alertError").show();
	}
}

//CLIENT-MODEL================================================================
function validateItemForm()
{
	//day of the week
	if ($("#Date").val().trim() == "")
	{
		return " Please select A day";
	}
	
	//schedule start time
	if ($("#Start_Time").val().trim() == "")
	{
		return " Please select A Time";
	}
	
	//schedule end time
	if ($("#End_Time").val().trim() == "")
	{
		return " Please select A correct Time";
	}
	
	//Doctor ID
	if ($("#D_id").val().trim() == "")
	{
		return " Please enter Doctor ID";
	}
	
	//Hospital ID
	if ($("#H_id").val().trim() == "")
	{
		return " Please enter Hospitl ID";
	}
	
	
	//Appointment Type ID
	if ($("#App_id").val().trim() == "")
	{
		return "Insert Appointment ID.";
	}
	
	return true;
}















