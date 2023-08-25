<?php
    session_start();
    /*Se comprueba si el boton registrar se activa*/
	if(isset($_POST['btn_actualizar'])){

        include ("../conexiones/CReservacion.php");
        $destinatario = correo_cliente($_POST['Nombre'],$_POST['Apellido_P'],$_POST['Apellido_M']);
        if ($destinatario != ""){
            /*Se almacena el resultado de la funcion registro con los valores del formulario*/
            $resultado = reservacion_registro($_SESSION['usuario'],$_POST['Nombre'],$_POST['Apellido_P'],$_POST['Apellido_M'],$_GET['idh'] ,$_POST['Fecha_Ingreso'], $_POST['Fecha_Salida'], $_POST['Fecha'], $_POST['Costo']);

            if($resultado != false){
                /*El registro se guarda correctamente */
                $asunto = "RESERVACION REALIZADA";
                $habitacion =  numero_habitacion($_GET['idh']);
                $mensaje = "Hola ". $_POST['Nombre']." ".$_POST['Apellido_P']." ". $_POST['Apellido_M']."\nSe realizo correctamente tu reservacion. La informacion de la reservacion es:\n".$habitacion."\nFecha de ingreso: ".$_POST['Fecha_Ingreso']."\nFecha de salida: ".$_POST['Fecha_Salida']."\nPrecio total: $".$_POST['Costo']."\n\nEsperamos que disfrute su estancia\n\n\nHOTEL EL DESCANSO MEDIEVAL";
                mail($destinatario, $asunto, $mensaje, 'From: ElDescasoMedieval@gmail.com');
                echo "<script> alert('Registro guardado');  window.location= 'P_ListadoHabi_Res.php'</script>";
            }else{
                /*El registro no se guardo */
                echo "<script> alert('Error en el registro'); window.location= 'P_ListadoHabi_Res.php'</script>";
            }
        }else{
            /*No se encontro correo para el usuario */
            echo "<script> alert('Error en el registro de persona'); </script>";
        }
	}

?>



<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;600&display=swap" rel="stylesheet"> 
        <!-- ionicons -->
        <script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>

        <link rel="stylesheet" href="../css/Estilo.css">
        <title>Registro Reservación</title>
    </head>
    <body>
        
        <!-- Menu -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <a class="navbar-brand" href=""><img src="../imagenes/logotipo.jpg" class="logo-brand" alt="logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                <a class="nav-link" href="P_ListadoHabi_Res.php" id="Inicio">Regresar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formularios -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Reservacion</h2>
                    <p>Por favor ingresa los datos del cliente para completar la reservacion</p>
                    <p><small>El nombre y apellidos deben estar previamente registrados para realizar la reservacion</small></p>
                </div>
                <form method="post" class="form-signin">
                    <h2 class="form-signin-heading text-center">RESERVACIÓN</h2>
                        <div class="form-group">
                            <label for="">Nombre:</label>
                            <input type="text" name="Nombre" placeholder="Nombre"  autofocus required class="form-control" autocomplete="off">
                        </div>
                        <div class="form-group">
                            <label for="">Apellido paterno:</label>
                            <input type="text" name="Apellido_P" placeholder="Apellido paterno" required class="form-control" autocomplete="off">
                        </div>
                        <div class="form-group">
                            <label for="">Apellido materno:</label>
                            <input type="text" name="Apellido_M" placeholder="Apellido materno" required class="form-control" autocomplete="off">
                        </div>
                        <div class="form-group">
                            <label for="">Habitacion:</label>
                            <input type="text" name="Habitacion" placeholder="Nombre"  autofocus required class="form-control" readonly value="<?php echo $_GET['nh']?>">
                        </div>
                        <div class="form-group">
                            <label for="">Tipo de habitacion:</label>
                            <input type="text" name="TipoH" placeholder="Nombre"  autofocus required class="form-control" readonly value="<?php echo $_GET['t']?>">
                        </div>
                        <div class="form-group">
                            <label for="">Precio por noche:</label>
                            <input type="number" name="PrecioNoche" placeholder="Nombre"  autofocus required class="form-control" readonly value="<?php echo $_GET['pr']?>">
                        </div>
                        <div class="form-group">
                            <label for="">Fecha de ingreso:</label>
                            <input type="date" name="Fecha_Ingreso" placeholder="año-mes-día"  required class="form-control" value="<?php echo $_GET['fi']; ?>" readonly>
                        </div>
                        <div class="form-group">
                            <label for="">Fecha de salida:</label>
                            <input type="date" name="Fecha_Salida" placeholder="año-mes-día" value="<?php echo $_GET['fs']; ?>" required class="form-control" readonly>
                        </div>
                        <div class="form-group">
                            <label for="">Dias de estancia:</label>
                            <input type="text" name="DIas" placeholder="Apellido materno" required class="form-control"  value="<?php echo $_GET['d'] ?>" readonly>
                        </div>
                        <div class="form-group">
                            <label>Costo:</label>
                            <input type="number" placeholder="Costo [100.00]" step="1.00" min="0" max="9000000" name="Costo" required class="form-control" readonly value="<?php echo intval($_GET['d']) * floatval($_GET['pr']) ?>">
                        </div>
                        <div class="form-group">
                            <label for="">Fecha:</label>
                            <input type="date" name="Fecha" placeholder="año-mes-día" value="<?php echo $_GET['f']; ?>" required class="form-control" readonly>
                        </div>
                        <div class="form-group d-flex">
                            <input type="submit" value="Registrar" name="btn_actualizar" class="btn btn-info ml-auto topmargin-xs">
                        </div>
                </form>
            </div>
        </section>

        <section id="footer" class="bd-f"> 
            <div class="container">
                <div class="content-center">
                <p><b>El descanso medieval</b></p>
                <p>......................................................</p>
                </div>
            </div>
        </section>
        
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>