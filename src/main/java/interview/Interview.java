package interview;

import java.lang.reflect.Array;
import java.util.*;

import pojo.ListNode;
import pojo.TreeNode;

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

    /**
     *  01.02 判定是否互为字符重排
     *  给定两个字符串 s1 和 s2
     *  请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 判断结果
     * 思路：先想到map，效率不高
     * 使用整型数组来记录字符出现频率，代替map
     * 长度固定、内容为基本型时，使用数组而非集合，这也是集合的最佳实践之一
     */
    public boolean checkPermutation(String s1, String s2) {
        int [] res = new int[128];
        if(s1.length() != s2.length()){
            return false;
        }
        for(int i = 0; i < s1.length(); i ++){
            res[s1.charAt(i) ] ++;
            res[s2.charAt(i) ] --;
        }
        for(int i : res){
            if(i != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 01.03. URL化
     * URL化。编写一种方法，将字符串中的空格全部替换为%20。
     * 假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。
     * @param s 字符串
     * @param length 真实长度
     * @return
     * 题意难懂，抄来的代码在不同环境执行会出现问题
     * 垃圾题目，不解释
     */
    public String replaceSpaces(String s, int length){
        int i = length - 1;
        int j = s.length() - 1;
        char [] res = s.toCharArray();
        while(i >= 0){
            if(res[i] == ' '){
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            }
            else{
                res[j--]  = res[i];
            }
            i --;
        }
        return String.valueOf(res,j + 1,s.length() - j - 1);
    }

    /**
     *  01.04. 回文排列
     *  给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * @param s 给定字符串
     * @return 是否是回文串
     * 思路： 本质就是int数组（替代map）记录字符出现次数，用于判断回文
     * 出现一次+1 出现两次-1，最终int数组的和只能是0和1，才是一个有效的回文串
     */
    public boolean canPermutePalindrome(String s){
        int [] record = new int [128];
        for(char c : s.toCharArray()){
            if(record[c] == 1){
                record[c]--;
            }
            else{
                record[c] ++;
            }
        }
        int count = 0;
        for(int a : record){
            if(count > 1){
                return false;
            }
            count += a;
        }
        return true;
    }

    /**
     *   01.05. 一次编辑
     *   字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。
     *   给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。

     * @param first 第一个字符串
     * @param second 第二个字符串
     * @return 一次编辑是否可达
     * 思路：起手进坑：使用上一题类似的思路进行记录和判断
     * 但没有考虑到顺序问题（见测试用例3）
     * 正儿八经的思路：把长的字符串调整为first，挨个比较
     * 若发现不通值的字符a[i]，则检查f.substring(i +1)  s.substring(i +1)
     * 或者f.substring(i + 1)  s.substring(i)是否相等，若相等则一步可达
     */
    public boolean oneEditAway(String first, String second){
        if(Math.abs(first.length() - second.length()) >1){
            return false;
        }
        if(first.length() < second.length()){
            String tmp = second;
            second = first;
            first = tmp;
        }
        for(int i = 0; i < second.length(); i ++){
            if(first.charAt(i) != second.charAt(i)){
                return first.substring(i + 1).equals(second.substring(i + 1)) ||
                        first.substring(i + 1).equals(second.substring(i));
            }
        }
        return true;
    }

    /**
     *  01.06. 字符串压缩
     *  字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
     *  比如，字符串aabcccccaaa会变为a2b1c5a3。
     *  若“压缩”后的字符串没有变短，则返回原先的字符串。
     *  你可以假设字符串中只包含大小写英文字母（a至z）。
     * @param s 要压缩的字符串
     * @return 结果
     * 思路：字符改变时统计字符出现的次数并塞入StringBuilder
     * 用时比题解更短的做法：使用for循环替代foreach，并用i - start来计算count，可能会更快些？
     */
    public String compressString(String s){
        if(s.length() == 0){
            return s;
        }
        StringBuilder builder = new StringBuilder();
        char tmp = s.charAt(0);
        int count = 0;
        int len = s.length();
        for(char c : s.toCharArray()){
            if(c != tmp){
                    builder.append(tmp);
                    builder.append(count);
                    count = 1;
                    tmp = c;
            }
            else{
                count ++;
            }
            if(builder.length() >= len){
                return s;
            }
        }
        if(count != 0){
            builder.append(tmp);
            builder.append(count);
        }
        if(builder.length() >= len){
            return s;
        }
        return builder.toString();
    }

    /**
     *  01.07. 旋转矩阵
     *  给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。
     *  请你设计一种算法，将图像旋转 90 度。
     * 不占用额外内存空间能否做到？
     * @param matrix 被反转的矩阵
     *  思路：对角线互换 + 水平翻转，需要先分析
     *   所谓不占用额外内存空间指的是，使用常数级空间，不要理解错
     */
    public void rotate(int [][] matrix){
        int tmp;
        for(int i = 0; i < matrix.length - 1; i ++){
            int j = i + 1;
            for(;j < matrix[i].length; j ++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for(int i = 0; i < matrix.length;i ++){
            int len = matrix[i].length ;
            for(int j = 0;j < len  / 2; j ++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }
    }

    public void setZeroes(int [][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        int [] rowIdx = new int [matrix.length];
        int [] columnIdx = new int [matrix[0].length];
        for(int i = 0; i< matrix.length; i ++){
            for(int j = 0; j < matrix[i].length; j ++){
                if(matrix[i][j] == 0){
                    rowIdx[i] = 1;
                    columnIdx[j] = 1;
                }
            }
        }
        for(int k = 0; k < rowIdx.length; k++){
            if(rowIdx[k] == 1){
                Arrays.fill(matrix[k], 0);
            }
        }
        for(int l = 0;l < columnIdx.length ; l++){
            if(columnIdx[l] == 1){
                for(int n = 0; n < matrix.length; n ++){
                    matrix[n][l] = 0;
                }

            }
        }
    }

    public boolean isFlipedString(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.length() == 0){
            return true;
        }
        char first = s1.charAt(0);
        int location = s2.indexOf(first);
        int current = location;
        int i;
        int count = 0;
        while(location != -1){
            for(i = 0; i < s1.length(); i ++){
                if(s1.charAt(i) == s2.charAt(location)){
                    location ++;
                    count ++;
                    if(location == s2.length()){
                        location = 0;
                    }
                }
                else{
                    location = s2.indexOf(first, current + 1);
                    current = location;
                    count = 0;
                    break;
                }
            }
            if(count == s1.length()){
                return true;
            }
        }
        return false;
    }

    /**
     * 02.01. 移除重复节点
     * @param head 头结点
     * @return 头结点
     * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
     * 链表长度在[0, 20000]范围内。
     * 链表元素在[0, 20000]范围内。
     *
     * 思路：定长、基础类型，数组比哈希速度更快
     * 而且占空间居然少了一点点？
     */
    public ListNode removeDuplicateNodes(ListNode head){
        int [] numArr = new int[20000];
        ListNode prev = new ListNode(0);

        prev.next = head;
        ListNode current = head;
        while(current != null){
            if(numArr[current.val] == 1){
                prev.next = current.next;
            }
            else{
                numArr[current.val] = 1;
                prev = prev.next;
            }
            current = current.next;
        }
        return head;
    }

    /**
     * 02.02. 返回倒数第 k 个节点
     * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
     * @param head 链表头
     * @param k 倒数第k
     * @return 倒数第k的值
     * 思路：双指针，简单题
     */
    public int kthToLast(ListNode head, int k) {
        ListNode target = head;
        for(int i = 0; i < k; i ++){
            head = head.next;
        }
        while(head != null){
            head = head.next;
            target = target.next;
        }
        //没什么必要，但还是健壮些
        if(target != null){
            return target.val;
        }
        return -1;
    }

    /**
     *  02.03. 删除中间节点
     *  实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点）
     *  假定你只能访问该节点。
     * @param node 被删除的节点
     *   简单题，但确实也中了盲区
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     *  02.04. 分割链表
     *  问题描述写得乱七八糟
     *  总之就是以x为基准重做链表，小的在左大的等于的在右
     * @param head 头结点
     * @param x 分割基准值
     * @return 新链表头
     * 思路 新建一个结点，往后接小值，完了一波合并了事
     */
    public ListNode partition(ListNode head, int x){
        ListNode tmp = new ListNode(0);
        ListNode res = tmp;
        ListNode start = new ListNode(0);
                start.next = head;
                head = start;
        while(start.next != null){
            if(start.next.val < x){
                tmp.next = start.next;
                tmp = tmp.next;
                start.next = start.next.next;
            }
            else{
                start = start.next;
            }
        }
        tmp.next = head.next;
        return res.next;
    }

    /**
     * 02.05 链表求和
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * @param l1 一个数
     * @param l2 另一个数
     * @return 结果链表
     * 思路 防一手链表跑远了抛空指针 和 进位 即可
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int extra = 0;
        int current;
        int num1 = 0;
        int num2 = 0;
        ListNode res = new ListNode(0);
        ListNode rt = res;
        while(l1 != null || l2 != null){
            if(l1 != null){
                num1 = l1.val;
                //防空指针异常
                l1 = l1.next;
            }
            if(l2 != null){
                //防空指针异常
                num2 = l2.val;
                l2 = l2.next;
            }
            current = num1 + num2 + extra;
            if(current >= 10){
                current -= 10;
                extra = 1;
            }
            else{
                extra = 0;
            }
            res.next = new ListNode(current);
            num1 = 0;
            num2 = 0;
            res = res.next;
        }
        if(extra == 1){
            res.next = new ListNode(1);
        }
        return rt.next;
    }

    /**
     * 02.06. 回文链表
     * 编写一个函数，检查输入的链表是否是回文的。
     * @param head 头结点
     * @return 是否是回文
     * 奇思妙想进死胡同了，留个纪念
     * 正确的思路：用栈或其他数据结构，记录中间点以后的各个数值，然后出栈（或反转）来比较
     * 高深的思路：慢指针行进过程中就进行前半段链表翻转
     * 链表翻转的方式： 定义一个临时结点、一个新结点
     * 临时结点指向当前遍历的结点
     * 每次遍历，临时结点的next指向新结点，新结点指向临时结点
     * 临时结点回到（已经被推到下一位置的）遍历结点上
     * 盲区警告
     */
    public boolean isPalindrome(ListNode head){
        Stack<Integer> value = new Stack<>();
        ListNode fast = head;
        ListNode slow = head;
        ListNode tmp = slow;
        ListNode newList = null;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            tmp.next = newList;
            newList = tmp;
            tmp = slow;
        }
        //总数量是单数
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){
            if(slow.val != newList.val){
                return false;
            }
            slow = slow.next;
            newList = newList.next;
        }
        return true;
    }
    /**
     * 02.07 同 Easy 160题
     */
    /**
     * 16.11. 跳水板
     * 你正在使用一堆木板建造跳水板
     * 有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
     * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * 返回的长度需要从小到大排列。
     * @param shorter 短木板长度
     * @param longer 长木板长度
     * @param k 要用的木板数量
     * @return 可能的长度数组
     * 思路：数学思路解
     * 规律是：用k块板可以搞出的组合数是k + 1
     * 长度数组的差值就是长短板的差值
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0){
            return  new int [0];
        }
        if(shorter == longer){
            int [] res = new int[1];
            res[0] = shorter * k;
            return res;
        }
        int [] res = new int[k + 1];
        int gap = longer - shorter;
        res[0] = shorter * k;
        for(int i = 1; i <= k; i ++ ){
            res[i] = res[i - 1] + gap;
        }
        return res;
    }

    /**
     *  02.08. 环路检测
     * @param head 头结点
     * @return 有环返开始节点 没环返回空
     * 正宗的龟兔赛跑
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * 04.02. 最小高度树
     * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
     * @param nums 有序数组
     * @return 二叉树
     * 思路：通过有序数组建立二叉搜索树的方式：最中间一个数为根节点，然后递归左右半边的数组
     * 递归函数返回根节点即可
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int middle = nums.length / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, middle));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, middle + 1,nums.length));
        return root;
    }

    /**
     * 10.01 合并排序的数组
     * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
     * 编写一个方法，将 B 合并入 A 并排序。
     * 初始化 A 和 B 的元素数量分别为 m 和 n。
     * @param A A数组
     * @param m 实际长度
     * @param B B数组
     * @param n 实际长度
     *  思路：从末尾开始插入，指针向前推
     */
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1;
        int tail = A.length - 1;
        while(i >= 0 && j >= 0){
            if(A[i] > B[j]){
                A[tail] = A[i];
                tail --;
                i --;
            }
            else{
                A[tail] = B[j];
                tail --;
                j --;
            }
        }
        if(i < 0){
         while(j >= 0){
             A[j] = B[j];
             j --;
         }
        }
    }

    /**
     *   16.05. 阶乘尾数
     * @param n 目标数字
     * @return 尾数一共有多少个0
     * 思路： 5 × 2才得到0， 而2远远比5多（4 = 2 × 2），所以实质上是找乘式中5的个数
     * 注意，是 count += n ，而非count ++，除以5的结果就是5的个数
     */
    public int trailingZeroes(int n ){
        int count = 0;
        while(n >= 5){
            n /= 5;
            count += n;
        }
        return count;
    }

    /**
     * 04.01. 节点间通路
     *  节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     *  思路：DFS 和 BFS的教科书，需要多练习
     */
    ArrayList<Integer>[] myGraph;
    int [] visited;
    public boolean  findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        myGraph = new ArrayList[n];
        visited = new int[n];
        for(int [] dot : graph){
            if(myGraph[dot[0]] == null){
                myGraph[dot[0]] = new ArrayList<>();
            }
            myGraph[dot[0]].add(dot[1]);
        }
        return graphDfs(start, target);
    }
    private boolean graphDfs(int node, int target){
        if(node == target){
            return true;
        }
        List<Integer> current = myGraph[node];
        visited[node] = 1;
        if(current == null){
            return false;
        }
        for(int n : current){
            if(visited[n] == 1){
                continue;
            }
            if(graphDfs(n,target)){
                return true;
            }
        }
        return false;
    }

    /**
     *   04.03. 特定深度节点链表
     *   给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
     *   （比如，若一棵树的深度为 D，则会创建出 D 个链表）。
     *   返回一个包含所有深度的链表的数组。
     * @param tree 二叉树顶
     * @return 包含所有深度的链表数组
     * 思路：BFS，尝试使用备用队列来提升效率
     * 左右子节点全部加入备队列，主队列为空时，主备队列互换
     * 好像没有什么根本变化
     */
    public ListNode[] listOfDepth(TreeNode tree){
        Queue<TreeNode> mainQueue = new ArrayDeque<>();
        Queue<TreeNode> backQueue = new ArrayDeque<>();
        List<ListNode> result = new ArrayList<>();
        mainQueue.offer(tree);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(!mainQueue.isEmpty()){
            TreeNode current = mainQueue.poll();
            if(current.left != null){
                backQueue.offer(current.left);
                cur.next = new ListNode(current.left.val);
                cur = cur.next;
            }
            if(current.right != null){
                backQueue.offer(current.right);
                cur.next = new ListNode(current.right.val);
                cur = cur.next;
            }
            if(mainQueue.isEmpty() && !backQueue.isEmpty()){
                result.add(head.next);
                head = new ListNode(0);
                cur = head;
                mainQueue = backQueue;
                backQueue = new ArrayDeque<>();
            }
        }
        ListNode [] res = new ListNode [result.size()];
        res[0] = new ListNode(tree.val);
        for(int i = 1; i <= result.size(); i ++){
            res[i] = result.get(i - 1);
        }
        return res;
    }

    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        getDepth(root);
        return isBalanced;

    }

    private int getDepth(TreeNode node){
        if(!isBalanced){
            return 0;
        }
        if(node == null){
            return 0;
        }
        int leftLen = getDepth(node.left);
        int rightLen = getDepth(node.right);
        if(Math.abs(leftLen - rightLen) > 1){
            isBalanced = false;
            return 0;
        }
        return Math.max(leftLen, rightLen) + 1;
    }
    long currentMax = Long.MIN_VALUE;
    /**
     * 04.05. 合法二叉搜索树
     * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
     * @param root 树的根节点
     * @return 是否是二叉搜索树
     * 思路： 树的中序遍历
     * 有一个坑爹的用例导致Integer.MIN_VALUE做最小值会出问题
     * 而且也没有限定元素值不重复，辣鸡题目
     */
    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }
    private boolean checkBST(TreeNode node){
        if(node == null){
            return true;
        }
        if(node.left != null){
            if(!checkBST(node.left)){
                return false;
            }
        }
        if(node.val <= currentMax){
            return false;
        }
        currentMax = node.val;
        if(node.right != null){
            return checkBST(node.right);
        }
        return true;
    }

    boolean find = false;
    TreeNode resultNode;
    /**
     * 04.06. 后继者
     * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     * @param root 树根节点
     * @param p 目标节点
     * @return 后继节点
     * 思路： 非常头疼的一个题，表面上看是中序遍历，但跳出时机不太好把握
     * 根据搜索树的性质进行剪枝，边界值也很容易出问题，且效果不明显
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        findNode(root, p.val);
        return resultNode;
    }

    private void findNode(TreeNode node, int val){
        if(node.left != null && node.val >= val){
            findNode(node.left, val);
        }
        if(find){
            find = false;
            resultNode = node;
            return ;
        }
        if(node.val == val){
            find = true;
        }
        if(node.right != null && node.val <= val){
            findNode(node.right, val);
        }
    }

    TreeNode result;
    boolean isFind = false;
    /**
     *  04.08. 首个共同祖先
     *  设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。
     *  不得将其他的节点存储在另外的数据结构中
     * @param root 根节点
     * @param p 查找目标1
     * @param q 查找目标2
     * @return 共同祖先节点
     * 思路：递归，自己、左树、右树里找到一个数就+1
     * 能加到2的地方且位于递归最深层的根节点一定是答案
     * 更短平快、更骚的操作：
     * 若节点等于要查询的节点或空，直接返回
     * 这样，如果左子树中找到了一个值，则会返回它，右子树也是如此
     * 如果左右子树都不为空，说明找到了答案（这时候是递归的最深层，所以肯定是首个祖先）
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p,  q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right;
    }
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        result = root;
//        findNodes(root, p.val, q.val);
//        return result;
//    }

    private int findNodes(TreeNode node, int p, int q){
        int total = 0;
        if(node.val == p || node.val == q){
            total += 1;
        }
        if(node.left != null){
            total += findNodes(node.left, p, q);
        }
        if(node.right != null){
            total += findNodes(node.right, p,q);
        }
        if(total == 2 && !isFind){
            isFind = true;
            result = node;
        }
        return total;
    }

    /**
     *   08.03. 魔术索引
     *   魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引
     *   若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
     *   nums长度在[1, 1000000]之间
     * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
     * @param nums 数组
     * @return 魔术索引
     * 思路：因为数字可能出现重复，所以无法进行二分查找，注意！
     * 也就是说，复杂度不可能降到O(log n)
     * 朴素遍历搞定(最多加一个跳跃性的优化)
     */
    public int findMagicIndex(int [] nums){
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == i){
                return i;
            }
        }
        return  -1;
    }
    /**
     *  08.06. 汉诺塔问题
     * @param A 塔1
     * @param B 塔2
     * @param C 塔3
     *  递归+分治的经典题目，要注意List实现栈操作可能出现的各种问题
     *   以及集合类的深浅拷贝（写测试用例可能会用到）
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        build(A.size(), A, B, C);
    }
    private void build(int size, List<Integer> A, List<Integer> B, List<Integer> C){
        if(size == 1){
            move(A, C);
        }
        else{
            build(size - 1, A, C, B);
            move(A, C);
            build(size - 1, B, A, C);
        }
    }
    private void move(List<Integer> A, List<Integer> B){
        B.add(A.remove(A.size() - 1));
    }

    int len;
    int [] row;
    int [] col;
    int [] vale;
    int [] dale;
    List<String> board;
    List<List<String>> res;

    /**
     *  08.12. N皇后
     * @param n 再战N皇后
     * @return 结果集合
     * 思路：回溯，需要练习 + 复习
     */
    public List<List<String>> solveNQueens(int n){
        res = new ArrayList<>();
        board = new ArrayList<>();
        if(n ==0){
            return res;
        }
        len = n;
        row = new  int[len];
        col = new int[len];
        vale = new int [len * 2];
        dale = new int [len * 2];

        for(int i = 0; i < len; i ++){
            StringBuilder stb = new StringBuilder();
            for(int j = 0; j < len; j ++){
                stb.append('.');
            }
            board.add(stb.toString());
        }
        attempt(0,0);
        return res;
    }

    private  void attempt(int r, int count){
        if(count == len){
            res.add(new ArrayList<>(board));
            return;
        }
        for(int c = 0; c < len; c ++){
            if(checkValid(r, c)){
                put(r ,c);
                attempt(r + 1, count + 1);
                remove(r, c);
            }
        }

    }
    /**
     * 10.02. 变位词组
     * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
     * @param strs
     * @return
     * 思路： 老题目，等优化吧
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> storage = new HashMap<>();
        for(String s : strs){
            int []alpha = new int[26];
            for(char c : s.toCharArray()){
                alpha[c - 97] ++;
            }
            StringBuilder key = new StringBuilder();
            for(int i : alpha){
                key.append("#");
                key.append(i);
            }
            String k = key.toString();
            if(storage.containsKey(k)){
                storage.get(k).add(s);
            }
            else{
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s);
                storage.put(k, arr);
            }
        }
        return new ArrayList<>(storage.values());
    }

    /**
     * 17.14. 最小K个数
     * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
     * @param arr 目标数组
     * @param k 最小的前k个数
     * @return 最小的前k个数数组
     * 思路：堆排序的练兵场，需要多加熟悉
     * 快速排序应该更快，待研究
     */
    public int[] smallestK(int[] arr, int k) {
        if(k == 0){
            return new int[]{};
        }
        int [] res = new int[k];
        buildHeap(arr, arr.length);
        int i = 0;
        int heapSize = arr.length;
        while(i < k){
            res[i] = arr[0];
            i ++;
            swap(arr, 0, heapSize - 1);
            heapSize --;
            minHeap(arr, 0, heapSize);
        }
        return res;
    }

    private void buildHeap(int [] heap, int heapSize){
        for(int i = heap.length / 2; i >= 0; i --){
            minHeap(heap, i, heapSize);
        }
    }
    private void minHeap(int [] heap, int i, int heapSize){
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int min = i;
        if(l < heapSize && heap[l] < heap[min]){
            min = l;
        }
        if(r < heapSize && heap[r] < heap[min]){
            min = r;
        }
        if(min != i){
            swap(heap, min, i);
            minHeap(heap, min, heapSize);
        }
    }
    private void swap(int [] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    private void put(int r, int c){
        StringBuilder stb = new StringBuilder(board.get(r));
        stb.setCharAt(c, 'Q');
        board.set(r,stb.toString());
        row[r] = 1;
        col[c] = 1;
        vale[r - c + len] = 1;
        dale[r + c] = 1;
    }

    private void remove(int r, int c){
        StringBuilder stb = new StringBuilder(board.get(r));
        stb.setCharAt(c, '.');
        board.set(r,stb.toString());
        row[r] = 0;
        col[c] = 0;
        vale[r - c + len] = 0;
        dale[r + c] = 0;
    }

    private boolean checkValid(int r, int c){
        return row[r] + col[c] + vale[r - c + len] + dale[r + c] == 0;
    }

    /**
     *   16.06. 最小差
     *   给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
     * @param a 数组1
     * @param b 数组2
     * @return 最小差
     * 思路：先排序，双指针推进，
     * 两数相减后把小的一方往后推（因为大的更大只会导致差距更大）直到末尾
     * 有一组极其恶心的测试用例，见测试类
     */
    public int smallestDifference(int [] a , int [] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int lenA = a.length;
        int lenB = b.length;
        int i = 0;
        int j = 0;
        long min = Long.MAX_VALUE;
        while(i < lenA && j < lenB){
            min = Math.min(min, Math.abs((long)a[i] - (long)b[j]));
            if(a[i] == b[j]){
                return 0;
            }
            else if(a[i] < b[j]){
                i ++;
            }
            else{
                j ++;
            }
        }
        return (int)min;
    }

    /**
     * 16.10. 生存人数
     * 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]
     * 实现一个方法以计算生存人数最多的年份。
     * 你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。
     * 如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。
     * 例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
     * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
     * @param birth 出生年份
     * @param death 死亡年份
     * @return 存活人数最多的年份
     * 思路：使用数量变化数组存储每一年生死人数的变化，再加一套循环寻找最大值
     * 比较有复习意义的题目
     */
    public int maxAliveYear(int []birth, int []death){
        int len = birth.length;
        int [] change = new int[120];
        int max = 1900;
        int countMax = 0;
        for(int i = 0; i < len; i ++){
            change[birth[i] - 1900] ++;
            change[death[i] - 1899] -- ;
        }
        int count = 0;
        for(int j = 0; j < change.length; j ++){
            count += change[j];
            if(count > countMax){
                countMax = count;
                max = 1900 + j;
            }
        }
        return max;
    }

    /**
     * 16.17. 连续数列
     * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int total = nums[0];
        int current = 0;
        if(nums.length == 1){
            return total;
        }
        for(int i : nums){
            if(i + current > 0){
                current = i + current;
                total = Math.max(total, current);
            }
            else{
                current = 0;
            }
        }
        return total;
    }

    /**
     * 16.20. T9键盘
     * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。
     * 每个数字映射到0至4个字母。给定一个数字序列，实现一个算法来返回匹配单词的列表。
     * 你会得到一张含有有效单词的列表。
     * @param num ha
     * @param words
     * @return
     */
    public List<String> getValidT9Words(String num, String[] words) {
        List<String> result = new ArrayList<>();
        int [] storage = new int [10];
        for(char c : num.toCharArray()){
            storage[c - 48] ++;
        }
        for(String s : words){
            int [] st = storage.clone();
            char [] a = s.toCharArray();
            boolean checked = true;
            for(char b : a){
                int currentNum = location(b);
                st[currentNum] --;
                if(st[currentNum] < 0){
                    checked = false;
                    break;
                }
            }
            if(checked){
                result.add(s);
            }
        }
        return result;
    }
    private int location(char c){
        switch(c){
            case 'a':
            case 'b':
            case 'c':
                return 2;
            case 'd':
            case 'e':
            case 'f':
                return 3;
            case 'g':
            case 'h':
            case 'i':
                return 4;
            case 'j':
            case 'k':
            case 'l':
                return 5;
            case 'm':
            case 'n':
            case 'o':
                return 6;
            case 'p':
            case 'q':
            case 'r':
            case 's':
                return 7;
            case 't':
            case 'u':
            case 'v':
                return 8;
            case 'w':
            case 'x':
            case 'y':
            case 'z':
                return 9;
            default:
                return 0;
        }
    }
    /**
     *  17.06. 2出现的次数
     *  编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
     *  暂时总结规律如下
     * n=10	i = 0	1
     *
     * n=100	i = 1	val(i - 1) * 10 + n % 10  = 20
     *
     * n = 1000	i = 2         val(i - 1) * 10 + n % 10  = 300
     *
     * n = 10000  i = 3      val(i - 1) * 10 + n % 10 = 4000
     */
}
