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
    private int min;
    private List<Integer> value;

    /** initialize your data structure here. */
    public MinStack() {
        value = new ArrayList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (min > x) {
            min = x;
        }
        value.add(x);
    }

    public void pop() {
        if (!value.isEmpty()) {
            int top = value.remove(value.size() - 1);
            if (top == min) {
                min = Integer.MAX_VALUE;
                for (Integer x : value) {
                    if (min > x) {
                        min = x;
                    }
                }
            }
        }
    }

    public int top() {
        return value.get(value.size() - 1);
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