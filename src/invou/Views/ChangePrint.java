package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ChangePrint extends javax.swing.JInternalFrame {
AuxiliaryFunctions af = new AuxiliaryFunctions();
String id_equipment , serialNumber;
View view;
        
    public ChangePrint(View view) 
    {
        this.view = view;
        initComponents();
        searchButton.setFocusable(false);       
    }
    
    public void setIdEquipment(String id_equipment)
    {
        fieldIdEquipment.setText(id_equipment);
    }
    
    public void setSerialNumber(String serialNumber)
    {
        if(!af.existPrintCode(serialNumber,"DISPONIBLE"))
        {
            JOptionPane.showMessageDialog(null,"La impresora seleccionada esta en uso o se encuentra en reparación.");
            fieldCode.requestFocus();
            return;
        }
        fieldCode.setText(serialNumber);
    }
    
    public void clean()
    {
        fieldCode.setText("");
        fieldIdEquipment.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonChange = new javax.swing.JButton();
        fieldIdEquipment = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        searchButton3 = new javax.swing.JButton();
        searchButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cambio de impresora");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/changePrint16.png"))); // NOI18N

        labelCodigo.setText("S/N Impresora disponible");

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

        labelCantidad.setText("Equipo vinculado");

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPrint26.png"))); // NOI18N
        searchButton.setToolTipText("Buscar impresora disponible");
        searchButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/help16.png"))); // NOI18N
        searchButton3.setToolTipText("Ayuda");
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

        searchButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-28.png"))); // NOI18N
        searchButton4.setToolTipText("Buscar equipo");
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
                        .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCantidad)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldIdEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(searchButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(19, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(labelCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(searchButton4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelCantidad)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fieldIdEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)))
                            .addGap(73, 73, 73)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonChange)
                    .addComponent(ButtonLimpiar)
                    .addComponent(ButtonSalir)
                    .addComponent(searchButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
             
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangeActionPerformed

        serialNumber=fieldCode.getText();
        id_equipment=fieldIdEquipment.getText();
        //comprobamos que los id de la impresora este disponible:
        if(!af.existIdEquipment(id_equipment))
        {
            JOptionPane.showMessageDialog(null,"El codigo del equipo no es correcto.");
            return;
        }
        if(!af.existPrintCode(serialNumber,"DISPONIBLE"))
        {
            JOptionPane.showMessageDialog(null,"La impresora seleccionada esta en uso o se encuentra en reparación.");
            return;
        }
        
        //TODO: Si existe una impresora registrada en la pc entro en este if, caso contrario la asocio solamente.
        if(af.existEquipmentWithPrint(id_equipment))
        {
            String oldPrint = af.parsePrint(id_equipment);
            af.updatePrint(serialNumber, id_equipment);
            af.updateStatePrinter("EN USO", serialNumber);
            
            int jo = JOptionPane.showConfirmDialog(null, "El cambio se ha realizado correctamente.\n ¿Desea que la impresora reemplazada entre en reparacion?", "Atención",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            //abrimos la pestaña pára que se registre la entrada de la impresora a reparacion
            if(jo == 0) 
            {
                view.addPrinterRepair(oldPrint);
                this.dispose();
            }
            //seteamos la impresora como diponible
            else
            {
                af.updateStatePrinter("DISPONIBLE", oldPrint);
                af.cleanPosition(oldPrint);
                JOptionPane.showMessageDialog(null,"La impresora con S/N: "+oldPrint+" paso a estar DISPONIBLE.");
                this.dispose();
            }
        }
        else
        {
            //asocio la impresora al equipo.
            af.updatePrint(serialNumber, id_equipment);
            af.updateStatePrinter("EN USO", serialNumber);
            JOptionPane.showMessageDialog(null,"La impresora con S/N: "+serialNumber+" se asocio correctamente con el equipo.");
            this.dispose();
        }
        
        
        
    }//GEN-LAST:event_buttonChangeActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
        clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void fieldIdEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdEquipmentActionPerformed
        buttonChange.requestFocus();
    }//GEN-LAST:event_fieldIdEquipmentActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        SearchPrinter printer = new SearchPrinter(this);
        printer.show();
        fieldIdEquipment.requestFocus();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton3ActionPerformed
      JOptionPane.showMessageDialog(null,""
              + "Para realizar el cambio de una impresora se debera:\n"
              + "Escanear el  s/n de la  impresora  disponible\n"
              + "o bien buscarla a travez del buscador.\n"
              + "Una vez indicada la impresora,  lo siguiente \n"
              + "consiste en seleccionar el equipo de destino.\n"
              + "Por ultimo se debe presionar el botón cambiar.\n\n"
              + "En caso que el equipo seleccionado cuente con\n"
              + "impresora, se mostrará la opción de enviarla \n"
              + "a reparación si fuera necesario.\n"
              + "Si se opta por no enviarla a reparación, dicha\n"
              + "impresora  queda  en  estado  DISPONIBLE para \n"
              + "volver a ser utilizada.");  
    }//GEN-LAST:event_searchButton3ActionPerformed

    private void searchButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton4ActionPerformed
        view.addSearchEquipment(this);
    }//GEN-LAST:event_searchButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton buttonChange;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldIdEquipment;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchButton3;
    private javax.swing.JButton searchButton4;
    // End of variables declaration//GEN-END:variables
}
