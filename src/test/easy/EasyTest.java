

import easy.Easy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EasyTest {
    private Easy easy;
    @Before
    public void init(){
        easy = new Easy();
    }

    @Test
    public void twoSum() {
        int [] res = new int  [] {1,2};
        int [] input = new int[] {3,2,4};
        int target = 6;
        assertArrayEquals(
                res,
                easy.twoSum(input,target)
        );
    }

    @Test
    public void reverse(){
        int i1 = 123;
        int i2 = 230;
        int i3 = -142;
        int e1 = 1534236469;
        assertEquals(321,easy.reverse(i1));
        assertEquals(32,easy.reverse(i2));
        assertEquals(-241,easy.reverse(i3));
        assertEquals(0,easy.reverse(e1));
    }

    @Test
    public void isPalindrome(){
        int  i1 = 121;
        int i2 = -121;
        int i3 = 10;
        assertTrue(easy.isPalindrome(i1));
        assertFalse(easy.isPalindrome(i2));
        assertFalse(easy.isPalindrome(i3));
    }

    @Test
    public  void longestCommonPrefix(){
        String [] a1 = {"flower","flow","flight"};
        String [] a2 = {"dog","racecar","car"};
        String [] a3 = {"abca","aba","aaab"};
        String [] a4 = {"ca","a"};

        assertEquals("fl",easy.longestCommonPrefix(a1));
        assertEquals("",easy.longestCommonPrefix(a2));
        assertEquals("a",easy.longestCommonPrefix(a3));
        assertEquals("",easy.longestCommonPrefix(a4));
    }
}
