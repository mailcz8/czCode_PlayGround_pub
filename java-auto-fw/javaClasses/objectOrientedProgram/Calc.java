package objectOrientedProgram;

public class Calc {

	private double x, y;

	Calc(double a, double b) {
		x = a;
		y = b;
	}

	public double add() {
		return x + y;
	}

	public double mult() {
		return x * y;
	}

	public double subt() {
		return x - y;
	}

	public double div() {
		return x / y;
	}
	
	public double pert() {
		return x % y;
	}
}
