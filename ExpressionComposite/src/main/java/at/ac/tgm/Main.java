package at.ac.tgm;

import at.ac.tgm.strategy.Cosinus;
import at.ac.tgm.strategy.FunctionStrategy;
import at.ac.tgm.strategy.Logarithm;
import at.ac.tgm.strategy.Sinus;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        postfix();
    }

    public static void stringBuilderTest(){
        // Zahlen
        Expression a = new Number(2);
        Expression b = new Number(3);
        Expression c = new Number(4);

        // Add
        Expression add = new Add(a, b);
        System.out.println(add.toString0());

        // Subtract
        Expression sub = new Subtract(a, b);
        System.out.println(sub.toString0());

        // Multiply
        Expression mul = new Multiply(a, b);
        System.out.println(mul.toString0());

        // Divide
        Expression div = new Divide(a, b);
        System.out.println(div.toString0());

        // Power
        Expression pow = new Power(a, b);
        System.out.println(pow.toString0());

        // Verschachtelt
        Expression complex = new Add(
                new Multiply(a, b),
                new Multiply(b, c)
        );
        System.out.println(complex.toString0());

        // Min
        List<Expression> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        Expression min = new Min(list);
        System.out.println(min.toString0());

        // Max
        Expression max = new Max(list);
        System.out.println(max.toString0());
    }
    public static void functionTest(){
        Expression x = new Number(0);

        Expression sin = new FunctionStrag(x, new Sinus());
        System.out.println(sin.toString0()); // sin(0)
        System.out.println(sin.evaluate());  // 0.0

        Expression cos = new FunctionStrag(new Number(0), new Cosinus());
        System.out.println(cos.toString0()); // cos(0)

        Expression ln = new FunctionStrag(new Number(1), new Logarithm());
        System.out.println(ln.toString0()); // ln(1)
    }
    public static void postfix(){
        Expression expr1 = PostfixParser.parse("2 3 + 4 *");
        System.out.println(expr1);        // ((2 + 3) * 4)
        System.out.println(expr1.evaluate()); // 20

        Expression expr2 = PostfixParser.parse("2 3 4 * +");
        System.out.println(expr2.toString0());        // (2 + (3 * 4))

        Expression expr3 = PostfixParser.parse("5 ~");
        System.out.println(expr3.toString0());        // (0 - 5)

        Expression expr4 = PostfixParser.parse("0 sin");
        System.out.println(expr4.toString0());        // sin(0)
    }
}