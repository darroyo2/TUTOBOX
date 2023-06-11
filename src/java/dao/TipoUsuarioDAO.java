/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entity.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TipoUsuarioDAO {
    
    public static List<TipoUsuario> listarTiposUsuario() throws SQLException {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<TipoUsuario> lista=new ArrayList<>();
        try {
            String query = "SELECT * FROM tutobox.tipousuario;";
            cn = Conexion.getConexion();
            st = cn.prepareStatement(query);           
            rs = st.executeQuery();
            while(rs.next()) {
                TipoUsuario c = new TipoUsuario();
                c.setIdTipoUsuario(rs.getInt("idTipousuario"));
                c.setDescripcion(rs.getString("descripcion"));
                lista.add(c);
            }
            //Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo traer la lista de los tipos de usuario\n" + e.getMessage());
            throw e;// Conexion.cerrarConexion(cn);
        } finally {
            Conexion.cerrarRecursos(cn, st, rs);
        }
        return lista;
    }
    
}
