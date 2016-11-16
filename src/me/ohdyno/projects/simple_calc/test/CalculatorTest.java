package me.ohdyno.projects.simple_calc.test;

import junit.framework.TestCase;
import me.ohdyno.projects.simple_calc.main.Calculator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test that Calculator can correctly solve simple math
 * expressions.
 *
 * The expressions cannot contain spaces or parentheses.
 * The numbers must also be positive numbers.
 *
 * Supported operations: +, -, *, /
 *
 * Created by Xing Zhou (@ohdyno) on 11/16/16.
 */
public class CalculatorTest {
    private static final double DELTA = 0.000001;
    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void textJustNumber() throws Exception {
        TestCase.assertEquals(2.0, calculator.solve("2"), DELTA);
    }

    @Test
    public void testAdd() throws Exception {
        TestCase.assertEquals(1 + 5, calculator.solve("1+5"), DELTA);
    }

    @Test
    public void testMultipleAdds() throws Exception {
        TestCase.assertEquals(1 + 5 + 8, calculator.solve("1+5+8"), DELTA);
    }

    @Test
    public void testSubtract() throws Exception {
        TestCase.assertEquals(1 - 5, calculator.solve("1-5"), DELTA);
    }

    @Test
    public void testAddThenSubtract() throws Exception {
        TestCase.assertEquals(1 + 5 - 120, calculator.solve("1+5-120"), DELTA);
    }

    @Test
    public void testSubtractThenAdd() throws Exception {
        TestCase.assertEquals(1 - 5 + 120, calculator.solve("1-5+120"), DELTA);
    }

    @Test
    public void testMultiply() throws Exception {
        TestCase.assertEquals(4 * 5, calculator.solve("4*5"), DELTA);
    }

    @Test
    public void testAddThenMultiple() throws Exception {
        TestCase.assertEquals(2 + 5 * 11, calculator.solve("2+5*11"), DELTA);
    }

    @Test
    public void testSubtractThenMultiply() throws Exception {
        TestCase.assertEquals(4 - 12 * 11, calculator.solve("4-12*11"), DELTA);
    }

    @Test
    public void testAddThenSubtractThenMultiply() throws Exception {
        TestCase.assertEquals(10 + 5 - 12 * 11, calculator.solve("10+5-12*11"), DELTA);
    }

    @Test
    public void testSubtractThenAddThenMultiply() throws Exception {
        TestCase.assertEquals(10 - 5 + 12 * 11, calculator.solve("10-5+12*11"), DELTA);
    }

    @Test
    public void testSubtractThenMultiplyThenAdd() throws Exception {
        TestCase.assertEquals(10 - 5 * 12 + 11, calculator.solve("10-5*12+11"), DELTA);
    }

    @Test
    public void testMultiplyThenSubtractThenAdd() throws Exception {
        TestCase.assertEquals(10 * 5 - 12 + 11, calculator.solve("10*5-12+11"), DELTA);
    }

    @Test
    public void testDivide() throws Exception {
        TestCase.assertEquals(12 / 2.0, calculator.solve("12/2"), DELTA);
    }

    @Test
    public void testDivideThenMultiply() throws Exception {
        TestCase.assertEquals(12 / 2.0 * 5, calculator.solve("12/2*5"), DELTA);
    }

    @Test
    public void testMultiplyThenDivide() throws Exception {
        TestCase.assertEquals(12 * 2.0 / 5, calculator.solve("12*2/5"), DELTA);
    }

    @Test
    public void testMultiplyThenDivideThenAdd() throws Exception {
        TestCase.assertEquals(12 * 2.0 / 5 + 11, calculator.solve("12*2/5+11"), DELTA);
    }

    @Test
    public void testExample() throws Exception {
        TestCase.assertEquals(23.5, calculator.solve("2*3+5/6*3+15"), DELTA);
    }
}