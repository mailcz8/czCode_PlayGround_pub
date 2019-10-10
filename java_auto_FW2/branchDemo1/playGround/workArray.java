package playGround;

public class workArray {

	public static void main(String[] args) {
		int value = 7;
		int[] values;
		values = new int[3];
		System.out.println("Print: " + values[0]);
		
		values[0] = 3;
		values[1] = 33;

		System.out.println("Print: " + values[0]);
		System.out.println("Print: " + values[1]);
		System.out.println("Print: " + values[2]);
		
		for (int i=0; i<values.length; i++){
			System.out.println("Print: " + values[i]);
		}
		
		int[] numbers = {5, 6, 7};
		numbers[2] = 8;
		for (int i=0; i<numbers.length; i++){
			System.out.println(numbers[i]);
		}
	}
}
