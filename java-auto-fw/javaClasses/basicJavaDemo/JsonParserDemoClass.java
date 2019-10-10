package basicJavaDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.StringReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import baseHelper.PropertyReader;

public class JsonParserDemoClass {

	public String getTestFilePath() {
		File f = new File("javaSandbox/src/testData");
		File fs = new File(f, "createAccTemplate.json");
		System.out.println(fs);
		String fullPath = fs.getAbsolutePath();
		System.out.println(fullPath);
		
		PropertyReader projectpath = new PropertyReader();
//		String home = System.getProperty("user.home");
		String home = projectpath.getPath();
		String jsonTemplatePath = "javaSandbox/src/testData";
		System.out.println("projectpath.getPath = " + projectpath.getPath());
		String jsonTemplateFileName = "createAccTemplate.json";
        String fileToReadIn = home + jsonTemplatePath + jsonTemplateFileName;
        System.out.println(fileToReadIn);
        return fileToReadIn;
	}
	
	public void newJsonWithParam(String desiorParentId, String numAccToCreate) throws IOException {
		// InputStream is = new FileInputStream(fileName);
		// BufferedReader buf = new BufferedReader(new InputStreamReader(is));

		String fileName = "/Users/czheng/devgitmailcz8/javaSandbox/src/testData/createAccTemplate.json";
		BufferedReader buf = new BufferedReader(new FileReader(fileName));
		System.out.println(buf.toString());

		String line = buf.readLine();
		System.out.println(line);
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			System.out.println(line);
			if (line.contains("parentIdNumber")) {
				line = line.replace("parentIdNumber", desiorParentId);
			} else if(line.contains("serverNameForCreateAccount")) {
				line = line.replace("serverNameForCreateAccount", "liveqa31");
			} else if(line.contains("numberOfAccountToBeCreated")) {
				line = line.replace("numberOfAccountToBeCreated", numAccToCreate);
			}
			System.out.println(line);
			sb.append(line).append("\n");
			line = buf.readLine();
		}
		buf.close();
		
		String outFileName = "/Users/czheng/devgitmailcz8/javaSandbox/src/testData/newCreateAccFile.json";
		String fileAsString = sb.toString();
		System.out.println("Contents : " + fileAsString);
		
		// write out to a file
		BufferedWriter outBuf = new BufferedWriter(new FileWriter(outFileName));
		outBuf.write(fileAsString);
		outBuf.close();
	}
	
	public void newJsonWithSeriolized(int desiorParentId, int numAccToCreate) throws IOException {
		// InputStream is = new FileInputStream(fileName);
		// BufferedReader buf = new BufferedReader(new InputStreamReader(is));

		String fileName = "/Users/czheng/devGitRepo/ai-automation-framework-v1/libs/TSF/createAccTemplate.json";
		BufferedReader buf = new BufferedReader(new FileReader(fileName));
		System.out.println(buf.toString());
		char[] cbuf = new char[5*1024]; //5 kb space for this char buff
		buf.read(cbuf);		
		buf.close();
		String cbufToString = new String(cbuf);		
		System.out.println("cbufToString = " + cbufToString);
		
		StringReader reader = new StringReader(cbufToString);
		JsonReader jsonReader = new JsonReader(reader);
		jsonReader.setLenient(true);
	
		JsonParser parser = new JsonParser();
		JsonObject o = parser.parse("{\"a\": \"A\"}").getAsJsonObject();
		JsonObject accTemplateJsonObj = parser.parse(cbufToString).getAsJsonObject();
		
		JsonObject reqStepIndexOne = accTemplateJsonObj.getAsJsonArray("steps").get(1).getAsJsonObject();
		reqStepIndexOne.addProperty("name", "TestAccountName");
		reqStepIndexOne.addProperty("is-disabled", false);
		
		JsonObject regBodyVal = accTemplateJsonObj.getAsJsonArray("steps").get(1).getAsJsonObject().getAsJsonObject("request-body");
		regBodyVal.addProperty("parentId", desiorParentId);
		regBodyVal.addProperty("server", "liveqa31");
		regBodyVal.addProperty("count", numAccToCreate);
		
		Gson gson = new Gson();
		String finalFileAsString = gson.toJson(accTemplateJsonObj);
		
		System.out.println("Contents : " + finalFileAsString);
	}
}
