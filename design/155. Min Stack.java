import java.util.Arrays;
import java.util.List;

// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.

class MinStack {
    private int capcaity;
    private int min;
    private int value[];
    private int index;

    /** initialize your data structure here. */
    public MinStack() {
        value = new int[capcaity = 0x10];
        index = 0;
        min = 0x7fffffff;
    }

    public void push(int x) {
        if (index + 1 > capcaity) {
            value =  Arrays.copyOf(value, capcaity <<= 1);
        }
        value[index++] = x;
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        if (index == 0) {
            return;
        }
        int top = value[--index];
        if (top == min) {
            min = 0x7fffffff;
            for (int i = 0; i < index; i++) {
                if (min > value[i]) {
                    min = value[i];
                }
            }
        }
    }

    public int top() {
        return value[index - 1];
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */