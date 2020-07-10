package pojo;

import java.util.Stack;

/**
 * 03.04. 化栈为队
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 * @author fstar
 *  思路： 主栈 + 辅助栈
 *  主栈存储数据，需要弹出时，将主栈数据全部弹出到辅助栈中（也就是改变了顺序）
 *  将翻江倒海操作统一到peek中，可以稍微提高效率
 */
public class MyQueue {
    Stack<Integer> main;
    Stack<Integer> aid;
    /** Initialize your data structure here. */
    public MyQueue() {
        main = new Stack<>();
        aid = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        main.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        aid.peek();
        return aid.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(aid.isEmpty()){
            while(!main.isEmpty()){
                int current = main.pop();
                aid.push(current);
            }
        }
        return aid.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return main.isEmpty() && aid.isEmpty();
    }
}
