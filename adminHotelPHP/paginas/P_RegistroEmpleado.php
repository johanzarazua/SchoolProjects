<?php
    /*Se comprueba si el boton registrar se activa*/
	if(isset($_POST['btn_registro'])){

		include ("../conexiones/CEmpleado.php");
		/*Se almacena el resultado de la funcion registro con los valores del formualrio*/
		$resultado = empleado_registrar($_POST['Nombre'], $_POST['Apellido_P'], $_POST['Apellido_M'], $_POST['Direccion'], $_POST['Telefono'],$_POST['Email'] ,$_POST['Puesto'],$_POST['Usuario'], $_POST['Contraseña'], $_POST['Pregunta_Seguridad'], $_POST['Respuesta_Seguridad']);

		if($resultado != false){
            /*El registro se guarda correctamente y se envia un correo al nuevo cliente*/
            $destinatario = $_POST['Email'];
            $asunto = 'BIENVENIDO';
            $mensaje = "Bienvenido " . $_POST['Nombre']." ".$_POST['Apellido_P']." ". $_POST['Apellido_M']."!!!\nAhora formas parte del grupo de trabajo\n\n\nHOTEL EL DESCANSO MEDIEVAL";
            mail($destinatario, $asunto, $mensaje, 'From: ElDescasoMedieval@gmail.com');
			echo "<script> alert('Te registraste correctamente'); </script>";
		}else{
			/*El registro no se guardo */
			echo "<script> alert('Error en el registro');  </script>";
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
        <title>REGISTRO DE EMPLEADO</title>
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
                <a class="nav-link" href="P_Mantenimiento.php" id="Inicio">Regresar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formularios -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Registro de empleado</h2>
                    <p>ingresa la infromaion del empleado.</p>
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
                            <label for="">Puesto:</label>
                            <select name="Puesto" required class="form-control">
                                    <option disabled selected value="">Seleccione un estado</option>
                                    <option value="G">Gerente</option>
                                    <option value="A">Recepcionista</option>
                            </select>
                        </div>
                            <div class="form-group">
                                <label for="">Usuario:</label>
                                <input type="text" name="Usuario" placeholder="Usuario [sin espacios]" required class="form-control" pattern="^[a-zA-Z0-9_\-]{7}$" title="El usuario debe ser de 7 caracteres, puede contener:
                                    -numeros (0 a 9)
                                    -letras
                                    -caracteres especiales (-, _)" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">Contraseña:</label>
                                <input type="password" name="Contraseña" placeholder="Contraseña" required class="form-control" pattern="^[a-zA-Z0-9_\-#@]{8,36}$" title="La contraseña debe ser minimo de 8 y maximo 36 caracteres, puede contener:
                                    -numeros (0 a 9)
                                    -letras
                                    -caracteres especiales (-, _, #, @)" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label for="">Pregunta de seguridad:</label>
                                <select name="Pregunta_Seguridad" required class="form-control">
                                    <option disabled selected>Seleccione una pregunta de seguridad</option>
                                    <option value="¿Nombre de tu mascota?">¿Nombre de tu mascota?</option>
                                    <option value="Apodo de tu mejor amigo">Apodo de tu mejor amigo</option>
                                    <option value="¿Comida favorita?">¿Comida favorita?</option>
                                    <option value="¿Equipo deportivo favorito?">¿Equipo deportivo favorito?</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="">Respuesta de seguridad:</label>
                                <input type="text" name="Respuesta_Seguridad" placeholder="Respuesta de seguridad" required class="form-control" autocomplete="off">
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