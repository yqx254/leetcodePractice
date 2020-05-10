package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author fstar
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 */
public class Medium {

    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        Map<Character,Integer> result = new HashMap<>(s.length());
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i ++){
            if(result.get(s.charAt(i)) != null  && result.get(s.charAt(i)) >= start){
                max = Math.max(max,(i - start));
                start = result.get(s.charAt(i)) + 1;
            }
            result.put(s.charAt(i),i);
        }
        return Math.max(max, s.length()  - start);
    }
    //5. 最长回文子串
    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return null;
        }
        int maxLen = 1;
        String maxStr = String.valueOf(s.charAt(0));
        for(int i = 0;i < s.length(); i ++){
            for(int j = s.length() - 1; j > i + maxLen - 1; j --){
                if(s.charAt(i) == s.charAt(j) && checkPalindrome(s.substring(i,j + 1))){
                    maxLen = j - i + 1;
                    maxStr = s.substring(i,j + 1);
                }
            }
        }
        return maxStr;
    }
    public boolean checkPalindrome(String s){
        for(int i = 0,j=s.length()-1;i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                System.out.println(s + " failed");
                return false;
            }
        }
        System.out.println(s + " succeed");
        return true;
    }
}
