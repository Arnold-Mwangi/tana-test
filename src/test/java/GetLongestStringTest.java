import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetLongestStringTest {

    @Test
    public void testBasicFunctionality() {
        String characters = "abc";
        String[] strings = {"ab", "abc", "abcd", "aab", "bca"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("abc", result);
    }

    @Test
    public void testNoValidString() {
        String characters = "ab";
        String[] strings = {"xyz", "def", "ghi"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("", result);
    }

    @Test
    public void testConsecutiveDuplicates() {
        String characters = "abc";
        String[] strings = {"aab", "abb", "acc"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("", result);
    }

    @Test
    public void testNullInputs() {
        String result1 = GetLongestString.getLongestString(null, new String[]{"abc"});
        assertEquals("", result1);
        
        String result2 = GetLongestString.getLongestString("abc", null);
        assertEquals("", result2);
        
        String result3 = GetLongestString.getLongestString(null, null);
        assertEquals("", result3);
    }

    @Test
    public void testEmptyInputs() {
        String characters = "";
        String[] strings = {"abc", "def"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("", result);
        
        String result2 = GetLongestString.getLongestString("abc", new String[]{});
        assertEquals("", result2);
    }

    @Test
    public void testNullStringInArray() {
        String characters = "abc";
        String[] strings = {"abc", null, "ab"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("abc", result);
    }

    @Test
    public void testEmptyStringInArray() {
        String characters = "abc";
        String[] strings = {"abc", "", "ab"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("abc", result);
    }

    @Test
    public void testSingleCharacter() {
        String characters = "a";
        String[] strings = {"a", "aa", "ab"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("a", result);
    }

    @Test
    public void testLongestValidString() {
        String characters = "abcdef";
        String[] strings = {"abc", "abcde", "abcdef", "abcdeff"};
        String result = GetLongestString.getLongestString(characters, strings);
        assertEquals("abcdef", result);
    }
}
