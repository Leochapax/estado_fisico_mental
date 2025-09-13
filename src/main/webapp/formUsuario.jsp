<%-- 
    Document   : formUsuario
    Created on : 11/09/2025, 9:04:35 a. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    // Si llegan parámetros → es edición
    String idUsuario = request.getParameter("idUsuario");
    String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
    String email = request.getParameter("email") != null ? request.getParameter("email") : "";
    String password = request.getParameter("password") != null ? request.getParameter("password") : "";
    String edad = request.getParameter("edad") != null ? request.getParameter("edad") : "";
    String sexo = request.getParameter("sexo") != null ? request.getParameter("sexo") : "";
    String objetivo = request.getParameter("objetivo_fisico") != null ? request.getParameter("objetivo_fisico") : "";

    boolean editar = (idUsuario != null && !idUsuario.isEmpty());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= editar ? "Editar Usuario" : "Agregar Usuario" %></title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
        }

        header {
            background-color: #002147;
            color: white;
            display: flex;
            align-items: center;
            padding: 0.5rem 1rem;
            justify-content: space-between;
        }

        .menu-icon {
            font-size: 2rem;
            cursor: pointer;
        }

        .logo img {
            height: 70px;
        }

        h2 {
            text-align: center;
            margin: 20px;
            color: #002147;
        }

        form {
            width: 400px;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 6px rgba(0,0,0,0.1);
        }

        label {
            font-weight: bold;
            color: #002147;
            display: block;
            margin-top: 10px;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        button {
            margin-top: 15px;
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 4px;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background-color: #c0392b;
        }

        .volver {
            display: block;
            text-align: center;
            margin-top: 15px;
            text-decoration: none;
            color: #002147;
            font-weight: bold;
        }
    </style>
</head>
<body>

<header>
    <!-- Botón menú hamburguesa -->
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    <!-- Logo -->
    <div class="logo">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
</header>

<h2><%= editar ? "Editar Usuario" : "Agregar Usuario" %></h2>

<form action="usuarioServlet" method="post">
    <!-- Acción que el servlet leerá -->
    <input type="hidden" name="action" value="<%= editar ? "editar" : "agregar" %>">
    <% if (editar) { %>
        <input type="hidden" name="idUsuario" value="<%= idUsuario %>">
    <% } %>

    <label>Nombre:</label>
    <input type="text" name="nombre" required value="<%= nombre %>">

    <label>Email:</label>
    <input type="email" name="email" required value="<%= email %>">

    <label>Password:</label>
    <input type="password" name="password" value="<%= password %>">

    <label>Edad:</label>
    <input type="number" name="edad" min="0" value="<%= edad %>">

    <label>Sexo:</label>
    <input type="text" name="sexo" value="<%= sexo %>">

    <label>Objetivo físico:</label>
    <input type="text" name="objetivo_fisico" value="<%= objetivo %>">

    <button type="submit"><%= editar ? "Actualizar" : "Agregar" %></button>
    <a href="usuarioServlet?action=listar" class="volver">← Volver</a>
</form>
</body>
</html>
