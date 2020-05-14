package medium;



import java.util.*;

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
    /**
     * 5. 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s input String
     * @return longest palindrome
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
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
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
 *  备注：switch似乎比hashmap快得多
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
}
