package at.ac.tgm;

public class Number implements Expression {

	private double value;

	public Number(double value) {
		this.value = value;
	}


	/**
	 * @see Expression#evaluate()
	 */
	@Override
	public double evaluate() {
		return value;
	}


	/**
	 * @see Expression#toString()
	 */
	public String toString() {
		return String.valueOf(value);
	}

}
