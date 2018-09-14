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
        jLabel13 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cambio de impresora");

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

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/printerRepair28.png"))); // NOI18N
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

        jLabel13.setText("* Seleccione el numero de serie de la impresora a intalar, junto con el id del equipo vinculado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonChange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalir)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCodigo)
                                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCantidad)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldIdEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel13))
                        .addGap(0, 11, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldIdEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchButton3)
                        .addGap(41, 41, 41)))
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonChange)
                    .addComponent(ButtonLimpiar)
                    .addComponent(ButtonSalir))
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
            JOptionPane.showMessageDialog(null,"La impresora seleccionada no se encuentra disponible.");
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
        view.addSearchEquipment(this);
    }//GEN-LAST:event_searchButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton buttonChange;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldIdEquipment;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JButton searchButton;
    private javax.swing.JButton searchButton3;
    // End of variables declaration//GEN-END:variables
}
