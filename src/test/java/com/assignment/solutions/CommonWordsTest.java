package com.assignment.solutions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonWordsTest {

    @Test
    public void testBasicFunctionality() {
        // Example from the problem description
        String sentence = "hi there care to discuss algorithm basis or how to solve algorithm or";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"algorithm", "or", "to"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testExactlyThreeUniqueWords() {
        // Sentence with exactly 3 unique words
        String sentence = "apple banana cherry apple banana cherry";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"apple", "banana", "cherry"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testLessThanThreeUniqueWords() {
        // Sentence with only 2 unique words
        String sentence = "hello world hello world hello";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"hello", "world"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSingleWord() {
        // Sentence with only one unique word repeated
        String sentence = "test test test test";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"test"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSingleWordOnce() {
        // Sentence with only one word appearing once
        String sentence = "unique";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"unique"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testNullInput() {
        // Null sentence input
        String[] result = CommonWords.getTop3CommonWords(null);
        String[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEmptyString() {
        // Empty sentence
        String sentence = "";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWhitespaceOnly() {
        // Sentence with only whitespace
        String sentence = "   \t\n   ";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testPunctuationOnly() {
        // Sentence with only punctuation marks
        String sentence = "!@#$%^&*()_+-=[]{}|;':\",./<>?";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testWordsWithPunctuation() {
        // Words mixed with punctuation
        String sentence = "hello, world! How are you? I'm fine, thanks!";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // Should extract: hello, world, how, are, you, i, m, fine, thanks
        // All appear once, so alphabetically: are, fine, hello (first 3)
        String[] expected = {"are", "fine", "hello"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testCaseInsensitive() {
        // Mixed case words should be treated as same word
        String sentence = "Hello HELLO hello World WORLD world";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"hello", "world"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testNumbersInSentence() {
        // Sentence containing numbers (should be ignored based on regex [^a-z]+)
        String sentence = "test123 456test test 789 test";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"456test", "789", "test"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAlphabeticalOrderingWithTies() {
        // All words appear same number of times - should be sorted alphabetically
        String sentence = "zebra apple banana zebra apple banana";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"apple", "banana", "zebra"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testFrequencyOrderingThenAlphabetical() {
        // Different frequencies, then alphabetical for ties
        String sentence = "c c c b b a a d d e";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // c appears 3 times, a,b,d appear 2 times each, e appears 1 time
        // Top 3: c (3 times), then a,b (2 times each, alphabetically a comes first)
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testManyWordsWithSameFrequency() {
        // More than 3 words with same frequency
        String sentence = "f e d c b a f e d c b a";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // All words appear twice, so pick first 3 alphabetically
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testLongSentence() {
        // Long sentence with various word frequencies
        StringBuilder sb = new StringBuilder();
        // Add "the" 5 times, "and" 4 times, "of" 3 times, "to" 3 times, "a" 2 times
        for (int i = 0; i < 5; i++) sb.append("the ");
        for (int i = 0; i < 4; i++) sb.append("and ");
        for (int i = 0; i < 3; i++) sb.append("of ");
        for (int i = 0; i < 3; i++) sb.append("to ");
        for (int i = 0; i < 2; i++) sb.append("a ");
        sb.append("in is");
        
        String[] result = CommonWords.getTop3CommonWords(sb.toString());
        // Expected: "the" (5), "and" (4), then "of" and "to" (3 each, alphabetically "of" comes first)
        String[] expected = {"and", "of", "the"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSpecialCharactersAndAccents() {
        // Words with special characters (should be split by regex)
        String sentence = "hello-world hello_world hello@world hello world";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // Should extract: hello, world (multiple times each)
        String[] expected = {"hello", "world"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testVeryShortWords() {
        // Single character words
        String sentence = "a b c a b c a b";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testRepeatedSpaces() {
        // Multiple spaces between words
        String sentence = "word1    word2     word1   word3    word2";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"word1", "word2", "word3"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testTabsAndNewlines() {
        // Words separated by tabs and newlines
        String sentence = "apple\tbanana\ncherry\tapple\nbanana";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"apple", "banana", "cherry"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testEmptyWordsFromSplit() {
        // Sentence that might create empty strings after split
        String sentence = "!!!hello!!!world!!!hello!!!";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"hello", "world"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testUnicodeCharacters() {
        // Non-English characters (should be filtered out by [^a-z]+ regex)
        String sentence = "hello мир world 你好 test hello";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        String[] expected = {"hello", "test", "world"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testComplexFrequencyScenario() {
        // Complex scenario with multiple frequency levels
        String sentence = "a a a a b b b c c d e f g h i j";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // a appears 4 times, b appears 3 times, c appears 2 times
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testAllWordsAppearOnce() {
        // All words appear exactly once
        String sentence = "zebra yankee xray whiskey victor uniform";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // All appear once, so first 3 alphabetically
        String[] expected = {"uniform", "victor", "whiskey"};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testMixedFrequenciesWithAlphabeticalTieBreaker() {
        // Test complex tie-breaking scenario
        String sentence = "dog cat bird dog cat elephant dog zebra";
        String[] result = CommonWords.getTop3CommonWords(sentence);
        // dog: 3, cat: 2, bird: 1, elephant: 1, zebra: 1
        // Top 3: dog (3), cat (2), bird (1) - bird wins alphabetically over elephant and zebra
        String[] expected = {"bird", "cat", "dog"};
        assertArrayEquals(expected, result);
    }
}
