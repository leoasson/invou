/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 
 */
public class RegisterNewSector extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    SentencesSql sensql = new SentencesSql();
    ActionListener actionBranch;
    ActionListener actionFloor;

    public RegisterNewSector()
    {
        initComponents();
        completeComboBranch();
        clean();
        String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
        completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
        
        this.actionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboFloor.setSelectedItem(null);
                    comboFloor.setEnabled(true);
                }
            }
        };
        comboBranch.addActionListener(actionBranch);
        this.actionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboFloor.getSelectedItem()!= null)
                {
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    String idPiso = af.parseFloor(comboFloor.getSelectedItem().toString());
                }
            }
        };
        comboFloor.addActionListener(actionFloor);
        
    }

    private void clean()
    {
       fieldSector.setText("");
    }
    
    private void completeComboBranch()
    {
        Object[] branch_;
        branch_ = af.combox("sucursal", "sucursal");
        comboBranch.removeAllItems();
        for (Object branchs : branch_) 
        {
            comboBranch.addItem(branchs.toString());
        }
    }
    
    private void completeComboFloor(String where)
    {
        Object[] floor_;
        String nameColumn = "piso";
        floor_ = sensql.setFilterCombox(nameColumn, "FROM `area` LEFT JOIN `piso` ON `cod_piso` = `id_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal` where " + where + " ORDER BY `piso`");
        comboFloor.removeAllItems();
        for (Object branchs : floor_) 
        {
            comboFloor.addItem(branchs.toString());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        fieldSector = new javax.swing.JTextField();
        Sucursal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buttonSalir = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        comboBranch = new javax.swing.JComboBox<>();
        comboFloor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

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

        setTitle("Registrar nuevo sector");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/registryEditor16.png"))); // NOI18N

        Sucursal.setText("Sucursal");

        jLabel2.setText("Sector");

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

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboFloor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Piso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(fieldSector, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sucursal)
                            .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sucursal)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(4, 4, 4)
                .addComponent(fieldSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegister)
                    .addComponent(buttonSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        String branch, floor;
        String sector = fieldSector.getText();
        
        branch = af.parseBranch(comboBranch.getSelectedItem().toString());
        floor = af.parseFloor(comboFloor.getSelectedItem().toString());
        
        if(!af.existSector(branch,floor,sector))
        {
            if (JOptionPane.showConfirmDialog(null, "Está seguro que desea agregar el sector "+sector+" en el piso "+comboFloor.getSelectedItem().toString()+" de la sucursal "+comboBranch.getSelectedItem().toString()+"?", "",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                if(af.registerNewSector(branch, floor, sector))
                {
                JOptionPane.showMessageDialog(null,"El sector se registró con éxito");
                fieldSector.requestFocus();
                clean();   
                }
            }
        }
        else
        {
           JOptionPane.showMessageDialog(null,"Error al registrar el articulo, puede que ya exista ese sector","Mensaje",JOptionPane.INFORMATION_MESSAGE);
        }
            
    }//GEN-LAST:event_buttonRegisterActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Sucursal;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JButton buttonSalir;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JComboBox<String> comboFloor;
    private javax.swing.JTextField fieldSector;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
