<?php 
    /* Se comprueba si el submit fue activado para inicar sesion*/
    if(isset($_POST['btn_actualizar'])){
        include ("../conexiones/CHabitacion.php");
        /* Se llama a la funcion chabitacion actualizar */
        $registro = habitacion_actualizar($_GET['idh'],$_GET['num'], $_GET['pis'], $_POST['Tipo'], $_POST['Descripcion'], $_POST['Precio'],$_POST['Estado']);

        if($registro != false){
            /*La modificación se guarda correctamente */
            echo "<script> alert('Modificaste la habitación correctamente'); window.location='P_MHab_Listado.php'</script>";
        }else{
            /*La modificación no se guardó */
            echo "<script> alert('Error en el registro, no existe esa habitación'); window.location='P_MHab_Listado.php'</script>";
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
        <title>MANTENIMIENTO HABITACIÓN</title>
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
                <a class="nav-link" href="P_MHab_Listado.php" id="Inicio">Regresar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formulario -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Actualizar habitacion</h2>
                    <p>Por favor actualiza los datos de la habitacion</p>
                </div>

                <form method="post" class="form-signin">
                    <h2 class="form-signin-heading text-center">ACTUALIZAR HABITACIÓN</h2>
                        <div class="form-group">
                            <label>Número:</label>
                            <input type="text" placeholder="Número" name="Numero"  autofocus required class="form-control" pattern="^[0-9]{3}$" title="El numero de habitacion debe de ser de 3 digitos" value=<?php echo $_GET['num'];?> disabled >
                        </div>
                        <div class="form-group">
                            <label>Piso:</label>
                            <input type="text" placeholder="Piso" name="Piso" required class="form-control" pattern="^[0-9]{1,2}$" title="El piso debe de ser de uno o dos digitos" value=<?php echo $_GET['pis'];?> disabled>
                        </div>
                        <div class="form-group">
                            <label>Tipo:</label>
                            <select name="Tipo" required class="form-control">
                                <?php 
                                    if($_GET['tip'] == "Estandar"){
                                ?>
                                <option disabled selected value="">Seleccione un tipo</option>
                                <option value="Estandar" selected>Estandar</option>
                                <option value="Junior suite">Junior suite</option>
                                <?php
                                    }else{
                                ?>
                                <option disabled selected value="">Seleccione un tipo</option>
                                <option value="Estandar" >Estandar</option>
                                <option value="Junior suite" selected>Junior suite</option>
                                <?php
                                    }
                                ?>
                            </select>
                        </div>
                        <div class="form-group">
                            <label>Descripción:</label>
                            <textarea  placeholder="Descripción" name="Descripcion" required class="form-control"><?php echo $_GET['des'];?></textarea>
                        </div>
                        <div class="form-group">
                            <label>Precio:</label>
                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max="9000000" name="Precio" required class="form-control" value=<?php echo $_GET['prec'];?>>
                        </div>
                        <div class="form-group">
                            <label for="">Estado:</label>
                            <select name="Estado" required class="form-control">
                                <?php
                                    if($_GET['est'] == 0){
                                ?>
                                <option disabled selected value="">Seleccione un estado</option>
                                <option value="0" selected>Ocupada</option>
                                <option value="1">Disponible</option>
                                <option value="2">Prereservada</option>
                                <?php
                                    }elseif($_GET['est'] == 1){
                                ?>
                                <option disabled selected value="">Seleccione un estado</option>
                                <option value="0">Ocupada</option>
                                <option value="1" selected>Disponible</option>
                                <option value="2">Prereservada</option>
                                <?php
                                    }elseif($_GET['est'] == 2){
                                ?>
                                <option disabled selected value="">Seleccione un estado</option>
                                <option value="0">Ocupada</option>
                                <option value="1">Disponible</option>
                                <option value="2"selected>Prereservada</option>

                                <?php
                                    }else{
                                ?> 
                                <option disabled selected value="">Seleccione un estado</option>
                                <option value="0">Ocupada</option>
                                <option value="1">Disponible</option>
                                <option value="2">Prereservada</option>
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