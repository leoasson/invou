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
public final class SearchIncomeToner extends javax.swing.JInternalFrame {
    
    AuxiliaryFunctions af;
    private Object[][] tableData; 
    ActionListener ActionModel;
    PropertyChangeListener ActListener;
    String superconsult;
    
    
    public SearchIncomeToner(SentencesSql sensql)
    {
        af= new AuxiliaryFunctions(sensql);
        initComponents();
        comboMonth.setEnabled(false);
        comboModel.setEnabled(false);
        comboYear.setEnabled(false);
        labelTotal.setEditable(false);
        table.setDefaultEditor(Object.class, null);
        completeComboModel();
        generateTableData();
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
    
    public void generateTableData()
    {      
        tableData = af.getIngressToner();
        generateTableData(tableData);
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
        tableData = af.filterToner("ingresotonner", modelo, ano, mes, filtro);
        generateTableData(tableData);
        superconsult = af.getConsultSql();
        setTotalToner(superconsult);
    }
    
    private void setTotalToner(String superConsult)  
    {
        labelTotal.setText(String.valueOf(af.getTotalToner("from (" + superConsult + ") as superconsult")));
    } 
    public void generateTableData(Object [][] datostabla)
    {          
        String[] columnas = {"N° ingreso","Codigo", "Modelo", "Detalle", "Proveedor", "fecha", "cantidad"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        table.setModel(datos);
        table.getColumnModel().getColumn(0).setMaxWidth(60);
        table.getColumnModel().getColumn(4).setMaxWidth(80);
        table.getColumnModel().getColumn(5).setMaxWidth(70);
        table.getColumnModel().getColumn(6).setMaxWidth(60);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonExit = new javax.swing.JButton();
        comboMonth = new com.toedter.calendar.JMonthChooser();
        jSeparator1 = new javax.swing.JSeparator();
        comboModel = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        boxMonth = new javax.swing.JCheckBox();
        boxModel = new javax.swing.JCheckBox();
        boxYear = new javax.swing.JCheckBox();
        comboYear = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        labelTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar ingresos de toner");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/list16.png"))); // NOI18N

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

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

        jLabel2.setText("Total");

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
                                .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boxModel))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(boxMonth)
                                .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(boxYear)
                                    .addGap(212, 212, 212)
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE)))
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
                    .addComponent(boxYear)
                    .addComponent(jLabel2)
                    .addComponent(labelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 314, Short.MAX_VALUE)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boxModel;
    private javax.swing.JCheckBox boxMonth;
    private javax.swing.JCheckBox boxYear;
    private javax.swing.JButton buttonExit;
    private javax.swing.JComboBox<String> comboModel;
    private com.toedter.calendar.JMonthChooser comboMonth;
    private com.toedter.calendar.JYearChooser comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField labelTotal;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
