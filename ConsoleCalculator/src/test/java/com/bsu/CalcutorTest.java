package com.bsu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalcutorTest {
    private static Calculator calculator;
    @BeforeClass
    public static void initCalculator() { // static обязателен
        calculator = new Calculator();
    }
    @Test
    public void differenceOfNineteenAndTwo() {
        Double actual = calculator.calculateExpression("19-2");
        Assert.assertEquals(actual,17.0);
    }

    @Test
    public void differenceOfNineAndTwentynine() {
        Double actual = calculator.calculateExpression("9-29");
        Assert.assertEquals(actual,-20.0);
    }
    @Test
    public void sumOfEightAndSix() {
        Double actual = calculator.calculateExpression("8+7");
        Assert.assertEquals(actual,15.0);
    }
    @Test
    public void differenceOfEightOThertyOneAndFourOSixtyNine() {
        Double actual = calculator.calculateExpression("8.31-4.69");
        Assert.assertEquals(actual,3.62);
    }

    @Test
    public void multiplicationOfSevenAndSix() {
        Double actual = calculator.calculateExpression("7*6");
        Assert.assertEquals(actual,42.0);
    }

    @Test
    public void multiplicationOfSixOTwentyOneAndTwoOFiftyNine() {
        Double actual = calculator.calculateExpression("6.21*2.59");
        Assert.assertEquals(actual,16.0839);
    }

    @Test
    public void divisionTenToFive() {
        Double actual = calculator.calculateExpression("10/5");
        Assert.assertEquals(actual,2.0);
    }

    @Test
    public void illegalSymbollInExpression() {
        Double actual = calculator.calculateExpression("10a/5");
        Assert.assertEquals(actual,-1.0E7);
    }
    @Test
    public void negativeNumber() {
        Double actual = calculator.calculateExpression("-10/5");
        Assert.assertEquals(actual,-1.0E7);
    }
    @Test
    public void wrongOrderOfParenthesis() {
        Double actual = calculator.calculateExpression("(13+5))");
        Assert.assertEquals(actual,-1.0E7);
    }
    @Test
    public void wrongOrderOfParenthesisTwo() {
        Double actual = calculator.calculateExpression("(13+5)(");
        Assert.assertEquals(actual,-1.0E7);
    }
    @Test
    public void whitespaces() {
        Double actual = calculator.calculateExpression("(13+ 5)-(12/5)*12 - 13 ");
        Assert.assertEquals(actual,-23.799999999999997);
    }





}