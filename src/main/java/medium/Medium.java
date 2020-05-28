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

    /**
     *  31. 下一个排列
     *  实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *  如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *  必须原地修改，只允许使用额外常数空间。
     *  如：
     *  1，2，3  ----   1，3，2
     *  1，5，1  ---- 5，1，1
     *  3，2，1  ---- 1，2，3
     * @param nums 指定数组
     */
    public void nextPermutation(int [] nums){
        int i = nums.length - 2;
        if(nums.length < 2){
            return;
        }
        while(i >= 0){
            if(nums[i] < nums[i + 1]){
                int minIndex = i + 1;
                for(int j = i + 1;j < nums.length; j ++){
                    if(nums[j] > nums[i] && nums[j] < nums[minIndex]){
                        minIndex = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                break;
            }
            else{
                i --;
            }
        }
        Arrays.sort(nums, i  + 1, nums.length) ;
    }

    /**
     *  33. 搜索旋转排序数组
     *  假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *  ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *  搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *  你的算法时间复杂度必须是 O(log n) 级别。
     * @param nums 旋转数组
     * @param target 目标值
     * @return 目标值下标
     * 思路：看到时间复杂度，首先考虑二分查找
     * 若中间索引i对应的值大于等于（这很重要，是容易搞错的边界值）最左端值，则左半边有序
     * 否则是右半边有序
     * 用有序的半边检查指定值是否在范围内，就可以达成查找目的
     * 若在，正常进行二分，若不在，使用另一半并重复操作
     * 边界值是个大问题
     */
    public int search(int [] nums, int target){
        int l = 0;
        int r = nums.length - 1;
        int i;
        while(l <= r){
            i = (l + r) / 2;
            if(nums[i] == target){
                return i;
            }
            //左半边有序
            if(nums[i] >= nums[l]){
                if(nums[i] > target && nums[l] <= target){
                    r = i - 1;
                }
                else{
                    l = i + 1;
                }
            }
            //右半边有序
            else{
                if(nums[i] < target && nums[r] >= target){
                    l = i + 1;
                }
                else{
                    r = i - 1;
                }
            }
        }
        return -1;
    }

    public int [] searchRangeV2(int [] nums, int target){
        if(nums.length == 0){
            return new int [] {-1,-1};
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        int [] result = {-1,-1};
        //先找一个目标，找不到直接返回
        while(left <= right){
            index = (left + right) / 2;
            if(nums[index] == target){
                break;
            }
            else if(nums[index] < target){
                left = index + 1;
            }
            else if(nums[index]  > target){
                right = index - 1;
            }
        }
        if(nums[index] != target){
            return result;
        }
        result[0] = index;
        result[1] = index;
        left = 0;
        right = nums.length - 1;

        boolean leftFlag = true;
        boolean rightFlag = true;

        int leftHead = 0;
        int leftTail = index;
        int rightHead = index + 1;
        int rightTail = nums.length - 1;
        if(rightTail < rightHead){
            rightFlag = false;
        }
        if(leftTail <= leftHead){
            leftFlag = false;
        }
        while(left < index || right > index){
            if(leftFlag){
                left = (leftHead + leftTail) / 2;
                if(nums[left + 1] == target && (nums[left] < target || left - 1 < 0)){
                    if(nums[left] < target){
                        result[0] = left + 1;
                    }
                    else if(left - 1 <= 0){
                        result[0] = left;
                    }
                    leftFlag = false;
                }
                else if(nums[left] == target){
                    leftTail = left - 1;
                }
                else if(nums[left + 1] < target){
                    leftHead = left + 1;
                }
            }
            if(rightFlag){
                right = (rightHead + rightTail) / 2;
                if(nums[right - 1] == target && (nums[right] > target || right + 1 >= nums.length)){
                    if(nums[right] > target) {
                        result[1] = right - 1;
                    }
                    else if(right + 1 >= nums.length){
                        result[1] = right;
                    }
                    rightFlag = false;
                }
                else if(nums[right] == target){
                    rightHead = right + 1;
                }
                else if(nums[right - 1] > target){
                    rightTail = right - 1;

                }
            }
            if(!leftFlag && !rightFlag){
                break;
            }
        }
        return result;
    }

    public int [] searchRange(int [] nums, int target){
        int [] result = new int[] {-1,-1};
        int leftIndex = searchBoundary(nums, target, true);
        if(leftIndex >= nums.length || nums[leftIndex] != target){
            return result;
        }
        int rightIndex = searchBoundary(nums, target, false);
        return new int [] {leftIndex, rightIndex - 1};
    }
    private int searchBoundary(int [] nums, int target, boolean flag){
        int left = 0;
        int right = nums.length;
        int index;
        if(flag){
            while(left < right){
                index = (left + right) / 2;
                if(nums[index] >= target){
                    right = index;
                }
                else{
                    left = index + 1;
                }
            }
        }
        else{
            while(left < right){
                index = (left + right) / 2;
                if(nums[index] <= target){
                    left = index + 1;
                }
                else{
                    right = index;
                }
            }
        }
        return left;
    }

    /**
     *  36. 有效的数独
     *  判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * @param board 疑似数独二维数组
     * @return 是否是有效数独
     * 思路一： 没啥好说的，一次尝试把所有组合放入set中，若被set去重（和计数不一致）则判断其为无效数独
     * 思路二：使用HashMap存储每个组合的数字信息
     * 很关键：横三竖三的box编号求法： (i / 3) * 3 + j / 3
     */
    public boolean isValidSudoku(char [] [] board){
        HashMap<Integer,Integer> [] rows = new HashMap[9];
        HashMap<Integer,Integer> [] column = new HashMap[9];
        HashMap<Integer,Integer> [] box = new HashMap[9];

        for(int i = 0; i < 9; i ++){
            rows[i] = new HashMap<>(16);
            column[i] = new HashMap<>(16);
            box[i] = new HashMap<>(16);
        }
        int boxIndex;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(board[i][j] == '.'){
                    continue;
                }
                boxIndex =  (i / 3) * 3 + j / 3;
                int current = board[i][j];
                if(rows[i].get(current) != null || column[j].get(current) != null
                        || box[boxIndex].get(current) != null){
                    return false;
                }
                rows[i].putIfAbsent(current,1);
                column[j].putIfAbsent(current,1);
                box[boxIndex].putIfAbsent(current,1);
            }
        }
        return true;
    }
    /**
     * 55.跳跃游戏
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个位置。
     * 思路：在数组的每一个位置检测，当前索引 + 最大跳跃步数是否大于等于终点index
     * 适当进行剪枝
     */
    public boolean canJump(int [] nums){
        int current = 0;
        int end = 0;
        if(nums.length == 0){
            return false;
        }
        for(;current < nums.length; current ++){
            if(current > end){
                return false;
            }
            end = Math.max(current + nums[current], end);
            if(end >= nums.length - 1){
                return true;
            }
        }
        return false;
    }

    /**
     *  46. 全排列
     *  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * @param nums 不重复的数字
     * @return 所有全排列List
     * 思路：回溯法典型例子
     * 将问题视作：N个空位上填N个数字
     * 填数字--修改标记数组--尝试填后边的数字--弹出当前数字
     */
    public List<List<Integer>> permute(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        int [] visit = new int [nums.length];
        process(result, new ArrayList<>(), nums, visit);
        return result;
    }
    private void process(List<List<Integer>> result,ArrayList<Integer> current,
                                            int [] nums, int [] visit){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(visit[i] == 1){
                continue;
            }
            visit[i] = 1;
            current.add(nums[i]);
            process(result, current, nums, visit);
            visit[i] = 0;
            current.remove(current.size() - 1);
        }
    }
    /**
     *  47. 全排列 II
     *  给定一个可包含重复数字的序列，返回所有不重复的全排列。
     * @param nums 数字序列
     * @return 非重复全排列
     * 思路：回溯 + 剪枝
     * 与上一题的细微差异：有重复数字
     * 重复数字应该考虑排序并剪枝（排序是剪枝的前提？）
     * 数字重复(nums[i] == nums[i - 1])有两种可能的情况
     * 一是数字刚刚被使用过（visit[i - 1] == 1），在找下一个坑
     * 二是数字刚刚出栈（visit[i - 1] == 0）。该填的list已经填入
     * 二者择一进行剪枝即可去重（这个如果有图更容易理解）
     */
    public List<List<Integer>> permuteUnique(int [] nums){
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        int [] visit = new int[nums.length];
        processUnique(result, new ArrayList<>(),nums, visit);
        return result;
    }

    private  void processUnique(List<List<Integer>> result, ArrayList<Integer> current,
                                                        int [] nums, int []visit){
        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
        }
        for(int i = 0; i < nums.length; i ++){
            if(visit[i] == 1){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && visit[i - 1] == 1){
                continue;
            }
            visit[i] = 1;
            current.add(nums[i]);
            processUnique(result, current, nums, visit);
            visit[i] = 0;
            current.remove(current.size() - 1);
        }
    }

    /**
     * 48. 旋转图像
     * 给定一个 n × n 的二维矩阵表示一个图像。将图像顺时针旋转 90 度。
     * 必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。
     * @param matrix 被旋转图像
     *  思路：研究图形规律
     *  首先将矩阵横竖互换，然后倒转每一行即可
     *   注意避免重复和剪枝
     */
    public void rotate(int [] [] matrix){
        int temp;
        int n = matrix.length;
        for(int i = 0; i < n; i ++){
            for(int j = i; j < n; j ++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int k = 0; k < n; k ++){
            for(int l = 0; l < n / 2; l ++){
                temp = matrix[k][l];
                matrix[k][l] = matrix[k][n - l - 1];
                matrix[k][n - l - 1] = temp;
            }
        }
    }
    /**
     *  49. 字母异位词分组
     *  给定一个字符串数组，将字母异位词组合在一起。
     *  字母异位词指字母相同，但排列不同的字符串。
     * @param strs 字母数组
     * @return 分组后的list
     * 思路：组合分类题目大概率需要使用Map
     * 根据计算获取一个独一无二的值，然后用值做键指向一组异位词
     * 官方解法：使用包含了26个字母出现次数并用符号隔开的字符串做键
     * 如 eat #1#0#0#0#1#…………
     * 美服大神骚套路：用26个质数表示26个字母，用质数的乘积做键保证各个串的唯一性
     * 是个好套路，使用long来存储乘积键避免溢出
     */
    public List<List<String>> groupAnagrams(String [] strs){
        Map<Character, Long> alphaMap = new HashMap<>();
        Map<Long,List<String>> resultMap = new HashMap<>();
        long [] arr = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        for(int i = 0; i < arr.length; i ++){
            alphaMap.put((char) ('a' + i), arr[i]);
        }
        for(String s : strs){
            long key = 1;
            for(char c : s.toCharArray()){
                key *= alphaMap.get(c);
            }
            if(resultMap.containsKey(key)){
                resultMap.get(key).add(s);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                resultMap.put(key,list);
            }
        }
        return new ArrayList<>(resultMap.values());
    }
}
