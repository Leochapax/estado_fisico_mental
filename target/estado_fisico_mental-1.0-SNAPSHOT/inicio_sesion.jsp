<%-- 
    Document   : inicio_sesion
    Created on : 10/09/2025
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        /* Barra azul con logo */
        .top-bar {
            width: 100%;
            background-color: #002147; /* Azul oscuro */
            padding: 10px 20px;
            display: flex;
            align-items: center;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
        }
        .top-bar img {
            height: 50px;
            margin-left: 30px; /* Logo corrido a la derecha */
        }
        /* Contenedor del login */
        .login-container {
            margin-top: 50px;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #aaa;
            width: 320px;
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #002147;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: none;
            border-radius: 4px;
            background-color: #e74c3c;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
        }
        .login-container button:hover {
            background-color: #c0392b;
        }
        .login-container .links {
            text-align: center;
            margin-top: 10px;
        }
        .login-container .links a {
            margin: 0 5px;
            text-decoration: none;
            color: #002147;
            font-weight: bold;
        }
        .login-container .error {
            color: red;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<!-- Barra azul superior con solo el logo -->
<div class="top-bar">
    <img src="imagenes/Logo_Estado.jpg" alt="Logo">
</div>

<div class="login-container">
    <h2>Iniciar Sesión</h2>

    <!-- Mostrar mensaje de error si existe -->
    <div class="error">
        ${errorExist ? error : ""}
    </div>

    <!-- Formulario de login -->
    <form action="Svinicio_sesion" method="post">
        <input type="text" name="usuario" placeholder="Usuario" required>
        <input type="password" name="clave" placeholder="Contraseña" required>
        <button type="submit" name="accion" value="login">Ingresar</button>
    </form>

    <!-- Botones adicionales -->
    <div class="links">
        <a href="registro.jsp">Registrarse</a> | 
        <a href="recuperar.jsp">¿Olvidaste tu contraseña?</a>
    </div>
</div>

</body>
</html>
