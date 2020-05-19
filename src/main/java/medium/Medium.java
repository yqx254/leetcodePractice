package medium;



import java.math.BigInteger;
import java.util.*;

/**
 * @author fstar
 *
 */
public class Medium {
    /**
     * 3. 无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param s 字符串
     * @return 最长子串
     * 思路：使用一遍哈希表
     *  start标识一个可能的子串起点
     * 发现重复字符：求重复字符之前到开始位置的这一段的长度，并将start移动到重复字符之后
     * 与当前max做对比
     * 未发现重复字符则将当前字符和位置存入哈希
     *  start和max可能没有移动，处理一下这个特殊情况（整个字符串不出现重复，长度为s.length() - start
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int start = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i ++){
            char current = s.charAt(i);
            if(map.get(current) != null && map.get(current) >= start){
                max = Math.max(max, i - start);
                start = map.get(current) + 1;
            }
            map.put(current, i);
        }
        return Math.max(max, s.length() - start);
    }
    /**
     * 5. 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s input String
     * @return longest palindrome
     * 思路：暴力穷举不可取
     * 较为容易理解的方法： 中心扩散法
     * 除了第一个元素之前、第一个元素、最后一个元素之后、最后一个元素以外
     * 长度为n的字符串共有2n - 4个中心点
     * 一层循环遍历，一层循环验证从中间点出发的字符串是否是回文即可
     * Manacher算法  据说复杂度达到O(n) 难度过大暂不尝试
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        if(s.length() == 1){
            return s;
        }
        //有效的中心点是2n - 2
        int start = 0;
        int end = 0;
        for(int center = 0; center < s.length() - 1; center ++){
            int len1 = findPalindrome(s,center, center);
            int len2 = findPalindrome(s,center, center + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = center - (len  - 1) / 2;
                end = center + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int findPalindrome(String s,int centerNum, int centerNum2){
        int start = centerNum;
        int end = centerNum2;

        while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
        }
        return end - start - 1;
    }

      /**
     * 6. Z字型变换
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * @param s input String
     * @param numRows input num
     * @return z form
       * 思路： 做标志位触底反弹即可
     */
      public String convert(String s, int numRows){
          List<StringBuilder> stringList  = new ArrayList<>(numRows);
          StringBuilder result  = new StringBuilder();
          if(numRows <= 1){
              return  s;
          }
          if(s.length() <= 1){
              return s;
          }
          if(s.length() <= numRows){
              return s;
          }
          for(int i = 0; i < numRows; i ++){
              stringList.add(new StringBuilder());
          }
          //进入的时候num=0，先假装翻一次
          boolean flip = true;
          int num = 0;
          for(int  j = 0;j < s.length(); j ++) {
              stringList.get(num).append(s.charAt(j));
              if(num == 0 || num == numRows - 1){
                  flip = !flip;
              }
              num += flip ? -1 : 1;
          }
          for(StringBuilder bd : stringList){
              result.append(bd);
          }
        return result.toString();
      }
    /**
     * 8. 字符串转换整数 (atoi)
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * 不想纠结这个题
     * 官方思路是DFA（确定有限状态机）
     */
    public int myAtoi(String str) {
        try{
            return Integer.parseInt(str.trim());
        }
        catch(Exception e){
            return 0;
        }
    }
    /**
     * 11. 盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
     * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找
     * 出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 思路：主要难点在于证明
     * 若  bucket[i] < bucket[j]，则面积为 i * len若移动长边，面积有减无增 i * (len - 1)
     * 所以移动短边咯
     * 总之，使用双指针，获得当前面积后，往中心方向移动短边，直到指针重合
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int maxArea = Math.min(height[0],height[height.length - 1]) * (height.length - 1);
        while(i < j){
            System.out.println(maxArea);
            if(height[i] <= height[j]){
                i ++;
            }
            else{
                j --;
            }
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i],height[j]));
        }
        return maxArea;
    }
    /**
     *  12.整数转罗马字
     *  给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
     *  神奇解法：人肉哈希--好像挺慢的
         String [][] manMadeHash = {
         {"","I","II","III","IV","V","VI","VII","VIII","IX"},
         {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"},
         {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"},
         {"","M","MM","MMM"}
         };     *
     *  思路2：分离出数字的每一位，使用这一位置可能是用到的前中后三个字符，来进行拼接
     *  如： 894  8（百位）的前中后：C  D  M
     *  等于1 4 5 9 直接返回
     *  1-4 ：前位N个
     *  5-9 中位+前位N个
     *  其他玩法： 贪心算法？
    * */
    public String intToRoman(int num){
        StringBuilder result = new StringBuilder();
        if(num / 1000 > 0){
            result.append(formCurrentNum(num / 1000,'M','I','I'));
            num -= (num / 1000) * 1000;
        }
        if(num / 100 > 0){
            result.append(formCurrentNum(num / 100,'C','D','M'));
            num -= (num / 100) * 100;
        }
        if(num / 10 > 0){
            result.append(formCurrentNum(num / 10,'X','L','C'));
            num -= (num / 10) * 10;
        }
        if(num > 0){
            result.append(formCurrentNum(num,'I','V','X'));
        }
        return result.toString();
    }

    private String formCurrentNum(int num,char first, char middle, char last){
        StringBuilder result = new StringBuilder();
        if(num < 4){
            for(int i = 0; i < num; i ++){
                result.append(first);
            }
            return result.toString();
        }
        else if(num == 4){
            return result.append(first).append(middle).toString();
        }
        else if(num == 9){
            return result.append(first).append(last).toString();
        }
        else{
            result.append(middle);
            for(int i =0;i < num - 5; i ++){
                result.append(first);
            }
            return result.toString();
        }
    }
/**
 *  13.罗马数字转整数
 *  例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
 *  27 写做  XXVII, 即为 XX + V + II 。
 *  基本玩法：发现前小后大，就把小的数减掉（减两倍就行）
 *  否则直接加上
 *  备注：switch似乎比hashmap快得多，诡异啊
 */
    public int  romanToInt(String s){
        Map<Character, Integer> map = new HashMap<>(8);
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int last = 0;
        int total = 0;
        int current;
        for(int i = 0; i < s.length(); i ++){
            current = map.get(s.charAt(i));
            if(current > last){
                total += current - 2 * last;
            }
            else{
                total += current;
            }
            last = current;
        }
        return total;
    }

    /**
     *  15.给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     *   请你找出所有满足条件且不重复的三元组。
     * @param nums 整数数组
     * @return 三元组组合
     *  思路：排序（重要），最外层遍历，内层双指针
     *  三数之和过小则移动左指针，三数之和过大则移动右指针
     *  排重是难点
     *  后置排重（算完了再排）较为安全
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int i ,j,k = 0;
        int sum = 0;
        List<List<Integer>> result = new ArrayList<>(nums.length / 2);
        if(nums.length <= 2){
            return  result;
        }
        Arrays.sort(nums);
        while(k < nums.length - 1 && nums[k] <= 0){
            //这个地方用k和k-1进行比较
            //k和k+1比较似乎也可行，但是处理不了{0,0,0,0,0},{-1,-1,-1,-1,1,2}这类情况，指针直接被推到最后了
//            if(k < nums.length - 3 && nums[k] == nums[k + 1]){
            if(k > 0 && nums[k] == nums[k - 1]){
                k ++;
                continue;
            }
            i = k + 1;
            j = nums.length - 1;
            while(i < j){
                sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    while(i < j && nums[i] == nums[i + 1]){
                        i ++;
                    }
                    i ++;
                }
                else if(sum > 0){
                    while(i < j && nums[j] == nums[j - 1]){
                        j --;
                    }
                    j --;
                }
                else{
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    while(i < j && nums[i] == nums[i + 1]){
                        i ++;
                    }
                    while(i < j && nums[j] == nums[j - 1]){
                        j --;
                    }
                    i ++;
                    j --;
                }
            }
         k ++;
        }
        return result;
    }

    /**
     * 16. 最接近的三数之和
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
     * 返回这三个数的和。假定每组输入只存在唯一答案。
     * @param nums 整数数组
     * @param target 目标
     * @return 最接近目标的和
     * 思路：同上，不需要排重因此要容易得多
     */
    public int threeSumClosest(int[] nums, int target){
        if(nums.length <= 2){
            return 0;
        }
        Arrays.sort(nums);
        int i, j, sum, k = 0, current = nums[0] + nums[1] + nums[2];
        while(k < nums.length){
            i = k + 1;
            j = nums.length - 1;
            while(i < j){
                sum = nums[i] + nums[j] + nums[k];
                if(Math.abs(target - current) > Math.abs(target - sum)){
                    current = sum;
                }
                if(sum > target){
                    j --;
                }
                else if(sum < target){
                    i ++;
                }
                else{
                    return sum;
                }
            }
            k ++;
        }
        return current;
    }

    /**
     * 17. 电话号码的字母组合
     *  给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * @param digits 号码
     * @return 可能的号码组合List
     * 思路：干脆的BFS 爆破……
     */
    public List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>(digits.length() * 3);
        if(digits.length() == 0){
            return result;
        }
        searchCombination(result,digits,"");
        return  result;
    }
    private void searchCombination(List<String>result,String digits,String prefix ){
        if(digits.length() == 0){
            result.add(prefix);
        }
        else{
            char c = digits.charAt(0);
            String comb = combination(c);
            for(int i = 0; i < comb.length(); i ++){
                searchCombination(result,digits.substring(1),prefix + comb.charAt(i));
            }
        }
    }
    private String combination(char digit){
        switch (digit){
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    /**
     *  18. 四数之和
     * @param nums 整数数组
     * @param target 目标值
     * @return 非重复的四元组
     *
     * 思路： 三数之和的进化版
     * 关键词：排序
     * 首尾各一个指针
     * 中间两个指针 根据结果移动
     */
    public List<List<Integer>> fourSum(int[]nums, int target){
        List<List<Integer>>result = new ArrayList<>(nums.length);
        if(nums.length < 4){
            return result;
        }
        Arrays.sort(nums);
        int sum;
        for(int l = 0;l < nums.length - 3; l ++){
            if(l > 0 && nums[l] == nums[l - 1]){
                continue;
            }
            for(int r = nums.length - 1;r > l + 2; r --){
                if(r < nums.length - 1 && nums[r] == nums[r + 1]){
                    continue;
                }
                int i = l + 1, j = r - 1;
                while(i < j){
                    System.out.println("i   :" + i + "j  :" + j);
                    sum = nums[l] + nums[r] + nums[i] + nums[j];
                    if(sum < target){
                        while(i < j && nums[i] == nums[i + 1]){
                            i ++;
                        }
                        i++;
                    }
                    else if(sum > target){
                        while(i < j && nums[j] == nums[j - 1]){
                            j --;
                        }
                        j --;
                    }
                    else{
                        result.add(new ArrayList<>(Arrays.asList(nums[l],nums[r],nums[i],nums[j])));
                        while(i < j && nums[i] == nums[i + 1]){
                            i ++;
                        }
                        while(i < j && nums[j] == nums[j - 1]){
                            j --;
                        }
                        i ++;
                        j --;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数
     * 请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * @param n 括号的对数
     * @return 可能的结果
     * 思路： DFS
     */
    public List<String> generateParenthesis(int n){
        List<String>result =new ArrayList<>();
        if(n < 1){
            result.add("");
            return result;
        }
        generate(result, "(",n - 1, n);
        return result;
    }
    private void generate(List<String> result, String current, int left, int right){
        if(left == 0 && right == 0){
            result.add(current);
        }
        else if(left < right){
            if(left > 0){
                generate(result,current + "(",left - 1, right);
            }
            if(right > 0){
                generate(result,current + ")" , left, right - 1);
            }
        }
        else if(left == right){
            generate(result, current + "(", left - 1, right);
        }
    }

    /**
     * 29.两数相除
     * 给定两个整数，被除数 dividend 和除数 divisor。
     * 将两数相除，要求不使用乘法、除法和 mod 运算符
     * @param dividend 除数
     * @param divisor 被除数
     * @return 整数商
     * 除法即减法，使用一个计数器统计进行减法运算的数量，作为商
     * 为了提高效率，每次除后将除数翻倍（使用位运算），此时除数计数也翻倍
     * 如果发现除数搞大了，退回1倍重新做人
     */
    public int divide(int dividend, int divisor){
        long d1 = dividend;
        long d2 = divisor;
        boolean flag = d1 * d2 > 0;
        long count = 0;
        if(divisor == 1){
            count = d1;
        }
        else if(divisor == - 1){
            count = - d1;
        }
        else{
            d1 = Math.abs(d1);
            d2 = Math.abs(d2);
            long tempDivisor, tempCount;
            while(d1 >= d2){
                tempDivisor = d2;
                tempCount = 1;
                while(tempDivisor <= d1){
                    d1 -= tempDivisor;
                    count += tempCount;
                    tempDivisor = tempDivisor << 1;
                    tempCount = tempCount << 1;
                }
            }
            if(!flag){
                count = -count;
            }
        }
        if(count > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return (int)count;
    }
}
