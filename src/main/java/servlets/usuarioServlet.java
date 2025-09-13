/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import usuario.usuario;
import usuario.usuarioDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "usuarioServlet", urlPatterns = {"/usuarioServlet"})
public class usuarioServlet extends HttpServlet {

    usuarioDAO dao = new usuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                List<usuario> lista = dao.listar();
                request.setAttribute("usuarios", lista);
                request.getRequestDispatcher("usuario.jsp").forward(request, response);
                break;

            case "nuevo":
                // Mostrar formulario vacío para agregar usuario
                request.getRequestDispatcher("formUsuario.jsp").forward(request, response);
                break;

            case "editar":
                // Cargar datos de un usuario para editar
                int idEditar = Integer.parseInt(request.getParameter("id"));
                usuario uEditar = null;
                for (usuario u : dao.listar()) { // aquí podrías hacer un dao.buscarPorId(idEditar) mejor
                    if (u.getIdUsuario() == idEditar) {
                        uEditar = u;
                        break;
                    }
                }
                request.setAttribute("usuario", uEditar);
                request.getRequestDispatcher("formUsuario.jsp").forward(request, response);
                break;

            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("usuarioServlet?action=listar");
                break;

            default:
                response.sendRedirect("usuarioServlet?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                usuario u1 = new usuario();
                u1.setNombre(request.getParameter("nombre"));
                u1.setEmail(request.getParameter("email"));
                u1.setPassword(request.getParameter("password"));
                u1.setEdad(Integer.parseInt(request.getParameter("edad")));
                u1.setSexo(request.getParameter("sexo"));
                u1.setObjetivoFisico(request.getParameter("objetivo_fisico"));
                dao.agregar(u1);
                response.sendRedirect("usuarioServlet?action=listar");
                break;

            case "editar":
                usuario u2 = new usuario();
                u2.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                u2.setNombre(request.getParameter("nombre"));
                u2.setEmail(request.getParameter("email"));
                u2.setPassword(request.getParameter("password"));
                u2.setEdad(Integer.parseInt(request.getParameter("edad")));
                u2.setSexo(request.getParameter("sexo"));
                u2.setObjetivoFisico(request.getParameter("objetivo_fisico"));
                dao.editar(u2);
                response.sendRedirect("usuarioServlet?action=listar");
                break;
        }
    }
}
