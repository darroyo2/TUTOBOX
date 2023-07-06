package dao;

import conexion.Conexion;
import entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDao {

    //Metodo utilizado para obtener todos los productos de nuestra base de datos
    public static Usuario obtenerUsuario(String email, String pass) throws SQLException {
        Usuario c = null;
        Connection cn = null;
        PreparedStatement ps;
        ResultSet rs;
        try {
            String query = "select * from USUARIO where correo=? and contrasena=?";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                c = new Usuario();
                c.setId(rs.getInt("id"));
                c.setNombres(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellidos"));
                c.setEmail(rs.getString("correo"));
                c.setPassword(rs.getString("contrasena"));
            }
            rs.close();
            ps.close();
            //Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo obtener el cliente\n" + e.getMessage());
            throw e;// Conexion.cerrarConexion(cn);
        } finally {
            Conexion.cerrarConexion(cn);
        }
        return c;
    }
    
    
    public static boolean actualizarContrasenia(Usuario usuario) {
    try (Connection conn = Conexion.getConexion()) {
        String sql = "UPDATE usuario SET contrasena = ? WHERE correo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getPassword());
            stmt.setString(2, usuario.getEmail());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Manejar el error de la base de datos
            System.out.println("Error al actualizar la contraseña del usuario: " + e.getMessage());
            return false;
        }
    } catch (SQLException e) {
        // Manejar el error de la conexión a la base de datos
        System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        return false;
    }
}
    
    public static List<Usuario> listaUsuario() throws SQLException {
        Usuario c = null;
        Connection cn = null;
        PreparedStatement ps;
        ResultSet rs;
        List<Usuario> lista=new ArrayList<>();
        try {
            String query = "select * from USUARIO";
            cn = Conexion.getConexion();
            ps = cn.prepareStatement(query);           
            rs = ps.executeQuery();
            while(rs.next()) {
                c = new Usuario();
                c.setId(rs.getInt("idUsuario"));
                c.setNombres(rs.getString("nombre"));
                c.setApellidos(rs.getString("apellidos"));
                c.setEmail(rs.getString("correo"));
                c.setPassword(rs.getString("contrasena"));
                c.setIdTipo(rs.getInt("idTipo"));
                lista.add(c);
            }
            rs.close();
            ps.close();
            //Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo traer la lista de usuarios\n" + e.getMessage());
            throw e;// Conexion.cerrarConexion(cn);
        } finally {
            Conexion.cerrarConexion(cn);
        }
        return lista;
    }
    
    public static List<String> obtenerNombreRolesUsuario(int usuarioId) {
    List<String> roles = new ArrayList<>();

    try (Connection conn = Conexion.getConexion()) {
        String sql = "SELECT t.descripcion FROM tipousuario t JOIN usuario u ON t.idTipousuario = u.idTipo WHERE u.idUsuario = ?";
        // SELECT t.descripcion FROM tipousuario t JOIN usuario u ON t.idTipousuario = u.idTipo WHERE u.idUsuario = ?"
        //"SELECT r.nombre FROM rol r JOIN usuario_rol ur ON r.id = ur.rol_id WHERE ur.usuario_id = ?"

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String rolNombre = rs.getString("descripcion");
                    roles.add(rolNombre);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return roles;
}

public static boolean guardarUsuario(Usuario usuario) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
            conn = Conexion.getConexion();

            String sql = "INSERT INTO usuario (nombre, apellidos, correo, contrasena, idTipo) VALUES (?, ?, ?, ?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNombres());
            stmt.setString(2, usuario.getApellidos());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getPassword());
            stmt.setInt(5, usuario.getIdTipo());
            stmt.executeUpdate();
        }
        catch (SQLException e) {
            // Manejar el error de la base de datos
            System.out.println("Error al guardar el usuario: " + e.getMessage());
            return false;
        } finally {
            Conexion.cerrarRecursos(conn, stmt, rs);
        }
    return true;
}

    public static boolean verificarContraseniaRepetida(Usuario usuario) {
    try (Connection conn = Conexion.getConexion()) {
        String sql = "SELECT COUNT(*) FROM usuario WHERE correo = ? AND contrasena = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            // Manejar el error de la base de datos
            System.out.println("Error al verificar contraseña repetida: " + e.getMessage());
            return false;
        }
    } catch (SQLException e) {
        // Manejar el error de la conexión a la base de datos
        System.out.println("Error de conexión a la base de datos: " + e.getMessage());
        return false;
    }

    return false;
}



public static String obtenerNombrePorUsuarioId(int usuarioId) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String nombre = ""; // Valor por defecto en caso de no encontrar el nombre

    try {
        conn = Conexion.getConexion(); // Obtener conexión a la base de datos

        String query = "SELECT nombre FROM usuario WHERE idUsuario = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, usuarioId);
        rs = stmt.executeQuery();

        if (rs.next()) {
            nombre = rs.getString("nombre");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.cerrarRecursos(conn, stmt, rs); // Cerrar recursos (conexión, statement y resultSet)
    }

    return nombre;
}

public static List<String> obtenerNombreRolesUsuario(String nombreUsuario) {
    List<String> roles = new ArrayList<>();

    try (Connection conn = Conexion.getConexion()) {
        String sql = "SELECT t.descripcion FROM tipousuario t JOIN usuario u ON t.idTipousuario = u.idTipo WHERE u.nombre = ?";
        // "SELECT r.nombre FROM rol r JOIN usuario_rol ur ON r.id = ur.rol_id JOIN usuario u ON ur.usuario_id = u.id WHERE u.nombres = ?"
        // "SELECT t.descripcion FROM tipousuario t JOIN usuario u ON t.idTipousuario = u.idTipo WHERE u.nombre = ?"

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombreUsuario);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String rolNombre = rs.getString("nombre");
                    roles.add(rolNombre);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return roles;
}    
public static String obtenerApellidoPorUsuarioId(int usuarioId) {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String apellido = ""; // Valor por defecto en caso de no encontrar el nombre

    try {
        conn = Conexion.getConexion(); // Obtener conexión a la base de datos

        String query = "SELECT apellidos FROM usuario WHERE idUsuario = ?";
        stmt = conn.prepareStatement(query);
        stmt.setInt(1, usuarioId);
        rs = stmt.executeQuery();

        if (rs.next()) {
            apellido = rs.getString("apellidos");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        Conexion.cerrarRecursos(conn, stmt, rs); // Cerrar recursos (conexión, statement y resultSet)
    }

    return apellido;
}
}
