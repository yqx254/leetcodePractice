package easy;

import easy.Easy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class EasyTest {
    private Easy easy;
    @Before
    public void init(){
        easy = new Easy();
    }

    @Test
    public void twoSum() {
        int [] res = new int  [] {1,2};
        int [] input = new int[] {3,2,4};
        int target = 6;
        assertArrayEquals(
                res,
                easy.twoSum(input,target)
        );
    }

    @Test
    public void reverse(){
        int i1 = 123;
        int i2 = 230;
        int i3 = -142;
        assertEquals(321,easy.reverse(i1));
        assertEquals(32,easy.reverse(i2));
        assertEquals(-241,easy.reverse(i3));
    }
}
