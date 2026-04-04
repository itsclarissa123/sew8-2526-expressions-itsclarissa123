public abstract class UnaryOperation implements Expression, Expression {

	private Expression operand;

	private char operator;

	public UnaryOperation(String operator, Expression operand) {

	}


	/**
	 * @see Expression#evaluate()
	 */
	public double evaluate() {
		return 0;
	}


	/**
	 * @see Expression#toString()
	 */
	public String toString() {
		return null;
	}

}
