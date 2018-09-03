package invou;

/**
 *
 * @author Leandro Asson
 */
public class Proveedor {
    
    
    protected String id_proveedor;
    protected String nombre_comercial;
    protected String direccion;
    protected String cod_ciudad;
    protected String telefono;

    public Proveedor(String id_proveedor, String nombre_comercial, String direccion, String cod_ciudad, String telefono)
    {
        this.id_proveedor = id_proveedor;
        this.nombre_comercial = nombre_comercial;
        this.direccion = direccion;       
        this.cod_ciudad = cod_ciudad;
        this.telefono=telefono;
    }
    
    
   
    
    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return cod_ciudad;
    }

    public void setCiudad(String ciudad) {
        this.cod_ciudad = ciudad;
    }
    
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
