<?php

    /*Se comprueba si el boron recuperar fue activado */
    if(isset($_POST['btn_recuperar'])){

        include ("../conexiones/CEmpleado.php");
        /*Se llama a la funcion recuperar con los valores del formulario */
        $registro = empleado_recuperar_contrasena($_POST['usuario'], $_POST['pregunta_s'], $_POST['respuesta_s']);

        /*Se comprueba si se recupero algun registro */
        if($registro == 1){
            /*Se redirecciona a otra pagina enviando el usuario por url */
            header('Location: P_CambiarC.php?u=' .$_POST['usuario']);
        }else{
            echo "<script> alert('Acceso denegado'); window.location='P_RecuperarC.php' </script>";
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
        <title>Recuperar contraseña</title>
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
                <a class="nav-link" href="P_IniciarS.php" id="Inicio">Cancelar</a>
                </li>
            </ul>
            </div>
        </div>
        </nav>

        <!-- Formulario -->
        <section id='formulario'>
            <div class="container">
                <div class="content-center">
                    <h2>Recupera tu cuenta</h2>
                    <p>Ingresa tu usuario y responde la pregunta de seguridad con la que te registraste para poder cambiar tu contraseña</p>
                </div>

                <form method="post" class="form-signin">q
                    <h2 class="form-signin-heading text-center">RECUPERAR CONTRASEÑA</h2>
                    <div class="form-group">
                        <label for="">Usuario:</label>
                        <input type="text" placeholder="Usuario" name="usuario" id="inp_us" autofocus required class="form-control" pattern="^[a-zA-Z0-9_\-]{7}$" title="Formato invalido, el usuario debe ser de 7 caracteres, puede contener: numeros (0 a 9), letras(minusculas y mayusculas) y caracteres especiales (-, _)" autocomplete="off">
                    </div>
                    <div class="form-group">
                        <label for="">Pregunta de seguridad:</label>
                        <select name="pregunta_s" id="pregunta_s" required class="form-control">
                            <option disabled selected value="">Seleccione una pregunta de seguridad</option>
                            <option value="¿Nombre de tu mascota?">¿Nombre de tu mascota?</option>
                            <option value="Apodo de tu mejor amigo">Apodo de tu mejor amigo</option>
                            <option value="¿Comida favorita?">¿Comida favorita?</option>
                            <option value="¿Equipo deportivo favorito?">¿Equipo deportivo favorito?</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="">Respuesta de seguridad:</label>
                        <input type="text" placeholder="Respuesta de seguridad " name="respuesta_s" id="inp_rs" required class="form-control" autocomplete="off">
                    </div>
                    <div class="form-group d-flex">
                        <input type="submit" value="Recuperar" name="btn_recuperar" class="btn btn-info ml-auto topmargin-xs">
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

