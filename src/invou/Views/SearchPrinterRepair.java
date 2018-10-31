package invou.Views;

import javax.swing.table.DefaultTableModel;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author Leandro Asson
 */
public final class SearchPrinterRepair extends javax.swing.JInternalFrame {
    
    AuxiliaryFunctions af;
    private Object[][] tableData;
    PropertyChangeListener ActListener;
    
    public SearchPrinterRepair(SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        comboMonth.setEnabled(false);
        comboYear.setEnabled(false);
        fieldCode.setEnabled(false);
        generateTableData();
        this.ActListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                filterTable();
            }
    };
        comboMonth.addPropertyChangeListener(ActListener);
        comboYear.addPropertyChangeListener(ActListener);
  
    }
    
    public void generateTableData()
    {      
        tableData = af.getPrintersRepair();
        generateTableData(tableData);
    }
    
    public void filterTable()
    {
        boolean[] filtro = {boxCode.isSelected(), boxMonth.isSelected(), boxYear.isSelected()};
        int mes = comboMonth.getMonth()+1;
        int ano = comboYear.getYear();  
        String code = fieldCode.getText();
        tableData = af.filterPrinterRepair(code, mes, ano, filtro);
        generateTableData(tableData);
    }
    
   public void generateTableData(Object [][] datostabla)
   {          
        String[] columnas = {"N° rep.","N° serie", "Modelo", "Salida", "Retorno", "Falla", "Detalle de reparación"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(60);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(90);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(115);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(70);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(110);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(150);
   }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonExit = new javax.swing.JButton();
        comboMonth = new com.toedter.calendar.JMonthChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        boxMonth = new javax.swing.JCheckBox();
        boxCode = new javax.swing.JCheckBox();
        boxYear = new javax.swing.JCheckBox();
        comboYear = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        fieldCode = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar reparaciones de impresoras");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/list16.png"))); // NOI18N

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

        boxMonth.setText("Mes: ");
        boxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMonthActionPerformed(evt);
            }
        });

        boxCode.setText("N° de serie:");
        boxCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCodeActionPerformed(evt);
            }
        });

        boxYear.setText("Año");
        boxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxYearActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonExit)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxCode)
                                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxMonth)
                                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxYear)
                                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 389, Short.MAX_VALUE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                    .addGap(26, 26, 26)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxMonth)
                    .addComponent(boxCode)
                    .addComponent(boxYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(buttonExit)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGap(54, 54, 54)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void boxCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCodeActionPerformed
        if(boxCode.isSelected())
        { 
            fieldCode.setEnabled(true);
            fieldCode.requestFocus();
        }
        else
        {
            fieldCode.setEnabled(false);
            filterTable();
        }  
    }//GEN-LAST:event_boxCodeActionPerformed

    private void boxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMonthActionPerformed
        if(boxMonth.isSelected())
        { 
            comboMonth.setEnabled(true);
            comboYear.setEnabled(true);
            boxYear.setEnabled(false);
            boxYear.setSelected(true);
            filterTable();
        }
        else
        {
            comboMonth.setEnabled(false);
            comboYear.setEnabled(false);
            boxYear.setEnabled(true);
            boxYear.setSelected(false);
            filterTable();
        }    
    }//GEN-LAST:event_boxMonthActionPerformed

    private void boxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxYearActionPerformed
      if(boxYear.isSelected())
      {
          comboYear.setEnabled(true);
          filterTable();
      }
      else
      {
          comboYear.setEnabled(false);
          filterTable();
      }    
    }//GEN-LAST:event_boxYearActionPerformed

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
       filterTable();
    }//GEN-LAST:event_fieldCodeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxCode;
    private javax.swing.JCheckBox boxMonth;
    private javax.swing.JCheckBox boxYear;
    private javax.swing.JButton buttonExit;
    private com.toedter.calendar.JMonthChooser comboMonth;
    private com.toedter.calendar.JYearChooser comboYear;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
