
var deviseIdSelected;// id=.codeDevise
var deviseSelected;
function display_selected_devise(){
	$("#spanMsg").html( "selected devise:" + deviseIdSelected) ;
	$('#spanCode').html(deviseSelected.code);
	$('#txtName').val(deviseSelected.nom);
	$('#txtExchangeRate').val(deviseSelected.rate);
}
$(function(){
	$.ajax({
		type: "GET",
		url: "restApp/devise/",
		contentType : "application/json",
		success: function (deviseReturned) {
			if (deviseReturned) {
				console.log ("deviseReturned", deviseReturned);
				deviseSelected = deviseReturned;
				display_selected_devise();
			}
			else $("#spanMsg").html("Cannot GET devises !");
		}
	});
});
