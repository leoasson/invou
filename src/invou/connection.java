/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invou;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class connection {

   
   
   
    //private final String url = "jdbc:mysql://192.168.1.15/Invou";
   private final String url = "jdbc:mysql://localhost/Invou";
    PreparedStatement psPrepararSentencia;
    Connection con = null;

    
    public connection() 
    {
        try
        {  

            Class.forName("com.mysql.jdbc.Driver");

            //con = DriverManager.getConnection(url,"LEOASSON","leo123");
            con = DriverManager.getConnection(url,"admin","administrador");
            if (con!=null){
                System.out.println("Conexión a base de datos facturacion. listo");
            }
        }
        catch(SQLException e )
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.", "Atención", JOptionPane.ERROR_MESSAGE); 
        }
        catch(ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.", "Atención", JOptionPane.ERROR_MESSAGE); 
            System.out.println(e);
        }
    }
    
     /**
     * @return
     */
    public Connection connected(){
      return con;
}

    public void desconectar(){
      con = null;
      System.out.println("conexion terminada");

    } 

    
}
