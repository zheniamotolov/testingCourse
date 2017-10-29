package com.bsu;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eugene on 10/23/17.
 */
public class CalcutorTest {
    @Test
    public void devison() throws Exception {

        assertEquals(2, Calculator.devison(12, 6));
    }

}