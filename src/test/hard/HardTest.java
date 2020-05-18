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
}
