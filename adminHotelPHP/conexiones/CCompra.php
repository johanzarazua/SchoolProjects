<?php
/*Archivo con conexion a base de datos */
include ("conexion.php");

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

function compra_listado($idReservacion){
    /*Conexion con la base de datos */
    $db = conectar();
    try{
        /*Consulta  a la tabla habitacion */
        $query = "SELECT c.idCompra, s.Nombre, s.Precio AS Precio_S, c.Precio, c.Fecha FROM compra c INNER JOIN servicio s ON c.idServicio = s.idServicio WHERE c.idReservacion = $idReservacion";
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

/*Funcion para saber el monto total de pagos de una reservacion */
function pagos_realizados($idReservacion){
    $db = conectar();
    try{
        $query = "SELECT idPago, Fecha, Monto FROM pago WHERE idReservacion = '$idReservacion'";
        $consulta = $db->query($query);
        /*Se comprueba si se realiza la consulta */
        if($consulta != false){
            /*Consulta exitosa */
            return $consulta;
        }else{
            /*Error inesperado */
            return false;
        }
    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }

}

/*Funcion para registrar pago */
function pago_registrar($idReservacion, $Monto, $Total , $Pagos){
    /*Conexion a la base de datos */
    $db = conectar();
    /*Se compreuba si aun es posible hacer un pago */
    if (floatval($Total) - floatval($Pagos) <= 0){
        try{
            /*El monto de la reservacion esta cubierto */
            $query = "UPDATE reservacion SET Estado = 0 WHERE idReservacion = '$idReservacion'";
            $query2 = "UPDATE compra SET Estado = 0 WHERE idReservacion = '$idReservacion'";
            $exito_q = $db->query($query);
            $exito_q2 = $db->query($query2);
            if($exito_q ==  true && $exito_q2 == true){
                /*Actualizacion correcta de los estados */
                echo "<script> alert('La reservacion esta pagada, no se pueden hacer mas pagos'); </script>";

            }else{
                /*Las actualizaciones  no se realizaron */
                echo "<script> alert('Error en actualizar estados'); </script>";
            }
        }catch (Exception $ex){
            echo "Error" . $ex->getMessage();
        }
        
    }else{
        try{
            /*querie para insertar en pago*/
            $query3 = "INSERT INTO `pago`( `idReservacion`, `Fecha`, `Monto`) VALUES ('$idReservacion',(SELECT CURDATE()),$Monto)";
            /*se preparan consultas */
            $exito_c = $db->query($query3);

            /*Comprobacion de registro guardado */
            if($exito_c != false){
                /*se registro bien en compra */
                return true;
            }else{
                /*Error al registrar compra */
                echo "<script> alert('Error en el registro de pago'); </script>";
                return false;
            }


        }catch (Exception $ex){
            echo "Error" . $ex->getMessage();
        }
    }
}


?>