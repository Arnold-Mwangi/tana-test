package com.assignment.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;
import java.util.Arrays;

public class RotateListTest {

    @Test
    public void testBasicFunctionality() {
        // Example from the problem description
        LinkedList<String> list = new LinkedList<>(Arrays.asList("ID_A01", "ID_A02", "ID_A03", "ID_A04", "ID_A05", "ID_A06"));
        LinkedList<String> result = RotateList.rotateRight(list, 2);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("ID_A05", "ID_A06", "ID_A01", "ID_A02", "ID_A03", "ID_A04"));
        assertEquals(expected, result);
    }

    @Test
    public void testRotateByZero() {
        // Rotating by 0 should return the same list
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> original = new LinkedList<>(list);
        LinkedList<String> result = RotateList.rotateRight(list, 0);
        assertEquals(original, result);
    }

    @Test
    public void testRotateByOne() {
        // Simple rotation by 1 position
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> result = RotateList.rotateRight(list, 1);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("D", "A", "B", "C"));
        assertEquals(expected, result);
    }

    @Test
    public void testRotateByListSize() {
        // Rotating by list size should return the same list
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> original = new LinkedList<>(list);
        LinkedList<String> result = RotateList.rotateRight(list, 4);
        assertEquals(original, result);
    }

    @Test
    public void testRotateByMultipleOfListSize() {
        // Rotating by multiple of list size should return the same list
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> original = new LinkedList<>(list);
        LinkedList<String> result = RotateList.rotateRight(list, 9); // 3 * 3
        assertEquals(original, result);
    }

    @Test
    public void testRotateByLargeNumber() {
        // Rotation by number larger than list size
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> result = RotateList.rotateRight(list, 7); // 7 % 4 = 3
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("B", "C", "D", "A"));
        assertEquals(expected, result);
    }

    @Test
    public void testNegativeRotation() {
        // Negative rotation should rotate left (converted to equivalent right rotation)
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> result = RotateList.rotateRight(list, -1);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("B", "C", "D", "A"));
        assertEquals(expected, result);
    }

    @Test
    public void testLargeNegativeRotation() {
        // Large negative rotation
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> result = RotateList.rotateRight(list, -5); // -5 % 4 = -1, converted to 3
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("B", "C", "D", "A"));
        assertEquals(expected, result);
    }

    @Test
    public void testSingleElementList() {
        // List with single element
        LinkedList<String> list = new LinkedList<>(Arrays.asList("ONLY"));
        LinkedList<String> result = RotateList.rotateRight(list, 5);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("ONLY"));
        assertEquals(expected, result);
    }

    @Test
    public void testTwoElementList() {
        // List with two elements
        LinkedList<String> list = new LinkedList<>(Arrays.asList("FIRST", "SECOND"));
        LinkedList<String> result = RotateList.rotateRight(list, 1);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("SECOND", "FIRST"));
        assertEquals(expected, result);
    }

    @Test
    public void testTwoElementListEvenRotation() {
        // Two element list with even rotation
        LinkedList<String> list = new LinkedList<>(Arrays.asList("FIRST", "SECOND"));
        LinkedList<String> original = new LinkedList<>(list);
        LinkedList<String> result = RotateList.rotateRight(list, 2);
        assertEquals(original, result);
    }

    @Test
    public void testEmptyList() {
        // Empty list should remain empty
        LinkedList<String> list = new LinkedList<>();
        LinkedList<String> result = RotateList.rotateRight(list, 5);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testNullList() {
        // Null list should return null
        LinkedList<String> result = RotateList.rotateRight(null, 3);
        assertNull(result);
    }

    @Test
    public void testRotateCompletelyAround() {
        // Rotate by exactly list size - 1
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        LinkedList<String> result = RotateList.rotateRight(list, 4);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("B", "C", "D", "E", "A"));
        assertEquals(expected, result);
    }

    @Test
    public void testIdenticalElements() {
        // List with identical elements
        LinkedList<String> list = new LinkedList<>(Arrays.asList("SAME", "SAME", "SAME", "SAME"));
        LinkedList<String> original = new LinkedList<>(list);
        LinkedList<String> result = RotateList.rotateRight(list, 2);
        assertEquals(original, result);
    }

    @Test
    public void testMixedIdenticalElements() {
        // List with some identical elements
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "A", "C"));
        LinkedList<String> result = RotateList.rotateRight(list, 1);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("C", "A", "B", "A"));
        assertEquals(expected, result);
    }

    @Test
    public void testLargeList() {
        // Test with larger list
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i <= 100; i++) {
            list.add("ITEM_" + String.format("%03d", i));
        }
        
        LinkedList<String> result = RotateList.rotateRight(list, 10);
        
        // Last 10 elements should move to front
        LinkedList<String> expected = new LinkedList<>();
        for (int i = 91; i <= 100; i++) {
            expected.add("ITEM_" + String.format("%03d", i));
        }
        for (int i = 1; i <= 90; i++) {
            expected.add("ITEM_" + String.format("%03d", i));
        }
        
        assertEquals(expected, result);
    }

    @Test
    public void testVeryLargeRotation() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("X", "Y", "Z"));
        LinkedList<String> result = RotateList.rotateRight(new LinkedList<>(list), 1000001);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("Y", "Z", "X")); // right rotation
        assertEquals(expected, result);
    }


    @Test
    public void testVeryLargeNegativeRotation() {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("X", "Y", "Z"));
        LinkedList<String> result = RotateList.rotateRight(list, -1000001);
        // should be:
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("Z", "X", "Y"));
        assertEquals(expected, result);
    }



    @Test
    public void testStringWithSpecialCharacters() {
        // Strings with special characters
        LinkedList<String> list = new LinkedList<>(Arrays.asList("@#$", "123", "abc!", "xyz&"));
        LinkedList<String> result = RotateList.rotateRight(list, 2);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("abc!", "xyz&", "@#$", "123"));
        assertEquals(expected, result);
    }

    @Test
    public void testEmptyStrings() {
        // List containing empty strings
        LinkedList<String> list = new LinkedList<>(Arrays.asList("", "A", "", "B"));
        LinkedList<String> result = RotateList.rotateRight(list, 1);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("B", "", "A", ""));
        assertEquals(expected, result);
    }

    @Test
    public void testNullElementsInList() {
        // List containing null elements
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", null, "B", "C"));
        LinkedList<String> result = RotateList.rotateRight(list, 2);
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("B", "C", "A", null));
        assertEquals(expected, result);
    }

    @Test
    public void testAllNullElements() {
        // List with all null elements
        LinkedList<String> list = new LinkedList<>(Arrays.asList(null, null, null));
        LinkedList<String> original = new LinkedList<>(list);
        LinkedList<String> result = RotateList.rotateRight(list, 1);
        assertEquals(original, result); // All nulls, so rotation doesn't change anything visually
    }

    @Test
    public void testRotateRightThenLeft() {
        // Test that rotating right then left returns to original
        LinkedList<String> original = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        LinkedList<String> list = new LinkedList<>(original);
        
        // Rotate right by 3
        RotateList.rotateRight(list, 3);
        // Rotate left by 3 (equivalent to right by -3)
        LinkedList<String> result = RotateList.rotateRight(list, -3);
        
        assertEquals(original, result);
    }

    @Test
    public void testConsistencyWithMultipleRotations() {
        // Test that multiple small rotations equal one large rotation
        LinkedList<String> list1 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList<String> list2 = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        
        // Rotate list1 by 1, three times
        RotateList.rotateRight(list1, 1);
        RotateList.rotateRight(list1, 1);
        RotateList.rotateRight(list1, 1);
        
        // Rotate list2 by 3 once
        RotateList.rotateRight(list2, 3);
        
        assertEquals(list1, list2);
    }

    @Test
    public void testMaxIntegerRotation() {
        // Test with maximum integer value
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> result = RotateList.rotateRight(list, Integer.MAX_VALUE);
        // Integer.MAX_VALUE % 3 = 1
        LinkedList<String> expected = new LinkedList<>(Arrays.asList("C", "A", "B"));
        assertEquals(expected, result);
    }

    @Test
    public void testMinIntegerRotation() {
        // Test with minimum integer value
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C"));
        LinkedList<String> result = RotateList.rotateRight(list, Integer.MIN_VALUE);
        // This should handle the edge case of Integer.MIN_VALUE
        assertNotNull(result);
        assertEquals(3, result.size());
    }

    @Test
    public void testRotationPreservesListSize() {
        // Ensure rotation doesn't change list size
        LinkedList<String> list = new LinkedList<>(Arrays.asList("ONE", "TWO", "THREE", "FOUR", "FIVE"));
        int originalSize = list.size();
        LinkedList<String> result = RotateList.rotateRight(list, 7);
        assertEquals(originalSize, result.size());
    }

    @Test
    public void testRotationPreservesElements() {
        // Ensure rotation preserves all original elements
        LinkedList<String> original = new LinkedList<>(Arrays.asList("ALPHA", "BETA", "GAMMA", "DELTA"));
        LinkedList<String> list = new LinkedList<>(original);
        LinkedList<String> result = RotateList.rotateRight(list, 2);
        
        // Check that all original elements are still present
        for (String element : original) {
            assertTrue(result.contains(element));
        }
        assertEquals(original.size(), result.size());
    }
}
