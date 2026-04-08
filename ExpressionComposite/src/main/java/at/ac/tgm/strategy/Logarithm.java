package at.ac.tgm.strategy;

public class Logarithm implements FunctionStrategy {
    public double apply(double x) {
        return Math.log(x);
    }
    public String getName() {
        return "ln";
    }
}