package invou.Views;

import invou.AuxiliaryFunctions;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leoasson
 */
public final class SearchPrinter extends javax.swing.JFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    Object[] channel;
    Object[] name;
    int state = 0;
    ActionListener ActListener;
 
    
    public SearchPrinter()
    {
        initComponents();
        init();
        state = 0;
        buttonAcept.setEnabled(false);
        this.ActListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                filterTable();
            }
        };
        fieldState.addActionListener(ActListener);
        fieldModel.addActionListener(ActListener);
    }
    /*
    public SearchPadron(AssociateLesse lessee1) {
        initComponents();
        init();
        this.lessee1 = lessee1;
        buttonAcept.setEnabled(true);
        state = 1;
    }  
    */
    
    private void init()
    {
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/searchCensus16.png")));
        this.setLocationRelativeTo(null);
        fieldModel.setEnabled(false);
        fieldState.setEnabled(false);
        fieldCode.setEnabled(false);
        completeComboState();
        completeComboModel();
        showTable();

    }
    
    public void showTable()
    {
        tableDate = af.getPrinters();
        generateTableData(tableDate);
    }
    
    public void completeComboModel()
    {
        name = af.combox("modeloImpresora", "modelo");
        fieldModel.removeAllItems();
        for (Object period1 : name) 
        {
            fieldModel.addItem(period1.toString());
        } 
    }
    
    public void completeComboState()
    {
        String [] lessee = {"EN USO", "EN REPARACION", "DISPONIBLE"};
        fieldState.removeAllItems();
        for (int i= 0; i<3; i++) 
        {
            fieldState.addItem(lessee[i]);
        }
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
        String[] columnas = {"N° de serie", "N° de parte", "Modelo", "Sucursal", "Puesto","Impresiones", "Fecha", "Estado"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(110);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(90);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(100);
    }
    
    public void filterTable()
    {
        boolean[] filter = {boxCode.isSelected(), boxModel.isSelected(), boxState.isSelected()};
        String State, Code, Model;
        Code = fieldCode.getText();
        Model = fieldModel.getSelectedItem().toString();
        State = fieldState.getSelectedItem().toString(); 
        tableDate = af.filterPrint(Code, Model, State, filter);
        generateTableData(tableDate);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxState = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        boxCode = new javax.swing.JCheckBox();
        boxModel = new javax.swing.JCheckBox();
        fieldModel = new javax.swing.JComboBox<>();
        fieldState = new javax.swing.JComboBox<>();
        buttonFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonAcept = new javax.swing.JButton();
        fieldCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Buscar impresora");

        boxState.setText("Estado");
        boxState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxStateActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        boxCode.setText("Codigo:");
        boxCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCodeActionPerformed(evt);
            }
        });

        boxModel.setText("Modelo");
        boxModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxModelActionPerformed(evt);
            }
        });

        fieldModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldModelActionPerformed(evt);
            }
        });

        fieldState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldStateActionPerformed(evt);
            }
        });

        buttonFilter.setText("Filtrar");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        buttonAcept.setText("Aceptar");
        buttonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptActionPerformed(evt);
            }
        });

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAcept)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxCode, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxModel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxState)
                            .addComponent(fieldState, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonFilter))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonFilter)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxState)
                            .addComponent(boxCode)
                            .addComponent(boxModel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fieldState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(buttonAcept))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxStateActionPerformed
        if(boxState.isSelected())
        {
            fieldState.setEnabled(true);
            filterTable();
        }
        else
        {
            fieldState.setEnabled(false);
            filterTable();
        }
    }//GEN-LAST:event_boxStateActionPerformed

    private void boxCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCodeActionPerformed
        if(boxCode.isSelected()){ fieldCode.setEnabled(true);fieldCode.requestFocus();}
        else
        {
            fieldCode.setEnabled(false);
            filterTable();
        }
    }//GEN-LAST:event_boxCodeActionPerformed

    private void boxModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxModelActionPerformed
        if(boxModel.isSelected())
        { 
            fieldModel.setEnabled(true);
            filterTable();
        }
        else
        {
            fieldModel.setEnabled(false);
            filterTable();
        }  
    }//GEN-LAST:event_boxModelActionPerformed

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        filterTable();
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void fieldStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldStateActionPerformed
        buttonFilter.requestFocus();
    }//GEN-LAST:event_fieldStateActionPerformed

    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0)
        {
        JOptionPane.showMessageDialog(null,"Seleccione la fila deseada."," ",JOptionPane.WARNING_MESSAGE);
        }
        else
        {/*
            switch(state)
            {
                case 1:
                        lessee1.setFieldPadron(tableDate[row][0].toString());
                        this.dispose();
                        break;
                case 2:
                        modCensus.setFieldPadron(tableDate[row][0].toString());
                        this.dispose();
                        break;       
            }
        */}
    }//GEN-LAST:event_buttonAceptActionPerformed

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        filterTable();
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void fieldModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldModelActionPerformed
        //filterTable();
        buttonFilter.requestFocus();
    }//GEN-LAST:event_fieldModelActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxCode;
    private javax.swing.JCheckBox boxModel;
    private javax.swing.JCheckBox boxState;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JComboBox<String> fieldModel;
    private javax.swing.JComboBox<String> fieldState;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}