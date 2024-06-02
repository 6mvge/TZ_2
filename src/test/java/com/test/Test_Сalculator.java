package com.test;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class Test_Сalculator {

    private ArrayList<Long> numbers;
    @BeforeEach

    void setUp() throws IOException {
        numbers = Calculator.readNumbersFromFile("test.txt");

    }
    @Test
    void testGetMin() throws IOException {
        assertEquals(-101, Calculator.getMin(numbers));
        System.out.println("testGetMin passed");
    }

    @Test
    void testGetMax() {
        assertEquals(228, Calculator.getMax(numbers));
        System.out.println("testGetMax passed");
    }

    @Test
    void testGetSum() throws IOException {
        assertEquals("280", Calculator.getSum(numbers));
        System.out.println("testGetSum passed");
    }

    @Test
    void testGetMult() {
        assertEquals("410652290664", Calculator.getMult(numbers));
        System.out.println("testGetMult passed");
    }

    @Disabled
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void timeoutTest() throws IOException {
        ArrayList<Long> bigSize = Calculator.readNumbersFromFile("test_numbers_size_10000000.txt");
        Calculator.getSum(bigSize);
    }


}
