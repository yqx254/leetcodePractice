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
    private int minLen;
    private int [] minArr;
    /** initialize your data structure here. */
    public MinStack() {
        len = 128;
        data = new int [len];
        minArr = new int [len];
        currentLen = 0;
        minLen = 0;
    }

    public void push(int x) {
        if(currentLen == len){
            len = len * 2;
            int [] newData = new int[len];
            int [] newMinArr = new int[len];
            System.arraycopy(data, 0, newData,0, data.length);
            System.arraycopy(minArr, 0, newMinArr,0, minArr.length);
            data = newData;
            minArr = newMinArr;
        }
        data[currentLen] = x;
        if(x <= min || currentLen == 0){
            min = x;
            minArr[minLen] = x;
            minLen ++;
        }
        currentLen ++;
    }

    public void pop() {
        if(currentLen > 0){
            currentLen --;
            if(minArr[minLen - 1] == data[currentLen]){
                minLen -- ;
                if(minLen > 0){
                    min = minArr[minLen - 1];
                }
                else{
                    min = Integer.MAX_VALUE;
                }
            }
        }
    }

    public int top() {
        if(currentLen > 0){
            return data[currentLen - 1];
        }
        return -1;
    }

    public int getMin(){
        return  minArr[minLen - 1];
    }
}
