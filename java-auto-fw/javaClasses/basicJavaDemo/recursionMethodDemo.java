package basicJavaDemo;

public class recursionMethodDemo {

	public static void main(String[] args) {
		String str = "cat";
//		printBacward(str, 0);

		int[] iArr = new int[] {1,2,3,4,5,6,7,8,9,10};
		int end = iArr.length-1;
		System.out.println(recursionSearch(0, end, iArr, 9));;
	}

	public static void printBacward(String str, int i) {		
		if(i == str.length()) return;
		printBacward(str, i+1);
		System.out.print(str.charAt(i));
	}
	
	public static int recursionSearch(int begin, int end, int[] iArr, int target) {
		int mid = (begin + end)/2;		
		if(begin>end) {
			return -1;
		}	
		if(iArr[mid] == target) {
			return mid;
		}
		if(iArr[mid] < target) {
			return recursionSearch(begin, mid-1, iArr, target);
		}
		return recursionSearch(mid+1, end, iArr, target);		
	}
}
