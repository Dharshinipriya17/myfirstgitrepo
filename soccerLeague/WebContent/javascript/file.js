/**
 * 
 */
function validationForm(){
	var form=document.getElementById("form1");
	var x=form[form1]["year"].value;
	var y=form[form1]["season"].value;
	var z=form[form1]["title"].value;

	if(x==" "){
		alert("enter year");
		return false;
	}
	if(y="UNKNOWN"){
		alert("enter season");
		return false;
	}
	if(z=" "){
		alert("enter title");
		return false;
	}
	
}