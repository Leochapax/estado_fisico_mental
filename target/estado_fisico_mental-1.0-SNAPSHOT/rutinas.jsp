<%-- 
    Document   : rutinas
    Created on : 24/09/2025, 10:09:35 p. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="rutinas.rutina" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Rutinas</title>
    <style>
        body { margin:0; font-family: Arial; background-color:#f4f4f4; }
        header { background-color:#002147; color:white; display:flex; align-items:center; padding:0.5rem 1rem; justify-content:space-between; }
        .menu-icon { font-size:2rem; cursor:pointer; }
        .logo img { height:70px; }
        h2 { text-align:center; color:#002147; margin-top:20px; }
        .acciones { text-align:center; margin:20px; }
        .acciones a { background-color:#e74c3c; color:white; padding:8px 16px; border-radius:4px; text-decoration:none; font-weight:bold; }
        .acciones a:hover { background-color:#c0392b; }
        table { border-collapse:collapse; width:90%; margin:20px auto; background-color:white; box-shadow:0 0 6px rgba(0,0,0,0.1); }
        th, td { border:1px solid #ccc; padding:10px; text-align:center; }
        th { background-color:#002147; color:white; }
        /* Contenedor de botones en flex para alinearlos horizontalmente */
        .botones-td { display:flex; justify-content:center; gap:5px; }
        .botones-td a { 
            background-color:#e74c3c; 
            color:white; 
            border:none; 
            padding:6px 12px; 
            border-radius:4px; 
            text-decoration:none; 
            font-weight:bold; 
        }
        .botones-td a:hover { background-color:#c0392b; }
    </style>
</head>
<body>
<header>
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    <div class="logo">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
</header>

<h2>Gestión de Rutinas</h2>

<div class="acciones">
    <a href="rutinaServlet?action=nuevo">➕ Agregar Rutina</a>
</div>

<table>
    <tr>
        <th>ID</th><th>Nombre</th><th>Descripción</th><th>Nivel Dificultad</th><th>Tipo</th><th>Acciones</th>
    </tr>
    <%
        List<rutina> lista = (List<rutina>) request.getAttribute("rutinas");
        if (lista != null && !lista.isEmpty()) {
            for (rutina r : lista) {
    %>
    <tr>
        <td><%= r.getIdRutina() %></td>
        <td><%= r.getNombre() %></td>
        <td><%= r.getDescripcion() %></td>
        <td><%= r.getNivelDificultad() %></td>
        <td><%= r.getTipo() %></td>
        <td class="botones-td">
            <a href="rutinaServlet?action=editar&id=<%= r.getIdRutina() %>">✏ Editar</a>
            <a href="rutinaServlet?action=eliminar&id=<%= r.getIdRutina() %>" 
               onclick="return confirm('¿Eliminar esta rutina?');">🗑 Eliminar</a>
        </td>
    </tr>
    <%  }
        } else { %>
    <tr><td colspan="6">No hay rutinas registradas.</td></tr>
    <% } %>
</table>
</body>
</html>