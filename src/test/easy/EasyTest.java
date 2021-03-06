

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

    @Test
    public void searchInsert() {
        int[] n1 = {1, 3, 5, 6};
        int target1 = 5;
        int[] n2 = {1, 3, 5, 6};
        int target2 = 2;
        int[] n3 = {1, 3, 5, 6};
        int target3 = 7;
        int[] n4 = {1, 3, 5, 6};
        int target4 = 0;
        assertEquals(2, easy.searchInsert(n1, target1));
        assertEquals(1, easy.searchInsert(n2, target2));
        assertEquals(4, easy.searchInsert(n3, target3));
        assertEquals(0, easy.searchInsert(n4, target4));
    }
    @Test
    public void countAndSay(){
        int n1 = 2;
        int n2 = 4;
        int n3 = 6;
        int n4 = 3;
        int n5 = 30;

        assertEquals("11",easy.countAndSay(n1));
        assertEquals("21",easy.countAndSay(n4));
        assertEquals("1211",easy.countAndSay(n2));
        assertEquals("312211",easy.countAndSay(n3));
        System.out.println(easy.countAndSay(n5));

    }

    @Test
    public void test_length_of_last_word(){
        String s = "Hello World";
        String s2 = "";
        String s3 = "love and peaceful";
        String s4 = " love and peaceful ";
        String s5 = "a ";
        assertEquals(easy.lengthOfLastWord(s),5);
        assertEquals(easy.lengthOfLastWord(s2),0);
        assertEquals(easy.lengthOfLastWord(s3),8);
        assertEquals(easy.lengthOfLastWord(s4),8);
        assertEquals(easy.lengthOfLastWord(s5),1);
    }

    @Test
    public void test_is_subsequence(){
        String s1 = "abc";
        String t1 = "ahbgdc";
        String s2 = "axc";
        String t2 = "ahbgdc";
        String s3 = "";
        String t3 = "abcd";
        assertTrue(easy.isSubsequence(s1, t1));
        assertFalse(easy.isSubsequence(s2, t2));
        assertTrue(easy.isSubsequence(s3, t3));
    }

    @Test
    public  void test_add_strings(){
        String s1 = "100";
        String s2 = "99";
        String s3 = "1";
        String s4 = "99";
        String s5 = "69538";
        String s6 = "77025";
        assertEquals("199",easy.addStrings(s1, s2));
        assertEquals("100",easy.addStrings(s3, s4));
        assertEquals("146563",easy.addStrings(s5, s6));
    }

    @Test
    public void test_rob(){
        int [] n1 = new int []{1,2,3,1};
        int [] n2 = new int []{2,7,9,3,1};
        int [] n3 = new int []{1,2};
        int [] n4 = new int []{3,1,1,2,4,5};
        int [] n5 = new int []{1,3,1,3,100};
        assertEquals(4,easy.rob(n1));
        assertEquals(12,easy.rob(n2));
        assertEquals(2,easy.rob(n3));
        assertEquals(10,easy.rob(n4));
        assertEquals(103,easy.rob(n5));
    }

    @Test
    public void test_count_binary_substring(){
        String s1 = "10101";
        String s2 = "00110";
        String s3 = "00110011";
        String s4 = "001";
        assertEquals(4, easy.countBinarySubstrings(s1));
        assertEquals(3, easy.countBinarySubstrings(s2));
        assertEquals(6, easy.countBinarySubstrings(s3));
        assertEquals(1, easy.countBinarySubstrings(s4));
    }
}
