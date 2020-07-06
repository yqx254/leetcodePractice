package interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Interview {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

 }
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
}
