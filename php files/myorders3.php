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
$address=$_POST['address'];

// WHERE (SELECT pincode FROM registerv WHERE contect='$dh')

$query=mysqli_query($con,"UPDATE item_cart SET delivery_address = '$address' , bill_status='1' WHERE contact='$dh';");

if($query)
{

}
mysqli_close($con);
?>
