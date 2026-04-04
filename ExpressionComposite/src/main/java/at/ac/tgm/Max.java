
package at.ac.tgm;

import java.util.List;

public class Max implements Expression {
	private List<Expression> expressions;

	public Max(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public double evaluate() {
		return expressions.stream()
				.mapToDouble(Expression::evaluate)
				.max()
				.orElse(0);
	}

	public String toString() {
		return "max(" + expressions + ")";
	}
}
