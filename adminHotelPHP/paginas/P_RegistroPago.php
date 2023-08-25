<?php
include ("../conexiones/CCompra.php");
    /*Se comprueba si el boton registrar se activa*/
    if(isset($_POST['btn_registro'])){
        /*Se almacena el resultado de la funcion registro con los valores del formualrio*/
        $resultado = pago_registrar($_GET['idr'], $_POST['Monto'], $_POST['TG'], $_POST['TP'] );

        if($resultado != false){
            /*El pago se registró correctamente */
            echo "<script> alert('Pago registrado correctamente'); </script>";
        }else{
            /*El registro no se guardo */
            echo "<script> alert('Error al registrar');  </script>";
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
        <title>Pago</title>
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
                <a class="nav-link" href="P_Pago_Listado.php" id="iniciar-sesion">Regresar</a>
            </ul>
            </div>
        </div>
        </nav>

        <!-- Menu  -->
        <section id="mantenimiento" class="topmargin-lg">
            <div class="container-fluid">
                <div class="content-center topmargin-lg">
                <h2 ><b>Registrar Pago</b></h2>
                </div>

                <!-- Opciones -->
                <div class="row">  
                    <div class="col-md-6">
                        <div class="man-container">
                            <?php 
                                $Total = floatval($_GET['cos']);
                                $Pagos = 0;
                            ?>
                            <p>
                                <b>Reservacion: </b> <?php echo $_GET['idr'];?><br>
                                <b>Habitacion: </b> <?php echo $_GET['hab']?><br>
                                <b>Fecha de ingreso: </b> <?php echo $_GET['fi']?><br>
                                <b>fecha de salida: </b> <?php echo $_GET['fs']?><br>
                                <b>Costo: </b> $<?php echo $_GET['cos']?><br><br>
                            </p>
                            <div class="table-responsive">
                                <table class="table table-hover">
                                    <tr>
                                        <th>idCompra</th>
                                        <th>Nombre Servicio</th>
                                        <th>Precio del servicio</th>
                                        <th>Precio de la compra</th>
                                        <th>Fecha</th>
                                    </tr>
                                        <?php
                                            $registroan = compra_listado($_GET['idr']);
                                            foreach($registroan as $fila){
                                        ?>
                                    <tr>
                                        <td><?php echo $fila['idCompra']; ?></td>
                                        <td><?php echo $fila['Nombre']; ?></td>
                                        <td><?php echo $fila['Precio_S']; ?></td>
                                        <td><?php echo $fila['Precio']; ?></td>
                                        <td><?php echo $fila['Fecha']; ?></td>
                                        
                                    </tr>
                                        <?php
                                                $Total = $Total + floatval($fila['Precio']);
                                            }

                                            $registro_pagos = pagos_realizados($_GET['idr']);
                                            foreach($registro_pagos as $p){
                                                $Pagos = $Pagos + floatval($p['Monto']);
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
                                    <h2 class="form-signin-heading text-center">REGISTRO</h2>
                                        <div class="form-group">
                                            <label for="">id de Reservación:</label>
                                            <input type="text" name="id_Reservacion" placeholder="Nombre" value="<?php echo $_GET['idr']; ?>" autofocus required class="form-control" disabled select>
                                        </div>
                                        <div class="form-group">
                                            <label>Total reservacion mas servicios:</label>
                                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max=<?php echo $Total - $Pagos?> name="TG" required class="form-control" value=<?php echo $Total?> readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Total de pagos:</label>
                                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max=<?php echo $Total - $Pagos?> name="TP" required class="form-control" value=<?php echo $Pagos?> readonly>
                                        </div>
                                        <div class="form-group">
                                            <label>Monto:</label>
                                            <input type="number" placeholder="Precio [100.00]" step="1.00" min="0" max=<?php echo $Total - $Pagos?> name="Monto" required class="form-control" value=<?php echo $Total - $Pagos?>>
                                        </div>
                                        <div class="form-group d-flex">
                                            <input type="submit" value="Registrar" name="btn_registro" class="btn btn-info ml-auto">
                                        </div>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>
                
                <div class="container">
                    <div class="content-center">
                    <h3><b>Lista de pagos</b></h3>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <tr>
                                <th>ID Pago</th>
                                <th>Fecha</th>
                                <th>Monto</th>
                            </tr>
                            <?php
                                $regis = pagos_realizados($_GET['idr']);
                                foreach($regis as $pags){
                            ?>
                            <tr>
                                <td><?php echo $pags['idPago'];?></td>
                                <td><?php echo $pags['Fecha'];?></td>
                                <td><?php echo $pags['Monto'];?></td>
                            </tr>
                            <?php
                                }
                            ?>
                        </table>
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
