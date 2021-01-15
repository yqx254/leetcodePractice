package easy;

import pojo.ListNode;
import pojo.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

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
     * 假设我们的环境只能存储得下 32 位的有符号整数
     *  思路：模10除10下一波
     *  用long存储来处理边界值问题
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
     * 额外要求：不使用字符串
     * 思路：负数和被10整除的数字直接返回false
     * 翻转整数和原数据进行比较
     * 优化：当结果数大于等于原数时，代表已经比对了超过一半的数字
     * 可直接确定结果
     */
    public boolean isPalindrome(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int result = 0;
        while(x > result){
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == x || result / 10 == x;
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

    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums 排序数组
     * @return 长度
     * 思路：快慢针
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[slow] == nums[fast]){
                fast ++;
            }
            else{
                nums[slow + 1] = nums[fast];
                slow ++;
                fast ++;
            }
        }
        return slow + 1;
    }

    /**
     * 27.移除元素
     * @param nums 元素数组
     * @param val 移除值
     * @return 长度
     * 思路：双指针
     * 当然，双指针也分别人的双指针和自己的双指针……
     */
    public int removeElement(int [] nums, int val){
        int i = 0;
        for(int j = 0; j < nums.length; j ++){
            if(nums[j]  != val){
                nums[i] = nums[j];
                i ++;
            }
        }
        return i;
    }

    /**
     *  28. 实现 strStr()
     *  给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
     *  如果不存在，则返回  -1。
     * @param haystack 源字符串
     * @param needle 目标字符串
     * @return 目标字符串所在位置
     * 思路1： 双循环暴力拆解
     * 思路2：  Sunday算法，建立偏移量map 如th： t： 2 h： 1
     *   例如 something  th   th与so不等，在map中查找m的偏移量  结果未找到，idx从0移动到0 + th.length  + 1 = 3
     *   et  与th不等，h在map中等于1，idx后移一位，th = th，返回idx=4
     *   思路3：KMP算法，未研究，较困难
     *   思路4：内置函数极限偷鸡
     */
    public int strStr(String haystack, String needle){
        Map<Character, Integer> bias = new HashMap<>();
        int needleLen = needle.length();
        int haystackLen = haystack.length();
        if(needleLen > haystackLen){
            return -1;
        }
        for(int i = 0; i < needleLen; i ++){
            bias.put(needle.charAt(i), needleLen - i);
        }
        int idx = 0;
        while(idx + needleLen <= haystackLen){
            String current = haystack.substring(idx,idx + needleLen);
            if(current.equals(needle)){
                return idx;
            }
            if(idx + needleLen >= haystackLen){
                return -1;
            }
            char next = haystack.charAt(idx + needleLen);
            if(bias.containsKey(next)){
                idx += bias.get(next);
            }
            else{
                idx += needleLen + 1;
            }
        }
        return  -1;
    }

    /**
     *  35. 搜索插入位置
     *   给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     *   如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * @param nums 目标数组
     * @param target 插入值
     * @return 插入位置
     */
    public int searchInsert(int [] nums, int target){
        int left = 0;
        int right = nums.length;
        int index;
        while(left < right){
            index = (left + right) / 2;
            if(nums[index] >= target){
                right = index;
            }
            else{
                left = index + 1;
            }
        }
        return left;
    }

    public String countAndSay(int n){
        return say(n);
    }

    private String say(int n){
        if(n == 1){
            return "1";
        }

        StringBuilder sb1 = new StringBuilder();
        String num = say(n - 1);
        if(num.length() == 1){
            sb1.append(1).append(num.charAt(0));
            return sb1.toString();
        }
        int count = 1;
        char start = num.charAt(0);
        for(int i = 1; i <  num.length(); i ++){
            if(num.charAt(i) == start){
                count ++;
            }
            else{
                sb1.append(count).append(start);
                start = num.charAt(i);
                count = 1;
            }
        }
        sb1.append(count).append(start);
        return sb1.toString();
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        if(nums.length == 1){
            return max;
        }
        for(int n : nums){
            if(sum > 0){
                sum += n;
            }
            else{
                sum = n;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 58. 最后一个单词的长度
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
     * @param s 给定字符串
     * @return 最后单词的长度
     * 思路： 没什么好说的，库函数走你
     * 会有"a "这个比较坑爹的用例，做一下trim
     */
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        int lastSpace = s.lastIndexOf(' ');
        return s.length() - lastSpace - 1;
    }

    /**
     *  100. 相同的树
     *给定两个二叉树，编写一个函数来检验它们是否相同。
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p  一棵树
     * @param q  另一棵树
     * @return 是否相同
     * 思路：简单递归
     */
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p == null || q == null){
            return p == q;
        }
        if(p.val != q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    int max = 0;
    /**
     *  104. 二叉树的最大深度
     *  给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root 根节点
     * @return 最大深度
     * BFS DFS各来一遍，需要多加练习的基操
     */
    public int maxDepth(TreeNode root) {
//        dfs(root, 1);
//        return max;
        return bfs(root);
    }
    private void dfs(TreeNode root, int current){
        if(root == null){
            max = Math.max(current, max);
            return;
        }
        dfs(root.left, current + 1);
        dfs(root.right, current + 1);
    }

    private int bfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = bfs(root.left);
        int right = bfs(root.right);
        return Math.max(left, right) + 1;
    }
     /**
     * 160.相交链表
     * 编写一个程序，找到两个单链表相交的起始节点。
     */
     public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode n1 = headA;
        ListNode n2 = headB;
        ListNode newList;
        int stat = 0;
        if(n1 == null || n2 == null){
            return null;
        }
        //把两个链表连成环
        while(n1.next != null && n2.next != null){
            n1 = n1.next;
            n2 = n2.next;
        }
        if(n1.next == null){
            if(n1 == headB){
                return n1;
            }
            n1.next = headA;
            stat = 1;
            newList = headB;
        }
        else{
            if(n2 == headA){
                return n2;
            }
            n2.next = headB;
            stat = 2;
            newList = headA;
        }
        ListNode fast = newList;
        ListNode slow = newList;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //出现环
            if(fast == slow){
                fast = newList;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                //不让改结构啊，调回去
                if(stat == 1){
                    n1.next = null;
                }
                if(stat == 2){
                    n2.next = null;
                }
                return fast;
            }
        }
        //不让改结构啊，调回去
         if(stat == 1){
             n1.next = null;
         }
         if(stat == 2){
             n2.next = null;
         }
        return null;
     }

    /**
     *  167. 两数之和 II - 输入有序数组
     *  给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *  函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * @param numbers 有序数组
     * @param target 要找的目标
     * @return 下标值
     * 思路：理论最佳思路应该是双指针一前一后？
     * 查找并剪枝的效率感觉还行，先酱
     */
     public int[] twoSum2(int [] numbers, int target){
        for(int i = 0; i < numbers.length; i ++){
            int realTarget = target - numbers[i];
            if(realTarget >= numbers[i]){
                int idx = Arrays.binarySearch(numbers, i,numbers.length,realTarget);
                if(idx > 0){
                    return new int[]{i + 1, idx + 1};
                }
            }
        }
        return new int[]{};
     }

    /**
     *198. 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，
     * 计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     * @param nums 金额数组
     *   思路：动态规划法，折戟沉沙again
     *  总结一下，动态规划法的临时存储变量一般是一个数组
     *  每一个点上，偷（加当前值）和不偷（越过当前值）是两种结果，比较后存储最大值
     *   然后再往后推
     */
    public int rob(int [] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int [] max = new int [nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i < nums.length; i ++){
            max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
        }
        return max[nums.length - 1];
    }
    /**
     * 206. 反转链表
     * 反转一个单链表。
     * @param head 链表头
     *   思路：有递归法和迭代法两种，递归法的空间复杂度较高
     *  但是不会不行哟
     */
    public ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    /**
     *  392. 判断子序列
     *  给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * @param s 疑似子序列
     * @param t 长长的字符串
     * @return 疑似子序列是不是子序列
     * 思路：双指针
     * 把字符串拆成字符数组可以略微提升效率
     */
     public boolean isSubsequence(String s, String t){
        if(s.length() > t.length()){
            return false;
        }
        char [] sChar = s.toCharArray();
        char [] tChar = t.toCharArray();
        int i = 0,j = 0;
        while(i < t.length() && j < s.length()){
            if(sChar[j] == tChar[i]){
                j ++;
            }
            i ++;
        }
        return j == s.length();
     }

    /**
     * 415. 字符串相加
     * 两字符串相加，不能直接转整形
     * @param num1  字符串1
     * @param num2 字符串2
     * @return 字符串型的结果
     * 思路：转成char array挨个计算
     *  char - '0' 的效率高于 char - 48
     *  toCharArray的效率高于 挨个charAt
     */
     public String addStrings(String num1, String num2){
         char [] n1 = num1.toCharArray();
         char [] n2 = num2.toCharArray();
         int start1 = n1.length - 1;
         int start2 = n2.length - 1;
         int extra = 0;
         StringBuilder result = new StringBuilder();
         while(start1 >= 0 || start2 >= 0 || extra != 0){
             int tmp  = extra;
             if(start1 >= 0){
                 tmp += (n1[start1] - '0');
                 start1 --;
             }
             if(start2 >= 0){
                 tmp += (n2[start2] - '0');
                 start2 --;
             }
             if(tmp >= 10){
                 extra = 1;
                 tmp -= 10;
             }
             else{
                 extra = 0;
             }
             result.append(tmp);
         }
         return result.reverse().toString();
     }

    /**
     *  696. 计数二进制子串
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量
     * 并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     * @param s 二进制字符串
     * 思路：循环比较当前值i和前一个值tmp
     *  如果i往前走一直不变且一直等于tmp ，每走一步总数+1
     *  如果i值变了，把tmp值重置为i的前值
     *  想通了会比较容易
     */
    public int countBinarySubstrings(String s){
        if(s. length() < 2){
            return 0;
        }
        int total = 0, tmp = -1;
        char [] c = s.toCharArray();
        for(int i = 1;i < c.length; i ++){
            if(c[i - 1] != c[i]){
                tmp = i - 1;
            }
            if(tmp > - 1 && c[tmp] != c[i]){
                total ++;
                tmp --;
            }
        }
        return total;
    }

    /**
     *  二叉树的层序遍历 II
     *  给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]
     * 返回其自底向上的层序遍历为：
     * [[15,7],[9,20],[3]]
     * @param root
     * @return
     * 思路：BFS，需要多练
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //双向队列和链表队列效率差距还是有点大哟
        //Queue<TreeNode> queue = new <>ArrayDeque();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> currentLayer = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                currentLayer.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(0, currentLayer);
        }
        return result;
    }

    /**
     * 上一题的dfs实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottomDFS(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        bottomDfs(root, 0, result);
        return result;
    }
    private void bottomDfs(TreeNode node, int depth, List<List<Integer>> result){
        if(node == null){
            return;
        }
        //非常精髓且不易理解的部分
        if(depth == result.size()){
            result.add(0, new ArrayList<>());
        }
        result.get(result.size() - depth - 1).add(node.val);

        bottomDfs(node.left,depth + 1, result);
        bottomDfs(node.right,depth + 1, result);
    }
}