package pojo;

import java.util.Objects;
import java.util.Stack;

/**
 * Offer 30. 包含min函数的栈
 * 同MinStack（interview0302）
 * 这个题最大的坑是最小值出栈以后，要调整当前的最小值来让之后的比较正确进行
 * 踩炸了两次
 */
public class MinStack2 {
    Stack<Integer> storage;
    Stack<Integer> min;
    int currentMin = Integer.MAX_VALUE;
    public MinStack2() {
        storage = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if(x <= currentMin){
            min.push(x);
            currentMin = x;
        }
        storage.push(x);
    }

    public void pop() {
        if(Objects.equals(storage.peek(), min.peek())){
            min.pop();
            //hin关键！！！
            if(min.size() == 0){
                currentMin = Integer.MAX_VALUE;
            }
            else{
                currentMin = min.peek();
            }
        }
        storage.pop();
    }

    public int top() {
        return storage.peek();
    }

    public int min() {
        return min.peek();
    }
}
