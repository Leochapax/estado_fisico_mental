/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api;

import conexion.conexionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author ferca
 */
@WebServlet("/procesarFormulario")
public class formulario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.html"); // página principal
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        try (Connection conn = conexionDB.getConnection()) {

            String sql = "SELECT * FROM usuario WHERE (email = ? OR nombre = ?) AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario);
            stmt.setString(2, usuario);
            stmt.setString(3, clave);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Inicio de sesión exitoso
                request.getSession().setAttribute("usuarioLogueado", rs.getString("nombre"));
                request.getSession().setAttribute("emailUsuario", rs.getString("email"));
                request.getRequestDispatcher("bienvenido.jsp").forward(request, response);

            } else {
                // Usuario incorrecto
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.setAttribute("errorExist", true);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Error al conectar con la base de datos");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}