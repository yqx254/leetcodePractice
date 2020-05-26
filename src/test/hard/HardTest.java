package hard;


import hard.Hard;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class HardTest {
    private Hard hard;
    @Before
    public void init(){
        hard = new Hard();
    }

    @Test
    public void findMedianSortedArrays() {
        int [] nums1 = {1,2,3,4,5};
        int [] nums2 = {6};
        assertEquals(
                Double.valueOf(3.5),
                Double.valueOf(hard.findMedianSortedArrays(nums1,nums2))
        );
    }
    @Test
    public void checkMatch(){
        String s1 = "ab";
        String p1 = ".*";
        String s2 = "";
        String p2 = "";
        String s3 = "aab";
        String p3 = "c*a*b";
        String es1 = "ab";
        String ep1 = ".*c";
        String es2 = "aaaaaab";
        String ep2 = "a*ab";
        String es3 = "aca";
        String ep3 = "a*b*a*c*a";
        String es4 = "a";
        String ep4 = "ab*";
        String es5 = "bbbba";
        String ep5 = ".*a*a*";
        String es6 = "bbbba";
        String ep6 = ".*a*a";
        assertTrue(hard.isMatch(s1,p1));
        assertTrue(hard.isMatch(s2,p2));
        assertTrue(hard.isMatch(s3,p3));
        assertFalse(hard.isMatch(es1,ep1));
        assertTrue(hard.isMatch(es2,ep2));
        assertTrue(hard.isMatch(es3,ep3));
        assertTrue(hard.isMatch(es4,ep4));
        assertTrue(hard.isMatch(es5,ep5));
        assertTrue(hard.isMatch(es6,ep6));
    }

    @Test
    public void checkFindSubString(){
        String s1 = "barfoothefoobarman";
        String [] words1 = {"foo","bar"};
        String s2 = "wordgoodgoodgoodbestword";
        String [] words2 = {"word","good","best","word"};
        String s3 = "namewordgooddaysbestgoodbestword";
        String [] words3 = {"word","good","best","days"};
        String s4 = "daydayupu";
        String [] words4 = {""};
        String e1 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String [] wordsE1 = {"fooo","barr","wing","ding","wing"};
        String e2 = "a";
        String [] wordsE2 = {"a"};

        assertArrayEquals(new Object [] {0,9},hard.findSubstring(s1,words1).toArray());
        assertArrayEquals(new Object [] {},hard.findSubstring(s2,words2).toArray());
        assertArrayEquals(new Object [] {4},hard.findSubstring(s3,words3).toArray());
        assertArrayEquals(new Object [] {},hard.findSubstring(s4,words4).toArray());
        assertArrayEquals(new Object [] {13},hard.findSubstring(e1,wordsE1).toArray());
        assertArrayEquals(new Object [] {0},hard.findSubstring(e2,wordsE2).toArray());
    }

    @Test
    public void longestValidParentheses(){
        String s1 = "(()";
        String s2 = ")()())";
        String s3 = ")";
        String s4= "())))))))()";
        String s5= "()(()";
        String s6= "()";

        assertEquals(2, hard.longestValidParentheses(s1));
        assertEquals(4, hard.longestValidParentheses(s2));
        assertEquals(0, hard.longestValidParentheses(s3));
        assertEquals(2,hard.longestValidParentheses(s4));
        assertEquals(2,hard.longestValidParentheses(s5));
        assertEquals(2,hard.longestValidParentheses(s6));
    }

    @Test
    public void firstMissingPositive(){
        int [] a1 = new int []{2,1,0};
        int [] a2 = new int [] {3,4,1,-1};
        int [] a3 = new int [] {7,8,9,11,12};
        int [] a4 = new int [] {12,1,8,9,7,2,13,6,4,5};
        int [] a5 = new int [] {8,7,6,5,4,3,2,1};
        int [] e1 = new int [] {1,2,3};

        assertEquals(3,hard.firstMissingPositive(a1));
        assertEquals(2,hard.firstMissingPositive(a2));
        assertEquals(1,hard.firstMissingPositive(a3));
        assertEquals(3,hard.firstMissingPositive(a4));
        assertEquals(9,hard.firstMissingPositive(a5));
        assertEquals(4,hard.firstMissingPositive(e1));
    }

    @Test
    public void trapTest(){
        int [] a1 = new int []{0,1,0,2,1,0,1,3,2,1,2,1};
        int [] a2 = new int []{0,1,0,3,1,0,1,3,2,1,2,1};

        assertEquals(6,hard.trap(a1));
        assertEquals(9,hard.trap(a2));
    }

    @Test
    public void isMatch2Test(){
        String s1 = "aa";
        String p1 = "a";
        String s2 = "aa";
        String p2 = "*";
        String s3 = "cb";
        String p3 = "?b";
        String s4 = "adceb";
        String p4 = "a*b";
        String s5 = "acdcb";
        String p5 = "a*c?b";
        String s6 = "abcd";
        String p6 = "ab*d";
        String s7 = "";
        String p7 = "*";
        String s8 = "bbbb";
        String p8 = "*b";
        String e1 = "adceb";
        String ep1 = "*a*b";
        String e2 = "ho";
        String ep2 = "ho**";

        assertFalse(hard.isMatch2(s1,p1));
        assertTrue(hard.isMatch2(s2,p2));
        assertTrue(hard.isMatch2(s3,p3));
        assertTrue(hard.isMatch2(s4,p4));
        assertFalse(hard.isMatch2(s5,p5));
        assertTrue(hard.isMatch2(s6,p6));
        assertTrue(hard.isMatch2(s7,p7));
        assertTrue(hard.isMatch2(s8,p8));
        assertTrue(hard.isMatch2(e1,ep1));
        assertTrue(hard.isMatch2(e2,ep2));
    }
}
