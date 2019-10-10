package basicJavaDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArr1 = new int[]{1, 2, 3}; //has 3 int in the arr with value = 1, 2, 3
		int[] intArr2 = new int[3]; //has 3 values of 0, 0, 0
		intArr2[0] = 1; intArr2[1] = 2; intArr2[2] = 3; 
		
		char[] charArr1 = new char[]{'a', 'b', 'c'}; //has 3 int in the arr with value = 1, 2, 3
		char[] charArr2 = new char[3]; //has 3 values of null

		String s1 = "dog";
		String s2 = "cat";
		String s3 = "monkey";
		String[] newSVal1 = new String[]{s1, s2, s3};
		String[] newSVal4 = new String[]{"dog", "cat", "monkey"};
		String[] newSVal = monday(s1, s2, s3);
		
		String[] strArr1 = new String[3]; //has 3 values of null		
		String[] newSVal2;
		newSVal2 = new String[3];
		newSVal2[0] = s1;
		newSVal2[1] = s2;
		newSVal2[2] = s3;
		
		ArrayList<String> newSVal3 = tuesday(s1, s2, s3, "tom", "bay area");
		for (String n : newSVal3) {
			System.out.print(n + ", ");
		}
		
		apple(newSVal1);
		
		int[] a = new int[]{1, 3, 5, 8};
		int[] b = new int[]{2, 4, 6};
		System.out.println(combineTwoIntArr(a,  b));;
	}
	
	public static int[] combineTwoIntArr(int[] arr1, int[] arr2) {
		int aCount = arr1.length;
		int bCount = arr2.length;
 		int[] res = new int[aCount + bCount];
 		for(int i=0; i<aCount; i++) {
 			res[i] = arr1[i];
 		}
 		for(int i=0; i<bCount; i++) {
 			res[aCount+i] = arr2[i];
 		}
		return res;
	}
	
	public static void apple(String[] strArr) {
		for(String n : strArr) {
			System.out.print("apple method: ");
			System.out.println(n);
		}
	}
	public static String[] monday(String s1, String s2, String s3) {		
		String[] newSList = new String[3];
		newSList[0] = s1;
		newSList[1] = s2;
		newSList[2] = s3;		
		System.out.println(newSList); // = newSList(s1, s2, s3);		
		return newSList;
	}
	
	public static ArrayList<String> tuesday(String... numStrings) {		
		ArrayList<String> newSList = new ArrayList<>();
		
//		newSList.add(s1); newSList.add(s2); newSList.add(s3); // method 1
		newSList.addAll(Arrays.asList(numStrings)); // method 2
		
		System.out.println(newSList);
		return newSList;
	}
	
	public static List<Integer> square(List<Integer> nums) {
		int len = nums.size();
		List<Integer> newArr = new ArrayList<>(len);
		List<Integer> newArr2 = new ArrayList<>(len);
		for(int n : nums) {
			newArr.add(n*n);
		}
		for(int i=0; i<len; i++) {
			newArr2.add(nums.get(i) * 3);
		}
		newArr.addAll(newArr2);
		return newArr;
	}
}
