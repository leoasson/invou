package invou.Views;

import invou.AuxiliaryFunctions;
import java.text.Normalizer.Form;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class SearchStockToner extends javax.swing.JFrame {
    AuxiliaryFunctions af = new AuxiliaryFunctions();
    private Object[][] tableDate; 
    Object[] model;
    int state=0;
    EgressToner et = new EgressToner();
    IngressToner it = new IngressToner();
            
    public SearchStockToner()
    {
        initComponents();
        init();
        buttonAcept.setEnabled(false);
    }
    
    public SearchStockToner(EgressToner et)
    {
        initComponents();
        init();
        this.et = et;
        state = 1;
        setTitle("Seleccionar codigo de toner");
    }
    
    public SearchStockToner(IngressToner it)
    {
        initComponents();
        init();
        this.it = it;
        state = 2;
        setTitle("Seleccionar codigo de toner");
    }
    
    
    public void init()
    {
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/searchLessee16.png")));
        this.setLocationRelativeTo(null);
        comboModel.setEnabled(false);
        completeComboModel();
        showTable();
    }
    
    
public void showTable()
    {
        tableDate = af.getStockToner();
        generateTableData(tableDate);
    }
    
    public void completeComboModel()
    {
        model = af.combox("tonner", "modelo");
        comboModel.removeAllItems();
        for (Object models : model) 
        {
            comboModel.addItem(models.toString());
        }
        comboModel.setEditable(true);
        AutoCompleteDecorator.decorate(comboModel);
    }
    
    public void generateTableData(Object [][] datostabla)
    {   
        String[] columnas = {"Codigo_articulo","modelo", "Descripcion", "Stock"};
        DefaultTableModel datos = new DefaultTableModel(tableDate,columnas);
        jTable1.setModel(datos);
        //jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
        //jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
        //jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        boxName = new javax.swing.JCheckBox();
        comboModel = new javax.swing.JComboBox<>();
        buttonFilter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonAcept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Stock de toner");

        jLabel1.setText("Filtrar por:");

        boxName.setText("Modelo");
        boxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxNameActionPerformed(evt);
            }
        });

        comboModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelActionPerformed(evt);
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
                            .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boxName)
                                .addGap(112, 112, 112)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonFilter)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boxName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(buttonAcept))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxNameActionPerformed
        if(boxName.isSelected()){ comboModel.setEnabled(true);}
        else
        {
            comboModel.setEnabled(false);
            showTable();
        }
    }//GEN-LAST:event_boxNameActionPerformed

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
        /*
        if(boxDNI.isSelected() && !fieldDNI.getText().equals("") || boxName.isSelected())
        {
            boolean[] filter = {boxDNI.isSelected(), boxName.isSelected()};
            String nameAndLastName, DNI;
            DNI = fieldDNI.getText();
            nameAndLastName = comboName.getSelectedItem().toString();
            tableDate = af.filterLessee(DNI, nameAndLastName, filter);
            generateTableData(tableDate);
        }
        else
        {     
            JOptionPane.showMessageDialog(null,"Asegurese de haber completado los campos para el filtrado.","",JOptionPane.WARNING_MESSAGE);
        }*/
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada."," ",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            switch(state)
            {
                case 1:
                        et.setCode(tableDate[row][0].toString());
                        this.dispose();
                        break;                       
                default:
                        it.setCode(tableDate[row][0].toString());
                        this.dispose();
                        break;
            }

        }      
    }//GEN-LAST:event_buttonAceptActionPerformed

    private void comboModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelActionPerformed

    }//GEN-LAST:event_comboModelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxName;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JComboBox<String> comboModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
