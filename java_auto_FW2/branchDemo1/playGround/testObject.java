package playGround;

public class testObject {

	public static Object[][] getDataFromDataprovider() {
		return new Object[][] { { "Guru99", "India" }, { "Krishna", "UK" }, { "Bhupesh", "USA" } };
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		        
		/*int[][] rubyCube= new int[3][3];
		rubyCube[0][0] = 1;
		rubyCube[0][1] = 2;
		rubyCube[1][0] = 3;
		rubyCube[1][1] = 4;
		*/
		
		int[][] rubyCube= new int[3][6];		
		populate(3, rubyCube);
		printCube(rubyCube);
		
		printString(getDataFromDataprovider());
	}
	
	public static void populate(int n, int[][] rubyCube) {
		for (int r = 0; r<rubyCube.length; r++) {
			for (int c = 0; c<rubyCube[r].length; c++) {
				rubyCube[r][c] = n;	
			}	
		}
	}

	public static void printCube(int[] newCube) {
		for (int r = 0; r<newCube.length; r++) {
			System.out.println(newCube[r]);
		}		
	}
	
	public static void printCube(int[][] rubyCube) {
		for (int r = 0; r<rubyCube.length; r++) {
			for (int c = 0; c<rubyCube[r].length; c++) {
				System.out.print(rubyCube[r][c]);
			}
			System.out.println();
		}	
	}
	
	public static void printString(Object[][] stringObject) {
		for (int r = 0; r<stringObject.length; r++) {
			for (int c = 0; c<stringObject[r].length; c++) {
				System.out.println(stringObject[r][c]);
			}
			System.out.println();
		}	
	}
}
