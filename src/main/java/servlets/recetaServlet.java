/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import recetas.receta;
import recetas.recetaDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author ferca
 */
@WebServlet(name = "recetaServlet", urlPatterns = {"/recetaServlet"})
public class recetaServlet extends HttpServlet {

    recetaDAO dao = new recetaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                List<receta> lista = dao.listar();
                request.setAttribute("recetas", lista);  // importante: "recetas"
                request.getRequestDispatcher("/recetas.jsp").forward(request, response);
                break;

            case "nuevo":
                request.getRequestDispatcher("/formReceta.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                receta rEditar = dao.buscarPorId(idEditar);
                request.setAttribute("receta", rEditar);
                request.getRequestDispatcher("/formReceta.jsp").forward(request, response);
                break;

            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("recetaServlet?action=listar");
                break;

            default:
                response.sendRedirect("recetaServlet?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                receta r1 = new receta();
                r1.setNombre(request.getParameter("nombre"));
                r1.setDescripcion(request.getParameter("descripcion"));
                r1.setCalorias(Integer.parseInt(request.getParameter("calorias")));
                r1.setGramos(Integer.parseInt(request.getParameter("gramos")));
                dao.agregar(r1);
                response.sendRedirect("recetaServlet?action=listar");
                break;

            case "editar":
                receta r2 = new receta();
                r2.setIdReceta(Integer.parseInt(request.getParameter("idReceta")));
                r2.setNombre(request.getParameter("nombre"));
                r2.setDescripcion(request.getParameter("descripcion"));
                r2.setCalorias(Integer.parseInt(request.getParameter("calorias")));
                r2.setGramos(Integer.parseInt(request.getParameter("gramos")));
                dao.editar(r2);
                response.sendRedirect("recetaServlet?action=listar");
                break;
        }
    }
}