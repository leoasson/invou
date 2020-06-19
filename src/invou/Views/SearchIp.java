package invou.Views;

import javax.swing.table.DefaultTableModel;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import invou.ip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Leandro Asson
 */
public final class SearchIp extends javax.swing.JInternalFrame
{
    
    AuxiliaryFunctions af;
    private Object[][] tableData;
    DefaultTableModel datos;
    ip ip = new ip(); 
    PropertyChangeListener ActListener;
    ReserveIp reserveIp;
    String begin,end;
    int tableLength;
    int state=0;
    SentencesSql sensql;
    
    public SearchIp(SentencesSql sensql)
    {
        this.sensql = sensql;
        init();
        state=1;
        table.setEnabled(false);
        buttonAcept.setEnabled(false);
    }

    public SearchIp(ReserveIp reserveIp, SentencesSql sensql)
    {
        this.sensql = sensql;
        init();
        this.reserveIp=reserveIp;
        state=2;


        table.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent)
        {
            JTable table =(JTable) mouseEvent.getSource();
            Point point = mouseEvent.getPoint();
            int rowClicked = table.rowAtPoint(point);
            if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
                {
                    reserveIp.setIp((String) datos.getValueAt(rowClicked, 0));
                    closeWindows();
                }
        }});    
    }
    
   private void closeWindows()
    {
        this.dispose();
    }
    
   private void init ()
   {
        af= new AuxiliaryFunctions(sensql);
        initComponents();
        fieldName.setEnabled(false);
        fieldIp.setEnabled(false);
        tableData = af.getIp();
        generateTableData(tableData);
        table.setDefaultEditor(Object.class, null);
   }
   
    private void generateTableData(Object [][] datostabla)
    {          
         String[] columnas = {"Ip","Nombre", "Estado"};
         datos = new DefaultTableModel(datostabla,columnas);
         RowSorter<TableModel> sorter = new TableRowSorter<>(datos);
         table.setRowSorter(sorter);
         table.setModel(datos);
         table.getColumnModel().getColumn(0).setPreferredWidth(100);
         table.getColumnModel().getColumn(0).setMaxWidth(110);
         table.getColumnModel().getColumn(1).setPreferredWidth(100);
         table.getColumnModel().getColumn(2).setPreferredWidth(100);
         table.getColumnModel().getColumn(2).setMaxWidth(120);
         table.getColumnModel().getColumn(2).setCellRenderer(new SearchIp.StatusColumnCellRenderer());

    }
    
    private void cleanTable()
    {
        tableData = af.getIp();
        generateTableData(tableData);
    }
    
    private boolean filter() 
    {     
        boolean exist = false;
        ArrayList<String> array = ip.generateRange(begin, end);
        int rows = table.getRowCount();

        for(int i=0;i<rows;i++)
        {
            String value = (String) table.getValueAt(i, 0);
            for(int k=0;k<array.size();k++)
            {
                if(value.equals(array.get(k)))
                {
                    exist = true;
                    k = array.size();
                }
            }    
            if(!exist)
            {
                ((DefaultTableModel)table.getModel()).removeRow(i);
                table.repaint();
                return true;
            }
            exist = false;

        } 
        return false;
}

    private int verifyRange()
    {
        String value = fieldIp.getText();
        if(value.equals(""))
        { 
           return -1;
        }
        if(value.contains("-"))
        {
            String [] ips = value.split("-");
             if(ip.validateIP(ips[0]) && ip.validateIP(ips[1]))
             {
                 return 0;
             }
             else
             {
                JOptionPane.showMessageDialog(null, "Revisar las ip ingresadas.", "Mensaje", JOptionPane.WARNING_MESSAGE);
                return -1;
                 
             }
        }  
        else if(ip.validateIP(value))
        {
            return 1;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Debe ingresar el rango de las ip separado por un guion medio(-). \n Por ejemplo: 192.168.0.1-192.168.0.255", "Mensaje", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }
    
    private void filterTableForRange()
    {
        boolean filter;
        switch(verifyRange())
        {
            case 0:
                tableData = af.getIp();
                generateTableData(tableData);
                String [] ips = fieldIp.getText().split("-");
                begin = ips[0];
                end = ips[1];
                filter = true;  
                while(filter)
                {
                    filter = filter();
                }
                break;
                
            case 1:
                tableData = af.getIp();
                generateTableData(tableData);
                begin = end = fieldIp.getText();
                filter = true;  
                while(filter)
                {
                    filter = filter();
                }
                break;
            case -1:
            tableData = af.getIp();
            generateTableData(tableData);
                break; 
            default:
                break;
                
        }

}
      
    private void filterTableForName()
    {
        tableData = af.filterIp(fieldName.getText());
        generateTableData(tableData);
    }
    
    
    public class StatusColumnCellRenderer extends DefaultTableCellRenderer {
     @Override
     public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) 
     {  
        JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

          //Get the status for the current row.
          switch (value.toString()) {
              case "EN USO":
                  l.setBackground(Color.RED);
                  break;
              case "DISPONIBLE":
                  l.setBackground(Color.GREEN);
                  break;   
              case "RESERVADA":
                  l.setBackground(Color.ORANGE);
                  break; 
              default:
                  l.setBackground(Color.WHITE);
                  break;
          }
      return l;
    }}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonExit = new javax.swing.JButton();
        buttonFilter = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        fieldIp = new javax.swing.JTextField();
        buttonAcept = new javax.swing.JButton();
        checkBoxIp = new javax.swing.JCheckBox();
        checkBoxName = new javax.swing.JCheckBox();
        fieldName = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Listar IP");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/listRepair16.png"))); // NOI18N

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        buttonFilter.setText("Filtrar");
        buttonFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFilterActionPerformed(evt);
            }
        });

        jLabel1.setText("Filtrar por:");

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

        fieldIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIpActionPerformed(evt);
            }
        });

        buttonAcept.setText("Aceptar");
        buttonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptActionPerformed(evt);
            }
        });

        checkBoxIp.setText("Ip/ rango");
        checkBoxIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxIpActionPerformed(evt);
            }
        });

        checkBoxName.setText("Nombre");
        checkBoxName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxNameActionPerformed(evt);
            }
        });

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxIp)
                        .addGap(208, 208, 208)
                        .addComponent(checkBoxName)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(buttonAcept)
                                .addGap(18, 18, 18)
                                .addComponent(buttonExit))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 167, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57)
                                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(buttonFilter))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(25, 25, 25))))
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
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkBoxIp)
                    .addComponent(checkBoxName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonFilter)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExit)
                    .addComponent(buttonAcept))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                    .addGap(54, 54, 54)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    private void buttonFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFilterActionPerformed
    if(checkBoxIp.isSelected())
        filterTableForRange();
    else if (checkBoxName.isSelected())
        filterTableForName();
    else
        cleanTable();
    }//GEN-LAST:event_buttonFilterActionPerformed

    private void fieldIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIpActionPerformed
        filterTableForRange();
    }//GEN-LAST:event_fieldIpActionPerformed

    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptActionPerformed
        int row = table.getSelectedRow();
        if(row < 0)
        {
        JOptionPane.showMessageDialog(null,"Seleccione la fila deseada."," ",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            switch(state)
            {
                case 1:
                        //lessee1.setFieldPadron(tableDate[row][0].toString());
                        //this.dispose();
                        break;
                case 2:
                        reserveIp.setIp(tableData[row][0].toString());
                        this.dispose();
                        break;       
            }
        }
    }//GEN-LAST:event_buttonAceptActionPerformed

    private void checkBoxIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxIpActionPerformed
     if(checkBoxIp.isSelected())
     {
        fieldIp.setEnabled(true);
        fieldName.setEnabled(false);
        checkBoxName.setSelected(false);        
     }
     
     else
     {
        fieldIp.setEnabled(false);   
        fieldIp.setText("");
        cleanTable();
     }
    }//GEN-LAST:event_checkBoxIpActionPerformed

    private void checkBoxNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxNameActionPerformed
    if(checkBoxName.isSelected())
     {
        fieldName.setEnabled(true);
        fieldIp.setEnabled(false);
        checkBoxIp.setSelected(false);        
     }
     
     else
     {
        fieldName.setEnabled(false);   
        fieldName.setText("");
        cleanTable();
     }
    }//GEN-LAST:event_checkBoxNameActionPerformed

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        filterTableForName();
    }//GEN-LAST:event_fieldNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonFilter;
    private javax.swing.JCheckBox checkBoxIp;
    private javax.swing.JCheckBox checkBoxName;
    private javax.swing.JTextField fieldIp;
    private javax.swing.JTextField fieldName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
