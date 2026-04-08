package at.ac.tgm;
public class Add extends BinaryOperation {
	public Add(Expression l, Expression r) {
		super(l, r);
	}

	@Override
	public double evaluate() {
		return left.evaluate() + right.evaluate();
	}

	@Override
	public void buildString(StringBuilder builder) {
		builder.append('(');
		left.buildString(builder);
		builder.append('+');
		right.buildString(builder);
		builder.append(')');
	}
}
