<?php
    $con = mysqli_connect("localhost", "root", "", "Paltrytrack");
    
    $name = $_POST["name"];
    $age = $_POST["age"];
    $password = $_POST["password"]; 
    $address=$_POST["address"];
    $phone=$_POST["phone"];
    $area=$_POST["area"];
    $city=$_POST["city"];
    $pincode=$_POST["pincode"];


    $statement = mysqli_prepare($con, "INSERT INTO register (name, age, password,address,contect,area,city,pincode) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sissssss", $name, $age, $password,$address,$phone,$area,$city,$pincode);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>