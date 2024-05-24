import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public static void insertarPersona(User user) throws SQLException {
        String sql = "INSERT INTO personas (nombre, apellido, edad, direccion, email, fechaNacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getApellido());
            stmt.setInt(3, user.getEdad());
            stmt.setString(4, user.getDireccion());
            stmt.setString(5, user.getEmail());
            stmt.setDate(6, Date.valueOf(user.getFechaNacimiento()));
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " fila(s) insertada(s) en la tabla personas.");
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarPersonas() throws SQLException {
        String sql = "SELECT * FROM personas";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Edad: " + rs.getInt("edad"));
                System.out.println("Dirección: " + rs.getString("direccion"));
                System.out.println("Email: " + rs.getString("email"));
                Date fechaNacimiento = rs.getObject("fechaNacimiento", java.sql.Date.class);
                if (fechaNacimiento != null) {
                    System.out.println("Fecha de Nacimiento: " + fechaNacimiento.toLocalDate());
                } else {
                    System.out.println("Fecha de Nacimiento: No disponible");
                }
                System.out.println("--------------------");
            }
        }
    }

    public static void actualizarPersona(Connection conn, int id, String nombre, String apellido, int edad, String direccion, String email, LocalDate fechaNacimiento) throws SQLException {
        String sql = "UPDATE personas SET nombre = ?, apellido = ?, edad = ?, direccion = ?, email = ?, fechaNacimiento = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, apellido);
            stmt.setInt(3, edad);
            stmt.setString(4, direccion);
            stmt.setString(5, email);
            stmt.setDate(6, Date.valueOf(fechaNacimiento));
            stmt.setInt(7, id);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " fila(s) actualizada(s) en la tabla personas.");
        }
    }

    public static void eliminarPersona(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM personas WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            System.out.println(rowsAffected + " fila(s) eliminada(s) de la tabla personas.");
        }
    }

    public static String getUserEmail(String username) {
        String email = "";
        String query = "SELECT email FROM personas where nombre = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                email = rs.getString("email");
                System.out.println("Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }
}

