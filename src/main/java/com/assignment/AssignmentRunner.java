package com.assignment;

import com.assignment.solutions.GetLongestString;
import com.assignment.solutions.FirstUniqueProduct;

/**
 * Main runner class for the  solutions.
 * Demonstrates all solutions with example usage.
 * For comprehensive testing, run mvn test (or javac + junit).
 */
public class AssignmentRunner {
    
    public static void main(String[] args) {
        System.out.println("=== Assignment Solutions Demo ===");
        System.out.println("This demonstrates basic usage of each solution.");
        System.out.println("For comprehensive testing, run: mvn test (or javac + junit)\n");
        
        // Demonstrate GetLongestString
        demonstrateGetLongestString();
        
        // Demonstrate FirstUniqueProduct
        demonstrateFirstUniqueProduct();
        
        // TODO: Add demonstrations for other 3 solutions as they are implemented
        // demonstrateSolution3();
        // demonstrateSolution4();
        // demonstrateSolution5();
        
        System.out.println("=== Demo Complete ===");
        System.out.println("Run the JUnit tests for thorough validation of all edge cases.");
    }
    
    private static void demonstrateGetLongestString() {
        System.out.println("1. GetLongestString Solution:");
        System.out.println("   Problem: Find the longest string with allowed characters and no consecutive duplicates");
        
        // Simple demonstration example
        String characters = "abc";
        String[] strings = {"ab", "abc", "abcd", "aab", "bca"};
        String result = GetLongestString.getLongestString(characters, strings);
        
        System.out.println("   Example Usage:");
        System.out.println("     characters = \"" + characters + "\"");
        System.out.println("     strings = " + java.util.Arrays.toString(strings));
        System.out.println("     result = \"" + result + "\"");
        System.out.println("   ✓ Returns longest valid string without consecutive duplicates\n");
    }
    
    private static void demonstrateFirstUniqueProduct() {
        System.out.println("2. FirstUniqueProduct Solution:");
        System.out.println("   Problem: Find the first product that occurs only once in the array");
        
        // Example from the problem description
        String[] products1 = {"Apple", "Computer", "Apple", "Bag"};
        String result1 = FirstUniqueProduct.firstUniqueProduct(products1);
        
        System.out.println("   Example Usage:");
        System.out.println("     products = " + java.util.Arrays.toString(products1));
        System.out.println("     result = \"" + result1 + "\"");
        
        // Additional example
        String[] products2 = {"A", "B", "C", "A", "D"};
        String result2 = FirstUniqueProduct.firstUniqueProduct(products2);
        System.out.println("     products = " + java.util.Arrays.toString(products2));
        System.out.println("     result = \"" + result2 + "\"");
        
        // No unique product example
        String[] products3 = {"X", "Y", "X", "Y"};
        String result3 = FirstUniqueProduct.firstUniqueProduct(products3);
        System.out.println("     products = " + java.util.Arrays.toString(products3));
        System.out.println("     result = " + result3 + " (no unique product)");
        System.out.println("   ✓ Returns first unique product or null if none exists\n");
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
