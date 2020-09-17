<?php
//host
$host = "localhost";
//user name
$username = "root";
//database password
$pwd = "";
//database name.
$db = "farm";

$con=mysqli_connect($host,$username,$pwd,$db) or die("Unable to Connect");

if(mysqli_connect_error($con))
{
	echo "Failed to connect";
}
$soil=$_POST['soil'];
$temp=$_POST['temp'];
$water=$_POST['water'];

$query=mysqli_query($con,"SELECT * FROM crop1 ");
//WHERE soil='$soil',temp='$temp',water='$water'
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
