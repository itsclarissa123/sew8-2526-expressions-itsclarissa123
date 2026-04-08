package at.ac.tgm;

public interface Expression {

	double evaluate();
	void buildString(StringBuilder builder);

	default String toString0() {
		StringBuilder sb = new StringBuilder();
		buildString(sb);
		return sb.toString();
	}

}
