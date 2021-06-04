<!DOCTYPE html>
<html>

<head>
    <title>Success</title>
    
</head>

<body background="bg4.jpg" style=" background-image: url(./assets/bg4.jpg);background-size: cover;">

    
    <p style="color: black" id="demo"></p>
</body>
<?php
    include('config.php');
    session_start();
    $email = $_SESSION['email'];

    $sql = "SELECT * FROM login WHERE email = '$email'";
    $result = mysqli_query($db,$sql);
    echo mysqli_error($db);
    $row = mysqli_fetch_array($result,MYSQLI_ASSOC);

    $fname = $row['fname'];
    $lname = $row['lname'];
    $address = $row['address'];
    $dob = $row['address'];
    $pincode = $row['pincode'];
    $interest = $row['interest'];
    $qualification =  $row['qualification'];
    echo "<h1> Welcome $fname $lname !</h1>";
    echo "<h3> Name :  $fname $lname <br> Address :  $address <br> DOB :  $dob <br> Pincode : $pincode <br> Interest : $interest <br> Qualification :  $qualification</h3>";

?>


</html>
