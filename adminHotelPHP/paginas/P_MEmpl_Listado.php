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
                    <h2>Listado de empleados</h2>
                </div>

                <form  method="post">
                    <div class="form-group">
                        <input type="text" placeholder="ID Empleado" name="ID_E" pattern="^[0-9]{1,6}$" title="El ID de empleado debe tener minimo un digito y maximo 6" autocomplete="off">
                        <input type="submit" value="Buscar" name="btn_buscar" class="btn btn-info">
                        <input type="submit" value="Todos" name="btn_all" class="btn btn-info">
                    </div>
                </form>

                <div class="table-responsive">
                    <table class="table table-hover">
                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Apellido paterno</th>
                            <th>Apellido materno</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>Puesto</th>
                            <th>Usuario</th>
                            <th>Estado</th>
                            <th></th>
                        </tr>
                            <?php
                                /*Consulta de todos los usuarios */
                                include ("../conexiones/CEmpleado.php");
                                if(isset($_POST['btn_buscar'])){
                                    if($_POST['ID_E'] != 0){
                                        $registro = empleado_listado_id($_POST['ID_E']);
                                        /*Se recorre todas las filas de la consulta */
                                        foreach($registro as $fila){
                            ?>
                        <tr>
                                        <td><?php echo $fila['idPersona']; ?></td>
                                        <td><?php echo $fila['Nombre']; ?></td>
                                        <td><?php echo $fila['Apellido_P']; ?></td>
                                        <td><?php echo $fila['Apellido_M']; ?></td>
                                        <td><?php echo $fila['Direccion']; ?></td>
                                        <td><?php echo $fila['Telefono']; ?></td>
                                        <td><?php echo $fila['Email']; ?></td>
                                        <td><?php echo $fila['Puesto']; ?></td>
                                        <td><?php echo $fila['Usuario']; ?></td>
                                        <td><?php echo $fila['Estado']; ?></td>
                                        <td><a href="P_MEmpl_Actualizacion.php?ide=<?php echo urlencode($fila['idPersona'])?>&no=<?php echo urlencode($fila['Nombre'])?>&app=<?php echo urlencode($fila['Apellido_P'])?>&apm=<?php echo urlencode($fila['Apellido_M'])?>&di=<?php echo urlencode($fila['Direccion'])?>&te=<?php echo urlencode($fila['Telefono'])?>&em=<?php echo urlencode($fila['Email'])?>&us=<?php echo urlencode($fila['Usuario'])?>&es<?php echo urlencode($fila['Estado'])?>&pu=<?php echo urlencode($fila['Puesto'])?>" class="btn btn-primary">Actualizar</a></td>
                        </tr>
                            <?php
                                        }
                                    }elseif($_POST['ID_E'] == 0){
                                        $registro = empleado_listado();
                                        /*Se recorre todas las filas de la consulta */
                                        foreach($registro as $fila){
                            ?>
                        <tr>
                                        <td><?php echo $fila['idPersona']; ?></td>
                                        <td><?php echo $fila['Nombre']; ?></td>
                                        <td><?php echo $fila['Apellido_P']; ?></td>
                                        <td><?php echo $fila['Apellido_M']; ?></td>
                                        <td><?php echo $fila['Direccion']; ?></td>
                                        <td><?php echo $fila['Telefono']; ?></td>
                                        <td><?php echo $fila['Email']; ?></td>
                                        <td><?php echo $fila['Puesto']; ?></td>
                                        <td><?php echo $fila['Usuario']; ?></td>
                                        <td><?php echo $fila['Estado']; ?></td>
                                        <td><a href="P_MEmpl_Actualizacion.php?ide=<?php echo urlencode($fila['idPersona'])?>&no=<?php echo urlencode($fila['Nombre'])?>&app=<?php echo urlencode($fila['Apellido_P'])?>&apm=<?php echo urlencode($fila['Apellido_M'])?>&di=<?php echo urlencode($fila['Direccion'])?>&te=<?php echo urlencode($fila['Telefono'])?>&em=<?php echo urlencode($fila['Email'])?>&us=<?php echo urlencode($fila['Usuario'])?>&es<?php echo urlencode($fila['Estado'])?>&pu=<?php echo urlencode($fila['Puesto'])?>" class="btn btn-primary">Actualizar</a></td>
                        </tr>
                            <?php
                                        }
                                    }
                                }elseif(isset($_POST['btn_all']) ){
                                    $registro = empleado_listado();
                                    /*Se recorre todas las filas de la consulta */
                                    foreach($registro as $fila){
                            ?>
                        <tr>
                                    <td><?php echo $fila['idPersona']; ?></td>
                                    <td><?php echo $fila['Nombre']; ?></td>
                                    <td><?php echo $fila['Apellido_P']; ?></td>
                                    <td><?php echo $fila['Apellido_M']; ?></td>
                                    <td><?php echo $fila['Direccion']; ?></td>
                                    <td><?php echo $fila['Telefono']; ?></td>
                                    <td><?php echo $fila['Email']; ?></td>
                                    <td><?php echo $fila['Puesto']; ?></td>
                                    <td><?php echo $fila['Usuario']; ?></td>
                                    <td><?php echo $fila['Estado']; ?></td>
                                    <td><a href="P_MEmpl_Actualizacion.php?ide=<?php echo urlencode($fila['idPersona'])?>&no=<?php echo urlencode($fila['Nombre'])?>&app=<?php echo urlencode($fila['Apellido_P'])?>&apm=<?php echo urlencode($fila['Apellido_M'])?>&di=<?php echo urlencode($fila['Direccion'])?>&te=<?php echo urlencode($fila['Telefono'])?>&em=<?php echo urlencode($fila['Email'])?>&us=<?php echo urlencode($fila['Usuario'])?>&es<?php echo urlencode($fila['Estado'])?>&pu=<?php echo urlencode($fila['Puesto'])?>" class="btn btn-primary">Actualizar</a></td>

                        </tr>
                            <?php 
                                    }
                                } 
                            ?>
                    </table>

                </div>  
                
                <div class="content-center">
                    <p>Puesto: G = Gerente ; A = Reepcionista</p>
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