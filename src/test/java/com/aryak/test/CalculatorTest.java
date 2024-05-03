package com.aryak.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();


    @Test
    void add() {
        int actual = calculator.add(6,5);
        assertEquals(11, actual);
    }

    @Test
    void subtract() {
        int actual = calculator.subtract(6,5);
        assertEquals(1, actual);
    }

    @Test
    void multiply() {

        int actual = calculator.multiply(6,5);
        assertEquals(30, actual);

    }

    @Test
    void divide_by_zero() {
        assertThrows(DivisionByZeroException.class, ()->  calculator.divide(6,0));
    }

    @Test
    void divide() {

        int actual = calculator.divide(6,2);
        assertEquals(3, actual);
    }
}