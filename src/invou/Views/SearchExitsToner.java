package invou.Views;

import javax.swing.table.DefaultTableModel;
import invou.AuxiliaryFunctions;
import invou.EquipmentReportXLS;
import invou.SaveExcelFile;
import invou.SentencesSql;
import invou.TonerReportXLS;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Asson
 */
public final class SearchExitsToner extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af;
    private Object[][] tableDate; 
    ActionListener ActionModel;
    PropertyChangeListener ActListener;
    
    public SearchExitsToner(SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        comboMonth.setEnabled(false);
        comboModel.setEnabled(false);
        comboYear.setEnabled(false);
        showTable();
        completeComboModel(); 
        this.ActionModel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
        comboModel.addActionListener(ActionModel);
        this.ActListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pce) {
                filterTable();
            }
    };
        comboMonth.addPropertyChangeListener(ActListener);
        comboYear.addPropertyChangeListener(ActListener);
    }
    
    public void showTable()
    {
        tableDate = af.getEgressToner();
        generateTableData(tableDate);
    }

    public void completeComboModel()
    {
        Object[] codigo = af.combox("tonner","modelo");
        comboModel.removeAllItems();
        for (Object codigo1 : codigo)
        {
            comboModel.addItem(String.valueOf(codigo1));
        }
    }
    public void filterTable()
    {
        boolean[] filtro = {boxModel.isSelected(), boxMonth.isSelected(), boxYear.isSelected()};
        int mes = comboMonth.getMonth()+1;
        int ano = comboYear.getYear();  
        String modelo = comboModel.getSelectedItem().toString();
        tableDate = af.filterToner("egresotonner", modelo, ano, mes, filtro);
        generateTableData(tableDate);
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
       System.out.println(datostabla.length);
        String[] columnas = {"N° egreso","Codigo", "Modelo", "Detalle","Impresoras compatibles", "fecha", "cantidad"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable2.setModel(datos);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(70);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(60);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(130);
        jTable2.getColumnModel().getColumn(2).setMaxWidth(150);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(200);
        //jTable2.getColumnModel().getColumn(4).setMaxWidth(210);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTable2.getColumnModel().getColumn(3).setMaxWidth(130);
        jTable2.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTable2.getColumnModel().getColumn(5).setMaxWidth(90);
        jTable2.getColumnModel().getColumn(6).setPreferredWidth(60);
        jTable2.getColumnModel().getColumn(6).setMaxWidth(60);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        comboMonth = new com.toedter.calendar.JMonthChooser();
        jSeparator1 = new javax.swing.JSeparator();
        comboModel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        boxMonth = new javax.swing.JCheckBox();
        boxModel = new javax.swing.JCheckBox();
        boxYear = new javax.swing.JCheckBox();
        comboYear = new com.toedter.calendar.JYearChooser();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar egresos de toner");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/list16.png"))); // NOI18N

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable2);

        comboModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Filtrar por:");

        boxMonth.setText("Mes: ");
        boxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMonthActionPerformed(evt);
            }
        });

        boxModel.setText("Modelo: ");
        boxModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxModelActionPerformed(evt);
            }
        });

        boxYear.setText("Año");
        boxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxYearActionPerformed(evt);
            }
        });

        jButton1.setText("Generar reporte ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExit))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxModel))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxMonth)
                            .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxYear)
                            .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 359, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE)
                    .addGap(29, 29, 29)))
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
                    .addComponent(boxModel)
                    .addComponent(boxYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(jButton1))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                    .addGap(53, 53, 53)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
    this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void boxModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxModelActionPerformed
        if(boxModel.isSelected())
        { 
            comboModel.setEnabled(true);
            filterTable();
        }
        else
        {
            comboModel.setEnabled(false);
            filterTable();
        }  
    }//GEN-LAST:event_boxModelActionPerformed

    private void boxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMonthActionPerformed
        if(boxMonth.isSelected())
        { 
            comboMonth.setEnabled(true);
            boxYear.setSelected(true);
            comboYear.setEnabled(true);
            filterTable();
        }
        else
        {
            boxYear.setSelected(false);
            comboYear.setEnabled(false);
            comboMonth.setEnabled(false);
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
          boxMonth.setSelected(false);
          comboMonth.setEnabled(false);
          comboYear.setEnabled(false);
          filterTable();
      }    
    }//GEN-LAST:event_boxYearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean[] filter = {boxYear.isSelected(), boxMonth.isSelected()};
        int month = comboMonth.getMonth()+1;
        int year = comboYear.getYear();  
        if(!boxYear.isSelected() && !boxMonth.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Seleccione el mes y año para generar el reporte.", "Atención", JOptionPane.WARNING_MESSAGE); 
        }
        else if(boxMonth.isSelected() && !boxYear.isSelected())
        {
            JOptionPane.showMessageDialog(null, "indique el año del mes seleccionado.", "Atención", JOptionPane.WARNING_MESSAGE); 
        }
        else
        { 
            SaveExcelFile file;
            if(!boxMonth.isSelected())
            {
            file = new SaveExcelFile("Consumo toner "+year);
            }
            else
            {
            file = new SaveExcelFile("Consumo toner "+month+"-"+year);
            }
            
            String[] column = {"Codigo  ", "Modelo          ", "Detalle", "Impresoras compatibles                   ", "cantidad"};
            Object[][] report = af.getReportToner(year, month, filter);

            TonerReportXLS xls = new TonerReportXLS(report, column, "Consumo toner "+month+"/"+year);

            String route = file.getRoute();
            if(route != null)
            {
                    xls.generates(route);
            }   
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxModel;
    private javax.swing.JCheckBox boxMonth;
    private javax.swing.JCheckBox boxYear;
    private javax.swing.JComboBox<String> comboModel;
    private com.toedter.calendar.JMonthChooser comboMonth;
    private com.toedter.calendar.JYearChooser comboYear;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
