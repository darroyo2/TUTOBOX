/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.PublicacionDao;
import entity.Publicacion;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;


@WebServlet(name = "guardarPublicacionServlet", urlPatterns = {"/guardarPublicacionServlet"})
@MultipartConfig
public class guardarPublicacionServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener los valores de los parámetros del formulario
            Part filePart = request.getPart("documento");
            String fileName = filePart.getSubmittedFileName();
            String titulo = request.getParameter("publicacion");
            String cuerpo = request.getParameter("descripcion");
            String idCurso = request.getParameter("idCurso");
            String fecha = request.getParameter("fecha_publicacion");
            int idUsuario = Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo")));
            
            
            // Leer los bytes del archivo
            InputStream documentoStream = filePart.getInputStream();
            byte[] documentoBytes = documentoStream.readAllBytes();
            System.out.println(documentoBytes);
            // Crear el objeto Publicacion
            Publicacion publicacionGuardada = new Publicacion(documentoBytes, titulo, cuerpo, fecha, Integer.parseInt(idCurso), idUsuario);
            
            // Guardar la publicación en la base de datos y obtener el ID generado
            boolean respuesta = PublicacionDao.guardarPublicacion(publicacionGuardada);
            
            if (respuesta) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("PrincipalExperto.jsp");
                dispatcher.forward(request, response);
            }else{
                System.out.println("Error al momento de ingresar un publicacion");
            }
        } catch (IOException | NumberFormatException | SQLException | ServletException e) {
            System.out.println("mensaje de error: " + e.getMessage());
        }
    }

    public static String obtenerNombreArchivo(String nombreCompleto) {
        int indicePunto = nombreCompleto.lastIndexOf(".");
        if (indicePunto != -1) {
            return nombreCompleto.substring(0, indicePunto);
        }
        return nombreCompleto;
    }

}
