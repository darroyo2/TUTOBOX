/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

import dao.PublicacionDao;
import entity.Publicacion;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class testPublicacionDAO {
    public static void main (String [] args){
        Publicacion publicacionObj = new Publicacion(1, null, "test2", "test2", "2023-06-09", 3, 4);
        PublicacionDao.guardarPublicacion(publicacionObj);
        
        List<Publicacion> lista = null;
        lista = PublicacionDao.obtenerListaPublicaciones(4);
        System.out.println(lista.size());
        for (Publicacion p : lista) {
           System.out.println("ID : "+p.getId());
         System.out.println("Nombre : "+p.getCuerpo());
        System.out.println("Apellido : "+p.getFecha());
        System.out.println("Correo : "+p.getTitulo());
        System.out.println("Contraseña : "+p.getDocumento());
          System.out.println("IDTipo : "+p.getIdCurso());
        System.out.println("IDTipo : "+p.getIdUsuario());}
    }
    }
