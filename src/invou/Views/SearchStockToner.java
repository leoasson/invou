package invou.Views;

import invou.AuxiliaryFunctions;
import invou.SentencesSql;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Normalizer.Form;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author leoasson
 */
public final class SearchStockToner extends javax.swing.JFrame {
    //SentencesSql sensql;
    AuxiliaryFunctions af;
    private Object[][] tableDate; 
    DefaultTableModel datos;
    Object[] model;
    int state=0;
    EgressToner et; 
    IngressToner it; 
    PrintLabelToner plt; 
    UpdateStockToner ust;
    ActionListener ActionModel;
            
    public SearchStockToner(SentencesSql sensql)
    {
        af =new AuxiliaryFunctions(sensql);
        initComponents();
        init();
        buttonAcept.setEnabled(false);
        this.ActionModel = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
               filterTable(); 
            }
        };
        comboModel.addActionListener(ActionModel);
    }
    
    public SearchStockToner(EgressToner et, SentencesSql sensql)
    {
        af =new AuxiliaryFunctions(sensql);
        state = 1;
        initComponents();
        init();
        this.et = et;
        setTitle("Seleccionar codigo de toner");
    }
    
    
    public SearchStockToner(IngressToner it, SentencesSql sensql)
    {
        af =new AuxiliaryFunctions(sensql);
        state = 2;
        this.it = it;
        initComponents();
        init();
        setTitle("Seleccionar codigo de toner");
    }
    
    public SearchStockToner(PrintLabelToner plt, SentencesSql sensql)
    {
        af = new AuxiliaryFunctions(sensql);
        state = 3;
        this.plt = plt;
        initComponents();
        init();
        setTitle("Seleccionar codigo de toner");
    }
    
    public SearchStockToner(UpdateStockToner ust, SentencesSql sensql)
    {
        af =new AuxiliaryFunctions(sensql);
        state = 4;
        this.ust = ust;
        initComponents();
        init();
        setTitle("Seleccionar codigo de toner");
    }
    
    
    public void init()
    {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/invou/imagenes/stock16.png")));
        this.setLocationRelativeTo(null);
        comboModel.setEnabled(false);
        completeComboModel();
        showTable();
        jTable1.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent mouseEvent) {
        JTable table =(JTable) mouseEvent.getSource();
        Point point = mouseEvent.getPoint();
        int rowClicked = table.rowAtPoint(point);
        if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) 
        {
            switch(state)
            {
                case 1:
                        et.setCode((String) datos.getValueAt(rowClicked, 0));
                        closeWindows();
                        break;       
                case 3:
                        plt.setCode((String) datos.getValueAt(rowClicked, 0));
                        closeWindows();
                        break; 
                case 4:
                        ust.setCode((String) datos.getValueAt(rowClicked, 0));
                        closeWindows();
                        break;                         
                        
                default:
                        it.setCode((String) datos.getValueAt(rowClicked, 0));
                        closeWindows();
                        break;
            }
        }
    }
        });
    }
    
    
    private void closeWindows()
    {
        this.dispose();
    }
    public void filterTable()
    {
            if(boxModel.isSelected())
        {
            tableDate = af.filterStockToner(comboModel.getSelectedItem().toString());
            generateTableData(tableDate);
            
        }
    }
    
    public void showTable()
    {
        tableDate = af.getStockToner();
        generateTableData(tableDate);
    }
    
    public void completeComboModel()
    {
        model = af.combox("tonner", "modelo");
        comboModel.removeAllItems();
        for (Object models : model) 
        {
            comboModel.addItem(models.toString());
        }
        comboModel.setEditable(true);
        AutoCompleteDecorator.decorate(comboModel);
    }
    
    public void generateTableData(Object [][] datostabla)
    {   
        String[] columnas = {"Codigo_articulo","modelo", "Descripcion", "Impresoras", "Stock"};
        datos = new DefaultTableModel(tableDate,columnas);
        jTable1.setModel(datos);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(90);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(160);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(200);
        //jTable1.getColumnModel().getColumn(3).setMaxWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(90);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        boxModel = new javax.swing.JCheckBox();
        comboModel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonExit = new javax.swing.JButton();
        buttonAcept = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar Stock de toner");

        jLabel1.setText("Filtrar por:");

        boxModel.setText("Modelo");
        boxModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxModelActionPerformed(evt);
            }
        });

        comboModel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboModelActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        ButtonExit.setText("Salir");
        ButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExitActionPerformed(evt);
            }
        });

        buttonAcept.setText("Aceptar");
        buttonAcept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonAcept)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonExit))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboModel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxModel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(boxModel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonExit)
                    .addComponent(buttonAcept))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boxModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxModelActionPerformed
        if(boxModel.isSelected()){ 
            comboModel.setEnabled(true);
            filterTable();
        }
        else
        {
            comboModel.setEnabled(false);
            showTable();
            filterTable();
        }
    }//GEN-LAST:event_boxModelActionPerformed

    private void ButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_ButtonExitActionPerformed

    private void buttonAceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAceptActionPerformed
        int row = jTable1.getSelectedRow();
        if(row < 0)
        {
            JOptionPane.showMessageDialog(null,"Seleccione la fila deseada."," ",JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            switch(state)
            {
                case 1:
                        et.setCode(tableDate[row][0].toString());
                        this.dispose();
                        break;       
                case 3:
                        plt.setCode(tableDate[row][0].toString());
                        this.dispose();
                        break; 
                case 4:
                        ust.setCode(tableDate[row][0].toString());
                        this.dispose();
                        break; 
                default:
                        it.setCode(tableDate[row][0].toString());
                        this.dispose();
                        break;
            }

        }      
    }//GEN-LAST:event_buttonAceptActionPerformed

    private void comboModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboModelActionPerformed

    }//GEN-LAST:event_comboModelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonExit;
    private javax.swing.JCheckBox boxModel;
    private javax.swing.JButton buttonAcept;
    private javax.swing.JComboBox<String> comboModel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
