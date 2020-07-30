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
}
