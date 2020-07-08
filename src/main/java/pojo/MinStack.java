package pojo;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author fstar
 */
public class MinStack {
    private int [] data;
    private int len;
    private int currentLen;
    private int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        len = 128;
        data = new int [len];
        currentLen = 0;
    }

    public void push(int x) {
        if(currentLen == len){
            len = len * 2;
            int [] newData = new int[len];
            System.arraycopy(data, 0, newData,0, data.length);
            data = newData;
        }
        data[currentLen] = x;
        currentLen ++;
        if(x  < min){
            min = x;
        }
    }

    public void pop() {
        if(currentLen > 0){
            currentLen --;
        }

    }

    public int top() {
        if(currentLen > 0){
            return data[currentLen - 1];
        }
        return -1;
    }

    public int getMin() {
        return  min;
    }
}
