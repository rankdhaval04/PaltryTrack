<?php
    $con = mysqli_connect("localhost", "root", "", "t");
    
    $mandalname = $_POST["mandalname"];
    $location = $_POST["location"];
    $totalfund = $_POST["totalfund"];
    $admin = $_POST["admin"];


    $statement = mysqli_prepare($con, "INSERT INTO mandal (mandalname, location, totalfund, admin) VALUES (?, ?, ?, ? )");
    mysqli_stmt_bind_param($statement, "ssis", $mandalname, $location, $totalfund, $admin);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;
    
    echo json_encode($response);
?>