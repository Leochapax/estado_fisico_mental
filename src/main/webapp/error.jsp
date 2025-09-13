<%-- 
    Document   : error
    Created on : 10/09/2025, 7:39:40 p. m.
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Error de Inicio</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            text-align:center; 
            background-color:#f4f4f4; 
            margin:0; 
        }

        /* Franja azul con logo */
        .header {
            background-color:#002147; 
            color:white; 
            padding:10px 20px; 
            display:flex; 
            align-items:center; 
            justify-content:center; 
            position:relative;
        }
        .header img {
            height:50px;
            position:absolute;
            left:30px; /* Logo fijo a la izquierda */
        }
        .header h1 {
            margin:0;
            font-size:22px;
            font-weight:bold;
        }

        /* Mensaje de error */
        .mensaje { 
            margin-top:5rem; 
            font-size:1.5rem; 
            color:#c0392b; /* Rojo para resaltar el error */
        }

        /* Botón azul */
        .boton { 
            margin-top:2rem; 
            padding:0.7rem 1.5rem; 
            background-color:#002147; 
            color:white; 
            border:none; 
            border-radius:5px; 
            font-weight:bold; 
            cursor:pointer; 
            font-size:16px;
        }
        .boton:hover {
            background-color:#00132b;
        }
    </style>
</head>
<body>
    <!-- Franja azul con logo -->
    <div class="header">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
        <h1>Error de Inicio</h1>
    </div>

    <!-- Mensaje central -->
    <div class="mensaje">
        <p>Usuario o contraseña incorrectos.</p>
        <button class="boton" onclick="window.location.href='inicio.jsp'">Volver</button>
    </div>
</body>
</html>
