import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1Test {
    private Solution1 solution;

    @Before
    public void setUp() {
        solution = new Solution1();
    }

    @Test
    public void convertsFiniteDecimal() {
        assertEquals("-0.5", solution.fractionToDecimal(1, 2));
        assertEquals("0.125", solution.fractionToDecimal(1, 8));
    }

    @Test
    public void convertsIntegerResult() {
        assertEquals("2", solution.fractionToDecimal(2, 1));
        assertEquals("0", solution.fractionToDecimal(0, 7));
    }

    @Test
    public void enclosesRepeatingPartInParentheses() {
        assertEquals("0.(3)", solution.fractionToDecimal(1, 3));
        assertEquals("0.(012)", solution.fractionToDecimal(4, 333));
        assertEquals("0.1(6)", solution.fractionToDecimal(1, 6));
    }

    @Test
    public void handlesNegativeFractions() {
        assertEquals("-0.5", solution.fractionToDecimal(-1, 2));
        assertEquals("-0.5", solution.fractionToDecimal(1, -2));
        assertEquals("0.5", solution.fractionToDecimal(-1, -2));
    }

    @Test
    public void handlesIntegerBoundaries() {
        assertEquals("-2147483648", solution.fractionToDecimal(Integer.MIN_VALUE, 1));
        assertEquals("2147483648", solution.fractionToDecimal(Integer.MIN_VALUE, -1));
        assertEquals("0.0000000004656612873077392578125",
                solution.fractionToDecimal(-1, Integer.MIN_VALUE));
    }

    @Test(expected = ArithmeticException.class)
    public void rejectsZeroDenominator() {
        solution.fractionToDecimal(1, 0);
    }
}
