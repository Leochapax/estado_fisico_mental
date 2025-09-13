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
/**
 *
 * @author ferca
 */
@WebServlet("/Svinicio_sesion")
public class Svinicio_sesion extends HttpServlet {

    private static final String USUARIO_VALIDO = "leonardo";
    private static final String CLAVE_VALIDA = "Melissa25+";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirige al login de la segunda pantalla
        request.getRequestDispatcher("/inicio_sesion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");

        if (USUARIO_VALIDO.equals(usuario) && CLAVE_VALIDA.equals(clave)) {
    // Usuario válido → ir a bienvenido.jsp
    request.getSession().setAttribute("usuarioLogueado", usuario);
    request.getSession().setAttribute("tipoMensaje", "login"); // <-- mensaje de login
    request.getRequestDispatcher("/bienvenido.jsp").forward(request, response);
        } else {
             // Usuario inválido → regresar al login con mensaje de error
    request.setAttribute("error", "Usuario o clave incorrectos");
    request.setAttribute("errorExist", true);
    request.getRequestDispatcher("/inicio_sesion.jsp").forward(request, response);
        }
    }
}