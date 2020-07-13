package interview;

import java.util.*;
import pojo.ListNode;

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
}
