

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

    @Test
    public void isValid(){
        String s1 = "()";
        String s2 = "{}()[]";
        String s3 = "([)]";
        String s4 = "{[]}";
        String s5 = "((";

        assertTrue(easy.isValid(s1));
        assertTrue(easy.isValid(s2));
        assertFalse(easy.isValid(s3));
        assertTrue(easy.isValid(s4));
        assertFalse(easy.isValid(s5));
    }

    @Test
    public void removeElement(){
        int [] nums1 = {3,2,2,3};
        int val1 = 3;
        int [] nums2 = {0,1,2,2,3,0,4,2};
        int val2 = 2;
        int [] nums3 = {1};
        int val3 = 1;
        int [] nums4 = {2,3,4,5};
        int val4 = 6;
        int [] nums5 = {4,5};
        int val5 = 4;

        System.out.println(easy.removeElement(nums1,val1));
        System.out.println(easy.removeElement(nums2,val2));
        System.out.println(easy.removeElement(nums3,val3));
        System.out.println(easy.removeElement(nums4,val4));
        System.out.println(easy.removeElement(nums5,val5));
    }

    @Test
    public void strStr(){
        String hayStack1= "hello";
        String needle1 = "ll";
        String hayStack2 = "aaaaa";
        String needle2 = "bba";
        String hayStack3 = "blablabla";
        String needle3 = "";
        String hayStack4 = "good";
        String needle4 = "good";
        String hayStackE1 = "mississippi";
        String needleE1 = "issi";

        assertEquals(2,easy.strStr(hayStack1, needle1));
        assertEquals(-1,easy.strStr(hayStack2, needle2));
        assertEquals(0,easy.strStr(hayStack3, needle3));
        assertEquals(0,easy.strStr(hayStack4, needle4));
        assertEquals(1,easy.strStr(hayStackE1, needleE1));
    }
}
