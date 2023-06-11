/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

import dao.UsuarioDao;
import entity.Usuario;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class testUsuarioDAO {
    public static void main (String [] args){
//    List<Usuario> lista = null;
//        try {
//            lista = UsuarioDao.listaUsuario();
//            for (Usuario u : lista) {
//                System.out.println("ID : "+u.getId());
//                System.out.println("Nombre : "+u.getNombres());
//                System.out.println("Apellido : "+u.getApellidos());
//                System.out.println("Correo : "+u.getEmail());
//                System.out.println("Contraseña : "+u.getPassword());
//                System.out.println("IDTipo : "+u.getIdTipo());
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(testUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        System.out.println(UsuarioDao.obtenerNombrePorUsuarioId(4));
}}
