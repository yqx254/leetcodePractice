package interview;

import pojo.ListNode;
import pojo.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 剑指offer分类题解
 * @author fstar
 */
public class Offer {
    /**
     *  Offer 03. 数组中重复的数字
     *  在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
     *  数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     *  请找出数组中任意一个重复的数字。
     * @param nums 输入数组
     * @return 重复数字
     * 思路：  FBI warning！ 这题是用不了弗洛伊德龟兔跑的（见中等题287）！
     * 因为数字中有0，会导致尝试建立链表的企图失效
     * 同时这题是对沟通能力的考察
     * 空间复杂度的要求是否是O(1)?是：数组排序，否则使用哈希或类哈希方式求解
     */
    public int findRepeatNumber(int[] nums) {
        int [] storage = new int[nums.length];
        for(int num : nums){
            if(storage[num] == 1){
                return num;
            }
            storage[num] ++;
        }
        return -1;
    }

    /**
     *   Offer 05. 替换空格
     * @param s 需要替换的字符串
     * @return 替换后的结果
     * 思路： 没啥好说的
     * 把字符串转化成char array再遍历是个小技巧
     */
    public String replaceSpace(String s){
        char [] c = s.toCharArray();
        StringBuilder stb = new StringBuilder();
        for(char t : c){
            if(t == ' '){
                stb.append("%20");
            }
            else{
                stb.append(t);
            }
        }
        return stb.toString();
    }
    /**
     * Offer 06. 从尾到头打印链表
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     * @param head 头节点
     * @return 反转的数组
     * 思路： 栈解法： 空间复杂度为O(n)
     * 切记！！！！不要用storage.size()直接做循环控制变量，囧
     * 反转链表（迭代式）然后再顺序输出，速度快得多
     */
    public int[] reversePrint(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode tmp;
        int size = 0;
        while(current != null){
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
            size ++;
        }
        int [] result = new int[size];
        size = 0;
        while(prev != null){
            result[size++] = prev.val;
            prev = prev.next;
        }
        return result;
    }
    /**
     * Offer 10-1  斐波那契数列
     *写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
     * 同No509
     * @param n 数列的第n项
     *  思路：直接想到的可能是递归，n过大时会超时
     *   使用map存储已经算出来的第n项值可以显著提高效率，但空间占用较大
     *   使用比较骚气的动态规划法循环求余
     *    简单来说就是一步一步将a推到n的位置，利用sum做跳板
     */
    public int fib(int n){
        int a = 0, b = 1,sum;
        for(int i = 0; i < n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    /**
     *  Offer 10- II. 青蛙跳台阶问题
     *  一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
     *  求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * @param n 台阶总数
     * @return 步数
     * 思路： 动态规划问题，递归必死
     * 可以看作是一个斐波那契数列的变种，返回值、边界值的选定比较讲究
     */
    public int numWays(int n){
        int a = 1, b = 2, sum;
        if(n  < 2){
            return 1;
        }
        for(int i = 3; i <= n; i ++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
    /**
     *  Offer 11. 旋转数组的最小数字
     *
     * @param numbers 旋转数组
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     *  例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *  思路：基本有序的数组问题首先考虑二分查找，注意边界值（尤其是high --）
     *   用堆排始终要慢了一点点
     */
    public int minArray(int [] numbers){
        int low = 0, high = numbers.length - 1,mid;
        while(low < high){
            mid = (low + high) / 2;
            if(numbers[mid] > numbers[high]){
                low = mid + 1;
            }
            else if(numbers[mid] < numbers[high]){
                high = mid;
            }
            else{
                high --;
            }
        }
        return numbers[low];
    }

    int [][] map;
    char [] wordArr;
    char [][] board;
    int row;
    int col;

    /**
     * Offer 12. 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
     * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
     * @param board  矩阵
     * @param word 某字符
     * @return 是否能找到
     * 思路： 回溯算法，在长度为1的矩阵上翻车
     * 要特别注意边界值，以及什么时候自增控制变量
     */
    public boolean exist(char[][] board, String word){
        row = board.length;
        col = board[0].length;
        map = new int [row][col];
        wordArr = word.toCharArray();
        this.board = board;
        boolean flag;
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(board[i][j] == wordArr[0]){
                    flag = moveForward(i,  j,1);
                    if(flag){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean moveForward(int i, int j, int len){
        if(i < 0 || i >= row || j < 0 || j >= col){
            return  false;
        }
        if(map[i][j] == 1){
            return false;
        }
        if(board[i][j] == wordArr[len - 1]){
            map[i][j] = 1;
            if(len == wordArr.length){
                return true;
            }
            len ++;
            boolean result = moveForward(i - 1,j, len) || moveForward(i,j - 1, len) ||
                    moveForward(i + 1, j, len) || moveForward(i , j + 1, len);
            if(!result){
                map[i][j] = 0;
            }
            return  result;
        }
        return false;
    }
    /**
     * Offer 17. 打印从1到最大的n位数
     * @param n n位数
     * @return 打印结果
     * 思路： 简单题，好像没发现什么坑
     */
    public int[] printNumbers(int n){
        int end = (int)Math.pow(10, (n - 1));
        int [] result = new int[end - 1];
        for(int i = 1; i < end; i ++){
            result[i - 1] = i;
        }
        return result;
    }

    /**
     * Offer 18. 删除链表结点
     * @param head 头结点
     * @param val 删除值
     * @return 头结点
     * 思路： 简单题，头结点的处理稍微注意一下
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode current = head;
        if(head.val == val){
            return head.next;
        }
        while(current != null){
            if(current.val == val){
                prev.next = current.next;
                return head;
            }
            prev = prev.next;
            current = current.next;
        }
        return head;
    }

    /**
     * Offer 22. 链表中倒数第k个节点
     * @param head 头
     * @param k 倒数第几
     * @return 返回链表
     * 简单题不解释
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for(int i = 0; i < k; i ++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    /**
     *Offer 24. 反转链表
     * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * @param head 头结点
     * 思路：简单题，漏了不少细节，试试用递归解
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode tmp;
        while(current != null){
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return  head;
    }

    /**
     * Offer 25. 合并两个排序的链表
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     * 思路： 常规操作，骚套路不太好想
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                tmp.next = l1;
                l1 = l1.next;
            }
            else{
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l1 != null ? l1 : l2;
        return head.next;
    }
    /**
     * Offer 27 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     * 思路：临时保存节点，进行递归
     * 或者使用辅助栈？
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }

    /**
     * Offer 28. 对称的二叉树
     *请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 思路：递归检查镜像对应节点的值是否相等，注意二叉树可能为空
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left, root.right);
    }

    private boolean check(TreeNode n1, TreeNode n2){
        if(n1 == null || n2 == null){
            return n1 == n2;
        }
        if(n1.val != n2.val){
            return false;
        }
        return check(n1.left,n2.right) && check(n1.right, n2.left);
    }
}
