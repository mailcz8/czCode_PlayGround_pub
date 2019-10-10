package objectOrientedProgram;

public class DoMath {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calc myCalc = new Calc(19,3);

		myCalc.add(); myCalc.mult(); myCalc.subt(); myCalc.div(); myCalc.pert();
		
		System.out.println("Add: " + myCalc.add());
		System.out.println("Mult: " + myCalc.mult());
		System.out.println("Sub: " + myCalc.subt());
		System.out.println("Sub: " + myCalc.div());
		System.out.println("Sub: " + myCalc.pert());
	}
}
