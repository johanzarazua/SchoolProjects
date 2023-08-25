<?php
    /*Se comprueba si el boton registrar se activa*/
	if(isset($_POST['btn_registro'])){

		include ("../conexiones/CServicio.php");
		/*Se almacena el resultado de la funcion registro con los valores del formualrio*/
		$resultado = servicio_registro($_POST['Nombre'], $_POST['Descripcion'], $_POST['Precio']);

		if($resultado != false){
			/*El registro se guarda correctamente */
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
        <title>REGISTRO DE SERVICIO</title>
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
                    <h2>Registro de servicio</h2>
                    <p>ingresa la información del servicio.</p>
                </div>

                <form method="post" class="form-signin">
                            <h2 class="form-signin-heading text-center">REGISTRO</h2>
                            <div class="form-group">
                                <label for="">Nombre:</label>
                                <input type="text" name="Nombre" placeholder="Nombre" autofocus required class="form-control" autocomplete="off">
                            </div>
                            <div class="form-group">
                                <label>Descripción:</label>
                                <textarea  placeholder="Descripción" name="Descripcion" required class="form-control"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Precio:</label>
                                <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max="9000000" name="Precio" required class="form-control" autocomplete="off">
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