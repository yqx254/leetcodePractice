package pojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值
 * 执行push、pop和min操作的时间复杂度必须为O(1)。
 * @author fstar
 * 神tm简单题
 * 用数组实现的话，要注意栈被弹空以后当前最小值的处理
 * 当前数等于最小值时需要入栈
 */
public class MinStack {
    int [] num;
    int [] min;
    int currentLen;
    int minLen;
    int len;
    int currentMin;
    /** initialize your data structure here. */
    public MinStack() {
        len = 128;
        num = new int [len];
        min = new int[len];
        currentLen = 0;
        minLen = 0;
        currentMin = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(currentLen == len){
            len = len * 2;
            int [] newNum = new int [len];
            int [] newMin = new int[len];
            System.arraycopy(num, 0, newNum,0,currentLen);
            System.arraycopy(min, 0, newMin,0,currentLen);
            num = newNum;
            min = newMin;
        }
        num[currentLen] = x;
        if(minLen == 0 || x <= currentMin){
            min[minLen] = x;
            minLen ++;
            currentMin = x;
        }
        currentLen ++;
    }

    public void pop() {
        if(currentLen > 0){
            currentLen --;
            if(num[currentLen] == min[minLen - 1]){
                minLen --;
                if(minLen > 0){
                    currentMin = min[minLen - 1];
                }
                else{
                    currentMin = Integer.MAX_VALUE;
                }
            }
        }
    }

    public int top() {
        if(currentLen > 0){
            return num[currentLen - 1];
        }
        return -1;
    }

    public int getMin(){
        return  min[minLen - 1];
    }
}
