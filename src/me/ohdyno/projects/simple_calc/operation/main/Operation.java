package me.ohdyno.projects.simple_calc.operation.main;

/**
 * Created by Xing Zhou (@ohdyno) on 11/16/16.
 */
public interface Operation {
    double calculate(double operand1, double operand2);
    String symbol();
}
