package library.Utils;


import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class PropertyReader
{	
	String path =  getPath();  	
	//FileOutputStream out;
	
	public String getValue(String keySearchFor) throws IOException {
		String keyValue = null;
		String configFile = "application.properties";
/*		File f = new File("branchCompanyName/com/compname/config/");
		File fs = new File(f, configFile);
		String fullPath = fs.getAbsolutePath();
		System.out.println(fullPath);*/
		
//		PropertyReader projectpath = new PropertyReader();
//		String home = System.getProperty("user.home");
		String home = getPath();
		String testFileNamePath = "/branchCompanyName/com/compname/config/";
		System.out.println("projectpath.getPath = " + getPath());		
        String fileToReadIn = home + testFileNamePath + configFile;
     
        File settingsFile = new File(fileToReadIn);
        BufferedReader br = new BufferedReader(new FileReader(settingsFile));
        
        
        Iterator<String> it = br.lines().iterator();
        while (it.hasNext()) {
        	String line = it.next();
            if (line.startsWith(keySearchFor)) {
            	keyValue = line.substring(line.indexOf("=") + 1);            	
            	break;
            }
        }
        br.close();
        System.out.println("searched for key = " + keySearchFor + "; value = " + keyValue);
        return keyValue;
	}
	
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

	public void updateKeyInApplicationFile(String key, String value, String file) {
		try {
			Properties prop = new Properties();
			File f = new File(path + file);
			prop.load(new FileInputStream(f));

			prop.setProperty(key, value);
			FileWriter writer = new FileWriter(f);
			prop.store(writer, "changed key value");
			writer.close();
		} catch (Exception e) {
			System.out.println("Failed to update the application.properties file.");
		}
	}
    
	public String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}
 
}