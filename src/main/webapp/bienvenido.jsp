<%-- 
    Document   : bienvenido
    Created on : 10/09/2025
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Bienvenido</title>
<style>
    body { 
        margin:0; 
        font-family: Arial, sans-serif; 
        background-color:#f4f4f4; 
        text-align:center; 
    }

    .header {
        background-color:#002147;
        color:white;
        padding:10px 20px;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    .header img {
        height: 50px;
        margin-left: 30px; 
    }
    .header button {
        background-color:#e74c3c;
        color:white;
        border:none;
        border-radius:5px;
        padding:0.5rem 1rem;
        font-weight:bold;
        cursor:pointer;
    }
    .header button:hover {
        background-color:#c0392b;
    }

    .mensaje {
        margin-top:5rem; 
        font-size:1.5rem; 
        color:#002147;
    }

    .boton {
        margin-top:2rem; 
        padding:0.7rem 1.5rem; 
        background-color:#e74c3c; 
        color:white; 
        border:none; 
        border-radius:5px; 
        font-weight:bold; 
        cursor:pointer; 
        font-size: 16px;
    }
    .boton:hover {
        background-color:#c0392b;
    }
</style>
</head>
<body>

    <div class="header">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
        <button onclick="window.location.href='cerrarSesion.jsp'">Cerrar Sesión</button>
    </div>

    <div class="mensaje">
        <%
            String usuario = (String) session.getAttribute("usuarioLogueado");
            String tipoMensaje = (String) session.getAttribute("tipoMensaje");
            if(usuario == null) usuario = "Usuario";

            if("registro".equals(tipoMensaje)){
        %>
            <p>¡Bienvenido <strong><%= usuario %></strong>! Tu registro se completó correctamente.</p>
            <button class="boton" onclick="window.location.href='inicio_sesion.jsp'">Iniciar Sesión</button>
        <%
            } else {
        %>
            <p>¡Bienvenido <strong><%= usuario %></strong>! Has iniciado sesión correctamente.</p>
            <button class="boton" onclick="window.location.href='menu.jsp'">Ir al Menú Principal</button>
        <%
            }
            session.removeAttribute("tipoMensaje");
        %>
    </div>

</body>
</html>
