package com.test;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    private ArrayList<Long> numbers;

    @BeforeEach
    void setUp() throws IOException {
        numbers =Calculator.readNumbersFromFile("test.txt");
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMin() {
        assertEquals(-101, Calculator.getMin(numbers));
        System.out.println("testGetMin passed");
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMax() {
        assertEquals(228, Calculator.getMax(numbers));
        System.out.println("testGetMax passed");
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetSum() {
        assertEquals("280", Calculator.getSum(numbers));
        System.out.println("testGetSum passed");
    }

    @org.junit.jupiter.api.Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMult() {
        assertEquals("410652290664", Calculator.getMult(numbers));
        System.out.println("testGetMult passed");
    }



}
