package com.assignment.solutions;

import java.util.*;


/**
 * Find the top3 common words in a sentence
 * If a tie, sort alphabetically
 * Finally sort alphabetically
 * Time complexity: O(n)
 * Space complexity: O(k)
 */
public class CommonWords {
/**
 * Gets the top 3 common words in a sentence
 * @param sentence Sentence to check
 * @return Array of top 3 common words
 */
    public static String[] getTop3CommonWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return new String[0];
        }

        // clean sentence and split into words
        String[] words = sentence.toLowerCase().split("[^a-z0-9]+");


        //count word occurrences
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if(word.isEmpty()) continue;
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        if (wordCount.isEmpty()) {
            return new String[0];
        }

        // sort by number of occurrences and then by asc order of word
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCount.entrySet());
        entries.sort((a,b) -> {
            int comparison = b.getValue().compareTo(a.getValue());
            if (comparison == 0) {
                return a.getKey().compareTo(b.getKey());
            }
            return comparison;
        });

        // pick the top 3 from the entries
        List<String> candidates = new ArrayList<>();
        int limit = Math.min(3, entries.size());
        int minimumOccurrence = entries.get(limit - 1).getValue();


        for (Map.Entry<String, Integer> entry : entries) {
            if (candidates.size() < 3 || entry.getValue() == minimumOccurrence) {
                candidates.add(entry.getKey());
            } else {
                break;
            }
        }
        // If more than 3 because of ties, keep smallest alphabetically
        Collections.sort(candidates);
        if (candidates.size() > 3) {
            candidates = candidates.subList(0, 3);
        }

        return candidates.toArray(new String[0]);
    }
}
