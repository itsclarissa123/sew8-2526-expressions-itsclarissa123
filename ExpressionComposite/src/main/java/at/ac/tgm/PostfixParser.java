package at.ac.tgm;

import at.ac.tgm.strategy.Cosinus;
import at.ac.tgm.strategy.Logarithm;
import at.ac.tgm.strategy.Sinus;

import java.util.*;

public class PostfixParser {

    public static Expression parse(String input) {
        List<Expression> stack = new ArrayList<>();

        String[] tokens = input.split(" ");

        for (String token : tokens) {

            switch (token) {

                case "+":
                    Expression bAdd = stack.remove(stack.size() - 1);
                    Expression aAdd = stack.remove(stack.size() - 1);
                    stack.add(new Add(aAdd, bAdd));
                    break;

                case "-":
                    Expression bSub = stack.remove(stack.size() - 1);
                    Expression aSub = stack.remove(stack.size() - 1);
                    stack.add(new Subtract(aSub, bSub));
                    break;

                case "*":
                    Expression bMul = stack.remove(stack.size() - 1);
                    Expression aMul = stack.remove(stack.size() - 1);
                    stack.add(new Multiply(aMul, bMul));
                    break;

                case "/":
                    Expression bDiv = stack.remove(stack.size() - 1);
                    Expression aDiv = stack.remove(stack.size() - 1);
                    stack.add(new Divide(aDiv, bDiv));
                    break;

                case "^":
                    Expression bPow = stack.remove(stack.size() - 1);
                    Expression aPow = stack.remove(stack.size() - 1);
                    stack.add(new Power(aPow, bPow));
                    break;

                case "min":
                    Expression bMin = stack.remove(stack.size() - 1);
                    Expression aMin = stack.remove(stack.size() - 1);
                    stack.add(new Min(Arrays.asList(aMin, bMin)));
                    break;

                case "max":
                    Expression bMax = stack.remove(stack.size() - 1);
                    Expression aMax = stack.remove(stack.size() - 1);
                    stack.add(new Max(Arrays.asList(aMax, bMax)));
                    break;

                case "~":
                    Expression aNeg = stack.remove(stack.size() - 1);
                    stack.add(new Subtract(new Number(0), aNeg));
                    break;

                case "sin":
                    Expression sin = stack.remove(stack.size() - 1);
                    stack.add(new FunctionStrag(sin, new Sinus()));
                    break;

                case "cos":
                    Expression cos = stack.remove(stack.size() - 1);
                    stack.add(new FunctionStrag(cos, new Cosinus()));
                    break;

                case "ln":
                    Expression ln = stack.remove(stack.size() - 1);
                    stack.add(new FunctionStrag(ln, new Logarithm()));
                    break;

                default:

                    stack.add(new Number(Double.parseDouble(token)));
                    break;
            }
        }

        return stack.get(0);
    }
}
