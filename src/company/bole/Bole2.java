package company.bole;

public class Bole2 {

    public static void main(String[] args) {
        int[] arr = {5,0,6,7};
        int maximumValue = maximumValue(arr);
        System.out.println(maximumValue);
    }

    /**
     * 取数组中不连续的最大值
     * @param arr
     * @return
     */
    public static int maximumValue (int[] arr) {
        int cur = 0, prepre = 0, pre = 0 ;
        for(int i = 0; i < arr.length; i++)
        {
            cur = Math.max(arr[i] + prepre, pre);
            prepre = pre;
            pre =  cur;
        }
        return cur;
    }
}
