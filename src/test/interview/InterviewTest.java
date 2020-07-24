package interview;

import org.junit.Before;
import org.junit.Test;
import pojo.WordsFrequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void test_compress_string(){
        String s1 = "aabcccccaaa";
        String s2 = "abbccd";
        String s3 = "";
        String s4 = "ABCDEFGHIJKLMNN";
        String s5 = "bb";

        assertEquals("a2b1c5a3",interview.compressString(s1));
        assertEquals("abbccd",interview.compressString(s2));
        assertEquals("",interview.compressString(s3));
        assertEquals("ABCDEFGHIJKLMNN",interview.compressString(s4));
        assertEquals("bb",interview.compressString(s5));
    }

    @Test
    public void test_rotate(){
        int [][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int [][] matrix3 = {{1,2},{4,5}};
        int [][] matrix4 = {{}};
        interview.rotate(matrix1);
        interview.rotate(matrix2);
        interview.rotate(matrix3);
        interview.rotate(matrix4);
        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
        System.out.println(Arrays.deepToString(matrix3));
        System.out.println(Arrays.deepToString(matrix4));
    }

    @Test
    public void test_set_zeroes(){
        int [][] matrix1 = {{1, 1, 1},{1, 0, 1},{1, 1, 1}};
        int [][] matrix2 = {{0, 1, 2, 0},{3, 4, 5, 2},{1, 3, 1 ,5}};

        interview.setZeroes(matrix1);
        interview.setZeroes(matrix2);

        System.out.println(Arrays.deepToString(matrix1));
        System.out.println(Arrays.deepToString(matrix2));
    }

    @Test
    public void test_fliped_string(){
        String s11 = "waterbottle";
        String s12 = "erbottlewat";

        String s21 = "";
        String s22 = "";

        String s31 = "aba";
        String s32 = "aa";

        String s41 = "somethingnew";
        String s42 = "thingnetsome";

        String s51 = "PvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmb";
        String s52 = "vCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRMvCsCPPmlKBSzXDWSvrxLBPdAvRpgcIwNOVQDdwPIElrAFqmbPvcvpkpHwaXQxpgGzURBvHRM";

        assertTrue(interview.isFlipedString(s11,s12));
        assertTrue(interview.isFlipedString(s21,s22));
        assertFalse(interview.isFlipedString(s31,s32));
        assertFalse(interview.isFlipedString(s41,s42));
        System.out.println(interview.isFlipedString(s51, s52));

    }

    @Test
    public void test_merge(){
        int [] A1 = new int [] {1,2,3,0,0,0};
        int [] B1 = new int [] {2,5,6};
        int m1 = 3;
        int n1 = 3;
        int [] A2 = new int [] {1,3,4,0,0};
        int [] B2 = new int [] {8,9};
        int m2 = 3;
        int n2 = 2;
        interview.merge(A1,m1, B1, n1);
        interview.merge(A2,m2, B2, n2);
        System.out.println(Arrays.toString(A1));
        System.out.println(Arrays.toString(A2));
    }

    @Test
    public void test_trailing_zeroes(){
        int n1 = 5;
        int n2 = 10;
        assertEquals(1,interview.trailingZeroes(n1));
        assertEquals(1,interview.trailingZeroes(n2));
    }

    @Test
    public void test_solve_n_queen(){
        int n = 8;
        System.out.println(interview.solveNQueens(n).size());
    }

    @Test
    public void test_word_frequency(){
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        assertEquals(wordsFrequency.get("you"), 0);
        assertEquals(wordsFrequency.get("have"), 2);
        assertEquals(wordsFrequency.get("an"), 1);
        assertEquals(wordsFrequency.get("apple"), 1);
        assertEquals(wordsFrequency.get("pen"), 1);
    }

    @Test
    public void test_hanota(){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> c= new ArrayList<>();

        for(int i = 0; i < 5; i ++){
            a.add(i);
        }
        //注意这个！
        List<Integer> tmp = new ArrayList<>(a);
        interview.hanota(a, b, c);
        assertArrayEquals(tmp.toArray(),c. toArray());
    }
}