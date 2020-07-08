package pojo;

/**
 * @author fstar
 */
public class TripleInOne {
    private int [][] data;
    private int []currentSize;
    private int unitLen;
    public TripleInOne(int stackSize) {
        unitLen = stackSize;
        data = new int[3][unitLen];
        currentSize = new int [3];
    }

    public void push(int stackNum, int value) {
        if(currentSize[stackNum] == unitLen){
            return;
        }
        data[stackNum][currentSize[stackNum]] = value;
        currentSize[stackNum] ++;
    }

    public int pop(int stackNum) {
        if(currentSize[stackNum] <= 0){
            return -1;
        }
        int res = data[stackNum][currentSize[stackNum] - 1];
        currentSize[stackNum] --;
        return res;
    }

    public int peek(int stackNum) {
        if(currentSize[stackNum] <= 0){
            return -1;
        }
        return data[stackNum][currentSize[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return currentSize[stackNum] <= 0;
    }
}
