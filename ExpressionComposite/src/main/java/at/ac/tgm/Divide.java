package at.ac.tgm;
public class Divide extends BinaryOperation {

	public Divide(Expression l, Expression r) {
		super(l, r);
	}

	@Override
	public double evaluate() {
		if (right.evaluate() == 0) {
			throw new ArithmeticException("Division by zero");
		}
		return left.evaluate() / right.evaluate();
	}

	@Override
	public String toString() {
		return "(" + left + " / " + right + ")";
	}

}
