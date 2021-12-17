package company.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam02 {

    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 1;i <= n;i++){
            arr.add(i);
        }
        fullp(arr,0);
        System.out.println();
    }

    private static void fullp(List<Integer> arr, int index) {
        if(arr.size() == index){
            ans.add(arr);
            return;
        }
        for(int i = index;i < arr.size();i++){
            swap(arr,index,i);
            fullp(arr,index+1);
            swap(arr,index,i);
        }
    }

    private static void swap(List<Integer> arr,int indexA,int indexB){
        int tmp = arr.get(indexA);
        arr.set(indexA,arr.get(indexB));
        arr.set(indexB,tmp);
    }

}
