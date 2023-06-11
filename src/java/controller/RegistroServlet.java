package controller;

import dao.UsuarioDao;
import entity.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener los parámetros del formulario
        String nombre = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String email = request.getParameter("correo");
        String password = request.getParameter("clave");
        String idTipoUsuario = request.getParameter("idTipoUsuario");
        
        // Crear un objeto Usuario con los datos ingresados
        try {
            Usuario usuario = new Usuario(nombre, apellidos, email, password,Integer.parseInt(idTipoUsuario));
            boolean respuesta = UsuarioDao.guardarUsuario(usuario);
            if (respuesta) {
                response.sendRedirect("registro_exitoso.html");
            }else{
                response.sendRedirect("errorRegistro.html");
            }
        } catch (SQLException ex) {
            response.sendRedirect("errorRegistro.html");
        }
    }

}
