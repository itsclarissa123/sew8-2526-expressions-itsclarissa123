package at.ac.tgm.strategy;

import java.io.Serializable;

public class Sinus implements FunctionStrategy {
    public double apply(double x){
        return Math.sin(x);
    }

    public String getName() {
        return "sin";
    }
}
