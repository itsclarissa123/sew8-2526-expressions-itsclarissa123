package at.ac.tgm;

import java.util.List;

public class Min implements Expression {
	private List<Expression> expressions;

	public Min(List<Expression> expressions) {
		this.expressions = expressions;
	}

	public double evaluate() {
		return expressions.stream()
				.mapToDouble(Expression::evaluate)
				.min()
				.orElse(0);
	}

	public String toString() {
		return "min(" + expressions + ")";
	}
}
