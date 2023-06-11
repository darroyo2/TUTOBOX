/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

import dao.MensajeDao;
import entity.Mensaje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class testMensaje {
    
    public static void main (String [] args){

        List<Mensaje> lista =new ArrayList<>();
        lista = MensajeDao.obtenerMensajePorId(4);
        System.out.println(lista.size());
        for (Mensaje p : lista) {
           System.out.println("ID : "+p.getAsunto());
         System.out.println("Nombre : "+p.getFecha());}
     }
    
}
