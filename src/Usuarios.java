import java.sql.*;

public class Usuarios {

    static String todos = "SELECT * FROM usuarios ORDER BY nombre";
    static String usuariosList = "SELECT usuario FROM usuarios ORDER BY usuario";

    String usuario, nombre, password, rol, estado;

    public Usuarios() {
    }

    public Usuarios(String usuario, String nombre, String password, String rol, String estado) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO usuarios VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, nombre);
            ps.setString(3, password);
            ps.setString(4, rol);
            ps.setString(5, estado);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM usuarios WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE usuarios SET nombre = ?, password = ?, rol = ?, estado = ? WHERE usuario = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, password);
            ps.setString(3, rol);
            ps.setString(4, estado);
            ps.setString(5, usuario);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            return resultado;
        }
    }
}