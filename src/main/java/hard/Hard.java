package hard;

import java.util.*;

/**
 * @author fstar
 */
public class Hard {
    /**
     *  4. 寻找两个正序数组的中位数
     *  给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     *  请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * @param nums1 排序数组1
     * @param nums2 排序数组2
     * @return 中位数
     * 思路：遍历两个数组并重建 ：时间复杂度为O(m + n)，不符合题意
     * log级别的复杂度，首先考虑二分法
     * 在短的一个数组上找到合适的i 和j （j = 两数组总长度 / 2 - i）
     * 使得 nums1[i - 1]  < nums2[j] 且 nums1[i] > nums2[j - 1]
     * 这同时也保证了两个数组被i和j切成长度几乎相等的左右两半
     * 寻找最大左值和最小右值，即可得到中位数
     */
    public double findMedianSortedArrays(int [] nums1, int [] nums2){
        int m = nums1.length;
        int n = nums2.length;
        if(m > n){
            int [] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (n + m + 1) / 2;
        int i = 0,j = 0,maxLeft = 0, minRight = 0;
        while(iMin <= iMax){
            i = (iMin + iMax) / 2;
            j = halfLen - i;
            if(i < iMax && nums1[i] < nums2[j - 1]){
                iMin = i + 1;
            }
            else if(i > iMin && nums1[i - 1] > nums2[j]){
                iMax = i - 1;
            }
            else{
                if(i == 0){
                    maxLeft = nums2[j - 1];
                }
                else if(j == 0){
                    maxLeft = nums1[i - 1];
                }
                else{
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if((m + n) % 2 == 1){
                    return maxLeft;
                }

                if(i == m){
                    minRight = nums2[j];
                }
                else if(j == n){
                    minRight = nums1[i];
                }
                else{
                    minRight = Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft + minRight) / 2.0;
            }

        }
        return 0.0;
    }

    /**
     *  10. 正则表达式匹配
     *  给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     *  '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * @param s 字符串
     * @param p 匹配串
     * @return 是否匹配
     * 使用递归
     * 当前字符是否和表达式匹配 或   当前字符匹配到 ‘.’
     * 表达式下一位是'*'  切掉当前字符继续递归匹配并和当前匹配求或
     * 或者切掉星号，继续匹配后面的内容
     * 当前匹配为真， 递归比较之后的字符并求或
     */
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()){
            return s.isEmpty();
        }
    boolean current = !s.isEmpty() && (p.charAt(0) =='.' || s.charAt(0) == p.charAt(0));
        if(p.length() >= 2 && p.charAt(1) == '*'){
        return (current && isMatch(s.substring(1),p)) || isMatch(s, p.substring(2));
    }
        return current && isMatch(s.substring(1),p.substring(1));
}

    /**
     *  30. 串联所有单词的子串
     *  给定一个字符串 s 和一些长度相同的单词 words。
     *  找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *  注意子串要与 words 中的单词完全匹配，中间不能有其他字符，
     *  但不需要考虑 words 中单词串联的顺序。
     * @param s 字符串
     * @param words 字串
     * @return 起始位置
     *  思路：传说中的滑动窗口
     *  例如 单词数组长度为3，可能从可选字符串的0  + n * words长度1 + n * words长度 2 + n * words长度中找到结果\
     *  先按words数组能构成的总长度装填map并比较
     *  若不相等，从左边移除一个单词，从右边加入一个单词，再次比较，循环
     */
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> result = new ArrayList<>();
        Map<String , Integer> map = new HashMap<>(words.length);
        Map<String, Integer> tmp = new HashMap<>(words.length);
        if(words.length == 0){
            return result;
        }
        for(String w : words){
            int v = map.getOrDefault(w, 0);
            map.put(w,v + 1);
        }
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int left,right;
        //进行窗口滑动
        for(int i = 0; i < wordLen; i ++){
            left = i;
            right = i;
            tmp.clear();
            if(right + totalLen <= s.length()){
                //第一轮，把一样长度的几个单词全部填入map
                while(right + wordLen <= totalLen + i  && right + wordLen <= s.length()){
                    String word = s.substring(right, right + wordLen);
                    int v = tmp.getOrDefault(word, 0);
                    tmp.put(word,v + 1);
                    right += wordLen;
                }
                if(map.equals(tmp)){
                    result.add(left);
                }
                //之后的轮次，右边加一个单词，左边拿掉一个单词
                while(right + wordLen <= s.length()){
                    String wordDel = s.substring(left, left + wordLen);
                    int dv = tmp.get(wordDel);
                    if(dv - 1 == 0){
                        tmp.remove(wordDel);
                    }
                    else{
                        tmp.put(wordDel, dv - 1);
                    }
                    String wordAdd = s.substring(right, right + wordLen);
                    int addV = tmp.getOrDefault(wordAdd, 0);
                    tmp.put(wordAdd, addV + 1);
                    if(map.equals(tmp)){
                        result.add(left + wordLen);
                    }
                    left += wordLen;
                    right += wordLen;
                }
            }
        }
        return result;
    }

    /**
     *32. 最长有效括号
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     * 思路： -1先进栈垫底
     * 遇到左括号将循环指针压栈，遇到右括号出栈
     * 此时循环指针 - 栈顶指针 就是有效括号的长度
     * 空栈则代表左括号全被捡完了，当前右括号不能组成有效括号
     * 将右括号指针压入栈中
     * 压-1这种事情，怎么想得到呢
     */
    public int longestValidParentheses(String s){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        stack.push(-1);
        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    /**
     *  41. 缺失的第一个正数
     *  给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     *  算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间
     * @param nums 未排序数组
     * @return 未出现的最小正整数
     * 思路：三轮扫描，O(n)级
     * 第一轮将所有负数和大于数组长度的数改写为-1（因为用不上）
     * 若数组中不存在1，直接返回1
     * 第二轮将数组的值作为键，把键对应的值改成负值
     * 负值代表这个数字出现过，比如{-1,-2,-1,4}代表1 2 4存在，3不存在
     * （总是使用 - Math.abs()来避免重复操作导致的反转）
     * 第二轮时，nums[0]将保存nums.length - 1这个键的出现状态
     * 第三轮，从1开始，查找首个大于0的数字并返回，若没有找到，检查nums[0]
     * 若nums[0] > 0，返回nums.length - 1
     * 否则返回nums.length （数组是一个1～n的连续值）
     */
    public int firstMissingPositive(int [] nums){
        boolean oneFlag = true;
        for(int i = 0;i < nums.length; i ++){
            if(nums[i] == 1 && oneFlag){
                oneFlag = false;
            }
            if(nums[i] <= 0 || nums[i] > nums.length){
                nums[i] = 1;
            }
        }
        if(oneFlag){
            return  1;
        }
        int index;
        for(int j = 0; j < nums.length; j++){
            index = Math.abs(nums[j]);
            if(index == nums.length){
                nums[0] = - Math.abs(nums[0]);
            }
            else{
                nums[index] = - Math.abs(nums[index]);
            }
        }
        for(int k = 1; k < nums.length; k ++){
            if(nums[k] > 0){
                return k;
            }
        }
        if(nums[0] > 0){
            return nums.length;
        }
        return nums.length + 1;
    }

    /**
     *  42.接雨水
     *  给定 n 个非负整数表示每个宽度为 1 的柱子的高度图
     *  计算按此排列的柱子，下雨之后能接多少雨水。
     * @param height 高度图
     * @return 接水量
     * 思路：双指针法，难在想通
     * 从左右各找一个相对的大值，大值 - 之后的小值就是小值位置的存水量
     * 例如：[0,2,1,0,2........] 左边大值是2， 在下标为2处（值为1）和下标为3处（值为0）的存水量分别为1 2
     *  右边以相反的方向相同的逻辑进行处理
     */
    public int trap(int [] height){
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int volumn = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }
                else{
                    volumn += (leftMax - height[left]);
                }
                left ++;
            }
            else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }
                else{
                    volumn += (rightMax - height[right]);
                }
                right --;
            }
        }
        return volumn;
    }

    public boolean isMatch2(String s, String p){
        int sLen = s.length(), pLen = p.length();
        int sIdx = 0, pIdx = 0;
        int starIdx = -1, sTempIdx = -1;
        while(sIdx < sLen){
            if(pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
                sIdx ++;
                pIdx ++;
            }
            else if(pIdx < pLen && p.charAt(pIdx) == '*'){
                starIdx = pIdx;
                sTempIdx = sIdx;
                pIdx ++;
            }
            else  if(starIdx == -1){
                return false;
            }
            else{
                pIdx = starIdx + 1;
                sIdx = sTempIdx + 1;
                sTempIdx = sIdx;
            }
        }
        for(int i = pIdx; i < pLen; i ++){
            if(p.charAt(i) != '*'){
                return false;
            }
        }
        return true;
    }

    public int  jump(int [] nums){
        int end = 0;
        int steps = 0;
        int  maxGap = 0;
        for(int i = 0; i < nums.length - 1; i ++){
            maxGap = Math.max(i + nums[i], maxGap);
            if(i == end){
                steps ++;
                end = maxGap;
            }
        }
        return steps;
    }

    /**
     *  N皇后
     *  思路：摆棋子用回溯
     *  判断棋子是否有效的逻辑上可能有较大改进空间
     *  调整：三个数组保存列、主对角线（左上到右下），副对角线（左下到右上）的碰撞情况
     *  主对角线规律：行减列的值相等的一共有2 * n - 1组
     *  副对角线规律：行加列的值相等的一共有 2 * n - 1组
     *  因此：同列、x - y + size - 1、x + y均不得有碰撞
     *  搞了一个很大的乌龙：循环条件应该在y = size时候结束
     *  而不是x = size && y = size
     *  乌龙是 y = size时候直接置为0然后x+1
     *  这样实际上把棋子摆到了下一排，（因为总数不够）进行的尝试么有作用！
     * @param n 数量
     * @return 所有可能的结果集
     */
    private int[] dale;
    private int[] hill;
    private int[] row;
    private int total;
    public List<List<String>> solveNQueens(int n){
        List<List<String>> result = new ArrayList<>(64);
        row = new int[n];
        dale = new int[2 * n - 1];
        hill = new int[2 * n -1];
        putPos(result, new ArrayList<>(),0, 0,0, n);
        return result;
    }

    private void putPos(List<List<String>> result,
                                            List<String> current, int x, int y, int cnt, int size){
        if(cnt == size){
            result.add(new ArrayList<>(current));
            return;
        }
        //初始化
        if(current.size() == 0){
            for(int i = 0; i < size; i ++){
                StringBuilder stb = new StringBuilder();
                for(int j = 0; j < size; j ++){
                    stb.append('.');
                }
                current.add(stb.toString());
            }
        }
        while(x < size && y < size){
            if(checkPos(current, x,y)){
                StringBuilder stb = new StringBuilder(current.get(x));

                stb.setCharAt(y, 'Q');
                current.set(x, stb.toString());
                row[y] = 1;
                dale[x - y + size - 1] = 1;
                hill[x + y] = 1;
                putPos(result, current, x + 1 , 0,cnt + 1, size);

                stb.setCharAt(y, '.');
                current.set(x, stb.toString());
                row[y] = 0;
                dale[x - y + size - 1] = 0;
                hill[x + y] = 0;
            }
            y ++;
            if(y == size){
                y = 0;
                x ++;
            }
        }
    }

    private boolean checkPos(List<String> current, int x, int y){
        int size = current.get(x).length();
        return row[y] + dale[x - y + size - 1] + hill[x + y] == 0;
    }
    private int size;
    public int totalNQueens(int n) {
        row = new int[n];
        dale = new int[2 * n - 1];
        hill = new int[2 * n -1];
        size = n;
        total = 0;
        putQueen(0,0,0);
        return total;
    }
    /**
     * No 52 N皇后解法计数
     * 跟上一题一个思路
     * 虽然最佳解似乎是位运算
     * 先不管了
     */
    private void putQueen(int x, int y,int cnt){
        if(cnt == size){
            total ++;
            return;
        }
        while(y < size){
            if(checkQueen(x, y)){
                row[y] = 1;
                dale[x - y + size - 1] = 1;
                hill[x + y] = 1;
                putQueen(x + 1,0,cnt + 1);
                row[y] = 0;
                dale[x - y + size - 1] = 0;
                hill[x + y] = 0;
            }
            y ++;
        }
    }
    private  boolean checkQueen(int x, int y){
        return row[y] + dale[x -y  + size - 1] + hill[x + y] == 0;
    }
}
