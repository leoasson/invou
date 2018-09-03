package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;

/**
 *
 * @author Leandro Asson
 */
public class InterfazActualizarStock extends javax.swing.JInternalFrame {
     AuxiliaryFunctions ca = new AuxiliaryFunctions();
     boolean esCodigoValidado = false;

    public InterfazActualizarStock()
    {
        initComponents();
        stockActual.setEnabled(false);
        desc_articulo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        desc_articulo = new javax.swing.JTextField();
        idArticulo = new javax.swing.JTextField();
        stockActual = new javax.swing.JTextField();
        nuevoStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonSalir = new javax.swing.JButton();
        buttonRegistrar = new javax.swing.JButton();
        ValidarCodigo = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setTitle("Actualizar stock");

        idArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idArticuloActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Descricion articulo");

        jLabel3.setText("Stock actual");

        jLabel4.setText("Nuevo stock");

        buttonSalir.setText("Salir");
        buttonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalirActionPerformed(evt);
            }
        });

        buttonRegistrar.setText("Registrar");
        buttonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistrarActionPerformed(evt);
            }
        });

        ValidarCodigo.setText("Validar");
        ValidarCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValidarCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(91, 91, 91))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desc_articulo)
                            .addComponent(nuevoStock, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(stockActual)
                            .addComponent(idArticulo))
                        .addGap(18, 18, 18)
                        .addComponent(ValidarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(idArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ValidarCodigo)
                        .addGap(2, 2, 2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(desc_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalir)
                    .addComponent(buttonRegistrar))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistrarActionPerformed
   
        if(!esCodigoValidado)
        {
            JOptionPane.showMessageDialog(this, "Debe validar el codigo");  
        }
        else
        {   
            if(ca.isValidNumber(nuevoStock.getText()))
            {
                
                if (JOptionPane.showConfirmDialog(null, "Está seguro que desea actualizar el stock de "+stockActual.getText()+" a "+nuevoStock.getText()+" unidades?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                {
                    if(ca.updateStockConBusqueda(idArticulo.getText()) && ca.updateIngressTableAndEgressTable(stockActual.getText(), nuevoStock.getText(),idArticulo.getText()))
                    {
                        JOptionPane.showMessageDialog(this, "Se actualizo correctamente el stock");  
                        nuevoStock.setText("");     
                        Object[][] datos = ca.datos_tonner(idArticulo.getText());
                        stockActual.setText(datos[0][1].toString()); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Error al actualizar");
                    }              
                }         
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Asegúrese de haber validado el código e ingresado un stock mayor o igual a 0");
            }
        }
    }//GEN-LAST:event_buttonRegistrarActionPerformed

    private void idArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idArticuloActionPerformed

    }//GEN-LAST:event_idArticuloActionPerformed

    private void ValidarCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValidarCodigoActionPerformed
        
        if(idArticulo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un codigo para validar");
        }
        else if(ca.existTonerCode(idArticulo.getText()))
        {
        esCodigoValidado = true;
        Object[][] datos = ca.datos_tonner(idArticulo.getText());
        desc_articulo.setText(datos[0][0].toString());
        stockActual.setText(datos[0][1].toString());
        stockActual.repaint();
        desc_articulo.repaint();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Inserte un codigo existente dentro de la base de datos");
        }
    }//GEN-LAST:event_ValidarCodigoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ValidarCodigo;
    private javax.swing.JButton buttonRegistrar;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JTextField desc_articulo;
    private javax.swing.JTextField idArticulo;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField nuevoStock;
    private javax.swing.JTextField stockActual;
    // End of variables declaration//GEN-END:variables
}
