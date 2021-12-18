package company.shopee;

import java.util.Deque;

public class LC232 {

    public static void main(String[] args) {
        MyQueue myQueue01 = new MyQueue();
        myQueue01.push(1);
        myQueue01.push(2);
        myQueue01.push(3);
        myQueue01.push(4);
        myQueue01.pop();
        myQueue01.push(5);
        int i = myQueue01.pop();
        int q = myQueue01.pop();
        int w = myQueue01.pop();
        int r = myQueue01.pop();
        System.out.println();
        Deque<Integer> deque;
    }

}
