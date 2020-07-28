package interview;

/**
 * 剑指offer分类题解
 * @author fstar
 */
public class Offer {
    /**
     *  Offer 03. 数组中重复的数字
     *  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     *  数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     *  请找出数组中任意一个重复的数字。
     * @param nums 输入数组
     * @return 重复数字
     * 思路：  FBI warning！ 这题是用不了弗洛伊德龟兔跑的（见中等题287）！
     * 因为数字中有0，会导致尝试建立链表的企图失效
     * 同时这题是对沟通能力的考察
     * 空间复杂度的要求是否是O(1)?是：数组排序，否则使用哈希或类哈希方式求解
     */
    public int findRepeatNumber(int[] nums) {
        int [] storage = new int[nums.length];
        for(int num : nums){
            if(storage[num] == 1){
                return num;
            }
            storage[num] ++;
        }
        return -1;
    }
}
