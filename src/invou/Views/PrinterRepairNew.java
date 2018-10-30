package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;

public class PrinterRepairNew extends javax.swing.JInternalFrame {
AuxiliaryFunctions af = new AuxiliaryFunctions();
String serialNumber;
    public PrinterRepairNew() 
    {
        initComponents();
        clean();    
    }
    
    public PrinterRepairNew(String serialNumber) 
    {
        this.serialNumber = serialNumber;
        initComponents();
        clean();    
        fieldCode.setText(serialNumber);
        fieldCode.setEnabled(false);
    }
    
    private void clean()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       fieldDate.setDate(Date);
       fieldCode.setText("");
       fieldFailure.setText("");
       fieldCode.requestFocus();
    }
    
    public void setCode(String id_toner)
    {
        fieldCode.setText(id_toner);
    }
    
    public boolean isValidPrinterCode(String code)
    {
        if(!af.existPrinterCode(code))
        {
            JOptionPane.showMessageDialog(null,"El codigo ingresado no esta registardo en la base de datos","Mensaje",JOptionPane.WARNING_MESSAGE);
            clean();
            return false;
        }
        else if(af.printerIsUnderRepair(code))
        {
            JOptionPane.showMessageDialog(null,"La impresora ya se encuentra en reparación.","Mensaje",JOptionPane.WARNING_MESSAGE);
            clean();
            return false;
        }
        else return true;
    }

    private void register()
    {
        String date, code, failure;       
        
        date = af.getDateToString(fieldDate.getDate());
        failure = fieldFailure.getText();
        code = fieldCode.getText();
        
        if(!isValidPrinterCode(code))
        {
            return;
        }
        
        if(!date.equals(""))
        {          
            if(af.ingressPrintRepair(date,code,failure) && af.updateStatePrinter("EN REPARACION", code) && af.cleanPosition(code))
            {   
                clean();
                fieldCode.requestFocus();
                JOptionPane.showMessageDialog(null,"La impresora entró a reparación","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                if(serialNumber !=null)
                {
                    this.dispose();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al ingresar el articulo","Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios");  
        }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        fieldFailure = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();

        setTitle("Enviar impresora a reparación");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/repairPrint16.png"))); // NOI18N

        labelCodigo.setText("Codigo");

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

        buttonRegister.setText("Registrar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        fieldFailure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldFailureActionPerformed(evt);
            }
        });

        labelCantidad.setText("Falla detectada");

        LabelFecha.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonRegister)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalir)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelFecha)
                            .addComponent(labelCodigo)
                            .addComponent(fieldCode)
                            .addComponent(fieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCantidad)
                            .addComponent(fieldFailure, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(labelCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldFailure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(LabelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalir)
                    .addComponent(ButtonLimpiar)
                    .addComponent(buttonRegister))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        if(isValidPrinterCode(fieldCode.getText()))
        {
        fieldFailure.requestFocus();
        }
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        register();
        
        //Despues de esto tengo que cambiar el puesto de la impresora en "EN REPARACION"
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
    clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void fieldFailureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldFailureActionPerformed
        buttonRegister.requestFocus();
    }//GEN-LAST:event_fieldFailureActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JTextField fieldCode;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JTextField fieldFailure;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    // End of variables declaration//GEN-END:variables
}
