package invou.Views;

import javax.swing.table.DefaultTableModel;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Leandro Asson
 */
public final class SearchPrinterRepair extends javax.swing.JInternalFrame {
    
    AuxiliaryFunctions af;
    private Object[][] tableData;
    PropertyChangeListener ActListener;
    DefaultTableModel data;
    SentencesSql sensql;
    private final View view;
    ModifyPrinterRepair modifyRepair;
    
    public SearchPrinterRepair(View view, SentencesSql sensql)
    {
        this.view = view;
        this.sensql = sensql;
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        init();
    }
    
    public void init()
    {
        table.setDefaultEditor(Object.class, null);
        comboMonth.setEnabled(false);
        fieldPrinterRepair.setEditable(false);
        comboYear.setEnabled(false);
        fieldCode.setEnabled(false);
        generateTableData(af.getPrintersRepair());
        this.ActListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                filterTable();
            }};
        comboMonth.addPropertyChangeListener(ActListener);
        comboYear.addPropertyChangeListener(ActListener);
        
        
        table.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int rowClicked = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
        {
            String id_repair = ((String) data.getValueAt(rowClicked, 0));
            newViewModify(id_repair);            
        }
    }
        });
    
    }
    public void newViewModify(String id_repair)
    {
        view.addModifyPrinterRapair(this, id_repair);  
    }
    
    public void filterTable()
    {
        boolean[] filtro = {boxCode.isSelected(), boxMonth.isSelected(), boxYear.isSelected()};
        int mes = comboMonth.getMonth()+1;
        int ano = comboYear.getYear();  
        String code = fieldCode.getText();
        tableData = af.filterPrinterRepair(code, mes, ano, filtro);
        generateTableData(tableData);
        SetTotalPrinterRepair();
    }
    
   public void SetTotalPrinterRepair()
   {
    fieldPrinterRepair.setText(String.valueOf(af.getPrinterRepairActually()));
   }
   
   public void generateTableData(Object [][] tableData)
   {          
        String[] columnas = {"N° rep.","N° serie", "Modelo", "Salida", "Retorno", "Proveedor", "Falla", "Detalle de reparación"};
        data = new DefaultTableModel(tableData,columnas);
        table.setModel(data);
        RowSorter<TableModel> sorter = new TableRowSorter<>(data);
        table.setRowSorter(sorter);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(1).setPreferredWidth(80);
        table.getColumnModel().getColumn(1).setMaxWidth(90);
        table.getColumnModel().getColumn(2).setPreferredWidth(115);
        table.getColumnModel().getColumn(2).setMaxWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(70);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(6).setPreferredWidth(120);
        table.getColumnModel().getColumn(6).setMaxWidth(500);
        table.getColumnModel().getColumn(7).setPreferredWidth(120);
        table.getColumnModel().getColumn(7).setMaxWidth(500);
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
        table = new javax.swing.JTable();
        fieldCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldPrinterRepair = new javax.swing.JTextField();

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

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        jLabel3.setText("En reparación:");

        fieldPrinterRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPrinterRepairActionPerformed(evt);
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
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(boxCode)
                                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(boxMonth)
                                .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(boxYear)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldPrinterRepair, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(boxYear)
                    .addComponent(jLabel3)
                    .addComponent(fieldPrinterRepair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
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
    view.closeModifyPrinterRepair();
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

    private void fieldPrinterRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPrinterRepairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPrinterRepairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxCode;
    private javax.swing.JCheckBox boxMonth;
    private javax.swing.JCheckBox boxYear;
    private javax.swing.JButton buttonExit;
    private com.toedter.calendar.JMonthChooser comboMonth;
    private com.toedter.calendar.JYearChooser comboYear;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldPrinterRepair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
