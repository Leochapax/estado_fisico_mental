/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import conexion.conexionDB;  // misma conexión que usas en registro

/**
 *
 * @author ferca
 */
@WebServlet(name="RecuperarServlet", urlPatterns={"/RecuperarServlet"})
public class recuperarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuarioEmail = request.getParameter("usuarioEmail");
        String mensaje = "";

        String sql = "SELECT password FROM usuario WHERE nombre=? OR email=?";

        try (Connection con = conexionDB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, usuarioEmail);
            ps.setString(2, usuarioEmail);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String password = rs.getString("password");
                    mensaje = "Tu contraseña es: " + password;
                } else {
                    mensaje = "El usuario o correo no se encuentra registrado.";
                }
            }

            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensaje", "Ocurrió un error en el proceso de recuperación.");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
        }
    }
}