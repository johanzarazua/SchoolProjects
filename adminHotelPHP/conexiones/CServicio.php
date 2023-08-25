<?php
include ("conexion.php");

/*Funcion para registrar nuevo servicio */
function servicio_registro($Nombre,$Descripcion,$Precio){
    /*Conexion  a la base de datos */
    $db = conectar();
    try{
        $resultado = $db->query("SELECT COUNT(*) FROM servicio WHERE Nombre='".$Nombre."'");

        if($resultado->fetchColumn() == 0){
            /*El servicio no existe */
            $query = "INSERT INTO `servicio`(`Nombre`, `Descripcion`, `Precio`) VALUES (TRIM(?), TRIM(?), REPLACE(?,' ','')) ";
            $consulta = $db->prepare($query);
            $exito = $consulta->execute([$Nombre,$Descripcion,$Precio]);
            if ($exito != false){
                /*Registro correcto */
                return true;
            }else{
                /*Error en el registro */
                echo "Error en el registro de servicio";
                return false;
            }

        }else{
            /*El servicio  existe */
            return false;
            
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para actualizar un servicio */
function servicio_actualizar($id, $Nombre, $Descripcion,$Precio, $Estado){
    $db = conectar();
    try{
        $query = "UPDATE servicio SET servicio.Nombre = TRIM('$Nombre'), servicio.Descripcion = TRIM('$Descripcion') , servicio.Precio = REPLACE('$Precio',' ',''), servicio.Estado = $Estado WHERE servicio.idServicio = '$id'";
        $exito = $db->query($query);
        if($exito == true){
            /*Actualizacion correcta */
            return true;
        }else{
            /*Error en la actualizacion */
            return false;
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para mostrar servicios */
function servicio_listado(){
    $db = conectar();
    try{
        $query = "SELECT * FROM servicio";
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

/*Funcion para mostrar servicios */
function servicio_listado_id($id){
    $db = conectar();
    try{
        $query = "SELECT * FROM servicio WHERE idServicio = '$id'";
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

/*Funcion para registrar compra */
function compra_registrar($idReservacion, $idServicio, $Precio){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        /*query para saber si la reservación ya tiene ese servicio  */
        $query2 = "SELECT COUNT(*) FROM compra WHERE idReservacion = '$idReservacion' AND idServicio ='$idServicio'";
        $exito_q2 = $db->query($query2);

            if($exito_q2->fetchColumn() >= 1){
                /*La compra ya existe */
                echo "<script> alert('Ya existe una compra con esa reservación'); </script>";
            }else{
                /*querie para insertar en compra*/
                $query3 = "INSERT INTO `compra`( `idReservacion`, `idServicio`, `Fecha`, `Precio`) VALUES ('$idReservacion','$idServicio',(SELECT CURDATE()),'$Precio')";
                /*se preparan consultas */
                $consulta = $db->query($query3);

                /*Comprobacion de registro guardado */
                if($consulta != false){
                    /*se registro bien en compra */
                    return true;
                }else{
                    /*Error al registrar compra */
                    return false;
                }
            }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

?>