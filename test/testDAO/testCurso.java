/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testDAO;

import dao.CursoDao;
import entity.Curso;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author HP
 */
public class testCurso {
     public static void main (String [] args) throws SQLException{

        List<Curso> lista = null;
        lista = CursoDao.listarCursos();
        System.out.println(lista.size());
        for (Curso p : lista) {
           System.out.println("ID : "+p.getNombre());
         System.out.println("Nombre : "+p.getIdCurso());}
     }}