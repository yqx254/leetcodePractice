package pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author fstar
 */
public class StackOfPlates {
    List<Stack<Integer>> storage;
    int currentStack;
    int maxCap;
    public StackOfPlates(int cap) {
        storage = new ArrayList<>();
        storage.add(new Stack<>());
        currentStack = 0;
        maxCap = cap;
    }

    public void push(int val) {
        if(maxCap == 0){
            return;
        }
        if(storage.get(currentStack).size() == 0
                && currentStack > 0
                && storage.get(currentStack - 1).size() < maxCap
        ){
            storage.get(currentStack - 1).push(val);
            return;
        }
        if(storage.get(currentStack).size() == maxCap){
            storage.add(new Stack<>());
            currentStack ++;
        }
        storage.get(currentStack).push(val);
    }

    public int pop() {
        while(storage.get(currentStack).size() == 0){
            if(currentStack == 0){
                return -1;
            }
            storage.remove(currentStack);
            currentStack --;
        }
        return storage.get(currentStack).pop();
    }

    public int popAt(int index) {
        while(index <= currentStack && storage.get(index).size() == 0) {
            index ++;
        }
        if(index > currentStack){
            return -1;
        }
        return storage.get(index).pop();
    }
}
