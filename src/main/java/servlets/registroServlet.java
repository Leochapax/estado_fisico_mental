/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import usuario.usuario;
import usuario.usuarioDAO;

@WebServlet(name="RegistroServlet", urlPatterns={"/RegistroServlet"})
public class registroServlet extends HttpServlet {

    usuarioDAO dao = new usuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        usuario u = new usuario();
        u.setNombre(request.getParameter("nombre"));
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));
        
        // Evitar error si la edad viene vacía
        String edadStr = request.getParameter("edad");
        if (edadStr != null && !edadStr.isEmpty()) {
            u.setEdad(Integer.parseInt(edadStr));
        } else {
            u.setEdad(0);
        }
        
        u.setSexo(request.getParameter("sexo"));
        u.setObjetivoFisico(request.getParameter("objetivo_fisico"));

        boolean agregado = dao.agregar(u);

        if(agregado){
            // Guardar usuario y tipo de mensaje en sesión
            request.getSession().setAttribute("usuarioLogueado", u.getNombre());
            request.getSession().setAttribute("tipoMensaje", "registro"); // <-- para diferenciar mensaje en JSP
            response.sendRedirect("bienvenido.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
