


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
        String s = "barfoothefoobarman";
        String [] words = {"foo","bar"};

        assertArrayEquals(new Object [] {0,9},hard.findSubstring(s,words).toArray());
    }
}
