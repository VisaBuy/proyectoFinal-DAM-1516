
package controlador;
/**Esta clase la utilizo para crear un ArrayList de objectos.*/
public class GastoDao {
    
    private String tipo, fecha, idusuario;
    private float  cantidad;
    private int idgasto;
    private String nombre;
/**
     * @param idgasto Guarda el identificador del gasto.
     * @param tipo    Guarda el tipo del gastp.
     * @param cantidad Almacena la cantidad del gasto.
     * @param fecha     Almacena la fecha del gasto.
     * @param usuarioGasto Almacena el usuario del gasto.
     */
    public GastoDao( int idgasto,String tipo, float cantidad, String fecha, String usuarioGasto) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.idusuario = usuarioGasto;
        this.cantidad = cantidad;
        this.idgasto = idgasto;
        
    }
    
    /**
     * @return */
    public String getTipo() {
        return tipo;
    }
/**
     * @param tipo*/
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
/**
     * @return */
    public String getFecha() {
        return fecha;
    }
/**
     * @param fecha*/
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
/**
     * @return */
    public String getIdusuario() {
        return idusuario;
    }
/**
     * @param idusuario*/
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
/**
     * @return */
    public float getCantidad() {
        return cantidad;
    }
/**
     * @param cantidad*/
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
/**
     * @return */
    public int getIdgasto() {
        return idgasto;
    }
/**
     * @param idgasto*/
    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }
    
    
    
    
}
