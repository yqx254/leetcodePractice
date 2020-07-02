package interview;

import java.util.HashMap;
import java.util.Map;

public class Interview {

    /**
     * 01.01 判定字符是否唯一
     * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
     * @param astr 待检查的字符串
     * @return 是否唯一
     * 思路：自然是哈希表咯
     * 附加条款：不用额外的数据结构很加分
     * 位运算？
     */
    public boolean isUnique(String astr){
        Map<Character, Integer> map = new HashMap<>(astr.length());
        for(char c : astr.toCharArray()){
            if(map.containsKey(c)){
                return false;
            }
            map.put(c,1);
        }
        return true;
    }
}
