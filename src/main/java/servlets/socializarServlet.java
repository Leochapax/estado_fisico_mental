/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import socializar.socializar;
import socializar.socializarDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
/**
 *
 * @author ferca
 */
@WebServlet(name = "socializarServlet", urlPatterns = {"/socializarServlet"})
public class socializarServlet extends HttpServlet {

    socializarDAO dao = new socializarDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                List<socializar> lista = dao.listar();
                request.setAttribute("socializar", lista);
                request.getRequestDispatcher("socializar.jsp").forward(request, response);
                break;

            case "nuevo":
                request.getRequestDispatcher("formSocializar.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                socializar sEditar = dao.buscarPorId(idEditar);
                request.setAttribute("socializarObj", sEditar);
                request.getRequestDispatcher("formSocializar.jsp").forward(request, response);
                break;

            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("socializarServlet?action=listar");
                break;

            default:
                response.sendRedirect("socializarServlet?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                socializar s1 = new socializar();
                s1.setIdUsuario1(Integer.parseInt(request.getParameter("idUsuario1")));
                s1.setIdUsuario2(Integer.parseInt(request.getParameter("idUsuario2")));
                dao.agregar(s1);
                response.sendRedirect("socializarServlet?action=listar");
                break;

            case "editar":
                socializar s2 = new socializar();
                s2.setIdSocializar(Integer.parseInt(request.getParameter("idSocializar")));
                s2.setIdUsuario1(Integer.parseInt(request.getParameter("idUsuario1")));
                s2.setIdUsuario2(Integer.parseInt(request.getParameter("idUsuario2")));
                dao.editar(s2);
                response.sendRedirect("socializarServlet?action=listar");
                break;
        }
    }
}