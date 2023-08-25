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
        <title>AGREGAR SERVICIO</title>
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
                <a class="nav-link" href="P_Reservacion.php" id="Inicio">Regresar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formularios -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Listado de reservaciones activas</h2>
                </div>

                <form  method="post">
                        <div class="form-group"><label for="">ID de reservacion:</label>
                        <input type="text"  name="ID_RES" placeholder="ID reservacion" pattern="^[0-9]{1,9}$" title="El id de reservacion debe tener al menos un digito y maximo nueve" autocomplete="off">
                        <label for="">Fecha de ingreso:</label>
                        <input type="date"  name="fecha_i" >
                        <input type="submit" value="Buscar" name="btn_buscar" class="btn btn-info">
                        <input type="submit" value="Todas" name="btn_all" class="btn btn-info">
                    </div>
                </form>
            
            
                <div class="table-responsive">
                    <table class="table table-hover">
                        <tr>
                            <th>Fecha</th><!--fecha en la que se realizo la reservacion-->
                            <th>ID</th><!--id reservacion-->
                            <th>Empleado</th><!--nombre y apellidos del empleado-->
                            <th>Cliente</th><!--nombre y apellidos del cleinte-->
                            <th>Habitacion</th><!--numero y tipo de habitacion-->
                            <th>Precio de habitacion</th><!--precio por noche-->
                            <th>Fecha de ingreso</th>
                            <th>Fecha de salida</th>
                            <th>Precio</th><!--precio de la reservacion por el total de dias-->
                            <th></th>
                        </tr>
                            <?php
                                include ("../conexiones/CReservacion.php");                                
                                if(isset($_POST['btn_buscar'])){
                                    $registro = reservacion_listado_filtro($_POST['ID_RES'],$_POST['fecha_i']);
                                    foreach($registro as $fila){
                            ?>
                        <tr>                 
                                        <td><?php echo $fila['Fecha']; ?></td>
                                        <td><?php echo $fila['idReservacion']; ?></td>
                                        <td><?php echo $fila['N_Empleado']." ".$fila['AP_Empleado']." ".$fila['AM_Empleado']; ?></td>
                                        <td><?php echo $fila['N_Cliente']." ".$fila['AP_Cliente']." ".$fila['AM_Clinete']; ?></td>
                                        <td><?php echo $fila['Numero'].", ".$fila['Tipo']; ?></td>
                                        <td><?php echo $fila['Precio']; ?></td>
                                        <td><?php echo $fila['Fecha_Ingreso']; ?> </td>
                                        <td><?php echo $fila['Fecha_Salida']; ?> </td>
                                        <td><?php echo $fila['Costo']; ?> </td>
                                        <td><a href="P_Reservacion_Servicio.php?idr=<?php echo urlencode($fila['idReservacion']); ?>&fi=<?php echo urlencode($fila['Fecha_Ingreso']); ?>&fs=<?php echo urlencode($fila['Fecha_Salida']);?>" class="btn btn-primary">Agregar servicio</a></td>
                        </tr>
                            <?php
                                    }
                                }elseif(isset($_POST['btn_all'])){
                                    $registro = reservacion_listado();
                                    foreach($registro as $fila){
                            ?>
                        <tr>                 
                                        <td><?php echo $fila['Fecha']; ?></td>
                                        <td><?php echo $fila['idReservacion']; ?></td>
                                        <td><?php echo $fila['N_Empleado']." ".$fila['AP_Empleado']." ".$fila['AM_Empleado']; ?></td>
                                        <td><?php echo $fila['N_Cliente']." ".$fila['AP_Cliente']." ".$fila['AM_Clinete']; ?></td>
                                        <td><?php echo $fila['Numero'].", ".$fila['Tipo']; ?></td>
                                        <td><?php echo $fila['Precio']; ?></td>
                                        <td><?php echo $fila['Fecha_Ingreso']; ?> </td>
                                        <td><?php echo $fila['Fecha_Salida']; ?> </td>
                                        <td><?php echo $fila['Costo']; ?> </td>
                                        
                                        <td><a href="P_Reservacion_Servicio.php?idr=<?php echo urlencode($fila['idReservacion']); ?>&fi=<?php echo urlencode($fila['Fecha_Ingreso']); ?>&fs=<?php echo urlencode($fila['Fecha_Salida']);?>" class="btn btn-primary">Agregar servicio</a></td>
                        </tr>
                            <?php
                                    }
                                }
                            ?>
                    </table>
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