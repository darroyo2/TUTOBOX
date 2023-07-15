/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entity.Ranking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brayan
 */
public class RankingDao {

    public static List<Ranking> listarCursos(int idCurso) throws SQLException {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Ranking> lista = new ArrayList<>();
        try {
            String query = "SELECT c.descripcion AS nombre_curso, u.idUsuario, u.nombre AS nombre_usuario,\n"
                    + "       COUNT(t.idTutoria) AS total_tutorias, AVG(t.puntuacion) AS promedio_puntuacion\n"
                    + "FROM curso c\n"
                    + "JOIN tutoria t ON c.idCurso = t.idCurso\n"
                    + "JOIN usuario u ON u.idUsuario = t.idTutor\n"
                    + "WHERE t.idCurso = ? AND t.puntuacion IS NOT NULL\n"
                    + "GROUP BY c.descripcion, u.idUsuario, u.nombre;";
            cn = Conexion.getConexion();
            st = cn.prepareStatement(query);
            st.setInt(1, idCurso);
            rs = st.executeQuery();
            while (rs.next()) {
                Ranking r = new Ranking();
                r.setNombreCurso(rs.getString("nombre_curso"));
                r.setIdUsuarioExperto(rs.getInt("idUsuario"));
                r.setNombreUsuarioExperto(rs.getString("nombre_usuario"));
                r.setTotalTutorias(rs.getInt("total_tutorias"));
                r.setPromedio(rs.getDouble("promedio_puntuacion"));
                lista.add(r);
            }
            //Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo traer la lista de cursos\n" + e.getMessage());
            throw e;// Conexion.cerrarConexion(cn);
        } finally {
            Conexion.cerrarRecursos(cn, st, rs);
        }
        return lista;
    }

}
