
package controlador;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private String user = "root";
    private String pass = "1234";
    private String url = "jdbc:mysql://localhost:3306/gastos";
    private Connection con;
    
    // contrurtor de la conexion.
    public Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("La conexión se realizo con exito");
        } catch (Exception e) {
            System.out.println("No se pudo realizar la conexión error: " + e.toString());
        }
        
        
    }
    
    public Connection getConexion(){
        return con;
    }
    
    
    public static void main(String[] args) {
       Conexion conex =new Conexion();
       conex.getConexion();
    }
}
