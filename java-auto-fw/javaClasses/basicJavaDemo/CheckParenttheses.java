package basicJavaDemo;

public class CheckParenttheses {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isBalanced("( )(    )()()( )()");
		isBalanceTwo("()()()()()()");
	}

	public static boolean isBalanced(String input) {
		boolean result = true;
		int left = 0;
		int right = 0;
		char x;
		for(int i = 0; i<input.length(); i++) {
			x = input.charAt(i);
			if(String.valueOf(x).equals("(")) {
				left = left+1;
				System.out.println(left);
			} else if (String.valueOf(x).equals(")")) {
				right++;
				System.out.println(right);
			}  
			
			if (right > left) {
			System.out.println("returned false");
			return false;
			}	
		}
		
		if (left == right) {
			System.out.println("returned true");
			return true;
		} else {
			System.out.println("returned false");
			return false;
		}
	}
	
	public static boolean isBalanceTwo(String input) {
		boolean result = true;
		int left = 0;
		int right = 0;
		char x;
		for(int i = 0; i<input.length(); i++) {
			x = input.charAt(i);
			if(x == '(') {
				left = left+1;
				System.out.println(left);
			} else if (x == ')') {
				right++;
				System.out.println(right);
			}
			
			if (right > left) {
				System.out.println("returned false");
				return false;
			}
		}
		
		if (left == right) {
			System.out.println("returned true");
			return true;
		} else {
			System.out.println("returned false");
			return false;
		}
		
	}
}
