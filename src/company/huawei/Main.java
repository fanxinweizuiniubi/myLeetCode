package company.huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            double num = in.nextDouble();
            int ans = (int)(num + 0.5);
            System.out.println(ans);
        }
    }

}
