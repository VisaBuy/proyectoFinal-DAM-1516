
package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
/**Clase que realiza la conexión a la base de datos.*/
public class Conexion {
    private String user = "root";
    private String pass = "1234";
    private String url = "jdbc:mysql://localhost:3306/gastos";
    private Connection con;
    
    /**Construtor de la clase conexion*/
    public Conexion() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("La conexión se realizo con exito");
        } catch (Exception e) {
            System.out.println("No se pudo realizar la conexión error: " + e.toString());
        }
        
        
    }
    /**
     * @return retorna la conexion conexion de la base de datos. */
    public Connection getConexion(){
        return con;
    }
    
}
