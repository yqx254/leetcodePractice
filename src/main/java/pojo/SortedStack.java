package pojo;

import java.util.Stack;

/**
 * 03.05. 栈排序
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * 思路： 对新入栈的数据进行检查
 * 若主栈为空则直接插入，若主栈不为空，则将小于插入值的数字弹出到辅助站中，插入结束后再将辅助栈的数字弹回
 * 还有一种神奇的方法，辅助栈升序主栈降序，待总结
 */
class SortedStack {
    Stack<Integer> main;
    Stack<Integer> aid;
    public SortedStack() {
        main = new Stack<>();
        aid = new Stack<>();
    }

    public void push(int val) {
        while(!main.isEmpty() && main.peek() < val){
            aid.push(main.pop());
        }
        main.push(val);
        while(!aid.isEmpty()){
            main.push(aid.pop());
        }
    }

    public void pop() {
        if(!main.isEmpty()){
            main.pop();
        }
    }

    public int peek() {
        if(!main.isEmpty()){
            return main.peek();
        }
        return -1;
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }
}
