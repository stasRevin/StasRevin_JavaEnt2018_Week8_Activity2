package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.random;

public class PerformanceComparison {

    public static  void main(String[] arguments) {

        List<Integer> numbers = new ArrayList<>();
        populateListWithNumbers(numbers);
        long start = System.currentTimeMillis();
        int max = findMaximumValueWithBruteForce(numbers);
        long end = System.currentTimeMillis();

        long bruteForcePerformance = calculatePerformance(start, end);

        start = System.currentTimeMillis();
        int maxFromLambda = findMaximumValueWithLambda(numbers);
        end = System.currentTimeMillis();

        long lambdaPerformance = calculatePerformance(start, end);

        System.out.println("Brute force performance: " +  bruteForcePerformance);
        System.out.println("Lambda performance: " + lambdaPerformance);
    }

    public static int findMaximumValueWithBruteForce(List<Integer> numbers) {

        int max = numbers.get(0);

        for (int number : numbers) {

            if (number > max) {

                max = number;
            }
        }

        return max;

    }


    public static int findMaximumValueWithLambda(List<Integer> numbers) {

        return numbers.stream().max(Comparator.comparing(Integer::valueOf)).get();
    }


    public static void populateListWithNumbers(List<Integer> numbers) {

        for (int i = 0; i < 100000000; i += 1) {

            Double randomNumber = Math.random() * 100;
            Integer numberToAdd = randomNumber.intValue();
            numbers.add(numberToAdd);
        }

    }

    public static long calculatePerformance(long start, long end) {

        return (end - start);
    }

}
