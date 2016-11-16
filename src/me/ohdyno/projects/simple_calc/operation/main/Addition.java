package me.ohdyno.projects.simple_calc.operation.main;

/**
 * Created by Xing Zhou (@ohdyno) on 11/16/16.
 */
public class Addition implements Operation {
    public static final String SYMBOL = "\\+";

    @Override
    public double calculate(double operand1, double operand2) {
        return operand1 + operand2;
    }

    @Override
    public String symbol() {
        return SYMBOL;
    }
}
