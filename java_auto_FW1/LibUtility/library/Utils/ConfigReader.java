package library.Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

//import com.library.Utils.ExecutionLog;
//import com.library.Utils.PropertyReader;
//import com.library.Utils.config.ProductConfig;

public class ConfigReader {
	
	
	public String fileParserAndUpdate(String desiorParentId, 
			String parentCode, String newAccountName) throws Exception {
		String jsonTemplateFileName = "fileName.txt";
/*		File f = new File("PlanningAndConsolidation/com/adaptiveinsight/data");
		File fs = new File(f, jsonTemplateFileName);
		String fullPath = fs.getAbsolutePath();
		System.out.println(fullPath);*/
		
		PropertyReader projectpath = new PropertyReader();
//		String home = System.getProperty("user.home");
		String home = projectpath.getPath();
		String testFileNamePath = "/branchname/com/compname/config/";
		System.out.println("projectpath.getPath = " + projectpath.getPath());		
        String fileToReadIn = home + testFileNamePath + jsonTemplateFileName;
        
        // This will only create 1 account for now
		String numAccToCreate = "1";
		String loginURI = "URL"; // appValues.getValue("URL");
		String username = "Username"; //appValues.getValue("Username");
		String clusterInfo = loginURI.substring(loginURI.lastIndexOf("https")+8, loginURI.indexOf(".adaptive"));
		ExecutionLog.Log(clusterInfo);
		BufferedReader buf = new BufferedReader(new FileReader(fileToReadIn));

		String line = buf.readLine();
		StringBuilder sb = new StringBuilder();
		
		while (line != null) {
			System.out.println(line);
			if (line.contains("expParentCode")) {
				line = line.replace("expParentCode", parentCode);
			} else if(line.contains("adminUserIDCreateAccount")) {
				line = line.replace("adminUserIDCreateAccount", username);
			} else if(line.contains("serverNameForCreateAccount")) {
				line = line.replace("serverNameForCreateAccount", clusterInfo);
			} else if(line.contains("instanceName")) {
				line = line.replace("instanceName", "C31_CZGC_171102");
			} else if(line.contains("accountPrefixTestDataAccount")) {
				line = line.replace("accountPrefixTestDataAccount", newAccountName);
			} else if(line.contains("numberOfAccountToBeCreated")) {
				line = line.replace("numberOfAccountToBeCreated", numAccToCreate);
			}
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		buf.close();
		
		String outFileName = home + testFileNamePath + "newCreateAccJsonFile.json";
		ExecutionLog.Log("New Json file name: " + outFileName);
		String fileAsString = sb.toString();
		System.out.println("Contents : " + fileAsString);
		
		// write new Jason file to a file
		BufferedWriter outBuf = new BufferedWriter(new FileWriter(outFileName));
		outBuf.write(fileAsString);
		outBuf.close();		

		//Creating accounts using Test Services Framework(TSF)
//		TestServicesClient testServicesClient = new TestServicesClient();
//		testServicesClient.executeScenario(outFileName);
		
		//Account name
		String newAccountID = newAccountName + 1;
		ExecutionLog.Log("new account created by TSF = " + newAccountID);
		return newAccountID;
	}

}
