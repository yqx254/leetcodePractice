

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
        String s = "babad";
        String s1 = "cbbd";
        String s2  = "";
        String e1 = "a";
        String e2 = "tattarrattat";
        assertEquals("bab",medium.longestPalindrome(s));
        assertEquals("bb",medium.longestPalindrome(s1));
        assertEquals("",medium.longestPalindrome(s2));
        assertEquals("a",medium.longestPalindrome(e1));
        assertEquals("tattarrattat",medium.longestPalindrome(e2));
    }

    @Test
    public void zConvert(){
        String s1 = "LEETCODEISHIRING";
        String s2 = "LEETCODEISHIRING";
        String e1 = "ABCD";
        int num1 = 3;
        int num2 = 4;
        int nume1 = 2;
        assertEquals("LCIRETOESIIGEDHN",medium.convert(s1, num1));
        assertEquals("LDREOEIIECIHNTSG",medium.convert(s2, num2));
        assertEquals("ACBD",medium.convert(e1, nume1));
    }

    @Test
    public void atoi(){
        String s1 = "-45";
        String s2 = "8888 and words";
        String s3 = "    167";
        assertEquals(-45,medium.myAtoi(s1));
        assertEquals(0,medium.myAtoi(s2));
        assertEquals(167,medium.myAtoi(s3));
    }

    @Test
    public void maxArea(){
        int [] height = {2,3};
        assertEquals(49,medium.maxArea(height));
    }
}
