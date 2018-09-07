package invou.Views;

import invou.AuxiliaryFunctions;
import invou.PrintLabel;
import invou.SentencesSql;
import invou.Views.View;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leoasson
 */
public final class SearchEquipment extends javax.swing.JInternalFrame {
    AuxiliaryFunctions af;
    SentencesSql sensql;
    private Object[][] tableDate; 
    private View view;
    private ModifyEquipment equipment;
    IngressEquipmentRepair ier;
    Object[] channel;
    Object[] name;
    int state = 0;
    DefaultTableModel datos;
    ActionListener ActionBranch;
    ActionListener ActionFloor;
    
    public SearchEquipment()
    {
        this.af = new AuxiliaryFunctions();
        this.sensql = new SentencesSql();
        initComponents();
        init();
        labelInfo.setVisible(false);
        buttonAcept.setEnabled(true);
        this.ActionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
        this.ActionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboFloor.setEnabled(true);
                    filterTable(); 
                }
            }
        };
        comboBranch.addActionListener(ActionBranch);
        comboFloor.addActionListener(ActionFloor);
//        tableData.addMouseListener(new MouseAdapter() {
//        @Override
//        public void mousePressed(MouseEvent mouseEvent) {
//        JTable table =(JTable) mouseEvent.getSource();
//        Point point = mouseEvent.getPoint();
//        int rowClicked = table.rowAtPoint(point);
//        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
//        {
//            JOptionPane.showMessageDialog(null,"aca sale la ventana."," ",JOptionPane.WARNING_MESSAGE);
//            //fieldCedulon.setText((String) model.getValueAt(rowClicked, 0));
//            //isRowClicked = true;
//            //getValues();
//            //setValues();
//            
//        }
//    }
//});
    }
    
    public SearchEquipment(View view)
    {
        this.af = new AuxiliaryFunctions();
        this.sensql = new SentencesSql();
        this.view = view;
        initComponents();
        init();
        buttonAcept.setVisible(false);
        labelInfo.setVisible(true);
        this.ActionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
        this.ActionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboFloor.setEnabled(true);
                    filterTable(); 
                }
            }
        };
        comboBranch.addActionListener(ActionBranch);
        comboFloor.addActionListener(ActionFloor);
        tableData.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int rowClicked = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
        {
            modifyEquipmentInView((String) datos.getValueAt(rowClicked, 0));
        }
    }
});
    }   
    
    public SearchEquipment(ModifyEquipment modifyEquipment)
    {
        this.af = new AuxiliaryFunctions();
        this.sensql = new SentencesSql();
        this.equipment = modifyEquipment;
        initComponents();
        init();
        labelInfo.setVisible(false);
        buttonAcept.setVisible(false);
        buttonAcept.setEnabled(true);
        this.ActionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
        this.ActionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboFloor.setEnabled(true);
                    filterTable(); 
                }
            }
        };
        comboBranch.addActionListener(ActionBranch);
        comboFloor.addActionListener(ActionFloor);
        tableData.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int rowClicked = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
        {
            modifyEquipment.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
            closeWindows();
        }
    }
        });
    }  
    
    public SearchEquipment(IngressEquipmentRepair ier)
    {
        this.af = new AuxiliaryFunctions();
        this.sensql = new SentencesSql();
        this.ier = ier;
        initComponents();
        init();
        labelInfo.setVisible(false);
        buttonAcept.setVisible(false);
        buttonAcept.setEnabled(true);
        this.ActionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
        this.ActionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboFloor.setEnabled(true);
                    filterTable(); 
                }
            }
        };
        comboBranch.addActionListener(ActionBranch);
        comboFloor.addActionListener(ActionFloor);
        tableData.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int rowClicked = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
        {
            ier.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
            closeWindows();
        }
    }
        });
    }  
    
    private void closeWindows()
    {
        this.dispose();
    }
    private void modifyEquipmentInView(String Id_equipment)
    {
        view.addModifyEquipment(this, Id_equipment);
    }
    private void init()
    {
        tableData.setDefaultEditor(Object.class, null);
        boxFloor.setEnabled(false);
        comboBranch.setEnabled(false);
        comboFloor.setEnabled(false);
        fieldCode.setEnabled(false);
        fieldIp.setEnabled(false);
        completeComboBranch();
        showTable();
    }
    
    private void clean()
    {
        fieldCode.setText("");
        fieldIp.setText("");
    }
    
    public void showTable()
    {
        tableDate = af.getEquipment();
        generateTableData(tableDate);
    }
    
    public void completeComboBranch()
    {
        name = af.combox("sucursal", "sucursal");
        comboBranch.removeAllItems();
        for (Object period1 : name) 
        {
            comboBranch.addItem(period1.toString());
        } 
        String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
        completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
        
    }
    
    private void completeComboFloor(String where)
    {
        Object[] floor;
        String nameColumn = "piso";
        floor = sensql.setFilterCombox(nameColumn, "FROM `area` LEFT JOIN `piso` ON `cod_piso` = `id_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal` where " + where + " ORDER BY `id_piso`");
        comboFloor.removeAllItems();
        for (Object branchs : floor) 
        {
            comboFloor.addItem(branchs.toString());
        }
        
    }
    
    public void generateTableData(Object [][] datostabla)
    {    
        String[] columnas = {"Id Pc", "Sucursal", "Piso", "Sector" ,"Nombre", "Usuario", "Contraseña", "Descripción", "IP Admin","IP Imagen"};
        datos = new DefaultTableModel(datostabla,columnas);
        tableData.setModel(datos);
        tableData.getColumnModel().getColumn(0).setPreferredWidth(45);
        tableData.getColumnModel().getColumn(0).setMaxWidth(50);
        tableData.getColumnModel().getColumn(1).setPreferredWidth(70);
        tableData.getColumnModel().getColumn(1).setMaxWidth(80);
        tableData.getColumnModel().getColumn(2).setPreferredWidth(70);
        tableData.getColumnModel().getColumn(2).setMaxWidth(80);
        tableData.getColumnModel().getColumn(3).setPreferredWidth(60);
        tableData.getColumnModel().getColumn(3).setMaxWidth(110);
        tableData.getColumnModel().getColumn(4).setPreferredWidth(90);
        tableData.getColumnModel().getColumn(4).setMaxWidth(150);
        tableData.getColumnModel().getColumn(5).setPreferredWidth(70);
        tableData.getColumnModel().getColumn(5).setMaxWidth(80);
        tableData.getColumnModel().getColumn(6).setPreferredWidth(70);
        tableData.getColumnModel().getColumn(6).setMaxWidth(80);
        tableData.getColumnModel().getColumn(7).setPreferredWidth(80);
        tableData.getColumnModel().getColumn(7).setMaxWidth(90);
        tableData.getColumnModel().getColumn(8).setPreferredWidth(80);
        tableData.getColumnModel().getColumn(8).setMaxWidth(90);
        tableData.getColumnModel().getColumn(9).setPreferredWidth(80);
        tableData.getColumnModel().getColumn(9).setMaxWidth(90);
    }
    
    public void filterTable()
    {
        boolean[] filter = {boxCode.isSelected(), boxBranch.isSelected(), boxFloor.isSelected(), boxIp.isSelected()};
        String  Code, floor="", branch="", ip;
        Code = fieldCode.getText();
        ip = fieldIp.getText();
        if(comboBranch.getSelectedItem() != null)
        {
            branch = comboBranch.getSelectedItem().toString();
            if(comboFloor.getSelectedItem() != null)
            {
                floor = comboFloor.getSelectedItem().toString(); 
            }
        }        

        tableDate = af.filterEquipment(Code, branch, floor, ip, filter);
        generateTableData(tableDate);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boxBranch = new javax.swing.JCheckBox();
        boxFloor = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        comboBranch = new javax.swing.JComboBox<>();
        buttonAcept = new javax.swing.JButton();
        comboFloor = new javax.swing.JComboBox<>();
        fieldCode = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        boxCode = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        fieldIp = new javax.swing.JTextField();
        boxIp = new javax.swing.JCheckBox();
        labelInfo = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Equipamiento");

        boxBranch.setText("Sucursal");
        boxBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxBranchActionPerformed(evt);
            }
        });

        boxFloor.setText("Piso");
        boxFloor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxFloorActionPerformed(evt);
            }
        });

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBranch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBranchActionPerformed(evt);
            }
        });

        buttonAcept.setText("Imprimir etiqueta");
        buttonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptActionPerformed(evt);
            }
        });

        comboFloor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFloor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFloorActionPerformed(evt);
            }
        });

        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        jLabel13.setText("Filtrar por:");

        boxCode.setText("Codigo:");
        boxCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCodeActionPerformed(evt);
            }
        });

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableData);

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        fieldIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIpActionPerformed(evt);
            }
        });

        boxIp.setText("IP");
        boxIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxIpActionPerformed(evt);
            }
        });

        labelInfo.setText("* Haciendo doble click sobre un elemento puede ampliar detalles del equipo.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxFloor))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIp))
                .addContainerGap(258, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonAcept)
                .addGap(18, 18, 18)
                .addComponent(ButtonExit)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(boxCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(fieldCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(28, 28, 28)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxBranch)
                            .addComponent(boxFloor)
                            .addComponent(boxIp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 366, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAcept)
                            .addComponent(ButtonExit)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelInfo)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jLabel13)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)
                    .addComponent(boxCode)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void boxFloorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxFloorActionPerformed
        if(boxFloor.isSelected())
        {
            comboFloor.setEnabled(true);
            boxIp.setSelected(false);
            boxCode.setSelected(false);
            filterTable();
        }
        else
        {
            boxCode.setEnabled(true);
            boxIp.setEnabled(true);
            comboFloor.setEnabled(false);
            filterTable();
        }
    }//GEN-LAST:event_boxFloorActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void boxCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCodeActionPerformed
        if(boxCode.isSelected())
        {
            fieldCode.setEnabled(true);
            fieldCode.requestFocus();
            boxBranch.setSelected(false);
            boxFloor.setSelected(false);
            boxFloor.setEnabled(false);
            boxIp.setSelected(false);
            comboBranch.setEnabled(false);
            comboFloor.setEnabled(false);
            fieldIp.setEnabled(false);
        }
        else
        {
            clean();
            boxBranch.setEnabled(true);
            boxIp.setEnabled(true);
            fieldCode.setEnabled(false);
            filterTable();
        }
    }//GEN-LAST:event_boxCodeActionPerformed

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        filterTable();
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void comboFloorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFloorActionPerformed

    }//GEN-LAST:event_comboFloorActionPerformed

    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptActionPerformed
        int row = tableData.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada."," ",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            String id_equipment = tableDate[row][0].toString();
            
            String name_ = sensql.getData("nombrePc", "select nombrePc from pc where id_pc='"+id_equipment+"';"); 
            String ipAdmin_ = sensql.getData("ipAdm", "select ipAdm from pc LEFT JOIN `ipAdm` ON `id_ipAdm` = `cod_ipAdm` where id_pc='"+id_equipment+"';");
            String ipImage_ = sensql.getData("ipImag", "select ipImag from pc LEFT JOIN `ipImage` ON `id_ipImag` = `cod_ipImag` where id_pc='"+id_equipment+"';");
            
            PrintLabel printLabel = new PrintLabel(name_, ipAdmin_, ipImage_, id_equipment);
            try
            {
                printLabel.printLabel();
            } catch (IOException ex) 
            {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
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

    private void comboBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBranchActionPerformed
        filterTable();
    }//GEN-LAST:event_comboBranchActionPerformed

    private void boxBranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxBranchActionPerformed
        if(boxBranch.isSelected())
        {
            boxFloor.setEnabled(true);
            fieldIp.setEnabled(false);
            fieldCode.setEnabled(false);
            comboBranch.setEnabled(true);
            boxFloor.setSelected(true);
            comboFloor.setEnabled(true);
            boxIp.setSelected(false);
            boxCode.setSelected(false);
            filterTable();
        }
        else
        {
            boxFloor.setEnabled(false);
            boxFloor.setSelected(false);
            boxCode.setEnabled(true);
            boxIp.setEnabled(true);
            filterTable();
        }
    }//GEN-LAST:event_boxBranchActionPerformed

    private void boxIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxIpActionPerformed
        if(boxIp.isSelected())
        {
            fieldIp.setEnabled(true);
            boxFloor.setSelected(false);
            boxFloor.setEnabled(false);
            boxCode.setSelected(false);
            boxBranch.setSelected(false);
            comboBranch.setEnabled(false);
            comboFloor.setEnabled(false);
            fieldCode.setEnabled(false);
        }
        else
        {
            fieldIp.setEnabled(false);
            boxCode.setEnabled(true);
            boxBranch.setEnabled(true);
            clean();
            filterTable();
        }
        
    }//GEN-LAST:event_boxIpActionPerformed

    private void fieldIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIpActionPerformed
        filterTable();
    }//GEN-LAST:event_fieldIpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxBranch;
    private javax.swing.JCheckBox boxCode;
    private javax.swing.JCheckBox boxFloor;
    private javax.swing.JCheckBox boxIp;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JComboBox<String> comboFloor;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JTextField fieldIp;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
}
