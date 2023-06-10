/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.TutoriaDao;
import entity.Tutoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brayan
 */
public class EliminarTutoriaServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("eliminar")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                //DAO
                TutoriaDao.eliminarTutoria(id);
                acceso = crearTuto;
            } catch (SQLException ex) {
                System.out.println("error 003" + ex);
            }
        }else if(action.equalsIgnoreCase("agregar")){
            String tema=request.getParameter("tema");
            String fecha=request.getParameter("fecha");
            String hora_ini=request.getParameter("hora_ini");
            String hora_fin=request.getParameter("hora_fin");
            String id_curso=request.getParameter("idCurso");
            Tutoria tutoria=new Tutoria();
            tutoria.setTema(tema);
            tutoria.setFecha(fecha);
            tutoria.setHoraIni(hora_ini);
            tutoria.setHoraFin(hora_fin);
            tutoria.setIdCurso(Integer.parseInt(id_curso));
//            tutoria.setIdCurso(id_curso);
            tutoria.setIdTutor(Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
//            tutoria.setIdTutor(4);
            TutoriaDao.AgregarTutoria(tutoria);
            acceso = crearTuto;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String crearTuto = "CrearTutoriaJsp.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("eliminar")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                //DAO
                TutoriaDao.eliminarTutoria(id);
                acceso = crearTuto;
            } catch (SQLException ex) {
                System.out.println("error 003" + ex);
            }
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
