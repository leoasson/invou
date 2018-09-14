package invou.Views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;


public class RegisterEquipmentRepair extends javax.swing.JInternalFrame {
AuxiliaryFunctions af = new AuxiliaryFunctions();
View view;
String id_equipment;

    public RegisterEquipmentRepair(View view) 
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
       dateFecha.setDate(Date);
       fieldCode.setText("");
       detailArea.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        ButtonLimpiar = new javax.swing.JButton();
        buttonIngress = new javax.swing.JButton();
        labelDetail = new javax.swing.JLabel();
        LabelDate = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detailArea = new javax.swing.JTextArea();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Ingresar reparación de equipamineto");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/mantenimiento-16.png"))); // NOI18N

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

        buttonIngress.setText("Ingresar");
        buttonIngress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIngressActionPerformed(evt);
            }
        });

        labelDetail.setText("Detalle");

        LabelDate.setText("Fecha");

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-28.png"))); // NOI18N
        searchButton.setToolTipText("Buscar equipo");
        searchButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        detailArea.setColumns(20);
        detailArea.setRows(5);
        jScrollPane1.setViewportView(detailArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCodigo)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelDate)
                            .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelDetail)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(200, 200, 200)
                            .addComponent(buttonIngress)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ButtonLimpiar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ButtonSalir))))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCodigo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(searchButton)))
                .addGap(26, 26, 26)
                .addComponent(labelDetail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSalir)
                    .addComponent(ButtonLimpiar)
                    .addComponent(buttonIngress))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        detailArea.requestFocus();
             
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonIngressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIngressActionPerformed
        String date_, codigo,detail;

        Date date = dateFecha.getDate();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
        date_ = String.valueOf(sdf.format(date));
        codigo = fieldCode.getText();
        detail = detailArea.getText();
        
        if(!af.existIdEquipment(codigo))
        {
            JOptionPane.showMessageDialog(null,"El codigo ingresado no esta registardo en la base de datos");
            fieldCode.requestFocus();
            return;          
        }
        
        if(!date_.equals(""))
            {          
                if(af.ingressNewEquipmentRepair(codigo, date_, detail))
                {            
                    JOptionPane.showMessageDialog(null,"La reparación se registro con éxito.");
                    fieldCode.requestFocus();
                    clean();
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
        

        
        
    }//GEN-LAST:event_buttonIngressActionPerformed

    private void ButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLimpiarActionPerformed
    clean();
    }//GEN-LAST:event_ButtonLimpiarActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        view.addSearchEquipment(this);
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonLimpiar;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelDate;
    private javax.swing.JButton buttonIngress;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JTextArea detailArea;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDetail;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
