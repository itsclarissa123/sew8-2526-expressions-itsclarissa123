package at.ac.tgm.strategy;

public class Cosinus implements FunctionStrategy {
    public double apply(double x) {
        return Math.cos(x);
    }
    public String getName() {
        return "cos";
    }
}
