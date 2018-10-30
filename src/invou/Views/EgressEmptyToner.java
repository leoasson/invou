package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import java.text.SimpleDateFormat;
import java.util.Date;


public class EgressEmptyToner extends javax.swing.JInternalFrame {
AuxiliaryFunctions ca = new AuxiliaryFunctions();;

    public EgressEmptyToner() 
    {
        initComponents();
        clean();
        
    }

    private void register()
    {
        String fecha, cantidad;       
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = String.valueOf(sdf.format(dateChosser.getDate()));
        
        cantidad = fieldQuantity.getText();
        
        if(!ca.isValidNumber(cantidad))
        {
            JOptionPane.showMessageDialog(null,"Ingrese una cantidad valida");
            return;
        }
        
        
        if(!fecha.equals(""))
        {          
            if(ca.ingressEmptyToner(fecha, cantidad))
            {   
                clean();
                JOptionPane.showMessageDialog(null,"El retiro de carcasas se registró correctamente");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Error al ingresar el articulo","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Hay campos obligatorios");  
        }
    
    }
    private void clean()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       dateChosser.setDate(Date);
       fieldQuantity.setText("");
       fieldQuantity.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonEgress = new javax.swing.JButton();
        fieldQuantity = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        dateChosser = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setTitle("Retiro de carcasa");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/deleteToner16.png"))); // NOI18N

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

        buttonEgress.setText("Registrar");
        buttonEgress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEgressActionPerformed(evt);
            }
        });

        fieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQuantityActionPerformed(evt);
            }
        });

        labelCantidad.setText("Cantidad");

        LabelFecha.setText("Fecha");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonEgress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalir)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelFecha)
                            .addComponent(dateChosser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCantidad)
                            .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(LabelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChosser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalir)
                    .addComponent(ButtonLimpiar)
                    .addComponent(buttonEgress))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonEgressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEgressActionPerformed
        register(); 
    }//GEN-LAST:event_buttonEgressActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
        clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void fieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldQuantityActionPerformed
        buttonEgress.requestFocus();
    }//GEN-LAST:event_fieldQuantityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JButton buttonEgress;
    private com.toedter.calendar.JDateChooser dateChosser;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JLabel labelCantidad;
    // End of variables declaration//GEN-END:variables
}
