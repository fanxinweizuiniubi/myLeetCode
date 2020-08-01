package slidingWindow;

public class Leetcode11 {

    public static void main(String[] args) {
        int height[] = {4,4,2,11,0,11,5,11,13,8};
        int max = maxArea(height);
        System.out.println(max);
    }

    // 双指针
    private static int maxArea(int[] height) {
        if(height.length == 0) return 0;
        // 设置两个指针i,j
        // 移动指针时优先移动指针位置数值小的
        // 移动后选择的下一个指针要比当前指针指向的值大
        int i = 0,j = height.length - 1;
        int area = 0,max = area;
        // 跳出循环条件，两个指针相撞
        while(i < j){
            int weight = height[i] > height[j] ? height[j] : height[i];
            area = (j-i)*weight;
            if(area > max) max = area;
            if(height[i] > height[j]) j--;
            else i++;
        }
        return max;
    }

}
