package twoPointers;

import java.util.Arrays;

public class CountTriplets {

    public static void main(String[] args) {
        CountTriplets countTriplets = new CountTriplets();
        long re = countTriplets.countTriplets(new long[]{-2, 0, 1, 3}, 4, 2);
        System.out.println(re);
    }

    long countTriplets(long[] arr, int n, int sum) {
        long count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                if (arr[l] + arr[r] + arr[i] >= sum) {
                    r--;
                } else {
                    count += r - l;
                    l++;
                }
            }
        }
        return count;
    }

}
