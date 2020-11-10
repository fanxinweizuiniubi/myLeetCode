package huawei;

import java.util.Scanner;

public class HJ2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //while(sc.hasNext()){
        char[] line = sc.nextLine().toLowerCase().toCharArray();
        char letter = sc.next().toLowerCase().charAt(0);
        int count = 0;
        for (char c : line) {
            if (letter == c) {
                count++;
            }
        }
        System.out.println(count);
        //}

    }

}
