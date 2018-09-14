package invou.Views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;


public class PrintReport extends javax.swing.JInternalFrame {
AuxiliaryFunctions af = new AuxiliaryFunctions();
View view;
String id_equipment;

    public PrintReport(View view) 
    {
        this.view=view;
        initComponents();
        clean();
    }
    
    public void setCode(String id_toner)
    {
        fieldCode.setText(id_toner);
    }
       
    public void setIdEquipment(String code)
    {
        fieldCode.setText(code);
        id_equipment = code;
    }
    
    
    private void clean()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       fieldCode.setText("");
       fieldCode.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        buttonIngress = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Visualizar reporte de equipo");
        setFrameIcon(new javax.swing.ImageIcon("C:\\Users\\leoas\\Documents\\NetBeansProjects\\InvOu\\src\\invou\\imagenes\\print-16.png")); // NOI18N

        labelCodigo.setText("Id del equipo");

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

        buttonIngress.setText("Generar");
        buttonIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngressActionPerformed(evt);
            }
        });

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-28.png"))); // NOI18N
        searchButton.setToolTipText("Buscar número de padrón");
        searchButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusable(false);
        searchButton.setRequestFocusEnabled(false);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCodigo)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fieldCode))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(buttonIngress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonSalir)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchButton))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIngress)
                    .addComponent(ButtonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        generateReport();         
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngressActionPerformed
        generateReport();

    }//GEN-LAST:event_buttonIngressActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        view.addSearchEquipment(this);
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton buttonIngress;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    private void generateReport() {
        String codigo = fieldCode.getText();
        
        if(!af.existIdEquipment(codigo))
        {
            JOptionPane.showMessageDialog(null,"El codigo ingresado no esta registardo en la base de datos");
            fieldCode.requestFocus();
            return;          
        }
        
        else
        {
           PrintReportView prv = new PrintReportView(codigo);
           prv.show();
           this.dispose();
        }
    }
}
