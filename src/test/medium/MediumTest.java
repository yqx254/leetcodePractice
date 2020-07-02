package medium;

import medium.Medium;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    @Test
    public void intToRome(){
        int i1 = 3;
        int i2 = 9;
        int i3 = 58;
        int i4 = 1994;
        int i5 = 4;

        assertEquals("III",medium.intToRoman(i1));
        assertEquals("IX",medium.intToRoman(i2));
        assertEquals("LVIII",medium.intToRoman(i3));
        assertEquals("MCMXCIV",medium.intToRoman(i4));
        assertEquals("IV",medium.intToRoman(i5));
    }

    @Test
    public void romeToInt(){
        String s1 = "III";
        String s2 = "IX";
        String s3 = "LVIII";
        String s4 = "MCMXCIV";

        assertEquals(3,medium.romanToInt(s1));
        assertEquals(9,medium.romanToInt(s2));
        assertEquals(58,medium.romanToInt(s3));
        assertEquals(1994,medium.romanToInt(s4));
    }

    @Test
    public void threeSum(){
        int [] nums1 = {1,-1,-1,0};
        int [] nums2= {};
        int [] nums3 = {-1,0,1,2,-1,-4};
        int [] nums4 = {0,0,0,0};
        System.out.println(medium.threeSum(nums1));
        System.out.println(medium.threeSum(nums2));
        System.out.println(medium.threeSum(nums3));
        System.out.println(medium.threeSum(nums4));

    }

    @Test
    public void threeSumCloset(){
        int [] nums1 = {5,0,0,0};
        int target1 = 1;
        int [] nums2 = {6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,
                -9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,
                -1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10};
        int target2 = -52;
        assertEquals(0,medium.threeSumClosest(nums1, target1));
        assertEquals(-52,medium.threeSumClosest(nums2, target2));
    }

    @Test
    public void letterCombination(){
        String input1 = "23";
        String input2 = "";
        assertArrayEquals(new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"}
                ,medium.letterCombinations(input1).toArray());
        assertArrayEquals(new String [] {},medium.letterCombinations(input2).toArray());
    }

    @Test
    public void forSum(){
        int [] nums = {0,0,0,0,0};
        int target =0;
        System.out.println(medium.fourSum(nums, target));
    }

    @Test
    public void generator(){
        int n1 = 4;
        System.out.println(medium.generateParenthesis(n1));
    }

    @Test
    public void divide(){
        int dd1 = 10;
        int ds1 = 3;
        int dd2 = 7;
        int ds2 = -3;
        int de1 = -2147483648;
        int des1 = -1;
        int de2 = 2147483647;
        int des2 = 2;
        assertEquals(3, medium.divide(dd1,ds1));
        assertEquals(-2, medium.divide(dd2,ds2));
        assertEquals(2147483647, medium.divide(de1,des1));
        assertEquals(1073741823, medium.divide(de2,des2));
    }

    @Test
    public void nextPermutation(){
        int [] a1 = {5,4,3,2,1};
        int [] a2 = {1,2,3,4,5};
        int [] a3 = {1,2,3,5,6,4,9};
        int [] a4 = {};
        medium.nextPermutation(a1);
        medium.nextPermutation(a2);
        medium.nextPermutation(a3);
        medium.nextPermutation(a4);
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        System.out.println(Arrays.toString(a4));
    }

    @Test
    public void search(){
        int [] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;

        int [] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;

        int [] nums3 = {4,5,6,7,0,1,2};
        int target3 = 4;

        int [] nums4 = {4,5,1};
        int target4 = 8;

        int [] numsE1 = {3,1};
        int targetE1 = 1;

        assertEquals(4,medium.search(nums1,target1));
        assertEquals(-1,medium.search(nums2,target2));
        assertEquals(0,medium.search(nums3,target3));
        assertEquals(-1,medium.search(nums4,target4));
        assertEquals(1,medium.search(numsE1,targetE1));
    }

    @Test
    public void searchRange(){
        int [] nums1 = {5,7,7,8,8,10,10};
        int target1 = 10;
        int [] nums2  = {5,7,7,8,8,10,12};
        int target2 = 8;
        int [] nums3  = {2,2};
        int target3 = 2;
        int [] numsE1 = {1,1,2};
        int targetE1 = 1;
        int [] numsE2 = {0,0,0,1,2,3};
        int targetE2 = 0;
        int [] numsE3 = {0,0,0,1,2,3,3,3};
        int targetE3 = 3;
        assertArrayEquals(new int [] {5,6},medium.searchRange(nums1, target1));
        assertArrayEquals(new int [] {3,4},medium.searchRange(nums2, target2));
        assertArrayEquals(new int [] {0,1},medium.searchRange(nums3, target3));
        assertArrayEquals(new int [] {0,1},medium.searchRange(numsE1, targetE1));
        assertArrayEquals(new int [] {0,2},medium.searchRange(numsE2, targetE2));
        assertArrayEquals(new int [] {5,7},medium.searchRange(numsE3, targetE3));
    }

    @Test
    public void checkSudoku(){
        char [] [] sudoku1 = {
                {'5','3','.',  '.','7','.',  '.','.','.'},
                {'6','.','.',   '1','9','5',   '.','.','.'},
                {'.','9','8',   '.','.','.',    '.','6','.'},
                {'8','.','.',   '.','6','.',   '.','.','3'},
                {'4','.','.',   '8','.','3',   '.','.','1'},
                {'7','.','.',   '.','2','.',   '.','.','6'},
                {'.','6','.',   '.','.','.',   '2','8','.'},
                {'.','.','.',   '4','1','9',   '.','.','5'},
                {'.','.','.',   '.','8','.',   '.','7','9'},
        };
        char [] [] sudoku2 = {
                {'9','3','.',  '.','7','.',  '.','.','.'},
                {'6','.','.',   '1','9','5',   '.','.','.'},
                {'.','9','8',   '.','.','.',    '.','6','.'},
                {'8','.','.',   '.','6','.',   '.','.','3'},
                {'4','.','.',   '8','.','3',   '.','.','1'},
                {'7','.','.',   '.','2','.',   '.','.','6'},
                {'.','6','.',   '.','.','.',   '2','8','.'},
                {'.','.','.',   '4','1','9',   '.','.','5'},
                {'.','.','.',   '.','8','.',   '.','7','9'},
        };
        assertTrue(medium.isValidSudoku(sudoku1));
        assertFalse(medium.isValidSudoku(sudoku2));
    }

    @Test
    public void jumpTest(){
        int [] a1 = {2,3,1,1,4};
        int [] a2 = {3,2,1,0,4};

        assertTrue(medium.canJump(a1));
        assertFalse(medium.canJump(a2));
    }

    @Test
    public void permuteTest(){
        int [] a1 = {};

        System.out.println(medium.permute(a1).toString());
    }

    @Test
    public void permuteUniqueTest(){
        int [] a1 = {1,1,3};
        System.out.println(medium.permuteUnique(a1).toString());
    }

    @Test
    public void groupAnagrams(){
        String [] a1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(medium.groupAnagrams(a1));
    }

    @Test
    public void testSpiral(){
        int [][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int [][] matrix2 = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        int [][] matrix3 = {
                {1,2,3,4,9,12},
                {5,6,7,8,6,5},
                {9,10,11,12,9,3},
                {33,44,61,7,7,1},
                {33,44,61,7,9,10},
                {15,23,9,89,8,11},
        };
        System.out.println(medium.spiralOrder(matrix1));
        System.out.println(medium.spiralOrder(matrix2));
        System.out.println(medium.spiralOrder(matrix3));
    }

    @Test
    public void testMerge(){
        int [][] arr = {{1,3},{2,6},{8,10},{15,18}};
        int [][] arr2 = {{1,4},{4,5}};
        int [][] arr3 = {{}};
        int [][] arr4 = {};
        int [][] arr5 = {{1,100},{3,6},{6,9},{9,12},{13,28}};

        System.out.println(Arrays.deepToString(medium.merge(arr)));
        System.out.println(Arrays.deepToString(medium.merge(arr2)));
        System.out.println(Arrays.deepToString(medium.merge(arr3)));
        System.out.println(Arrays.deepToString(medium.merge(arr4)));
        System.out.println(Arrays.deepToString(medium.merge(arr5)));
    }

    @Test
    public void test_insert(){
        int [][] arr = {{1,3},{6,9}};
        int [] new1 = {2,5};

        int [][] arr2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int [] new2 = {4,8};

        int [][] arr3 = {{2,4},{5,7}};
        int [] new3 = {3,6};

        int [][] arr4 = {{6,8}};
        int []new4 = {1,5};

        int [][] arr5 = {{1,2},{3,4},{5,6}};
        int []new5 = {7,8};

        int [][] arr6 = {{1,2}};
        int [] new6 = {0,0};

        int [][] arr7 = {{3,5},{12,15}};
        int [] new7 = {6,12};

        System.out.println(Arrays.deepToString(medium.insert(arr, new1)));
        System.out.println(Arrays.deepToString(medium.insert(arr2, new2)));
        System.out.println(Arrays.deepToString(medium.insert(arr3, new3)));
        System.out.println(Arrays.deepToString(medium.insert(arr4, new4)));
        System.out.println(Arrays.deepToString(medium.insert(arr5, new5)));
        System.out.println(Arrays.deepToString(medium.insert(arr6, new6)));
        System.out.println(Arrays.deepToString(medium.insert(arr7, new7)));
    }

    @Test
    public void test_generate(){
        int n1 = 3;
        int n2 = 4;
        System.out.println(Arrays.deepToString(medium.generateMatrix(n1)));
        System.out.println(Arrays.deepToString(medium.generateMatrix(n2)));
    }

    @Test
    public void test_find_k_largest(){
        int []a1 = {6,1,9,3,12,25,2,8,4};
        int k1 = 3;
        int []a2 = {3, 2, 1, 5, 6, 4};
        int k2 = 2;
        int [] a3 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k3 = 4;
        int [] a4 = {};
        int k4 = 0;
        System.out.println(medium.findKthLargest(a1,k1));
        System.out.println(medium.findKthLargest(a2,k2));
        System.out.println(medium.findKthLargest(a3,k3));
        System.out.println(medium.findKthLargest(a4,k4));
    }
}
