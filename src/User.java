import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;



public class User {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String email;
    private LocalDate fechaNacimiento;


    public User(String nombre, String apellido, int edad, String direccion, String email, LocalDate fechaNacimiento) throws SQLException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;

        UserDAO.insertarPersona(this);
    }

    public static void consultarPersonas() throws SQLException {
        UserDAO.consultarPersonas();
    }

    public static void actualizarPersona(Connection conn, int i, String pedro, String garcía, int i1, String s, String mail, LocalDate localDate) {
    }

    public static void eliminarPersona(Connection conn, int i) {
    }

    public String getEmail() {
        return UserDAO.getUserEmail(this.nombre);
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setId(int anInt) {
    }
}
