<?php
    $con = mysqli_connect("localhost", "root", "", "paltrytrack");
    
    $name = $_POST["name"];
    $area = $_POST["area"];
    $password = $_POST["password"]; 
    $address=$_POST["address"];
    $phone=$_POST["phone"];
    $city=$_POST["city"];
    $latitude=$_POST["latitude"];
    $longitude=$_POST["longitude"];
    $pincode=$_POST["pincode"];

    $statement = mysqli_prepare($con, "INSERT INTO registerv (name, area, password,address,contect,city,latitude,longitude,pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssssssdds", $name, $area, $password,$address,$phone,$city,$latitude,$longitude,$pincode);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>