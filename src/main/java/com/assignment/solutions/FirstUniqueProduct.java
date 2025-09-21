package com.assignment.solutions;

import java.util.LinkedHashMap;
import java.util.Map;

/** *
 * Finds first product that is unique among all products in a list in input order.
 * Time compelexity: O(n)
 * Space complexity: O(n)
 */
public class FirstUniqueProduct {
    /**
     *
     * @param products Array of products
     * @return First unique product or null if no unique product is found
     */
    public static String firstUniqueProduct(String[] products) {
        // Null safety for inputs
        if (products == null || products.length == 0) {
            return null;
        }
        
        //Count the number of product occurrences and store them in a LinkedHashMap
        Map<String, Integer> productOccurrence = new LinkedHashMap<>();
        for (String product : products) {
            if (productOccurrence.containsKey(product)) {
                productOccurrence.put(product, productOccurrence.get(product) + 1);
            } else {
                productOccurrence.put(product, 1);
            }
        }
        // Find and return the first product that appears only once in input order
        for (Map.Entry<String, Integer> entry : productOccurrence.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // No unique product found
        return null;
    }
}
