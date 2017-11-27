package com.bsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 калькулятор поддерживает:
 скобки, нецелочисленные числа,операции сложения вычитания деления умножения,пробелы
 калькулятор поддерживает:
 явное приведение чилсла к положительному или отрицательному ввиду
 */
public class CalculatorStarter {
    public static void main(String[] args) throws IOException {
        String input="";
        Calculator calculator = new Calculator();
        while (true) {
            System.out.print("Enter infix: ");
            input = getString();
            if (input.equals("")) {
                break;
            }
                System.out.println(calculator.calculateExpression((input)));
        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
