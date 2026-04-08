package at.ac.tgm;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        stringBuilderTest();
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
}