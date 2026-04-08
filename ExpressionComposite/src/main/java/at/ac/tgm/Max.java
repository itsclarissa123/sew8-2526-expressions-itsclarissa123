
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
	@Override
	public void buildString(StringBuilder sb) {
		sb.append("max(");
		for (int i = 0; i < expressions.size(); i++) {
			expressions.get(i).buildString(sb);
			if (i < expressions.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append(")");
	}
}
