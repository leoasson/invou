package invou.Views;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.text.ParseException;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ModifyPrinterRepair extends javax.swing.JInternalFrame {
AuxiliaryFunctions af;
SentencesSql sensql;
View view;
Object[] proveedor;
String id_repair;
String DBserial, DBmodel, DBissue, DBdetailRapair, DBdateExit, DBdateReturn, DBprovider; 
String NewSerial, NewModel, NewIssue, NewDetailRapair, NewDateExit, NewDateReturn, NewProvider;
SearchPrinterRepair searchPrinterRepair;
    /**
     * Creates new form Interfaz_Proveedor
     * @param view
     * @param search
     * @param sensql
     * @param id_repair
     */
    public ModifyPrinterRepair(View view, SearchPrinterRepair search, String id_repair, SentencesSql sensql) 
    {
        searchPrinterRepair = search;
        this.sensql = sensql;
        this.view = view;
        this.id_repair = id_repair;
        af = new AuxiliaryFunctions(sensql);
        initComponents();
        clean();
        proveedor = af.combox("proveedor ORDER BY nombre_comercial ","nombre_comercial");
        comboProvider.removeAllItems();
        for (Object proveedor1 : proveedor)
        {
            comboProvider.addItem(proveedor1);
        }
        comboProvider.setEditable(true);
        AutoCompleteDecorator.decorate(comboProvider);
        getValuesOfDatabase(id_repair);
        setValuesInView();
        serial.setEnabled(false);
        model.setEnabled(false);
    }
    
    public void setCode(String id_toner)
    {
        serial.setText(id_toner);
    }
       
    private void clean()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       dateExit.setDate(Date);
       serial.setText("");
       model.setText("");
       comboProvider.setName("");
    }
    private void getValuesOfDatabase(String id_repair) 
    {
        DBserial = sensql.getData("cod_impresora", "select cod_impresora from reparacion where id_reparacion='"+id_repair+"';");
        DBmodel =  sensql.getData("modelo", "select modelo from reparacion LEFT JOIN impresora ON `cod_impresora` = `id_sn` LEFT JOIN modeloimpresora ON `id_pn` = `cod_pn` where `id_reparacion`='"+id_repair+"';");
        DBissue = sensql.getData("falla", "select falla from reparacion where id_reparacion='"+id_repair+"';"); 
        DBdetailRapair = sensql.getData("detallereparacion", "select detallereparacion from reparacion where id_reparacion='"+id_repair+"';"); 
        DBdateExit = sensql.getData("fechaSalida", "select fechaSalida from reparacion where id_reparacion='"+id_repair+"';");
        DBdateReturn = sensql.getData("fechaRetorno", "select fechaRetorno from reparacion where id_reparacion='"+id_repair+"';");
        DBprovider =sensql.getData("nombre_comercial", "select nombre_comercial from reparacion LEFT JOIN proveedor ON cod_proveedor = id_proveedor where id_reparacion='"+id_repair+"';");
      
        if(DBprovider == null){DBprovider = "";}
        if(DBdateReturn == null){DBdateReturn="";}
        if(DBdetailRapair == null){DBdetailRapair = "";}
        if(DBissue == null){DBissue = "";}
    }
    
    private boolean getValuesOfView() 
    {
        if(dateExit.getDate() == null)
        {
            JOptionPane.showMessageDialog(null,"Debe ingresar una fecha válida.", "Advertencia",JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if(dateReturn.getDate() == null)
        {
            NewDateReturn="";
        }
        else
        {
            NewDateReturn = af.getStringToDate(dateReturn.getDate());
        }
        
        NewSerial = serial.getText();
        NewModel = model.getText();
        NewIssue = issue.getText();
        NewDetailRapair =  detailRepair.getText();
        NewDateExit = af.getStringToDate(dateExit.getDate());
        NewProvider = comboProvider.getSelectedItem().toString();
        if(NewProvider == null){NewProvider = "";}

        
        
        System.out.println("oldProvider: "+DBprovider+"  "+"new provider:" + NewProvider );
        System.out.println("oldDateReturn: "+DBdateReturn+"  "+"new date retrn:" + NewDateReturn);
        System.out.println("date issue: "+DBissue+"  "+"new date issue:" + NewIssue);
        System.out.println("detail repair: "+DBdetailRapair+"  "+"new detail repair:" + NewDetailRapair);
        System.out.println("db date exit:" + DBdateExit+"  "+"new date exit:" + NewDateExit);
        return true;
    }
    
    private void setValuesInView()
    {
        serial.setText(DBserial);
        model.setText(DBmodel);
        issue.setText(DBissue);
        detailRepair.setText(DBdetailRapair);
        dateExit.setDate(af.getDateToString(DBdateExit));
        
        if(!DBdateReturn.equals(""))
            dateReturn.setDate(af.getDateToString(DBdateReturn));
        
        if(comboProvider == null){comboProvider.setSelectedItem(null);}
        else{comboProvider.setSelectedItem(DBprovider);}
        
    }
    
    private void searchChanges()
    {
        if(!DBissue.equals(NewIssue) || !DBdetailRapair.equals(NewDetailRapair) || !DBdateExit.equals(NewDateExit) || !DBdateReturn.equals(NewDateReturn) || !DBprovider.equals(NewProvider))
        {
            int jo = JOptionPane.showConfirmDialog(null, "Se registaron modificaciones. \n¿Desea guardar los cambios efectudos?", "Advertencia",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
            if(jo == 0) 
            {
                modifyRepair();
            }
            else if(jo == 1)
            {
                this.dispose();
            }
        }
        else this.dispose();    
    }
    //TODO: Caundo intento modificar una reparacion dejandole la fecha vacia en la fecha de retorno hay error. seguir probandolo.
    private void modifyRepair()
    {
        if(!getValuesOfView())return;
        if(!NewProvider.equals("")){NewProvider = af.parseProvider(NewProvider);}
        else{NewProvider = "0";}
        boolean hasAReturn = !NewDateReturn.equals("");
       // String data[] = {id_repair, NewSerial, NewDateExit, NewDateReturn, NewProvider, NewIssue, NewDetailRapair};
            
        if(hasAReturn == true)
        {
            String data[] = {id_repair, NewSerial, NewDateExit, NewDateReturn, NewProvider, NewIssue, NewDetailRapair};
            if(af.modifyPrinterRepair(data))
            { 
                JOptionPane.showMessageDialog(null,"La modificación se realizó correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                getValuesOfDatabase(id_repair);
                searchPrinterRepair.filterTable();
                this.dispose();
                
            }
        }
        else
        {
            String data[] = {id_repair, NewSerial, NewDateExit, NewProvider, NewIssue, NewDetailRapair};
            if(af.modifyPrinterRepairWithOutDateReturn(data))
            { 
                JOptionPane.showMessageDialog(null,"La modificación se realizó correctamente","Mensaje",JOptionPane.INFORMATION_MESSAGE);
                getValuesOfDatabase(id_repair);
                searchPrinterRepair.filterTable();
                this.dispose();
            }
        }
    }
    private void deleteRepair()
    {
        if(af.deletePrinterRepair(id_repair))
        {
            JOptionPane.showMessageDialog(null,"La reparación se borró con éxito","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            searchPrinterRepair.filterTable();
            this.dispose();
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelSerial = new javax.swing.JLabel();
        serial = new javax.swing.JTextField();
        LabelProvider = new javax.swing.JLabel();
        ButtonSalir = new javax.swing.JButton();
        ButtonDelet = new javax.swing.JButton();
        buttonModify = new javax.swing.JButton();
        model = new javax.swing.JTextField();
        labelModel = new javax.swing.JLabel();
        LabelDateExit = new javax.swing.JLabel();
        comboProvider = new javax.swing.JComboBox();
        dateExit = new com.toedter.calendar.JDateChooser();
        issue = new javax.swing.JTextField();
        detailRepair = new javax.swing.JTextField();
        LabelDateCameBack = new javax.swing.JLabel();
        LabelIssue = new javax.swing.JLabel();
        LabeldetailRepair = new javax.swing.JLabel();
        dateReturn = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Modificar reparación");
        setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/invou/imagenes/print-16.png"))); // NOI18N

        labelSerial.setText("Numero de serie");

        serial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serialActionPerformed(evt);
            }
        });

        LabelProvider.setText("Proveedor");

        ButtonSalir.setText("Salir");
        ButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalirActionPerformed(evt);
            }
        });

        ButtonDelet.setText("Borrar");
        ButtonDelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDeletActionPerformed(evt);
            }
        });

        buttonModify.setText("Modificar");
        buttonModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModifyActionPerformed(evt);
            }
        });

        model.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelActionPerformed(evt);
            }
        });

        labelModel.setText("Modelo");

        LabelDateExit.setText("Fecha de retiro");

        comboProvider.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProviderActionPerformed(evt);
            }
        });

        issue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issueActionPerformed(evt);
            }
        });

        detailRepair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailRepairActionPerformed(evt);
            }
        });

        LabelDateCameBack.setText("Fecha de regreso");

        LabelIssue.setText("Falla detectada");

        LabeldetailRepair.setText("Detalle reparación");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonModify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonDelet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSalir)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(issue, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LabelDateExit)
                                .addComponent(serial)
                                .addComponent(dateExit, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                .addComponent(LabelProvider)
                                .addComponent(LabelIssue))
                            .addComponent(labelSerial))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabeldetailRepair)
                                .addContainerGap(98, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(dateReturn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(model, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(detailRepair, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelModel))
                                        .addComponent(LabelDateCameBack)))
                                .addGap(0, 25, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboProvider, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelModel)
                    .addComponent(labelSerial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDateExit)
                    .addComponent(LabelDateCameBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateExit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelIssue)
                    .addComponent(LabeldetailRepair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(issue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailRepair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(LabelProvider)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModify)
                    .addComponent(ButtonDelet)
                    .addComponent(ButtonSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void serialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serialActionPerformed
        model.requestFocus();
             
    }//GEN-LAST:event_serialActionPerformed

    private void ButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalirActionPerformed
        getValuesOfView();
        searchChanges();
    }//GEN-LAST:event_ButtonSalirActionPerformed
    
    private void buttonModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModifyActionPerformed
        modifyRepair();
    }//GEN-LAST:event_buttonModifyActionPerformed

    private void ButtonDeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDeletActionPerformed
        
        int jo = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar la reparación "+ id_repair +"definitivamente?", "Advertencia",JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(jo == 0) 
        {
            deleteRepair();
        }
        
        
    }//GEN-LAST:event_ButtonDeletActionPerformed

    private void modelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelActionPerformed
        buttonModify.requestFocus();
    }//GEN-LAST:event_modelActionPerformed

    private void comboProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProviderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProviderActionPerformed

    private void issueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issueActionPerformed

    private void detailRepairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailRepairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailRepairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelet;
    private javax.swing.JButton ButtonSalir;
    private javax.swing.JLabel LabelDateCameBack;
    private javax.swing.JLabel LabelDateExit;
    private javax.swing.JLabel LabelIssue;
    private javax.swing.JLabel LabelProvider;
    private javax.swing.JLabel LabeldetailRepair;
    private javax.swing.JButton buttonModify;
    private javax.swing.JComboBox comboProvider;
    private com.toedter.calendar.JDateChooser dateExit;
    private com.toedter.calendar.JDateChooser dateReturn;
    private javax.swing.JTextField detailRepair;
    private javax.swing.JTextField issue;
    private javax.swing.JLabel labelModel;
    private javax.swing.JLabel labelSerial;
    private javax.swing.JTextField model;
    private javax.swing.JTextField serial;
    // End of variables declaration//GEN-END:variables

}
