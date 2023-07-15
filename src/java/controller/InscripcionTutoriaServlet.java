/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TutoriaDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class InscripcionTutoriaServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("inscribir")) {
            try {
                int idTutoria = Integer.parseInt(request.getParameter("id"));
                int idEstudiante =Integer.parseInt(request.getParameter("idEstudiante"));
                //DAO
                TutoriaDao.RegistrarAlumno(idEstudiante, idTutoria);
            } catch (Exception ex) {
                System.out.println("Error al registrar Estudiante" + ex);
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher("PerfilExperto.jsp");
        vista.forward(request, response);
    }
}
