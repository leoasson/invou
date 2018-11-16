package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.text.SimpleDateFormat;
import java.util.Date;


public class UplinkPrint extends javax.swing.JInternalFrame {
AuxiliaryFunctions af;
SentencesSql sensql;
String id_equipment , serialNumber;
View view;
        
    public UplinkPrint(View view, SentencesSql sensql) 
    {
        af = new AuxiliaryFunctions(sensql);
        this.view = view;
        this.sensql = sensql;
        initComponents();
        searchButton.setFocusable(false);       
    }
    
    public void setSerialNumber(String serialNumber)
    {
        if(!af.existPrintCode(serialNumber,"EN USO"))
        {
            JOptionPane.showMessageDialog(null,"Seleccione la impresora que desee desvincular,\nEs decir, que se encuentre EN USO.");
            fieldCode.requestFocus();
            return;
        }
        fieldCode.setText(serialNumber);
    }
    
    public void clean()
    {
        fieldCode.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonUplink = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Desvincular impresora");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/changePrint16.png"))); // NOI18N

        labelCodigo.setText("S/N Impresora a desvincular");

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

        buttonUplink.setText("Desvincular");
        buttonUplink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUplinkActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(buttonUplink)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigo)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUplink)
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
    
    private void buttonUplinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUplinkActionPerformed

        serialNumber=fieldCode.getText();
        //comprobamos que los id de la impresora este disponible:
        if(!af.existPrintCode(serialNumber,"EN USO"))
        {
            JOptionPane.showMessageDialog(null,"La impresora seleccionada esta disponible o se encuentra en reparación.\nPor favor seleccione una impresora en uso.");
            return;
        }
        
        //TODO:Verificar que la impresora tenga asociado un equipo.
        
        String idEquipment = sensql.getData("cod_pc", "Select cod_pc from impresora where id_sn = '"+serialNumber+"';");
        if(idEquipment != null && !idEquipment.equals(""))
        {
            af.updateStatePrint("DISPONIBLE", serialNumber );
            af.cleanPcLinkedToThePrinter(serialNumber);
            JOptionPane.showMessageDialog(null,"La impresora se desvinvuló correctamente.");
            clean();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"La impresora no pudo desvincularse.");
        }
        
    }//GEN-LAST:event_buttonUplinkActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
        clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        clean();
        SearchPrinter printer = new SearchPrinter(this, sensql);
        printer.show();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButton3ActionPerformed
//      JOptionPane.showMessageDialog(null,""
//              + "Para realizar el cambio de una impresora se debera:\n"
//              + "Escanear el  s/n de la  impresora  disponible\n"
//              + "o bien buscarla a travez del buscador.\n"
//              + "Una vez indicada la impresora,  lo siguiente \n"
//              + "consiste en seleccionar el equipo de destino.\n"
//              + "Por ultimo se debe presionar el botón cambiar.\n\n"
//              + "En caso que el equipo seleccionado cuente con\n"
//              + "impresora, se mostrará la opción de enviarla \n"
//              + "a reparación si fuera necesario.\n"
//              + "Si se opta por no enviarla a reparación, dicha\n"
//              + "impresora  queda  en  estado  DISPONIBLE para \n"
//              + "volver a ser utilizada.");  
    }//GEN-LAST:event_searchButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton buttonUplink;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchButton3;
    // End of variables declaration//GEN-END:variables
}
