package codingBat;

public class CodingBat2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ab";
		String str2 = "sunday";
		// System.out.println(makeOutWord(str, str2));

		/*
		 * int[] x = new int[]
		 * {1,2,3,4,5,6,7,8,9,20,40,50,100,200,210,210,1009,2000,2001}; int[] y
		 * = {9,8,99,88,7}; System.out.println(makePi(y));
		 * System.out.println(makePi1());
		 */

		int[] nums = new int[] { 1, 2, 3 };
		System.out.println(frontPiece(nums));
		;
	}

	public static int[] frontPiece(int[] nums) {
		// int[] res = new int[2];
		if (nums.length > 2) {
			// res[0] = nums[0];
			// res[1] = nums[1];
			// return res;
			return new int[] { nums[0], nums[1] };
		}
		return nums;
	}

	public static int[] makePi1() {
		int[] res = new int[3];
		res[0] = 3;
		res[1] = 1;
		res[2] = 4;
		return res;
	}

	public static int[] makePi(int[] a) {
		int[] res = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			res[i] = a[i];
			System.out.println("" + a[i]);
		}
		return res;
	}

	public static boolean sameFirstLast(int[] nums) {
		int count = nums.length;
		if (count > 1) {
			for (int i = 0; i < nums.length; i++) {
				// if()
			}
			return true;
		}
		return false;
	}

	public static boolean firstLast6(int[] nums) {
		int all = nums.length;
		return (nums[0] == 6 || nums[nums.length] == 6);
	}

	public String middleTwo(String str) {
		int count = str.length();
		if (count > 2) {
			count = count / 2;
			return "" + str.charAt(count - 1) + str.charAt(count);
		}
		return str;
	}

	public static String helloName(String str) {
		// String sampel = "right2("Hello") → "loHel";
		if (str.length() > 2) {
			String a = str.substring(str.length() - 2, str.length());
			String b = str.substring(0, str.length() - 2);
			return a + b;
		}
		return str;
	}

	public static String makeOutWord(String a, String b) {
		int countA = a.length();
		int countB = b.length();
		if (countA > countB) {
			return b + a + b;
		} else if (countA < countB) {
			return a + b + a;
		} else {
			return "nothing";
		}
	}
}
