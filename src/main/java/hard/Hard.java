package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fstar
 */
public class Hard {

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
     *
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
