<?php
//host
$host = "localhost";
//user name
$username = "root";
//database password
$pwd = "";
//database name.
$db = "Paltrytrack";

$con=mysqli_connect($host,$username,$pwd,$db) or die("Unable to Connect");

if(mysqli_connect_error($con))
{
	echo "Failed to connect";
}
$dh=$_POST['dh'];
$name=$_POST['name'];
$area=$_POST['area'];
$password=$_POST['password'];
$address=$_POST['address'];
$contect=$_POST['contect'];
$pincode=$_POST['pincode'];
$city=$_POST['city'];

$query=mysqli_query($con,"UPDATE register SET name='$name',area='$area',password='$password',address='$address',contect='$contect',city='$city',pincode='$pincode' WHERE id='$dh'");

if($query)
{

}
mysqli_close($con);
?>


