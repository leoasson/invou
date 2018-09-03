package invou.Views;

import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;

/**
 *
 * @author ANDRES
 */
public class RegisterNewPrint extends javax.swing.JInternalFrame {
     AuxiliaryFunctions af = new AuxiliaryFunctions();
     SentencesSql sen = new SentencesSql();
     String code, model, count, date, branch, position;
     String state="DISPONIBLE";
     
     

    public RegisterNewPrint()
    {
        initComponents();
        completeComboBranch();
        fieldModel.setEnabled(false);
        fieldDate.setDate(af.getActualDate());
        completeComboPositions();
        clean();
    }

    private void clean()
    {
       verifyRadioButton();
       setPrintPosition.setSelected(false);
       comboBranch.setSelectedItem(null);
       comboPosition.setSelectedItem(null);
       fieldCode.setText("");
       fieldPart.setText("");
       fieldModel.setText("");
       fieldCount.setText("");
       fieldCode.requestFocus();
    }
    
    private void completeComboBranch()
    {
        Object[] branch;
        branch = af.combox("sucursal", "sucursal");
        comboBranch.removeAllItems();
        for (Object branchs : branch) 
        {
            comboBranch.addItem(branchs.toString());
        }
    }
    
    private void completeComboPositions()
    {
        Object[] position;
        position = af.combox("puesto", "puesto");
        comboPosition.removeAllItems();
        for (Object positions : position) 
        {
            comboPosition.addItem(positions.toString());
        }
    }
    
    private boolean verifyModel()
    {
        if(!af.existPrintModel(fieldPart.getText()))
        {
            JOptionPane.showMessageDialog(null,"El modelo no se encuentra registrado en la base de datos.");
            fieldPart.setText("");
            return false;
        }
        else
        {
            fieldModel.setText(sen.getData("modelo", "select modelo from modeloImpresora where id_pn='"+fieldPart.getText()+"';"));
            fieldCount.requestFocus();
            return true;
        }
    }
    private void verifyRadioButton()
    {
    if(setPrintPosition.isSelected())
       {
            comboBranch.setEnabled(true);
            comboPosition.setEnabled(true);
       }
       else
       {
            comboBranch.setEnabled(false);
            comboPosition.setEnabled(false);
       }
    }
    
    private void insertPrinter(String state)
    {
        if(af.registerNewPrint(code, model, branch, position, state) && af.ingressPagesPrinted(code, date, count))
        {
            JOptionPane.showMessageDialog(null,"La impresora se registró correctamente.");
            clean();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Se produjo un error al momente de agregar la impresora." ,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void getValues()
    {
        code = fieldCode.getText();
        model = fieldPart.getText();
        count = fieldCount.getText();
        date = af.getDateToString(fieldDate.getDate());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        fieldPart = new javax.swing.JTextField();
        fieldCode = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonExit = new javax.swing.JButton();
        buttonRegister = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        comboBranch = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        comboPosition = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        fieldCount = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldDate = new com.toedter.calendar.JDateChooser();
        fieldModel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        setPrintPosition = new javax.swing.JRadioButton();

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

        setTitle("Registrar nueva impresora");

        fieldPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPartActionPerformed(evt);
            }
        });

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        jLabel1.setText("N° de serie");

        jLabel2.setText("N° de parte");

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonRegister.setText("Registrar");
        buttonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterActionPerformed(evt);
            }
        });

        jLabel4.setText("Sucursal");

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Puesto");

        comboPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Cantidad de impresiones");

        fieldCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCountActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha");

        fieldModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldModelActionPerformed(evt);
            }
        });

        jLabel8.setText("Modelo");

        setPrintPosition.setText("Definir ubicación de la impresora");
        setPrintPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPrintPositionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(setPrintPosition)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldPart, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(fieldCode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldModel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3))
                            .addComponent(fieldCount, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(fieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(buttonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(comboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(setPrintPosition)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonRegister)
                            .addComponent(buttonExit))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterActionPerformed
        
        if(!af.isValidNumber(fieldCount.getText()))
        {
            JOptionPane.showMessageDialog(null,"La cantidad de impresiones ingresada no es válida.","Advertencia",JOptionPane.WARNING_MESSAGE);
            fieldCount.setText("");
            return;
        }
        if(af.existPrinterCode(fieldCode.getText()))
        {
            JOptionPane.showMessageDialog(null,"Ya se encuentra registrada la impresora en la base de datos." ,"Advertencia",JOptionPane.WARNING_MESSAGE);
            clean();
            return;
        }
        if(!verifyModel())
        {
            return;
        }
        

        if(setPrintPosition.isSelected() && comboBranch.getSelectedItem()!=null && comboPosition.getSelectedItem()!=null)
        {
            //el usuario desea configurar una ubicacion de la impresora.
            branch = af.parseBranch(comboBranch.getSelectedItem().toString());
            position = af.parsePosition(comboPosition.getSelectedItem().toString());
            getValues();
            insertPrinter("EN USO");
            
        }
        else
        {
            //La impresora se agraga sin una ubicacion especifica.
            branch = null;
            position = null;
            getValues();    
            insertPrinter("DISPONIBLE");
        }
        
    }//GEN-LAST:event_buttonRegisterActionPerformed

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        if(af.existPrinterCode(fieldCode.getText()))
        {
            JOptionPane.showMessageDialog(null,"Ya se encuentra registrado el código en la base de datos." ,"Advertencia",JOptionPane.WARNING_MESSAGE);
            clean();
            return;
        }
        fieldPart.requestFocus();
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void fieldModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldModelActionPerformed

    }//GEN-LAST:event_fieldModelActionPerformed

    private void fieldPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPartActionPerformed
        verifyModel();
    }//GEN-LAST:event_fieldPartActionPerformed

    private void fieldCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCountActionPerformed
        buttonRegister.requestFocus();
    }//GEN-LAST:event_fieldCountActionPerformed

    private void setPrintPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPrintPositionActionPerformed
        verifyRadioButton();       
    }//GEN-LAST:event_setPrintPositionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonRegister;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JComboBox<String> comboPosition;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldCount;
    private com.toedter.calendar.JDateChooser fieldDate;
    private javax.swing.JTextField fieldModel;
    private javax.swing.JTextField fieldPart;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton setPrintPosition;
    // End of variables declaration//GEN-END:variables
}