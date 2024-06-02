package com.test;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestСalculator {

    private static ArrayList<Long> numbers;

    @BeforeAll
    public static void setUp() throws IOException {
        numbers = Calculator.readNumbersFromFile("test.txt");
        System.out.println("Read file");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testGetMin() {
        assertEquals(-101, Calculator.getMin(numbers));
        System.out.println("testGetMin passed");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testGetMax() {
        assertEquals(228, Calculator.getMax(numbers));
        System.out.println("testGetMax passed");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testGetSum() {
        assertEquals("280", Calculator.getSum(numbers));
        System.out.println("testGetSum passed");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    public void testGetMult() {
        assertEquals("410652290660", Calculator.getMult(numbers));
        System.out.println("testGetMult passed");
    }

    @Test
    public void testTimeOut() throws IOException {
        ArrayList<Long> bigSize = Calculator.readNumbersFromFile("test_numbers_size_10000000.txt");
        Assertions.assertThrows(AssertionError.class, () -> {
            Assertions.assertTimeout(Duration.ofMillis(200), () -> {
                Calculator.getSum(bigSize);
            });
        });
        System.out.println("testTimeOut passed");
    }
}
