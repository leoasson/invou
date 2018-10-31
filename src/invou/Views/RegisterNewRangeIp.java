package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import invou.ip;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class RegisterNewRangeIp extends javax.swing.JInternalFrame {
AuxiliaryFunctions af;
String id_equipment;
ip ip = new ip();  
String begin,end;
ArrayList<String> array;

    public RegisterNewRangeIp(SentencesSql sensql) 
    {
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        clean();
    }
    
    public void setCode(String id_toner)
    {
        fieldCode.setText(id_toner);
    }
       
    public void setIdEquipment(String code)
    {
        fieldCode.setText(code);
        id_equipment = code;
    }
    
    
    private void clean()
    {
       fieldCode.setText("");
       fieldCode.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        buttonIngress = new javax.swing.JButton();

        setClosable(true);
        setTitle("Generar rango de ip");
        setFrameIcon(new javax.swing.ImageIcon("C:\\Users\\leoas\\Documents\\NetBeansProjects\\InvOu\\src\\invou\\imagenes\\print-16.png")); // NOI18N

        labelCodigo.setText("Rango de ip");

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        ButtonSalir.setText("Salir");
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        buttonIngress.setText("Generar");
        buttonIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(buttonIngress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSalir)
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldCode)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCodigo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIngress)
                    .addComponent(ButtonSalir))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        registerNewRange();
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngressActionPerformed
        registerNewRange();

    }//GEN-LAST:event_buttonIngressActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton buttonIngress;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JLabel labelCodigo;
    // End of variables declaration//GEN-END:variables

    public boolean verifyRange()
    {
        String value = fieldCode.getText();
        if(value.equals(""))
        { 
           JOptionPane.showMessageDialog(null, "Completar el campo.", "Mensaje", JOptionPane.WARNING_MESSAGE); 
           return false;
        }
        if(value.contains("-"))
        {
            String [] ips = value.split("-");
            if(ip.validateIP(ips[0]) && ip.validateIP(ips[1]))
            {
                String [] ip1 = ips[0].split("\\.");
                String [] ip2 = ips[1].split("\\.");
                
                if(ip1[3].equals("1") && ip2[3].equals("255"))
                {
                    begin = ips[0];
                    end = ips[1];
                    return true;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El rango declarado debe estar completo (comenzar en 1 finalizar en 255).\nPor ejemplo: 192.168.0.1-192.168.0.255", "Mensaje", JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
             else
             {
                JOptionPane.showMessageDialog(null, "Revisar las ip ingresadas.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                return false; 
             }
        }  
        
        else
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar el rango de las ip separado por un guion medio(-). \n Ademas, el rango declarado debe estar completo.\nPor ejemplo: 192.168.0.1-192.168.0.255", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
   
    public boolean existRangeInSQL()
    { 
        array = ip.generateRange(begin, end);
        
        for(int i=0; i<array.size(); i++)
        {
            if(af.existIpForRange(array.get(i)))
            {
                JOptionPane.showMessageDialog(null, "El rango seleccionado o parte del mismo ya existe.\nAsegurese de ingresar un rango libre", "Mensaje", JOptionPane.WARNING_MESSAGE);
                return true;
            }
        }
    return false;
    }
    
    public void registerNewRange()
    {
        if(verifyRange())
        {
            if(!existRangeInSQL())
            {
                for(int i=0; i<array.size(); i++)
                {
                    af.registerNewIp(array.get(i));
                }
                JOptionPane.showMessageDialog(null, "El rango de ip se agregó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
        }
    }
    
}
