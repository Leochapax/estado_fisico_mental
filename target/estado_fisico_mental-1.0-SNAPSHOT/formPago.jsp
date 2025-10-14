<%-- 
    Document   : formPago
    Created on : 24/09/2025, 11:19:36 p. m.
    Author     : ferca
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%
    String idPago = request.getParameter("idPago");
    String idUsuario = request.getParameter("id_usuario") != null ? request.getParameter("id_usuario") : "";
    String fechaPago = request.getParameter("fecha_pago") != null ? request.getParameter("fecha_pago") : "";
    String cantidad = request.getParameter("cantidad") != null ? request.getParameter("cantidad") : "";
    String medioPago = request.getParameter("medio_pago") != null ? request.getParameter("medio_pago") : "";
    String estado = request.getParameter("estado") != null ? request.getParameter("estado") : "";

    boolean editar = (idPago != null && !idPago.isEmpty());
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title><%= editar ? "Editar Pago" : "Agregar Pago" %></title>
    <style>
        body { margin:0; font-family: Arial, sans-serif; background-color: #f4f4f4; }
        header { background-color: #002147; color:white; display:flex; align-items:center; padding:0.5rem 1rem; justify-content:space-between;}
        .menu-icon{font-size:2rem; cursor:pointer;}
        .logo img{height:70px;}
        h2{text-align:center;margin:20px;color:#002147;}
        form{width:400px;margin:auto;background:white;padding:20px;border-radius:8px;box-shadow:0 0 6px rgba(0,0,0,0.1);}
        label{font-weight:bold;color:#002147;display:block;margin-top:10px;margin-bottom:5px;}
        input, select {width:100%;padding:8px;border:1px solid #ccc;border-radius:4px;}
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

<h2><%= editar ? "Editar Pago" : "Agregar Pago" %></h2>

<form action="pagoServlet" method="post">
    <input type="hidden" name="action" value="<%= editar ? "editar" : "agregar" %>">
    <% if (editar) { %>
        <input type="hidden" name="idPago" value="<%= idPago %>">
    <% } %>

    <label>ID Usuario:</label>
    <input type="number" name="id_usuario" required value="<%= idUsuario %>">

    <label>Fecha de Pago:</label>
    <input type="date" name="fecha_pago" required value="<%= fechaPago %>">

    <label>Cantidad:</label>
    <input type="number" name="cantidad" step="0.01" required value="<%= cantidad %>">

    <label>Medio de Pago:</label>
    <select name="medio_pago" required>
        <option value="">Seleccione</option>
        <option value="Efectivo" <%= "Efectivo".equals(medioPago) ? "selected" : "" %>>Efectivo</option>
        <option value="Tarjeta" <%= "Tarjeta".equals(medioPago) ? "selected" : "" %>>Tarjeta</option>
        <option value="Transferencia" <%= "Transferencia".equals(medioPago) ? "selected" : "" %>>Transferencia</option>
    </select>

    <label>Estado:</label>
<select name="estado" required>
    <option value="">--Seleccionar--</option>
    <option value="Pendiente">Pendiente</option>
    <option value="Pagado">Pagado</option>
    <option value="Fallido">Fallido</option>
</select>

    <button type="submit"><%= editar ? "Actualizar" : "Agregar" %></button>
    <a href="pagoServlet?action=listar" class="volver">← Volver</a>
</form>
</body>
</html>
