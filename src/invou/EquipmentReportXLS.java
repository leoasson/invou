package invou;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
/**
 *
 * @author decodigo
 */
public class EquipmentReportXLS 
{
    String[] column;
    String title;
    int countFloor=10;
    Workbook workbook = new HSSFWorkbook();
    ArrayList<Object[][]> list = new ArrayList<Object[][]>();
    ArrayList<Sheet> sheets = new ArrayList<Sheet>();
    CellStyle style = workbook.createCellStyle();
    CellStyle style2 = workbook.createCellStyle();
    CellStyle style3 = workbook.createCellStyle();
    CellStyle style4 = workbook.createCellStyle();
    Map<Integer, Object[]> map;

    
    public EquipmentReportXLS(ArrayList<Object[][]> list, String[] column, String title)
    {
        this.column = column;
        this.title = title;
        this.list = list;
        
        //Genero las hojas del excel
        sheets.add(0,workbook.createSheet("2SS"));
        sheets.add(1,workbook.createSheet("1SS"));
        sheets.add(2,workbook.createSheet("PB"));
        sheets.add(3,workbook.createSheet("1P"));
        sheets.add(4,workbook.createSheet("2P"));
        sheets.add(5,workbook.createSheet("3P"));
        sheets.add(6,workbook.createSheet("4P"));
        sheets.add(7,workbook.createSheet("5P"));
        sheets.add(8,workbook.createSheet("6P"));
        sheets.add(9,workbook.createSheet("Sucursales"));
        
        setStylus1();
        setBorderStylus();
        setTitleStylus();
        setTotalStylus();
    }
    
    public void generates(String route) 
    {
        
        for(int i=0;i<countFloor;i++)
        {
            map = new TreeMap<>();
            for(int k=0; k<list.get(i).length; k++)
            {    
                map.put(k, list.get(i)[k]);
            }
            generateHeader(sheets.get(i));
            insertDataInTable(sheets.get(i), map);
        }
        generateDocument(route);

    }
    
    
    private void setStylus1()
    {
        // Indicamos que tendra un fondo azul aqua con patron solido del color indicado
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
    }
    private void setBorderStylus()
    {
        style2.setBorderBottom(CellStyle.BORDER_THIN);
        style2.setBorderTop(CellStyle.BORDER_THIN);
        style2.setBorderRight(CellStyle.BORDER_THIN);
        style2.setBorderLeft(CellStyle.BORDER_THIN);
    }
    
    private void setTitleStylus()
    {
        style4.setFillForegroundColor(IndexedColors.LEMON_CHIFFON.getIndex());
        style4.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style4.setBorderBottom(CellStyle.BORDER_THIN);
        style4.setBorderTop(CellStyle.BORDER_THIN);
        style4.setBorderRight(CellStyle.BORDER_THIN);
        style4.setBorderLeft(CellStyle.BORDER_THIN);
        style4.setAlignment(CellStyle.ALIGN_CENTER);
    }
        
        private void setTotalStylus()
    {
        style3.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style3.setBorderBottom(CellStyle.BORDER_THIN);
        style3.setBorderTop(CellStyle.BORDER_THIN);
        style3.setBorderRight(CellStyle.BORDER_THIN);
        style3.setBorderLeft(CellStyle.BORDER_THIN);
        style3.setAlignment(CellStyle.ALIGN_CENTER);
    }
    
    
    private void generateHeader(Sheet sheet)
    {    
        //cramos el titulo del archivo
        Row fila = sheet.createRow(0);
        
        for(int i = 0; i < column.length;i++)
        {
            Cell celd = fila.createCell(i);
            celd.setCellStyle(style4);

            if(i == 0)
            {
                celd.setCellValue(title);
            }
        }
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0,0,0,column.length - 1);
        sheet.addMergedRegion(cellRangeAddress);

        
        //Creamos los nombre de las columnas
        Row fila2 = sheet.createRow(1); 

        
        for(int i = 0; i < column.length; i++) 
        {
            Cell cell2 = fila2.createCell(i);
            cell2.setCellStyle(style); 
            cell2.setCellValue(column[i]);
            sheet.autoSizeColumn(i);
        }
    }
    
    private void insertDataInTable(Sheet sheet, Map<Integer, Object[]> map_)
    {
        Set keyset = map_.keySet();
        int numeroRenglon = 2;
        for (Object key : keyset)
        {
            Row row = sheet.createRow(numeroRenglon++);
            Object[] arregloObjetos = map_.get(key);
            int numeroCelda = 0;
            for (Object obj : arregloObjetos) {
                Cell cell = row.createCell(numeroCelda++);      
                
                if((String) obj != null)
                {
                        
                        cell.setCellValue((String) obj);
                        cell.setCellStyle(style2);
                        sheet.autoSizeColumn(numeroCelda);

                }
                else
                {
                    cell.setCellValue("");
                    cell.setCellStyle(style2);
                    sheet.autoSizeColumn(numeroCelda);
                }
            }
        }
        insertTotal(numeroRenglon,sheet);     
    }
    
    private void insertTotal(int celda, Sheet sheet_)
    {
        Row fila = sheet_.createRow(celda);
        for(int i = 0; i < 3; i++)
        {
            Cell celd = fila.createCell(i);
            celd.setCellStyle(style3);
            if(i == 0)
            {
                celd.setCellValue("Total equipos");
            }
            else if (i == 2)
            {
                celd.setCellValue(celda-2);
//                celd.setCellType(Cell.CELL_TYPE_FORMULA);
//                String strFormula = "COUNT(B3:B"+celda+")";
//                celd.setCellFormula(strFormula);
            }
        }
       CellRangeAddress cellRangeAddress = new CellRangeAddress(celda,celda,0,1);
       sheet_.addMergedRegion(cellRangeAddress);
    }
//    
//    
//    
//    private void insertTotalForPayments(int celda)
//    {    
//        Row fila = sheet.createRow(celda);
//        for(int i = 0; i < column.length; i++)
//        {
//            Cell celd = fila.createCell(i);
//            celd.setCellStyle(style3);
//            if(i == 0)
//            {
//                celd.setCellValue("Total");
//            }
//            else if (i == column.length-1)
//            {
//                celd.setCellType(Cell.CELL_TYPE_FORMULA);
//                String strFormula = "SUM(H2:H"+celda+")";
//                celd.setCellFormula(strFormula);
//            }
//        }
//        CellRangeAddress cellRangeAddress = new CellRangeAddress(celda,celda,0,column.length-2);
//        sheet.addMergedRegion(cellRangeAddress);
//    }
    
    private void generateDocument(String route)
    {
        try 
        {
            try (FileOutputStream out = new FileOutputStream(new File(route))) {
                workbook.write(out);
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"No se pudo guardar el archivo. Asegurese que no este abierto."," ",JOptionPane.WARNING_MESSAGE);
        }
    }
      
    
    private boolean VerifyIsIntegger(String value)
    {
        try
        {
            Double.valueOf(value);  
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
}