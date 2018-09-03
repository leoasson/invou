/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invou;

import invou.Views.EgressToner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author leoas
 */
    
public class prueba implements Runnable {

    @Override
    public void run() 
    {
        JDialog nn = new JDialog();
        
        nn.setLocation(800, 40);
                        nn.setSize(400,150);
                        nn.setLocationRelativeTo(null);
                        nn.setVisible(true);
                        nn.toFront();
                        for(int i=0;i<1000;i++){}
                        //try {                        
                        //    Thread.sleep(800);
                        //} catch (InterruptedException ex) {
                        //    Logger.getLogger(InterfazEgresoToner.class.getName()).log(Level.SEVERE, null, ex);
                        //}
                        nn.setVisible(false);
    }

}    
    

