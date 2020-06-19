package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;

public class UpdatePagesPrinted extends javax.swing.JInternalFrame {
AuxiliaryFunctions af;

    public UpdatePagesPrinted(SentencesSql sensql) 
    {
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        clean();    
    }
    
    private void clean()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       fieldDate.setDate(Date);
       fieldCode.setText("");
       pagesPrinted.setText("");
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
        else return true;
    }

    private void register()
    {
        String date, code, pages;       
        
        date = af.getStringToDate(fieldDate.getDate());
        pages = pagesPrinted.getText();
        code = fieldCode.getText().toUpperCase();
        
        if(!isValidPrinterCode(code))
        {
            return;
        }
        if(!af.isValidNumber(pages))
        {
            return;
        }
        
        if(!date.equals(""))
        {          
            if(af.ingressPagesPrinted(code, date, pages))
            {   
                clean();
                fieldCode.requestFocus();
                JOptionPane.showMessageDialog(null,"Se actualizó la cantidad de impresiones","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al actualizar la cantidad de impresiones","Mensaje",JOptionPane.ERROR_MESSAGE);
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
        ButtonExit = new javax.swing.JButton();
        ButtonClean = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        pagesPrinted = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar la cantidad de páginas impresas");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/update16.png"))); // NOI18N

        labelCodigo.setText("Codigo");

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        ButtonClean.setText("Limpiar");
        ButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCleanActionPerformed(evt);
            }
        });

        buttonRegister.setText("Registrar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        pagesPrinted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagesPrintedActionPerformed(evt);
            }
        });

        labelCantidad.setText("Páginas impresas");

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
                        .addComponent(ButtonClean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonExit)
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
                            .addComponent(pagesPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(pagesPrinted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(LabelFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(ButtonClean)
                    .addComponent(buttonRegister))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        if(isValidPrinterCode(fieldCode.getText()))
        {
        pagesPrinted.requestFocus();
        }
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed
    
    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        register();
        
        //Despues de esto tengo que cambiar el puesto de la impresora en "EN REPARACION"
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void ButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCleanActionPerformed
    clean();
    }//GEN-LAST:event_ButtonCleanActionPerformed

    private void pagesPrintedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagesPrintedActionPerformed
        buttonRegister.requestFocus();
    }//GEN-LAST:event_pagesPrintedActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonClean;
    private javax.swing.JButton ButtonExit;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JTextField fieldCode;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JTextField pagesPrinted;
    // End of variables declaration//GEN-END:variables
}
