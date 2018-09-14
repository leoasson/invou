package invou;

import static java.lang.Math.abs;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

public class AuxiliaryFunctions 
{ 
    SentencesSql sensql;
    String fecha = getActualDateString();
    
    public AuxiliaryFunctions()
    {
        sensql = new SentencesSql();
    }
    
    public boolean isValidNumber(String number)
    {
        if(number.equals("")){return false;}
        int value;
        try
        {
            value = Integer.valueOf(number);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return value >= 0;  
    }
    
    public boolean registerNewToner(String id_articulo, String modelo, String descripcion, int stock)
    {               
        String datos[] = {id_articulo, modelo, descripcion, Integer.toString(stock)};           
        return sensql.insertRow(datos, "insert into tonner(id_tonner, modelo, descripcion, stock) values(?,?,?,?)");
    }
    
    public boolean registerNewPrint(String id_sn, String cod_pn, String cod_pc, String estado)
    {
        String datos[] = {id_sn,cod_pn, cod_pc, estado};
        return sensql.insertRow(datos, "insert into `impresora`(`id_sn`, `cod_pn`, `cod_pc`, `estado` ) values(?,?,?,?)");
    }
    
    public boolean ingressToner(String cod_articulo, String cod_proveedor,String detalle, String fecha, String cantidad)
    {
        String datos[] = {cod_articulo, cod_proveedor,detalle, fecha, cantidad};
        return sensql.insertRow(datos, "insert into `ingresotonner`(`cod_tonner`, `cod_proveedor`, `detalle`, `fecha`, `cantidad`) values(?,?,?,?,?)") && updateStockConBusqueda(cod_articulo);
    }
    
    public boolean ingressNewEquipmentRepair(String code, String fecha, String detail)
    {
        String datos[] = {code, fecha, detail};
        return sensql.insertRow(datos, "insert into `reparacionpc`(`cod_pc`, `fecha`, `detalle`) values(?,?,?)");
    }
    
    public boolean ingressNewEquipment(String data[])
    {
        return sensql.insertRow(data, "insert into `pc`(`nombrePc`, `usuario`, `contraseña`, `cod_ipAdm`, `cod_ipImag`, `descripcion`,`cod_area`, `cod_procesador`, `cod_motherboard`, `cod_ram`, `cod_disco`, `cod_so`) values(?,?,?,?,?,?,?,?,?,?,?,?)");
    }
        
    public boolean ingressPrintRepair (String dateOut,String code, String failure)
    {
        String datos[] = {dateOut, code, failure};
        return sensql.insertRow(datos, "insert into `reparacion`(`fechaSalida`, `cod_impresora`, `falla`) values(?,?,?)");
    }
    
    public boolean ingressPagesPrinted (String code,String date, String quantity)
    {
        String datos[] = {code, quantity, date};
        if(sensql.insertRow(datos, "insert into `impresiones`(`cod_sn`, `cantidad`, `fecha`) values(?,?,?)"))
        {
            String id = sensql.getUltimateID("impresiones", "id_impresion", "cod_sn = '"+ code +"';");
            System.out.println(id);
            if(isValidNumber(id))
            {
                return sensql.modifiedRow("impresora", "cod_impresion", id, "id_sn = '"+ code +"'");
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
       
    public boolean egressToner(String cod_articulo, String detalle, String fecha, String cantidad)
    {
        String datos[] = {cod_articulo,detalle, fecha, cantidad};
        return sensql.insertRow(datos, "insert into `egresotonner`(`cod_tonner`, `detalle`, `fecha`, `cantidad`) values(?,?,?,?)") && updateStockConBusqueda(cod_articulo);
    }
    
    public String getActualDateString()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       return String.valueOf(sdf.format(Date));
    }
    
    public Date getActualDate()
    {
       java.sql.Date Date = new java.sql.Date(System.currentTimeMillis());
       return Date;
    }
    
    public String getDateToString (Date date)
    {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
             try
             {
                return String.valueOf(sdf.format(date));
             }
             catch(Exception e)
             {return "empty";}            
    }
    
    public Object[][] getStockToner()
    {
        String[] columnas={"id_tonner", "modelo", "descripcion","stock"};
        Object[][] datos = sensql.GetTable(columnas, "from tonner",";");
        return datos;
    }

    public Object [][] getIngressToner()
    {
    String[] columnas= {"id_ingresoTonner", "cod_tonner","modelo", "detalle","nombre_comercial","fecha", "cantidad"};
    Object [][] datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and id_tonner=cod_tonner");
    return datos;
    }
    
    public Object [][] getEgressToner()
    {
    String[] columnas= {"id_egresoTonner","cod_tonner","modelo","detalle","fecha","cantidad"};
    Object [][] datos = sensql.GetTable(columnas, "FROM `egresotonner`,`tonner`", "WHERE cod_tonner=id_tonner");
    return datos;
    }
    
    public Object [][] getPrinters()
    {
        String[] columnas= {"id_sn", "cod_pn","modelo","sucursal", "piso", "area", "nombrePC","cantidad","fecha", "estado"};
        Object [][] datos = sensql.GetTable(columnas, "FROM `impresora` LEFT JOIN `modeloimpresora` ON `cod_pn` = `id_pn` LEFT JOIN `impresiones` ON `cod_impresion` = `id_impresion` LEFT JOIN `pc` on `cod_pc` = `id_pc` LEFT JOIN `area` ON `id_area` = `cod_area` LEFT JOIN `piso` ON `id_piso` = `cod_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal`", "ORDER BY `modelo`;");
        return datos;
    }
    
    public Object [][] getEquipment()
    {
        String[] columnas= {"result.id_pc", "sucursal", "piso", "area" ,"nombrePc","usuario", "contraseña", "descripcion","ipadmin","ip"};
        Object [][] datos = sensql.GetTable(columnas, "FROM (SELECT `id_pc`,`sucursal`,`piso`,`area`,`nombrePc`,`usuario`,`contraseña`,`descripcion`,`ip` as ipadmin,`cod_ipImag` FROM `pc` LEFT JOIN `area` ON `id_area`=`cod_area` LEFT JOIN `piso` ON `id_piso`=`cod_piso` LEFT JOIN `sucursal` ON `id_sucursal`=`cod_sucursal` LEFT JOIN `ip` ON `id_ip`=`cod_ipAdm`) as `result` LEFT JOIN ip ON `id_ip`=`cod_ipImag`", "ORDER BY area, nombrePC;");
        return datos;
    }
    
    public Object [][] getPrintersRepair()
    {
        String[] columnas= {"id_reparacion","cod_impresora","modelo","fechaSalida","fechaRetorno","falla","detalleReparacion"};
        Object [][] datos = sensql.GetTable(columnas, "FROM `reparacion` LEFT JOIN `impresora` on `cod_impresora` = `id_sn` LEFT JOIN `modeloImpresora` ON `cod_pn` = `id_pn`", "ORDER BY `id_reparacion` DESC;");
        return datos;
    }
    
    public String getIdPrinterRepair(String code)
    {
        return sensql.getData("id_reparacion", "select id_reparacion from reparacion where cod_impresora ='"+code+"' and fechaRetorno IS NULL;");
    }

    public Object [][] getPcsRepair()
    {
        String[] columnas= {"id_reparacion","cod_pc","nombrePC", "area","fecha","detalle"};
        Object [][] datos = sensql.GetTable(columnas, "FROM `reparacionPc` LEFT JOIN `pc` on `cod_pc` = `id_pc` LEFT JOIN `area` ON `cod_area` = `id_area`", "ORDER BY `fecha` DESC;");
        return datos;
    }
    
    public Object [][] getPcsRepairFilter(String cod_pc)
    {
        String[] columnas= {"id_reparacion","cod_pc","fecha","detalle"};
        Object [][] datos = sensql.GetTable(columnas, "FROM `reparacionPc` WHERE cod_pc = '" +cod_pc +"'", "ORDER BY `fecha` DESC;");
        return datos;
    }
    
    public Object[][] filterPcRepair (String code, int month, int year, boolean[] filter)
    {
        String[] columnas= {"id_reparacion","cod_pc","nombrePC", "area","fecha","detalle"};
        Object [][] datos = getPcsRepair();
        String select="FROM `reparacionPc` LEFT JOIN `pc` on `cod_pc` = `id_pc` LEFT JOIN `area` ON `cod_area` = `id_area`";
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                datos = getPcsRepair();
                return datos;
                case "[false, false, true]":
                datos = sensql.GetTable(columnas, select, "WHERE YEAR(fecha) = '"+year+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[false, true, true]":
                datos = sensql.GetTable(columnas, select, "WHERE YEAR(fecha) = '"+year+"' and MONTH(fechaSalida) = '"+month+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[true, false, false]":
                datos = sensql.GetTable(columnas, select, "WHERE `cod_pc`='"+code+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[true, false, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `cod_pc`='"+code+"' and YEAR(fecha) = '"+year+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[true, true, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `cod_pc`='"+code+"' and YEAR(fecha) = '"+year+"' and MONTH(fecha) = '"+month+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                default:
                return datos;
            }
    }
    
    public Object[][] filterPrinterRepair (String code, int month, int year, boolean[] filter)
    {
        String[] columnas= {"id_reparacion","cod_impresora","modelo","fechaSalida","fechaRetorno","falla","detalleReparacion"};
        Object [][] datos = getPrintersRepair();
        String select="FROM `reparacion` LEFT JOIN `impresora` on `cod_impresora` = `id_sn` LEFT JOIN `modeloImpresora` ON `cod_pn` = `id_pn`";
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                datos = getPrintersRepair();
                return datos;
                case "[false, false, true]":
                datos = sensql.GetTable(columnas, select, "WHERE YEAR(fechaSalida) = '"+year+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[false, true, true]":
                datos = sensql.GetTable(columnas, select, "WHERE YEAR(fechaSalida) = '"+year+"' and MONTH(fechaSalida) = '"+month+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[true, false, false]":
                datos = sensql.GetTable(columnas, select, "WHERE `cod_impresora`='"+code+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[true, false, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `cod_impresora`='"+code+"' and YEAR(fechaSalida) = '"+year+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                case "[true, true, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `cod_impresora`='"+code+"' and YEAR(fechaSalida) = '"+year+"' and MONTH(fechaSalida) = '"+month+"' ORDER BY `id_reparacion` DESC;");
                return datos;
                default:
                return datos;
            }
    
    }
    public Object[][] filterEquipment(String code, String branch, String floor, String ip, boolean[] filter)
    {
        String[] columnas= {"id_pc", "sucursal", "piso", "area" ,"nombrePc","usuario", "contraseña", "descripcion","ipadmin","ip"};
        Object[][] data = getEquipment();
        String select = "FROM (SELECT `id_pc`,`sucursal`,`piso`,`area`,`nombrePc`,`usuario`,`contraseña`,`descripcion`,`ip` as ipadmin,`cod_ipImag` FROM `pc` LEFT JOIN `area` ON `id_area`=`cod_area` LEFT JOIN `piso` ON `id_piso`=`cod_piso` LEFT JOIN `sucursal` ON `id_sucursal`=`cod_sucursal` LEFT JOIN `ip` ON `id_ip`=`cod_ipAdm`) as `result` LEFT JOIN ip ON `id_ip`=`cod_ipImag`";
        switch(Arrays.toString(filter))
            {
                case "[false, false, false, false]":
                    return data;
                case "[true, false, false, false]":
                    data = sensql.GetTable(columnas, select, "WHERE `id_pc`='"+code+"';");
                    return data;
                case "[false, true, true, false]":
                    data = sensql.GetTable(columnas, select, "WHERE `sucursal`='"+branch+"' and `piso`='"+floor+"' order by area, nombrePC;");
                    return data;      
                case "[false, true, false, false]":
                    data = sensql.GetTable(columnas, select, "WHERE `sucursal`='"+branch+"';");
                    return data;
                case "[false, false, false, true]":
                    data = sensql.GetTable(columnas, select, "WHERE `ipAdmin` LIKE '%"+ip+"%' or `ip` LIKE '%"+ip+"%';");
                    return data;
                default:
                return data;
        }
    }
    
    public Object[][] filterPrint(String code, String model, String state, boolean[] filter)
    {
        String[] columnas= {"id_sn", "cod_pn","modelo","sucursal", "piso", "area", "nombrePC","cantidad","fecha", "estado"};
        Object [][] datos = getPrinters();
        String select="FROM `impresora` LEFT JOIN `modeloimpresora` ON `cod_pn` = `id_pn` LEFT JOIN `impresiones` ON `cod_impresion` = `id_impresion` LEFT JOIN `pc` on `cod_pc` = `id_pc` LEFT JOIN `area` ON `id_area` = `cod_area` LEFT JOIN `piso` ON `id_piso` = `cod_piso` LEFT JOIN `sucursal` ON `id_sucursal` = `cod_sucursal`";
        switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                datos = getPrinters();
                return datos;
                case "[false, false, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `estado`='"+state+"';");
                return datos;
                case "[false, true, false]":
                datos = sensql.GetTable(columnas, select, "WHERE `modelo`='"+model+"';");
                return datos;
                case "[false, true, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `estado`='"+state+"' and `modelo`='"+model+"';");
                return datos;
                case "[true, false, false]":
                datos = sensql.GetTable(columnas, select, "WHERE `id_sn`='"+code+"';");
                return datos;
                case "[true, false, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `id_sn`='"+code+"' and `estado`='"+state+"';");
                return datos;
                case "[true, true, false]":
                datos = sensql.GetTable(columnas, select, "WHERE `id_sn`='"+code+"' and `modelo`='"+model+"';");
                return datos;
                case "[true, true, true]":
                datos = sensql.GetTable(columnas, select, "WHERE `id_sn`='"+code+"' and `modelo`='"+model+"' and `estado`='"+state+"';");
                return datos;
                default:
                return datos;
            }
    }
    
    public Object[][] filterStockToner(String model)
    {
    String[] columnas={"id_tonner", "modelo", "descripcion","stock"};
    Object[][] datos = sensql.GetTable(columnas, "from `tonner`","WHERE modelo = '"+model+"';");
    return datos;
    }
    
    public Object[][] filterToner(String tabla, String modelo, int ano, int mes, boolean [] filter)
    {
        if(tabla.equals("ingresotonner"))
        {
            String[] columnas= {"id_ingresoTonner", "cod_tonner","modelo", "detalle","nombre_comercial","fecha", "cantidad"};
            Object [][] datos = sensql.GetTable(columnas,"FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner;");
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`" , "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner;");
                return datos;
                case "[false, false, true]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner and YEAR(fecha) = '" +ano+ "';");
                return datos;
                case "[false, true, false]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner AND MONTH(fecha) = '"+mes+"';");
                return datos;
                case "[false, true, true]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner AND MONTH(fecha) = '"+mes+"' AND YEAR(fecha) = '"+ano+"';");
                return datos;
                case "[true, false, false]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner AND modelo = '" +modelo+ "';");
                return datos;
                case "[true, false, true]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner AND modelo = '" +modelo+ "' AND YEAR(fecha) = '"+ano+"';");
                return datos;
                case "[true, true, false]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner AND modelo = '" +modelo+ "' AND MONTH(fecha) = '"+mes+"';");
                return datos;
                case "[true, true, true]":
                datos = sensql.GetTable(columnas, "FROM `ingresotonner`,`proveedor`,`tonner`", "WHERE id_proveedor=cod_proveedor and cod_tonner=id_tonner AND modelo = '" +modelo+ "' AND MONTH(fecha) = '"+mes+"' AND YEAR(fecha) = '"+ano+"';");
                return datos;
                default:
                return datos;
            }
        }
        else
        {
            String[] columnas= {"id_egresoTonner", "cod_tonner", "modelo", "detalle","fecha", "cantidad"};
            Object [][] datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner;");
            switch(Arrays.toString(filter))
            {
                case "[false, false, false]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner;");
                return datos;
                case "[false, false, true]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner and YEAR(fecha) = '" +ano+ "';");
                return datos; 
                case "[false, true, false]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner AND MONTH(fecha) = '"+mes+"';");
                return datos;
                case "[false, true, true]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner AND MONTH(fecha) = '"+mes+"' AND YEAR(fecha) = '"+ano+"';");
                return datos; 
                case "[true, false, false]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner AND modelo = '" +modelo+ "';");
                return datos;
                case "[true, false, true]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner AND modelo = '" +modelo+ "' AND YEAR(fecha) = '"+ano+"';");
                return datos;
                case "[true, true, false]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner AND modelo = '" +modelo+ "' AND MONTH(fecha) = '"+mes+"';");
                return datos;
                case "[true, true, true]":
                datos = sensql.GetTable(columnas, "from `egresotonner`,`tonner`", "where cod_tonner=id_tonner AND modelo = '" +modelo+ "' AND MONTH(fecha) = '"+mes+"' AND YEAR(fecha) = '"+ano+"';");
                return datos;
                default:
                return datos;
            }
        }   
    }
    
    public boolean isIpAvailable(String id_ip)
    {
        return sensql.existencias(id_ip, " from ip where id_ip='"+id_ip+"' and estado='LIBRE';");
    }
        
    public boolean existProvider( String id_prov)
    {
        return sensql.existencias(id_prov, " from proveedor where No_documento='"+id_prov+"';");
    }
    
    public boolean existPrinterCode(String code)
    {
        return sensql.existencias(code, " from impresora where id_sn = '"+code+"';");
    }
    
    public boolean existPrintModel(String model)
    {
        return sensql.existencias(model, " from modeloImpresora where id_pn = '"+model+"';");
    }
    
    public boolean existTonerCode( String code)
    {
        return sensql.existencias(code, " from tonner where id_tonner='"+code+"';");
    }
   
    public boolean existNameEquipment(String name)
    {
        return sensql.existencias(name, " from pc where nombrePc='"+name+"';");
    }
    
    public boolean existIdEquipment(String id)
    {
        return sensql.existencias(id, " from pc where id_pc='"+id+"';");
    }
    
    public boolean existEquipmentWithPrint(String id)
    {
        return sensql.existencias(id, " from impresora LEFT JOIN pc ON id_pc = cod_pc where id_pc='"+id+"';");
    }
    
    public boolean existPrintCode(String id, String state)
    {
        return sensql.existencias(id, " from impresora where id_sn='"+id+"' and estado = '"+state+"';");
    }
         
    
    public boolean existIp(String ip)
    {
        if(ip.equals("")){return true;}
        if(sensql.existencias(ip, " from ip where ip='"+ip+"';"))
        {
            if(isIpAvailable(parseIp(ip)))
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "La ip: "+ ip +", ya esta siendo usada por otro equipo.", "Advertencia", JOptionPane.WARNING_MESSAGE); 
                return false;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "La ip: "+ ip +", no existe en la base de datos.", "Advertencia", JOptionPane.WARNING_MESSAGE); 
            return false;
        }
           
    }
    
    public String parsePrint(String id_equipment)
    {
        return sensql.getData("id_sn", "select id_sn from impresora LEFT JOIN pc ON id_pc = cod_pc where id_pc='"+id_equipment+"';");

    }
    
    public String parseIp(String ip)
    {
        return sensql.getData("id_ip", "select id_ip from ip where ip='"+ip+"';");
    }
    
     /* Mapea el el nombre comercial del proveedor con el id correspondiente.
     */
     public String parseProvider(String nombre_comercial)
     {
         return sensql.getData("id_proveedor", "select id_proveedor from proveedor where nombre_comercial='"+nombre_comercial+"';");
     }
     
     public String parseBranch(String branch)
     {
         if(branch == null)
         {
            return null;
         }
         else
         {
            return sensql.getData("id_sucursal", "select id_sucursal from sucursal where sucursal='"+branch+"';");
         }
     }
     
     public String parseFloor(String floor)
     {
         if(floor == null)
         {
            return null;
         }
         else
         {
            return sensql.getData("id_piso", "select id_piso from piso where piso='"+floor+"';");
         }
     }
     
      public String parseSector(String sector)
     {
            return sensql.getData("id_area", "select id_area from area where area='"+sector+"';");
     }
      
     public String parseProcessor(String processor)
     {
            return sensql.getData("id_procesador", "select id_procesador from procesador where procesador='"+processor+"';");
     }
     
     public String parseMotherboard(String model)
     {
            return sensql.getData("id_motherboard", "select id_motherboard from motherboard where modelo='"+model+"';");
     }
     
     public String parseRam(String ram)
     {
            return sensql.getData("id_ram", "select id_ram from ram where memoriaRam='"+ram+"';");
     }
     
     public String parseDisco(String disco)
     {
            return sensql.getData("id_disco", "select id_disco from disco where disco='"+disco+"';");
     }
     
     public String parseSo(String so)
     {
            return sensql.getData("id_so", "select id_so from so where so='"+so+"';");
     }
     
     
     public String parseMakerMotherboard(String maker)
     {
            return sensql.getData("id_marca", "select id_marca from marcamotherboard where fabricante='"+maker+"';");
     }
     
     public String parsePosition(String position)
     {
         if(position == null)
         {
            return null;
         }
         else
         {
            return sensql.getData("id_puesto", "select id_puesto from puesto where puesto='"+position+"';");
         }
     }
     
    public boolean deleteEquipment(String id_equipment)
    {
        String ipAdmin = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipAdm` where id_pc='"+id_equipment+"';");
        String ipImage = sensql.getData("ip", "select ip from pc LEFT JOIN `ip` ON `id_ip` = `cod_ipImag` where id_pc='"+id_equipment+"';");
        if(ipAdmin != null && !ipAdmin.equals(""))
        {
            ipAdmin=parseIp(ipAdmin);
        }
        if(ipImage != null && !ipImage.equals(""))
        {
            ipImage=parseIp(ipImage);
        }
        updateStateIp("LIBRE", ipAdmin);
        updateStateIp("LIBRE", ipImage);
        return sensql.deleteRow("pc", "id_pc = "+id_equipment +";");  
    }
    
    public boolean modifyEquipment(String data[])
    {
        if(deleteEquipment(data[0]))
        {
            if (sensql.insertRow(data, "insert into `pc`(`id_pc`, `nombrePc`, `usuario`, `contraseña`, `cod_ipAdm`, `cod_ipImag`, `descripcion`,`cod_area`, `cod_procesador`, `cod_motherboard`, `cod_ram`, `cod_disco`, `cod_so`) values(?,?,?,?,?,?,?,?,?,?,?,?,?)"))
            {
                updateStateIp("USADA", data[4]);
                updateStateIp("USADA", data[5]);
                return true;
            }
            else
            {
                    return false;
            }
        }
        else
        {    
            return false;    
        }
    }
     
    //cuenta la cantidad de entradas en la tabla de ingresos y en la tabla de egresos en base a esas cantidades calcula el Stock
    public boolean updateIngressTableAndEgressTable(String stockActual, String nuevoStock, String cod_articulo)
    {
        int actual = Integer.parseInt(stockActual);
        int nuevo = Integer.parseInt(nuevoStock);
        int resultado = nuevo - actual;

        if (resultado > 0)
        {
            return ingressToner(cod_articulo,"1", "Actualizacion de stock",fecha, String.valueOf(resultado));
        }
        else if(resultado < 0)
        {   
            resultado = abs(resultado); 
            return egressToner(cod_articulo, "Actualizacion de stock",fecha, String.valueOf(resultado));   
        }
        return true;
    }
     
    public boolean update_stock(String stock, String id_articulo)
    {
          String campos[] = {stock,id_articulo};           
          return sensql.insertRow(campos, "update tonner set stock=? where id_tonner=?;");
    }   
    
    public boolean updateStockConBusqueda(String id_articulo)
    {
        int totalIngresos = sensql.getQuantity(" from ingresoTonner where cod_tonner='"+id_articulo+"';");
        int totalEgresos =  sensql.getQuantity(" from egresoTonner where cod_tonner='"+id_articulo+"';");
        int stock = totalIngresos - totalEgresos;
        return update_stock(Integer.toString(stock),id_articulo);
    }
    
    public boolean updateStatePrinter(String state,String code)
    {
        return sensql.modifiedRow("impresora", "estado", state, "id_sn = '"+ code +"'");
    }
    
    public boolean updateStateIp(String state,String id)
    {
        return sensql.modifiedRow("ip", "estado", state, "id_ip = '"+ id +"'");
    }
    
    public boolean updateStateIpAdmin(String state,String id_ipAdm)
    {
        return sensql.modifiedRow("ipadm", "estado", state, "id_ipAdm = '"+ id_ipAdm +"'");
    }
    
    public boolean updateStateIpImage(String state,String id_ipImage)
    {
        return sensql.modifiedRow("ipimage", "estado", state, "id_ipImag = '"+ id_ipImage +"'");
    }
     
    public boolean updateDateOfReturnPrinter(String date, String idRepair)
    {
        return sensql.modifiedRow("reparacion", "fechaRetorno", date, "id_reparacion = '"+idRepair+"'");
    }
    
    public boolean updateDetailOfReturnPrinter(String detail ,String idRepair)
    {
        return sensql.modifiedRow("reparacion", "detalleReparacion", detail, "id_reparacion = '"+idRepair+"'");
    }
    
    public boolean updatePrint(String id_sn, String id_equipment)
    {
        return sensql.modifiedRow("impresora", "cod_pc", id_equipment, "id_sn = '"+id_sn+"'");
    }
    public boolean cleanPosition(String serialNumber)
    {
       return sensql.modifiedRow("impresora", "cod_pc", "", "id_sn = '"+ serialNumber +"';");
    }
    
    public boolean printerIsUnderRepair(String code)
    {
        //String state = sensql.datos_string("estado", "select estado from impresora where id_sn='"+code+"';");
        //return state.equals("EN REPARACION");
        return sensql.existencias("*", " from reparacion where cod_impresora ='"+code+"' and fechaRetorno IS NULL;");
    }
    
    public Object[] combox(String tabla, String campo)
    {
        return sensql.setCombox(tabla, campo, "select "+campo+" from "+tabla+";");
    }
    
    public Object[][] datos_tonner(String id_articulo)
    {
        String[] columnas={"descripcion","stock"};
        Object[][] resultado = sensql.GetTabla(columnas, "tonner", "select descripcion, stock from tonner where id_tonner='"+id_articulo+"';");
        return resultado;
    }
   
    public boolean esPosibleRetirar(String idArticulo, String cantidad)
    {
        Object[][] datos = datos_tonner(idArticulo);
        int stock = Integer.parseInt(datos[0][1].toString());
        int stockARetirar = Integer.parseInt(cantidad);
        
        return (stock-stockARetirar) >= 0;
    }
    

    
}