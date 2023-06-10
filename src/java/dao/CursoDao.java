/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entity.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDao {
     public static List<Curso> listarCursos() throws SQLException {
        Connection cn = null;
        PreparedStatement st;
        ResultSet rs;
        List<Curso> lista=new ArrayList<>();
        try {
            String query = "SELECT * FROM tutobox.curso;";
            cn = Conexion.getConexion();
            st = cn.prepareStatement(query);           
            rs = st.executeQuery();
            while(rs.next()) {
                Curso c = new Curso();
                c.setIdCurso(rs.getInt("idCurso"));
                c.setNombre(rs.getString("descripcion"));
                lista.add(c);
            }
            rs.close();
            st.close();
            //Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo traer la lista de cursos\n" + e.getMessage());
            throw e;// Conexion.cerrarConexion(cn);
        } finally {
            Conexion.cerrarConexion(cn);
        }
        return lista;
    }
    
}
