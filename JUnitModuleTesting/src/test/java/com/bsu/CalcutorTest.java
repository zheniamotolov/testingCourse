package com.bsu;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by eugene on 10/23/17.
 */
public class CalcutorTest {
    private static Calculator calculator;
    @BeforeClass
    public static void initCalculator() { // static обязателен
        calculator = new Calculator();
    }
    @Test
    public void sumOfSevenAndSix() {
        Double actual = calculator.calculateExpression("7+6");
        Assert.assertEquals(actual,13.0);
    }

    @Test
    public void differenceOfNineAndTwo() {
        Double actual = calculator.calculateExpression("9-2");
        Assert.assertEquals(actual,7.0);
    }

    @Test
    public void differenceOfNineAndTen() {
        Double actual = calculator.calculateExpression("9-10");
        Assert.assertEquals(actual,-1.0);
    }

    @Test
    public void differenceOfSixOTwentyOneAndTwoOFiftyNine() {
        Double actual = calculator.calculateExpression("6.21-2.59");
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
    public void divisionTenToSeven() {
        Double actual = calculator.calculateExpression("10/7");
        Assert.assertEquals(actual,1.4285714285714286);
    }

    @Test
    public void threeMultiplyByOPTwoPlusSixCP() {
        Double actual = calculator.calculateExpression("3*(2+6)");
        Assert.assertEquals(actual,24.0);
    }

    @Test
    public void threeMultiplyByOPTwoMinusSixCP() {
        Double actual = calculator.calculateExpression("3*(2-6)");
        Assert.assertEquals(actual,-12.0);
    }

    @Test(expectedExceptions = DivisionByZeroException.class)
    public void divisionByZeroException() {
        Double actual = calculator.calculateExpression("10/0");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void symbolAinTestString() {
        Double actual = calculator.calculateExpression("2+a-3");
    }


}