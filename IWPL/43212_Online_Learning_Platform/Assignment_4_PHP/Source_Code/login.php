<!DOCTYPE html>
<html>

<head>
    <title>Enrollment Form</title>
    <style type="text/css">
    input {
        width: 45%;
        margin-bottom: 20px;
        margin-top: 7px;
        background: transparent;
        border: none;
        color: black;
        border-bottom: 2px solid lightgreen;
    }
    
    input:hover {
        transition: 0.2s;
        border-bottom: 2px solid black;
    }
    
    button {
        width: 20%;
        background-color: #ffb3b3;
        color: black;
        height: 30px;
        border-radius: 10px;
        border: none;
    }
    
    input[type=submit] {
        width: 20%;
        background-color: #ffb3b3;
        color: black;
        height: 30px;
        border-radius: 10px;
        border: none;
    }
    
    input[type=date]::-webkit-inner-spin-button,
    input[type=number]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    
    input[type=submit]:hover {
        background-color: green;
        transition: .2s;
    }
    
    input[type=radio] {
        width: 5%;
    }
    
    select {
        width: 20%;
        padding-left: 8%;
    }
    
    label {
        margin-top: 9px;
        font-weight: bold;
        font-size: 22px;
        color: black;
    }
    
     ::placeholder {
        color: black;
        opacity: 0.6;
    }
    
    input:focus,
    select:focus,
    textarea:focus,
    button:focus {
        outline: none;
    }

    input[title]:hover{
    font-style: italic;
    color: red;
}
</style>
</head>
<style type="text/css">
    input {
        width: 45%;
        margin-bottom: 20px;
        margin-top: 7px;
        background: transparent;
        border: none;
        color: black;
        border-bottom: 2px solid lightgreen;
    }
    
    input:hover {
        transition: 0.2s;
        border-bottom: 2px solid black;
    }
    
    button {
        width: 20%;
        background-color: #ffb3b3;
        color: black;
        height: 30px;
        border-radius: 10px;
        border: none;
    }
    
    input[type=submit] {
        width: 20%;
        background-color: #ffb3b3;
        color: black;
        height: 30px;
        border-radius: 10px;
        border: none;
    }
    
    input[type=date]::-webkit-inner-spin-button,
    input[type=number]::-webkit-outer-spin-button {
        -webkit-appearance: none;
        margin: 0;
    }
    
    input[type=submit]:hover {
        background-color: green;
        transition: .2s;
    }
    
    input[type=radio] {
        width: 5%;
    }
    
    select {
        width: 20%;
        padding-left: 8%;
    }
    
    label {
        margin-top: 9px;
        font-weight: bold;
        font-size: 22px;
        color: black;
    }
    
     ::placeholder {
        color: black;
        opacity: 0.6;
    }
    
    input:focus,
    select:focus,
    textarea:focus,
    button:focus {
        outline: none;
    }
</style>

<body style="background-image: url(./assets/bg4.jpg);background-size: cover;">
<?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $passwordErr = $phoneErr = "";
$name = $email = $password = $phone = $website = "";


include("config.php");
   session_start();
   
   if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form 
      
      $myemail = mysqli_real_escape_string($db,$_POST['email']);
      $mypassword = mysqli_real_escape_string($db,$_POST['password']); 
      
      $sql = "SELECT * FROM login WHERE email = '$myemail' and password = '$mypassword'";
      $result = mysqli_query($db,$sql);
      echo mysqli_error($db);
      $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
      $active = $row['active'];
      
      $count = mysqli_num_rows($result);
      echo $count;
      // If result matched $myemail and $mypassword, table row must be 1 row
		
      if($count == 1) {
          
          $_SESSION["email"] = $myemail;
         header("location: successful.php");
      }else {
         $error = "Your Login Name or Password is invalid";
      }
    
   }

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>
    <h2 style="color: black;font-size: 50px;" align="center">Enter Your Details !</h2>
    <div style="margin-left: 25% ;width: 50%;">
        <form method="post" action="" >

            <div style=" border: 2px solid black;padding: 20px">
                <label for="email">Email : </label><br>
                <input maxlength="20" ondblclick="return newfunc(this);"  autocomplete="off" placeholder="Enter email *" onkeyup="validateEmail(this)" type="text" id="email" name="email"><br>
                <span style="color:red;"> <?php echo $emailErr;?></span><br>
                <p>Suggestions: <span id="txtHint"></span></p>
             
                <label for="password">Password : </label><br>
                <input maxlength="15" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter password *" type="password" id="password" name="password"><br>
                <span style="color:red;"> <?php echo $passwordErr;?></span><br>

            </div>

          
            <button class="prevbtn" style="margin-top: 20px;" id="submitbtn" type="submit" name="submit">Submit</button>

        </form>
    </div>




    <script>




        document.getElementById("email").onkeyup = function() {
            var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
            str = document.getElementById("email").value;
            if (str.length == 0) {
                document.getElementById("txtHint").innerHTML = "";
                return;
            } else {
                // alert(str);
                var xmlhttp = new XMLHttpRequest();
                xmlhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200) {
                        document.getElementById("txtHint").innerHTML = this.responseText;
                    }
                };
                xmlhttp.open("GET", "gethint.php?q=" + str, true);
                xmlhttp.send();
            }
            if (reg.test(this.value) == false) {
                this.style.borderBottom = "2px solid red";
                //playAudio();
                return false;
            }
            this.style.borderBottom = "2px solid lightgreen";

            return true;
        }
        
  

        document.getElementById("password").onkeyup = function() {
            var reg = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,15}$/;

            if (reg.test(this.value) == false) {
                this.style.borderBottom = "2px solid red";
                //playAudio();
                return false;
            }
            this.style.borderBottom = "2px solid lightgreen";

            return true;
        }

 

        document.getElementById("phone").onkeyup = function() {
            var reg = /^\d{10}$/;

            if (reg.test(this.value) == false) {
                this.style.borderBottom = "2px solid red";
                //playAudio();
                return false;
            }
            this.style.borderBottom = "2px solid lightgreen";
            return true;
        }



        document.getElementById("btn1").onclick = function() {
            todo1();
        }



        function todo1() {
            document.getElementById("fname").value = "";
            document.getElementById("lname").value = "";
            document.getElementById("email").value = "";
            document.getElementById("phone").value = "";
            document.getElementById("password").value = "";

        }


        document.getElementById("btn2").onclick = function() {
            todo2();
        }




        function todo2() {
            
            
            document.getElementById("address").value = "";
            document.getElementById("qualification").value = "UG";
            document.getElementById("pincode").value = "";
            document.getElementById("radio1").checked = true;
            document.getElementById("radio2").checked = false;
        }

        document.getElementById("btn3").onclick = function() {
            todo1();
            todo2();
        }

        function newfunc(here) {
            here.value = "";
        }

        document.getElementById("submitbtn").onclick = function() {

            if (document.getElementById("email").value == "") {
                playAudio();
                alert("Please insert email !");

                return false;
            } else if (document.getElementById("phone").value == "") {
                alert("Please insert phone !");
                playAudio();
                return false;
            } else if (document.getElementById("password").value == "") {
                alert("Please insert password !");
                playAudio();
                return false;
            }

        }



 
        
    </script>
</body>



</html>