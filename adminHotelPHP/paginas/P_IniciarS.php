<?php
session_start();
unset($_SESSION['usuario']); 
unset($_SESSION['puesto']);
session_destroy();

    /* Se comprueba si el submit fue activado para inicar sesion*/
    if(isset($_POST['btn_ingresar'])){
        include ("../conexiones/CEmpleado.php");
        /* Se llama a la funcion cliente_ingresar */
        $registro = empleado_ingresar($_POST['usuario'], $_POST['contraseña']);

        /* se cuenta el numero de registros que regresa la funcion */
        if($registro == 1){
            session_start();
            $_SESSION['usuario'] = $_POST['usuario'];
            $_SESSION['puesto'] = empleado_puesto($_POST['usuario']);
            /*echo "<script> alert('Acceso aprobado'); window.location= 'P_IniciarS.php' </script>";*/
            /* Redireccionar a la pagina de incio. */
            header('Location: P_Inicial.php');
        }else{
            echo "<script> alert('Acceso denegado usuario o contraseña incorrecta');</script>";
            /*return ;*/
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
        <title>INICIAR SESION</title>
    </head>
    <body>
        
        <!-- Menu -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <div class="container">
            <a class="navbar-brand" href="../index.html"><img src="../imagenes/logotipo.jpg" class="logo-brand" alt="logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                <a class="nav-link" href="../index.html" id="Inicio">Cancelar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        
        <!-- Formulario -->
        <section id="formulario" class="topmargin-lg">
            <div class="container">
                <div class="content-center">
                    <h2>Bienvenido</h2>
                    <p>Por favor inicia sesion para ingresar al sistema</p>
                </div>
                

                
                <form method="post" class="form-signin">
                    <h2 class="form-signin-heading text-center">INICIAR SESION</h2>
                        <div class="form-group">
                            <label>Usuario:</label>
                            <input type="text" placeholder="Usuario" name="usuario"  autofocus required class="form-control" pattern="^[a-zA-Z0-9_\-]{7}$" title="Formato invalido, el usuario debe ser de 7 caracteres, puede contener: numeros (0 a 9), letras(minusculas y mayusculas) y caracteres especiales (-, _)" autocomplete="off">
                        </div>
                        <div class="form-group">
                            <label>Contraseña:</label>
                            <input type="password" placeholder="Contraseña" name="contraseña"  required class="form-control" pattern="^[a-zA-Z0-9_\-#@]{6,36}$" title="Formato invalido, la contraseña debe ser minimo de 6 y maximo 36 caracteres, puede contener: numeros (0 a 9), letras (minusculas y mayusculas) y caracteres especiales (-, _, #, @)">
                            <a href="P_RecuperarC.php" >Olvidaste tu contraseña?</a>
                        </div>
                        <div class="form-group d-flex">
                            <input type="submit" value="Ingresar" name="btn_ingresar" class="btn btn-info ml-auto topmargin-xs">
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