<%-- 
    Document   : cerrarSesion
    Created on : 12/09/2025
    Author     : ferca
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Cierra la sesión actual
    session.invalidate();

    // Redirige al inicio de sesión
    response.sendRedirect("inicio.jsp");
%>
