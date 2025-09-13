<%-- 
    Document   : usuario
    Created on : 11/09/2025, 9:00:00 a. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="usuario.usuario" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Usuarios</title>
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
            color: #002147;
            margin-top: 20px;
        }

        .acciones-superior {
            text-align: center;
            margin: 20px;
        }

        .acciones-superior a {
            background-color: #e74c3c;
            color: white;
            padding: 8px 16px;
            border-radius: 4px;
            text-decoration: none;
            font-weight: bold;
        }

        .acciones-superior a:hover {
            background-color: #c0392b;
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0 0 6px rgba(0,0,0,0.1);
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #002147;
            color: white;
        }

        td button, td a {
            background-color: #e74c3c;
            color: white;
            border: none;
            padding: 6px 12px;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            font-weight: bold;
            margin: 2px;
            display: inline-block;
        }

        td button:hover, td a:hover {
            background-color: #c0392b;
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

<h2>Gestión de Usuarios</h2>

<div class="acciones-superior">
    <a href="formUsuario.jsp">➕ Agregar Usuario</a>
</div>

<table>
    <tr>
        <th>ID</th><th>Nombre</th><th>Email</th><th>Edad</th><th>Sexo</th><th>Objetivo</th><th>Acciones</th>
    </tr>

    <%
        List<usuario> lista = (List<usuario>) request.getAttribute("usuarios");
        if (lista != null && !lista.isEmpty()) {
            for (usuario u : lista) {
    %>
    <tr>
        <td><%= u.getIdUsuario() %></td>
        <td><%= u.getNombre() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getEdad() %></td>
        <td><%= u.getSexo() %></td>
        <td><%= u.getObjetivoFisico() %></td>
        <td>
            <!-- Editar -->
            <form action="formUsuario.jsp" method="get" style="display:inline;">
                <input type="hidden" name="idUsuario" value="<%= u.getIdUsuario() %>">
                <input type="hidden" name="nombre" value="<%= u.getNombre() %>">
                <input type="hidden" name="email" value="<%= u.getEmail() %>">
                <input type="hidden" name="password" value="<%= u.getPassword() %>">
                <input type="hidden" name="edad" value="<%= u.getEdad() %>">
                <input type="hidden" name="sexo" value="<%= u.getSexo() %>">
                <input type="hidden" name="objetivoFisico" value="<%= u.getObjetivoFisico() %>">
                <button type="submit">✏ Editar</button>
            </form>
            <!-- Eliminar -->
            <a href="usuarioServlet?action=eliminar&id=<%= u.getIdUsuario() %>"
               onclick="return confirm('¿Eliminar este usuario?');">🗑 Eliminar</a>
        </td>
    </tr>
    <%      }
        } else { %>
    <tr><td colspan="7">No hay usuarios registrados.</td></tr>
    <% } %>
</table>

</body>
</html>
