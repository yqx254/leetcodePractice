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
        int [] c1 = {2,3,4,7};
        int target1 = 7;
        System.out.println(Arrays.toString(special.combinationSum(c1, target1).toArray()));
    }
    @Test
    public void combinationSum2(){
        int [] c1 = {2,2,3,4,7};
        int [] c2 = {10,1,2,7,6,1,5};
        int target1 = 7;
        int target2 = 8;
//        System.out.println(Arrays.toString(special.combinationSum2(c1, target1).toArray()));
        System.out.println(Arrays.toString(special.combinationSum2(c2, target2).toArray()));
    }
}
