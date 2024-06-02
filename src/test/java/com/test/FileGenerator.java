package com.test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class FileGenerator {

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
}