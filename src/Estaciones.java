import java.sql.*;

public class Estaciones {

    static String todos = "SELECT * FROM estaciones ORDER BY nombre";
    static String claves = "SELECT clave FROM estaciones ORDER BY clave";

    String clave, nombre, ubicacion, estado;

    public Estaciones() {
    }

    public Estaciones(String clave, String nombre, String ubicacion, String estado) {
        this.clave = clave;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public int insertar(Connection con) {
        int resultado = 0;
        try {
            String sql = "INSERT INTO estaciones VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            ps.setString(2, nombre);
            ps.setString(3, ubicacion);
            ps.setString(4, estado);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int borrar(Connection con) {
        int resultado = 0;
        try {
            String sql = "DELETE FROM estaciones WHERE clave = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, clave);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            return resultado;
        }
    }

    public int actualizar(Connection con) {
        int resultado = 0;
        try {
            String sql = "UPDATE estaciones SET nombre = ?, ubicacion = ?, estado = ? WHERE clave = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, ubicacion);
            ps.setString(3, estado);
            ps.setString(4, clave);
            return ps.executeUpdate();

        } catch (Exception e) {
            System.out.print("Error: " + e.getMessage());
            return resultado;
        }
    }
}
