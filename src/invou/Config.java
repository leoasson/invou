package invou;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author leoasson
 */
public final class Config 
{

private String printPath, url, user, password, leftBorder, upBorder;
    
public Config() 
{
    
}
    
public void generatePaths() throws IOException
{
    getPaths();
}

public void getPaths() throws FileNotFoundException, IOException 
{
    String cadena;
    FileReader f = new FileReader(new File ("config.txt"). getAbsolutePath());
    try (BufferedReader b = new BufferedReader(f)) {
        while((cadena = b.readLine())!=null)
        {
            if(cadena.contains("PrintPath:>"))
            {  
                String[] parts = cadena.split(">");
                printPath = parts[1];
            }
            if(cadena.contains("Url:>"))
            {  
                String[] parts = cadena.split(">");
                url = parts[1];
            }
            if(cadena.contains("User:>"))
            {  
                String[] parts = cadena.split(">");
                user = parts[1];
            }
            if(cadena.contains("password:>"))
            {  
                String[] parts = cadena.split(">");
                password = parts[1];
            }
            if(cadena.contains("PrintLeftBorder:>"))
            {  
                String[] parts = cadena.split(">");
                leftBorder = parts[1];
            }
            if(cadena.contains("PrintUpBorder:>"))
            {  
                String[] parts = cadena.split(">");
                upBorder = parts[1];
            }
        }
    }
}
    
    public String getPathPrinter() throws IOException
    {
        generatePaths();
        return printPath;
    }

    public String getUrl() throws IOException
    {
        generatePaths();
        System.out.println(url);
        return url;

    }

    public String getUser() throws IOException
    {
        generatePaths();
        return user;
    }

    public String getPassword() throws IOException
    {
        generatePaths();
        return password;
    }

    public String getLeftBorder() throws IOException
    {
        generatePaths();
        return leftBorder;
    }
    
    public String getUpBorder() throws IOException
    {
        generatePaths();
        return upBorder;
    }
}
