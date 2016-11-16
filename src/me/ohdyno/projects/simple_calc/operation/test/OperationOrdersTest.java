package me.ohdyno.projects.simple_calc.operation.test;

import junit.framework.TestCase;
import me.ohdyno.projects.simple_calc.operation.main.*;
import org.junit.Test;

/**
 * Tests the OperationOrders class to make sure that
 * the operation orders reflect (Java) mathematical
 * operation orderings.
 *
 * Created by Xing Zhou (@ohdyno) on 11/16/16.
 */
public class OperationOrdersTest {
    @Test
    public void testDivisionIsLastOperation() throws Exception {
        TestCase.assertNull(OperationOrders.successor(new Division()));
    }

    @Test
    public void testDivisionFollowsMultiplication() throws Exception {
        TestCase.assertEquals(Division.class, OperationOrders.successor(new Multiplication()).getClass());
    }

    @Test
    public void testMultiplicationFollowsSubtraction() throws Exception {
        TestCase.assertEquals(Multiplication.class, OperationOrders.successor(new Subtraction()).getClass());
    }

    @Test
    public void testSubtractionFollowsAddition() throws Exception {
        TestCase.assertEquals(Subtraction.class, OperationOrders.successor(new Addition()).getClass());
    }

    @Test
    public void testAdditionIsFirstOperation() throws Exception {
        TestCase.assertEquals(Addition.class, OperationOrders.first().getClass());
    }
}
