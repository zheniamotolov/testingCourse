package com.bsu;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

class Calculator {
    private Stack<Character> operatorsStack;
    private StringBuilder output;
    private Stack<Double> operandsStack;

    Calculator() {
        operatorsStack = new Stack<>();
        output = new StringBuilder();
        operandsStack = new Stack<>();
    }

    private String transformToReversePolishNotation(String input) throws Exception {
        output.setLength(0);
        operatorsStack.clear();
        int inputLength = input.length();
        for (int j = 0; j < inputLength; j++) {
            char ch = input.charAt(j);
            if (ch == ' ') {
                continue;
            }
            switch (ch) {
                case '+':
                case '-':
                    output.append(" ");
                    gotOperator(ch, operatorPriority(ch));

                    break;
                case '*':
                case '/':
                    output.append(" ");
                    gotOperator(ch, operatorPriority(ch));

                    break;
                case '(':
                    operatorsStack.push(ch);
                    break;
                case ')':
                    gotParensis();
                    break;
                case '.':

                    if (isNotIntegerNumber(input, j)) {
                        output.append(ch);
                    }
                    break;
                default:

                    if (isNumber(ch)) {
                        output.append(ch);
                    } else {
                        throw new IllegalArgumentException("недопустимый символ");


                    }
                    break;

            }

        }
        while (!operatorsStack.isEmpty()) {
            output.append(" ");
            output.append(operatorsStack.pop());

        }

        return output.toString();
    }

    private boolean isNotIntegerNumber(String input, int j) throws IndexOutOfBoundsException {

        if (isNumber(input.charAt(j - 1)) && isNumber(input.charAt(j + 1))) {
            return true;
        } else {
            throw new IndexOutOfBoundsException("недопустимый символ");

        }
    }

    private void gotOperator(char opThis, int prec1) {
        while (!operatorsStack.isEmpty()) {
            char opTop = operatorsStack.pop();
            if (opTop == '(') {
                operatorsStack.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-')
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1) {
                    operatorsStack.push(opTop);
                    break;
                } else
                    output.append(opTop);
                output.append(" ");
            }
        }
        operatorsStack.push(opThis);
    }

    private void gotParensis() throws  ParenthesisParseException,EmptyStackException {
        if (operatorsStack.size() == 0) {
            throw new ParenthesisParseException("Ошибка разбора скобок. Проверьте правильность выражения");

        }
        char ch = operatorsStack.pop();


        while ('(' != ch) {

            if (operatorsStack.size() < 1) {
                throw new ParenthesisParseException("Ошибка разбора скобок. Проверьте правильность выражения.");
            }
            output.append(" ");
            output.append(ch);
            ch = operatorsStack.pop();

        }


    }

    private boolean isNumber(char ch) {
        if ((ch >= '0' && ch <= '9')) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOperator(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
                return true;
        }
        return false;
    }

    private byte operatorPriority(char op) {
        switch (op) {
            case '*':
            case '/':
                return 2;
        }
        return 1;
    }

    public double calculateExpression(String inputString) {
        operandsStack.clear();
        try {
            String RPNstring = transformToReversePolishNotation(inputString);
            double num1 = 0, num2 = 0;
            String tempStr = "";
            StringTokenizer st = new StringTokenizer(RPNstring);
            while (st.hasMoreTokens()) {
                tempStr = st.nextToken();
                if (1 == tempStr.length() && isOperator(tempStr.charAt(0))) {
                    if (operandsStack.size() < 2) {
                        throw new Exception("Неверное количество данных в стеке ");
                    }
                    num2 = operandsStack.pop();
                    num1 = operandsStack.pop();
                    switch (tempStr.charAt(0)) {
                        case '+':
                            addition(num1, num2);
                            break;
                        case '-':
                            substraction(num1, num2);
                            break;
                        case '/':
                            division(num1, num2);
                            break;
                        case '*':
                            multiplication(num1, num2);
                            break;
                        default:
                            throw new NumberFormatException("Нарушена последовательность символов");
                    }
                } else {

                    try {
                        operandsStack.push(Double.parseDouble(tempStr));
                    } catch (NumberFormatException e) {
                        System.err.println("недопустимый символ в данном выражении");
                        return -10000000;
                    }
                }

            }

            if (operandsStack.size() > 1) {
                throw new Exception("Количество операторов не соответствует количеству операндов");
            }
        } catch (ParenthesisParseException e) {
            System.err.println(e.getMessage());
            return -10000000;
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return -10000000;
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return -10000000;
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            return -10000000;
        } catch (DivisionByZeroException e) {
            System.err.println(e.getMessage());
            return -10000000;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return -10000000;
        }
        return operandsStack.pop();
    }

    private void addition(double num1, double num2) {
        operandsStack.push(num1 + num2);
    }

    private void substraction(double num1, double num2) {
        operandsStack.push(num1 - num2);
    }

    private void multiplication(double num1, double num2) {
        operandsStack.push(num1 * num2);
    }

    private void division(double num1, double num2) throws DivisionByZeroException {

        if (num2 == 0) {
            throw new DivisionByZeroException("деление на ноль");
        }
        operandsStack.push(num1 / num2);

    }

}

