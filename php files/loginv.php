<?php
    $con = mysqli_connect("localhost", "root", "", "PalTryTrack");
    
    $contect = $_POST["contect"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM registerv WHERE contect = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $contect, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
    }
    
    echo json_encode($response);
?>