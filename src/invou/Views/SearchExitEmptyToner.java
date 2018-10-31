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
public final class SearchExitEmptyToner extends javax.swing.JInternalFrame {

    AuxiliaryFunctions af;
    private Object[][] tableDate; 
    ActionListener ActionModel;
    PropertyChangeListener ActListener;
    
    public SearchExitEmptyToner(SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        comboMonth.setEnabled(false);
        comboYear.setEnabled(false);

        showTable();
        this.ActionModel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
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
        tableDate = af.getExitEmptyToner();
        generateTableData(tableDate);
    }

    public void filterTable()
    {
        boolean[] filtro = {boxMonth.isSelected(), boxYear.isSelected()};
        int mes = comboMonth.getMonth()+1;
        int ano = comboYear.getYear();  
        tableDate = af.filterExitEmptyToner(ano, mes, filtro);
        generateTableData(tableDate);
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
       System.out.println(datostabla.length);
        String[] columnas = {"N° egreso","fecha", "cantidad"};
        DefaultTableModel datos = new DefaultTableModel(datostabla,columnas);
        jTable2.setModel(datos);
        jTable2.getColumnModel().getColumn(0).setMaxWidth(60);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(200);
        jTable2.getColumnModel().getColumn(1).setMaxWidth(100);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonExit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        comboMonth = new com.toedter.calendar.JMonthChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        boxMonth = new javax.swing.JCheckBox();
        boxYear = new javax.swing.JCheckBox();
        comboYear = new com.toedter.calendar.JYearChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar retiro de toner vacios");
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

        jLabel1.setText("Filtrar por:");

        boxMonth.setText("Mes: ");
        boxMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxMonthActionPerformed(evt);
            }
        });

        boxYear.setText("Año");
        boxYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ButtonExit))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boxMonth)
                                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxYear))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1))))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxYear)
                            .addComponent(boxMonth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(ButtonExit)
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

    private void boxMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxMonthActionPerformed
        if(boxMonth.isSelected())
        { 
            boxYear.setSelected(true);
            comboMonth.setEnabled(true);
            comboYear.setEnabled(true);
            filterTable();
        }
        else
        {
            comboMonth.setEnabled(false);
            filterTable();
        }    
    }//GEN-LAST:event_boxMonthActionPerformed

    private void boxYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxYearActionPerformed
      if(boxYear.isSelected())
      {
          comboYear.setEnabled(true);
          boxMonth.setEnabled(true);
          filterTable();
      }
      else
      {
          comboMonth.setEnabled(false);
          boxMonth.setSelected(false);
          comboYear.setEnabled(false);
          filterTable();
      }    
    }//GEN-LAST:event_boxYearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxMonth;
    private javax.swing.JCheckBox boxYear;
    private com.toedter.calendar.JMonthChooser comboMonth;
    private com.toedter.calendar.JYearChooser comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
