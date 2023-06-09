/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import entity.Mensaje;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MensajeDao {

    
    public static List<Mensaje> obtenerMensajes() {
        List<Mensaje> mensajes = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Establecer la conexión a la base de datos
            connection = Conexion.getConexion();

            // Consulta SQL para obtener los mensajes
            String query = "SELECT id, asunto, cuerpo, fechaEnvio, idUsuarioEmisor, idUsuarioReceptor FROM mensaje";

            // Preparar la sentencia SQL
            statement = connection.prepareStatement(query);

            // Ejecutar la consulta
            resultSet = statement.executeQuery();

            // Recorrer los resultados y crear objetos Mensaje
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String asunto = resultSet.getString("asunto");
                String contenido = resultSet.getString("cuerpo");
                String fecha = resultSet.getString("fechaEnvio");
                int emisor = resultSet.getInt("idUsuarioEmisor");
                int receptor = resultSet.getInt("idUsuarioReceptor");

                Mensaje mensaje = new Mensaje(id, asunto, contenido, fecha, emisor, receptor);
                mensajes.add(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar los recursos
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return mensajes;
    }
    
    public static Mensaje obtenerMensajePorId(int receptor) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Mensaje mensaje = null;
    
    try {
        conn = Conexion.getConexion(); // Obtener la conexión a la base de datos
        
        // Preparar la consulta SQL
        String query = "SELECT * FROM mensaje WHERE idUsuarioReceptor = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, receptor);
        
        // Ejecutar la consulta
        rs = stmt.executeQuery();
        
        // Verificar si se encontró un mensaje con el ID proporcionado
        if (rs.next()) {
            // Extraer los datos del mensaje de la fila actual
            int id = rs.getInt("id");
            String asunto = rs.getString("asunto");
            String contenido = rs.getString("cuerpo");
            String fecha = rs.getString("fechaEnvio");
            int emisor = rs.getInt("idUsuarioEmisor");
            
            // Crear el objeto Mensaje con los datos obtenidos
              mensaje = new Mensaje(id, asunto, contenido, fecha, emisor, receptor);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.cerrarRecursos(conn, stmt, rs); // Cerrar la conexión, el statement y el result set
    }
    
    return mensaje;
}

    
    
}
