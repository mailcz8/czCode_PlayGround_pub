package basicJavaDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.testng.annotations.Test;

public class StringRevert {

	public static void main(String[] args) {
		String input = "GeeksforGeeks";
		String input2 = "Geeks for Geeks";

		// revertStringMethod1(input);
		// revertStringMethod2(input2);
		// revertStringMethod3(input2);
		// revertStringMethod4(input2);
		revString();
	}

	public static void revertStringMethod1(String input) {

		// getBytes() method to convert string into bytes[].
		byte[] strAsByteArray = input.getBytes();
		byte[] result = new byte[strAsByteArray.length];

		// Store result in reverse order into the
		// result byte[]
		for (int i = 0; i < strAsByteArray.length; i++)
			result[i] = strAsByteArray[strAsByteArray.length - i - 1];
		System.out.println(new String(result));
	}

	public static void revertStringMethod2(String input) {

		StringBuilder input1 = new StringBuilder();

		// append a string into StringBuilder input1
		input1.append(input);

		// reverse StringBuilder input1
		input1 = input1.reverse();

		System.out.println(input1);
		// print reversed String
		for (int i = 0; i < input1.length(); i++)
			System.out.print(input1.charAt(i));
		System.out.println();
	}

	public static void revertStringMethod3(String input) {
		// convert String to character array
		// by using toCharArray
		char[] data = input.toCharArray();
		System.out.println("total data length: " + data.length);

		String newData = String.valueOf(data.length - 1);
		newData = Integer.toString(data.length - 2);
		// IntegernewData = new Integer(int).toString(data.length-3)
		System.out.println("newData = " + newData);

		for (int i = data.length - 1; i >= 0; i--)
			System.out.print(data[i]);
	}

	public static void revertStringMethod4(String input) {
		char[] hello = input.toCharArray();
		List<Character> trial1 = new ArrayList<>();

		for (char c : hello)
			trial1.add(c);

		Collections.reverse(trial1);
		ListIterator<Character> li = trial1.listIterator();
		while (li.hasNext())
			System.out.print(li.next());
	}

	@Test
	public static void revString() {
		String sText = "abc";
		String result = "";
		int tMax = sText.length();
		StringBuilder t = new StringBuilder();

		System.out.println("text length = " + tMax);
		for (int i = 0; i < sText.length(); i++) {
			// System.out.println(sText.charAt(i));
			String sVal = String.valueOf(sText.charAt(i));
			result = result + sVal;
		}
		System.out.println("org text = " + sText);
		System.out.println("after reservsed = " + result);

		for (int i = tMax - 1; i >= 0; i--) {
			// System.out.println(sText.charAt(i));
			String sVal = String.valueOf(sText.charAt(i));
			result = result + sVal;
		}
		System.out.println("org text = " + sText);
		System.out.println("after reservsed = " + result);
	}

	@Test
	public static void charArrDemo() {
		System.out.println("java demo: charArrDemo");
		String str = "MondayTuesday";
		char[] newCharList = str.toCharArray();
		System.out.println(newCharList.length);

		System.out.println(str.charAt(3));

		char[] char1 = new char[7];
		str.getChars(0, 7, char1, 0);
		System.out.println(char1);
	}
}
