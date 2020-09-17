<?php
    $con = mysqli_connect("localhost", "root", "", "de");
    
    $dh=$_POST["username"];

$query=mysqli_query($con,"SELECT * FROM profile WHERE name='$dh'");

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