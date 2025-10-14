/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import rutinas.rutina;
import rutinas.rutinaDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author ferca
 */
@WebServlet(name="rutinaServlet", urlPatterns={"/rutinaServlet"})
public class rutinaServlet extends HttpServlet {

    rutinaDAO dao = new rutinaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                List<rutina> lista = dao.listar();
                request.setAttribute("rutinas", lista);
                request.getRequestDispatcher("rutinas.jsp").forward(request, response);
                break;

            case "nuevo":
                request.getRequestDispatcher("formRutina.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                rutina rEditar = dao.buscarPorId(idEditar);
                request.setAttribute("rutina", rEditar);
                request.getRequestDispatcher("formRutina.jsp").forward(request, response);
                break;

            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("rutinaServlet?action=listar");
                break;

            default:
                response.sendRedirect("rutinaServlet?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                rutina r1 = new rutina();
                r1.setNombre(request.getParameter("nombre"));
                r1.setDescripcion(request.getParameter("descripcion"));
                r1.setNivelDificultad(request.getParameter("nivel_dificultad"));
                r1.setTipo(request.getParameter("tipo"));
                dao.agregar(r1);
                response.sendRedirect("rutinaServlet?action=listar");
                break;

            case "editar":
                rutina r2 = new rutina();
                r2.setIdRutina(Integer.parseInt(request.getParameter("idRutina")));
                r2.setNombre(request.getParameter("nombre"));
                r2.setDescripcion(request.getParameter("descripcion"));
                r2.setNivelDificultad(request.getParameter("nivel_dificultad"));
                r2.setTipo(request.getParameter("tipo"));
                dao.editar(r2);
                response.sendRedirect("rutinaServlet?action=listar");
                break;
        }
    }
}