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
	var status = validateTypeForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}

	// If valid------------------------
	var type = ($("#hidtypeIDSave").val() == "") ? "POST" : "PUT";

	$.ajax(
	{
		url : "TypeAPI",
		type : type,
		data : $("#formtype").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			 onApptypeSaveComplete(response.responseText, status);
		}
	});
});


function onApptypeSaveComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
 
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divtypeGrid").html(resultSet.data);
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
	$("#hidtypeIDSave").val("");
	$("#formtype")[0].reset();
}

//UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
{
	$("#hidtypeIDSave").val($(this).closest("tr").find('#hidtypeIDUpdate').val());
	$("#Appointment_Type").val($(this).closest("tr").find('td:eq(0)').text());
	$("#Appointment_Name").val($(this).closest("tr").find('td:eq(1)').text());
	$("#Appointment_Desc").val($(this).closest("tr").find('td:eq(2)').text());
	
}); 

//REMOVE==========================================
$(document).on("click", ".btnRemove", function(event)
		{
		 $.ajax(
		 {
		 url : "TypeAPI",
		 type : "DELETE",
		 data : "appointment_Id =" + $(this).data("typeid"),
		 dataType : "text",
		 complete : function(response, status)
		 {
		 onAppTypeDeleteComplete(response.responseText, status);
		 }
		 });
		});

function onAppTypeDeleteComplete(response, status)
{
	if (status == "success")
	{
		var resultSet = JSON.parse(response);
		if (resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully deleted.");
			$("#alertSuccess").show();
			$("#divtypeGrid").html(resultSet.data);
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
function validateTypeForm()
{
	//APPOINTMENT TYPE
	if ($("#Appointment_Type").val().trim() == "")
	{
		return "Insert Appointment Type.";
	}
	
	
	// cannot be only numerical value
	var tmptype = $("#Appointment_Type").val().trim();
	if ($.isNumeric(tmptype))
	{
		return "Only Numerical values NotAllowed.";
	}
	

	//APPOINTMENT NAME
	if ($("#Appointment_Name").val().trim() == "")
	{
		return "Insert Appointment Name.";
	}
	
	// cannot be only numerical value
	var tmpname = $("#Appointment_Name").val().trim();
	if ($.isNumeric(tmpname))
	{
		return "Only Numerical values NotAllowed.";
	}
	
	
	//APPOINTMENT DESCRIPTION------------------------
	if ($("#Appointment_Desc").val().trim() == "")
	{
		return "Insert Appointment Discription.";
	}
	
	// cannot be only numerical value
	var tmpDesc = $("#Appointment_Desc").val().trim();
	if ($.isNumeric(tmpDesc))
	{
		return "Only Numerical values NotAllowed.";
	}
	
	
	return true;
}















