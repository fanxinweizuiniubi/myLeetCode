package interview;

import java.util.Arrays;

public class MS03 {

    public static void main(String[] args) {
        MS03 ms03 = new MS03();
        int[] a = {1, 2, 5};
        int[] b = {2, 4, 6};
        int[] merge = ms03.merge(a, b);
        System.out.println(Arrays.toString(merge));
    }

    public int[] merge(int[] a, int[] b) {
        int lenA = a.length, lenB = b.length;
        int[] res = new int[lenA + lenB];
        int i = 0, p1 = 0, p2 = 0;
        while (p1 < lenA && p2 < lenB) {
            if (a[p1] <= b[p2]) {
                res[i] = a[p1];
                i++;
                p1++;
            } else {
                res[i] = b[p2];
                i++;
                p2++;
            }
        }
        while (p1 < lenA) {
            res[i] = a[p1];
            p1++;
            i++;
        }
        while (p2 < lenB) {
            res[i] = b[p2];
            p2++;
            i++;
        }
        return res;
    }

}
