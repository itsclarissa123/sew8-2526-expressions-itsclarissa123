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

	@Override
	public void buildString(StringBuilder sb) {
		sb.append("min(");
		for (int i = 0; i < expressions.size(); i++) {
			expressions.get(i).buildString(sb);
			if (i < expressions.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
	}
}
