/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

import dao.TutoriaDao;
import entity.Tutoria;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class testTutorias {
    public static void main (String [] args){
    List<Tutoria> lista = null;
            lista = TutoriaDao.obtenerListaTutorias(4);
            for (Tutoria u : lista) {
                System.out.println("ID : "+u.getId());
                System.out.println("Nombre : "+u.getComentario());
                System.out.println("Apellido : "+u.getEstado());
                System.out.println("Correo : "+u.getFecha());
                System.out.println("Contraseña : "+u.getHoraFin());
                System.out.println("IDTipo : "+u.getTema());
            }
        } 
     
}
