package shopee;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack;
    private Stack<Integer> stackB;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        stackB = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            stackB.push(pop);
        }
        Integer res = stackB.pop();
        while (!stackB.isEmpty()) {
            Integer pop = stackB.pop();
            stack.push(pop);
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            stackB.push(pop);
        }
        Integer res = stackB.peek();
        while (!stackB.isEmpty()) {
            Integer pop = stackB.pop();
            stack.push(pop);
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

}
