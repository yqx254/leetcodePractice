package interview;

import org.junit.Before;
import org.junit.Test;

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
}
