<?php
//host
$host = "localhost";
//user name
$username = "root";
//database password
$pwd = "";
//database name.
$db = "pharma";

$con=mysqli_connect($host,$username,$pwd,$db) or die("Unable to Connect");

if(mysqli_connect_error($con))
{
	echo "Failed to connect";
}
$id=$_POST['id'];
$ab=$_POST['ab'];
$contact=$_POST['contact'];

$query=mysqli_query($con,"UPDATE madicine SET total=total-'$ab' WHERE id='$id'");


if($query)
{

}

mysqli_close($con);
?>