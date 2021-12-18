package company.huawei;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> mainQueue;
    Queue<Integer> subQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        mainQueue = new LinkedList<>();
        subQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        subQueue.offer(x);
        while(!mainQueue.isEmpty()){
            subQueue.offer(mainQueue.poll());
        }
        Queue<Integer> tmp = mainQueue;
        mainQueue = subQueue;
        subQueue = tmp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        // 出队，并返回当前元素
        return mainQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        // 取得队头元素
        return mainQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return mainQueue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
    }

}


