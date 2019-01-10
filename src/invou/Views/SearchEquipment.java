package invou.Views;

import invou.AuxiliaryFunctions;
import invou.EquipmentReportXLS;
import invou.PrintLabel;
import invou.SaveExcelFile;
import invou.SentencesSql;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
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
    private ModifyEquipment modifyEquipment;
    RegisterEquipmentRepair registerEquipmentRepair;
    RegisterNewPrint registerNewPrint;
    ChangeEquipment changeEquipment;
    ChangePrint changePrint;
    PrintReport printReport;
    Object[] channel;
    Object[] name;
    int state = 0, equipment;
    DefaultTableModel datos;
    ActionListener ActionBranch;
    ActionListener ActionFloor;
       
    public SearchEquipment(View view, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        this.sensql = sensql;
        this.view = view;
        state = 0;
        initComponents();
        init();
        buttonAcept.setVisible(false);
        labelInfo.setVisible(true);
    }   
    
    public SearchEquipment(ChangePrint changePrint, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        this.sensql = sensql;
        this.changePrint = changePrint;
        state=1;
        initComponents();
        init();
        setSelecButton();
        buttonGenerate.setVisible(false);
    } 
    
    public SearchEquipment(SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        state = 2;
        this.sensql = sensql;
        initComponents();
        init();
        labelInfo.setVisible(false);
        buttonAcept.setEnabled(true);

    }    
    
    public SearchEquipment(ModifyEquipment modifyEquipment, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);      
        this.modifyEquipment = modifyEquipment;
        this.sensql = sensql;
        state=3; 
        initComponents();
        init();
        setSelecButton();
        buttonGenerate.setVisible(false);
    }  
        
    public SearchEquipment(PrintReport printReport, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        this.printReport = printReport;
        this.sensql = sensql;
        state=4;
        initComponents();
        init();
        setSelecButton();
        buttonGenerate.setVisible(false);        
    }  
    
    public SearchEquipment(RegisterEquipmentRepair registerEquipmentRepair, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);        
        this.registerEquipmentRepair = registerEquipmentRepair;
        this.sensql = sensql;
        state=5;        
        initComponents();
        init();
        setSelecButton();
        buttonGenerate.setVisible(false);
    }    
    
    public SearchEquipment(RegisterNewPrint registerNewPrint, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        this.registerNewPrint = registerNewPrint;
        this.sensql = sensql;
        state=6;
        initComponents();
        init();
        setSelecButton();
        buttonGenerate.setVisible(false);
    }      
    
    public SearchEquipment(ChangeEquipment changeEquipment, int equipment, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        this.sensql = sensql;
        this.equipment=equipment;
        state=7;
        this.changeEquipment = changeEquipment;
        initComponents();
        init();
        setSelecButton();
        buttonGenerate.setVisible(false);
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
        
        this.ActionFloor = (ActionEvent ae) -> {
            filterTable();
        };
        this.ActionBranch = (ActionEvent ae) -> {
            if(comboBranch.getSelectedItem()!= null)
            {
                String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                comboFloor.setEnabled(true);
                filterTable();
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
            
            switch(state)
                {
                case 0:
                    modifyEquipmentInView((String) datos.getValueAt(rowClicked, 0));
                break;
                case 1:
                changePrint.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
                closeWindows();
                break;
                
                case 2:
                String id_equipment = ((String) datos.getValueAt(rowClicked, 0));
                String name_ = sensql.getData("nombrePc", "select nombrePc from pc where id_pc='"+id_equipment+"';"); 
                String ipAdmin_ = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipAdm` where id_pc='"+id_equipment+"';");
                String ipImage_ = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipImag` where id_pc='"+id_equipment+"';");
                PrintLabel printLabel = new PrintLabel(name_, ipAdmin_, ipImage_, id_equipment);
                
                try
                {
                    printLabel.printLabel();
                } 
                catch (IOException ex) {Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);}
                break;
                                case 3:
                modifyEquipment.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
                closeWindows();
                break;
                
                case 4:
                printReport.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
                closeWindows();
                break;
                
                case 5:
                registerEquipmentRepair.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
                closeWindows();
                break;
                
                case 6:
                registerNewPrint.setIdEquipment((String) datos.getValueAt(rowClicked, 0));
                closeWindows();
                break;
                
                case 7:
                    if (equipment==1)
                        changeEquipment.setIdEquipmentFree((String) datos.getValueAt(rowClicked, 0));
                    else
                        changeEquipment.setIdEquipmentBusy((String) datos.getValueAt(rowClicked, 0));
                    closeWindows();
                    break;
                    
                default:
                    break;
            }
        }
    }
        });
            
        
        
        
    }
    
    private void setSelecButton()
    {
        buttonAcept.setLabel("Seleccionar");
        labelInfo.setVisible(false);
        buttonAcept.setEnabled(true);
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
        tableData.getColumnModel().getColumn(0).setMaxWidth(60);
        tableData.getColumnModel().getColumn(1).setPreferredWidth(90);
        tableData.getColumnModel().getColumn(1).setMaxWidth(150);
        tableData.getColumnModel().getColumn(2).setPreferredWidth(40);
        tableData.getColumnModel().getColumn(2).setMaxWidth(60);
        tableData.getColumnModel().getColumn(3).setPreferredWidth(130);
        tableData.getColumnModel().getColumn(3).setMaxWidth(170);
        tableData.getColumnModel().getColumn(4).setPreferredWidth(90);
        tableData.getColumnModel().getColumn(4).setMaxWidth(130);
        tableData.getColumnModel().getColumn(5).setPreferredWidth(60);
        tableData.getColumnModel().getColumn(5).setMaxWidth(120);
        tableData.getColumnModel().getColumn(6).setPreferredWidth(70);
        tableData.getColumnModel().getColumn(6).setMaxWidth(130);
        tableData.getColumnModel().getColumn(7).setPreferredWidth(80);
        tableData.getColumnModel().getColumn(7).setMaxWidth(300);
        tableData.getColumnModel().getColumn(8).setPreferredWidth(85);
        tableData.getColumnModel().getColumn(8).setMaxWidth(110);
        tableData.getColumnModel().getColumn(9).setPreferredWidth(85);
        tableData.getColumnModel().getColumn(9).setMaxWidth(110);
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
        buttonGenerate = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Equipamiento");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-16.png"))); // NOI18N

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

        buttonGenerate.setText("Generar Excel");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

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
                .addContainerGap(394, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonGenerate)
                .addGap(18, 18, 18)
                .addComponent(buttonAcept)
                .addGap(18, 18, 18)
                .addComponent(ButtonExit)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
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
                            .addComponent(ButtonExit)
                            .addComponent(buttonGenerate)))
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addGap(65, 65, 65)))
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
            return;
        }           
            switch(state)
            {
                case 1:
                    changePrint.setIdEquipment(tableDate[row][0].toString());
                    this.dispose();
                    break;
                
                case 2:
                    String id_equipment = tableDate[row][0].toString();
                    String name_ = sensql.getData("nombrePc", "select nombrePc from pc where id_pc='"+id_equipment+"';"); 
                    String ipAdmin_ = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipAdm` where id_pc='"+id_equipment+"';");
                    String ipImage_ = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipImag` where id_pc='"+id_equipment+"';");
                    PrintLabel printLabel = new PrintLabel(name_, ipAdmin_, ipImage_, id_equipment);
                    try
                    {
                        printLabel.printLabel();
                    } 
                    catch (IOException ex) {Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);}
                    break;
                case 3:
                    modifyEquipment.setIdEquipment(tableDate[row][0].toString());
                    this.dispose();
                    break;
                case 4:
                    printReport.setIdEquipment(tableDate[row][0].toString());
                    this.dispose();
                    break;
                case 5:
                    registerEquipmentRepair.setIdEquipment(tableDate[row][0].toString());
                    this.dispose();
                    break;
                case 6:
                    registerNewPrint.setIdEquipment(tableDate[row][0].toString());
                    this.dispose();
                    break;
                case 7:
                    if (equipment==1)
                        changeEquipment.setIdEquipmentFree(tableDate[row][0].toString());
                    else
                        changeEquipment.setIdEquipmentBusy(tableDate[row][0].toString());
                    this.dispose();
                    break;
                default:
                    break;
            }     
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
            comboBranch.setEnabled(false);
            comboFloor.setEnabled(false);
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

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed
        SaveExcelFile file = new SaveExcelFile("Equipamiento al "+af.getActualDateString());
        String[] column = {"Id del equipo", "Sucursal      ","Piso", "Sector       ", "Nombre del equipo", "Usuario    ", "Contraseña   ", "Descripcion                        ", "Ip administrativa", "Ip de imagen      ", "Procesador","Memoria RAM","Almacenamiento","Sistema Operativo", "Fabricante PM", "Modelo Motherboard"};
        
        ArrayList<Object[][]> list = new ArrayList<Object[][]>();

        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '2° SS'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '1° SS'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = 'PB'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '1° P'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '2° P'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '3° P'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '4° P'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '5° P'"));
        list.add(af.getEquipmentOfFloor("sucursal = 'central' and piso = '6° P'"));
        list.add(af.getEquipmentOfFloor("sucursal != 'central'"));
        
        EquipmentReportXLS xls = new EquipmentReportXLS(list, column, "Inventario equipamiento al " + af.getActualDateString());
        
        
        String route = file.getRoute();
        if(route != null)
        {
                xls.generates(route);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_buttonGenerateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxBranch;
    private javax.swing.JCheckBox boxCode;
    private javax.swing.JCheckBox boxFloor;
    private javax.swing.JCheckBox boxIp;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JButton buttonGenerate;
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
