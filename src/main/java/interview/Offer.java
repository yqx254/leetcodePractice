package interview;

import pojo.ListNode;
import pojo.TreeNode;

import java.lang.reflect.Array;
import java.util.*;

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


    int cnt = 0;
    int limit;
    int [][] robotBoard;
    int xLen, yLen;
    /**
     *  Offer 13. 机器人的运动范围
     *  地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     *  一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外）
     *  也不能进入行坐标和列坐标的数位之和大于k的格子。
     *  例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
     *  但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     * @param m 横长
     * @param n 竖长
     * @param k 边界参数
     * 思路：DFS搞起
     */
    public int movingCount(int m, int n, int k){
        robotBoard = new int[m][n];
        limit = k;
        xLen = m;
        yLen = n;
        forwardMove(0,0);
        return cnt;
    }
    private void forwardMove(int x, int y){
        if(!checkCurrent(x, y)){
            return;
        }
        robotBoard[x][y] = 1;
        cnt ++;
        forwardMove(x - 1, y);
        forwardMove(x, y - 1);
        forwardMove(x + 1, y);
        forwardMove(x, y + 1);
    }

    private boolean checkCurrent(int x, int y){
        if(x < 0 || y < 0 || x == xLen || y == yLen){
            return false;
        }
        return (x % 10 + x / 10 + y % 10 + y / 10) <= limit && robotBoard[x][y] == 0;
    }

    /**
     *  Offer 14- I. 剪绳子
     *  给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1）
     *  每段绳子的长度记为 k[0],k[1]...k[m-1] 。
     *  请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * @param n 绳子的长度
     * @return 最大的可能乘积
     * 思路： 数学证明略略略  切绳子，切出3的乘积最小，小于3就是0或1或2
     * 大于三： 是2就乘2 是1就把最后一个3 + 1 切成2 + 2 得4，完事
     */
    public int cuttingRope(int n){
        if(n <= 3){
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        if(b == 0){
            return (int) Math.pow(3, a);
        }
        if(b == 1){
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int ) Math.pow(3, a)* 2;
    }

    /**
     * Offer 14- II. 剪绳子 II
     * @param n 绳子
     * @return 乘积
     * 傻缺题目
     */
    public int cuttingRope2(int n){
        if(n <= 3){
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        long result = 1;
        for(int i = 1;i < a; i ++){
            result = result * 3 % 1000000007;
        }
        if(b == 0){
            result = result * 3 % 1000000007;
        }
        else if(b == 1){
            result = result * 4 % 1000000007;
        }
        else{
            result = result * 6 % 1000000007;
        }
        return (int)result;
    }

    /**
     * Offer 15. 二进制中1的个数
     * 渣渣题目，输入不能被正常接收
     * API走你
     * @param n 可能是0开头的没办法正常转换的数字
     * @return 1的个数
     */
    public int hammingWeight(int n){
        return Integer.bitCount(n);
    }

    /**
     *Offer 16. 数值的整数次方
     * 实现函数double Power(double base, int exponent)，求base的exponent次方。
     * 不得使用库函数，同时不需要考虑大数问题。
     * 不考虑大数问题个屁咧！
     * @param x 一个数字
     * @param n 多少次幂
     * 思路：似乎是一个叫快速幂的玩法，之后在具体研究
     * 被乘数乘上自己以后，把结果变成被乘数，同时乘率翻倍，计数 + 乘率
     * 如果发达县计数 + 乘率 大于结果，就把乘率变回1重新来过
     * 存在n=-2147483648这个使用绝对值或取负时会溢出的用例（不是说不考虑大数？），所以要把关键变量表示成long型
     */
    public double myPow(double x, int n){
        long rate = 1;
        long cnt = 0;
        double current = x;
        double total = 1;
        boolean flag = (n >= 0);
        long num = n;
        num = Math.abs(num);
        while(cnt < num){
            if(cnt + rate > num){
                rate = 1;
                current = x;
            }
            if(flag){
                total *= current;
            }
            else{
                total *= 1 / current;
            }
            current = current * current;
            cnt += rate;
            rate *= 2;
        }
        return  total;
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

    int [] heapArr;

    /**
     *  Offer 40. 最小的k个数
     *  输入整数数组 arr ，找出其中最小的 k 个数。
     *  例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     * @param arr 数组
     * @param k 个数
     * @return k个数
     * 思路： 堆排序！
     * 可以考虑学习一下快速排序解法
     */
    public int [] getLeastNumbers(int [] arr, int k){
        heapArr = arr;
        int heapSize = heapArr.length;
        buildHeap();
        int [] result = new int [k];
        int index = 0;
        while(index < k){
            swap(0, heapSize - 1);
            result[index] = heapArr[heapSize - 1];
            heapSize --;
            index ++;
            minHeap(0,heapSize);
        }
        return result;
    }

    private void buildHeap(){
        int size = heapArr.length;
        for(int i = size / 2 - 1; i >=0 ; i --){
            minHeap(i,size);
        }
    }

    private void minHeap(int current, int heapSize){
        int minIdx = current;
        int l = current * 2 + 1;
        int r = current * 2 + 2;
        if(l < heapSize && heapArr[l] < heapArr[minIdx]){
            minIdx = l;
        }
        if(r < heapSize && heapArr[r] < heapArr[minIdx]){
            minIdx = r;
        }
        if(minIdx != current){
            swap(minIdx, current);
            minHeap(minIdx, heapSize);
        }
    }

    private void swap(int i, int j){
        int tmp = heapArr[i];
        heapArr[i] = heapArr[j];
        heapArr[j] = tmp;
    }

    /**
     *  Offer 21. 调整数组顺序使奇数位于偶数前面
     *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     *  使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
     * @param nums 整数数组
     * @return 调整结果
     * 思路：不要想得太复杂，双指针就能解
     * num % 2 == 1 和num & 1 == 1都能够判断数字是否是奇数，学习了
     */
    public int[] exchange(int []nums){
        int i = 0, j = nums.length - 1;
        while(i < j){
            while(i < nums.length && (nums[i] & 1) == 1){
                i ++;
            }
            while( j >= 0 && (nums[j] & 1) == 0){
                j --;
            }
            if(i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return  nums;
    }

    /**
     *  Offer 26. 树的子结构
     *  输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *  B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     * @param A 大树
     * @param B  小树
     * @return 是否是子树
     * 思路：比较土气的BFS + 递归校验，待优化
     * 更新，DFS速度快得多，为什么呢？
     * 大概是BFS算法写的不好？
     */
    public boolean isSubStructure(TreeNode A, TreeNode B){
        if(A == null || B == null){
            return false;
        }
        return checkTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean checkTree(TreeNode p, TreeNode q){
        if(q == null){
            return true;
        }
        if(p == null){
            return false;
        }
        return p.val == q.val && checkTree(p.left, q.left) && checkTree(p.right, q.right);
    }

    /**
     * Offer 32 - I. 从上到下打印二叉树
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     * @param root 根节点
     * @return 打印结果
     * 思路: BFS
     * 值得注意的效率提升细节（学到了！）
     * 1.队列使用LinkedList比ArrayDeque快得多
     * 2.一种List< Integer > 转 int[]的方法是int[] ints = list.stream().mapToInt(Integer::valueOf).toArray();效率似乎比较低
     * 3.最后一步杀鸡取卵式遍历，释放内存，有点意思
     */
    public int[] levelOrder(TreeNode root){
        if(root == null){
            return new int[0];
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> storage = new LinkedList<>();
        storage.offer(root);
        while(storage.size() > 0){
            TreeNode node = storage.poll();
            result.add(node.val);
            if(node.left != null){
                storage.offer(node.left);
            }
            if(node.right != null){
                storage.offer(node.right);
            }
        }
        int [] res = new int[result.size()];
        for(int i = 0;i < result.size(); i ++){
            //这个remove就有点精髓
            res[i] = result.remove(0);
        }
        return res;
    }

    /**
     * Offer 32 - II. 从上到下打印二叉树 II
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     * @param root 根节点
     * @return 打印结果
     * 思路：BFS很容易想到，关键是什么时候换行
     * 提前取得当前存储队列的长度，就可以避免while循环时结点一头进一头出而导致的死循环
     * 居然没想到
     */
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size() != 0){
            List<Integer> list = new ArrayList<>();
            //这个边界控制很关键！
            for(int i = queue.size(); i > 0 ; i --){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(list);

        }
        return result;
    }

    /**
     *  Offer 32 - III. 从上到下打印二叉树 III
     *  请实现一个函数按照之字形顺序打印二叉树
     *  即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印
     *  其他行以此类推。
     * @param root 根节点
     * @return 打印结果
     * 思路： 尝试过两种思路解决问题
     * 1.逢偶数行使用Collections.reverse倒转结果
     * 2.使用LinkedList，，逢偶数行使用addFirst构造列表
     * 第二种方法更快些
     */
    public List<List<Integer>> levelOrder3(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue <TreeNode> storage = new LinkedList<>();
        storage.offer(root);
        boolean reverse = false;
        while(!storage.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = storage.size(); i > 0; i --){
                TreeNode node;
                node =storage.poll();
                if(reverse){
                    list.addFirst(node.val);
                }
                else{
                    list.add(node.val);
                }
                if(node.left != null){
                    storage.add(node.left);
                }
                if(node.right != null){
                    storage.add(node.right);
                }
            }
            result.add(list);
            reverse = !reverse;
        }
        return result;
    }

    /**
     * Offer 39. 数组中出现次数超过一半的数字
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * @param nums 数组
     * @return 众数
     * 常规解法：
     * 1.哈希表存储（空间复杂度较高）
     * 2.排序以后取正中间的（时间复杂度较高）
     * 3.摩尔投票法（最佳解法）
     * 将第一位数字设置成候选人，选票为1，遍历数组
     * 若被遍历的值不等于候选人，则减一票，票数为0又被减一票时，更换候选人并重设选票值
     * 因为众数超过总数的一半，所以票数必定是正的
     * 很有意思的解法
     */
    public int majorityElement(int[] nums) {
        int vote = 1;
        int current = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if(nums[i] == current){
                vote ++;
            }
            else if(vote > 0){
                vote --;
            }
            else{
                current = nums[i];
                vote = 1;
            }
        }
        return current;
    }

    /**
     * Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * @param nums
     * @return
     * 完全没有弄懂的题目，请再试！！
     * 实际上是相对简单的动态规划题目，需要多次复习
     */
    public int maxSubArray(int [] nums){
        int max = nums[0];
        int sum = 0;
        if(nums.length < 2){
            return  max;
        }
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
