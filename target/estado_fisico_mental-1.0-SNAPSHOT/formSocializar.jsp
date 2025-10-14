<%-- 
    Document   : formSocializar
    Created on : 24/09/2025, 10:39:00 p. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    String idSocializar = request.getParameter("idSocializar");
    String idUsuario1 = request.getParameter("idUsuario1") != null ? request.getParameter("idUsuario1") : "";
    String idUsuario2 = request.getParameter("idUsuario2") != null ? request.getParameter("idUsuario2") : "";
    boolean editar = (idSocializar != null && !idSocializar.isEmpty());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= editar ? "Editar Conexión" : "Agregar Conexión" %></title>
    <style>
        body { margin:0; font-family: Arial, sans-serif; background-color: #f4f4f4; }
        header { background-color: #002147; color:white; display:flex; align-items:center; padding:0.5rem 1rem; justify-content:space-between; }
        .menu-icon{font-size:2rem; cursor:pointer;}
        .logo img{height:70px;}
        h2{text-align:center;margin:20px;color:#002147;}
        form{width:400px;margin:auto;background:white;padding:20px;border-radius:8px;box-shadow:0 0 6px rgba(0,0,0,0.1);}
        label{font-weight:bold;color:#002147;display:block;margin-top:10px;margin-bottom:5px;}
        input{width:100%;padding:8px;border:1px solid #ccc;border-radius:4px;}
        button{margin-top:15px;background-color:#e74c3c;color:white;border:none;padding:10px;width:100%;border-radius:4px;font-weight:bold;cursor:pointer;}
        button:hover{background-color:#c0392b;}
        .volver{display:block;text-align:center;margin-top:15px;text-decoration:none;color:#002147;font-weight:bold;}
    </style>
</head>
<body>
<header>
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    <div class="logo">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
</header>

<h2><%= editar ? "Editar Conexión" : "Agregar Conexión" %></h2>

<form action="socializarServlet" method="post">
    <input type="hidden" name="action" value="<%= editar ? "editar" : "agregar" %>">
    <% if (editar) { %>
        <input type="hidden" name="idSocializar" value="<%= idSocializar %>">
    <% } %>

    <label>ID Usuario 1:</label>
    <input type="number" name="idUsuario1" required value="<%= idUsuario1 %>">

    <label>ID Usuario 2:</label>
    <input type="number" name="idUsuario2" required value="<%= idUsuario2 %>">

    <button type="submit"><%= editar ? "Actualizar" : "Agregar" %></button>
    <a href="socializarServlet?action=listar" class="volver">← Volver</a>
</form>
</body>
</html>