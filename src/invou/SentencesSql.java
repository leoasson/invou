
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
        String consult = "SELECT " + select + from + " "+ where ; 
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
    
    public Object [][] GetTabla(String colName[], String tabla, String sql){
      int registros = 0;
      
      try{
         ps = con.connected().prepareStatement("select count(*) as total from " + tabla);
         res = ps.executeQuery();
         res.next();
         registros = res.getInt("total");
         res.close();
      }catch(SQLException e){
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
            ps = con.connected().prepareStatement("SELECT count('"+campo+"') as total " + from_where);
            System.out.println("SELECT count('"+campo+"') as total  " + from_where);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
         }catch(SQLException e){
            System.out.println(e);
         }

        if (registros >0){
               return true;
           }
        else
           {
               return false;
           }
    }
    
    public String getUltimateID (String table, String column, String where){
        String id="";
        try{
            System.out.println("SELECT max("+column+") as id from  " +table+ " where "+ where);
            ps = con.connected().prepareStatement("SELECT max("+column+") as id from " +table+ " where "+ where);
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
        int registros = 0;
        try{
            ps = con.connected().prepareStatement("SELECT sum(cantidad) as total "  + from_where);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
         }
        catch(SQLException e)
         {
            System.out.println(e);
         }
        return registros;
        
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
            System.out.println("SELECT count(DISTINCT "+ nameColum +") as total " + fromWhere);
            ps = con.connected().prepareStatement("SELECT count(DISTINCT `"+ nameColum +"`) as total " + fromWhere);
            res = ps.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        }
        catch(SQLException e){System.out.println(e);}

        Object[] datos = new Object[registros];
        try{
            System.out.println("SELECT DISTINCT "+ nameColum +" "+ fromWhere);
            ps = con.connected().prepareStatement("SELECT DISTINCT "+ nameColum +" "+ fromWhere);
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
         System.out.println("SELECT count(*) as total FROM " + tabla);
         ps = con.connected().prepareStatement("SELECT count(*) as total FROM " + tabla);
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
            System.out.println("UPDATE `"+ table +"` SET `"+column+"` = '"+value+"' WHERE "+ where +";");
            ps = con.connected().prepareStatement("UPDATE `"+ table +"` SET `"+column+"` = '"+value+"' WHERE "+ where +";");
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
              //System.out.println("DELETE FROM `"+ table +"` WHERE "+where+";");
              ps = con.connected().prepareStatement("DELETE FROM `"+ table +"` WHERE "+where+";");
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
}
    

