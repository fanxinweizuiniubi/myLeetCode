package huawei;

public class LeetCode344 {

    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        reverseString(arr);
        for (char c : arr) {
            System.out.print(c);
        }
    }

    public static void reverseString(char[] s) {
        if (s.length == 0 || s == null) {
            return;
        }
        int len = s.length;
        int left = 0, right = len - 1;
        while (left < right) {
            swap(left, right, s);
            left++;
            right--;
        }
    }

    public static void swap(int aIndex, int bIndex, char[] arr) {
        char tmp = arr[aIndex];
        arr[aIndex] = arr[bIndex];
        arr[bIndex] = tmp;
    }

}
