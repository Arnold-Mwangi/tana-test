package com.assignment;

import com.assignment.solutions.GetLongestString;

/**
 * Main runner class for the assignment solutions.
 * This class provides a convenient way to test and demonstrate all solutions.
 */
public class AssignmentRunner {
    
    public static void main(String[] args) {
        System.out.println("=== Assignment Solutions Runner ===\n");
        
        // Demonstrate GetLongestString
        demonstrateGetLongestString();
        
        // TODO: Add demonstrations for other 4 solutions as they are implemented
        // demonstrateSolution2();
        // demonstrateSolution3();
        // demonstrateSolution4();
        // demonstrateSolution5();
    }
    
    private static void demonstrateGetLongestString() {
        System.out.println("1. GetLongestString Solution:");
        System.out.println("   Problem: Find the longest string with allowed characters and no consecutive duplicates");
        
        // Test case 1
        String characters1 = "abc";
        String[] strings1 = {"ab", "abc", "abcd", "aab", "bca"};
        String result1 = GetLongestString.getLongestString(characters1, strings1);
        System.out.println("   Input: characters=\"" + characters1 + "\", strings=" + java.util.Arrays.toString(strings1));
        System.out.println("   Output: \"" + result1 + "\"");
        
        // Test case 2
        String characters2 = "ab";
        String[] strings2 = {"xyz", "def", "ghi"};
        String result2 = GetLongestString.getLongestString(characters2, strings2);
        System.out.println("   Input: characters=\"" + characters2 + "\", strings=" + java.util.Arrays.toString(strings2));
        System.out.println("   Output: \"" + result2 + "\" (no valid strings)");
        
        System.out.println();
    }
    
    // Template methods for other solutions
    /*
    private static void demonstrateSolution2() {
        System.out.println("2. Solution2 Name:");
        System.out.println("   Problem: [Description]");
        // Implementation here
        System.out.println();
    }
    
    private static void demonstrateSolution3() {
        System.out.println("3. Solution3 Name:");
        System.out.println("   Problem: [Description]");
        // Implementation here
        System.out.println();
    }
    
    private static void demonstrateSolution4() {
        System.out.println("4. Solution4 Name:");
        System.out.println("   Problem: [Description]");
        // Implementation here
        System.out.println();
    }
    
    private static void demonstrateSolution5() {
        System.out.println("5. Solution5 Name:");
        System.out.println("   Problem: [Description]");
        // Implementation here
        System.out.println();
    }
    */
}
