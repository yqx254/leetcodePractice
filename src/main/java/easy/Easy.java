package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
    /**
     * @author fstar
     * 7.给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 假设我们的环境只能存储得下 32 位的有符号整数
     *  思路：模10除10下一波
     *  用long存储来处理边界值问题
     */
    public int reverse(int x) {
        long result = 0;
        int current;

        while(x != 0){
            current = x % 10;
            result = result * 10 + current;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
    /**
     *
     * 9.判断一个整数是否是回文数。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 额外要求：不使用字符串
     * 思路：负数和被10整除的数字直接返回false
     * 翻转整数和原数据进行比较
     * 优化：当结果数大于等于原数时，代表已经比对了超过一半的数字
     * 可直接确定结果
     */
    public boolean isPalindrome(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int result = 0;
        while(x > result){
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == x || result / 10 == x;
    }
    /**
     * 14.最长公共前缀
     *  编写一个函数来查找字符串数组中的最长公共前缀。
     *  思路1：水平扫描  字符串挨个和前缀比较（默认为数组首个字符串）
     *  使用indexOf来计算当前字符和公共前缀的关系（若为0，则切掉前缀最后一位，再进行尝试）
     *  思路2： 垂直扫描  字符串每个字母挨个和其他字符串同位置字符进行比较
     *  若数组末尾有较短的字符，则减少了很多比较次数
     *  思路3：JAVA偷鸡大法
     *  使用Arrays.sort排序数组，再比较第一个字符和最后一个字符即可找出公共前缀
     *  思路清奇，但似乎略慢一些
     */
    public String longestCommonPrefix(String [] strs){
        if(strs.length == 0){
            return "";
        }
        for(int i = 0; i <strs[0].length(); i ++){
            char current = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j ++){
                if(i == strs[j].length() || strs[j].charAt(i) != current){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 20.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * @param s 带括号的字符串
     * @return 是否有效
     * 思路： 栈来！
     * 可能的错误：抬手一个反括号，直接peek会报异常，需要先进行检查
     * 补充：如果length为奇数，应该直接返回false
     * 其他诡异思路：循环replace () {} []，然后检查字符串是否为空，5行python搞定的偏锋操作
     */
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length(); i ++){
            char current =s.charAt(i);
            if(current == '(' || current == '{' || current == '['){
                stack.push(current);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if(current == ')' && stack.peek() != '('){
                    return false;
                }
                if(current == '}' && stack.peek() != '{'){
                    return false;
                }
                if(current == ']' && stack.peek() != '['){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums 排序数组
     * @return 长度
     * 思路：快慢针
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[slow] == nums[fast]){
                fast ++;
            }
            else{
                nums[slow + 1] = nums[fast];
                slow ++;
                fast ++;
            }
        }
        return slow + 1;
    }

    /**
     * 27.移除元素
     * @param nums 元素数组
     * @param val 移除值
     * @return 长度
     * 思路：双指针
     * 当然，双指针也分别人的双指针和自己的双指针……
     */
    public int removeElement(int [] nums, int val){
        int i = 0;
        for(int j = 0; j < nums.length; j ++){
            if(nums[j]  != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }

    /**
     *  28. 实现 strStr()
     *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     *  如果不存在，则返回  -1。
     * @param haystack 源字符串
     * @param needle 目标字符串
     * @return 目标字符串所在位置
     * 思路1： 双循环暴力拆解
     * 思路2：  Sunday算法，建立偏移量map 如th： t： 2 h： 1
     *   例如 something  th   th与so不等，在map中查找m的偏移量  结果未找到，idx从0移动到0 + th.length  + 1 = 3
     *   et  与th不等，h在map中等于1，idx后移一位，th = th，返回idx=4
     *   思路3：KMP算法，未研究，较困难
     *   思路4：内置函数极限偷鸡
     */
    public int strStr(String haystack, String needle){
        Map<Character, Integer> map = new HashMap<>(needle.length());
        for(int i = 0 ;i < needle.length(); i ++){
            map.put(needle.charAt(i), needle.length() - i);
        }
        int idx = 0;
        while(idx + needle.length() <= haystack.length()){
            String hay = haystack.substring(idx, idx + needle.length());
            if(hay.equals(needle)){
                return idx;
            }
            if(idx + needle.length() >= haystack.length()){
                return -1;
            }
            char next = haystack.charAt(idx + needle.length());
            if(map.get(next) != null){
                idx = idx + map.get(next);
            }
            else{
                idx = idx + needle.length() + 1;
            }
        }
        if(idx + needle.length() >= haystack.length()){
            return -1;
        }
        return idx;
    }

    /**
     *  35. 搜索插入位置
     *   给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     *   如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums 目标数组
     * @param target 插入值
     * @return 插入位置
     */
    public int searchInsert(int [] nums, int target){
        int left = 0;
        int right = nums.length;
        int index;
        while(left < right){
            index = (left + right) / 2;
            if(nums[index] >= target){
                right = index;
            }
            else{
                left = index + 1;
            }
        }
        return left;
    }

    public String countAndSay(int n){
        return say(n);
    }

    private String say(int n){
        if(n == 1){
            return "1";
        }

        StringBuilder sb1 = new StringBuilder();
        String num = say(n - 1);
        if(num.length() == 1){
            sb1.append(1).append(num.charAt(0));
            return sb1.toString();
        }
        int count = 1;
        char start = num.charAt(0);
        for(int i = 1; i <  num.length(); i ++){
            if(num.charAt(i) == start){
                count ++;
            }
            else{
                sb1.append(count).append(start);
                start = num.charAt(i);
                count = 1;
            }
        }
        sb1.append(count).append(start);
        return sb1.toString();
    }
}