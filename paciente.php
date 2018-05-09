<?php

include("conecta.php");

    $aliasp=$_POST['aliasp'];
    $sexo=$_POST['sexo'];
    
    
    $statement= mysqli_query($conexion, "insert into alias (aliasp,sexo) values ('$aliasp', '$sexo')");
    
    mysqli_stmt_bind_param($statement, "ss", $aliasp, $sexo);
    
    mysqli_stmt_execute($statement);
    
    $response = array();
    
    $response["success"] = true;
    
    echo json_encode($response);
?>
