class Solution {
    private int[] stack;
    private int[] minStack;
    private int topIndex;
    private int capacity;

    public Solution() {
        capacity = 1000000; 
        stack = new int[capacity];
        minStack = new int[capacity];
        topIndex = -1;
    }

    public void push(int x) {
        if (topIndex + 1 >= capacity) return;  
        topIndex++;
        stack[topIndex] = x;
        if (topIndex == 0) {
            minStack[topIndex] = x;
        } else {
            minStack[topIndex] = Math.min(x, minStack[topIndex - 1]);
        }
    }

    public void pop() {
        if (topIndex == -1) return;  
        topIndex--;
    }

    public int top() {
        if (topIndex == -1) return -1;
        return stack[topIndex];
    }

    public int getMin() {
        if (topIndex == -1) return -1;
        return minStack[topIndex];
    }
}
