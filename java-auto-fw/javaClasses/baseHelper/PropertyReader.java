package baseHelper;


import java.io.*;
import java.util.*;

public class PropertyReader
{	
	String path =  getPath();  	
	//FileOutputStream out;
    public String readApplicationFile(String key, String file){ 
    	
    	String value = "";
        try{         	  
	          Properties prop = new Properties();
	          File f = new File(path +file );
	        
	          if(f.exists()){
		          prop.load(new FileInputStream(f));
		          value = prop.getProperty(key); 		        
          	}
	   }
        catch(Exception e){  
           System.out.println("Failed to read from application.properties file.");  
        }
        return value;
     } 

    public void updateKeyInApplicationFile(String key, String value, String file){ 
        try{
        	Properties prop = new Properties();
        File f = new File(path +file);
        prop.load(new FileInputStream(f));
        
        prop.setProperty(key, value);
        FileWriter writer = new FileWriter(f);
        prop.store(writer, "changed key value");
        writer.close();        
        }
        catch(Exception e){  
           System.out.println("Failed to update the application.properties file.");  
        }
     } 
    
	public String getPath()
	{
		String path ="";		
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");		
		return path;
	}
 
}