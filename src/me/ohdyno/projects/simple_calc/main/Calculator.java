package me.ohdyno.projects.simple_calc.main;

import me.ohdyno.projects.simple_calc.operation.main.IllegalOperationException;
import me.ohdyno.projects.simple_calc.operation.main.OperationOrders;
import me.ohdyno.projects.simple_calc.operation.main.Operation;

/**
 * An Calculator that can solve basic math expressions.
 * Supported operations: +, -, *, /
 * The expression cannot contain spaces or parenthesis.
 *
 * Created by Xing Zhou (@ohdyno) on 11/15/16.
 */
public class Calculator {
    public double solve(String expression) throws IllegalOperationException {
        return evaluate(expression, OperationOrders.first());
    }

    private double evaluate(String expression, Operation operation) throws IllegalOperationException {
        if (operation == null)
            return new Double(expression);

        String[] operands = expression.split(operation.symbol());
        return reduce(operation, operands);
    }

    private double reduce(Operation operation, String[] operands) throws IllegalOperationException {
        Operation nextOperation = OperationOrders.successor(operation);
        double sum = evaluate(operands[0], nextOperation);
        for (int i = 1; i < operands.length; i++) {
            Double operand = evaluate(operands[i], nextOperation);
            sum = operation.calculate(sum, operand);
        }
        return sum;
    }
}
