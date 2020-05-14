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
     */
    public boolean isPalindrome(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int result = 0;
        while (x > result){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == x || result / 10 == x ;
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

}