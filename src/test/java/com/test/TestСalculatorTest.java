package com.test;

import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestСalculatorTest {

    @Disabled
    @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
    @Test
    void timeoutTest() throws IOException {
        ArrayList<Long> bigSize = Calculator.readNumbersFromFile("test_numbers_size_10000000.txt");
        Calculator.getSum(bigSize);
    }


}
