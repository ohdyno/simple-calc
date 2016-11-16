package me.ohdyno.projects.simple_calc.operation.main;

/**
 * Created by Xing Zhou (@ohdyno) on 11/16/16.
 */
public class OperationOrders {
    public static Operation successor(Operation before) throws IllegalOperationException {
        String operator = before.symbol();
        switch (operator) {
            case Subtraction.SYMBOL:
                return new Multiplication();
            case Addition.SYMBOL:
                return new Subtraction();
            case Multiplication.SYMBOL:
                return new Division();
            case Division.SYMBOL:
                return null;
        }

        throw new IllegalOperationException();
    }

    public static Operation first() {
        return new Addition();
    }
}
