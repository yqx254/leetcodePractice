import easy.Easy;
import org.junit.Test;

import static org.junit.Assert.*;


public class EasyTest {

    @Test
    public void twoSum() {
        Easy easy = new Easy();
        int [] res = new int  [] {1,2};
        int [] input = new int[] {3,2,4};
        int target = 6;
        assertArrayEquals(
                res,
                easy.twoSum(input,target)
        );
    }
}
