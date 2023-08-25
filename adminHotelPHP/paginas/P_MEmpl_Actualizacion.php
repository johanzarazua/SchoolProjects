<?php
    /*Se comprueba si el boton registrar se activa*/
	if(isset($_POST['btn_actualizar'])){

		include ("../conexiones/CEmpleado.php");
		/*Se almacena el resultado de la funcion registro con los valores del formualrio*/
		$resultado = empleado_actualizar($_GET['ide'],$_POST['Nombre'],$_POST['Apellido_P'],$_POST['Apellido_M'] ,$_POST['Direccion'], $_POST['Telefono'],$_POST['Puesto'],$_POST['Email'] , $_POST['Estado']);

		if($resultado != false){
			/*El registro se guarda correctamente */
            echo "<script> alert('Actualizacion guadada');  window.location='P_MEmpl_Listado.php'</script>";
		}else{
			/*El registro no se guardo */
			echo "<script> alert('Error en la actualizacion');  window.location='P_MEmpl_Listado.php'</script>";
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
        <title>MANTENIMIENTO EMPLEADO</title>
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
                <a class="nav-link" href="P_MEmpl_Listado.php" id="Inicio">Regresar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formularios -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Actualizar empleado</h2>
                    <p>Por favor actualiza los datos del empleado</p>
                </div>
                <form method="post" class="form-signin">
                    <h2 class="form-signin-heading text-center">ACTUALIZAR EMPLEADO</h2>
                        <div class="form-group">
                            <label for="">Nombre:</label>
                            <input type="text" name="Nombre" placeholder="Nombre" value="<?php echo $_GET['no']; ?>" autofocus required class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Apellido paterno:</label>
                            <input type="text" name="Apellido_P" placeholder="Apellido paterno" value="<?php echo $_GET['app']; ?>" required class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Apellido materno:</label>
                            <input type="text" name="Apellido_M" placeholder="Apellido materno" value="<?php echo $_GET['apm']; ?>" required class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Direccion:</label>
                            <textarea  name="Direccion" placeholder="Calle #, cp, delegacion, ciudad"  required class="form-control"><?php echo $_GET['di']; ?></textarea>
                        </div>
                        <div class="form-group">
                            <label for="">Telefono:</label>
                            <input type="tel" name="Telefono" placeholder="Teléfono [10 digitos]" value="<?php echo $_GET['te']; ?>" required class="form-control" pattern="^[0-9]{10}$" title="El numero debe ser de 10 digitos">
                        </div>
                        <div class="form-group">
                            <label for="">Email:</label>
                            <input type="email" name="Email" placeholder="Email" value="<?php echo $_GET['em']; ?>" required class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="">Puesto:</label>
                            <select name="Puesto" required class="form-control">
                                    <?php
                                        if($_GET['pu'] == "G"){
                                    ?>
                                    <option disabled selected value="">Seleccione un estado</option>
                                    <option value="G" selected>Gerente</option>
                                    <option value="A">Recepcionista</option>
                                    <?php 
                                        }else{
                                    ?>
                                    <option disabled selected value="">Seleccione un estado</option>
                                    <option value="G" >Gerente</option>
                                    <option value="A" selected>Recepcionista</option>
                                    <?php 
                                        }
                                    ?>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="">Usuario:</label>
                            <input type="text" name="Usuario" placeholder="Usuario [sin espacios]" value="<?php echo $_GET['us']; ?>" required class="form-control" pattern="^[a-zA-Z0-9_\-]{7}$" title="El usuario debe ser minimo de 6 caracteres, puede contener:
                                    -numeros (0 a 9)
                                    -letras
                                    -caracteres especiales (-, _)" readonly>
                        </div> 
                        <div class="form-group">
                            <label for="">Estado:</label>
                            <select name="Estado" required class="form-control">
                                    <?php
                                        if($_GET['es'] == "1"){
                                    ?>
                                    <option disabled selected value="">Seleccione un estado</option>
                                    <option value="0" >Inactivo</option>
                                    <option value="1" selected>Activo</option>
                                    <?php 
                                        }else{
                                    ?>
                                    <option disabled selected value="">Seleccione un estado</option>
                                    <option value="0" selected>Inactivo</option>
                                    <option value="1" >Activo</option>
                                    <?php 
                                        }
                                    ?>
                            </select>
                        </div>

                        <div class="form-group d-flex">
                            <input type="submit" value="Actualizar" name="btn_actualizar" class="btn btn-info ml-auto topmargin-xs">
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