<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<style>
html{ 
  background: url(./Source_Code/assets/bg4.jpg)
 no-repeat center fixed; 
  background-size: cover;
}

.container 
{
    margin: 0 auto;
}

.container1 
{
    margin: 0 auto;
}

.container{
  margin: 0 auto; 
  text-align: left;
  padding: 30px;
  border-style: solid;
  border-width: 5px;border-color: aqua;
}

.container1{
  margin: 0 auto; 
  text-align: left;
  padding: 30px;
  border-style: solid;
  border-width: 5px;border-color: aqua;
}

input[type=text], select, textarea {
  width: 300px;
  padding: 7px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;

}

input[type=date], select, textarea {
  width: 300px;
  padding: 7px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  
}

input[type=password], select, textarea {
  width: 300px;
  padding: 7px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
  
}

input[type=email], select, textarea {
  width: 300px;
  padding: 7px;
  border: 1px solid #ccc;
  border-radius: 4px;
  resize: vertical;
 

}



label {
  align-self: right;
  font-size: 17px;
 
}



input[type=submit] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: center;
 
}

input[type=Reset] {
  background-color: crimson;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  float: center;
 

}
button {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
input[type=Reset]:hover {
  background-color: red;
}


input:required:invalid, input:focus:invalid {
  
  border-color: red;

  }
  input:required:valid {
  
   border-color: green;
  }




</style>
</head>
<body>

<h1 style="text-align:center;color: white"><em>Registration Form</em></h1>
<div>
<div align="right">
<button type="button" style=";background-color: lightblue;color: black;height: 50px;width: 75px"onclick="window.location.href='index.jsp'">Home</button> 

</div>
<div class="container" style="width: 450px;height: 400px;">
  <form name="myForm1" onsubmit="return validateForm()" action="RegisterS" method="post" >
      <h2><strong><em>Personal Information</em></strong></h2>

      <label for="fn">First Name:</label><br>
      <input type="text" name="firstname" id="fn" placeholder="First name" required><br><br>

     <label for="ln">Last Name:</label><br>
      <input type="text" name="lastname" id="ln" placeholder="Last name" required><br><br>

      <label for="tphone">Phone number:</label><br>
    <input type="text" id ="tphone" name="phone" placeholder="Phone number" pattern="[1-9]{1}[0-9]{9}" maxlength="10" required><br><br>

         

      <label for="bd">Birth Date:</label><br>
      <input type="date" id="bd" name="bday" placeholder="Birth Date" max="2018-01-01" min="1900-01-01" required><br><br>

     

     
      <input type="Reset" onclick="form1();"><br>
  </div>
  



<br>
<br>



    <div class="container1" style="width: 450px;height: 300px;">
            <h2><strong><em>Account Information</em></strong></h2>


     <label for="ln">Password:</label><br>
      <input type="password" name="password" required><br><br>

      
      <label for="bd">Email Id</label><br>
       <input type="email" name="emailid" required><br><br>
 
      
      <input type="Reset" onclick="form2();">
      </div>
  
       <br><br>
       <div style="text-align: center;">
      <input type="submit" value="Submit">
      <input type="Reset" onclick="form4();"> 
      </div>
      
  </form>


 </div>
   
 <script>

function form1() 
{
  
  document.forms["myForm1"]["firstname"].value="";
  document.forms["myForm1"]["lastname"].value="";
  document.forms["myForm1"]["phone"].value="";
  document.forms["myForm1"]["Gender"].value="";
  document.forms["myForm1"]["bday"].value="";
  document.forms["myForm1"]["Address"].value="";
  document.forms["myForm1"]["City"].value="";
}

function form2() 
{
  document.forms["myForm2"]["Password"].value="";
  document.forms["myForm2"]["password1"].value="";
  document.forms["myForm2"]["Email_id"].value="";
}

function form4() 
{
   form1();
   form2();
}

function validateForm() 
{
  var x = document.forms["myForm1"]["firstname"].value;
  var y = document.forms["myForm1"]["lastname"].value;   
  var z = document.forms["myForm1"]["phone"].value;
  var r = document.forms["myForm1"]["Password"].value;
  var s = document.forms["myForm1"]["Email id"].value;

  if (x == "" || y == "" || z == "" || w == ""  || s == "") 
  {
     alert("First Name, Last name, Telephone no., User name, Password, Email Id must be filled out");
     return false;
  }
  return true;
}

</script>
 
    </body>
    </html>