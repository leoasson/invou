package invou.Views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class IngressToner extends javax.swing.JInternalFrame {
AuxiliaryFunctions af;
SentencesSql sensql;
Object[] proveedor;

    /**
     * Creates new form Interfaz_Proveedor
     */
    public IngressToner(SentencesSql sensql) 
    {
        this.sensql = sensql;
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        clean();
        proveedor = af.combox("proveedor ORDER BY nombre_comercial ","nombre_comercial");
        comboProvider.removeAllItems();
        for (Object proveedor1 : proveedor)
        {
            comboProvider.addItem(proveedor1);
        }
        comboProvider.setEditable(true);
        AutoCompleteDecorator.decorate(comboProvider);
        //comboProveedor.getEditor().getEditorComponent().addKeyListener(keyListener);
    }
    
    public void setCode(String id_toner)
    {
        fieldCode.setText(id_toner);
    }
       
    private void clean()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       dateFecha.setDate(Date);
       fieldCode.setText("");
       fieldQuantity.setText("");
       comboProvider.setName("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        labelProveedor = new javax.swing.JLabel();
        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonIngress = new javax.swing.JButton();
        fieldQuantity = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        comboProvider = new javax.swing.JComboBox();
        dateFecha = new com.toedter.calendar.JDateChooser();
        searchButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingresar tonner");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/addToner16.png"))); // NOI18N

        labelCodigo.setText("Codigo");

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        labelProveedor.setText("Proveedor");

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

        buttonIngress.setText("Ingresar");
        buttonIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngressActionPerformed(evt);
            }
        });

        fieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldQuantityActionPerformed(evt);
            }
        });

        labelCantidad.setText("Cantidad");

        LabelFecha.setText("Fecha");

        comboProvider.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProviderActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchBar.png"))); // NOI18N
        searchButton.setToolTipText("Buscar codigo");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonIngress)
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
                            .addComponent(dateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelProveedor)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelCantidad)
                                    .addComponent(fieldQuantity)
                                    .addComponent(comboProvider, 0, 156, Short.MAX_VALUE))
                                .addGap(0, 26, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodigo)
                            .addComponent(labelProveedor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidad)
                    .addComponent(LabelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalir)
                    .addComponent(ButtonLimpiar)
                    .addComponent(buttonIngress))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        fieldQuantity.requestFocus();
             
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngressActionPerformed
        String fecha, codigo,cantidad, proveedor;       

        Date date = dateFecha.getDate();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
        if(date == null)
        {
            JOptionPane.showMessageDialog(null,"Debe ingresar una fehca válida.", "Advertencia",JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        fecha = String.valueOf(sdf.format(date));
        proveedor =af.parseProvider(comboProvider.getSelectedItem().toString());
        cantidad = fieldQuantity.getText();
        codigo = fieldCode.getText();
        
        if(!af.existTonerCode(codigo))
        {
            JOptionPane.showMessageDialog(null,"El codigo ingresado no esta registardo en la base de datos", "Advertencia",JOptionPane.WARNING_MESSAGE);
            fieldCode.requestFocus();
            return;
        }
        if(!af.isValidNumber(cantidad))
        {
            JOptionPane.showMessageDialog(null,"Ingrese una cantidad válida", "Advertencia",JOptionPane.WARNING_MESSAGE);
            fieldQuantity.requestFocus();
            return;
            
        }
        
        if(!fecha.equals(""))
            {          
                if(af.ingressToner(codigo, proveedor, null, fecha, cantidad))
                {            
                    JOptionPane.showMessageDialog(null,"El articulo se ingreso con exito");
                    fieldCode.requestFocus();
                    clean();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Error al ingresar el artículo","Advertencia",JOptionPane.ERROR_MESSAGE);
                }
            }
        else
        {
           JOptionPane.showMessageDialog(this, "Hay campos obligatorios");  
        }
        

        
        
    }//GEN-LAST:event_buttonIngressActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
    clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void fieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldQuantityActionPerformed
        buttonIngress.requestFocus();
    }//GEN-LAST:event_fieldQuantityActionPerformed

    private void comboProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProviderActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        SearchStockToner stock = new SearchStockToner(this, sensql);
        stock.show();
        fieldQuantity.requestFocus();
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JButton buttonIngress;
    private javax.swing.JComboBox comboProvider;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelProveedor;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
