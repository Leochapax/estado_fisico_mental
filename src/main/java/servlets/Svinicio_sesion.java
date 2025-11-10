/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// IMPORTS para BD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Importar tu clase de conexión
import conexion.conexionDB;
/**
 *
 * @author ferca
 */
@WebServlet("/Svinicio_sesion")
public class Svinicio_sesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/inicio_sesion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuarioInput = request.getParameter("usuario"); // puede ser email o nombre
        String clave = request.getParameter("clave");

        try {
            Connection con = conexionDB.getConnection();

            String sql = "SELECT * FROM usuario WHERE (email = ? OR nombre = ?) AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuarioInput);
            ps.setString(2, usuarioInput);
            ps.setString(3, clave);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                request.getSession().setAttribute("usuarioLogueado", rs.getString("nombre"));
                request.getSession().setAttribute("emailUsuario", rs.getString("email"));
                request.getSession().setAttribute("tipoMensaje", "login");
                request.getRequestDispatcher("/bienvenido.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Usuario/Email o contraseña incorrectos");
                request.setAttribute("errorExist", true);
                request.getRequestDispatcher("/inicio_sesion.jsp").forward(request, response);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al conectar con la base de datos");
            request.getRequestDispatcher("/inicio_sesion.jsp").forward(request, response);
        }
    }
}