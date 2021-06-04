<!DOCTYPE html>
<html>

<head>
    <title>Enrollment Form</title>

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

<body style="background-image: url(./assets/bg4.png);background-size: cover;">
<?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $passwordErr = $phoneErr = "";
$email = $password = $phone = $fname = $lname = $address = $dob = $pincode = $interest = $qualification = $gender = "";
if ($_SERVER["REQUEST_METHOD"] == "POST") {
  
  if (empty($_POST["email"])) {
    $emailErr = "Email is required";
    echo "Invalid email !";
    
  } else {
    $email = test_input($_POST["email"]);
    // check if e-mail address is well-formed
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $emailErr = "Invalid email format";
      echo "Invalid email format !";
    }
  }
    
  if (empty($_POST["phone"])) {
    $phoneErr = "Phone is required";
    echo "Invalid phone!";
  } else {
    $phone = test_input($_POST["phone"]);
  }


if (empty($_POST["password"])) {
    $passwordErr = "Password is required";
    echo "Invalid password !";
  } else {
    $password = test_input($_POST["password"]);
  }



  if (empty($_POST["gender"])) {
    $genderErr = "Gender is required";
    echo "Invalid gender !";
  } else {
    $gender = test_input($_POST["gender"]);
  }
}


include("config.php");
   session_start();
   
   if($_SERVER["REQUEST_METHOD"] == "POST") {
      // username and password sent from form 
      
      $myemail = mysqli_real_escape_string($db,$_POST['email']);
      $mypassword = mysqli_real_escape_string($db,$_POST['password']); 
      $fname = mysqli_real_escape_string($db,$_POST['fname']); 
      $lname = mysqli_real_escape_string($db,$_POST['lname']); 
      $phone = mysqli_real_escape_string($db,$_POST['phone']);
      $address = mysqli_real_escape_string($db,$_POST['address']); 
      $pincode = mysqli_real_escape_string($db,$_POST['pincode']); 
      $gender = mysqli_real_escape_string($db,$_POST['gender']); 
      $dob = mysqli_real_escape_string($db,$_POST['dob']);
      $qualification = mysqli_real_escape_string($db,$_POST['qualification']); 
      $interest = mysqli_real_escape_string($db,$_POST['interest']); 
      
      $sql = "SELECT * FROM login WHERE username = '$myemail' and password = '$mypassword'";
      $sql2 = "INSERT INTO login VALUES('$mypassword','$fname','$lname','$phone','$myemail','$address','$pincode','$gender',current_timestamp(),'$qualification','$interest')";
      $sql3 = "SELECT * FROM login";
      $result = mysqli_query($db,$sql2);
      echo mysqli_error($db);
      if ($result) { 
        
        $_SESSION["email"] = $myemail;
        header("location: successful.php"); 
    } 
    //   $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
    //   $active = $row['active'];
      
    //   $count = mysqli_num_rows($result);
      
    //   // If result matched $myemail and $mypassword, table row must be 1 row
		
    //   if($count == 1) {
         
    //      $_SESSION['login_user'] = $myemail;
    //      echo "<h2>Successful !</h2>";

    //      header("location: successful.html");
    //   }else {
    //      $error = "Your Login Name or Password is invalid";
    //      echo "Invalid login password !";
    //   }
   }


function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>
    <h2 style="color: black;font-size: 35px;" align="center">Please enter Your Details !</h2>
    <div style="margin-left: 25% ;width: 50%;">
        <form method="POST">

            <div style=" border: 2px solid black;padding: 20px">
        
                    <div style="width: 50%; float: left">
                        <label for="fname">First Name : </label><br>
                        <input title="First Name should not contain numbers" style="width: 95%" maxlength="20" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter first name..." id="fname" type="text" name="fname"><br>
                    </div>
                    <div style="width:50%;float: right">
                        <label for="lname">Last Name : </label><br>
                        <input title="Last Name should not contain numbers" style="width: 95%" maxlength="20" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter last name..." id="lname" type="text" name="lname"><br>
                    </div>
                    <div style="width: 50%; float: left">
                        <label for="email">Email : </label><br>
                        <input maxlength="20" title="Email should contain at least one @ and . ex. (email@exaple.com)" style="width: 95%" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter email *" onkeyup="validateEmail(this)" type="email" id="email" name="email"><br>
                    </div>
                    <div style="width:50%;float: right">
                        <label for="phone">Phone Number : </label><br>
                        <input maxlength="10" style="width: 95%" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter Mobile number *" id="phone" type="tel" name="phone"><br>
                    </div>

                <label for="password">Password : </label><br>
                <input maxlength="15" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter password *" type="password" id="password" name="password"><br>

                <button type="button" id="btn1" hidden>RESET</button>
            </div>

            <div style="border: 2px solid black ;padding: 20px;margin-top: 20px">
            
               
                <br>
                <div style="width:50%;float: left">
                    <label for="address"> Address : </label><br>
                    <input maxlength="30" style="width: 95%;" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter Full address..." id="address" type="text" name="address"><br>
                </div>
                <div style="width:50%;float: right">
                    <label for="Pincode">Pincode : </label><br>
                    <input maxlength="6" style="width: 95%;" ondblclick="return newfunc(this);" autocomplete="off" placeholder="Enter Pincode..." pattern="^\d{6}" id="pincode" type="tel" name="pincode"><br>
                </div>
                <div style="width:50%;float: left">
                <label for="gender">Gender : </label><br>
                <input ondblclick="return newfunc(this);" value="male" autocomplete="off" id="radio1" type="radio" name="gender" checked>male
                <input ondblclick="return newfunc(this);" autocomplete="off" value="female" id="radio2" type="radio" name="gender">female
                <input ondblclick="return newfunc(this);" autocomplete="off" id="radio1" value="prefer_not_to_say" type="radio" name="gender" checked>Prefer not to say
                </div>
                <br>
                <label for="dob" >DOB : </label><br>
                <input ondblclick="return newfunc(this);" autocomplete="off" id="dob" type="date" name="dob" checked >
                <br>
                <div style="background-color: white;">
                <h2  style="color: black;">Please Select other areas of Interest !</h2 >
                <input style="padding: 0px;" type="checkbox" name="interest" value="Engineering">
                <label for="interest"> Engineering</label><br>
                <input type="checkbox" name="interest" value="Science">
                <label for="interest"> Science</label><br>
                <input type="checkbox" name="interest" value="Finance">
                <label for="interest"> Finance</label><br><br>
                </div>

                <h3 style="color: black;">Please Enter Your Qualification : </h3>
                <select ondblclick="return newfunc(this);" id="qualification" name="qualification">
                    <option value="UG">UG</option>
                    <option value="PG">PG</option>
                    <option value="SSC">SSC</option>
                    <option value="HSC">HSC</option>
                </select><br>

                <button type="button" style="margin-top: 20px" id="btn2" hidden>RESET</button>
            </div>

            <button class="prevbtn" style="margin-top: 20px;" id="submitbtn" type="submit" name="submit">Submit</button>
            <button type="button" style="margin-top: 20px" id="btn3" >Reset</button>

        </form>
    </div>


    <audio id="player">
		<source src="./assets/beep.wav" type="audio/wav">
	</audio><br>



    <script>
        function playAudio() {
            document.getElementById("player").play();
        }



        document.getElementById("email").onkeyup = function() {
            var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

            if (reg.test(this.value) == false) {
                this.style.borderBottom = "2px solid red";
                //playAudio();
                return false;
            }
            this.style.borderBottom = "2px solid lightgreen";

            return true;
        }
        
        document.getElementById("fname").onkeyup = function() {
            var reg = /^([A-Za-z])+$/;

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

        document.getElementById("lname").onkeyup = function() {
            var reg = /^([A-Za-z])+$/;

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

        document.getElementById("pincode").onkeyup = function() {
            var reg = /^\d{6}$/;

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

        document.getElementById("dob").onblur = function() {
            var d1 = new Date();
            var d2 = new Date(document.getElementById("dob").value);
            var timeDiff = d2.getTime() - d1.getTime();
            var diff = timeDiff / (1000 * 3600 * 24);

            var value = parseInt(-1 * 365 * 14);

            if (parseInt(diff) > 0) {

                alert("Wrong Date of birth !");
            }

        }
    </script>
</body>
</html>