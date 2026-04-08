
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
		int x = 0;
		sb.append("max(");
		for (Expression expression : expressions) {
			expression.buildString(sb);
			if(expressions.size() > x) {
				sb.append(", ");
				x++;
			}
		}
		sb.append(")");
	}
}
