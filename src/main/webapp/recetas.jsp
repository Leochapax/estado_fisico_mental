<%-- 
    Document   : recetas
    Created on : 24/09/2025, 6:36:43 p. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="recetas.receta" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Recetas</title>
    <style>
        body { margin: 0; font-family: Arial, sans-serif; background-color: #f4f4f4; }
        header { background-color: #002147; color: white; display: flex; align-items: center; padding: 0.5rem 1rem; justify-content: space-between; }
        .menu-icon { font-size: 2rem; cursor: pointer; }
        .logo img { height: 70px; }
        h2 { text-align: center; color: #002147; margin-top: 20px; }
        .acciones-superior { text-align: center; margin: 20px; }
        .acciones-superior a { background-color: #e74c3c; color: white; padding: 8px 16px; border-radius: 4px; text-decoration: none; font-weight: bold; }
        .acciones-superior a:hover { background-color: #c0392b; }
        table { border-collapse: collapse; width: 90%; margin: 20px auto; background-color: white; box-shadow: 0 0 6px rgba(0,0,0,0.1); }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        th { background-color: #002147; color: white; }
        td button, td a { background-color: #e74c3c; color: white; border: none; padding: 6px 12px; border-radius: 4px; cursor: pointer; text-decoration: none; font-weight: bold; margin: 2px; display: inline-block; }
        td button:hover, td a:hover { background-color: #c0392b; }
    </style>
</head>
<body>
<header>
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    <div class="logo">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
</header>

<h2>Gestión de Recetas</h2>

<div class="acciones-superior">
    <a href="recetaServlet?action=nuevo">➕ Agregar Receta</a>
</div>

<table>
    <tr>
        <th>ID</th><th>Nombre</th><th>Descripción</th><th>Calorías</th><th>Gramos</th><th>Acciones</th>
    </tr>
    <%
        List<receta> lista = (List<receta>) request.getAttribute("recetas");
        if (lista != null && !lista.isEmpty()) {
            for (receta r : lista) {
    %>
    <tr>
        <td><%= r.getIdReceta() %></td>
        <td><%= r.getNombre() %></td>
        <td><%= r.getDescripcion() %></td>
        <td><%= r.getCalorias() %></td>
        <td><%= r.getGramos() %></td>
        <td>
            <a href="recetaServlet?action=editar&id=<%= r.getIdReceta() %>">✏ Editar</a>
            <a href="recetaServlet?action=eliminar&id=<%= r.getIdReceta() %>"
               onclick="return confirm('¿Eliminar esta receta?');">🗑 Eliminar</a>
        </td>
    </tr>
    <%      }
        } else { %>
    <tr><td colspan="6">No hay recetas registradas.</td></tr>
    <% } %>
</table>
</body>
</html>