package basicJavaDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReplacement {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// newJsonWithWholeBuffer("createAcc.json");

		// newJsonWithParam("createAcc.json");
		//
		// stringReplace();
		//
		// stringReplaceTwo();

		codeConvert("abc");
		codeConvert("happy");
		codeConvert("happz");

		findMax(new int[] { 5, 6, -10, 0, 2, -300 });
		findMax(new int[] { -5, -6, -10, -300 });
	}

	public static void newJsonWithWholeBuffer(String fileName) throws IOException {
		System.out.println(fileName);
		// InputStream is = new FileInputStream(fileName);
		// BufferedReader buf = new BufferedReader(new InputStreamReader(is));
		String filePath = "/Users/czheng/devGitRepo/ai-automation-framework-v1/libs/TSF/";
		fileName = filePath + fileName;

		BufferedReader buf = new BufferedReader(new FileReader(fileName));
		char[] cBuf = new char[1024 * 3];
		int size = buf.read(cBuf);
		System.out.println(String.valueOf(size));
		buf.close();

		String allText = new String(cBuf);

		allText = allText.replace("test-scenario", "sunday");
		allText = allText.replace("liveqa31", "monday");

		String newFileName = filePath + "newFileName.json";
		BufferedWriter bufOut = new BufferedWriter(new FileWriter(newFileName));
		bufOut.append(allText);
		bufOut.close();
	}

	public static void newJsonWithParam(String fileName) throws IOException {
		String filePath = "/Users/czheng/devGitRepo/ai-automation-framework-v1/libs/TSF/";
		fileName = filePath + fileName;

		BufferedReader buf = new BufferedReader(new FileReader(fileName));
		String line = buf.readLine();

		StringBuilder sb = new StringBuilder();
		while (line != null) {
			// sb.append(line).append("\n");
			if (line.contains("test-scenario")) {
				line = line.replace("test-scenario", "wwwXXXyyyZZZ");
			} else if (line.contains("liveqa31")) {
				line = line.replace("liveqa31", "liveqa44");
			}
			sb.append(line).append('\n');
			line = buf.readLine();
		}

		String newFileName = filePath + "newFileName.json";
		BufferedWriter bufOut = new BufferedWriter(new FileWriter(newFileName));
		bufOut.append(sb.toString());
		bufOut.close();
	}

	public static void stringReplace() {
		System.out.println("=== stringReplace method ===");
		String oneLine = "  I's was overjoyed's to be able to cele.......brate one of my favorite authors, Italo Calvino.";

		oneLine = oneLine.replace(" ", "\n");
		oneLine = oneLine.replace(".", "");
		oneLine = oneLine.replace(",", "");
		oneLine = oneLine.replace("'s", "");
		System.out.println("after replace: " + oneLine);

		oneLine = oneLine.replace("\n", " ");
		System.out.println("trim 1: " + oneLine.trim());

		oneLine = oneLine.concat(", hello world    ").trim();
		System.out.println("trim 2: " + oneLine);

		// oneLine = oneLine.concat(", hello world").trim().toUpperCase();
		System.out.println("toUpper: " + oneLine.toUpperCase());
		System.out.println("toLower: " + oneLine.toLowerCase());
	}

	public static void stringReplaceTwo() {
		System.out.println(" \n\n=== stringReplaceTwo method ===");
		String oneLine = "I's was overjoyed's to be able to celebrate one of my favorite authors, Italo Calvino.";

		for (int i = 0; i < oneLine.length(); i++) {
			char c = oneLine.charAt(i);

			if (c == ' ') {
				System.out.println();
			} else if (c == '.' || c == ',') {
				// just do nothing is good
			} else if (c == '\'') {
				if (oneLine.charAt(i + 1) == 's') {
				}
			} else {
				System.out.print(c);
			}
		}
	}

	public static String codeConvert(String originalText) {
		String resultText = "";
		for (int i = 0; i < originalText.length(); i++) {
			char y = originalText.charAt(i);
			// System.out.println("position " + i + " has char: " + y);
			if (y == 'z') {
				y = 'a';
			} else {
				y = (char) (y + 1); // down cast
			}
			// System.out.println("position " + i + " converted value is: " +
			// y);
			resultText = resultText + y;
		}
		System.out.println("Original text: " + originalText + " >>> Encoded text: " + resultText);
		return resultText;
	}

	public static int findMax(int[] num) {
		int maxVal = Integer.MIN_VALUE;
		System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
		for (int i = 0; i < num.length; i++) {
			int currentNum = num[i];
			if (currentNum > maxVal) {
				maxVal = currentNum;
			}
		}

		System.out.println("Max valu = " + maxVal);
		return maxVal;
	}
	
	public static void strReadAndAppendOutput() throws Exception {
	    FileInputStream f= new FileInputStream("D:/workplace/sample/bookstore.txt");
	    BufferedReader br = new BufferedReader(new InputStreamReader(f));
	    String strline;
	    StringBuffer sb = new StringBuffer();
	    while ((strline = br.readLine()) != null)
	    {
//	        String[] arraylist=StringUtils.split(strline, ",");
	    	String[] arraylist=strline.split(",");
	        if(arraylist.length == 2){
//	            sb.append("lat=").append(strline.trim(arraylist[0])).append("&lon=").append(strline.trim(arraylist[1])).append("&rt=1.0&|");
	            sb.append("lat=").append(strline.trim()).append("&lon=").append(strline.trim()).append("&rt=1.0&|");
	        }else{
	            System.out.println("Error: "+strline);
	        }

	    }

	    System.out.println("Data: "+sb.toString());
	}
}
