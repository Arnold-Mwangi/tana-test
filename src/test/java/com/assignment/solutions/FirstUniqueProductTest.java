package com.assignment.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FirstUniqueProductTest {

    @Test
    public void testBasicFunctionality() {
        // Example from the problem description
        String[] products = {"Apple", "Computer", "Apple", "Bag"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("Computer", result);
    }

    @Test
    public void testFirstUniqueProduct() {
        // Multiple unique products - should return the first one
        String[] products = {"A", "B", "C", "A", "D"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("B", result);
    }

    @Test
    public void testNoUniqueProduct() {
        // All products appear more than once
        String[] products = {"Apple", "Banana", "Apple", "Banana"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertNull(result);
    }

    @Test
    public void testSingleProduct() {
        // Array with single product - should return that product
        String[] products = {"OnlyOne"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("OnlyOne", result);
    }

    @Test
    public void testAllProductsUnique() {
        // All products are unique - should return the first one
        String[] products = {"A", "B", "C", "D"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("A", result);
    }

    @Test
    public void testNullInput() {
        // Null array input
        String result = FirstUniqueProduct.firstUniqueProduct(null);
        assertNull(result);
    }

    @Test
    public void testEmptyArray() {
        // Empty array input
        String[] products = {};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertNull(result);
    }

    @Test
    public void testNullProductInArray() {
        // Array containing null values
        String[] products = {"Apple", null, "Apple", "Banana"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertNull(result);
    }

    @Test
    public void testMultipleNullsInArray() {
        // Array containing multiple null values
        String[] products = {"Apple", null, "Apple", null, "Banana"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("Banana", result);
    }

    @Test
    public void testEmptyStringInArray() {
        // Array containing empty strings
        String[] products = {"Apple", "", "Apple", "Banana"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("", result);
    }

    @Test
    public void testCaseSensitivity() {
        // Case sensitive comparison
        String[] products = {"apple", "Apple", "APPLE", "banana"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("apple", result);
    }

    @Test
    public void testLargeArray() {
        // Test with larger array
        String[] products = new String[1000];
        for (int i = 0; i < 999; i++) {
            // Creates duplicates
            products[i] = "Product" + (i % 499);
        }
        // Only unique product
        products[999] = "UniqueProduct";
        
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("UniqueProduct", result);
    }

    @Test
    public void testUniqueAtEnd() {
        // Unique product appears at the end
        String[] products = {"A", "B", "A", "B", "C"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("C", result);
    }

    @Test
    public void testUniqueAtBeginning() {
        // Unique product appears at the beginning
        String[] products = {"Unique", "A", "B", "A", "B"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("Unique", result);
    }

    @Test
    public void testWhitespaceProducts() {
        // Products with whitespace
        String[] products = {" ", "  ", " ", "tab\t", "newline\n"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("  ", result); // "  " appears once
    }

    @Test
    public void testSpecialCharacters() {
        // Products with special characters
        String[] products = {"@#$", "123", "@#$", "abc!", "123"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("abc!", result);
    }

    @Test
    public void testVeryLongProductNames() {
        // Test with very long product names
        String longProduct1 = "A".repeat(1000);
        String longProduct2 = "B".repeat(1000);
        String[] products = {longProduct1, longProduct2, longProduct1, "Short"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals(longProduct2, result);
    }

    @Test
    public void testOrderPreservation() {
        // Verify that insertion order is preserved
        String[] products = {"Third", "First", "Second", "First", "Third"};
        String result = FirstUniqueProduct.firstUniqueProduct(products);
        assertEquals("Second", result);
    }
}
