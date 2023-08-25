<?php
include ("../conexiones/CServicio.php");

    /*Se comprueba si el boton registrar se activa*/
    if(isset($_POST['btn_registro'])){

        /*Se almacena el resultado de la funcion registro con los valores del formualrio*/
        $resultado = compra_registrar($_GET['idr'],$_POST['ID_S'] , $_POST['Precio']);

        if($resultado != false){
            /*El servicio se agregó correctamente */
            echo "<script> alert('Servicio agregado correctamente'); </script>";
        }else{
            /*El registro no se guardo */
            echo "<script> alert('Error al agregar');  </script>";
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
        <title>Agregar Servicio</title>
    </head>
    <body>
        <!-- Menu -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <a class="navbar-brand" href="" id="iniciar-sesion"><img src="../imagenes/logotipo.jpg" class="logo-brand" alt="logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_ListadoReserv_Serv.php" id="iniciar-sesion">Regresar</a>
            </ul>
            </div>
        </div>
        </nav>

        <!-- Menu  -->
        <section id="mantenimiento" class="topmargin-lg">
            <div class="container-fluid">
                <div class="content-center topmargin-lg">
                <h2 ><b>Agregar servicio a la reservación</b></h2>
                </div>
            
                <!-- Opciones -->
                <div class="row">  
                    <div class="col-md-6">
                        <div class="man-container">
                             <div class="table-responsive">
                                    <table class="table table-hover topmargin-lg">
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Precio</th>
                                            <th></th>
                                        </tr>
                                            <?php
                                                $registro = servicio_listado();
                                                /*Se recorren todas las filas de las columnas */
                                                foreach($registro as $fila){ 
                                            ?>
                                        <tr>
                                            <td ><?php echo $fila['idServicio']; ?></td>
                                            <td ><?php echo $fila['Nombre']; ?></td>
                                            <td ><?php echo $fila['Precio']; ?></td>
                                            <td>
                                                <form method="post">
                                                <input type="hidden" name="ids" value="<?php echo $fila['idServicio']; ?>">
                                                <input type="hidden" name="Nom" value="<?php echo $fila['Nombre']; ?>">
                                                <input type="hidden" name="Pre" value="<?php echo $fila['Precio']; ?>">
                                                <input type="submit" value="Seleccionar" name="btn_sel" class="btn btn-info">
                                                </form>
                                            </td>
                                        </tr>
                                            <?php
                                                }
                                            ?>

                                    </table>  
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-md-6">
                        <section id="formulario">
                            <div class="container">
                                <form method="post" class="form-signin">
                                    <h2 class="form-signin-heading text-center">MODIFICACIÓN</h2>
                                    <?php
                                    $f_i = new DateTime($_GET['fi']);
                                    $f_s = new DateTime($_GET['fs']);
                                    $dias = $f_i->diff($f_s);
                                    if(isset($_POST['btn_sel'])){
                                        
                                    ?>
                                        <div class="form-group">
                                            <label for="">ID servicio:</label>
                                            <input type="text" name="ID_S" placeholder="ID servicio" value="<?php echo $_POST['ids']; ?>" autofocus required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label for="">Nombre:</label>
                                            <input type="text" name="Nombre" placeholder="Nombre" value="<?php echo $_POST['Nom']; ?>" autofocus required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Precio (por día):</label>
                                            <input type="number" placeholder="Precio [100.00]" value="<?php echo $_POST['Pre']; ?>" step="1.00" min="0" max="9000000" name="Precio_D" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Total (dias de reservacion):</label>
                                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max="9000000" name="Precio" required class="form-control" readonly value="<?php echo ($dias->days) * floatval($_POST['Pre']) ?>">
                                        </div>
                                        <div class="form-group d-flex">
                                            <input type="submit" value="Agregar" name="btn_registro" class="btn btn-info ml-auto">
                                        </div>
                                    <?php
                                        
                                        }else{
                                    ?>
                                        <div class="form-group">
                                            <label for="">ID servicio:</label>
                                            <input type="text" name="ID_S" placeholder="ID servicio"  autofocus required class="form-control">
                                        </div>                                    
                                        <div class="form-group">
                                            <label for="">Nombre:</label>
                                            <input type="text" name="Nombre" placeholder="Nombre" autofocus required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Precio (por día):</label>
                                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max="9000000" name="Precio_D" required class="form-control">
                                        </div>
                                        <div class="form-group">
                                            <label>Total (dias de reservacion):</label>
                                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max="9000000" name="Precio" required class="form-control" readonly>
                                        </div>
                                        <div class="form-group d-flex">
                                            <input type="submit" value="Agregar" name="btn_registro" class="btn btn-info ml-auto">
                                        </div>
                                    <?php
                                        }
                                    ?>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>            
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