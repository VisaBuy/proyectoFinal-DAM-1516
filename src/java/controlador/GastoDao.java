
package controlador;

public class GastoDao {
    
    private String tipo, fecha, idusuario;
    private float  cantidad;
    private int idgasto;
    private String nombre;

    public GastoDao( int idgasto,String tipo, float cantidad, String fecha, String idusuario) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.cantidad = cantidad;
        this.idgasto = idgasto;
        
    }

    public GastoDao(String tipo, String fecha, float cantidad, int idgasto, String nombre) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.idgasto = idgasto;
        this.nombre = nombre;
    }

    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(int idgasto) {
        this.idgasto = idgasto;
    }
    
    
    
    
}
