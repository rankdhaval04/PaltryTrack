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
$item_title=$_POST['item_title'];
$quantity=$_POST['quantity'];
$price=$_POST['price'];
$contact=$_POST['contact'];
$small_pic=$_POST['small_pic'];
$unit=$_POST['unit'];
$vendor_contact=$_POST['vendor_contact'];


//$query=mysqli_query($con,"UPDATE ads SET quantity=quantity-'$ab' WHERE id='$id'");

$query1=mysqli_query($con,"INSERT INTO item_cart(item_title,quantity,price,contact,vendor_contact,status,small_pic,unit)VALUES('$item_title','$quantity','$price','$contact','$vendor_contact','1','$small_pic','$unit') ");

//if($query)
//{

//}
if($query1)
{

}
mysqli_close($con);
?>