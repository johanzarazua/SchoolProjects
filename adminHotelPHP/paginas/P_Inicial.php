<?php
session_start();
if(!isset($_SESSION['usuario'])){
    header('Location: ../index.html');
    exit;
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
        <title>EL DESCANSO MEDIEVAL</title>
    </head>
    <body>

<?php
    if($_SESSION['puesto'] == "G"){

?>
        <!-- Menu -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <a class="navbar-brand" href="P_Inical.php"><img src="../imagenes/logotipo.jpg" class="logo-brand" alt="logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                </li>
                <li class="nav-item">
                <a class="nav-link" href="CerrarSesion.php" id="cerrar-sesion">Cerrar sesion</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_Reservacion.php" id="Reservacion">Reservacion</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_RegistroCliente.php" id="RegistroC">Registro de cliente</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_Pago_Listado.php" id="Pago">Pago</a>
                </li>
                <li class="nav-item active">
                <a class="nav-link" href="P_Mantenimiento.php" id="Mantenimiento">Mantenimiento</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        <!-- Banner -->
        <section id="banner"> 
            <div class="container">
            
            </div>
        </section>

        <!-- Menu  -->
        <section id="portfolio">
            <div class="container-fluid">
                <div class="content-center">
                <h2 ><b>Bienvenido <?php echo $_SESSION['usuario'];?></b></h2>
                </div>
            
                <!-- Opciones -->
                <div class="row">

                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_Reservacion.php"><img src="../imagenes/res.jpg" alt="hab 1" width="750" height="578"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Reservacion</b></h2>
                            </div>
                        </div>
                    </div>
                
                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_RegistroCliente.php"><img src="../imagenes/rc.jpg" alt="hab 1" width="750"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Registro de cliente</b></h2>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_Pago_Listado.php"><img src="../imagenes/pag.jpg" alt="hab 1" width="750"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Pago</b></h2>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_Mantenimiento.php"><img src="../imagenes/manteni.png" alt="hab 1" width="750" height="500"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Mantenimiento</b></h2>
                            </div>
                        </div>
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

<?php
    }elseif($_SESSION['puesto'] == "A"){
?>
        <!-- Menu -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <a class="navbar-brand" href="P_Inical.php"><img src="../imagenes/logotipo.jpg" class="logo-brand" alt="logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                </li>
                <li class="nav-item">
                <a class="nav-link" href="CerrarSesion.php" id="cerrar-sesion">Cerrar sesion</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_Reservacion.php" id="Reservacion">Reservacion</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_RegistroCliente.php" id="RegistroC">Registro de cliente</a>
                </li>
                <li class="nav-item">
                <a class="nav-link" href="P_Pago_Listado.php" id="Pago">Pago</a>
                </li>
                <li class="nav-item active">
                <a class="nav-link " href="P_MClien_Listado.php" id="Mantenimiento">Actualizar cliente</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        <!-- Banner -->
        <section id="banner"> 
            <div class="container">
            
            </div>
        </section>

        <!-- Menu  -->
        <section id="portfolio">
            <div class="container-fluid">
                <div class="content-center">
                <h2 ><b>Bienvenido <?php echo $_SESSION['usuario'];?></b></h2>
                </div>
            
                <!-- Opciones -->
                <div class="row">

                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_Reservacion.php"><img src="../imagenes/res.jpg" alt="hab 1" width="750" height="578"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Reservacion</b></h2>
                            </div>
                        </div>
                    </div>
                
                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_RegistroCliente.php"><img src="../imagenes/rc.jpg" alt="hab 1" width="750"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Registro de cliente</b></h2>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_Pago_Listado.php"><img src="../imagenes/pag.jpg" alt="hab 1" width="750"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Pago</b></h2>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="hab-container">
                            <a href="P_MClien_Listado.php"><img src="../imagenes/ac.jpg" alt="hab 1" width="750" height="500"></a>
                            <div class="text-center topmargin-lg">
                                <h2><b>Actualizar cliente</b></h2>
                            </div>
                        </div>
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
<?php
    }else{
        session_destroy();
        header('Location: P_Inicio.html');
        exit;
    }
?>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
    </body>
</html>