package competition;

public class LeetCode5554 {

    public static void main(String[] args) {
        // int[][] pieces = {{78},{4,64},{91}};
        int[][] pieces = {{2,4,6,8}};
        // int[] arr = {91,4,64,78};
        int[] arr = {1,3,5,7};
        boolean b = canFormArray(arr, pieces);
        System.out.println(b);
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        for(int[] piece : pieces){
            int count = 0;
            for(int num : arr){
                if(count < piece.length && num == piece[count]){
                    count++;
                }
            }
            if(count != piece.length) return false;
        }
        return true;
    }

    public static boolean canFormArray1(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length;) {
            boolean flag = false;
            for (int[] piece : pieces) {
                if (arr[i] == piece[0]) {
                    for (int j = 0; j < piece.length; i++, j++) {
                        if (arr[i] != piece[j]) {
                            return false;
                        }
                    }
                    flag = true;
                    break;
                }
            }
            // 压根儿就没有相等的，就是false
            if (!flag) {
                return false;
            }
        }
        return true;
    }



}
