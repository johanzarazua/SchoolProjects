<?php
/*Archivo con conexion a base de datos */
include ("conexion.php");


/*Funcion para registrar  */
function cliente_registro($nombre, $apellido_p, $apellido_m, $direccion, $telefono, $email, $tarjeta_credito, $cv, $vencimiento){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
            /*queries para insertar en persona y cliente*/
            $query2 = "INSERT INTO `persona`( `Nombre`, `Apellido_P`, `Apellido_M`, `Direccion`, `Telefono`, `Email`) VALUES (TRIM(?),TRIM(?),TRIM(?),TRIM(?),REPLACE(?,' ',''),TRIM(?))";
            $query3 = "INSERT INTO `cliente`(`idCliente`, `Tarjeta_Credito`, `TC_CV`, `TC_Vencimiento`) VALUES ((SELECT idPersona FROM persona ORDER BY idPersona DESC LIMIT 1),REPLACE(?,' ',''),REPLACE(?,' ',''),REPLACE(?,' ',''))";

            /*se preparan consultas */
            $consulta = $db->prepare($query2);
            $exito_c = $consulta->execute([$nombre, $apellido_p, $apellido_m,$direccion,$telefono,$email]);
            if($exito_c != false){
                /*Se registro la persona */
                $consulta2 = $db->prepare($query3);
                $exito_c2 = $consulta2->execute([$tarjeta_credito, $cv, $vencimiento]);
                
                if($exito_c2 != false){
                    /*Se registro el cliente */
                    return true;

                }else{
                    /*Error al registar cliente */
                    echo "Error en el registro de cliente";
                    return false;
                }
            }else{
                /*Error en el registro de persona */
                return false;
            }

    }catch (Exception $ex){
        echo "Error" . $ex->getMessage();
    }


}

/*Funcion para listar todos los clientes */
function cliente_listado(){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        $query = "SELECT p.idPersona, p.Nombre, p.Apellido_P, p.Apellido_M, p.Direccion, p.Telefono, p.Email, c.Tarjeta_Credito, c.TC_CV, c.TC_Vencimiento, c.Estado FROM persona p INNER JOIN cliente c ON p.idPersona = c.idCliente";
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

/*Funcion para listar los clientes por id */
function cliente_listado_id($apellido_p){
    /*Conexion a la base de datos */
    $db = conectar();
    try{
        $query = "SELECT p.idPersona, p.Nombre, p.Apellido_P, p.Apellido_M, p.Direccion, p.Telefono, p.Email, c.Tarjeta_Credito, c.TC_CV, c.TC_Vencimiento, c.Estado FROM persona p INNER JOIN cliente c ON p.idPersona = c.idCliente WHERE p.Apellido_P = '$apellido_p'";
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

function cliente_actualizar($idCliente,$Nombre, $Apellido_p, $Apellido_m,$Direccion,$Telefono,$Email, $TC, $TC_CV, $TC_V, $Estado){
    $db = conectar();
    try{
        $query = "UPDATE persona, cliente SET persona.Nombre = TRIM('$Nombre') , persona.Apellido_P = TRIM('$Apellido_p') , persona.Apellido_M = ('$Apellido_m'), persona.Direccion = TRIM('$Direccion') , persona.Telefono = REPLACE('$Telefono', ' ','') , persona.Email = TRIM('$Email'), cliente.Tarjeta_Credito = REPLACE('$TC',' ',''), cliente.TC_CV = REPLACE('$TC_CV',' ','') , cliente.TC_Vencimiento = REPLACE('$TC_V',' ',''), cliente.Estado = '$Estado' WHERE idPersona = '$idCliente' AND idCliente = '$idCliente'";
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




?>