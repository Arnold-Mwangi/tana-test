package com.assignment.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestMinimumsTest {

    @Test
    public void testBasicFunctionality() {
        // Example from the problem description
        int[] numbers = {1, 2, 3, 1, 4, 5, 2};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(3, result);
    }

    @Test
    public void testConsecutiveMinimums() {
        // Minimum values are consecutive
        int[] numbers = {3, 1, 1, 4, 5};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(1, result);
    }

    @Test
    public void testTwoMinimums() {
        // Array with exactly two minimums
        int[] numbers = {5, 2, 7, 2, 9};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result);
    }

    @Test
    public void testMultipleMinimums() {
        // Multiple occurrences of minimum, should return closest pair
        int[] numbers = {1, 3, 1, 5, 1, 7};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result); // Distance between indices 0 and 2, or 2 and 4
    }

    @Test
    public void testMinimumsAtEnds() {
        // Minimums at the beginning and end
        int[] numbers = {1, 5, 6, 7, 8, 1};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(5, result);
    }

    @Test
    public void testNegativeNumbers() {
        // Array with negative numbers
        int[] numbers = {-2, 5, -2, 3, 1};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result);
    }

    @Test
    public void testAllSameNumbers() {
        // All numbers are the same (all are minimums)
        int[] numbers = {3, 3, 3, 3, 3};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(1, result); // Any consecutive pair has distance 1
    }

    @Test
    public void testMixedPositiveNegative() {
        // Mix of positive and negative numbers
        int[] numbers = {-5, 2, -3, -5, 1, 0};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(3, result); // -5 appears at indices 0 and 3
    }

    @Test
    public void testZeroAsMinimum() {
        // Zero is the minimum value
        int[] numbers = {5, 0, 3, 2, 0, 1};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(3, result); // 0 appears at indices 1 and 4
    }

    @Test
    public void testLargeNumbers() {
        // Test with large numbers
        int[] numbers = {1000000, 999999, 1000000, 999998, 999999};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(-1, result); // No pair of numbers are within 1 of each other
    }

    @Test
    public void testThreeConsecutiveMinimums() {
        // Three consecutive minimums
        int[] numbers = {5, 2, 2, 2, 7};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(1, result); // Distance between any consecutive pair
    }

    @Test
    public void testMinimumAtIntegerMaxValue() {
        // Test edge case where minimum is Integer.MAX_VALUE
        int[] numbers = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(1, result);
    }

    @Test
    public void testMinimumAtIntegerMinValue() {
        // Test edge case where minimum is Integer.MIN_VALUE
        int[] numbers = {0, Integer.MIN_VALUE, 5, Integer.MIN_VALUE, 3};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result); // Integer.MIN_VALUE appears at indices 1 and 3
    }

    @Test
    public void testLargeArray() {
        // Test with larger array
        int[] numbers = new int[1000];
        for (int i = 0; i < 1000; i++) {
            numbers[i] = i + 100; // Values from 100 to 1099
        }
        numbers[100] = 50; // Minimum at index 100
        numbers[200] = 50; // Minimum at index 200
        numbers[150] = 50; // Minimum at index 150 (closer to 100)
        
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(50, result); // Distance between indices 100 and 150
    }

    @Test
    public void testAlternatingPattern() {
        // Alternating pattern with minimums
        int[] numbers = {1, 5, 1, 5, 1, 5};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result); // Distance between consecutive 1's
    }

    @Test
    public void testTwoElementArray() {
        // Minimum possible array size (two elements, both minimums)
        int[] numbers = {7, 7};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(1, result);
    }

    @Test
    public void testDuplicateNonMinimums() {
        // Array with duplicate non-minimum values
        int[] numbers = {5, 3, 5, 3, 2, 7, 2, 8};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result); // 2 appears at indices 4 and 6
    }

    @Test
    public void testMultipleMinimumsSpreadOut() {
        // Multiple minimums spread throughout the array
        int[] numbers = {1, 8, 9, 1, 7, 1, 6, 5};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result); // Distance between indices 3 and 5
    }

    @Test
    public void testSymmetricArray() {
        // Symmetric array pattern
        int[] numbers = {3, 2, 1, 2, 1, 2, 3};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(2, result); // 1 appears at indices 2 and 4
    }

    @Test
    public void testRepeatedMinimumPattern() {
        // Pattern where minimum repeats in clusters
        int[] numbers = {5, 1, 1, 8, 9, 1, 1, 3};
        int result = ClosestMinimums.getClosestMinimums(numbers);
        assertEquals(1, result); // Consecutive 1's at indices 1,2 or 5,6
    }
}
