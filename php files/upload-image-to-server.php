<?php

include 'config.php';

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
 
 if($_SERVER['REQUEST_METHOD'] == 'POST')
 {
 $DefaultId = 0;
 
 $ImageData = $_POST['image_data'];
 
 $ImageName = $_POST['image_tag'];

 $price=$_POST['price'];

 $contact=$_POST['contact'];

 $discription=$_POST['discription'];

  $keyword=$_POST['keyword'];

  $pincode=$_POST['pincode'];

  $latitude=$_POST['latitude'];

  $longitude=$_POST['longitude'];


 
 $ImagePath = "upload/$ImageName.jpg";
 
 $ServerURL = "shadi/$ImagePath";
 
 $InsertSQL = "INSERT INTO additem (image_path,name,price,contact,keyword,latitude,longitude,pincode,discription) values('$ServerURL','$ImageName',     '$price','$contact','$keyword','$latitude','$longitude','$pincode','$discription')";
 
 if(mysqli_query($conn, $InsertSQL)){

 file_put_contents($ImagePath,base64_decode($ImageData));

 echo "Your Image Has Been Uploaded.";
 }
 
 mysqli_close($conn);
 }else{
 echo "Please Try Again";
 }

?>