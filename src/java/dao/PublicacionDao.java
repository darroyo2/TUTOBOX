
package dao;

import conexion.Conexion;
import entity.Publicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


public class PublicacionDao {
    
    public static void eliminarPublicacion(int idPublicacion) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        conn = Conexion.getConexion();
        String query = "DELETE FROM publicacion WHERE idPublicacion = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1,idPublicacion);
        stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión, el statement y el result set
            Conexion.cerrarRecursos(conn, stmt, rs);
        }
    }
    public static List<Publicacion> obtenerListaPublicaciones(int idTutor) {
        List<Publicacion> listaPublicaciones = new ArrayList<>();

        // Establecer conexión con la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConexion(); // Método para obtener la conexión a la base de datos

            // Consulta SQL para obtener las publicaciones
            String query = "SELECT * FROM publicacion WHERE idUsuario = ?";
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idTutor);
            rs = stmt.executeQuery();

            // Iterar sobre los resultados y crear objetos Publicacion
            while (rs.next()) {
                int id = rs.getInt("idPublicacion");
                String titulo = rs.getString("titulo");
                String cuerpo = rs.getString("cuerpo");
                String fecha = rs.getString("fecha");
                byte[] documento = rs.getBytes("documento");
                int idCurso = rs.getInt("idCurso");
                int idUsuario = rs.getInt("idUsuario");

                Publicacion publicacionObj = new Publicacion(id, documento, titulo, cuerpo, fecha, idCurso, idUsuario);
                listaPublicaciones.add(publicacionObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión, el statement y el result set
            Conexion.cerrarRecursos(conn, stmt, rs);
        }

        return listaPublicaciones;
    }
    
    
    
    
   public static int guardarPublicacion(Publicacion publicacion) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet generatedKeys = null;
    int publicacionId = 0;

    try {
        conn = Conexion.getConexion();

        // Consulta SQL para insertar la publicación en la base de datos y obtener el ID generado
        String query = "INSERT INTO publicacion (titulo, cuerpo, fecha, documento, idCurso, idUsuario) VALUES (?, ?, ?, ?, ?, ?)";

        stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, publicacion.getTitulo());
        stmt.setString(2, publicacion.getCuerpo());
        stmt.setString(3, publicacion.getFecha());
        stmt.setBytes(4, publicacion.getDocumento());
        stmt.setInt(5, publicacion.getIdCurso());
        stmt.setInt(6, publicacion.getIdUsuario());
        stmt.executeUpdate();

        // Obtener el ID generado para la publicación
        generatedKeys = stmt.getGeneratedKeys();
        if (generatedKeys.next()) {
            publicacionId = generatedKeys.getInt(1);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.cerrarRecursos(conn, stmt, generatedKeys);
    }

    return publicacionId;
}




   
}
