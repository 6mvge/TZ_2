package com.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public static long getMin(ArrayList<Long> numbers) {
        return numbers.stream().mapToLong(Long::longValue).min().orElseThrow();
    }

    public static long getMax(ArrayList<Long> numbers) {
        return numbers.stream().mapToLong(Long::longValue).max().orElseThrow();
    }

    public static String getSum(ArrayList<Long> numbers) {
        BigInteger sum = numbers.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ZERO, BigInteger::add);
        return sum.toString();
    }

    public static String getMult(ArrayList<Long> numbers) {
        BigInteger mult = numbers.stream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
        return mult.toString();
    }

    public static ArrayList<Long> readNumbersFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            return Stream.of(line.split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Long> numbers = readNumbersFromFile("test.txt");
        System.out.println("Минимальное: " + getMin(numbers));
        System.out.println("Максимальное: " + getMax(numbers));
        System.out.println("Сумма: " + getSum(numbers));
        System.out.println("Произведение: " + getMult(numbers));
    }
}




