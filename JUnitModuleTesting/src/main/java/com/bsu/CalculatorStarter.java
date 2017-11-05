package com.bsu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by eugene on 11/5/17.
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
            try {
                System.out.println(calculator.calculateExpression((input)));
            }catch (Exception e){
                System.err.println(e.getMessage());
            }

        }
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}
