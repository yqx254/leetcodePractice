package special;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.*;


public class SpecialTest {
    private Special special;
    @Before
    public void init(){
        special = new Special();
    }


    @Test
    public void combinationSum(){
        int [] c1 = {2,3};
        int target1 = 6;
        System.out.println(Arrays.toString(special.combinationSum(c1, target1).toArray()));
    }
}
