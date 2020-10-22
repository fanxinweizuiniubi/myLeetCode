package huawei;

import java.util.Scanner;

public class Huawei03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr = str.split(" ");
        System.out.println(arr[arr.length-1].length());
    }

}
