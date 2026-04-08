package at.ac.tgm;
public class Multiply extends BinaryOperation {

	public Multiply(Expression l, Expression r) {
        super(l,r);
	}

	@Override
	public double evaluate() {
		return left.evaluate() * right.evaluate();
	}

	@Override
	public void buildString(StringBuilder sb) {
		sb.append('(');
		left.buildString(sb);
		sb.append('*');
		right.buildString(sb);
		sb.append(')');
	}
}
