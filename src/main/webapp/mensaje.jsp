<%-- 
    Document   : mensaje
    Created on : 13/09/2025, 9:08:08 a. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Mensaje</title>
<style>
    body { margin:0; font-family: Arial,sans-serif; background-color:#f4f4f4; }
    header { background-color:#002147; color:white; display:flex; align-items:center; padding:0.5rem 1rem; justify-content:space-between; }
    .logo img { height:70px; }
    .mensaje-container { max-width:400px; margin:50px auto; background:#002147; color:white; padding:20px; border-radius:8px; box-shadow:0 0 6px rgba(0,0,0,0.1); text-align:center; }
    a { display:block; margin-top:15px; color:#e74c3c; text-decoration:none; font-weight:bold; }
</style>
</head>
<body>
<header>
    <div class="logo"><img src="imagenes/Logo_Estado.jpg" alt="Logo"></div>
</header>

<div class="mensaje-container">
    <h2>
        <%
            String mensaje = (String) request.getAttribute("mensaje");
            if (mensaje != null) {
                out.print(mensaje);
            } else {
                out.print("No hay mensaje disponible.");
            }
        %>
    </h2>
    <a href="inicio.jsp">← Volver al inicio</a>
</div>
</body>
</html>
