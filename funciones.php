<?php
//function solo_letras($cadena){ 
$cadena=$_POST['num1'];
$letras = " Ã¡Ã©Ã­Ã³ÃºabcdefghijklmnÃ±opqrstuvwxyz"; 
for ($i=0; $i<strlen($cadena); $i++){ 
if (strpos($letras, substr($cadena,$i,1))===false){ 
//no es válido; 
    $resultado= 'no es letra';
//return false; 
        }
        else  $resultado= 'es letra';
    } 
    echo $resultado;
//return true; 
//}  
?>