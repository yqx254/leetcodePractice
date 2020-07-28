package interview;

/**
 * 剑指offer分类题解
 */
public class Offer {

    public int findRepeatNumber(int[] nums) {
        int i = 1, j = 0;
        while(i < nums.length){
            if(nums[i] == nums[j]){
                j = 0;
                break;
            }
            i = nums[nums[i]];
            j = nums[j];
        }
        while(nums[i] != nums[j]){
            i = nums[i];
            j = nums[j];
        }
        return nums[i];
    }
}
