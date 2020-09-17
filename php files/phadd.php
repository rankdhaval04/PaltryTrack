<?php
    $con = mysqli_connect("localhost", "root", "", "pharma");
    
    $name=$_POST["name"];
    $expiry=$_POST["expiry"];
    $total=$_POST["total"];
    $agency=$_POST["agency"];
    $company=$_POST["company"];

$query= "INSERT INTO madicine (name,expiry,total,agency,company) values('$name','$expiry','$total','$agency','$company')";

if(mysqli_query($con, $query));
mysqli_close($con);
?>