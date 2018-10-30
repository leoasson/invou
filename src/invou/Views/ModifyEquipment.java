package invou.Views;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ModifyEquipment extends javax.swing.JInternalFrame {
AuxiliaryFunctions af = new AuxiliaryFunctions();
SentencesSql sensql = new SentencesSql();
String id_equipment;
String name, user, password, ipAdmin, ipImage, description, branch, floor, sector, processor, so, ram, disk, motherboard, modelMotherboard;
String newName, newUser, newPassword, newIpImage, newDescription, newIpAdmin, newBranch, newFloor, newSector, newProcessor, newSo, newRam, newDisk, newMotherboard, newModelMotherboard;
View view = new View();
SearchEquipment searchEquipment;
ActionListener actionMotherboard;
ActionListener actionBranch;
ActionListener actionFloor;

    public ModifyEquipment(View view)
    {
        this.view = view;
        initComponents();  
        completeComboBranch();
        completeComboProcessor();
        completeComboMaker();
        completeComboSo();
        completeComboRam();
        completeComboStorage();
        clean();
        buttonId.setEnabled(true);
        fieldId.setEnabled(true);
        block_UnblockButton(false);
        block_UnblockField(false);
        this.actionMotherboard = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboMotherboarMaker.getSelectedItem()!= null)
                {
                    comboMotherboardModel.setEnabled(true);
                    String idMaker = af.parseMakerMotherboard(comboMotherboarMaker.getSelectedItem().toString());
                    completeComboMotherboardModel("`cod_marca` = '"+idMaker+"'");
                }
            }
        };
        comboMotherboarMaker.addActionListener(actionMotherboard);
        this.actionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboSector.setEnabled(false);
                    comboSector.removeAllItems();
                    comboFloor.setSelectedItem(null);
                    comboFloor.setEnabled(true);
                }
            }
        };
        comboBranch.addActionListener(actionBranch);
        this.actionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboFloor.getSelectedItem()!= null)
                {
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    String idPiso = af.parseFloor(comboFloor.getSelectedItem().toString());
                    completeComboSector("`cod_sucursal` = '"+idBranch+"' and `cod_piso` = '"+ idPiso +"'");
                    comboSector.setEnabled(true);
                }
            }
        };
        comboFloor.addActionListener(actionFloor);
        getValuesOfDatabase(id_equipment);
        setValuesInView();
    } 
    public ModifyEquipment(View view, SearchEquipment searchEquipment, String id_equipment)
    {
        this.id_equipment = id_equipment;
        this.view = view;
        this.searchEquipment = searchEquipment;
        initComponents();  
        buttonId.setEnabled(false);
        fieldId.setEnabled(false);
        fieldId.setText(id_equipment);
        completeComboBranch();
        completeComboProcessor();
        completeComboMaker();
        completeComboSo();
        completeComboRam();
        completeComboStorage();
        clean();               
        this.actionMotherboard = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboMotherboarMaker.getSelectedItem()!= null)
                {
                    comboMotherboardModel.setEnabled(true);
                    String idMaker = af.parseMakerMotherboard(comboMotherboarMaker.getSelectedItem().toString());
                    completeComboMotherboardModel("`cod_marca` = '"+idMaker+"'");
                }
            }
        };
        comboMotherboarMaker.addActionListener(actionMotherboard);
        this.actionBranch = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboBranch.getSelectedItem()!= null)
                {     
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    completeComboFloor("`cod_sucursal` = '"+idBranch+"'");
                    comboSector.setEnabled(false);
                    comboSector.removeAllItems();
                    comboFloor.setSelectedItem(null);
                    comboFloor.setEnabled(true);
                }
            }
        };
        comboBranch.addActionListener(actionBranch);
        this.actionFloor = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                if(comboFloor.getSelectedItem()!= null)
                {
                    String idBranch = af.parseBranch(comboBranch.getSelectedItem().toString());
                    String idPiso = af.parseFloor(comboFloor.getSelectedItem().toString());
                    completeComboSector("`cod_sucursal` = '"+idBranch+"' and `cod_piso` = '"+ idPiso +"'");
                    comboSector.setEnabled(true);
                }
            }
        };
        comboFloor.addActionListener(actionFloor);
        getValuesOfDatabase(id_equipment);
        setValuesInView();
    }         
    private void completeComboBranch()
    {
        Object[] branch_;
        branch_ = af.combox("sucursal", "sucursal");
        comboBranch.removeAllItems();
        for (Object branchs : branch_) 
        {
            comboBranch.addItem(branchs.toString());
        }
    }
    
    private void completeComboFloor(String where)
    {
        Object[] floor_;
        String nameColumn = "piso";
        floor_ = sensql.setFilterCombox(nameColumn, "FROM `area` LEFT JOIN `piso` ON `cod_piso` = `id_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal` where " + where + " ORDER BY `piso`");
        comboFloor.removeAllItems();
        for (Object branchs : floor_) 
        {
            comboFloor.addItem(branchs.toString());
        }
    }
    
    private void completeComboSector(String where)
    {
        Object[] sector_;
        String nameColumn = "area";
        sector_ = sensql.setFilterCombox(nameColumn, "FROM `area` LEFT JOIN `piso` ON `cod_piso` = `id_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal` where " + where + " ORDER BY `area`");
        comboSector.removeAllItems();
        for (Object branchs : sector_) 
        {
            comboSector.addItem(branchs.toString());
        }
    }
    
    private void completeComboMotherboardModel(String where)
    {
        Object[] model;
        model = sensql.setFilterCombox("modelo", "FROM `motherboard` LEFT JOIN `marcamotherboard` ON `cod_marca` = `id_marca` where " + where +" ORDER BY modelo");
        comboMotherboardModel.removeAllItems();
        for (Object branchs : model) 
        {
            comboMotherboardModel.addItem(branchs.toString());
        }
        
    } 
    
    private void completeComboProcessor()
    {
        Object[] processor_;
        processor_ = af.combox("procesador", "procesador");
        comboProcessor.removeAllItems();
        for (Object branchs : processor_) 
        {
            comboProcessor.addItem(branchs.toString());
        }
        comboProcessor.setSelectedItem(null);
    }
    
    private void completeComboMaker()
    {
        Object[] maker;
        maker = af.combox("marcamotherboard ORDER BY fabricante", "fabricante");
        comboMotherboarMaker.removeAllItems();
        for (Object branchs : maker) 
        {
            comboMotherboarMaker.addItem(branchs.toString());
        }
    }
    
    private void completeComboRam()
    {
        Object[] ram_;
        ram_ = af.combox("ram", "memoriaRam");
        comboRam.removeAllItems();
        for (Object branchs : ram_) 
        {
            comboRam.addItem(branchs.toString());
        }
    }
    
    private void completeComboSo()
    {
        Object[] so_;
        so_ = af.combox("so", "so");
        comboSo.removeAllItems();
        for (Object branchs : so_) 
        {
            comboSo.addItem(branchs.toString());
        }
    }
    
    private void completeComboStorage()
    {
        Object[] disc;
        disc = af.combox("disco", "disco");
        comboStorage.removeAllItems();
        for (Object branchs : disc) 
        {
            comboStorage.addItem(branchs.toString());
        }
    }
    
    private void clean()
    {
        fieldName.setText("");
        fieldUser.setText("");
        fieldPassword.setText("");
        fieldAdminIP.setText("");
        fieldImageIP.setText("");
        fieldDescription.setText("");
        fieldName.requestFocus();
        comboProcessor.setSelectedItem(null);
        comboStorage.setSelectedItem(null);
        comboSo.setSelectedItem(null);
        comboRam.setSelectedItem(null);
        comboMotherboardModel.setSelectedItem(null);
        comboMotherboardModel.setEnabled(false);
        comboMotherboarMaker.setSelectedItem(null);
        comboBranch.setSelectedItem(null);
        comboFloor.setSelectedItem(null);
        comboSector.setSelectedItem(null);
        comboFloor.setEnabled(false);
        comboSector.setEnabled(false);
        
    }
    
    private void block_UnblockField(boolean state)
    {
        fieldName.setEnabled(state);
        fieldUser.setEnabled(state);
        fieldPassword.setEnabled(state);
        fieldAdminIP.setEnabled(state);
        fieldImageIP.setEnabled(state);
        fieldDescription.setEnabled(state);
        fieldName.requestFocus();
        comboProcessor.setEnabled(state);
        comboStorage.setEnabled(state);
        comboSo.setEnabled(state);
        comboRam.setEnabled(state);
        comboMotherboardModel.setEnabled(state);
        comboMotherboarMaker.setEnabled(state);
        comboBranch.setEnabled(state);
        comboFloor.setEnabled(state);
        comboSector.setEnabled(state);
    }
    
    private void block_UnblockButton(boolean status)
    {
        saveButton.setEnabled(status);
        deleteButton.setEnabled(status);
    }
    
    
    public void setCode(String id_toner)
    {
        fieldName.setText(id_toner);
    }
    
    
    public void getValuesForCheckChanges()
    {
        newName = fieldName.getText().toUpperCase();
        newUser = fieldUser.getText();
        newPassword = fieldPassword.getText();
        newIpImage = fieldImageIP.getText();
        newDescription = fieldDescription.getText();
        newIpAdmin = fieldAdminIP.getText();
        
        if(comboBranch.getSelectedItem() != null)
        {
            newBranch = comboBranch.getSelectedItem().toString();
        }
        if(comboFloor.getSelectedItem() != null)
        {
            newFloor = comboFloor.getSelectedItem().toString();
        }
        if(comboSector.getSelectedItem() != null)
        {
            newSector = comboSector.getSelectedItem().toString();
        }
        newProcessor = comboProcessor.getSelectedItem().toString();
        newSo = comboSo.getSelectedItem().toString();
        newRam = comboRam.getSelectedItem().toString();
        newDisk = comboStorage.getSelectedItem().toString();
        newMotherboard = comboMotherboarMaker.getSelectedItem().toString();
        if(comboMotherboardModel.getSelectedItem() == null)
        {
            newModelMotherboard = "";
        }
        else
        {
            newModelMotherboard = comboMotherboardModel.getSelectedItem().toString();
        }       
        
    }
    
    public void getValuesOfDatabase(String Id_equipment)
    {
        name = sensql.getData("nombrePc", "select nombrePc from pc where id_pc='"+Id_equipment+"';");
        user =  sensql.getData("usuario", "select usuario from pc where id_pc='"+Id_equipment+"';");
        password = sensql.getData("contraseña", "select contraseña from pc where id_pc='"+Id_equipment+"';"); 
        ipAdmin = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipAdm` where id_pc='"+Id_equipment+"';");
        ipImage = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipImag` where id_pc='"+Id_equipment+"';");
        description = sensql.getData("descripcion", "select descripcion from pc where id_pc='"+Id_equipment+"';");
        String from = "FROM `pc` LEFT JOIN `area` ON `id_area` = `cod_area` LEFT JOIN `piso` ON `cod_piso` = `id_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal` where ";
        branch = sensql.getData("sucursal", "select `sucursal`" + from + "id_pc='"+Id_equipment+"';");
        floor = sensql.getData("piso", "select `piso`" + from + "id_pc='"+Id_equipment+"';");
        sector = sensql.getData("area", "select `area`" + from + "id_pc='"+Id_equipment+"';");
        processor = sensql.getData("procesador", "select `procesador` from pc LEFT JOIN `procesador` ON `id_procesador` = `cod_procesador` where id_pc='"+Id_equipment+"';");
        motherboard = sensql.getData("fabricante", "select `fabricante` from pc LEFT JOIN `motherboard` ON `id_motherboard` = `cod_motherboard` LEFT JOIN `marcamotherboard` ON `id_marca`=`cod_marca` where id_pc='"+Id_equipment+"';");
        modelMotherboard = sensql.getData("modelo", "select `modelo` from pc LEFT JOIN `motherboard` ON `id_motherboard` = `cod_motherboard` LEFT JOIN `marcamotherboard` ON `id_marca`=`cod_marca` where id_pc='"+Id_equipment+"';");
        ram = sensql.getData("memoriaRam", "select `memoriaRam` from `PC` LEFT JOIN `ram` ON `id_ram` = `cod_ram` where id_pc='"+Id_equipment+"';");
        disk = sensql.getData("disco", "select `disco` from `PC` LEFT JOIN `disco` ON `id_disco` = `cod_disco` where id_pc='"+Id_equipment+"';");
        so = sensql.getData("so", "select `so` from `PC` LEFT JOIN `so` ON `id_so` = `cod_so` where id_pc='"+Id_equipment+"';");
        if(ipAdmin == null){ipAdmin="";}
        if(ipImage == null){ipImage="";}
    }
    
    public boolean getValuesOfView()
    {
        newName = fieldName.getText().toUpperCase();
        newUser = fieldUser.getText();
        newPassword = fieldPassword.getText();
        newIpImage = fieldImageIP.getText();
        newDescription = fieldDescription.getText();
        newIpAdmin = fieldAdminIP.getText();
        
        if(newName.equals("") || newUser.equals("") || newPassword.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Debe completar los campos obligatorios correspondiente a la administración", "Mensaje", JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        
        if(af.existNameEquipment(newName)&& !name.equals(newName))
        {
            JOptionPane.showMessageDialog(null, "Ya existe "+ newName +" como nombre de equipo.", "Mensaje", JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        //si la ip administrativa es una nueva ip, la verifica de lo contrario la carga directamente
        if(!newIpAdmin.equals(ipAdmin))
        {
            if(af.existIp(newIpAdmin))
            {
                if(newIpAdmin.equals("")){ipAdmin = "";}
                newIpAdmin = af.parseIp(newIpAdmin);  
            }
            else return false;
        }
        else
        {
            if(newIpAdmin.equals("")){ipAdmin = "";}
            newIpAdmin = af.parseIp(newIpAdmin); 
        }
        
        
        //si la ip de imagen es una nueva ip, la verifica de lo contrario la carga directamente
        if(!newIpImage.equals(ipImage))
        {
            if(af.existIp(newIpImage))
            {
                if(newIpImage.equals("")){newIpImage = "";}
                newIpImage = af.parseIp(newIpImage);  
            }
            else return false;
        }
        else
        {
            if(newIpImage.equals("")){newIpImage = "";}
            newIpImage = af.parseIp(newIpImage); 
        }
        
        
        if(comboBranch.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null, "Debe completar los campos correspondiente a la ubicación", "Mensaje", JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        newSector = af.parseSector(comboSector.getSelectedItem().toString());

        if(comboProcessor.getSelectedItem() == null || comboSo.getSelectedItem() == null || comboRam.getSelectedItem() == null || comboStorage.getSelectedItem() == null)
        {
            JOptionPane.showMessageDialog(null, "Debe completar los campos correspondiente a las caracteristicas del equipo", "Mensaje", JOptionPane.WARNING_MESSAGE); 
            return false;
        }
        newProcessor = af.parseProcessor(comboProcessor.getSelectedItem().toString());
        newSo = af.parseSo(comboSo.getSelectedItem().toString());
        newRam = af.parseRam(comboRam.getSelectedItem().toString());
        newDisk = af.parseDisco(comboStorage.getSelectedItem().toString());

        if(comboMotherboardModel.getSelectedItem() == null)
        {
            newMotherboard = "";
        }
        else
        {
            newMotherboard = af.parseMotherboard(comboMotherboardModel.getSelectedItem().toString());
        }
        return true;
    }
    
        public void setValuesInView()
    {
        fieldName.setText(name);
        fieldUser.setText(user);
        fieldPassword.setText(password);
        fieldAdminIP.setText(ipAdmin);
        fieldImageIP.setText(ipImage);
        fieldDescription.setText(description);
        comboBranch.setSelectedItem(branch);
        comboFloor.setSelectedItem(floor);
        comboSector.setSelectedItem(sector);
        comboProcessor.setSelectedItem(processor);

        if(modelMotherboard == null){comboMotherboarMaker.setSelectedItem(null);}
        else{comboMotherboarMaker.setSelectedItem(motherboard);}
        
        if(modelMotherboard == null){comboMotherboardModel.setSelectedItem(null);}
        else{comboMotherboardModel.setSelectedItem(modelMotherboard);}
        
        comboRam.setSelectedItem(ram);
        comboStorage.setSelectedItem(disk);
        comboSo.setSelectedItem(so);
    }
    
    public void VerifyIfExistChanges()
    {
        if(!name.equals(newName) || !user.equals(newUser) || !password.equals(newPassword) || !ipAdmin.equals(newIpAdmin) || !ipImage.equals(newIpImage) || !description.equals(newDescription)
        || !branch.equals(newBranch) || !floor.equals(newFloor) || !sector.equals(newSector)
        || !processor.equals(newProcessor) || !motherboard.equals(newMotherboard) || !modelMotherboard.equals(newModelMotherboard) || !so.equals(newSo) || !ram.equals(newRam) || !disk.equals(newDisk))
        {
            int jo = JOptionPane.showConfirmDialog(null, "Se registaron modificaciones. \n¿Desea guardar los cambios efectudos?", "Advertencia",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if(jo == 0) 
            {
                modifyEquipment();
                searchEquipment.filterTable();
            }
            else if(jo == 1)
            {
                this.dispose();
            }
        }
        else this.dispose();

    }
    
    private void modifyEquipment()
    {
        if(getValuesOfView())
        {
            
            String data[] = {id_equipment, newName, newUser, newPassword, newIpAdmin, newIpImage, newDescription, newSector, newProcessor, newMotherboard, newRam, newDisk, newSo};
            if(af.modifyEquipment(data))
            { 
                JOptionPane.showMessageDialog(null,"El equipo se modifico correctamente.","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                getValuesOfDatabase(id_equipment);
            }
        }
    }
    public void setIdEquipment(String id)
    {
            fieldId.setText(id);
            id_equipment = fieldId.getText();
            block_UnblockField(true);
            block_UnblockButton(true);
            clean();
            getValuesOfDatabase(id_equipment);
            setValuesInView();
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelCodigo = new javax.swing.JLabel();
        fieldName = new javax.swing.JTextField();
        buttonExit = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        fieldUser = new javax.swing.JTextField();
        labelCantidad = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fieldAdminIP = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        fieldImageIP = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        fieldDescription = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        comboBranch = new javax.swing.JComboBox<>();
        comboFloor = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        comboSector = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        comboProcessor = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        comboMotherboarMaker = new javax.swing.JComboBox<>();
        comboMotherboardModel = new javax.swing.JComboBox<>();
        comboRam = new javax.swing.JComboBox<>();
        comboStorage = new javax.swing.JComboBox<>();
        comboSo = new javax.swing.JComboBox<>();
        deleteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        fieldId = new javax.swing.JTextField();
        buttonId = new javax.swing.JButton();

        setClosable(true);
        setTitle("Detalles equipamiento");

        labelCodigo.setText("Nombre del equipo*");

        fieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNameActionPerformed(evt);
            }
        });

        buttonExit.setText("Salir");
        buttonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExitActionPerformed(evt);
            }
        });

        saveButton.setText("Guardar");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        fieldUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldUserActionPerformed(evt);
            }
        });

        labelCantidad.setText("Usuario*");

        fieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPasswordActionPerformed(evt);
            }
        });

        jLabel13.setText("Contraseña*");

        jLabel14.setText("IP administrativa");

        jLabel15.setText("IP Imagen");

        jLabel16.setText("Administración");

        jLabel17.setText("Descripción");

        fieldDescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDescriptionActionPerformed(evt);
            }
        });

        jLabel19.setText("Sucursal*");

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboFloor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel18.setText("Piso*");

        jLabel20.setText("Sector*");

        comboSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel21.setText("Ubicación");

        jLabel22.setText("Detalles del equipo");

        comboProcessor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setText("Procesador*");

        jLabel24.setText("Marca motherboard");

        jLabel25.setText("Modelo motherboard");

        jLabel26.setText("Almacenamiento*");

        jLabel27.setText("Memoria RAM*");

        jLabel28.setText("S.O*");

        comboMotherboarMaker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboMotherboarMaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMotherboarMakerActionPerformed(evt);
            }
        });

        comboMotherboardModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboRam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboStorage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboSo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        deleteButton.setText("Borrar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Id del Equipo");

        fieldId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdActionPerformed(evt);
            }
        });

        buttonId.setText("Buscar Id");
        buttonId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14)
                                    .addComponent(fieldAdminIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCodigo)
                                            .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCantidad)
                                            .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldImageIP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20)
                                            .addComponent(comboSector, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel23)
                                                .addGap(133, 133, 133)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel26)
                                                    .addComponent(comboStorage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(comboMotherboarMaker, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel24)))
                                            .addComponent(comboProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboSo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel28)
                                                    .addComponent(jLabel25)
                                                    .addComponent(comboMotherboardModel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(deleteButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(saveButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonExit)))
                                .addComponent(jLabel27)))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel19)
                            .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(comboRam, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(buttonId)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonId))
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(labelCantidad)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAdminIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldImageIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBranch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboProcessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMotherboarMaker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMotherboardModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboStorage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonExit)
                    .addComponent(saveButton)
                    .addComponent(deleteButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNameActionPerformed
        fieldUser.requestFocus();
    }//GEN-LAST:event_fieldNameActionPerformed

    private void buttonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExitActionPerformed
        getValuesForCheckChanges();
        VerifyIfExistChanges();
    }//GEN-LAST:event_buttonExitActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        modifyEquipment();
        buttonExit.requestFocus();
        if(searchEquipment != null)
        searchEquipment.filterTable();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void fieldUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldUserActionPerformed
        saveButton.requestFocus();
    }//GEN-LAST:event_fieldUserActionPerformed

    private void fieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPasswordActionPerformed

    private void fieldDescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDescriptionActionPerformed

    private void comboMotherboarMakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMotherboarMakerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboMotherboarMakerActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int jo = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar el equipo: "+ name +" definitivamente?", "Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(jo == 0) 
        {
            if(af.deleteEquipment(id_equipment))
            {
                JOptionPane.showMessageDialog(null, "El equipo fue borrado de la base de datos.\nLas ip asociadas fueron liberadas.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                searchEquipment.filterTable();
                this.dispose();
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void fieldIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdActionPerformed

        if(af.existIdEquipment(fieldId.getText()))
        {
            id_equipment = fieldId.getText();
            block_UnblockField(true);
            block_UnblockButton(true);
            clean();
            getValuesOfDatabase(id_equipment);
            setValuesInView();
        }
        else
        {
            clean();
            block_UnblockField(false);
            block_UnblockButton(false);
            JOptionPane.showMessageDialog(null, "El equipo no existe en la base de datos.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            fieldId.requestFocus();
        }
        
        
        
    }//GEN-LAST:event_fieldIdActionPerformed

    private void buttonIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIdActionPerformed
        view.addSearchEquipment(this);
    }//GEN-LAST:event_buttonIdActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonExit;
    private javax.swing.JButton buttonId;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JComboBox<String> comboFloor;
    private javax.swing.JComboBox<String> comboMotherboarMaker;
    private javax.swing.JComboBox<String> comboMotherboardModel;
    private javax.swing.JComboBox<String> comboProcessor;
    private javax.swing.JComboBox<String> comboRam;
    private javax.swing.JComboBox<String> comboSector;
    private javax.swing.JComboBox<String> comboSo;
    private javax.swing.JComboBox<String> comboStorage;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField fieldAdminIP;
    private javax.swing.JTextField fieldDescription;
    private javax.swing.JTextField fieldId;
    private javax.swing.JTextField fieldImageIP;
    private javax.swing.JTextField fieldName;
    private javax.swing.JTextField fieldPassword;
    private javax.swing.JTextField fieldUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}
