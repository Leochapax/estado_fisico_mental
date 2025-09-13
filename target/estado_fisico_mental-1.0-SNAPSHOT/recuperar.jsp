<%-- 
    Document   : recuperar
    Created on : 11/09/2025, 6:37:08 p. m.
    Author     : ferca
--%>

<%-- 
    Document   : recuperar
    Created on : 13/09/2025
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Recuperar Contraseña</title>
<style>
    body { margin:0; font-family: Arial,sans-serif; background-color:#f4f4f4; }
    header { background-color:#002147; color:white; display:flex; align-items:center; padding:0.5rem 1rem; justify-content:space-between; }
    .logo img { height:70px; }
    .form-container { max-width:400px; margin:50px auto; background:white; padding:20px; border-radius:8px; box-shadow:0 0 6px rgba(0,0,0,0.1); }
    label { display:block; margin-top:10px; margin-bottom:5px; font-weight:bold; color:#002147; }
    input { width:100%; padding:8px; border:1px solid #ccc; border-radius:4px; }
    button { margin-top:15px; width:100%; padding:10px; background-color:#e74c3c; color:white; border:none; border-radius:4px; font-weight:bold; cursor:pointer; }
    button:hover { background-color:#c0392b; }
    a { display:block; text-align:center; margin-top:10px; color:#002147; text-decoration:none; font-weight:bold; }
</style>
</head>
<body>
<header>
    <div class="logo"><img src="imagenes/Logo_Estado.jpg" alt="Logo"></div>
</header>

<div class="form-container">
    <h2>Recuperar Contraseña</h2>
    <form action="RecuperarServlet" method="post">
        <label>Usuario o Email</label>
        <input type="text" name="usuarioEmail" required>

        <button type="submit">Enviar</button>
    </form>
    <a href="inicio.jsp">← Volver al inicio</a>
</div>
</body>
</html>
