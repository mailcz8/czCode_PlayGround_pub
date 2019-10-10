package codingBat;

public class CodingBat4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(repeatSeparator("Word", "X", 3));
		System.out.println(nTwice("Chocolate", 3));
	}

	public static String nTwice(String str, int n) {
		String subA, subB;
		int len = str.length();
		String newS = "";
		if(len>=n) {
			for(int i=0; i<len; i++) {
				subA = str.substring(0, n);
				subB = str.substring(len-n, len);
				newS = subA + subB;
			}
			return newS;
		}else {
		return "no good";
		}
	}

	public static boolean endsLy(String str) {
		  String lastTwo = str.substring(str.length()-2, str.length());
		  System.out.println(lastTwo);
		  return true;
		}
	
	public static String repeatSeparator(String word, String sep, int count) {
		String newS = "";
		for (int i = 0; i<count; i++) {
			newS = newS + word + sep;
		}
		return newS;
	}

}
