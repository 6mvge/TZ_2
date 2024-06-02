package com.test;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private ArrayList<Long> numbers;

    @BeforeEach
    void setUp() throws IOException {
        numbers =Calculator.readNumbersFromFile("test.txt");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMin() {
        assertEquals(-101, Calculator.getMin(numbers));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMax() {
        assertEquals(228, Calculator.getMax(numbers));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetSum() {
        assertEquals("280", Calculator.getSum(numbers));
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMult() {
        assertEquals("410652290664", Calculator.getMult(numbers));
    }

    @Disabled
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void timeoutTest() throws IOException {
        ArrayList<Long> numbers = Calculator.readNumbersFromFile("test_numbers_size_10000000.txt");
        Calculator.getSum(numbers);
    }

}
