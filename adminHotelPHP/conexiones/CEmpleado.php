<?php
/*Archivo con conexion a base de datos */
include ("conexion.php");

/*Funcion para registrar empleado */
function empleado_registrar($nombre, $apellido_p, $apellido_m, $direccion, $telefono, $email,$puesto ,$usuario, $contrasena, $ps, $rs){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        /*query para saber si el  usuario ya existen  */
        $query2 = "SELECT COUNT(*) FROM empleado WHERE Usuario = REPLACE('". $usuario ."', ' ','')";
        $exito_q2 = $db->query($query2);

            if($exito_q2->fetchColumn() >= 1){
                /*El usuario ya existe */
                echo "<script> alert('Ya existe una cuenta con ese usuario'); </script>";
            }else{
                /*queries para insertar en persona y empleado*/
                $query3 = "INSERT INTO `persona`( `Nombre`, `Apellido_P`, `Apellido_M`, `Direccion`, `Telefono`, `Email`) VALUES (TRIM(?),TRIM(?),TRIM(?),TRIM(?),REPLACE(?,' ',''),TRIM(?))";
                $query4 = "INSERT INTO `empleado`(`idEmpleado`,`Puesto`, `Usuario`, `Password`, `Pregunta_seguridad`, `Respuesta_seguridad`) VALUES ((SELECT idPersona FROM persona ORDER BY idPersona DESC LIMIT 1),?,REPLACE(?,' ',''),MD5(?),?,TRIM(?))";

                /*se preparan consultas */
                $consulta = $db->prepare($query3);
                $exito_c = $consulta->execute([$nombre, $apellido_p, $apellido_m, $direccion, $telefono, $email]);

                /*Comprobacion de registro guardado */
                if($exito_c != false){
                    /*se registro bien en persona */
                    $consulta2 = $db->prepare($query4);
                    $exito_c2 = $consulta2->execute([$puesto,$usuario, $contrasena, $ps, $rs]);

                    /*Comprobacion de registro guardado */
                    if($exito_c2 != false){
                        /*Ambos registros se hicieron correctamente */
                        return true;

                    }else{
                        /*Error al registar empleado */
                        echo "<script> alert('Error en el registro de empleado'); </script>";
                        return false;
                    }
                }else{
                    /*Error al registrar persona */
                    echo "<script> alert('Error en el registro de persona'); </script>";
                    return false;
                }
            }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para iniciar sesion */
function empleado_ingresar($usuario, $contrasena){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        /*query para comprobra si el usuario y contraseña son correctos */
        $query = "SELECT COUNT(*) FROM empleado WHERE Usuario = REPLACE('". $usuario ."',' ','') AND Password = MD5('". $contrasena ."') AND Estado = 1";
        $consulta = $db->query($query);
        /*Retronar el numero de filas encontradas */
        return  $consulta->fetchColumn();


    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }

}

function empleado_recuperar_contrasena($usuario, $ps, $rs){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        /*query para comprobra si el usuario, pregunta de seguridad y respuesta de segurida son correctos */
        $query = "SELECT COUNT(*) FROM empleado WHERE Usuario = REPLACE('". $usuario ."',' ','') AND Pregunta_seguridad = '". $ps ."' AND Respuesta_seguridad = TRIM('". $rs ."') AND Estado = 1";
        $consulta = $db->query($query);
        /*Retronar el numero de filas encontradas */
        return  $consulta->fetchColumn();


    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

function empleado_cambiar_contrasena($usuario, $contrasena){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        /*query para actualizar contraseña */
        $query = "UPDATE empleado SET Password = MD5('". $contrasena ."') WHERE Usuario = REPLACE('". $usuario ."', ' ','') AND Estado = 1";
        
        /*Almacena el resultado de executar el query */
        $exito = $db->query($query);
        if($exito == true){
            /*Actualizacion correcta */

            /*Se envia correo al empleado */
            $query2 = "SELECT p.Nombre, p.Apellido_P, p.Apellido_M, p.Email FROM persona p INNER JOIN empleado e ON e.idEmpleado = p.idPersona WHERE e.Usuario = '$usuario'";
            $exito2 =  $db->query($query2);
            $destinatario = null;
            $mens = "Hola ";
            $asunto = "CAMBIO DE CONTRASEÑA";
            $mensaje =  "\nTu contraseña se actualizo correctamente.\n\n\nHOTEL EL DESCANSO MEDIEVAL";
            foreach($exito2 as $aux){
                $destinatario = $aux['Email'];
                $mens =  $mens." ".$aux['Nombre'] . " " . $aux['Apellido_P'] ." " . $aux['Apellido_M'];
            }
            mail($destinatario, $asunto, $mens ."." . $mensaje, 'From: ElDescasoMedieval@gmail.com');
            
            return true;
        }else{
            /*Error en actualizacion */
            return false;
        }


    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para mostrar todos los empleados activos */
function empleado_listado(){
    $db = conectar();
    try{
        $query = "SELECT p.idPersona, p.Nombre, p.Apellido_P, p.Apellido_M, p.Direccion, p.Telefono, p.Email,e.Puesto ,e.Usuario , e.Estado FROM persona p INNER JOIN empleado e ON p.idPersona = e.idEmpleado /*WHERE e.Estado = 1*/";
        $exito = $db->query($query);

        /*Se comprueba si se realiza la consulta */
        if($exito != false){
            /*Consulta exitosa */
            return $exito;
        }else{
            /*Error inesperado */
            return false;
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para listar empleados filtrando por id */
function empleado_listado_id($id){
    $db = conectar();
    try{
        $query = "SELECT p.idPersona, p.Nombre, p.Apellido_P, p.Apellido_M, p.Direccion, p.Telefono, p.Email,e.Puesto ,e.Usuario , e.Estado FROM persona p INNER JOIN empleado e ON p.idPersona = e.idEmpleado WHERE e.idEmpleado = '$id'";
        $exito = $db->query($query);

        /*Se comprueba si se realiza la consulta */
        if($exito != false){
            /*Consulta exitosa */
            return $exito;
        }else{
            /*Error inesperado */
            return false;
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para actualizar todos los empleados */
function empleado_actualizar($idEmpleado, $Nombre, $Apellido_p, $Apellido_m,$Direccion, $Telefono, $Puesto ,$Email,$Estado){
    /*Conexion con la base de datos */
    $db = conectar();
    try{
        $query = "UPDATE persona, empleado SET persona.Nombre = TRIM('$Nombre') , persona.Apellido_P = TRIM('$Apellido_p') , persona.Apellido_M = ('$Apellido_m'), persona.Direccion = TRIM('$Direccion') , persona.Telefono = REPLACE('$Telefono', ' ','') , persona.Email = TRIM('$Email'),empleado.Puesto = '$Puesto' , empleado.Estado = '$Estado' WHERE persona.idPersona = '$idEmpleado' AND empleado.idEmpleado = '$idEmpleado'";
        $exito = $db->query($query);
        /*Se comprueba si se realiza la actualización*/
        if($exito != false){
            /*Actualización exitosa */
            return true;
        }else{
            /*Error inesperado */
            return false;
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para consultar puesto del empleado */
function empleado_puesto($usuario){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        /*query para comprobra si el usuario y contraseña son correctos */
        $query = "SELECT Puesto FROM empleado WHERE Usuario = REPLACE('". $usuario ."',' ','') AND Estado = 1";
        $consulta = $db->query($query);
        /*Retronar el numero de filas encontradas */
        return  $consulta->fetchColumn();


    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }


}

?>