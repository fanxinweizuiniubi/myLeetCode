package huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class Huawei02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TreeSet<Integer> set = new TreeSet<>();
        while (in.hasNext()) {
            int n = in.nextInt();
            for(int i = 0;i < n;i++) {
                set.add(in.nextInt());
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
    }

}
