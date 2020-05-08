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
}
