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
        int [] nums1 = new int[] {3,2,3};
        assertEquals(offer.findRepeatNumber(nums1),1);
    }
}
