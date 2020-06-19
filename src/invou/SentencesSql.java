
package invou;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class SentencesSql {
    
    connection con;
    PreparedStatement ps;
    ResultSet res;
    String consult;

    public SentencesSql() 
    {
        con = new connection();
    }
    
    public boolean insertRow(String datos[], String insert){
      boolean estado = false;
       try {
            ps = con.connected().prepareStatement(insert);
            for(int i=0; i<=datos.length-1;i++){
                ps.setString(i+1, datos[i]);
            }
            ps.execute();
            ps.close();
            estado = true;
         }catch(SQLException e){
         System.out.println(e);
      }
       return estado;
   }
    
    public Object [][] GetTable(String colName[], String from, String where){
        int register = 0;
        String select = arrayStringToString(colName);
        consult = "SELECT " + select + from + " "+ where ; 
        System.out.println(consult);
        try
        {
           ps = con.connected().prepareStatement("select count(*) as total " + from + where);
           res = ps.executeQuery();
           res.next();
           register = res.getInt("total");
           res.close();
        }
        catch(SQLException e)
        {
           System.out.println(e);
        }

      Object[][] data = new String[register][colName.length];
      String col[] = new String[colName.length];

        try{
           ps = con.connected().prepareStatement(consult);
           res = ps.executeQuery();
           int i = 0;
           while(res.next()){
              for(int j=0; j<=colName.length-1;j++){
                  col[j] = res.getString(colName[j]);
                  data[i][j] = col[j];
              }
              i++;
           }
           res.close();
            }catch(SQLException e){
           System.out.println(e);
        }
        return data;
    }
    
        public Object [][] GetTableForTonerReport(String colName[], String from, String where){
        int register = 0;
        String select = arrayStringToString(colName);
        consult = "SELECT " + select + from + " "+ where ; 
        System.out.println(consult);
        try
        {
           ps = con.connected().prepareStatement("select count(*) as total from ("+consult+") as `tableOne`");
           res = ps.executeQuery();
           res.next();
           register = res.getInt("total");
           System.out.println(register);
           res.close();
        }
        catch(SQLException e)
        {
           System.out.println(e);
        }

      Object[][] data = new String[register][colName.length];
      String col[] = new String[colName.length];

        try{
           ps = con.connected().prepareStatement(consult);
           res = ps.executeQuery();
           int i = 0;
           while(res.next()){
              for(int j=0; j<=colName.length-1;j++){
                  col[j] = res.getString(colName[j]);
                  data[i][j] = col[j];
              }
              i++;
           }
           res.close();
            }catch(SQLException e){
           System.out.println(e);
        }
        return data;
    }
    
    
    public Object [][] GetTabla(String colName[], String tabla, String sql){
      int registros = 0;
      
      try
      {
         consult = "select count(*) as total from " + tabla;
         ps = con.connected().prepareStatement(consult);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }
      catch(SQLException e)
      {
         System.out.println(e);
      }

    Object[][] data = new String[registros][colName.length];
    String col[] = new String[colName.length];
    
      try{
         ps = con.connected().prepareStatement(sql);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            for(int j=0; j<=colName.length-1;j++){
                col[j] = res.getString(colName[j]);
                data[i][j] = col[j];
            }
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }
     
     public boolean existencias(String campo, String from_where){
        int registros = 0;
        try{
            consult = "SELECT count('"+campo+"') as total  " + from_where;
            System.out.println(consult);
            ps = con.connected().prepareStatement(consult);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
         }catch(SQLException e){
            System.out.println(e);
         }

        return registros >0;
    }
    
    public String getUltimateID (String table, String column, String where){
        String id="";
        try{
            consult = "SELECT max("+column+") as id from  " +table+ " where "+ where;
            System.out.println(consult);
            ps = con.connected().prepareStatement(consult);
            res = ps.executeQuery();
            res.next();
            id = res.getString("id");
            res.close();
         }
        catch(SQLException e)
         {
            System.out.println(e);
         }
        return id;
    }
     
     /*
     * Retorna la suma de las cantidades de una tabla dado un articulo en particular.
     */
    public int getQuantity (String from_where){
        int record = 0;
        try{
            consult = "SELECT sum(cantidad) as total "  + from_where;
            ps = con.connected().prepareStatement(consult);
            res = ps.executeQuery();
            res.next();
            record = res.getInt("total");
            res.close();
         }
        catch(SQLException e)
         {
            System.out.println(e);
         }
        return record;   
    }
    
    public int getQuantityOfRow (String from_where)
    {
        int record = 0;
        try{
            consult = "SELECT count(*) as total "  + from_where;
            System.out.println(consult);
            ps = con.connected().prepareStatement(consult);
            res = ps.executeQuery();
            res.next();
            record = res.getInt("total");
            res.close();
         }
        catch(SQLException e)
         {
            System.out.println(e);
         }
        return record;   
    }
    
     
    public String getData(String nombre_columna, String sentenciasql){
        
    String datos ="";
      try{
         System.out.println(sentenciasql);
         ps = con.connected().prepareStatement(sentenciasql);
         res = ps.executeQuery();
         while(res.next()){
            datos = res.getString(nombre_columna);
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
    }
    
    /*
    * ejemplo setFilterCombox("columna a obtener los datos", 
    * "FROM `TABLA1` LEFT JOIN `TABLA2` ON `id_tabla1` = `cod_tabla2` where 'RESTRICCION'")
    */
    public Object[] setFilterCombox(String nameColum, String fromWhere){
        int registros = 0;      
        try
        {
            consult = "SELECT count(DISTINCT "+ nameColum +") as total " + fromWhere;
            System.out.println(consult);
            ps = con.connected().prepareStatement(consult);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }
        catch(SQLException e){System.out.println(e);}

        Object[] datos = new Object[registros];
        try{
            consult = "SELECT DISTINCT "+ nameColum +" "+ fromWhere;
            System.out.println(consult);
            ps = con.connected().prepareStatement(consult);
            res = ps.executeQuery();
            int i = 0;
            while(res.next()){
               datos[i] = res.getObject(nameColum);
               i++;
            }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }   
    
    public Object[] setCombox(String tabla, String nombrecol, String sql){
      int registros = 0;      
      try
      {
         consult = "SELECT count(*) as total FROM " + tabla;
         System.out.println(consult);
         ps = con.connected().prepareStatement(consult);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }
      catch(SQLException e)
      {
         System.out.println(e);
      }

    Object[] datos = new Object[registros];
      try{
         ps = con.connected().prepareStatement(sql);
         res = ps.executeQuery();
         int i = 0;
         while(res.next()){
            datos[i] = res.getObject(nombrecol);
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return datos;
 }
     
    public boolean modifiedRow(String table, String column ,String value, String where){
        try
        {
            consult = "UPDATE `"+ table +"` SET `"+column+"` = '"+value+"' WHERE "+ where +";";
            System.out.println(consult);
            ps = con.connected().prepareStatement(consult);
            ps.executeUpdate();
            return true;
        }
        catch(SQLException e)
        {
            System.out.println(e);
            return false;
        }
    }
     
    public boolean deleteRow(String table, String where){
            try
            {
              consult = "DELETE FROM `"+ table +"` WHERE "+where+";";
              //System.out.println(consult);
              ps = con.connected().prepareStatement(consult);
              ps.executeUpdate();
              return true;
            }
          catch(SQLException e)
          {
              System.out.println(e);
              return false;
          }  
            
        } 
    
    private String arrayStringToString (String [] table){
           String select = "";
              for (String table1 : table)
        {
            if (select.equals("")) {
                select = table1;
            } else {
                select = select + "," + table1;
            }
        }
              return select + " ";
     }
    
    public String getConsultSql()
    {
        return consult;
    }
}
    

