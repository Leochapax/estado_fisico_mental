/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import pagos.pago;
import pagos.pagoDAO;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

/**
 *
 * @author ferca
 */
@WebServlet(name = "pagoServlet", urlPatterns = {"/pagoServlet"})
public class pagoServlet extends HttpServlet {

    pagoDAO dao = new pagoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                List<pago> lista = dao.listar();
                request.setAttribute("pagos", lista);
                request.getRequestDispatcher("pagos.jsp").forward(request, response);
                break;

            case "nuevo":
                request.getRequestDispatcher("formPago.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                pago pEditar = dao.buscarPorId(idEditar);
                request.setAttribute("pagoObj", pEditar);
                request.getRequestDispatcher("formPago.jsp").forward(request, response);
                break;

            case "eliminar":
                int id = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(id);
                response.sendRedirect("pagoServlet?action=listar");
                break;

            default:
                response.sendRedirect("pagoServlet?action=listar");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                pago p1 = new pago();
                p1.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
                p1.setFechaPago(java.sql.Date.valueOf(request.getParameter("fecha_pago")));
                p1.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
                p1.setMedioPago(request.getParameter("medio_pago"));
                p1.setEstado(request.getParameter("estado"));
                dao.agregar(p1);
                response.sendRedirect("pagoServlet?action=listar");
                break;

            case "editar":
                pago p2 = new pago();
                p2.setIdPago(Integer.parseInt(request.getParameter("idPago")));
                p2.setIdUsuario(Integer.parseInt(request.getParameter("id_usuario")));
                p2.setFechaPago(java.sql.Date.valueOf(request.getParameter("fecha_pago")));
                p2.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
                p2.setMedioPago(request.getParameter("medio_pago"));
                p2.setEstado(request.getParameter("estado"));
                dao.editar(p2);
                response.sendRedirect("pagoServlet?action=listar");
                break;
        }
    }
}