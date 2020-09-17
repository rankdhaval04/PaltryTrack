<?php

//Define your host here.
$HostName = "localhost";

//Define your database username here.
$HostUser = "root";

//Define your database password here.
$HostPass = "";

//Define your database name here.
$DatabaseName = "dhaval";

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 
 $email = $_POST['email'];
 $password = $_POST['password'];
 $address=$_POST['address'];
 $phone=$_POST['phone'];
 $dob=$_POST['dob'];

 $Sql_Query = "insert into login (email,password,address,phone,dob) values ('$email','$password','$address','$phone','$dob')";
 
 if(mysqli_query($con,$Sql_Query)){
 
 echo 'Data Submit Successfully';
 
 }
 else{
 
 echo 'Try Again';
 
 }
 mysqli_close($con);

?>