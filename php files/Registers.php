<?php
    $con = mysqli_connect("localhost", "root", "", "t");
    
    $name = $_POST["name"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $age = $_POST["age"]; 
    $address=$_POST["address"];
    $phone=$_POST["phone"];

    $statement = mysqli_prepare($con, "INSERT INTO user (name, age,username, password,address,phone) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sissss", $name, $age,$username, $password,$address,$phone);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>