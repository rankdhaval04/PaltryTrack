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
// WHERE (SELECT pincode FROM registerv WHERE contect='$dh')

$query=mysqli_query($con,"SELECT * FROM store_favorite WHERE contact_cust='$dh'");

if($query)
{
while($row=mysqli_fetch_array($query))
	{
	$flag[]=$row;
	}
print(json_encode($flag));
}
mysqli_close($con);
?>