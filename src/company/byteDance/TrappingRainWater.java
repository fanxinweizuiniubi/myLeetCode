package company.byteDance;

public class TrappingRainWater {

    public int optimize(int[] height) {
        int re = 0, len = height.length, leftMax = 0, rightMax = 0;
        int left = 1, right = len - 2;
        for (int i = 1; i < len - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                leftMax = Math.max(leftMax, height[left - 1]);
                int min = leftMax;
                if (min > height[left]) {
                    re += min - height[left];
                }
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right + 1]);
                int min = rightMax;
                if (min > height[right]) {
                    re += min = height[right];
                }
                right--;
            }
        }
        return re;
    }

    public int trap(int[] height) {
        int re = 0, len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        for (int i = 1; i < len - 1; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                re += min - height[i];
            }
        }
        return re;
    }

    public int lineByLine(int[] height) {
        int re = 0, max = 0, len = height.length;
        if (len == 0) return 0;
        for (int value : height) {
            if (value > max) {
                max = value;
            }
        }
        for (int i = 1; i <= max; i++) {
            int l = -1, r = -1;
            for (int j = 0; j < len; j++) {
                if (height[j] >= i) {
                    l = j;
                    break;
                }
            }
            for (int k = len - 1; k >= 0; k--) {
                if (height[k] >= i) {
                    r = k;
                    break;
                }
            }
            int s = r - l + 1;
            int sub = 0;
            for (int q = l; q <= r; q++) {
                if (height[q] >= i) {
                    sub++;
                }
            }
            re += s - sub;
        }
        return re;
    }
}
