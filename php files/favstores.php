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
$contact_cust=$_POST['contact_cust'];
$store_name=$_POST['store_name'];
$store_area=$_POST['store_area'];
$store_id=$_POST['store_id'];

$query=mysqli_query($con,"INSERT INTO store_favorite(contact_cust,store_name,store_area,store_id)VALUES('$contact_cust','$store_name','$store_area','$store_id') ");

if($query)
{
while($row=mysqli_fetch_array($query))
	{
	
	}

}
mysqli_close($con);
?>