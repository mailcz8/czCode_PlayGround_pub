package codingBat;

import java.util.HashMap;
import java.util.Map;

public class Codingbat1 {

	public static void main(String[] args) {
		String str = "bz00";
		// frontBack(str);
		// System.out.println(front3(str));
		// System.out.println(front3("xxxo"));

		int[] lNumbs = { 1, 2, 3, 9, 3, 5, 8 };
		// intMax(lNumbs);

		System.out.println(everyNth("infomation", 2));
	}

	public static String everyNth(String str, int n) {
		String res = "result = " + str.charAt(0);
		String tail = "";
		for (int i = 0; i < str.length(); i = i + n) {
			tail = tail + str.charAt(i);
		}
		return tail;
	}

	public static String endUp(String str) {
		if (str.length() < 3)
			return (str.toUpperCase());
		String front = str.substring(0, str.length() - 3);
		String end = str.substring(str.length() - 3).toUpperCase();
		return front + end;
	}

	public static boolean stringE(String str) {
		int count = 0;
		char[] n = str.toCharArray();
		for (char c : n) {
			if (c == 'e') {
				count = count + 1;
			}
		}
		System.out.println("count = " + count);
		if (count == 1 || count == 3) {
			return true;
		}
		return false;
	}

	public static int max1020(int a, int b) {
		if (b > a) {
			int temp = a;
			a = b;
			b = temp;
		}
		if (a >= 10 && a <= 20)
			return a;
		if (b >= 10 && b <= 20)
			return b;
		return 0;
	}

	public static int intMax(int a[]) {
		// int[] lNumbs = {1, 2, 3, 9, 3, 5, 8};
		int maxInt = 0;
		System.out.println(a[1]);
		for (int i = 0; i < a.length; i++) {
			if (maxInt < a[i]) {
				maxInt = a[i];
			}
		}
		System.out.println("max value = " + maxInt);
		return maxInt;
	}

	public static int close10(int a, int b) {
		int newA = Math.abs(a - 10);
		int newB = Math.abs(b - 10);
		if ((a == b) || (newA == newB)) {
			return 0;
		}
		if (a > b) {
			return b;
		}
		return a;
	}

	public static String delDel(String str) {
		if (str.length() == 4) {
			return str.substring(0, 1);
		} else if (str.length() > 4) {
			String newStr = str.substring(1, 4);
			if (newStr.equals("del")) {
				return str.charAt(0) + str.substring(4, str.length());
			}
		}
		return str;
	}

	public static String front3(String str) {
		char x = str.charAt(str.length() - 1);
		return x + str + x;
	}

	public static String frontBack(String str) {
		if (str.length() <= 1)
			return str;
		String mid = str.substring(1, str.length() - 1);
		// last + mid + first
		String result = str.charAt(str.length() - 1) + mid + str.charAt(0);
		System.out.println(result);
		return result;
	}

	public static String switchFB(String str) {
		String newStr = str.charAt(str.length() - 1) + str.substring(1, str.length() - 1) + str.charAt(0);
		System.out.println(newStr);
		return newStr;
	}

	public static void mapDoTheCount(String str) {
		String[] ar = str.split(",");
		Map<String, Integer> map = new HashMap<>();
		int maxlen = ar.length;
		for (int i = 0; i < maxlen; i++) {
			String trimAr = ar[i].trim();
			if (map.containsKey(trimAr)) {
				int count = map.get(trimAr);
				map.put(trimAr, count + 1);
			} else {
				map.put(trimAr, 1);
			}
		}
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			System.out.print("key = " + m.getKey() + " \t");
			System.out.println("; value = " + m.getValue());
		}
	}
}
