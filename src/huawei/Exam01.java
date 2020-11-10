package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1;i <= num;i++){
            sum = 0;
            List<Integer> li = new ArrayList<>();
            for(int j = i;j <= num;j++){
                sum = sum + j;
                li.add(j);
                if(sum > num){
                    break;
                }
                if(sum == num){
                    list.add(li);
                    break;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = list.size() - 1;i >= 0;i--){
            ans.add(list.get(i));
        }
        for(List<Integer> ll : ans){
            StringBuilder sb = new StringBuilder(num + "=");
            for(int i = 0;i < ll.size();i++){
                sb.append(ll.get(i));
                if(i != ll.size() - 1) {
                    sb.append("+");
                }
            }
            System.out.println(sb.toString());
        }
        System.out.println("Result:" + list.size());
    }

}
