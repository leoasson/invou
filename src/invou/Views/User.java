/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invou.Views;

import invou.SentencesSql;

/**
 *
 * @author leoas
 */
public class User extends javax.swing.JInternalFrame {

    SentencesSql sensql;
    
    
    /**
     * Creates new form test
     * @param sensql
     */
    public User(SentencesSql sensql) {
        this.sensql = sensql;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldUser = new javax.swing.JTextField();
        labelUser = new javax.swing.JLabel();
        labelPasword = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JTextField();
        fieldRepeatPassword = new javax.swing.JTextField();
        labelRepeatPassword = new javax.swing.JLabel();
        labelPrivilege = new javax.swing.JLabel();
        comboBoxPrivilege = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setTitle("Nuevo usuario");

        labelUser.setText("Usuario:");

        labelPasword.setText("Contraseña:");

        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });

        labelRepeatPassword.setText("Repetir contraseña:");

        labelPrivilege.setText("Privilegios:");

        comboBoxPrivilege.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Crear");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUser)
                    .addComponent(labelPasword)
                    .addComponent(labelRepeatPassword)
                    .addComponent(labelPrivilege))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldUser)
                    .addComponent(fieldPassword)
                    .addComponent(fieldRepeatPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(comboBoxPrivilege, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUser))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPasword)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRepeatPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRepeatPassword))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPrivilege)
                    .addComponent(comboBoxPrivilege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboBoxPrivilege;
    private javax.swing.JTextField fieldPassword;
    private javax.swing.JTextField fieldRepeatPassword;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelPasword;
    private javax.swing.JLabel labelPrivilege;
    private javax.swing.JLabel labelRepeatPassword;
    private javax.swing.JLabel labelUser;
    // End of variables declaration//GEN-END:variables
}
