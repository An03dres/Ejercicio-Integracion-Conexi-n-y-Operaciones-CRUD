import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Conexión exitosa a la base de datos");

            // Insertar datos en la tabla personas
            User usuario1 = new User("Pedro", "García", 40, "Calle Principal 123", "pedro.garcia@example.com", LocalDate.of(1984, 5, 21));
            User usuario2 = new User("Ana", "Martínez", 22, "Avenida Sol 101", "ana.martinez@example.com", LocalDate.of(2002, 4, 12));

            // Consultar datos de la tabla personas
            System.out.println("Consultando personas:");
            User.consultarPersonas();

            // Actualizar datos de una persona
            System.out.println("Actualizando persona con ID 1:");
            User.actualizarPersona(conn, 1, "Pedro", "García", 41, "Calle Principal 123", "pedro.garcia@example.com", LocalDate.of(1983, 5, 21));

            // Consultar datos después de la actualización
            System.out.println("Consultando personas después de la actualización:");
            User.consultarPersonas();

            // Eliminar una persona
            System.out.println("Eliminando persona con ID 2:");
            User.eliminarPersona(conn, 2);

            // Consultar datos después de la eliminación
            System.out.println("Consultando personas después de la eliminación:");
            User.consultarPersonas();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
