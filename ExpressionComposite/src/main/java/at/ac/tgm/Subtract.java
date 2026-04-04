package at.ac.tgm;
public class Subtract extends BinaryOperation {

	public Subtract(Expression l, Expression r) {
		super(l, r);
	}
	public double evaluate() {
		return left.evaluate() - right.evaluate();
	}

	public String toString() {
		return "(" + left + " - " + right + ")";
	}
}
