package basicJavaDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import baseHelper.PropertyReader;

public class IOLinesAndFiles {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "testHashData.txt";
//		readWriteFile(getFilePath1(fileName));
//		readWriteFile(getFilePath2(fileName));
		buildXMLRequestFile("loginUser", "admin@comp.com", "password");
	}

	public static String getFilePath1(String fileName) throws IOException {
		File f = new File("src/testData");
		File fs = new File(f, fileName);
		String fileLoc = fs.getAbsolutePath();
//		System.out.println(fs.getAbsolutePath());
		return fileLoc;
	}
	
	public static String getFilePath2(String fileName) {
		PropertyReader projectpath = new PropertyReader();
//		String home = System.getProperty("user.home");
		String home = projectpath.getPath();
		String dirPath = "/src/testData/";
        String fileLoc = home + dirPath + fileName;
//		System.out.println(fileLoc);
        return fileLoc;
	}

	public static void readWriteFile(String fileLoc) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileLoc));

		String line = br.readLine();
//		String line = " ";
		System.out.println(line);
		StringBuilder sb = new StringBuilder();
		while (line != null) {
			//System.out.println(line);
			sb.append(line).append("\n");
			line = br.readLine();
			System.out.println(line);
		}
		br.close();
		
		String outFileName = "newCreateTestFile.txt";
		File f = new File("test-output");
		File fs = new File(f, outFileName);
		String outFileLoc = fs.getAbsolutePath();
		System.out.println("file pull path: " + outFileLoc);
		String fileAsString = sb.toString();
//		System.out.println("Contents : " + fileAsString);
		String[] lineX = fileAsString.split("\n");
		for(String l : lineX) {
			System.out.println(l);
		}
		
		// write new Jason file to a file
		BufferedWriter outBuf = new BufferedWriter(new FileWriter(outFileLoc));
		outBuf.write(fileAsString);
		outBuf.close();	
	}
	
	//build a file
    public static String buildXMLRequestFile(String companyMethod, String username, String password) throws Exception{
    	String outFileName = "newZZZXMLFileTest.txt";
		File f = new File("test-output");
		File fs = new File(f, outFileName);
		String outFileLoc = fs.getAbsolutePath();
		System.out.println(outFileLoc);
		@SuppressWarnings("unused")
		BufferedWriter bw = new BufferedWriter(new FileWriter(outFileLoc));
		
        StringBuffer contentBuffer = new StringBuffer();
        contentBuffer.append("<?xml version=\'1.0\' encoding=\'UTF-8\'?>\n");
        contentBuffer.append(String.format("<call method=\"%s\" callerName=\"%s\">\n", companyMethod, username));
        contentBuffer.append(String.format("<credentials login=\"%s\" password=\"%s\"/>\n", username, password));
        contentBuffer.append("<valueSet>\n");
        contentBuffer.append("</valueSet>\n");
        contentBuffer.append("</call>\n");
        contentBuffer.append("</newZZZXMLFileTest>");
//        System.out.println(contentBuffer.toString());
        bw.write(contentBuffer.toString());
        bw.close();
        return contentBuffer.toString();  
    }
}
