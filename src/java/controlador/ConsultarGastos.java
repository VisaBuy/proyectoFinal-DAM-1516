
package controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;




public class ConsultarGastos extends Conexion{

    public ConsultarGastos() {
    }
    
   public ConsultarGastos(String catidad,String  tipo,String  fecha, String idusuario) {
    }
    
    public List<GastoDao>  verTodosLosGastos(){
        PreparedStatement pst=null;
        ResultSet rs =null;
        String consulta ="SELECT * FROM gasto;";
        // Declaro la lista donde guardo en forma de objetos todos los registros generados por la consulta
        List<GastoDao> gastoslist = new ArrayList();
        
        
        try {
           pst = getConexion().prepareStatement(consulta);
           rs =    pst.executeQuery();
           GastoDao j;
           while(rs.next()){
           int idgasto = Integer.valueOf(rs.getString("idgasto"));
           String tipo= rs.getString("tipo");
           float cantidad = Float.valueOf(rs.getString("cantidad")) ;
           String fecha = rs.getString("fecha");
           String idUsuario = rs.getString("idusuariogasto");
           //Añado cada fila en forma de objeto GastoDao
           gastoslist.add(new GastoDao(idgasto,tipo,cantidad , fecha, idUsuario));
          }
            
        }
      //tengo que crear un nuevo objecto y con todos los atributos de la columna y meterlo en el arraylist   
        catch (SQLException ex) {
            System.out.println("No se pudo ver los gastos ");
        }
        
      return gastoslist;
        
    }  
    
      public boolean  InsertarGasto(float cantidad, String tipo,  int idusuario){
            PreparedStatement pst=null;
            ResultSet rs=null;
        try {
            
            String consulta = "INSERT INTO gasto(cantida, tipo, fecha, idusuariogasto, ) VALUES(?,?,now(),?)";
            pst =getConexion().prepareStatement(consulta);
            //Asigno los parámetros a la consulta para ingresar los datos.
            pst.setFloat(1,cantidad );
            pst.setString(2, tipo);
            pst.setInt(3, idusuario);            
            int r= pst.executeUpdate();
            // Ejecuto la consulta, en caso de que se ejecute correctamente retornará TRUE.
            if(r == 1){
                return true;
            }
            
            
        } catch (SQLException ex) {
            System.err.println("No se insertar el gasto.");
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
    
    public static void main(String[] args) {
        ConsultarGastos j = new ConsultarGastos();
        System.out.println(j.InsertarGasto((float) 122.5,"Comida", 1));
}
    
}
