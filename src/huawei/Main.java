package huawei;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            int anInt = in.nextInt();
            if(anInt != 0) {
                System.out.println(anInt / 2);
            }
        }
    }

}
