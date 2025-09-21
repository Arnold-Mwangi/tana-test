import java.util.*;

public class GetLongestString {
    /**
     *
     * @param characters Characters allowed in the string
     * @param strings Array of strings to check
     * @return Longest valid string or empty string if no valid string is found
     */

    public static String getLongestString(String characters,String[] strings) {
        // Null safety for inputs
        if (characters == null || strings == null) {
            return "";
        }

        Set<Character> characterSet = new HashSet<>();
        for(char c : characters.toCharArray()) {
            characterSet.add(c);
        }

        String longestString = "";

        for(String str : strings) {
            if (str == null) {
                continue;
            }

            // skipp checkstrings if they are shorter than the longest string
            if (str.length() <= longestString.length()) {
                continue;
            }


            if(isValid(str, characterSet)) {
                    longestString = str;
            }
        }
        return longestString;
    }

    /**
     * Checks if a string contains only characters allowed in the string
     * @param str String to check
     * @param characterSet Set of characters allowed in the string
     * @return True if string contains only characters allowed in the string, false otherwise
     */
    private static boolean isValid(String str, Set<Character> characterSet) {
        if (str.isEmpty()) {
            return false;
        }

        char previous  = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            // check if string character is in the set
            if (!characterSet.contains(current)) {
                return false;
            }

            // check if there are consecutive characters
            if (i > 0 && current == previous) {
                return false;
            }

            previous = current;
        }
        return true;
    }
}
