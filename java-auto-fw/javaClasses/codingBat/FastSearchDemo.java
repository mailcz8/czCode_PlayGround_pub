package codingBat;

public class FastSearchDemo {

	public static void main(String[] args) {
        int[] x = new int[] {1,2,3,4,5,6,7,8,9,20,40,50,100,200,210,210,1009,2000,2001};
        int[] y = {9,8,99,88,7};
//        System.out.println(makePi(y));
		System.out.println("x length = " + (x.length));
        System.out.println(binarySearch(103, x));
	}

	public static int binarySearch(int target, int[] nums) {		
		int begin = 0; 
		int end = nums.length-1;		
		while(begin<=end) {
			int midIndex = (begin + end)/2;
			int currentMid = nums[midIndex];
			if(target == currentMid) {
				return midIndex;
			}
			if(target>currentMid) {
				begin = midIndex+1;				
			}else if(target<currentMid) {
				end = midIndex-1;
			}
		}
		return -1;
	}
}
