<?php

include("conecta.php");

    $usuario=$_POST['usuario'];
    $clave=$_POST['clave'];
    
    $statement= mysqli_prepare($conexion, "select * from login where usuario = ? and clave = ? ");
    
    mysqli_stmt_bind_param($statement, "ss",  $usuario, $clave);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($sratement, $usuario, $clave);
    
    $response = array();
    
    $response["success"] = false;
    
    while (mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["usuario"] = $usuario;
        $response["clave"] = $clave;
        
        
        
    }
    
    
    echo json_encode($response);
?>
