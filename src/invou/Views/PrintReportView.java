package invou.Views;

import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author leoasson
 */
public class PrintReportView extends javax.swing.JFrame implements Printable {

String id_equipment;
String name, user, password, ipAdmin, ipImage, description, branch, floor, sector, processor, so, ram, disk, motherboard,date_;
public boolean top;
PrinterJob gap = PrinterJob.getPrinterJob();
AuxiliaryFunctions af; 
SentencesSql sensql;


public PrintReportView(String id_equipment, SentencesSql sensql)
{
    af= new AuxiliaryFunctions(sensql);
    this.id_equipment =id_equipment;
    this.sensql = sensql;
    initComponents();
    this.setLocationRelativeTo(null);
    this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/invou/imagenes/print-16.png")));
    getValues();
    insertValuesInCedulon();
    blockButton();
}

private void blockButton() 
{
        fieldDate.setEnabled(false);
        fieldName.setEditable(false);
        fieldUser.setEditable(false);
        fieldPassword.setEditable(false);
        fieldAdminIp.setEditable(false);
        fieldImageIp.setEditable(false);
        fieldDetail.setEditable(false);
        fieldBranch.setEditable(false);
        fieldFloor.setEditable(false);
        fieldSector.setEditable(false);
        fieldProcessor.setEditable(false);
        fieldMotherboard.setEditable(false);
        fieldRam.setEditable(false);
        fieldStorage.setEditable(false);
        fieldSO.setEditable(false);
}
private void getValues()
{
        java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date_ = String.valueOf(sdf.format(Date));
    
        name = sensql.getData("nombrePc", "select nombrePc from pc where id_pc='"+id_equipment+"';");
        user =  sensql.getData("usuario", "select usuario from pc where id_pc='"+id_equipment+"';");
        password = sensql.getData("contraseña", "select contraseña from pc where id_pc='"+id_equipment+"';"); 
        ipAdmin = sensql.getData("ipAdm", "select ipAdm from pc LEFT JOIN `ipAdm` ON `id_ipAdm` = `cod_ipAdm` where id_pc='"+id_equipment+"';");
        ipImage = sensql.getData("ipImag", "select ipImag from pc LEFT JOIN `ipImage` ON `id_ipImag` = `cod_ipImag` where id_pc='"+id_equipment+"';");
        description = sensql.getData("descripcion", "select descripcion from pc where id_pc='"+id_equipment+"';");
        String from = "FROM `pc` LEFT JOIN `area` ON `id_area` = `cod_area` LEFT JOIN `piso` ON `cod_piso` = `id_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal` where ";
        branch = sensql.getData("sucursal", "select `sucursal`" + from + "id_pc='"+id_equipment+"';");
        floor = sensql.getData("piso", "select `piso`" + from + "id_pc='"+id_equipment+"';");
        sector = sensql.getData("area", "select `area`" + from + "id_pc='"+id_equipment+"';");
        processor = sensql.getData("procesador", "select `procesador` from pc LEFT JOIN `procesador` ON `id_procesador` = `cod_procesador` where id_pc='"+id_equipment+"';");
        motherboard = sensql.getData("fabricante", "select `fabricante` from pc LEFT JOIN `motherboard` ON `id_motherboard` = `cod_motherboard` LEFT JOIN `marcamotherboard` ON `id_marca`=`cod_marca` where id_pc='"+id_equipment+"';") +" "+ sensql.getData("modelo", "select `modelo` from pc LEFT JOIN `motherboard` ON `id_motherboard` = `cod_motherboard` LEFT JOIN `marcamotherboard` ON `id_marca`=`cod_marca` where id_pc='"+id_equipment+"';");
        ram = sensql.getData("memoriaRam", "select `memoriaRam` from `PC` LEFT JOIN `ram` ON `id_ram` = `cod_ram` where id_pc='"+id_equipment+"';");
        disk = sensql.getData("disco", "select `disco` from `PC` LEFT JOIN `disco` ON `id_disco` = `cod_disco` where id_pc='"+id_equipment+"';");
        so = sensql.getData("so", "select `so` from `PC` LEFT JOIN `so` ON `id_so` = `cod_so` where id_pc='"+id_equipment+"';");
        if(ipAdmin == null){ipAdmin="";}
        if(ipImage == null){ipImage="";}
        getRepairDetails();
   }
    
    public void insertValuesInCedulon()
    {
        fieldDate.setText(date_); 
        fieldName.setText(name);
        fieldUser.setText(user);
        fieldPassword.setText(password);
        fieldAdminIp.setText(ipAdmin);
        fieldImageIp.setText(ipImage); 
        fieldDetail.setText(description);
        fieldBranch.setText(branch);
        fieldFloor.setText(floor);
        fieldSector.setText(sector);
        fieldProcessor.setText(processor);
        fieldMotherboard.setText(motherboard);
        fieldRam.setText(ram);
        fieldStorage.setText(disk);
        fieldSO.setText(so);
        getRepairDetails();
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        cedulon1 = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();
        labelAdminIp = new javax.swing.JLabel();
        labelDetail = new javax.swing.JLabel();
        fieldAdminIp = new javax.swing.JTextField();
        fieldUser = new javax.swing.JTextField();
        fieldImageIp = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        fieldDate = new javax.swing.JTextField();
        fieldDetail = new javax.swing.JTextField();
        labelImageIp = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JTextField();
        fieldName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        LabelUbacation = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelBranch = new javax.swing.JLabel();
        labelFloor = new javax.swing.JLabel();
        labelArea = new javax.swing.JLabel();
        fieldBranch = new javax.swing.JTextField();
        fieldFloor = new javax.swing.JTextField();
        fieldSector = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        labelProcessor = new javax.swing.JLabel();
        labelMotherboard = new javax.swing.JLabel();
        labelRam = new javax.swing.JLabel();
        labelStorage = new javax.swing.JLabel();
        labelSO = new javax.swing.JLabel();
        fieldProcessor = new javax.swing.JTextField();
        fieldStorage = new javax.swing.JTextField();
        fieldSO = new javax.swing.JTextField();
        fieldMotherboard = new javax.swing.JTextField();
        fieldRam = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        labelRepair = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        buttonPrint = new javax.swing.JButton();
        buttonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cedulon1.setBackground(new java.awt.Color(255, 255, 255));

        labelName.setText("Nombre:");

        labelPassword.setText("Pasword:");

        labelUser.setText("Usuario:");

        labelAdminIp.setText("Ip administrativa:");

        labelDetail.setText("Detalles:");

        fieldAdminIp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldAdminIp.setOpaque(false);
        fieldAdminIp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAdminIpActionPerformed(evt);
            }
        });

        fieldUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldUser.setOpaque(false);

        fieldImageIp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldImageIp.setOpaque(false);

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Reporte Completo de equipamiento ");

        fieldDate.setForeground(new java.awt.Color(255, 255, 255));
        fieldDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldDate.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldDate.setDragEnabled(true);
        fieldDate.setOpaque(false);
        fieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDateActionPerformed(evt);
            }
        });

        fieldDetail.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldDetail.setOpaque(false);
        fieldDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDetailActionPerformed(evt);
            }
        });

        labelImageIp.setText("Ip de imagen: ");

        fieldPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldPassword.setOpaque(false);
        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });

        fieldName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        fieldName.setDragEnabled(true);
        fieldName.setOpaque(false);

        jLabel1.setText("Detalles  administrativos");

        LabelUbacation.setText("Ubicación");

        labelBranch.setText("Sucursal:");

        labelFloor.setText("Piso:");

        labelArea.setText("Sector:");

        fieldBranch.setBorder(null);
        fieldBranch.setOpaque(false);

        fieldFloor.setBorder(null);
        fieldFloor.setOpaque(false);

        fieldSector.setBorder(null);
        fieldSector.setOpaque(false);

        jLabel5.setText("Detalles de Hardware");

        labelProcessor.setText("Procesador:");

        labelMotherboard.setText("Motherboard: ");

        labelRam.setText("Memoria Ram:");

        labelStorage.setText("Almacenamiento:");

        labelSO.setText("Sistema operativo:");

        fieldProcessor.setBorder(null);
        fieldProcessor.setOpaque(false);

        fieldStorage.setBorder(null);
        fieldStorage.setOpaque(false);

        fieldSO.setBorder(null);
        fieldSO.setOpaque(false);
        fieldSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldSOActionPerformed(evt);
            }
        });

        fieldMotherboard.setBorder(null);
        fieldMotherboard.setOpaque(false);
        fieldMotherboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMotherboardActionPerformed(evt);
            }
        });

        fieldRam.setBorder(null);
        fieldRam.setOpaque(false);
        fieldRam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRamActionPerformed(evt);
            }
        });

        jTextPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(jTextPane1);

        labelRepair.setText("Reparaciones");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/logoOulton.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout cedulon1Layout = new javax.swing.GroupLayout(cedulon1);
        cedulon1.setLayout(cedulon1Layout);
        cedulon1Layout.setHorizontalGroup(
            cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(labelAdminIp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldAdminIp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelImageIp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldImageIp, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelRepair)
                            .addComponent(jLabel5)
                            .addComponent(LabelUbacation)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(cedulon1Layout.createSequentialGroup()
                                    .addComponent(labelBranch)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(labelFloor)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)
                                    .addComponent(labelArea)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fieldSector, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cedulon1Layout.createSequentialGroup()
                                    .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(cedulon1Layout.createSequentialGroup()
                                            .addComponent(labelRam)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldRam))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cedulon1Layout.createSequentialGroup()
                                            .addComponent(labelMotherboard)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldMotherboard))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cedulon1Layout.createSequentialGroup()
                                            .addComponent(labelProcessor)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(98, 98, 98)
                                    .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(cedulon1Layout.createSequentialGroup()
                                            .addComponent(labelSO)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldSO))
                                        .addGroup(cedulon1Layout.createSequentialGroup()
                                            .addComponent(labelStorage)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(fieldStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(labelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cedulon1Layout.createSequentialGroup()
                                .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jLabel31)))
                .addGap(0, 97, Short.MAX_VALUE))
        );
        cedulon1Layout.setVerticalGroup(
            cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cedulon1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAdminIp)
                    .addComponent(fieldAdminIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUser)
                            .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPassword)
                            .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(cedulon1Layout.createSequentialGroup()
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelImageIp)
                            .addComponent(fieldImageIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDetail)
                            .addComponent(fieldDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(LabelUbacation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBranch)
                    .addComponent(labelFloor)
                    .addComponent(labelArea)
                    .addComponent(fieldBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProcessor)
                    .addComponent(labelStorage)
                    .addComponent(fieldProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMotherboard)
                    .addComponent(labelSO)
                    .addComponent(fieldSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldMotherboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cedulon1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRam)
                    .addComponent(fieldRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(labelRepair)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(cedulon1);

        buttonPrint.setText("Imprimir");
        buttonPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(679, Short.MAX_VALUE)
                .addComponent(buttonPrint)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExit)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrint)
                    .addComponent(buttonExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintActionPerformed
 try
        {
            PrinterJob _gap = PrinterJob.getPrinterJob();
            _gap.setPrintable(this);
            boolean _top = _gap.printDialog();
            if(_top)
            {
            _gap.print();
            }
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,"ERROR DE PROGRAMA", "Error\n" + e, JOptionPane.INFORMATION_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPrintActionPerformed

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

    private void fieldDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDetailActionPerformed

    private void fieldDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDateActionPerformed

    private void fieldAdminIpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAdminIpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAdminIpActionPerformed

    private void fieldMotherboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMotherboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldMotherboardActionPerformed

    private void fieldRamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldRamActionPerformed

    private void fieldSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldSOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldSOActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
    this.dispose();
    }//GEN-LAST:event_buttonExitActionPerformed

    @Override
    public int print(Graphics graf, PageFormat pagfor, int index) throws PrinterException
    {
        if(index>0)
        {
        return NO_SUCH_PAGE;
        }
        Graphics2D hub = (Graphics2D) graf;
        hub.translate(pagfor.getImageableX()-10, pagfor.getImageableY());
        hub.scale(0.8,0.8);
        
        cedulon1.printAll(graf);
        return PAGE_EXISTS;
    }
    
 public void imprimir(){                                            
    try
        {
            gap.print();
        }
        catch(PrinterException e)
        {
            JOptionPane.showMessageDialog(null,"ERROR DE PROGRAMA", "Error\n" + e, JOptionPane.INFORMATION_MESSAGE);
        }        // TODO add your handling code here:
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelUbacation;
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonPrint;
    private javax.swing.JPanel cedulon1;
    private javax.swing.JTextField fieldAdminIp;
    private javax.swing.JTextField fieldBranch;
    private javax.swing.JTextField fieldDate;
    private javax.swing.JTextField fieldDetail;
    private javax.swing.JTextField fieldFloor;
    private javax.swing.JTextField fieldImageIp;
    private javax.swing.JTextField fieldMotherboard;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPassword;
    private javax.swing.JTextField fieldProcessor;
    private javax.swing.JTextField fieldRam;
    private javax.swing.JTextField fieldSO;
    private javax.swing.JTextField fieldSector;
    private javax.swing.JTextField fieldStorage;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel labelAdminIp;
    private javax.swing.JLabel labelArea;
    private javax.swing.JLabel labelBranch;
    private javax.swing.JLabel labelDetail;
    private javax.swing.JLabel labelFloor;
    private javax.swing.JLabel labelImageIp;
    private javax.swing.JLabel labelMotherboard;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelProcessor;
    private javax.swing.JLabel labelRam;
    private javax.swing.JLabel labelRepair;
    private javax.swing.JLabel labelSO;
    private javax.swing.JLabel labelStorage;
    private javax.swing.JLabel labelUser;
    // End of variables declaration//GEN-END:variables

    private void getRepairDetails() 
    {
        String data = "";
        Object[][] repair = af.getPcsRepairFilter(id_equipment);
        for (int i = 0; i < repair.length;i++) 
        {
            String date = (String) repair[i][2];
            String detail = (String) repair[i][3];
            data = data + date +"       "+detail +"\n";
        }
        jTextPane1.setText(data);
    }

    
}
