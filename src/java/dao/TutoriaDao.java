package dao;

import conexion.Conexion;
import static conexion.Conexion.cerrarRecursos;
import entity.Tutoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class TutoriaDao {
    
    public static List<Tutoria> obtenerListaTutorias(int idTutor) {
    List<Tutoria> listaTutorias = new ArrayList<>();
    Connection cn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        cn = Conexion.getConexion();
        String query = "SELECT * FROM tutoria WHERE idTutor = ?";
        stmt = cn.prepareStatement(query);
        stmt.setInt(1, idTutor);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Tutoria tutoria = new Tutoria();
            tutoria.setId(rs.getInt("idTutoria"));
            tutoria.setTema(rs.getString("tema"));
            tutoria.setEstado(rs.getString("estado"));
            tutoria.setFecha(rs.getString("fecha"));
            tutoria.setHoraIni(rs.getString("horaIni"));
            tutoria.setHoraFin(rs.getString("horaFin"));
            tutoria.setPuntuacion(rs.getInt("puntuacion"));
            tutoria.setComentario(rs.getString("comentario"));
            tutoria.setEstadoPago(rs.getInt("estadoPago"));
            tutoria.setIdTutor(rs.getInt("idTutor"));
            tutoria.setIdEstudiante(rs.getInt("idEstudiante"));
            tutoria.setIdCurso(rs.getInt("idCurso"));
            // También puedes obtener el usuario asociado a la tutoría aquí, si es necesario

            listaTutorias.add(tutoria);
        }
    } catch (SQLException e) {
        System.out.println("Error: No se pudo obtener la lista de tutorías\n" + e.getMessage());
    } finally {
        Conexion.cerrarRecursos(cn, stmt, rs);
    }

    return listaTutorias;}
    
     public static void eliminarTutoria(int idTutoria) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        conn = Conexion.getConexion();
        String query = "DELETE FROM tutoria WHERE idTutoria = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1,idTutoria);
        stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar la conexión, el statement y el result set
            Conexion.cerrarRecursos(conn, stmt, rs);
        }
    }
     
    public static void AgregarTutoria(Tutoria tutoria) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conn = Conexion.getConexion();

        // Consulta SQL para insertar la tutoria en la base de datos
        String query = "INSERT INTO tutoria (tema, estado, fecha, horaIni, horaFin, idTutor, idCurso) VALUES (?, 'pendiente', ?, ?, ?, ?, ?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, tutoria.getTema());
        stmt.setString(2, tutoria.getFecha());
        stmt.setString(3, tutoria.getHoraIni());
        stmt.setString(4, tutoria.getHoraFin());
        stmt.setInt(5, tutoria.getIdTutor());
        stmt.setInt(6, tutoria.getIdCurso());
        stmt.executeUpdate();

        // Obtener el ID generado para la publicación
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.cerrarRecursos(conn, stmt, rs);
    }
}


    public static List<Tutoria> obtenerTutoriasPorTerminoDeBusqueda(String searchTerm) {
    List<Tutoria> tutorias = new ArrayList<>();

    if (searchTerm.isEmpty()) {
        return tutorias; // Devuelve una lista vacía si searchTerm está vacío
    }

    // Aquí realizas la consulta a la base de datos usando el término de búsqueda
    // y obtienes los resultados en forma de objetos Tutoria

    // Ejemplo de código para realizar la consulta en la base de datos
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = Conexion.getConexion(); // Método para obtener la conexión a la base de datos
        String query = "SELECT * FROM tutoria WHERE tema LIKE ? OR estado LIKE ? OR tutor LIKE ? OR feedback LIKE ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, "%" + searchTerm + "%");
        pstmt.setString(2, "%" + searchTerm + "%");
        pstmt.setString(3, "%" + searchTerm + "%");
        pstmt.setString(4, "%" + searchTerm + "%");
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Tutoria tutoria = new Tutoria();
            tutoria.setId(rs.getInt("id"));
            tutoria.setTema(rs.getString("tema"));
            tutoria.setEstado(rs.getString("estado"));
            tutoria.setFecha(rs.getString("fecha"));
            tutoria.setHoraIni(rs.getString("horaIni"));
            tutoria.setHoraFin(rs.getString("horaFin"));
            tutoria.setPuntuacion(rs.getInt("puntuacion"));
            tutoria.setComentario(rs.getString("comentario"));
            tutoria.setEstadoPago(rs.getInt("estadoPago"));
            tutoria.setIdTutor(rs.getInt("idTutor"));
            tutoria.setIdEstudiante(rs.getInt("idEstudiante"));
            // Obtener más datos de la tutoría y asignarlos al objeto tutoria
            tutorias.add(tutoria);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        cerrarRecursos(conn, pstmt, rs); // Método para cerrar la conexión y otros recursos
    }

    return tutorias;
    }
}
