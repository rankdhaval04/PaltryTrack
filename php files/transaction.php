<?php
    $con = mysqli_connect("localhost", "root", "", "t");
    
    $credit = $_POST["credit"];
    $username = $_POST["username"];
    $debit = $_POST["debit"];
    $intrest = $_POST["intrest"];
    $totalfund = 0;
    $mid = $_POST["mid"];


    $statement = mysqli_prepare($con, "INSERT INTO userentries (username, credit,debit, intrest,totalfund,mid) VALUES (?, ?, ?, ?, ? , ?)");

    mysqli_stmt_bind_param($statement, "siiiii", $username, $credit,$debit, $intrest,$totalfund,$mid);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;
        
    echo json_encode($response);
?>