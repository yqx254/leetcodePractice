package medium;


import medium.Medium;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class MediumTest {

    private Medium medium;
    @Before
    public void init(){
        medium = new Medium();
    }
    @Test
    public void LongestSub() {
        String s = "abba";
        String s2 = "abcabcbb";
        String s3 = "pwwkew";
        String e1 = "dvdf";
        String e2 = "bbbbb";
        assertEquals(
                2,
                medium.lengthOfLongestSubstring(s)
        );
        assertEquals(
                3,
                medium.lengthOfLongestSubstring(e1)
        );

        assertEquals(
                3,
                medium.lengthOfLongestSubstring(s2)
        );
        assertEquals(
                3,
                medium.lengthOfLongestSubstring(s3)
        );
        assertEquals(
                1,
                medium.lengthOfLongestSubstring(e2)
        );
    }

    @Test
    public void longestPalindrome(){
        String s = "";
    }
}
