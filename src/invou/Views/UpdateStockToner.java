package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;

/**
 *
 * @author Leandro Asson
 */
public class UpdateStockToner extends javax.swing.JInternalFrame {
     AuxiliaryFunctions ca = new AuxiliaryFunctions();
     boolean esCodigoValidado = false;

    public UpdateStockToner()
    {
        initComponents();
        stockActual.setEnabled(false);
        desc_articulo.setEnabled(false);
        searchButton.transferFocus();
        fieldCode.requestFocus();
        searchButton.setFocusable(false);
    }
    
    public void setCode(String id_toner)
    {
        fieldCode.setText(id_toner);
        validateId();
        newStock.requestFocus();
    }
    
    public void validateId()
    {
        if(fieldCode.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Debe ingresar un codigo para validar");
        }
        else if(ca.existTonerCode(fieldCode.getText()))
        {
        esCodigoValidado = true;
        Object[][] datos = ca.datos_tonner(fieldCode.getText());
        desc_articulo.setText(datos[0][0].toString());
        stockActual.setText(datos[0][1].toString());
        stockActual.repaint();
        desc_articulo.repaint();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Inserte un codigo existente dentro de la base de datos");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        desc_articulo = new javax.swing.JTextField();
        fieldCode = new javax.swing.JTextField();
        stockActual = new javax.swing.JTextField();
        newStock = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonSalir = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

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
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/updateStock16.png"))); // NOI18N

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        newStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStockActionPerformed(evt);
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

        buttonRegister.setText("Registrar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchBar.png"))); // NOI18N
        searchButton.setToolTipText("Buscar número de padrón");
        searchButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
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
                            .addComponent(newStock, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(stockActual)
                            .addComponent(fieldCode))
                        .addGap(15, 15, 15)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonRegister)
                        .addGap(18, 18, 18)
                        .addComponent(buttonSalir)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(desc_articulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalir)
                    .addComponent(buttonRegister))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
   
        if(!esCodigoValidado)
        {
            JOptionPane.showMessageDialog(this, "Debe validar el codigo");  
        }
        else
        {   
            if(ca.isValidNumber(newStock.getText()))
            {
                
                if (JOptionPane.showConfirmDialog(null, "Está seguro que desea actualizar el stock de "+stockActual.getText()+" a "+newStock.getText()+" unidades?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                {
                    if(ca.updateStockConBusqueda(fieldCode.getText()) && ca.updateIngressTableAndEgressTable(stockActual.getText(), newStock.getText(),fieldCode.getText()))
                    {
                        JOptionPane.showMessageDialog(this, "Se actualizo correctamente el stock");  
                        newStock.setText("");     
                        Object[][] datos = ca.datos_tonner(fieldCode.getText());
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
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        validateId();    
        buttonRegister.requestFocus();   
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        SearchStockToner stock = new SearchStockToner(this);
        stock.show();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void newStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStockActionPerformed
        buttonRegister.requestFocus();     
    }//GEN-LAST:event_newStockActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegister;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JTextField desc_articulo;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField newStock;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField stockActual;
    // End of variables declaration//GEN-END:variables
}
