import at.ac.tgm.*;
import at.ac.tgm.Number;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ExpressionTest {

    @Test
    void testNumber() {
        Expression n = new Number(5);
        assertEquals(5, n.evaluate());
        assertEquals("5.0", n.toString0());
    }

    @Test
    void testAdd() {
        Expression expr = new Add(new Number(2), new Number(3));
        assertEquals(5, expr.evaluate());
    }

    @Test
    void testSubtract() {
        Expression expr = new Subtract(new Number(5), new Number(3));
        assertEquals(2, expr.evaluate());
    }

    @Test
    void testMultiply() {
        Expression expr = new Multiply(new Number(4), new Number(3));
        assertEquals(12, expr.evaluate());
    }

    @Test
    void testDivide() {
        Expression expr = new Divide(new Number(10), new Number(2));
        assertEquals(5, expr.evaluate());
    }

    @Test
    void testDivideByZero() {
        Expression expr = new Divide(new Number(10), new Number(0));
        assertThrows(ArithmeticException.class, expr::evaluate);
    }

    @Test
    void testPower() {
        Expression expr = new Power(new Number(2), new Number(3));
        assertEquals(8, expr.evaluate());
    }

    @Test
    void testNegativeNumber() {
        Expression expr = new Number(-5);
        assertEquals(-5, expr.evaluate());
        assertEquals("-5.0", expr.toString0());
    }

    @Test
    void testMin() {
        Expression expr = new Min(List.of(
                new Number(3),
                new Number(1),
                new Number(5)
        ));
        assertEquals(1, expr.evaluate());
    }

    @Test
    void testMax() {
        Expression expr = new Max(List.of(
                new Number(3),
                new Number(1),
                new Number(5)
        ));
        assertEquals(5, expr.evaluate());
    }

    @Test
    void testMinSingle() {
        Expression expr = new Min(List.of(new Number(7)));
        assertEquals(7, expr.evaluate());
    }

    @Test
    void testMaxSingle() {
        Expression expr = new Max(List.of(new Number(7)));
        assertEquals(7, expr.evaluate());
    }

    @Test
    void testNestedExpression() {
        Expression expr = new Add(
                new Number(2),
                new Multiply(new Number(3), new Number(4))
        );
        assertEquals(14, expr.evaluate());
    }

    @Test
    void testComplexMinMax() {
        Expression expr = new Max(List.of(
                new Min(List.of(new Number(2), new Number(8))),
                new Number(5)
        ));
        assertEquals(5, expr.evaluate());
    }

    @Test
    void testtoString0Add() {
        Expression expr = new Add(new Number(2), new Number(3));
        assertEquals("(2.0 + 3.0)", expr.toString0());
    }

    @Test
    void testtoString0Nested() {
        Expression expr = new Add(
                new Number(2),
                new Multiply(new Number(3), new Number(4))
        );
        assertEquals("(2.0 + (3.0 * 4.0))", expr.toString0());
    }

    @Test
    void testtoString0MinMax() {
        Expression expr = new Min(List.of(
                new Number(1),
                new Number(2)
        ));
        assertTrue(expr.toString0().contains("min"));
    }

    @Test
    void testComplexExpressionString() {
        Expression expr = new Max(List.of(
                new Add(new Number(1), new Number(2)),
                new Multiply(new Number(3), new Number(4))
        ));
        assertTrue(expr.toString0().contains("max"));
    }
}