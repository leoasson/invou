/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invou.Views;

import invou.AuxiliaryFunctions;
import invou.PrintLabel;
import invou.ip;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Desktop;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author leoas
 */
public class View extends javax.swing.JFrame {

    AuxiliaryFunctions af = new AuxiliaryFunctions();
    public View() 
    {
        initComponents();
        this.setLocationRelativeTo(null);
        jToolBar2.setFloatable(false);
        
    }

    
    
    public void addModifyEquipment(SearchEquipment se, String Id_equipment)
    {
        ModifyEquipment equipment = new ModifyEquipment(this, se, Id_equipment);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }
    
    public void addSearchEquipment(RegisterNewPrint rnp)
    {
        SearchEquipment equipment = new SearchEquipment(rnp);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }
    
    
    public void addSearchEquipment(ModifyEquipment me)
    {
        SearchEquipment equipment = new SearchEquipment(me);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }
    
    public void addSearchEquipment(PrintReport pr)
    {
        SearchEquipment equipment = new SearchEquipment(pr);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }
    
    public void addSearchEquipment(RegisterEquipmentRepair ier)
    {
        SearchEquipment equipment = new SearchEquipment(ier);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }
    
    public void addSearchEquipment(ChangePrint changePrint)
    {
        SearchEquipment equipment = new SearchEquipment(changePrint);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }
    
    public void addPrinterRepair(String serialNumber)
    {
        PrinterRepairNew repair = new PrinterRepairNew(serialNumber);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = repair.getSize();
        repair.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(repair);
        repair.show();
    }
    
    public void addSearchIp(ReserveIp reserveip) 
    {
        SearchIp searchIp = new SearchIp(reserveip);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = searchIp.getSize();
        searchIp.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(searchIp);
        searchIp.show();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar2 = new javax.swing.JToolBar();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        ButtonEnviarAReparacion = new javax.swing.JButton();
        ButtonRegresoDeReparacion = new javax.swing.JButton();
        ButtonRegresoDeReparacion1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel2 = new javax.swing.JLabel();
        fieldCode = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        printLabeltonnerMenu = new javax.swing.JMenu();
        addTonner = new javax.swing.JMenuItem();
        deleteTonner = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        listTonner = new javax.swing.JMenu();
        entryList = new javax.swing.JMenuItem();
        exitList = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        StockList = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        registryTonner = new javax.swing.JMenuItem();
        updateStock = new javax.swing.JMenuItem();
        updateStock1 = new javax.swing.JMenuItem();
        printerMenu = new javax.swing.JMenu();
        enviarImpresoraAReparacion1 = new javax.swing.JMenuItem();
        regresoDeReparacion = new javax.swing.JMenuItem();
        enviarImpresoraAReparacion = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        listPrinter = new javax.swing.JMenu();
        listRepair = new javax.swing.JMenuItem();
        listPrint = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        registrarImpresora = new javax.swing.JMenuItem();
        newPagesPrinted = new javax.swing.JMenuItem();
        generateReportMenu = new javax.swing.JMenu();
        RegisterNewMenu = new javax.swing.JMenuItem();
        modifyDeleteMenu = new javax.swing.JMenuItem();
        ListEquipmentMenu = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        registerRepairMenu = new javax.swing.JMenuItem();
        ListRepairEquipmentMenu = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        printLabelMenu = new javax.swing.JMenuItem();
        print1 = new javax.swing.JMenuItem();
        monitorMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        equiposMenu = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menu_proveedores = new javax.swing.JMenu();
        listarProveedor = new javax.swing.JMenuItem();
        registrarProveedor = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Invou");
        setBackground(new java.awt.Color(255, 255, 255));

        jToolBar2.setRollover(true);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/addToner26.png"))); // NOI18N
        jButton3.setToolTipText("Ingreso de tonner");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/deleteTonner26.png"))); // NOI18N
        jButton4.setToolTipText("Egreso de tonner");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);
        jToolBar2.add(jSeparator3);

        ButtonEnviarAReparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/changePrint26.png"))); // NOI18N
        ButtonEnviarAReparacion.setToolTipText("Cambiar impresora");
        ButtonEnviarAReparacion.setAlignmentX(0.5F);
        ButtonEnviarAReparacion.setFocusable(false);
        ButtonEnviarAReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEnviarAReparacionActionPerformed(evt);
            }
        });
        jToolBar2.add(ButtonEnviarAReparacion);

        ButtonRegresoDeReparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/printerOk26.png"))); // NOI18N
        ButtonRegresoDeReparacion.setToolTipText("Ingresar impresora reparada");
        ButtonRegresoDeReparacion.setAlignmentX(0.5F);
        ButtonRegresoDeReparacion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonRegresoDeReparacion.setFocusable(false);
        ButtonRegresoDeReparacion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRegresoDeReparacion.setName("gfgbb"); // NOI18N
        ButtonRegresoDeReparacion.setNextFocusableComponent(ButtonEnviarAReparacion);
        ButtonRegresoDeReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresoDeReparacionActionPerformed(evt);
            }
        });
        jToolBar2.add(ButtonRegresoDeReparacion);

        ButtonRegresoDeReparacion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPrint26.png"))); // NOI18N
        ButtonRegresoDeReparacion1.setToolTipText("Buscar Impresoras");
        ButtonRegresoDeReparacion1.setAlignmentX(0.5F);
        ButtonRegresoDeReparacion1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ButtonRegresoDeReparacion1.setFocusable(false);
        ButtonRegresoDeReparacion1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ButtonRegresoDeReparacion1.setName("gfgbb"); // NOI18N
        ButtonRegresoDeReparacion1.setNextFocusableComponent(ButtonEnviarAReparacion);
        ButtonRegresoDeReparacion1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ButtonRegresoDeReparacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegresoDeReparacion1ActionPerformed(evt);
            }
        });
        jToolBar2.add(ButtonRegresoDeReparacion1);
        jToolBar2.add(jSeparator4);

        jButton7.setIcon(new javax.swing.ImageIcon("C:\\Users\\leoas\\Documents\\NetBeansProjects\\InvOu\\src\\invou\\imagenes\\newPc-28.png")); // NOI18N
        jButton7.setToolTipText("Registrar nuevo equipo");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-28.png"))); // NOI18N
        jButton8.setToolTipText("Listar equipamiento");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);
        jToolBar2.add(jSeparator5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/listIp26.png"))); // NOI18N
        jButton6.setToolTipText("Listar direcciones IP");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/monitorAdd.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(jButton5);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDesktopPane1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/logo-oulton (1).png"))); // NOI18N

        jDesktopPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 379, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        fieldCode.setToolTipText("Generar reporte de pc");
        fieldCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodeActionPerformed(evt);
            }
        });

        printLabeltonnerMenu.setText("Tonner");

        addTonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/addToner16.png"))); // NOI18N
        addTonner.setText("Ingresar");
        addTonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTonnerActionPerformed(evt);
            }
        });
        printLabeltonnerMenu.add(addTonner);

        deleteTonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/deleteToner16.png"))); // NOI18N
        deleteTonner.setText("Retirar ");
        deleteTonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteTonnerActionPerformed(evt);
            }
        });
        printLabeltonnerMenu.add(deleteTonner);
        printLabeltonnerMenu.add(jSeparator1);

        listTonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/list16.png"))); // NOI18N
        listTonner.setText("Listar");

        entryList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/downArrow16 .png"))); // NOI18N
        entryList.setText("Ingresos");
        entryList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entryListActionPerformed(evt);
            }
        });
        listTonner.add(entryList);

        exitList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/upArrow16 .png"))); // NOI18N
        exitList.setText("Egresos");
        exitList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitListActionPerformed(evt);
            }
        });
        listTonner.add(exitList);
        listTonner.add(jSeparator2);

        StockList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/stock16.png"))); // NOI18N
        StockList.setText("Stock");
        StockList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockListActionPerformed(evt);
            }
        });
        listTonner.add(StockList);

        printLabeltonnerMenu.add(listTonner);
        printLabeltonnerMenu.add(jSeparator6);

        registryTonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/registryEditor16.png"))); // NOI18N
        registryTonner.setText("Registrar nuevo código");
        registryTonner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registryTonnerActionPerformed(evt);
            }
        });
        printLabeltonnerMenu.add(registryTonner);

        updateStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/updateStock16.png"))); // NOI18N
        updateStock.setText("Actualizar stock");
        updateStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStockActionPerformed(evt);
            }
        });
        printLabeltonnerMenu.add(updateStock);

        updateStock1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/print-16.png"))); // NOI18N
        updateStock1.setText("Imprimir códigos");
        updateStock1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStock1ActionPerformed(evt);
            }
        });
        printLabeltonnerMenu.add(updateStock1);

        jMenuBar1.add(printLabeltonnerMenu);

        printerMenu.setText("Impresoras");

        enviarImpresoraAReparacion1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/changePrint16.png"))); // NOI18N
        enviarImpresoraAReparacion1.setText("Cambio de impresora");
        enviarImpresoraAReparacion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarImpresoraAReparacion1ActionPerformed(evt);
            }
        });
        printerMenu.add(enviarImpresoraAReparacion1);

        regresoDeReparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/printerOk16.png"))); // NOI18N
        regresoDeReparacion.setText("Regreso de reparacion");
        regresoDeReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresoDeReparacionActionPerformed(evt);
            }
        });
        printerMenu.add(regresoDeReparacion);

        enviarImpresoraAReparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/repairPrint16.png"))); // NOI18N
        enviarImpresoraAReparacion.setText("Enviar a reparacion");
        enviarImpresoraAReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarImpresoraAReparacionActionPerformed(evt);
            }
        });
        printerMenu.add(enviarImpresoraAReparacion);
        printerMenu.add(jSeparator8);

        listPrinter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/list16.png"))); // NOI18N
        listPrinter.setText("Listar");

        listRepair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/mantenimiento-16.png"))); // NOI18N
        listRepair.setText("Reparaciones");
        listRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listRepairActionPerformed(evt);
            }
        });
        listPrinter.add(listRepair);

        listPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/print-16.png"))); // NOI18N
        listPrint.setText("Impresoras");
        listPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listPrintActionPerformed(evt);
            }
        });
        listPrinter.add(listPrint);

        printerMenu.add(listPrinter);
        printerMenu.add(jSeparator7);

        registrarImpresora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/registryEditor16.png"))); // NOI18N
        registrarImpresora.setText("Registrar nueva impresora");
        registrarImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarImpresoraActionPerformed(evt);
            }
        });
        printerMenu.add(registrarImpresora);

        newPagesPrinted.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/update16.png"))); // NOI18N
        newPagesPrinted.setText("Actualizar paginas impresas");
        newPagesPrinted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPagesPrintedActionPerformed(evt);
            }
        });
        printerMenu.add(newPagesPrinted);

        jMenuBar1.add(printerMenu);

        generateReportMenu.setText("Equipos");

        RegisterNewMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/newPc-16.png"))); // NOI18N
        RegisterNewMenu.setText("Registrar nuevo");
        RegisterNewMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterNewMenuActionPerformed(evt);
            }
        });
        generateReportMenu.add(RegisterNewMenu);

        modifyDeleteMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/editPc-16.png"))); // NOI18N
        modifyDeleteMenu.setText("Modificar/Borrar");
        modifyDeleteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyDeleteMenuActionPerformed(evt);
            }
        });
        generateReportMenu.add(modifyDeleteMenu);

        ListEquipmentMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/searchPc-16.png"))); // NOI18N
        ListEquipmentMenu.setText("Listar equipamiento");
        ListEquipmentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListEquipmentMenuActionPerformed(evt);
            }
        });
        generateReportMenu.add(ListEquipmentMenu);
        generateReportMenu.add(jSeparator9);

        registerRepairMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/mantenimiento-16.png"))); // NOI18N
        registerRepairMenu.setText("Registrar reparación");
        registerRepairMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerRepairMenuActionPerformed(evt);
            }
        });
        generateReportMenu.add(registerRepairMenu);

        ListRepairEquipmentMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/listRepair16.png"))); // NOI18N
        ListRepairEquipmentMenu.setText("Listar Reparaciones");
        ListRepairEquipmentMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListRepairEquipmentMenuActionPerformed(evt);
            }
        });
        generateReportMenu.add(ListRepairEquipmentMenu);
        generateReportMenu.add(jSeparator10);

        printLabelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/print-16.png"))); // NOI18N
        printLabelMenu.setText("Imprimir etiqueta");
        printLabelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printLabelMenuActionPerformed(evt);
            }
        });
        generateReportMenu.add(printLabelMenu);

        print1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/report-16.png"))); // NOI18N
        print1.setText("Generar reporte");
        print1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print1ActionPerformed(evt);
            }
        });
        generateReportMenu.add(print1);

        jMenuBar1.add(generateReportMenu);

        monitorMenu.setText("Monitores");

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/monitorAdd16 .png"))); // NOI18N
        jMenuItem4.setText("Ingreso de Monitor");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        monitorMenu.add(jMenuItem4);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/monitorDelete16.png"))); // NOI18N
        jMenuItem3.setText("Egreso de Monitor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        monitorMenu.add(jMenuItem3);

        jMenuBar1.add(monitorMenu);

        equiposMenu.setText("IP");

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/listIp16.png"))); // NOI18N
        jMenuItem5.setText("Listar IP");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        equiposMenu.add(jMenuItem5);
        equiposMenu.add(jSeparator12);

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/rangeIp16.png"))); // NOI18N
        jMenuItem6.setText("Registrar rango de ip");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        equiposMenu.add(jMenuItem6);
        equiposMenu.add(jSeparator11);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/reserveIp16.png"))); // NOI18N
        jMenuItem7.setText("Reservar ip");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        equiposMenu.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/liberateIp16.png"))); // NOI18N
        jMenuItem8.setText("Liberar ip reservada");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        equiposMenu.add(jMenuItem8);

        jMenuBar1.add(equiposMenu);

        menu_proveedores.setText("Proveedores");

        listarProveedor.setText("Listar proveedores");
        listarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarProveedorActionPerformed(evt);
            }
        });
        menu_proveedores.add(listarProveedor);

        registrarProveedor.setText("Registrar Proveedor");
        registrarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarProveedorActionPerformed(evt);
            }
        });
        menu_proveedores.add(registrarProveedor);

        jMenuBar1.add(menu_proveedores);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonEnviarAReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEnviarAReparacionActionPerformed
        PrinterRepairNew repair = new PrinterRepairNew();
        jDesktopPane1.add(repair);
        repair.show();
    }//GEN-LAST:event_ButtonEnviarAReparacionActionPerformed

    private void ButtonRegresoDeReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresoDeReparacionActionPerformed
        PrinterRepairReturn repair = new PrinterRepairReturn();
        jDesktopPane1.add(repair);
        repair.show();
    }//GEN-LAST:event_ButtonRegresoDeReparacionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        SearchIp searchIp = new SearchIp();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = searchIp.getSize();
        searchIp.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(searchIp);
        searchIp.show();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void addTonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTonnerActionPerformed
    IngressToner ing = new IngressToner();
    jDesktopPane1.add(ing);
    ing.show();
    }//GEN-LAST:event_addTonnerActionPerformed

    private void deleteTonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteTonnerActionPerformed
    EgressToner egr = new EgressToner();
    jDesktopPane1.add(egr);
    egr.show();
    }//GEN-LAST:event_deleteTonnerActionPerformed

    private void registryTonnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registryTonnerActionPerformed
        RegisterNewToner art = new RegisterNewToner();
        jDesktopPane1.add(art);
        art.show(); 
    }//GEN-LAST:event_registryTonnerActionPerformed

    public void addInPanel()
    {
        RegisterNewToner art = new RegisterNewToner();
        jDesktopPane1.add(art);
        art.show(); 
    }
    
    private void StockListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockListActionPerformed
        SearchStockToner bus = new SearchStockToner();
        bus.show();        
    }//GEN-LAST:event_StockListActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        EgressToner egr = new EgressToner();
        jDesktopPane1.add(egr);
        egr.show();        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        IngressToner ing = new IngressToner();
        jDesktopPane1.add(ing);
        ing.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void updateStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStockActionPerformed
        UpdateStockToner stock = new UpdateStockToner();
        jDesktopPane1.add(stock);
        stock.show(); 
    }//GEN-LAST:event_updateStockActionPerformed

    private void entryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryListActionPerformed
        SearchIncomeToner ingresos = new SearchIncomeToner();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ingresos.getSize();
        ingresos.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ingresos);
        ingresos.show();
    }//GEN-LAST:event_entryListActionPerformed

    private void exitListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitListActionPerformed
        SearchExitsToner egresos = new SearchExitsToner();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = egresos.getSize();
        egresos.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(egresos);
        egresos.show();
    }//GEN-LAST:event_exitListActionPerformed

    private void listarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarProveedorActionPerformed
        InterfazListarProveedores listaProv = new InterfazListarProveedores();
        jDesktopPane1.add(listaProv);
        listaProv.show();
    }//GEN-LAST:event_listarProveedorActionPerformed

    private void registrarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarProveedorActionPerformed
        RegisterNewProvider prov = new RegisterNewProvider();
        jDesktopPane1.add(prov);
        prov.show();
    }//GEN-LAST:event_registrarProveedorActionPerformed

    private void registrarImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarImpresoraActionPerformed
        RegisterNewPrint impresora = new RegisterNewPrint(this);
        jDesktopPane1.add(impresora);
        impresora.show();
    }//GEN-LAST:event_registrarImpresoraActionPerformed

    private void listRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listRepairActionPerformed
        SearchPrinterRepair repairs = new SearchPrinterRepair();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = repairs.getSize();
        repairs.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(repairs);
        repairs.show();
    }//GEN-LAST:event_listRepairActionPerformed

    private void listPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listPrintActionPerformed
        SearchPrinter printers = new SearchPrinter();
        printers.show();
    }//GEN-LAST:event_listPrintActionPerformed

    private void enviarImpresoraAReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarImpresoraAReparacionActionPerformed
        PrinterRepairNew repair = new PrinterRepairNew();
        jDesktopPane1.add(repair);
        repair.show();
    }//GEN-LAST:event_enviarImpresoraAReparacionActionPerformed

    private void regresoDeReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresoDeReparacionActionPerformed
        PrinterRepairReturn repair = new PrinterRepairReturn();
        jDesktopPane1.add(repair);
        repair.show();
    }//GEN-LAST:event_regresoDeReparacionActionPerformed

    private void newPagesPrintedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPagesPrintedActionPerformed
        UpdatePagesPrinted pages = new UpdatePagesPrinted();
        jDesktopPane1.add(pages);
        pages.show();        
    }//GEN-LAST:event_newPagesPrintedActionPerformed

    private void RegisterNewMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterNewMenuActionPerformed
        RegisterNewEquipment equipment = new RegisterNewEquipment(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_RegisterNewMenuActionPerformed

    private void ListEquipmentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListEquipmentMenuActionPerformed
        SearchEquipment equipment = new SearchEquipment(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_ListEquipmentMenuActionPerformed

    private void registerRepairMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerRepairMenuActionPerformed
        RegisterEquipmentRepair equipment = new RegisterEquipmentRepair(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_registerRepairMenuActionPerformed

    private void printLabelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printLabelMenuActionPerformed
        
        SearchEquipment equipment = new SearchEquipment();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_printLabelMenuActionPerformed

    private void modifyDeleteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyDeleteMenuActionPerformed
        ModifyEquipment equipment = new ModifyEquipment(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_modifyDeleteMenuActionPerformed

    private void ListRepairEquipmentMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListRepairEquipmentMenuActionPerformed
        SearchEquipmentRepair equipment = new SearchEquipmentRepair();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_ListRepairEquipmentMenuActionPerformed

    private void print1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print1ActionPerformed
        PrintReport equipment = new PrintReport(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_print1ActionPerformed

    private void fieldCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodeActionPerformed
        String codigo = fieldCode.getText();
        
        if(!af.existIdEquipment(codigo))
        {
            JOptionPane.showMessageDialog(null,"El codigo ingresado no esta registardo en la base de datos");
            fieldCode.requestFocus();
        }
        
        else
        {
           PrintReportView prv = new PrintReportView(codigo);
           prv.show();
           fieldCode.setText("");
        }
    }//GEN-LAST:event_fieldCodeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        RegisterNewEquipment equipment = new RegisterNewEquipment(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        SearchEquipment equipment = new SearchEquipment(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = equipment.getSize();
        equipment.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(equipment);
        equipment.show();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void enviarImpresoraAReparacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarImpresoraAReparacion1ActionPerformed
        ChangePrint changePrint = new ChangePrint(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = changePrint.getSize();
        changePrint.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(changePrint);
        changePrint.show();
    }//GEN-LAST:event_enviarImpresoraAReparacion1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        SearchIp searchIp = new SearchIp();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = searchIp.getSize();
        searchIp.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(searchIp);
        searchIp.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        RegisterNewRangeIp range = new RegisterNewRangeIp();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = range.getSize();
        range.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(range);
        range.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed

        ReserveIp ip = new ReserveIp(this);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ip.getSize();
        ip.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ip);
        ip.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        ReserveIp ip = new ReserveIp(this,1);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = ip.getSize();
        ip.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(ip);
        ip.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void updateStock1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStock1ActionPerformed
        PrintLabelToner toner = new PrintLabelToner();
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension jInternalFrameSize = toner.getSize();
        toner.setLocation((desktopSize.width - jInternalFrameSize.width)/2,(desktopSize.height- jInternalFrameSize.height)/2);
        jDesktopPane1.add(toner);
        toner.show();   
    }//GEN-LAST:event_updateStock1ActionPerformed

    private void ButtonRegresoDeReparacion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegresoDeReparacion1ActionPerformed
        SearchPrinter printers = new SearchPrinter();
        printers.show();
    }//GEN-LAST:event_ButtonRegresoDeReparacion1ActionPerformed

    
    
    
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */

//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new View().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEnviarAReparacion;
    private javax.swing.JButton ButtonRegresoDeReparacion;
    private javax.swing.JButton ButtonRegresoDeReparacion1;
    private javax.swing.JMenuItem ListEquipmentMenu;
    private javax.swing.JMenuItem ListRepairEquipmentMenu;
    private javax.swing.JMenuItem RegisterNewMenu;
    private javax.swing.JMenuItem StockList;
    private javax.swing.JMenuItem addTonner;
    private javax.swing.JMenuItem deleteTonner;
    private javax.swing.JMenuItem entryList;
    private javax.swing.JMenuItem enviarImpresoraAReparacion;
    private javax.swing.JMenuItem enviarImpresoraAReparacion1;
    private javax.swing.JMenu equiposMenu;
    private javax.swing.JMenuItem exitList;
    private javax.swing.JTextField fieldCode;
    private javax.swing.JMenu generateReportMenu;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JToolBar.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenuItem listPrint;
    private javax.swing.JMenu listPrinter;
    private javax.swing.JMenuItem listRepair;
    private javax.swing.JMenu listTonner;
    private javax.swing.JMenuItem listarProveedor;
    private javax.swing.JMenu menu_proveedores;
    private javax.swing.JMenuItem modifyDeleteMenu;
    private javax.swing.JMenu monitorMenu;
    private javax.swing.JMenuItem newPagesPrinted;
    private javax.swing.JMenuItem print1;
    private javax.swing.JMenuItem printLabelMenu;
    private javax.swing.JMenu printLabeltonnerMenu;
    private javax.swing.JMenu printerMenu;
    private javax.swing.JMenuItem registerRepairMenu;
    private javax.swing.JMenuItem registrarImpresora;
    private javax.swing.JMenuItem registrarProveedor;
    private javax.swing.JMenuItem registryTonner;
    private javax.swing.JMenuItem regresoDeReparacion;
    private javax.swing.JMenuItem updateStock;
    private javax.swing.JMenuItem updateStock1;
    // End of variables declaration//GEN-END:variables

}
