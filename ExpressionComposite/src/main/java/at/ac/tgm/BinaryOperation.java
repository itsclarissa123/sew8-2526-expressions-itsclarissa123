public class BinaryOperation implements Expression {

	private Expression left;

	private Expression right;

	public BinaryOperation(Expression left, Expression right) {

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
