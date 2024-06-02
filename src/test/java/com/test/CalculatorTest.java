package com.test;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private ArrayList<Long> numbers;



    @Test
    void timeoutTest() throws IOException {
        System.out.println("test");
        ArrayList<Long> numbers = Calculator.readNumbersFromFile("test_numbers_size_10000000.txt");
        Calculator.getSum(numbers);
    }

}
