package codingBat;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a, b, c";
//		revertStr(str);
//		hashFun1(str);
//		hashFunStringString1(str);
		hashFunStringString2(str);
	}
	
	public static void hashFunStringString1(String str) {
		String[] newStr = str.split(",");		
		Map<String, String> map = new HashMap<>();
		for(int i=0; i<newStr.length; i++) {
			String key = newStr[i].trim();
			String value;
			if(i+1 == newStr.length) {
				value = key;				
			} else {
				value = newStr[i+1].trim();
			}
			map.put(key, value);
			i=i+1;
		}
		
 		for(Map.Entry<String, String> m : map.entrySet()) {
 			System.out.println("key = " + m.getKey() + "\t" +"value = " + m.getValue()); 			
 		}
	}
	
	public static void hashFunStringString2(String str) {
		String[] newStr = str.split(",");
		Map<String, String> map = new HashMap<>();
		for(int i=0; i<newStr.length-1; i++) {
			String key = newStr[i].trim();
			String value = newStr[i+1].trim();
			map.put(key, value);
			i = i + 1;
		}
		
		if(newStr.length%2 == 1) {
			String lastStr = newStr[newStr.length-1].trim();
			map.put(lastStr, lastStr);
		}
		
 		for(Map.Entry<String, String> m : map.entrySet()) {
 			System.out.println("key = " + m.getKey() + "\t" +"value = " + m.getValue()); 			
 		}
	}
	
	public static void revertStr(String str) {
		String newStr = "";
		int strMax = str.length();
		for(int i=strMax-1; i>0; i--) {
			String res = Character.toString(str.charAt(i));			
			newStr = newStr + res.trim();
		}
		System.out.println(newStr);
	}
	
	public static void hashFunStringInt(String str) {
		String[] newStr = str.split(",");
		Map<String, Integer> map = new HashMap<>();
		for(String n : newStr) {
			String trimStr = n.trim();
			if(map.containsKey(trimStr)) {
				System.out.println(map.get(trimStr));
				int counter = map.get(trimStr);
				map.put(trimStr, counter+1);
			}else {
				map.put(trimStr, 1);
			}
		}
		
 		for(Map.Entry<String, Integer> m : map.entrySet()) {
 			System.out.println("key = " + m.getKey() + "\t" +"value = " + m.getValue()); 			
 		}
	}
	
}
