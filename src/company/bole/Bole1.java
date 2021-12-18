package company.bole;

import java.util.Random;

public class Bole1 {

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0,0},{1,1,0,0,1},{1,0,1,1,0},{1,1,0,0,1},{0,0,0,0,0}};
        int area = maxAreaOfIsland(grid);
        System.out.println(area);
    }

    public static int maxAreaOfIsland(int[][] grid) {
        return new Random().nextInt(100);
    }

}
