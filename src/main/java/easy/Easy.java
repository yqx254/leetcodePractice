package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fstar
 *
1.给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 思路：使用一遍哈希表
 以数值为键以下标做值，找到目标值（target - 当前值）的话，返回当前下表和目标值的下标
 */
public class Easy{
public int[] twoSum(int [] nums, int target) {
                Map<Integer, Integer> result = new HashMap<>(nums.length);
                for(int i=0; i < nums.length; i ++){
                        if(result.get(target - nums[i]) != null
                                && result.get(target - nums[i]) != i){
                                return new int [] {result.get(target - nums[i]), i};
                        }
                        result.put(nums[i],i);
                }
                return  new int[] {0,0};
        }
}