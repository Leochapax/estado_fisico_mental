<%-- 
    Document   : usuarioRegistrado
    Created on : 12/09/2025
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Registro Exitoso</title>
    <style>
        body { 
            margin: 0; 
            font-family: Arial, sans-serif; 
            background-color: #f4f4f4; 
            text-align: center; 
        }

        /* Header azul */
        .header {
            background-color: #002147; 
            color: white; 
            padding: 10px 20px; 
            display: flex; 
            align-items: center; 
        }
        .header img {
            height: 50px; 
            margin-left: 30px; 
        }
        .header h1 {
            margin: 0 auto; 
            font-size: 22px; 
            font-weight: bold; 
        }

        /* Mensaje */
        .mensaje {
            margin-top: 5rem; 
            font-size: 1.5rem; 
            color: #002147; 
        }

        /* Botón */
        .boton {
            margin-top: 2rem; 
            padding: 0.7rem 1.5rem; 
            background-color: #e74c3c; 
            color: white; 
            border: none; 
            border-radius: 5px; 
            font-weight: bold; 
            cursor: pointer; 
            font-size: 16px;
        }
        .boton:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

    <!-- Header con logo -->
    <div class="header">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
        <h1>Registro Exitoso</h1>
    </div>

    <!-- Contenido -->
    <div class="mensaje">
        <p>¡Tu usuario ha sido registrado correctamente! 🎉</p>
        <button class="boton" onclick="window.location.href='inicio.jsp'">Iniciar Sesión</button>
    </div>

</body>
</html>
