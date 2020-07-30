package interview;

import pojo.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    /**
     *   Offer 05. 替换空格
     * @param s 需要替换的字符串
     * @return 替换后的结果
     * 思路： 没啥好说的
     * 把字符串转化成char array再遍历是个小技巧
     */
    public String replaceSpace(String s){
        char [] c = s.toCharArray();
        StringBuilder stb = new StringBuilder();
        for(char t : c){
            if(t == ' '){
                stb.append("%20");
            }
            else{
                stb.append(t);
            }
        }
        return stb.toString();
    }
    /**
     * Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head 头节点
     * @return 反转的数组
     * 思路： 栈解法： 空间复杂度为O(n)
     * 切记！！！！不要用storage.size()直接做循环控制变量，囧
     * 反转链表（迭代式）然后再顺序输出，速度快得多
     */
    public int[] reversePrint(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode tmp;
        int size = 0;
        while(current != null){
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
            size ++;
        }
        int [] result = new int[size];
        size = 0;
        while(prev != null){
            result[size++] = prev.val;
            prev = prev.next;
        }
        return result;
    }
    /**
     * Offer 10-1  斐波那契数列
     *写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
     * 同No509
     * @param n 数列的第n项
     *  思路：直接想到的可能是递归，n过大时会超时
     *   使用map存储已经算出来的第n项值可以显著提高效率，但空间占用较大
     *   使用比较骚气的动态规划法循环求余
     *    简单来说就是一步一步将a推到n的位置，利用sum做跳板
     */
    public int fib(int n){
        int a = 0, b = 1,sum;
        for(int i = 0; i < n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     *  Offer 10- II. 青蛙跳台阶问题
     *  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     *  求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * @param n 台阶总数
     * @return 步数
     * 思路： 动态规划问题，递归必死
     * 可以看作是一个斐波那契数列的变种，返回值、边界值的选定比较讲究
     */
    public int numWays(int n){
        int a = 1, b = 2, sum;
        if(n  < 2){
            return 1;
        }
        for(int i = 3; i <= n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
    /**
     *  Offer 11. 旋转数组的最小数字
     *
     * @param numbers 旋转数组
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     *  例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *  思路：基本有序的数组问题首先考虑二分查找，注意边界值（尤其是high --）
     *   用堆排始终要慢了一点点
     */
    public int minArray(int [] numbers){
        int low = 0, high = numbers.length - 1,mid;
        while(low < high){
            mid = (low + high) / 2;
            if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }
            else if(numbers[mid] < numbers[high]){
                high = mid;
            }
            else{
                high --;
            }
        }
        return numbers[low];
    }
}
