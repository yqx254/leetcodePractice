package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
