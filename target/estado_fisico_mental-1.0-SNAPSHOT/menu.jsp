<%--  
    Document   : menu
    Created on : 11/09/2025, 5:34:28 p. m.
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Menú Principal</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
        text-align: center;
    }

    /* Franja azul superior con logo */
    .header {
        background-color: #002147; /* Azul oscuro */
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
    .header button {
        margin-left: auto;
        padding: 8px 16px;
        background-color: #e74c3c;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
    }
    .header button:hover {
        background-color: #c0392b;
    }

    /* Contenido */
    h2 {
        color: #002147;
        margin-top: 30px;
    }

    button.modulo {
        margin: 15px;
        padding: 15px 35px;
        background-color: #e74c3c; /* Rojo */
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
        font-size: 16px;
    }
    button.modulo:hover {
        background-color: #c0392b; /* Rojo oscuro */
    }
</style>
</head>
<body>

    <!-- Franja azul con logo y botón inicio -->
    <div class="header">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
        <h1>Menú Principal</h1>
        <button onclick="window.location.href='inicio.jsp'">Inicio</button>
    </div>

    <h2>Selecciona una opción</h2>

    <button class="modulo" onclick="window.location.href='rutinaServlet?action=listar'">Rutinas</button>
    <button class="modulo" onclick="window.location.href='recetaServlet?action=listar'">Recetas</button>
    <button class="modulo" onclick="window.location.href='socializarServlet?action=listar'">Socializar</button>
    <button class="modulo" onclick="window.location.href='pagoServlet?action=listar'">Pagos</button>

</body>
</html>