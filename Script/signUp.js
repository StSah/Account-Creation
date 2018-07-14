var SignUp = function() {
var emailId=document.getElementById("email").value
var pwd=document.getElementById("password").value
var cnf =document.getElementById("cnfpassword").value

var obj = new Object();
   obj.emailid = emailId;
   obj.password  = pwd;
   obj.confirmPassword=cnf;
   //var jsonString= JSON.stringify(obj);
   var jsonString= JSON.stringify(obj);
	  var signUpUrl="http://localhost:8062/loginUser/signUpUser"
	var xhr = new XMLHttpRequest();
	xhr.open("POST", signUpUrl, true);
	//xhr.setRequestHeader("Content-type", "application/json");
	
	xhr.onreadystatechange = function () { 
	
    if (xhr.readyState == 4 && xhr.status == 200) {
        console.log("Data Present")
		var resultText = xhr.responseText
		alert(resultText)
		console.log(resultText)
    }
	
}
 xhr.send(jsonString);  


}

function ValidateEmail(email) 
{
 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(myForm.email.value))
  {
    return (true)
  }
    alert("You have entered an invalid email address!")
    return (false)
}