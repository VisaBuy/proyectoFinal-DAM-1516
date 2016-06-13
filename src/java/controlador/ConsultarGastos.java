
package controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConsultarGastos extends Conexion{

    public ConsultarGastos() {
    }
    
    public List<GastoDao>  verTodosLosGastos(){
        PreparedStatement pst=null;
        ResultSet rs =null;
        String consulta ="SELECT * FROM gasto;";
        // Declaro la lista donde guardare en forma de objetos todos los registros generados por la consulta
        List<GastoDao> gastoslist = new ArrayList();
        
        
        try {
                pst = getConexion().prepareStatement(consulta);
                rs =    pst.executeQuery();
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
            
            String consulta = "INSERT INTO gasto(cantidad, tipo, fecha, idusuariogasto ) VALUES(?,?,now(),?)";
            pst =getConexion().prepareStatement(consulta);
            //Asigno los parámetros a la consulta para ingresar los datos.
            pst.setFloat(1,cantidad );
            pst.setString(2, tipo);
            pst.setInt(3, idusuario);            
            int r= pst.executeUpdate();
            // Ejecuto la consulta, en caso de que se ejecute correctamente retornará TRUE.
            if(r == 1){return true; }
          
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
    
  //Metodo para eliminar gastos.
     public boolean eliminarGasto(int id){
        PreparedStatement pst=null;
        ResultSet rs =null;
        String consulta ="DELETE FROM gasto WHERE idgasto= ?;";
       
        try {
           pst = getConexion().prepareStatement(consulta);
          //Asigno el parametro al identificador del gasto para eliminarlo.
           pst.setInt(1, id);
           //Si la consulta se realiza se correctamente devolverá TRUE. 
                if (pst.executeUpdate()>=1){ 
                     return true;}
           }catch (SQLException ex) {
            System.out.println("No se pudo ver los gastos ");
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
      
 
// METODO PARA MODIFICAR LOS GASTOS:
//Este función recibe los metodos del servlet para luego ser insertado como parametros dentro de la consulta.
//Si la consulta se realiza correctamente esta función devolverá TRUE en el caso contrario delvolverá FALSE.
     public boolean modificarGasto(int idg, float cantidad, String tipo,  int idusuario){
            PreparedStatement pst=null;
            ResultSet rs=null;
        try {
            String consulta = "UPDATE gasto SET cantidad=?,tipo=?, fecha=now(), idusuariogasto=? WHERE idgasto=?";
            pst =getConexion().prepareStatement(consulta);
            //Asigno los parámetros a la consulta para ingresar los datos.
            pst.setFloat(1,cantidad );
            pst.setString(2, tipo);
            pst.setInt(3, idusuario); 
            pst.setInt(4, idg);
            int r= pst.executeUpdate();
            // Ejecuto la consulta, en caso de que se ejecute correctamente retornará TRUE.
            if(r == 1){
                return true;
            }
            
            
        } catch (SQLException ex) {
            System.err.println("No se pudo actualizar el gasto.");
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
