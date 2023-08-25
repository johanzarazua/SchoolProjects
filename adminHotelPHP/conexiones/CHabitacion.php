<?php
include ("conexion.php");

/*Funcion para consultar todas la habitaciones */
function habitaciones_listado(){
    /*Conexion con la base de datos */
    $db = conectar();
    try{
        /*Consulta  a la tabla habitacion */
        $query = "SELECT * FROM habitacion";
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

/*Funcion para consultar habitaciones por piso */
function habitaciones_listado_piso($piso){
    /*Conexion con la base de datos */
    $db = conectar();
    try{
        /*Consulta  a la tabla habitacion */
        $query = "SELECT * FROM habitacion WHERE Piso = '$piso'";
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

/*Funcion para registrar nueva habitacion */
function habitacion_registro($numero,$piso,$tipo,$descripcion,$precio){
    /*Conexion  a la base de datos */
    $db = conectar();
    try{
        $resultado = $db->query("SELECT COUNT(*) FROM habitacion WHERE Numero='".$numero."' AND Piso='".$piso."'");

        if($resultado->fetchColumn() == 0){
            /*La habitacion no existe */
            $query = "INSERT INTO `habitacion`(`Numero`, `Piso`, `Tipo`, `Descripcion`, `Precio`) VALUES (REPLACE(?,' ',''),REPLACE(?,' ',''),TRIM(?),TRIM(?),REPLACE(?,' ','')) ";
            $consulta = $db->prepare($query);
            $exito = $consulta->execute([$numero,$piso,$tipo,$descripcion,$precio]);
            if ($exito != false){
                /*Registro correcto */
                return true;
            }else{
                /*Error en el registro */
                echo "Error en el registro de habitacion";
                return false;
            }

        }else{
            /*La habitacion no existe */
            return false;
            
        }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }
}

/*Funcion para actualizar habitacion */
function habitacion_actualizar($id,$numero,$piso,$tipo,$descripcion,$precio,$estado){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        $query = "UPDATE `habitacion` SET `Numero`=REPLACE('$numero',' ','') ,`Piso`=REPLACE('$piso',' ','') ,`Tipo`= TRIM('$tipo') ,`Descripcion`=TRIM('$descripcion') ,`Precio`=REPLACE('$precio',' ',''),`Estado`='$estado' WHERE `idHabitacion`='$id'";
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

/*Funcion para mostrar las hbaitaciones disponibles para reservacion */
function habitacion_disponibilidad($fi, $fs){
    $db = conectar();
    try{
        $query = "SELECT idHabitacion, Numero, Piso,Tipo,Descripcion, Precio, Estado FROM habitacion WHERE Estado = 1 UNION SELECT idHabitacion, Numero, Piso,Tipo,Descripcion, Precio,Estado FROM habitacion WHERE idHabitacion IN (SELECT idHabitacion FROM `reservacion` WHERE (Fecha_Ingreso NOT BETWEEN '$fi' AND '$fs') AND (Fecha_Salida NOT BETWEEN '$fi' AND '$fs')) AND Estado = 2 ORDER BY idHabitacion ASC ";
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


function fecha_bd(){
    $db = conectar();
    try{
        $query = "SELECT CURDATE()";
        $fecha = $db->query($query);
        return $fecha->fetchColumn();
    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }

}


?>