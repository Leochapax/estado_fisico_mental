<%-- 
    Document   : socializar
    Created on : 24/09/2025, 10:38:43 p. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="socializar.socializar" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Socializar</title>
    <style>
        body { font-family: Arial, sans-serif; margin:0; background:#f4f4f4; }
        header { background:#002147; color:white; display:flex; justify-content:space-between; align-items:center; padding:0.5rem 1rem; }
        .menu-icon{font-size:2rem; cursor:pointer;}
        .logo img{height:70px;}
        h2{color:#002147; text-align:center; margin-top:20px;}
        .boton-agregar { display:block; width:200px; margin:10px auto; text-align:center; background:#e74c3c; padding:6px 12px; color:white; border-radius:4px; text-decoration:none; font-weight:bold;}
        .boton-agregar:hover{background:#c0392b;}
        table { width:90%; margin:20px auto; border-collapse:collapse; background:white; }
        th, td { border:1px solid #ccc; padding:10px; text-align:center; }
        th { background:#002147; color:white; }
        td a { text-decoration:none; color:white; padding:5px 10px; border-radius:4px; background:#e74c3c; margin:0 2px;}
        td a:hover { background:#c0392b; }
    </style>
</head>
<body>
<header>
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    <div class="logo">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
</header>

<h2>Conexiones Sociales</h2>

<a href="formSocializar.jsp" class="boton-agregar">➕ Agregar Conexión</a>

<table>
    <tr>
        <th>ID</th>
        <th>ID Usuario 1</th>
        <th>ID Usuario 2</th>
        <th>Acciones</th>
    </tr>
    <%
        List<socializar> lista = (List<socializar>) request.getAttribute("socializar");
        if (lista != null && !lista.isEmpty()) {
            for (socializar s : lista) {
    %>
    <tr>
        <td><%= s.getIdSocializar() %></td>
        <td><%= s.getIdUsuario1() %></td>
        <td><%= s.getIdUsuario2() %></td>
        <td>
            <a href="socializarServlet?action=editar&id=<%= s.getIdSocializar() %>">✏ Editar</a>
            <a href="socializarServlet?action=eliminar&id=<%= s.getIdSocializar() %>" onclick="return confirm('¿Eliminar esta conexión?');">🗑 Eliminar</a>
        </td>
    </tr>
    <%      }
        } else { %>
    <tr>
        <td colspan="4">No hay conexiones registradas.</td>
    </tr>
    <% } %>
</table>
</body>
</html>