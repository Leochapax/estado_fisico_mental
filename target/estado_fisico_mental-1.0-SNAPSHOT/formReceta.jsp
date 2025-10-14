<%-- 
    Document   : formReceta
    Created on : 24/09/2025, 6:38:01 p. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%
    String idReceta = request.getParameter("idReceta");
    String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
    String descripcion = request.getParameter("descripcion") != null ? request.getParameter("descripcion") : "";
    String calorias = request.getParameter("calorias") != null ? request.getParameter("calorias") : "";
    String gramos = request.getParameter("gramos") != null ? request.getParameter("gramos") : "";
    boolean editar = (idReceta != null && !idReceta.isEmpty());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= editar ? "Editar Receta" : "Agregar Receta" %></title>
    <style>
        body { margin: 0; font-family: Arial, sans-serif; background-color: #f4f4f4; }
        header { background-color: #002147; color: white; display: flex; align-items: center; padding: 0.5rem 1rem; justify-content: space-between; }
        .menu-icon { font-size: 2rem; cursor: pointer; }
        .logo img { height: 70px; }
        h2 { text-align: center; margin: 20px; color: #002147; }
        form { width: 400px; margin: auto; background-color: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 6px rgba(0,0,0,0.1); }
        label { font-weight: bold; color: #002147; display: block; margin-top: 10px; margin-bottom: 5px; }
        input, textarea { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; }
        button { margin-top: 15px; background-color: #e74c3c; color: white; border: none; padding: 10px; width: 100%; border-radius: 4px; font-weight: bold; cursor: pointer; }
        button:hover { background-color: #c0392b; }
        .volver { display: block; text-align: center; margin-top: 15px; text-decoration: none; color: #002147; font-weight: bold; }
    </style>
</head>
<body>
<header>
    <div class="menu-icon" onclick="window.location.href='menu.jsp'">☰</div>
    <div class="logo">
        <img src="imagenes/Logo_Estado.jpg" alt="Logo">
    </div>
</header>

<h2><%= editar ? "Editar Receta" : "Agregar Receta" %></h2>

<form action="recetaServlet" method="post">
    <input type="hidden" name="action" value="<%= editar ? "editar" : "agregar" %>">
    <% if (editar) { %>
        <input type="hidden" name="idReceta" value="<%= idReceta %>">
    <% } %>

    <label>Nombre:</label>
    <input type="text" name="nombre" required value="<%= nombre %>">

    <label>Descripción:</label>
    <textarea name="descripcion" rows="3"><%= descripcion %></textarea>

    <label>Calorías:</label>
    <input type="number" name="calorias" min="0" value="<%= calorias %>">

    <label>Gramos:</label>
    <input type="number" name="gramos" min="0" value="<%= gramos %>">

    <button type="submit"><%= editar ? "Actualizar" : "Agregar" %></button>
    <a href="recetaServlet?action=listar" class="volver">← Volver</a>
</form>
</body>
</html>