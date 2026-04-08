package at.ac.tgm;

public class Power extends BinaryOperation {
	public Power(Expression l, Expression r) {
		super(l, r);
	}

	public double evaluate() {
		return Math.pow(left.evaluate(), right.evaluate());
	}

	@Override
	public void buildString(StringBuilder sb) {
		sb.append('(');
		left.buildString(sb);
		sb.append('^');
		right.buildString(sb);
		sb.append(')');
	}
}
