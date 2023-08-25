<?php
    /*Se comprueba si el boton registrar se activa*/
	if(isset($_POST['btn_registro'])){

		include ("../conexiones/CCliente.php");
		/*Se almacena el resultado de la funcion registro con los valores del formualrio*/
		$resultado = cliente_registro($_POST['Nombre'], $_POST['Apellido_P'], $_POST['Apellido_M'], $_POST['Direccion'], $_POST['Telefono'], $_POST['Email'], $_POST['Tarjeta_Credito'], $_POST['TC_CV'], $_POST['TC_Vencimiento']);

		if($resultado != false){
            /*El registro se guarda correctamente */
            $destinatario = $_POST['Email'];
            $asunto = 'BIENVENIDO';
            $mensaje = "Bienvenido " . $_POST['Nombre']." ".$_POST['Apellido_P']." ". $_POST['Apellido_M']."!!!\nAhora eres cliente, esperamos que disfrutes de nuestras instalaciones y servicios\n\n\nHOTEL EL DESCANSO MEDIEVAL";
            mail($destinatario, $asunto, $mensaje, 'From: ElDescasoMedieval@gmail.com');
			echo "<script> alert('Se registro correctamente');</script>";
		}else{
			/*El registro no se guardo */
			echo "<script> alert('Error en el registro');</script>";
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
        <title>REGISTRO DE CLIENTE</title>
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
                <?php
                    session_start();
                    if(!isset($_SESSION['usuario'])){
                ?>
                <li class="nav-item">
                <a class="nav-link" href="../index.html" id="Inicio">Cancelar</a>
                </li>
                <?php
                    }else{
                ?>
                <li class="nav-item">
                <a class="nav-link" href="P_Inicial.php" id="Inicio">Cancelar</a>
                </li>
                <?php
                    }
                ?>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formularios -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Registro de cliente</h2>
                    <p>ingresa la infromaion del cliente.</p>
                </div>

                <form method="post" class="form-signin">
                            <h2 class="form-signin-heading text-center">REGISTRO</h2>
                            <div class="form-group">
                                <label for="">Nombre:</label>
                                <input type="text" name="Nombre" placeholder="Nombre" autofocus required class="form-control" autocomplete="off">
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
                                <label for="">Direccion:</label>
                                <input type="text" name="Direccion" placeholder="Calle #, cp, delegacion, ciudad" required class="form-control" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">Telefono:</label>
                                <input type="tel" name="Telefono" placeholder="Telefono [10 digitos]" required class="form-control" pattern="^[0-9]{10}$" title="El numero debe ser de 10 digitos" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">Email:</label>
                                <input type="email" name="Email" placeholder="Email" required class="form-control" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">Tarjeta de credito:</label>
                                <input type="text" name="Tarjeta_Credito" placeholder="Tarjeta de crédito [16 digitos]" required class="form-control" pattern="^[0-9]{16}$" title="Numero de tarjeta de 16 digitos" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">CV:</label>
                                <input type="text" name="TC_CV" placeholder="CV [3 o 4 digitos]" required class="form-control" pattern="^[0-9]{3,4}" title="El CV debe ser de 3 o 4 digitos" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">Fecha de vencimiento:</label>
                                <input type="text" name="TC_Vencimiento" placeholder="Fecha de vencimiento [mm/yy]" required class="form-control" pattern="^[0-9]{2}/[0-9]{2}" title="Formato incorrecto de fecha de vencimiento [mm/yy]" autocomplete="off">
                            </div>
                            <div class="form-group d-flex">
                                <input type="submit" value="Registrar" name="btn_registro" class="btn btn-info ml-auto">
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