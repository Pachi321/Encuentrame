<?php

include("conecta.php");

    $usuario=$_POST['usuario'];
    $rut=$_POST['rut'];
    $clave=$_POST['clave'];
    
    $statement= mysqli_query($conexion, "insert into login (usuario,rut,clave) values ('$usuario', '$rut', '$clave')");
    
    mysqli_stmt_bind_param($statement,  $usuario, $rut, $clave);
    
    mysqli_stmt_execute($statement);
    
    $response = array();
    
    $response["success"] = true;
    
    echo json_encode($response);
?>
