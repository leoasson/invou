/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invou;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ANDRES
 */
public class connection {
 
    //private final String url = "jdbc:mysql://192.168.1.15/Invou";
    //private final String url = "jdbc:mysql://localhost/Invou";
    PreparedStatement psPrepararSentencia;
    Connection con = null;
    private String url;
    
    public connection() 
    {
        Config config = new Config();
        try
        {  
            
            Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection(url,"LEOASSON","leo123");
            //con = DriverManager.getConnection(url,"admin","administrador");
            url = config.getUrl();
            con = DriverManager.getConnection(url,config.getUser(),config.getPassword());
            if (con!=null){
                System.out.println("Conexión a base de datos. listo");
            }
        }
        catch(ClassNotFoundException | SQLException e )
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "No hay conexión con la base de datos.", "Atención", JOptionPane.ERROR_MESSAGE); 
        } catch (IOException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
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
