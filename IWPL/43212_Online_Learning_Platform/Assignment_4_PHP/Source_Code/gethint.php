<?php
// Array with names
include("config.php");
   session_start();
   $sql = "SELECT email FROM login";
   $result = mysqli_query($db,$sql);
   echo mysqli_error($db);
   $a = array();

while($row = mysqli_fetch_array($result,MYSQLI_ASSOC)) {
   $a[] = $row['email'];
}
// get the q parameter from URL
$q = $_REQUEST["q"];

$hint = "";

// lookup all hints from array if $q is different from ""
if ($q !== "") {
  $q = strtolower($q);
  $len=strlen($q);

  foreach($a as $name) {

    if (stristr($q, substr($name, 0, $len)) ) {
      if ($hint === "") {
        $hint = $name;
      } else {
        $hint .= ", $name";
      }
    }
  }
}

// Output "no suggestion" if no hint was found or output correct values
echo $hint === "" ? "no suggestion" : $hint;
?>