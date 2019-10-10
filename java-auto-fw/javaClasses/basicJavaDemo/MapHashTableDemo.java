package basicJavaDemo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapHashTableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strWC = ("@, a, b, c, a, b, c,a, aa, b,b, c, c,c, ccccc, c, c, c,		 a, a, 9, 9 ,9,9,9,999,9z");
		String strWC2 = ("a, b, c, d, e");
		String str = "bcaccashdfohwaaaaaaaaaaaaaaaaaoquihefonouhwfuphquwhefnmzbnmbkhoiqw";

//		demoHashtable();
//		demoMap();
//		maxLetterCountA(str);
//		maxLetterCountB(str);
//		demoHashMap(strWC);
		
//		hashWithTwoStrings(strWC2);
//		hashS2S(strWC2);
		hashFunStringString2(strWC);
	}

	public static void hashS2S(String str) {
		String[] newStr = str.split(",");
		Map<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i<newStr.length-1; i++) {
			String key = newStr[i].trim();
			String value = newStr[i+1].trim();
			map.put(key, value);
			i=i+1;
		}

		for(String key : map.keySet()) {
			String value = map.get(key);
			System.out.print("key is: " + key + "\t");
			System.out.println("; value: " + value);
		}
	}
	
	public static void maxLetterCountA(String str) {
		char[] charX = str.toCharArray();
		int[] charCount = new int[26];

		for (char c : charX) {
			int char2slot = c - 'a';
			charCount[char2slot] = charCount[char2slot] + 1;
		}

		int max = 0;
		char key = ' ';
		for (int i = 0; i < charCount.length; i++) {
			char slot2char = (char) ('a' + i);
			System.out.println("char = " + slot2char + ", count = " + charCount[i]);

			if (max < charCount[i]) {
				max = charCount[i];
				key = slot2char;
			}
		}
		System.out.println("key = " + key + ", max = " + max);
	}

	public static void maxLetterCountB(String str) {
		char[] charX = str.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (char c : charX) {
			// System.out.println("output: " + c);
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				int oldCount = map.get(c);
				int newCount = oldCount + 1;
				map.put(c, newCount);
			}
		}

		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			System.out.print("key = " + m.getKey());
			System.out.println("; value = " + m.getValue());
		}

		System.out.println("======== Search for spacific value only ========");
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			String[] searchVal = { "a", "z" };
			for (String st : searchVal) {
				char newcc = st.charAt(0);
				if (m.getKey().equals(newcc)) {
					System.out.print("key = " + m.getKey());
					System.out.println("; value = " + m.getValue());
				}
			}
		}

		System.out.println("======== Get value for the key with Max count ========");
		int maxCount = 0;
		char maxKey = ' ';
		for (Map.Entry<Character, Integer> m : map.entrySet()) {
			// System.out.println(m.getKey() + ": " + m.getValue());
			if (maxCount < m.getValue()) {
				maxCount = m.getValue();
				maxKey = m.getKey();
			}
		}
		System.out.println("The key value: " + maxKey + " has " + maxCount + " count");
	}

	public static void demoHashMap(String str) {
		String[] ar = str.split(",");
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String n : ar) {
			String trimN = n.trim();
			if(!map.containsKey(trimN)) {
				map.put(trimN, 1);
			}else {
				int count = map.get(trimN) + 1;
				map.put(trimN, count);
		 	}
//			System.out.println(map.entrySet());
		}
		
		String findVal = "c";
		System.out.println("search for value: "+findVal+", and found:" +map.get(findVal));
		
		for(Map.Entry<String, Integer> m : map.entrySet()) {			
			if(m.getKey().equals("aa")) {
				System.out.print("key = " + m.getKey());
				System.out.println("::: value = " + m.getValue());
			}
		}
		
		for(Map.Entry<String, Integer> m : map.entrySet()) {			
			System.out.print("key = "+m.getKey());
			System.out.println("; value = " + m.getValue());
		}
	}

	public static void demoCharCount() {
		String str = ("a, b, c, a, b, c,a, aa, b,b, c,        c,c, ccccc, ccccc, c, c, a, a, 9, 9 ,9,9,9,999,99");
		int charA = 0, charB = 0, charC = 0;
		String[] ar = str.split(",");
		for (String n : ar) {
			n = n.trim();
			System.out.println("print val: " + n.trim());
			for (char x : n.toCharArray()) {
				if (x == 'a') {
					charA++;
				} else if (x == 'b') {
					charB++;
				} else if (x == 'c') {
					charC++;
				}
			}
			// System.out.println("a count = " + charA);
			// System.out.println("b count = " + charB);
			// System.out.println("c count = " + charC);
			// charA = 0; charB = 0; charC = 0;
		}

		// for (Map.Entry m : map.entrySet()) {
		// System.out.println(m.getKey() + " " + m.getValue());
		// }
		System.out.println("a count = " + charA);
		System.out.println("b count = " + charB);
		System.out.println("c count = " + charC);
	}

	public static void demoHashtable() {
		Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
		numbers.put("one", 1);
		numbers.put("two", 2);
		numbers.put("three", 3);
		System.out.println(numbers);

		Integer n = numbers.get("two");
		if (n != null) {
			System.out.println("two = " + n);
		}
	}

	public static void demoMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(100, "Amit");
		map.put(101, "Vijay");
		map.put(102, "Rahul");
		for (Map.Entry m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
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
 			System.out.println("key = " + m.getKey() + " \t" +"value = " + m.getValue()); 			
 		}
	}
	
}
