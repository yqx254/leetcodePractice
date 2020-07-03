package interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class InterviewTest {
    private Interview interview;
    @Before
    public void init(){
        interview = new Interview();
    }

    @Test
    public void test_is_unique(){
        String s1 = "leetcode";
        String s2 = "abc";
        String s3 = "";
        assertFalse(interview.isUnique(s1));
        assertTrue(interview.isUnique(s2));
        assertTrue(interview.isUnique(s3));
    }

    @Test
    public void test_check_permutation(){
        String s11 = "abcc";
        String s12 = "cbca";

        String s21 = "terror";
        String s22 = "teiror";

        String s31 = "goody";
        String s32 = "dooyg";

        String s41 = "";
        String s42 = "";

        String s51 = "Account";
        String s52 = "aCcount";

        assertTrue(interview.checkPermutation(s11, s12));
        assertFalse(interview.checkPermutation(s21, s22));
        assertTrue(interview.checkPermutation(s31, s32));
        assertTrue(interview.checkPermutation(s41, s42));
        assertFalse(interview.checkPermutation(s51, s52));
    }


    @Test
    public void test_can_permutePalindrome(){
        String s1 = "tactcoa";
        String s2 = "";
        String s3 = "some";
        String s4 = "naa";
        assertTrue(interview.canPermutePalindrome(s1));
        assertTrue(interview.canPermutePalindrome(s2));
        assertFalse(interview.canPermutePalindrome(s3));
        assertTrue(interview.canPermutePalindrome(s4));
    }

    @Test
    public void test_one_edit_away(){
        String sf1 = "pale";
        String ss1 = "ple";

        String sf2 = "pales";
        String ss2 = "pal";

        String sf3 = "something";
        String ss3 = "somaehing";

        String sf4 = "a";
        String ss4 = "ea";

        assertTrue(interview.oneEditAway(sf1, ss1));
        assertFalse(interview.oneEditAway(sf2, ss2));
        assertFalse(interview.oneEditAway(sf3, ss3));
        assertTrue(interview.oneEditAway(sf4, ss4));
    }
}