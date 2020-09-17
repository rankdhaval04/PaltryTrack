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
$id=$_POST['id'];
$contact=$_POST['contact'];

$query=mysqli_query($con,"UPDATE ads SET sell='1' WHERE id='$id'");

$query1=mysqli_query($con,"INSERT INTO adsorder(pid,contact)VALUES('$id','$contact') ");

if($query)
{

}
if($query1)
{

}
mysqli_close($con);
?>