
package controlador;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * Esta clase hereda de Conexion.
 */
public class ConsultasUsuarios extends Conexion{
    
    /**
     * @param nombre Contiene el nombre del usuario.
     * @param pass Contiene la contraseña del usuario.
     * @return  Retornará TRUE si el usuario y contreseña sean verdadres de lo contrario devolvera FALSE.
     */
    public boolean autenticacion(String nombre, String pass){
        PreparedStatement pst=null;
        ResultSet rs=null;
        
        try {
            String consulta ="SELECT * FROM usuarios where usuario=? and contrasena =PASSWORD(?)";
            pst= getConexion().prepareStatement(consulta);
            pst.setString(1,nombre);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            
            if(rs.absolute(1)){
                return true;
            }
        } catch (Exception e) {
            System.err.println("el usuario no esta registrado"+e.toString());
        }finally{
            try {
                // Cierro la conexión con la base de datos en caso de que este abierta.
                if(getConexion()!=null)getConexion().close();
                //Cierro el PreparredStatement
                if(pst !=null) pst.close();
                //Cierro la consula
                if(rs != null) rs.close();
                    
           } catch (SQLException ex) {
               System.err.println("no se pudo cerrar la conexión");;
           }
        }
        
        
        return false;
    }
   
    /**
     * 
     * @param nom  Contiene el nombre de usuario.
//   * @param ape  Contiene el apellido del usuario
     * @param suel  Contiene el con tiene el sueldo del usuario y es de tipo float
     * @param usu   Con nombre de usuario con el que iniciará sesión.
     * @param contra Contiene la contraseña del usuario.
     * @return  Retornará TRUE si la consulta se ejecuta correctamente, en caso contraserio devolvera FALSE.
     */
    public boolean  registroUsuario(String nom, String ape, float suel, String usu, String contra){
            PreparedStatement pst=null;
            ResultSet rs=null;
        try {
            
            String consulta = "INSERT INTO usuarios(nombre, apellido, sueldo, usuario, contrasena) VALUES(?,?,?,?,PASSWORD(?))";
            pst =getConexion().prepareStatement(consulta);
            //Asigno los parámetros a la consulta para ingresar los datos.
            pst.setString(1,nom );
            pst.setString(2, ape);
            pst.setFloat(3, suel);
            pst.setString(4,usu );
            pst.setString(5,contra);
            
           int r= pst.executeUpdate();
            // Ejecuto la consulta, en caso de que se ejecute correctamente retornará TRUE.
            if(r == 1){
                return true;
            }
            
            
        } catch (SQLException ex) {
            System.err.println("No se pudo registrar el usuario.");
        }finally{
            //Cierro las conexiones.
            try {
                if(getConexion() !=null) {getConexion().close();}
                if(pst !=null) pst.close();
            } catch (Exception e) {
                System.err.println("No se pudo cerrar la conexiones error: "+ e.toString());
            }
        }
        
      return false;
    }
    
}
