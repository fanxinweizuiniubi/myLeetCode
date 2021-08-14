package dynamicPlanning;

public class LeetCode62 {

    public static void main(String[] args) {
        LeetCode62 leetCode62 = new LeetCode62();
        int paths = leetCode62.uniquePaths(3, 7);
        System.out.println(paths);
    }

    /**
     * 将二维数组初始化，由于左上角出发，所以紧连着起点的横着的一行和竖着的一列的路径均为1
     * 状态转移 : 当前点的路径 = 正上方点路径 + 正左方点路径
     */
    public int uniquePaths(int row, int column) {
        int[][] dp = new int[row][column];
        // m为行 n为列
        for(int i = 0;i < row;i++){
            dp[i][0] = 1;
        }
        for(int i = 0;i < column;i++){
            dp[0][i] = 1;
        }
        for(int i = 1;i < row;i++){
            for(int j = 1;j < column;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[row-1][column-1];
    }

}
