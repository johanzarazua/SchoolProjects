<?php
include ("conexion.php");


/*Funcion para registrar una reservacion */
function reservacion_registro($usuario, $nombre, $app, $apm, $idhabitacion, $fi, $fs, $f, $costo){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        $fecha_db = $db->query("SELECT CURDATE()");
        if($fecha_db->fetchColumn() == $fi){
            /*la fecha de ingreso es igua la fecha de la base de datos */
            $query = "INSERT INTO `reservacion`(`idEmpleado`, `idCliente`, `idHabitacion`, `Fecha_Ingreso`, `Fecha_Salida`, `Fecha`, `Costo`) VALUES ((SELECT idEmpleado FROM empleado WHERE Usuario = '$usuario'), (SELECT p.idPersona FROM persona p INNER JOIN cliente c on p.idPersona = c.idCliente WHERE p.Nombre = '$nombre' AND p.Apellido_P = '$app' AND p.Apellido_M = '$apm' AND c.Estado = '1'),'$idhabitacion','$fi','$fs',(select CURDATE()),'$costo')";
            $exito = $db->query($query);
            if ($exito != false){
                /*Registro de reservacion correcto */
                $query2 = "UPDATE habitacion SET Estado = 0 WHERE idHabitacion = '$idhabitacion'";
                $exito2 = $db->query($query2);
                if ($exito2 != false){
                    /*Actualizacion correcta */
                    return true;

                }else{
                    /*No se actualizo el estado de la habitacion */
                    return false;

                }
            }else{
                /*Registro de reservacion correcto */
                return false;
            }
        }else{
            /*la fecha de ingreso es mayor a la fecha de la base de datos */
            $query = "INSERT INTO `reservacion`(`idEmpleado`, `idCliente`, `idHabitacion`, `Fecha_Ingreso`, `Fecha_Salida`, `Fecha`, `Costo`) VALUES ((SELECT idEmpleado FROM empleado WHERE Usuario = '$usuario'), (SELECT p.idPersona FROM persona p INNER JOIN cliente c on p.idPersona = c.idCliente WHERE p.Nombre = '$nombre' AND p.Apellido_P = '$app' AND p.Apellido_M = '$apm' AND c.Estado = '1'),'$idhabitacion','$fi','$fs',(select CURDATE()),'$costo')";
            $exito = $db->query($query);
            if ($exito != false){
                /*Registro de reservacion correcto */
                $query2 = "UPDATE habitacion SET Estado = 2 WHERE idHabitacion = '$idhabitacion'";
                $exito2 = $db->query($query2);
                if ($exito2 != false){
                    /*Actualizacion correcta */
                    return true;

                }else{
                    /*No se actualizo el estado de la habitacion */
                    return false;

                }
            }else{
                /*Registro de reservacion correcto */
                return false;
            }

        }
    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para listar las reservaciones avtivas */
function reservacion_listado_filtro($id, $fi){
    /*Conexion a base de datos */
    $db = conectar();
    try{
        if(strlen($id) == 0 && strlen($fi) > 0){
            /*id vacio */
            $query = "SELECT r.Fecha,r.idReservacion,(SELECT Nombre FROM persona WHERE idPersona = r.idEmpleado)AS N_Empleado,(SELECT Apellido_P FROM persona WHERE idPersona = r.idEmpleado)AS AP_Empleado,(SELECT Apellido_M FROM persona WHERE idPersona = r.idEmpleado)AS AM_Empleado, (SELECT Nombre FROM persona WHERE idPersona = r.idCliente)AS N_Cliente,(SELECT Apellido_P FROM persona WHERE idPersona = r.idCliente)AS AP_Cliente,(SELECT Apellido_M FROM persona WHERE idPersona = r.idCliente)AS AM_Clinete, h.Numero, h.Tipo, h.Precio, r.Fecha_Ingreso, r.Fecha_Salida, r.Costo FROM reservacion r INNER JOIN habitacion h ON r.idHabitacion = h.idHabitacion WHERE r.Fecha_Ingreso = '$fi' AND r.Estado = 1";
            $consulta = $db->query($query);
            if($consulta != false){
                /*Consulta realizada */
                return $consulta;
            }else{
                /*Error en la consulta */
                return false;

            }

        }elseif(strlen($id) > 0 && strlen($fi) == 0){
            $query = "SELECT r.Fecha,r.idReservacion,(SELECT Nombre FROM persona WHERE idPersona = r.idEmpleado)AS N_Empleado,(SELECT Apellido_P FROM persona WHERE idPersona = r.idEmpleado)AS AP_Empleado,(SELECT Apellido_M FROM persona WHERE idPersona = r.idEmpleado)AS AM_Empleado, (SELECT Nombre FROM persona WHERE idPersona = r.idCliente)AS N_Cliente,(SELECT Apellido_P FROM persona WHERE idPersona = r.idCliente)AS AP_Cliente,(SELECT Apellido_M FROM persona WHERE idPersona = r.idCliente)AS AM_Clinete, h.Numero, h.Tipo, h.Precio, r.Fecha_Ingreso, r.Fecha_Salida, r.Costo FROM reservacion r INNER JOIN habitacion h ON r.idHabitacion = h.idHabitacion WHERE r.idReservacion = '$id' AND r.Estado = 1";
            $consulta = $db->query($query);
            if($consulta != false){
                /*Consulta realizada */
                return $consulta;
            }else{
                /*Error en la consulta */
                return false;

            }

        }elseif(strlen($id) == 0 && strlen($fi) == 0){
            $query = "SELECT r.Fecha,r.idReservacion,(SELECT Nombre FROM persona WHERE idPersona = r.idEmpleado)AS N_Empleado,(SELECT Apellido_P FROM persona WHERE idPersona = r.idEmpleado)AS AP_Empleado,(SELECT Apellido_M FROM persona WHERE idPersona = r.idEmpleado)AS AM_Empleado, (SELECT Nombre FROM persona WHERE idPersona = r.idCliente)AS N_Cliente,(SELECT Apellido_P FROM persona WHERE idPersona = r.idCliente)AS AP_Cliente,(SELECT Apellido_M FROM persona WHERE idPersona = r.idCliente)AS AM_Clinete, h.Numero, h.Tipo, h.Precio, r.Fecha_Ingreso, r.Fecha_Salida, r.Costo FROM reservacion r INNER JOIN habitacion h ON r.idHabitacion = h.idHabitacion WHERE r.Estado = 1";
            $consulta = $db->query($query);
            if($consulta != false){
                /*Consulta realizada */
                return $consulta;
            }else{
                /*Error en la consulta */
                return false;
            }
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }

}


/*Funcion para listar todas las reservaciones */
function reservacion_listado(){
    $db = conectar();
    try{
        $query = "SELECT r.Fecha,r.idReservacion,(SELECT Nombre FROM persona WHERE idPersona = r.idEmpleado)AS N_Empleado,(SELECT Apellido_P FROM persona WHERE idPersona = r.idEmpleado)AS AP_Empleado,(SELECT Apellido_M FROM persona WHERE idPersona = r.idEmpleado)AS AM_Empleado, (SELECT Nombre FROM persona WHERE idPersona = r.idCliente)AS N_Cliente,(SELECT Apellido_P FROM persona WHERE idPersona = r.idCliente)AS AP_Cliente,(SELECT Apellido_M FROM persona WHERE idPersona = r.idCliente)AS AM_Clinete, h.Numero, h.Tipo, h.Precio, r.Fecha_Ingreso, r.Fecha_Salida, r.Costo FROM reservacion r INNER JOIN habitacion h ON r.idHabitacion = h.idHabitacion WHERE r.Estado = 1";
        $consulta = $db->query($query);
        if($consulta != false){
            /*Consulta realizada */
            return $consulta;
        }else{
            /*Error en la consulta */
            return false;
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para recuperar correo de cliente */
function correo_cliente($nombre, $app, $apm){
    $db = conectar();
    try{
        $query = "SELECT Email FROM persona WHERE Nombre = '$nombre' AND Apellido_P = '$app' AND Apellido_M = '$apm'";
        $email =  $db->query($query);
        if($email != false){
            /*Se enontro correo del cliente */
            return $email->fetchColumn();

        }else{
            /*No se encontro correo para el usuario */
            echo "<script> alert('Error en el registro de persona'); </script>";
            return "";
        }
    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }

}

function numero_habitacion($idh){
    $db = conectar();
    try{
        $habitacion = "Habitacion: ";
        $query = "SELECT Numero, Tipo, Descripcion, Precio FROM habitacion WHERE idHabitacion = '$idh'";
        $hab =  $db->query($query);
        foreach($hab as $aux){
            $habitacion = $habitacion.$aux['Numero'].", ".$aux['Tipo']."\nPrecio por noche: $".$aux['Precio']."\nDescripcion: ".$aux['Descripcion'];
        }
        return $habitacion;
    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }

}


?>