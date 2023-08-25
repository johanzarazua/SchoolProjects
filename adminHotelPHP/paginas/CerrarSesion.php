<?php

session_start();
unset($_SESSION['usuario']); 
unset($_SESSION['puesto']);
session_destroy();
header('Location: ../index.html');
exit;

?>