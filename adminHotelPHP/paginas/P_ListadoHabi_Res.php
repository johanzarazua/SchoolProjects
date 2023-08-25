
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
                    <h2>Listado de habitaciones disponibles</h2>
                </div>

                <?php
                    include ("../conexiones/CHabitacion.php");
                    $fecha_actual = fecha_bd();
                ?>
                <form  method="post">
                    <div class="form-group">
                        <label for="">Fecha de ingreso:</label>
                        <input type="date"  name="fecha_i" min=<?php echo $fecha_actual?> required>
                        <label for="">Fecha de salida:</label>
                        <input type="date"  name="fecha_s" min=<?php echo date("Y-m-d",strtotime($fecha_actual."+ 1 days"));?> required>
                        <input type="submit" value="Buscar" name="btn_buscar" class="btn btn-info">
                    </div>
                </form>
            
            
                <div class="table-responsive">
                    <table class="table table-hover">
                        <tr>
                            <th>Numero</th>
                            <th>Piso</th>
                            <th>Tipo</th>
                            <th>Descripcion</th>
                            <th>Precio</th>
                            <th>Estado</th>
                            <th></th>
                        </tr>
                            <?php                                
                                if(isset($_POST['btn_buscar'])){
                                    $registro = habitacion_disponibilidad($_POST['fecha_i'],$_POST['fecha_s']);
                                    $f_i = new DateTime($_POST['fecha_i']);
                                    $f_s = new DateTime($_POST['fecha_s']);
                                    $dias = $f_i->diff($f_s);
                                    foreach($registro as $fila){
                            ?>
                        <tr>                 
                                        <td><?php echo $fila['Numero']; ?></td>
                                        <td><?php echo $fila['Piso']; ?></td>
                                        <td><?php echo $fila['Tipo']; ?></td>
                                        <td><?php echo $fila['Descripcion']; ?></td>
                                        <td>$ <?php echo $fila['Precio']; ?></td>
                                        <td><?php echo $fila['Estado']; ?></td>
                                        
                                        <td><a href="P_RegistroReservacion.php?idh=<?php echo urlencode($fila['idHabitacion'])?>&fi=<?php echo urlencode($_POST['fecha_i'])?>&fs=<?php echo urlencode($_POST['fecha_s'])?>&f=<?php echo urlencode($fecha_actual)?>&pr=<?php echo urlencode($fila['Precio'])?>&d=<?php echo urlencode($dias->days)?>&nh=<?php echo urlencode($fila['Numero'])?>&t=<?php echo urlencode($fila['Tipo'])?>" class="btn btn-primary">Reservar</a></td>
                        </tr>
                            <?php
                                    }
                                }
                            ?>
                    </table>
                </div>
                
                <div class="content-center">
                    <p>Estado: 0 = Ocupada ; 1 = Disponible ; 2 = Prereservada </p>
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