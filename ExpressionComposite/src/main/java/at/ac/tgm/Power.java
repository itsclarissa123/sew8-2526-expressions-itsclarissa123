package at.ac.tgm;

public class Power extends BinaryOperation {
	public Power(Expression l, Expression r) {
		super(l, r);
	}

	public double evaluate() {
		return Math.pow(left.evaluate(), right.evaluate());
	}

	public String toString() {
		return "(" + left + " ^ " + right + ")";
	}
}
