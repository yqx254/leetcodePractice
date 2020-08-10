package interview;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class OfferTest {
    private Offer offer;

    @Before
    public void init(){
        offer = new Offer();
    }

    @Test
    public void test_find_repeat_number(){
        int [] nums1 = new int[] {1,2,1};
        int [] nums2 = new int[] {2, 3, 1, 0, 2, 5, 3};
        int [] nums3 = new int[] {1,0, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        assertEquals(offer.findRepeatNumber(nums1),1);
        assertEquals(offer.findRepeatNumber(nums2),2);
        assertEquals(offer.findRepeatNumber(nums3),11);
    }

    @Test
    public void test_fib(){
        assertEquals(offer.fib(2),1);
        assertEquals(offer.fib(5),5);
        assertEquals(offer.fib(30),832040);
    }

    @Test
    public void test_num_ways(){
        assertEquals(offer.numWays(2),2);
        assertEquals(offer.numWays(7),21);
        assertEquals(offer.numWays(0),1);
        assertEquals(offer.numWays(1),1);
        System.out.println(offer.numWays(45));
    }

    @Test
    public void test_min_array(){
        assertEquals(offer.minArray(new int [] {3,4,5,1,2}),1);
        assertEquals(offer.minArray(new int [] {2,2,2,0,1}),0);
    }

    @Test
    public void test_print_number(){
        System.out.println(Arrays.toString(offer.printNumbers(2)));
        System.out.println(Arrays.toString(offer.printNumbers(3)));
        System.out.println(Arrays.toString(offer.printNumbers(4)));
    }

    @Test
    public void test_exists(){
        char [][] board1 = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word1 = "ABCCED";
        char [][] board2 = new char [][]{{'a','b'},{'c','d'}};
        String word2 = "abcd";
        String word3 = "SEE";
        char [][] board3 = new char[][]{{'r','v','l','n','w','e','c','z','w','q','g','l','h','m','r','i','h','i','n','j','z','m','t','m','d','p','l','k','l','g','m','c','d','x','s','a','e','w','b','c','m','i','q','u','w','h','c','d','r','r','p','q','g','i','e','l','z','r','v','k','x','j','p','b','h','h','d','n','d','g','r','s','o','h'},{'m','m','q','q','s','h','k','j','z','q','r','f','d','t','w','z','f','u','i','w','x','r','f','c','g','j','i','y','d','z','h','p','l','y','h','d','h','r','m','j','j','g','o','n','b','l','o','i','h','y','f','e','s','k','g','a','v','o','y','y','n','i','p','b','i','z','g','p','q','v','y','c','d','p'},{'r','e','a','h','o','h','f','t','n','z','g','v','a','b','l','a','c','z','k','r','c','s','q','i','k','j','d','k','n','g','z','g','m','z','n','b','i','u','w','v','u','c','s','w','g','e','y','i','d','j','b','h','b','s','p','n','d','v','y','s','d','x','y','s','z','l','v','j','f','r','h','b','w','z'},{'x','c','d','w','k','i','h','l','p','i','f','h','w','k','c','w','c','h','v','a','z','w','n','u','g','t','o','n','u','k','m','u','m','q','s','y','y','z','l','q','j','r','x','h','d','z','d','g','i','z','i','i','v','w','e','d','p','s','q','l','e','f','h','s','v','z','q','v','y','c','n','i','v','k'},{'r','y','l','v','g','u','w','p','c','t','n','i','x','e','d','n','p','h','s','z','a','p','y','s','n','z','w','a','j','r','l','a','s','y','x','y','s','t','p','w','n','c','f','k','i','i','z','y','r','s','z','t','j','x','m','y','y','i','z','h','c','m','k','u','k','h','u','d','b','m','b','q','q','g'},{'a','z','q','z','z','k','t','y','d','d','x','p','b','w','a','c','f','c','o','p','y','z','z','u','e','c','g','f','s','x','o','s','y','g','r','x','q','n','v','w','q','u','n','t','q','n','w','y','r','m','p','r','n','o','m','t','q','s','b','i','r','p','a','p','x','u','m','q','h','j','m','z','e','z'},{'u','w','p','s','u','i','f','k','a','u','y','m','o','r','g','p','z','y','g','c','p','d','y','c','t','h','n','h','g','r','h','a','q','y','v','k','g','a','w','g','u','x','s','i','o','z','z','p','z','f','r','o','j','r','s','e','y','g','m','g','z','v','j','p','t','e','c','b','e','a','i','a','x','c'},{'l','n','d','k','d','c','q','w','t','b','o','l','h','o','t','t','v','t','q','e','k','l','i','o','n','o','r','x','o','o','b','z','e','f','m','j','j','c','f','c','f','v','q','m','m','j','i','h','e','a','l','r','m','v','h','b','j','y','a','z','p','b','b','t','g','n','c','s','r','j','u','w','h','m'},{'k','t','w','s','a','c','t','n','t','h','i','b','k','t','b','k','s','q','n','t','j','w','i','n','o','z','x','k','v','e','x','g','z','t','a','z','v','t','o','r','c','y','s','o','r','v','a','l','m','o','h','x','m','p','l','a','p','k','k','m','q','j','s','p','e','t','q','a','o','e','t','t','c','n'},{'h','v','i','i','i','u','y','p','u','k','h','f','m','w','r','y','i','h','i','d','w','m','y','o','o','m','s','j','h','w','w','r','t','f','b','b','b','z','t','v','l','a','c','x','y','t','x','i','a','h','l','y','u','j','m','k','y','g','u','h','e','s','y','x','x','z','b','b','a','w','w','l','w','z'},{'k','w','u','k','e','v','r','s','v','n','d','i','y','d','q','u','l','v','m','j','u','m','l','v','n','l','r','l','z','p','k','l','n','f','v','s','c','n','m','x','c','p','h','a','t','a','w','g','v','l','r','r','x','c','p','m','q','i','x','r','y','k','c','n','r','a','h','t','p','t','s','r','l','c'},{'u','g','c','q','m','z','b','f','s','a','k','h','m','a','q','k','r','q','w','v','d','n','v','l','i','k','e','c','c','p','e','w','x','i','o','j','j','s','r','c','s','b','l','h','b','b','r','u','r','p','p','v','c','n','g','k','x','m','m','b','e','t','z','b','d','o','n','p','i','e','r','a','f','c'},{'j','i','g','a','e','x','p','v','u','t','i','c','f','i','p','s','l','v','n','l','y','q','b','l','f','j','r','y','l','y','d','v','g','j','x','k','i','p','g','d','i','q','f','o','y','w','i','k','r','x','x','q','p','y','d','v','j','v','v','u','t','a','r','c','l','r','o','u','g','w','z','q','n','e'},{'g','l','d','q','x','u','n','u','m','d','u','s','a','d','n','x','a','i','y','t','m','l','k','b','f','s','x','e','l','m','l','r','a','q','k','x','k','z','u','z','e','o','r','e','s','g','e','u','q','e','n','d','p','y','g','v','q','f','b','b','s','o','v','s','e','h','r','r','g','l','s','l','a','j'},{'r','s','r','v','o','h','z','b','m','r','b','u','m','s','a','p','v','u','e','s','m','k','z','d','b','g','p','t','t','r','e','m','l','v','i','z','f','j','a','t','a','c','o','o','w','o','g','t','k','m','m','w','w','l','b','a','t','s','v','o','j','c','b','u','x','l','v','e','w','w','y','z','a','o'},{'n','y','c','t','r','m','f','f','k','e','t','n','e','o','g','b','d','r','d','g','o','d','r','j','h','n','f','h','m','h','v','c','f','z','x','z','n','d','e','x','j','x','n','p','m','t','q','r','m','u','x','a','x','o','k','g','d','r','o','s','b','j','w','i','l','t','h','y','y','o','y','h','l','l'},{'w','z','g','n','q','s','h','p','v','g','f','f','m','j','y','c','d','z','o','z','i','z','s','r','x','r','f','v','a','t','i','x','s','o','m','l','j','v','a','e','b','g','j','p','r','h','s','w','j','g','v','r','f','p','i','e','i','o','a','j','h','k','i','b','z','u','o','i','p','p','m','s','x','x'},{'h','q','g','z','m','p','f','j','g','m','y','r','r','h','h','t','s','q','d','a','r','e','w','i','m','l','z','a','f','w','z','m','o','g','o','a','v','v','j','e','i','h','x','b','q','e','u','k','u','z','k','n','e','i','v','s','v','u','v','a','s','u','n','g','c','b','g','y','y','r','e','g','b','b'},{'h','r','h','d','e','b','f','q','q','l','z','o','d','u','i','a','v','d','x','k','j','z','n','s','z','l','j','d','u','k','g','d','e','n','h','i','q','o','y','h','z','z','v','c','u','f','f','r','i','c','d','u','b','q','m','b','d','x','g','x','k','p','b','q','c','k','a','t','y','a','c','x','a','x'},{'b','w','e','g','n','n','k','q','h','m','i','v','p','n','u','x','l','e','m','o','w','r','y','w','k','y','z','o','x','z','l','y','v','p','h','k','e','r','c','n','f','k','i','w','x','f','u','k','l','i','y','i','z','y','g','l','y','f','z','v','e','k','w','b','c','f','l','i','y','p','w','e','z','g'},{'c','z','l','y','l','x','h','m','f','g','m','l','s','n','r','t','i','x','g','g','z','i','l','m','q','m','c','o','q','d','v','u','e','g','t','s','f','c','e','k','i','s','y','c','f','r','w','q','q','e','w','r','m','k','e','e','w','i','v','o','n','q','i','s','y','d','k','e','f','q','q','q','i','q'},{'s','o','h','q','e','a','u','c','r','i','m','x','p','i','f','k','y','t','c','h','n','a','m','z','g','s','p','x','i','z','n','c','n','x','v','t','x','r','w','o','c','k','o','r','v','t','d','t','o','f','c','b','f','p','a','o','h','r','l','r','r','a','t','g','x','o','a','w','i','y','n','k','i','b'},{'d','f','u','g','z','l','l','d','o','s','s','p','g','b','i','t','s','z','u','m','g','t','c','i','q','k','g','d','w','q','e','z','w','a','h','x','l','s','a','a','n','v','r','v','w','z','r','p','b','l','b','h','e','f','p','u','s','x','z','q','p','d','q','n','g','x','k','t','s','n','t','h','i','m'},{'e','e','o','v','v','p','i','y','y','n','e','p','j','y','m','l','o','b','q','g','p','w','g','b','q','y','q','l','h','a','y','l','h','o','j','c','f','r','b','d','g','h','s','s','f','g','d','v','h','t','c','y','q','i','c','i','i','u','t','p','v','t','c','c','h','n','e','m','f','h','r','n','o','j'},{'f','v','p','i','r','z','e','v','z','w','d','d','e','n','y','z','e','t','t','g','x','c','u','b','p','b','l','i','o','z','s','w','v','j','g','o','k','k','j','m','g','m','p','m','b','p','m','f','k','f','l','h','h','h','l','y','k','w','j','b','v','b','x','s','m','d','g','x','o','r','j','w','f','a'},{'j','g','q','x','l','a','c','z','k','l','i','v','m','t','t','v','w','q','y','t','j','k','w','r','j','m','l','u','l','q','v','w','x','n','t','k','n','x','j','z','k','s','u','w','n','n','t','j','e','t','e','p','e','c','i','p','r','t','k','c','k','h','a','j','u','t','t','j','q','f','j','a','x','d'},{'z','m','t','u','x','z','o','d','q','u','f','a','l','y','u','v','a','g','c','a','p','y','v','k','i','n','p','r','q','o','w','r','c','p','l','b','q','b','e','i','v','m','j','h','k','d','e','n','l','j','p','c','h','l','o','p','y','e','i','o','u','f','f','x','w','t','y','p','u','f','x','s','r','g'},{'b','b','l','h','o','y','s','e','a','a','r','p','r','p','v','c','g','p','h','n','m','f','i','n','u','f','s','u','z','j','a','a','m','o','j','b','m','c','h','p','e','a','e','v','r','z','z','x','q','g','n','f','o','x','s','k','c','k','e','b','v','h','d','h','v','n','k','j','r','t','y','v','t','e'},{'s','l','d','s','k','w','y','x','b','o','x','t','z','z','f','d','d','c','k','g','l','h','v','w','r','m','p','p','h','l','u','c','w','z','u','g','x','u','g','y','j','d','t','i','e','y','n','h','c','a','q','o','h','n','k','a','a','b','s','j','o','o','n','k','n','h','t','l','c','b','l','l','g','f'},{'v','m','f','k','u','i','k','m','w','u','z','i','u','b','l','m','n','a','a','a','m','q','k','f','d','m','i','q','z','o','v','u','b','b','g','x','l','r','l','j','n','k','r','h','o','c','w','d','e','y','f','r','q','p','y','v','d','h','m','c','v','j','y','w','m','f','v','x','y','g','g','l','t','z'},{'u','h','e','s','m','i','r','t','b','j','l','a','f','o','h','t','r','c','e','r','b','r','y','w','q','w','d','z','j','w','y','e','f','e','y','t','p','p','o','q','b','z','q','i','o','z','d','h','c','h','a','f','y','z','d','p','v','g','q','h','e','q','n','l','v','l','g','k','d','v','c','e','u','v'},{'m','k','u','p','r','y','y','s','d','x','t','h','o','q','p','e','x','w','u','k','j','r','w','q','b','b','l','g','f','h','b','t','s','v','k','l','u','i','f','x','h','y','g','v','r','w','b','o','u','y','b','d','p','z','t','t','a','g','z','f','o','c','a','i','x','m','v','t','u','b','t','c','b','z'},{'z','s','x','d','j','r','b','k','v','s','j','o','l','l','x','m','s','l','o','s','v','o','e','q','h','a','t','a','e','v','a','g','p','x','j','y','r','m','i','m','e','t','a','s','e','z','g','w','m','v','o','h','l','u','a','s','v','t','v','z','q','v','f','g','u','q','e','l','c','p','z','j','i','c'},{'b','n','b','h','l','o','e','c','v','p','w','x','i','t','r','d','v','h','a','a','n','w','t','u','k','v','j','j','e','t','l','h','i','p','p','u','d','t','w','a','l','u','y','t','q','p','y','l','y','a','n','o','y','g','i','i','c','t','u','i','m','h','q','x','w','h','r','b','a','p','c','l','l','c'},{'g','b','r','g','m','r','g','a','f','h','i','p','r','k','k','l','v','z','v','l','w','t','s','p','v','u','g','z','i','r','b','o','v','u','x','j','n','f','l','v','m','u','m','e','g','x','r','b','y','m','o','w','i','g','l','f','d','t','e','l','m','h','b','h','d','y','t','q','g','e','n','s','y','a'},{'y','f','z','q','g','z','e','v','v','o','d','i','t','i','b','z','t','p','i','x','x','n','x','q','g','d','w','t','y','v','t','w','c','u','o','i','t','v','f','o','l','l','y','f','t','z','g','p','p','p','m','o','c','j','g','i','p','c','e','n','z','z','l','b','u','c','m','n','x','r','e','i','c','c'},{'p','y','e','w','n','v','n','z','l','r','k','t','c','b','x','g','o','x','f','c','a','b','e','m','r','b','g','v','l','k','z','d','i','f','z','x','c','o','w','n','f','j','g','j','k','e','p','b','d','x','d','d','a','h','s','r','k','y','o','v','i','q','y','t','v','z','q','y','p','p','n','v','y','u'},{'g','k','a','y','l','d','v','o','i','x','x','a','p','h','y','f','f','j','x','f','e','t','h','u','t','w','l','i','t','l','c','a','w','e','y','j','h','v','a','q','s','z','s','j','h','r','p','o','c','o','t','i','h','c','e','c','z','q','l','s','b','p','s','z','w','q','l','d','l','n','v','e','m','o'},{'p','v','h','g','j','l','v','f','t','e','h','x','h','g','p','u','z','t','l','t','u','h','k','f','n','v','u','k','b','h','y','r','c','h','x','o','u','s','t','n','x','c','n','g','j','c','c','k','v','p','d','q','x','p','x','m','n','s','w','o','b','x','h','f','g','h','t','b','b','o','o','a','r','d'},{'g','c','g','k','o','d','a','r','v','z','h','v','n','u','p','j','k','q','i','u','x','p','b','t','q','e','h','g','f','a','k','n','e','s','y','s','x','a','m','t','b','v','q','o','r','f','z','b','x','i','x','u','z','a','n','p','f','x','x','k','x','j','z','c','b','z','w','b','z','i','u','c','d','k'},{'s','u','r','u','y','o','c','v','i','d','y','w','u','d','t','r','p','s','b','o','w','e','q','t','f','r','d','b','u','h','n','m','d','e','g','d','s','k','b','d','p','z','z','j','c','u','b','t','o','e','h','l','i','x','g','o','p','j','p','l','s','d','z','w','j','i','z','c','u','a','f','k','b','g'},{'t','d','c','w','w','q','a','g','d','j','f','j','z','w','t','q','j','n','v','j','j','f','t','l','j','n','n','q','z','p','w','t','u','a','r','t','q','s','z','u','d','g','d','e','d','y','u','o','m','s','x','x','x','q','k','i','g','y','y','f','p','u','a','j','u','s','c','m','m','d','i','r','m','o'},{'v','r','m','r','f','a','j','d','a','i','v','k','q','d','k','o','j','b','k','j','l','g','d','p','v','p','v','d','g','h','r','d','y','g','v','d','i','g','i','i','r','g','v','h','j','f','y','s','h','k','e','u','r','h','l','o','x','g','r','f','p','l','j','n','r','g','t','z','m','b','k','d','h','f'},{'n','r','k','n','l','t','x','p','n','q','z','b','e','w','h','y','d','x','j','m','m','a','s','f','b','h','h','l','m','q','q','z','j','d','o','x','w','m','m','m','e','l','n','l','j','w','j','n','v','s','b','i','u','u','n','v','d','w','j','p','p','z','p','y','c','f','v','b','r','k','p','y','x','c'},{'j','j','a','s','y','w','k','z','e','g','v','t','b','y','s','k','q','h','m','h','h','q','m','f','r','g','r','g','e','o','k','n','z','l','f','x','j','r','z','p','x','w','i','a','x','c','l','n','l','z','u','v','p','g','a','j','m','r','r','q','h','e','d','h','p','k','g','a','b','f','p','a','c','z'},{'b','z','c','o','m','p','n','i','k','c','q','k','n','d','d','f','v','l','j','b','u','a','l','a','a','p','g','p','p','k','o','s','j','s','g','x','i','t','h','s','y','x','f','l','a','k','s','y','v','d','z','r','d','m','s','f','d','a','u','v','k','l','n','v','f','u','u','n','p','b','i','p','a','p'},{'d','d','z','v','b','x','z','c','o','e','q','i','k','u','i','e','p','u','r','e','p','x','a','l','m','s','m','u','h','n','l','k','s','n','i','t','k','h','v','a','n','l','l','x','h','t','e','y','o','v','d','f','u','f','r','h','x','f','d','f','u','p','r','m','c','z','h','o','i','e','q','w','q','b'},{'t','z','x','z','y','n','v','b','s','p','i','l','y','g','t','c','l','p','t','e','e','v','e','l','l','o','q','b','m','i','d','g','h','c','h','f','p','c','i','h','u','r','v','u','z','o','w','m','f','p','q','j','m','w','v','z','l','l','b','x','v','g','f','c','i','n','k','z','r','u','g','n','n','d'},{'i','m','t','g','y','z','w','r','i','k','n','d','k','y','q','n','y','l','v','d','q','f','s','c','e','m','w','m','z','m','q','j','a','j','q','z','i','o','s','t','y','f','y','k','g','p','z','e','c','u','j','u','z','e','w','f','q','v','s','r','j','i','b','j','t','r','k','e','f','c','x','f','i','v'},{'q','o','m','p','u','r','m','f','l','n','j','k','t','z','h','n','t','q','x','u','z','q','l','k','w','s','m','t','x','w','r','p','m','f','f','g','w','t','o','i','g','x','u','b','z','b','o','s','r','l','m','s','e','z','c','a','r','r','w','q','n','n','g','c','s','l','k','p','g','y','z','m','y','v'},{'q','x','w','e','r','p','s','f','h','w','g','k','w','x','d','s','n','s','h','v','u','a','g','f','r','o','f','s','d','d','n','t','c','j','x','v','y','r','a','f','n','i','r','k','h','u','e','x','p','m','s','j','o','b','q','f','p','y','x','s','b','m','l','g','v','l','b','v','c','e','c','q','m','w'},{'c','u','s','i','r','h','u','l','t','i','m','l','p','c','j','o','u','n','a','i','t','x','t','w','s','x','c','x','p','r','v','r','n','n','a','g','x','w','r','q','h','e','b','w','g','n','l','a','a','l','k','v','l','d','r','d','d','u','c','s','n','z','m','a','n','o','g','m','k','x','e','r','b','h'},{'q','j','u','d','k','u','o','w','p','z','c','j','f','f','f','j','x','s','j','j','s','y','x','a','k','k','x','q','d','b','x','t','k','s','w','w','m','n','t','e','o','v','n','v','a','s','f','z','m','q','l','e','o','k','e','a','u','d','q','y','e','n','r','p','h','q','l','w','d','g','a','r','b','p'},{'n','d','j','u','d','v','k','q','b','a','a','h','c','v','k','u','t','r','j','m','g','r','c','t','n','h','a','p','b','d','e','o','h','n','k','m','k','w','c','l','y','c','s','c','z','e','w','u','v','h','j','d','a','l','x','p','v','z','g','w','c','k','m','j','z','y','x','j','u','z','w','s','e','o'},{'w','d','v','u','a','q','b','j','u','e','w','t','t','r','s','a','p','w','m','b','g','o','z','f','x','v','f','w','p','l','k','l','q','h','f','q','y','j','z','u','n','w','n','i','n','h','k','f','d','x','g','l','l','i','r','k','d','y','g','t','j','t','g','z','a','m','s','a','v','r','u','i','n','j'},{'s','d','s','d','i','w','a','q','h','n','y','a','x','e','y','g','z','j','z','f','l','b','r','d','c','o','u','y','y','k','i','r','p','c','u','x','y','u','p','i','j','o','k','g','u','l','o','t','u','n','a','h','r','u','k','t','i','h','r','j','t','b','a','i','g','u','f','e','q','u','o','z','k','z'},{'h','g','k','w','z','g','l','c','o','c','w','a','x','e','h','r','n','a','u','p','i','a','l','p','h','b','m','v','c','y','u','m','f','g','k','g','n','v','i','d','a','e','d','x','l','n','q','a','n','l','q','y','l','b','p','s','f','b','q','h','a','k','v','h','t','f','n','i','b','w','l','d','c','q'},{'a','n','d','r','q','t','e','i','r','p','j','g','k','q','k','a','a','k','m','v','t','h','b','g','p','e','e','c','h','h','v','j','w','y','c','m','r','g','u','k','y','g','r','k','w','d','k','y','p','w','u','i','g','x','o','v','d','v','a','k','c','v','v','a','v','a','p','n','g','j','z','g','r','s'},{'q','q','v','c','o','k','b','k','s','h','h','j','e','k','e','e','w','i','z','u','i','x','u','x','k','c','j','l','j','c','e','b','s','z','e','h','m','h','t','e','o','d','p','s','n','t','x','m','d','y','g','o','v','a','l','h','c','w','v','n','z','z','p','r','a','v','a','o','c','w','v','s','z','k'},{'k','o','g','j','a','j','k','i','x','h','k','l','r','n','j','m','c','k','n','t','c','p','o','e','e','s','c','z','k','b','j','x','s','r','g','s','b','s','d','a','c','n','n','t','c','z','h','f','j','u','y','n','j','p','u','n','j','w','m','u','a','y','t','s','p','b','m','s','u','p','v','w','f','k'},{'r','h','j','y','o','v','s','p','i','d','e','e','r','p','b','f','j','b','f','e','v','x','g','h','r','a','z','m','y','g','z','p','n','k','n','e','f','h','t','q','k','z','u','d','o','v','l','a','y','q','e','v','n','m','d','h','m','e','t','m','k','u','d','z','f','q','d','k','z','y','a','k','z','x'},{'p','q','s','a','s','t','r','w','o','g','l','t','n','z','x','j','m','j','d','p','j','i','i','o','v','h','p','x','t','o','u','j','g','p','j','y','i','c','x','y','l','i','s','a','h','r','l','t','d','p','l','o','z','t','c','w','a','t','w','w','i','q','f','o','f','o','p','p','t','m','q','e','u','k'},{'e','b','d','q','x','g','h','i','u','i','b','z','f','d','s','b','z','c','t','g','t','b','v','i','s','o','u','i','u','q','u','y','r','y','q','q','e','z','y','z','i','b','y','p','h','s','s','i','v','l','p','o','o','m','w','h','a','s','r','w','i','m','u','b','k','n','s','o','m','s','p','w','u','p'},{'l','d','i','f','l','d','t','c','t','h','o','r','q','q','j','i','m','t','w','j','u','g','w','m','w','k','h','m','j','d','d','w','g','l','c','t','q','v','w','j','e','k','a','v','b','j','f','p','c','b','y','z','j','w','n','f','j','u','t','s','x','x','q','d','k','s','z','b','p','v','k','w','h','n'},{'r','k','y','y','a','d','z','a','c','k','x','p','r','i','m','l','c','l','k','s','r','w','n','q','x','e','l','k','a','s','x','t','d','x','r','d','a','s','f','c','e','c','u','w','m','i','h','o','t','t','j','k','p','w','a','p','a','l','b','d','g','a','y','j','x','s','o','y','m','t','c','r','y','w'},{'n','k','e','w','b','y','r','k','i','g','i','l','x','k','w','y','n','e','a','o','n','y','g','d','w','s','z','a','l','x','x','y','j','d','u','m','d','l','w','o','u','e','z','t','p','x','u','e','c','u','s','r','s','a','v','q','t','w','r','g','v','q','f','e','v','b','t','z','p','p','n','j','w','o'},{'e','n','n','y','t','p','t','o','j','n','o','g','e','j','c','x','q','x','n','x','d','i','y','w','j','n','o','y','y','k','m','d','z','c','b','u','r','w','i','a','k','z','g','q','i','k','n','a','h','c','x','l','m','w','j','w','l','x','w','m','j','j','p','i','n','s','d','e','p','n','h','b','m','p'},{'r','v','a','g','x','j','i','v','w','u','t','g','s','g','d','p','s','n','a','h','x','n','c','a','t','r','o','c','u','a','s','l','x','u','r','v','f','b','s','c','x','n','i','q','t','l','h','m','a','h','v','y','w','x','y','p','q','o','u','k','r','o','x','q','i','q','n','p','r','f','r','p','s','b'},{'h','o','p','o','c','p','x','z','n','t','x','o','k','p','e','g','c','x','u','b','o','e','s','b','u','j','j','n','y','d','p','f','r','g','v','v','v','s','v','l','n','u','b','a','l','f','g','n','d','d','r','t','h','j','w','d','u','f','r','t','j','i','a','c','o','y','y','j','q','v','w','g','p','x'},{'i','a','f','o','q','i','t','h','d','b','s','z','e','m','h','v','h','q','f','i','u','t','g','u','f','y','p','b','e','e','z','m','h','e','d','x','o','w','e','r','z','y','s','g','k','z','d','s','r','j','a','o','c','i','i','h','i','a','j','p','g','i','b','n','o','g','m','c','f','s','v','g','q','n'},{'m','b','n','q','t','g','z','v','u','d','f','d','l','n','f','w','c','l','g','g','z','u','o','n','w','t','g','r','c','w','g','o','x','v','g','q','c','f','n','w','j','s','b','w','g','g','s','i','s','y','q','t','s','f','g','q','a','m','j','c','j','p','t','i','n','z','b','p','h','o','l','s','h','n'},{'o','p','t','i','x','n','i','o','i','c','v','p','u','v','d','d','y','o','u','r','z','h','s','a','w','z','o','k','t','x','z','j','m','u','r','m','i','b','c','s','d','x','j','x','s','n','c','s','d','x','l','c','g','e','c','f','f','t','p','z','q','o','i','f','i','c','r','s','d','v','l','j','s','w'},{'g','m','j','l','h','p','i','s','r','q','y','w','v','g','r','k','h','h','a','r','o','l','t','f','f','z','a','s','i','u','p','q','j','a','b','q','p','l','i','j','c','j','h','x','p','y','k','w','h','m','n','w','x','j','d','f','i','g','x','s','a','m','k','l','p','o','b','e','z','k','p','d','v','w'},{'d','k','u','n','g','c','b','v','a','z','e','d','g','o','j','d','g','m','s','t','x','h','h','z','n','i','l','d','m','g','z','p','s','w','e','y','y','f','v','y','g','a','b','m','q','n','s','x','b','k','s','y','t','z','z','i','h','m','l','v','u','n','k','m','j','q','m','h','w','i','h','c','k','k'},{'r','a','x','j','z','a','v','r','b','o','s','a','w','a','p','k','v','j','x','i','w','g','y','i','p','w','s','w','b','c','i','s','d','i','d','e','i','y','y','j','o','q','m','m','s','b','w','q','k','v','y','g','d','y','r','s','v','j','q','w','o','z','q','t','j','t','x','r','t','v','d','h','o','p'},{'t','g','q','s','w','c','n','w','l','r','v','c','l','q','n','e','o','b','f','g','u','o','z','s','f','u','p','k','b','d','z','w','k','r','q','i','u','g','f','f','x','a','j','k','s','w','o','g','y','t','m','s','j','n','k','p','h','a','b','k','f','b','g','p','s','x','a','o','d','f','t','c','f','c'},{'o','x','z','f','f','z','a','t','r','k','i','c','b','r','e','c','b','l','d','j','d','y','i','d','m','n','i','i','r','n','m','i','m','n','n','t','m','n','m','e','x','w','i','y','n','o','b','o','z','g','z','c','e','i','f','t','x','n','d','p','c','r','x','q','f','m','j','t','z','x','z','x','t','h'},{'x','g','x','a','w','x','h','w','b','n','g','h','i','f','w','l','u','b','f','t','r','k','f','d','f','f','a','f','e','u','o','d','c','m','e','z','l','n','x','m','a','f','v','j','k','u','w','h','v','b','a','o','n','i','t','v','p','u','a','v','q','o','y','s','c','e','t','n','r','s','a','s','z','x'},{'d','k','r','b','t','o','d','t','f','s','d','y','n','s','u','p','n','k','e','o','f','i','u','a','w','m','v','y','g','u','x','l','g','p','m','z','f','r','v','k','k','y','l','z','t','f','p','i','s','v','w','z','d','r','b','b','f','w','b','l','t','z','w','z','q','i','z','v','a','u','i','m','u','v'},{'l','n','a','a','w','u','v','u','v','b','n','x','c','s','t','e','f','m','f','d','o','v','o','n','s','o','j','a','c','f','v','n','v','y','q','t','u','n','n','q','o','d','p','t','v','k','z','d','z','e','g','n','b','u','c','t','k','n','w','m','s','t','c','p','t','u','i','o','h','y','g','y','b','v'},{'r','y','f','s','b','e','y','k','t','z','e','v','u','r','i','s','f','d','m','h','s','f','d','d','v','l','b','b','l','c','y','e','c','g','w','e','k','u','q','g','v','u','b','r','n','m','k','t','r','w','c','l','d','g','o','b','t','p','e','e','t','d','i','w','j','g','c','v','a','s','d','x','o','f'},{'o','c','t','y','x','k','w','z','v','c','f','m','d','a','b','h','e','x','m','o','v','x','u','x','v','w','r','y','t','f','f','i','j','y','i','g','k','h','i','g','j','p','s','o','q','v','x','u','u','m','l','p','l','f','o','g','c','f','h','v','n','o','f','w','n','q','f','x','x','n','f','i','c','z'},{'y','s','x','v','p','t','h','a','j','v','h','x','b','j','f','k','f','s','z','m','q','o','c','x','l','b','k','t','l','p','u','j','j','r','f','a','n','o','c','w','j','k','v','n','t','c','x','a','w','y','p','n','m','r','m','a','v','x','t','g','o','p','q','z','j','x','a','w','n','e','s','x','o','p'},{'m','k','s','l','m','o','k','b','d','y','v','q','y','q','p','t','w','f','j','o','e','s','n','g','o','b','n','i','a','d','z','m','n','t','x','a','k','j','b','n','i','y','f','i','o','w','c','n','b','l','d','i','f','r','q','v','s','d','f','s','h','e','g','w','a','f','w','k','p','a','z','z','y','f'},{'h','p','d','j','c','f','w','f','p','d','y','f','y','q','l','f','k','s','m','q','q','m','w','n','y','n','p','x','m','p','e','v','e','i','f','i','p','d','q','g','h','o','n','h','h','y','n','r','s','b','k','j','n','i','y','l','v','p','k','j','e','p','e','l','z','j','v','q','p','n','w','w','c','j'},{'d','l','i','s','e','c','t','o','l','i','w','l','v','r','a','i','c','h','z','h','s','y','q','n','o','f','b','m','d','f','v','j','s','f','d','w','k','z','n','v','h','j','j','f','d','j','n','f','q','m','m','k','m','f','y','c','m','b','o','s','i','l','b','c','t','e','y','d','f','l','a','p','x','j'},{'u','a','t','j','h','l','x','u','w','j','b','w','l','p','z','b','h','j','m','i','l','h','p','j','k','u','x','l','l','u','w','f','w','r','q','d','d','n','z','z','w','a','x','j','s','w','k','z','f','z','k','q','g','b','b','t','x','y','g','j','s','c','o','o','u','f','u','z','u','t','a','r','w','x'},{'c','o','t','n','p','a','o','z','s','w','a','t','p','y','u','v','h','m','a','x','d','w','e','z','v','z','s','v','s','q','u','u','g','n','j','w','p','x','v','h','w','y','c','l','w','w','j','f','l','j','c','q','f','j','p','c','i','j','x','c','a','r','y','g','g','i','c','x','h','a','g','d','y','i'},{'r','u','h','a','b','s','l','f','k','q','o','b','u','y','k','r','a','m','k','b','t','s','j','x','p','s','z','x','y','x','f','p','t','o','r','u','i','c','a','s','u','q','t','o','p','g','h','r','s','t','s','n','l','d','n','c','w','m','b','w','k','i','n','f','x','e','c','f','i','c','a','c','s','v'},{'s','j','b','z','b','w','u','v','j','h','z','y','l','x','l','m','t','x','u','g','c','r','m','g','z','u','i','z','w','d','u','q','o','y','r','p','u','l','l','f','s','m','e','d','j','p','r','c','o','l','k','s','d','w','z','e','q','j','d','o','o','z','e','d','x','v','u','r','i','h','z','a','t','d'},{'f','c','u','w','g','i','h','q','c','m','o','b','q','g','n','v','u','b','v','a','e','s','x','z','m','f','g','l','f','c','q','m','e','k','i','n','u','s','f','w','g','u','y','z','c','l','u','x','o','r','z','t','k','x','u','y','c','c','l','k','e','b','w','l','l','h','a','f','z','f','d','f','b','b'},{'g','g','o','b','d','f','s','e','y','e','b','u','e','g','y','p','q','f','s','m','s','f','v','s','m','u','z','q','c','d','t','k','j','k','l','o','p','g','s','p','m','w','j','r','c','j','i','s','o','b','g','g','i','c','a','v','y','a','l','c','f','e','n','o','q','a','e','f','g','w','u','t','s','f'},{'m','w','p','u','o','d','x','x','m','g','b','m','b','z','o','o','e','t','u','t','h','l','t','n','q','c','k','n','x','e','s','j','d','h','f','r','n','f','q','b','n','r','n','o','t','c','e','x','v','y','q','f','l','l','s','c','n','e','r','k','l','j','v','o','t','d','h','i','i','y','j','v','p','y'},{'l','i','a','r','h','y','p','z','f','d','l','z','h','a','g','y','n','r','h','i','f','c','n','o','k','v','m','v','s','e','u','f','o','w','w','w','w','o','x','d','r','i','d','y','j','j','w','y','c','f','g','j','k','w','x','u','t','m','s','m','q','m','t','e','k','q','c','h','g','a','k','x','k','p'},{'x','v','y','v','t','c','c','c','l','m','y','j','j','r','v','b','f','n','p','z','t','z','p','w','g','v','y','t','u','i','i','t','e','j','o','x','l','q','z','z','d','x','i','o','r','f','p','w','u','e','v','n','d','m','j','m','j','j','h','f','s','r','y','w','a','m','v','o','f','v','n','k','u','x'}};
        String word4 = "leniytflws";
        char [][] board4 = new char[][]{{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a'},{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','b'}};
        String word5 = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        char [][] board5 = new char [][]{{'a'}};
        String word6 = "a";
        assertTrue(offer.exist(board1, word1));
        assertFalse(offer.exist(board2, word2));
        assertTrue(offer.exist(board1, word3));
        assertFalse(offer.exist(board3, word4));
        assertTrue(offer.exist(board4, word5));
        assertTrue(offer.exist(board5, word6));
    }

    @Test
    public void test_moving_count(){
        int m1 = 2;
        int n1 = 3;
        int k1 = 1;
        int m2 = 3;
        int n2 = 1;
        int k2 = 0;
        assertEquals(offer.movingCount(m1,n1,k1),3);
        offer.cnt = 0;
        assertEquals(offer.movingCount(m2,n2,k2),1);
        offer.cnt = 0;
        System.out.println(offer.movingCount(100,100,20));
    }

    @Test
    public void test_cutting_rope(){
        int n1 = 2;
        int n2 = 10;
        assertEquals(offer.cuttingRope(n1),1);
        assertEquals(offer.cuttingRope(n2), 36);
    }

    @Test
    public void test_cutting_rope2(){
        int n1 = 1000;
        System.out.println(offer.cuttingRope2(n1));
    }

    @Test
    public void test_hamming_weight(){
        int n1 = 00000000000000000000000000001011;
        System.out.println(Integer.valueOf(n1));
//        int n1 = 00000000000000000000000000001011;
        int n2 = 00000000000000000000000010000000;

        assertEquals(offer.hammingWeight(n1),3);
        assertEquals(offer.hammingWeight(n2),1);
    }

    @Test
    public void test_my_pow(){
        double n1  = 2;
        int p1 = -3;
        double n2 = 2;
        int p2 = -2147483648;
        System.out.println(offer.myPow(n1,p1));
        System.out.println(offer.myPow(n2,p2));
    }

    @Test
    public void test_get_least_num(){
        int [] arr1 = new int[] {3,2,1};
        int k1 = 2;
        int [] arr2 = new int[] {0,1,2,1};
        int k2 = 0;
        assertArrayEquals(new int[]{1,2},offer.getLeastNumbers(arr1, k1));
        assertArrayEquals(new int[]{},offer.getLeastNumbers(arr2, k2));
    }

    @Test
    public void test_exchange(){
        int []arr1 = new int[]{1,2,3,4};
        int []arr2 = new int[]{1,3,5};
        int []arr3 = new int[]{2,2,2,2,2,2,2,2,2,2,3,3,3};
        System.out.println(Arrays.toString(offer.exchange(arr1)));
        System.out.println(Arrays.toString(offer.exchange(arr2)));
        System.out.println(Arrays.toString(offer.exchange(arr3)));
    }

    @Test
    public void test_max_sub(){
        int [] arr1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        assertEquals(6,offer.maxSubArray(arr1));
    }
}
