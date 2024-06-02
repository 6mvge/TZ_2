package com.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.test.Calculator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFileGenerator {

    public static void main(String[] args) {
        generateTestFile("test_numbers_size_100.txt", 100);
        generateTestFile("test_numbers_size_1000.txt", 1000);
        generateTestFile("test_numbers_size_100000.txt", 100000);
        generateTestFile("test_numbers_size_1000000.txt", 1000000);
        generateTestFile("test_numbers_size_10000000.txt", 10000000);
    }

    public static void generateTestFile(String filename, int size) {
        Random random = new Random();
        try (FileWriter writer = new FileWriter(filename)) {
            for (int i = 0; i < size; i++) {
                int number = random.nextInt(1000) -500;
                writer.write(number + " ");
            }
            System.out.println("Generated file: " + filename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static class TimeTest {


        private ArrayList<Long> numbers;

        @BeforeEach
        void setUp() throws IOException {
            numbers = readNumbersFromFile("test.txt");
        }

        @Test
        @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
        void testGetMin() {
            Assertions.assertEquals(-101, Calculator.getMin(numbers));
            System.out.println("testGetMin passed");
        }

        @Test
        @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
        void testGetMax() {
            Assertions.assertEquals(228, Calculator.getMax(numbers));
            System.out.println("testGetMax passed");
        }

        @Test
        @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
        void testGetSum() {
            Assertions.assertEquals("280", Calculator.getSum(numbers));
            System.out.println("testGetSum passed");
        }

        @Test
        @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
        void testGetMult() {
            Assertions.assertEquals("410652290664", Calculator.getMult(numbers));
            System.out.println("testGetMult passed");
        }

        @Disabled
        @Test
        @Timeout(value = 200, unit = TimeUnit.MILLISECONDS)
        void timeoutTest() throws IOException {
            ArrayList<Long> numbers = readNumbersFromFile("test_numbers_size_10000000.txt");
            Calculator.getSum(numbers);
        }

        public static void testPerformance(String filename) throws IOException {
            ArrayList<Long> numbers = readNumbersFromFile(filename);

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
}