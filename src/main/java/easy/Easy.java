package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fstar
 *
1.给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class Easy{
public int[] twoSum(int [] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i ++){
        map.put(nums[i],i);
        }
        for(int j = 0; j < nums.length; j ++){
        if(map.get(target - nums[j]) != null && j != map.get(target - nums[j])){
        return new int[]{j,map.get(target - nums[j])};
        }
        }
        return new int[]{0, 0};
        }
}