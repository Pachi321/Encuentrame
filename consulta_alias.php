<?php
include("conecta.php");

    $respuesta = array();
    $respuesta["aliasp"] = array();  


//$sql="SELECT * FROM alias";
$result=mysqli_query($conexion,"SELECT * FROM alias");
    while($row = mysqli_fetch_array($result)){
        // Array temporal para crear una sola categoría
        $tmp = array();
        //$tmp["idusuariologin"] = $row["idusuariologin"];
        $tmp["aliasp"] = $row["aliasp"];
        
        
        // Push categoría a final json array
        array_push($respuesta["aliasp"], $tmp);
        
    }
    
    // Mantener el encabezado de respuesta a json
    header('Content-Type: application/json');
    
    //Escuchando el resultado de json
    echo json_encode($respuesta);
?>

