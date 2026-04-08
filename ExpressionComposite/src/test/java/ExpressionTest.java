import at.ac.tgm.*;
import at.ac.tgm.Number;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {

    @Test
    @DisplayName("01 - Test Number (Evaluation und toString)")
    void testNumber() {
        Expression n = new Number(5);
        assertEquals(5, n.evaluate());
        assertEquals("5.0", n.toString0());
    }

    @Test
    @DisplayName("02 - Test Addition")
    void testAdd() {
        Expression expr = new Add(new Number(2), new Number(3));
        assertEquals(5, expr.evaluate());
        assertEquals("(2.0+3.0)", expr.toString0());
    }

    @Test
    @DisplayName("03 - Test Subtraction")
    void testSubtract() {
        Expression expr = new Subtract(new Number(5), new Number(3));
        assertEquals(2, expr.evaluate());
    }

    @Test
    @DisplayName("04 - Test Multiplication")
    void testMultiply() {
        Expression expr = new Multiply(new Number(4), new Number(3));
        assertEquals(12, expr.evaluate());
    }

    @Test
    @DisplayName("05 - Test Division")
    void testDivide() {
        Expression expr = new Divide(new Number(10), new Number(2));
        assertEquals(5, expr.evaluate());
    }

    @Test
    @DisplayName("06 - Test Division durch 0 (Exception)")
    void testDivideByZero() {
        Expression expr = new Divide(new Number(10), new Number(0));
        assertThrows(ArithmeticException.class, expr::evaluate);
    }

    @Test
    @DisplayName("07 - Test Potenzfunktion")
    void testPower() {
        Expression expr = new Power(new Number(2), new Number(3));
        assertEquals(8, expr.evaluate());
    }

    @Test
    @DisplayName("08 - Test negative Zahlen")
    void testNegativeNumber() {
        Expression expr = new Number(-5);
        assertEquals(-5, expr.evaluate());
        assertEquals("-5.0", expr.toString0());
    }

    @Test
    @DisplayName("09 - Test zur Überprüfung von Min/Max (Min)")
    void testMin() {
        Expression expr = new Min(List.of(
                new Number(3),
                new Number(1),
                new Number(5)
        ));
        assertEquals(1, expr.evaluate());
        assertTrue(expr.toString0().contains("min"));
    }

    @Test
    @DisplayName("10 - Test zur Überprüfung von Min/Max (Max)")
    void testMax() {
        Expression expr = new Max(List.of(
                new Number(3),
                new Number(1),
                new Number(5)
        ));
        assertEquals(5, expr.evaluate());
        assertTrue(expr.toString0().contains("max"));
    }

    @Test
    @DisplayName("11 - Test Min mit nur einem Element")
    void testMinSingle() {
        Expression expr = new Min(List.of(new Number(7)));
        assertEquals(7, expr.evaluate());
    }

    @Test
    @DisplayName("12 - Test Max mit nur einem Element")
    void testMaxSingle() {
        Expression expr = new Max(List.of(new Number(7)));
        assertEquals(7, expr.evaluate());
    }

    @Test
    @DisplayName("13 - Test verschachtelte Ausdrücke (Evaluation)")
    void testNestedExpressionEvaluation() {
        Expression expr = new Add(
                new Number(2),
                new Multiply(new Number(3), new Number(4))
        );
        assertEquals(14, expr.evaluate());
    }

    @Test
    @DisplayName("14 - Test komplexe Min/Max Kombination")
    void testComplexMinMax() {
        Expression expr = new Max(List.of(
                new Min(List.of(new Number(2), new Number(8))),
                new Number(5)
        ));
        assertEquals(5, expr.evaluate());
    }

    @Test
    @DisplayName("15 - Test verschachtelte Ausdrücke (toString)")
    void testNestedExpressionToString() {
        Expression expr = new Add(
                new Number(2),
                new Multiply(new Number(3), new Number(4))
        );
        assertEquals("(2.0+(3.0*4.0))", expr.toString0());
    }

    @Test
    @DisplayName("16 - Test komplexer Ausdruck enthält Max")
    void testComplexExpressionContainsMax() {
        Expression expr = new Max(List.of(
                new Add(new Number(1), new Number(2)),
                new Multiply(new Number(3), new Number(4))
        ));
        assertTrue(expr.toString0().contains("max"));
    }
    @Test
    @DisplayName("EK01 - Test einfache Addition")
    void testSimpleAddition() {
        Expression expr = PostfixParser.parse("2 3 +");

        assertEquals(5, expr.evaluate(), 0.0001);
        assertEquals("(2.0+3.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK02 - Test komplexer Ausdruck")
    void testComplexExpression() {
        Expression expr = PostfixParser.parse("2 3 4 * +");

        assertEquals(14, expr.evaluate(), 0.0001);
        assertEquals("(2.0+(3.0*4.0))", expr.toString0());
    }

    @Test
    @DisplayName("EK03 - Test Multiply then Add")
    void testMultiplyThenAdd() {
        Expression expr = PostfixParser.parse("2 3 + 4 *");

        assertEquals(20, expr.evaluate(), 0.0001);
        assertEquals("((2.0+3.0)*4.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK04 - Test Unary Minus")
    void testUnaryMinus() {
        Expression expr = PostfixParser.parse("5 ~");

        assertEquals(-5, expr.evaluate(), 0.0001);
        assertEquals("(0.0-5.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK05 - Test Sin Funktion")
    void testSinFunction() {
        Expression expr = PostfixParser.parse("0 sin");

        assertEquals(0, expr.evaluate(), 0.0001);
        assertEquals("sin(0.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK06 - Test Cos Funktion")
    void testCosFunction() {
        Expression expr = PostfixParser.parse("0 cos");

        assertEquals(1, expr.evaluate(), 0.0001);
        assertEquals("cos(0.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK07 - Test Ln Funktion")
    void testLnFunctionEK() {
        Expression expr = PostfixParser.parse("1 ln");

        assertEquals(0, expr.evaluate(), 0.0001);
        assertEquals("ln(1.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK08 - Test Power")
    void testPowerEK() {
        Expression expr = PostfixParser.parse("2 3 ^");

        assertEquals(8, expr.evaluate(), 0.0001);
        assertEquals("(2.0^3.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK09 - Test Min")
    void testMinEK() {
        Expression expr = PostfixParser.parse("2 3 min");

        assertEquals(2, expr.evaluate(), 0.0001);
        assertEquals("min(2.0, 3.0)", expr.toString0());
    }

    @Test
    @DisplayName("EK10 - Test Max")
    void testMaxEK() {
        Expression expr = PostfixParser.parse("2 3 max");

        assertEquals(3, expr.evaluate(), 0.0001);
        assertEquals("max(2.0, 3.0)", expr.toString0());
    }
}