package com.assignment.utils;

import java.util.*;

/**
 * Utility class for generating test data for assignment solutions.
 * This can be useful for creating consistent test cases across different solutions.
 */
public class TestDataGenerator {
    
    private static final Random random = new Random();
    
    /**
     * Generates random strings with specified characters
     * @param allowedChars Characters that can be used in the strings
     * @param count Number of strings to generate
     * @param maxLength Maximum length of each string
     * @return Array of generated strings
     */
    public static String[] generateRandomStrings(String allowedChars, int count, int maxLength) {
        String[] result = new String[count];
        
        for (int i = 0; i < count; i++) {
            int length = random.nextInt(maxLength) + 1;
            StringBuilder sb = new StringBuilder();
            
            for (int j = 0; j < length; j++) {
                int charIndex = random.nextInt(allowedChars.length());
                sb.append(allowedChars.charAt(charIndex));
            }
            
            result[i] = sb.toString();
        }
        
        return result;
    }
    
    /**
     * Generates test arrays with known valid and invalid strings
     * @return Map containing test cases with expected results
     */
    public static Map<String, Object[]> getStandardTestCases() {
        Map<String, Object[]> testCases = new HashMap<>();
        
        // Test case 1: Basic functionality
        testCases.put("basic", new Object[]{
            "abc", 
            new String[]{"ab", "abc", "abcd", "aab", "bca"}, 
            "abc"
        });
        
        // Test case 2: No valid strings
        testCases.put("no_valid", new Object[]{
            "ab", 
            new String[]{"xyz", "def", "ghi"}, 
            ""
        });
        
        // Test case 3: Consecutive duplicates
        testCases.put("consecutive", new Object[]{
            "abc", 
            new String[]{"aab", "abb", "acc"}, 
            ""
        });
        
        return testCases;
    }
    
    /**
     * Prints test case in a formatted way
     * @param caseName Name of the test case
     * @param characters Allowed characters
     * @param strings Array of strings to test
     * @param expected Expected result
     */
    public static void printTestCase(String caseName, String characters, String[] strings, String expected) {
        System.out.println("Test Case: " + caseName);
        System.out.println("  Characters: \"" + characters + "\"");
        System.out.println("  Strings: " + Arrays.toString(strings));
        System.out.println("  Expected: \"" + expected + "\"");
        System.out.println();
    }
}
