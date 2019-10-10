package codingBat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CodingBat3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ab12";
		int[] intArr = new int[] {1, 2, 3, 4, 5};
		int[] intArr2 = new int[] {4, 5, 6, 7, 8, 9};
//		System.out.println(endOther("ab", str));
//		System.out.println(scores100(intArr));
//		maxEnd3(new int[] {1, 2, 3});
//		middleWay(intArr, intArr2);
//		makeLast(intArr2);
		arrayCount9(new int[]{1, 9, 9});
		
		List<Integer> newArr = new ArrayList<>();
		newArr.add(1); newArr.add(2); newArr.add(3); 
		System.out.println(square(newArr));		
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
	
	public static int arrayCount9(int[] nums) {
		int len = nums.length;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (nums[i] == 9) {
				count = count + 1;
			}
		}
		return count;
	}
	
	public static List<Integer> doubling(List<Integer> nums) {
//		int[] intArr = new int[] {2, 4, 5};
//		for (int i = 0; i < nums.size(); i++) {
//			nums.set(i, nums.get(i) * 2);
//		}
//		return nums;

		// OR the equivalent java streams solution:
		 return nums.stream()
		 .map(n -> n * 2)
		 .collect(Collectors.toList());
	}
	
	public static int[] makeLast(int[] nums) {
		  int len = nums.length+1;
		  int[] newArr = new int[len+1];
		  for(int i=0; i<len-1; i++) {
		    newArr[i] = 0;
		  }
		  newArr[len] = nums[len-1];
		  return newArr;
		}

	
	public static int[] middleWay(int[] a, int[] b) {
		int aLen = a.length/2;
		int bLen = b.length/2;
		int[] mid = new int[2];
		mid[0] = a[aLen];
		mid[1] = b[bLen];
		return mid;
	}
	
	public static boolean commonEnd(int[] a, int[] b) {
		int aLen = a.length - 1;
		int blen = b.length - 1;
		if (a[0] == b[0] || a[aLen] == b[blen])
			return true;
		return false;
	}

	public static int[] reverse3(int[] nums) {
		int len = nums.length;
		int[] newN = new int[len];
		for(int i=len-1; i>=0; i--) {
			for(int n=0; n<=len-1; n++) {
				newN[n] = nums[i];
			}			
		}
		return newN;
	}
	
	public static int[] maxEnd3(int[] nums) {
		int len = nums.length;
		int[] newN = new int[len];
		int currentMax = 0;
		for(int i=0; i<len; i++) {
			if(currentMax<nums[i]) {
			  currentMax = nums[i];
		  	}
		}
		for(int n=0; n<len; n++) {
		  newN[n] = currentMax;
		}
		return newN;
}
	
	public static boolean scores100(int[] scores) {
		int len = scores.length;
		if (len >= 2) {
			for (int i = 0; i < len - 1; i++) {
				if (scores[i] == scores[i + 1])
					return true;
			}
		}
		return false;
	}
	
	public static boolean scoresIncreasing(int[] scores) {
		int len = scores.length;
		int currentMax = scores[0];
		for(int i=0; i<len-1; i++) {
			if(scores[i] > scores[i+1]) {				
				return false;
			} 
		}
		return true;
	}
	
/*	public static List<Integer> noNeg(List<Integer> nums) {
		  nums.removeIf(n -> n < 0);
		  nums.replaceAll(n -> n < 0);
		  return nums;
		}
	
	public static List<Integer> noNeg2(List<Integer> nums) {
		   return nums.stream()
		     .filter(n -> n >= 0)
		     .collect(Collectors.toList());
	}
	
	public static List<Integer> doubling(List<Integer> nums) {
		List<Integer> nums = newresult;
		  nums = nums.stream()
		    .map(n -> n * 2)
		    .filter(n -> n >= 0)
		    .collect(Collectors.toList());
		  return nums;
	}*/
	
	public static boolean endOther(String a, String b) {
		a = a.toLowerCase();
		b = b.toLowerCase();
		int aCount = a.length();
		int bCount = b.length();
		if(aCount<bCount) {
			String bFront = b.substring(0,aCount);
			String bEnd = b.substring((b.length()-aCount),b.length());
			if(a.equals(bFront) || a.equals(bEnd)) {
				return true;
			}
		}else if(aCount>bCount){
			String aFront = a.substring(0,bCount);
			String aEnd = a.substring((a.length()-bCount),a.length());
			if(b.equals(aFront) || b.equals(aEnd)) {
				return true;
			}
		}else if(a.equals(b)) return true;
		return false;
	}
	
	public static int countCode(String str) {
		int count = 0;
		int len = str.length()-4;
		for(int i=0; i<=len; i++) {
			String newS = str.substring(i, (i+4));
			String pattern = "co[a-z]e"; // "co(\\w)e" 
			if(newS.matches("co.e")) {
				count = count + 1;
			}
		}		  
		return count;
	}

	public static boolean unlucky1(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 && nums[i + 1] == 3) {
				return true;
			}
		}
		return false;
	}
}
