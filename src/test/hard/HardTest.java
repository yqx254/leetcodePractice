package hard;


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
}
