package company.bole;

public class Bole3 {

    public static void main(String[] args) {
        int[] change = coinChange(87);
        System.out.println(change);
    }

    public static int[] coinChange(int coin) {
        // 从最大的开始取，可以继续取就+1
        int[] ans = new int[6];
        while (coin != 0) {
            if (coin - 100 >= 0) {
                coin = coin - 100;
                ans[5]++;
            } else if (coin - 50 >= 0) {
                coin = coin - 50;
                ans[4]++;
            } else if (coin - 20 >= 0) {
                coin = coin - 20;
                ans[3]++;
            } else if (coin - 10 >= 0) {
                coin = coin - 10;
                ans[2]++;
            } else if (coin - 5 >= 0) {
                coin = coin - 5;
                ans[1]++;
            } else if (coin - 1 >= 0) {
                coin = coin - 1;
                ans[0]++;
            }
        }
        return ans;
    }

    public static int[] coinChange1(int amount) {
        // 从最大的开始取，可以继续取就+1
        int[] ans = new int[6];
        int[] coins = {1, 5, 10, 20, 50, 100};
        for (int i = 1;i < amount;i++){

        }
        return ans;
    }

}
