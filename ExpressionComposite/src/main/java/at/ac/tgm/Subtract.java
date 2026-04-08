package at.ac.tgm;
public class Subtract extends BinaryOperation {

	public Subtract(Expression l, Expression r) {
		super(l, r);
	}

	public double evaluate() {
		return left.evaluate() - right.evaluate();
	}

	@Override
	public void buildString(StringBuilder sb) {
		sb.append('(');
		left.buildString(sb);
		sb.append('-');
		right.buildString(sb);
		sb.append(')');

	}
}