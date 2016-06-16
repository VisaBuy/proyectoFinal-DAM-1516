package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 Esta clase hereda de conexión.
 */

public class ConsultarGastos extends Conexion{
    
    /***
     Este constructor permite crear un objeto de tipo ConsultarGastos.
     **/
    public ConsultarGastos() {
    }
    
    /**
     * @return retorna una lista de objeto de tipo GastoDao. 
     * Cada atributo de un objeto representa unos atributos en la tabla dentro de la base de datos.
     *
     **/
    public List<GastoDao>  verTodosLosGastos(){
        PreparedStatement pst=null;
        ResultSet rs =null;
       
        String consulta ="SELECT g.idgasto, g.cantidad , g.tipo, g.fecha, g.idusuariogasto,"
                + " u.usuario  FROM gasto g, usuarios u where g.idusuariogasto=u.idusuario;";
        // Declaro la lista donde guardare en forma de objetos todos los registros generados por la consulta
        List<GastoDao> gastoslist = new ArrayList();
        
        
        try {
                pst = getConexion().prepareStatement(consulta);
                rs =    pst.executeQuery();
                while(rs.next()){
                      int idgasto = Integer.valueOf(rs.getString("g.idgasto"));
                      String tipo= rs.getString("g.tipo");
                      float cantidad = Float.valueOf(rs.getString("g.cantidad")) ;
                      String fecha = rs.getString("g.fecha");
                      String usuario = rs.getString("u.usuario");
                      //Añado cada fila en forma de objeto GastoDao
                      gastoslist.add(new GastoDao(idgasto,tipo,cantidad , fecha, usuario));
                 }
            
             }
      //tengo que crear un nuevo objecto y con todos los atributos de la columna y meterlo en el arraylist   
        catch (SQLException ex) {
            System.out.println("No se pudo ver los gastos ");
        }
        
      return gastoslist;
        
    }  
 /***
  Recibe tres parametros para ingresar los gastos:
     * @param cantidad representa importe del gasto es de tipo float
     * @param tipo  representa uno d elos tipos de gastos Deporte, Ocio...etc.
     * @param idusuario Este es un atributo de tipo String que contiene el nombre del usuario para luego utilizarlo en la consulta 
     * y el identificador para ser utilizado en la consulta.
     * @return  Si se ha realizado correctamente la consulta devuelve TRUE de lo contrario 
     * devolvera FALSE
  **/
      public boolean  InsertarGasto(float cantidad, String tipo,  String idusuario){
            PreparedStatement pst=null;
            ResultSet rs=null;
        try {
            
            String consulta = "INSERT INTO gasto(cantidad, tipo, fecha, idusuariogasto ) VALUES(?,?,now(),(select idusuario from usuarios where usuario=?))";
            pst =getConexion().prepareStatement(consulta);
            //Asigno los parámetros a la consulta para ingresar los datos.
            pst.setFloat(1,cantidad );
            pst.setString(2, tipo);
            pst.setString(3, idusuario);            
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
    
 
    /**
     *
     * @param id este parámetro contiene el identificador del gasto que sera eliminado.
     * @return  si el gasto se ha eliminado correctamente devolverá TRUE en caso contrario FALSE.
     */
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
     
    /**
     * @param idg Contiene el identificador del gasto que sera modificado.
     * @param cantidad Con tiene la contidad del gasto.
     * @param tipo contiene el tipo de gasto.
     * @param gUsuario contiene el nombre del usuario.
     * @return  Este función recibe los metodos del servlet para luego ser insertado como parametros dentro de la consulta.
     * Si la consulta se realiza correctamente esta función devolverá TRUE en el caso contrario delvolverá FALSE.
 */
     public boolean modificarGasto(int idg, float cantidad, String tipo,  String gUsuario){
            PreparedStatement pst=null;
            ResultSet rs=null;
        try {
            String consulta = "UPDATE gasto SET cantidad=?,tipo=?, fecha=now() "
                    + " WHERE idgasto=? and idusuariogasto= (select idusuario from usuarios where usuario=?)";
            pst =getConexion().prepareStatement(consulta);
            //Asigno los parámetros a la consulta para ingresar los datos.
            pst.setFloat(1,cantidad );
            pst.setString(2, tipo);
            pst.setInt(3, idg);
            pst.setString(4, gUsuario); 
            
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
