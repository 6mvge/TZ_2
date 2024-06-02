package com.test;

import java.io.IOException;
import java.util.ArrayList;

import static com.test.Calculator.getSum;
import static com.test.Calculator.getMult;
import static com.test.Calculator.getMin;
import static com.test.Calculator.getMax;

public class TimeTest {

    public static void main(String[] args) throws IOException {
        testPerformance("test_numbers_size_100.txt");
        testPerformance("test_numbers_size_1000.txt");
        testPerformance("test_numbers_size_100000.txt");
        testPerformance("test_numbers_size_1000000.txt");
        testPerformance("test_numbers_size_10000000.txt");
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