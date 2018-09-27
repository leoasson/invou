package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import invou.ip;

public class ReserveIp extends javax.swing.JInternalFrame {
AuxiliaryFunctions af = new AuxiliaryFunctions();
SentencesSql sensql = new SentencesSql();
View view = new View();
boolean liberate=false;
ip ip = new ip();

    public ReserveIp(View view) 
    {
        initComponents();
        clean();
        this.view =view;
    }
    
    public ReserveIp(View view,int l) 
    {
        initComponents();
        clean();
        this.view =view;
        button.setLabel("Liberar");
        liberate=true;
        this.setTitle("Liberar ip");
        fieldName.setEnabled(false);
        labelName.setEnabled(false);
    }
    
    public void setIp(String ip)
    {
        fieldIp.setText(ip);
    }
    
    private void clean()
    {
        fieldIp.setText("");
        fieldIp.requestFocus();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldIp = new javax.swing.JTextField();
        ButtonSalir = new javax.swing.JButton();
        button = new javax.swing.JButton();
        fieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();

        setClosable(true);
        setTitle("Reservar ip");
        setFrameIcon(new javax.swing.ImageIcon("C:\\Users\\leoas\\Documents\\NetBeansProjects\\InvOu\\src\\invou\\imagenes\\print-16.png")); // NOI18N

        labelCodigo.setText("IP");

        fieldIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIpActionPerformed(evt);
            }
        });

        ButtonSalir.setText("Salir");
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        button.setText("Reservar");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });

        labelName.setText("Nombre");

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/printerRepair28.png"))); // NOI18N
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCodigo)
                    .addComponent(fieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(button)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonSalir))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelName)
                            .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCodigo)
                            .addComponent(labelName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button)
                    .addComponent(ButtonSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIpActionPerformed
        if(liberate)
            liberate();
        else
            fieldName.requestFocus();
    }//GEN-LAST:event_fieldIpActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        if(liberate)
            liberate();
        else
            reserve();

    }//GEN-LAST:event_buttonActionPerformed

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
       button.requestFocus();
    }//GEN-LAST:event_fieldNameActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        view.addSearchIp(this);
    }//GEN-LAST:event_searchButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JButton button;
    private javax.swing.JTextField fieldIp;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelName;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables

    
    public void reserve()
    {
        if(fieldName.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar el sector o a quien se reserva dicha ip.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(af.existIp(fieldIp.getText()))
            {
                String ip = af.parseIp(fieldIp.getText());
                af.ingressReserveIp(fieldName.getText().toUpperCase(), ip);
                JOptionPane.showMessageDialog(null, "La ip se reservó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
    }
    public void liberate()
    {
            if(ip.validateIP(fieldIp.getText()))
            {
                String ip = af.parseIp(fieldIp.getText());
                if(af.isIpReserve(ip))
                {
                    sensql.deleteRow("reservasip", "cod_ip = "+ip+";");
                    af.updateStateIp("DISPONIBLE", ip);
                    JOptionPane.showMessageDialog(null, "La ip se liberó correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "La ip ingresada no esta reservada", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else
            {
                 JOptionPane.showMessageDialog(null, "La ip ingresada es invalida.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);    
            }
    
    }
    
}
