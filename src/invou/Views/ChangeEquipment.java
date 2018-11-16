package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChangeEquipment extends javax.swing.JInternalFrame {
AuxiliaryFunctions af;
SentencesSql sensql;
String id_equipment , serialNumber;
View view;
        
    public ChangeEquipment(View view, SentencesSql sensql) 
    {
        af = new AuxiliaryFunctions(sensql);
        this.view = view;
        this.sensql = sensql;
        initComponents();
        searchButton.setFocusable(false);       
    }
    
    public void setIdEquipmentFree(String id_equipment)
    {
        fieldCodeFree.setText(id_equipment);
                if(!sensql.existencias(fieldCodeFree.getText(), " from pc where id_pc='"+fieldCodeFree.getText()+"' and cod_area='44';"))
            {
                JOptionPane.showMessageDialog(null,"El codigo del equipo no existe o no se encuentra disponible.");
                fieldCodeFree.setText("");
                return;
            } 
    }
    
    public void setIdEquipmentBusy(String id_equipment)
    {
        fieldIdEquipment.setText(id_equipment);
    }
    
    public void setSerialNumber(String serialNumber)
    {
        fieldCodeFree.setText(serialNumber);
    }
    
    public void clean()
    {
        fieldCodeFree.setText("");
        fieldIdEquipment.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCodeFree = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonChange = new javax.swing.JButton();
        fieldIdEquipment = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        searchButton3 = new javax.swing.JButton();
        searchButton4 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cambio de equipamiento");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/changeEquipment16.png"))); // NOI18N

        labelCodigo.setText("Código equipo disponible");

        fieldCodeFree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeFreeActionPerformed(evt);
            }
        });

        ButtonSalir.setText("Salir");
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        ButtonLimpiar.setText("Limpiar");
        ButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLimpiarActionPerformed(evt);
            }
        });

        buttonChange.setText("Cambiar");
        buttonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangeActionPerformed(evt);
            }
        });

        fieldIdEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdEquipmentActionPerformed(evt);
            }
        });

        labelCantidad.setText("Código equipo a reemplazar");

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-28.png"))); // NOI18N
        searchButton.setToolTipText("Buscar impresora disponible");
        searchButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-28.png"))); // NOI18N
        searchButton3.setToolTipText("Buscar equipo");
        searchButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton3.setBorderPainted(false);
        searchButton3.setContentAreaFilled(false);
        searchButton3.setFocusable(false);
        searchButton3.setRequestFocusEnabled(false);
        searchButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton3ActionPerformed(evt);
            }
        });

        searchButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/help16.png"))); // NOI18N
        searchButton4.setToolTipText("Ayuda");
        searchButton4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton4.setBorderPainted(false);
        searchButton4.setContentAreaFilled(false);
        searchButton4.setFocusable(false);
        searchButton4.setRequestFocusEnabled(false);
        searchButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalir)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigo)
                            .addComponent(fieldCodeFree, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCantidad)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldIdEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldCodeFree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelCantidad)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fieldIdEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(73, 73, 73)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonChange)
                        .addComponent(ButtonLimpiar)
                        .addComponent(ButtonSalir))
                    .addComponent(searchButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeFreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeFreeActionPerformed
        if(!sensql.existencias(fieldCodeFree.getText(), " from pc where id_pc='"+fieldCodeFree.getText()+"' and cod_area='44';"))
            {
                JOptionPane.showMessageDialog(null,"El codigo del equipo no existe o no se encuentra disponible.");
                fieldCodeFree.setText("");
                return;
            }        
    }//GEN-LAST:event_fieldCodeFreeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeActionPerformed
        //TODO: verificar que el equipo este libre, es decir dentro de deposito de soporte
        //TODO:cambiar los datos del equipo que se modifica(usuario,contraseña,ips,locacion)
        //TODO:setear la ubicacion del equipo antiguo en el nuevo.
    
        if(!sensql.existencias(fieldCodeFree.getText(), " from pc where id_pc='"+fieldCodeFree.getText()+"' and cod_area='44';"))
            {
                JOptionPane.showMessageDialog(null,"El codigo del equipo no existe o no se encuentra disponible.");
                return;
            }
        
        //obtengo los datos de la pc a reemplazar
        id_equipment = fieldIdEquipment.getText();
        String name = sensql.getData("nombrePc", "select nombrePc from pc where id_pc='"+id_equipment+"';");
        String user =  sensql.getData("usuario", "select usuario from pc where id_pc='"+id_equipment+"';");
        String password = sensql.getData("contraseña", "select contraseña from pc where id_pc='"+id_equipment+"';"); 
        String ipAdmin = sensql.getData("cod_ipAdm", "select cod_ipAdm from pc where id_pc='"+id_equipment+"';");
        String ipImage = sensql.getData("cod_ipImag", "select cod_ipImag where id_pc='"+id_equipment+"';");
        String description = sensql.getData("descripcion", "select descripcion from pc where id_pc='"+id_equipment+"';");
        String cod_area = sensql.getData("cod_area", "select cod_area from pc where id_pc='"+id_equipment+"';");
        if(ipAdmin == null || ipAdmin.equals("null"))
        {ipAdmin="";}
        if(ipImage == null || ipImage.equals("null"))
        {ipImage="";}
        
        
        //Libero los ips de la pc disponible si es que tiene
        String ipAdmFree = sensql.getData("cod_ipAdm", "select cod_ipAdm from pc where id_pc='"+fieldCodeFree.getText()+"';");
        String ipImageFree = sensql.getData("cod_ipImag", "select cod_ipImag from pc where id_pc='"+fieldCodeFree.getText()+"';"); 
        if(ipAdmFree != null)
        {
            if(!ipAdmFree.equals(""))
            {
                af.updateStateIp("DISPONIBLE",ipAdmFree );
            }
        }
        if(ipImageFree != null)
        {
            if(!ipImageFree.equals(""))
            {
                af.updateStateIp("DISPONIBLE", ipImageFree);
            }
        }
        
        //cargo los datos a la nueva pc
        sensql.modifiedRow("pc", "nombrePc", name, "id_pc = '"+ fieldCodeFree.getText() +"'");
        sensql.modifiedRow("pc", "usuario", user, "id_pc = '"+ fieldCodeFree.getText() +"'"); 
        sensql.modifiedRow("pc", "contraseña", password, "id_pc = '"+ fieldCodeFree.getText() +"'"); 
        sensql.modifiedRow("pc", "cod_ipAdm", ipAdmin, "id_pc = '"+ fieldCodeFree.getText() +"'"); 
        sensql.modifiedRow("pc", "cod_ipImag", ipImage, "id_pc = '"+ fieldCodeFree.getText() +"'"); 
        sensql.modifiedRow("pc", "descripcion", description, "id_pc = '"+ fieldCodeFree.getText() +"'");
        sensql.modifiedRow("pc", "cod_area", cod_area, "id_pc = '"+ fieldCodeFree.getText() +"'");
        
        //libero la pc antigua.
        sensql.modifiedRow("pc", "nombrePC", "EX "+name, "id_pc = '"+ id_equipment +"'");
        sensql.modifiedRow("pc", "cod_area", "44", "id_pc = '"+ id_equipment +"'");
        sensql.modifiedRow("pc", "cod_ipImag", "", "id_pc = '"+ id_equipment +"'");
        sensql.modifiedRow("pc", "cod_ipAdm", "", "id_pc = '"+ id_equipment +"'");
        sensql.modifiedRow("pc", "descripcion", "Para reparar", "id_pc = '"+ id_equipment +"'");
        
        JOptionPane.showMessageDialog(null,"Se ha realizado el cambio de equipo. \nLos detalles administrativos y de ubicación se han transferidos a la nueva pc.\nSi desea modificar alguna caracteristica dirijase a al menu equipo->modificar");
        clean();
        
        
    }//GEN-LAST:event_buttonChangeActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
        clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void fieldIdEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdEquipmentActionPerformed
        buttonChange.requestFocus();
    }//GEN-LAST:event_fieldIdEquipmentActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        view.addSearchEquipment(this,1);
        fieldIdEquipment.requestFocus();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton3ActionPerformed
        view.addSearchEquipment(this,2);
    }//GEN-LAST:event_searchButton3ActionPerformed

    private void searchButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton4ActionPerformed
        JOptionPane.showMessageDialog(null,""
            + "Para realizar el cambio de equipamiento se deberá:\n"
            + "Indicar la PC disponible, la cual debe estar  \n"
            + "ubicada en DEPOSITO SOPORTE, de lo contrario  \n"
            + "la aplicación no permitirá cargarla.  \n"
            + "Lo siguiente consiste en seleccionar el equipo\n"
            + " a reemplazar (equipo antiguo)\n"
            + "Los datos administrativos y de ubicación serán\n"
            + "copiados automaticamente del antiguo al nuevo, \n"
            + "cambiando la ubicacion del primero a: \n"
            + "DEPOSITO SOPORTE.\n\n"
            + "Si se pretende modificar algun dato extra, es\n"
            + "necesario dirijirse al menú equipo->modificar\n");
    }//GEN-LAST:event_searchButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton buttonChange;
    private javax.swing.JTextField fieldCodeFree;
    private javax.swing.JTextField fieldIdEquipment;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchButton3;
    private javax.swing.JButton searchButton4;
    // End of variables declaration//GEN-END:variables
}
