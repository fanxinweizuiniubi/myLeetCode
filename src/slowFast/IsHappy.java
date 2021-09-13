package slowFast;

public class IsHappy {

    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        isHappy.isHappy(19);
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int t = n % 10;
            sum += t * t;
            n /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        } while (slow != fast);
        return slow == 1;
    }

}
