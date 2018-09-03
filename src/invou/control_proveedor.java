
package invou;

import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class control_proveedor extends Proveedor {
    
SentencesSql sql;

    public control_proveedor(String id_proveedor, String nombre_comercial, String direccion, String cod_ciudad,String telefono)
    { 
        super(id_proveedor, nombre_comercial, direccion, cod_ciudad, telefono);
        sql = new SentencesSql();
    }
       
    public boolean ingresar_proveedor()
    {               
            String datos[] = {id_proveedor,nombre_comercial,direccion,cod_ciudad, telefono};           
            return sql.insertRow(datos, "insert into proveedor(id_proveedor,nombre_comercial,direccion,cod_ciudad, telefono) values(?,?,?,?,?)");                          
    }
    
    public Object[][] consulta_proveedor(){
        String[] columnas={"id_proveedor","nombre_comercial","direccion","nombre_ciudad", "telefono"};
        Object[][] datos = sql.GetTabla(columnas, "proveedor", "select id_proveedor,nombre_comercial,direccion,nombre_ciudad, telefono from proveedor,ciudad where id_ciudad=cod_ciudad;");
        return datos;
    }
}
