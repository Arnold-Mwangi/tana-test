package com.assignment.solutions;

/**
 * Finds the distance of closest minimums in an array of numbers.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ClosestMinimums {

    /**
     *Gets the distance between minimums in an array of numbers
     * @param numbers Array of numbers (minimum array item occurs twice)
     * @return Number of closest minimums
     */
    public static int getClosestMinimums(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return -1;
        }
        // get minimum value
        int minimumValue = Integer.MAX_VALUE;
        for (int number : numbers) {
            if (number < minimumValue) {
                minimumValue = number;
            }
        }

        // loop through the numbers array and get the closest distance to minimum value
        int previousIndex = -1;
        int minimumDistance = Integer.MAX_VALUE;
        int occurrences = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == minimumValue) {
                occurrences++;
                if (previousIndex != -1) {
                    minimumDistance = Math.min(minimumDistance, i - previousIndex);
                }
                previousIndex = i;
            }
        }

        // In case minimum occurs only once in the array
        if (occurrences < 2) {
            return -1;
        }

        return minimumDistance;
    }
}
