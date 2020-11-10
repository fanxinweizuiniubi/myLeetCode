package huawei;

public class LeetCode1122 {

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,19,9,2,7};
        int[] arr2 = {2,1,4,3,9,6};
        int[] ans = relativeSortArray(arr1, arr2);
        System.out.println(ans);
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 因为题中给定大小为1000
        int[] bucket = new int[1001];
        // 先将arr1的数据放进桶里
        for(int n : arr1){
            bucket[n]++;
        }
        // 将arr2中有的数在arr1中排序
        int i = 0;
        for(int n : arr2){
            while (bucket[n] > 0){
                arr1[i++] = n;
                bucket[n]--;
            }
        }
        // 遍历桶，将arr2中没有的剩余的数排序
        for(int j = 0;j < bucket.length;j++){
            while(bucket[j] > 0){
                arr1[i++] = j;
                bucket[j]--;
            }
        }
        return arr1;
    }

}
