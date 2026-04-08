package at.ac.tgm;
import at.ac.tgm.strategy.*;

public class FunctionStrag implements Expression {
    private Expression inner;
    private FunctionStrategy strategy;

    public FunctionStrag(Expression inner, FunctionStrategy strategy) {
        this.inner = inner;
        this.strategy = strategy;
    }

    @Override
    public double evaluate() {
        return strategy.apply(inner.evaluate());
    }

    @Override
    public void buildString(StringBuilder sb) {
        sb.append(strategy.getName());
        sb.append("(");
        inner.buildString(sb);
        sb.append(")");
    }
}
