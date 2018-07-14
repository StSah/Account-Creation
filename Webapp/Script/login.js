var LoginPage = function() {
console.log("inside here")
var emailId=document.getElementById("email").value
console.log(emailId)
var pwd=document.getElementById("password").value
console.log(pwd)
var obj = new Object();
   obj.email = emailId;
   obj.password  = pwd;
   //var jsonString= JSON.stringify(obj);
   var jsonString= JSON.stringify(obj);
   console.log(obj)
	  var loginUrl="http://localhost:8062/loginUser/signInUser"
	var xhr = new XMLHttpRequest();
	xhr.open("POST", loginUrl, true);
	//xhr.setRequestHeader("Content-type", "application/json");
	
	console.log(xhr)
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