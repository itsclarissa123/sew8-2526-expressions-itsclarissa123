package at.ac.tgm;

public class Number implements Expression {

	private double value;

	public Number(double value) {
		this.value = value;
	}

	@Override
	public double evaluate() {
		return value;
	}


	@Override
	public void buildString(StringBuilder sb) {
		sb.append(value);
	}
}