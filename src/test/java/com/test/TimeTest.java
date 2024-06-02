package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static com.test.Calculator.getSum;
import static com.test.Calculator.getMult;
import static com.test.Calculator.getMin;
import static com.test.Calculator.getMax;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {


    private ArrayList<Long> numbers;

    @BeforeEach
    void setUp() throws IOException {
        numbers =Calculator.readNumbersFromFile("test.txt");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMin() {
        assertEquals(-101, Calculator.getMin(numbers));
        System.out.println("testGetMin passed");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMax() {
        assertEquals(228, Calculator.getMax(numbers));
        System.out.println("testGetMax passed");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetSum() {
        assertEquals("280", Calculator.getSum(numbers));
        System.out.println("testGetSum passed");
    }

    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void testGetMult() {
        assertEquals("410652290664", Calculator.getMult(numbers));
        System.out.println("testGetMult passed");
    }

    @Disabled
    @Test
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    void timeoutTest() throws IOException {
        ArrayList<Long> numbers = Calculator.readNumbersFromFile("test_numbers_size_10000000.txt");
        Calculator.getSum(numbers);
    }

    public static void testPerformance(String filename) throws IOException {
        ArrayList<Long> numbers = Calculator.readNumbersFromFile(filename);

        long startTime, endTime, duration;
        String answer = "File: " + filename + ": ";
        startTime = System.nanoTime();
        long min = getMin(numbers);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        answer += "Min: " + duration/1000000 + " ms";

        startTime = System.nanoTime();
        long max = getMax(numbers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        answer += "; Max: " + duration/1000000 + " ms";

        startTime = System.nanoTime();
        String sum = getSum(numbers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        answer += "; Sum: " + duration/1000000 + " ms";

        startTime = System.nanoTime();
        String mult = getMult(numbers);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        answer += "; Mult: " + duration/1000000 + " ms";
        System.out.println(answer);
    }
}
