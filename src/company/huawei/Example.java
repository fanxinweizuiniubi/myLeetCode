package company.huawei;

import java.util.Scanner;

public class Example {

    // 本题为考试多行输入输出规范示例，无需提交，不计分。
    static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int ans = 0, x;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    x = sc.nextInt();
                    ans += x;
                }
            }
            System.out.println(ans);
        }
    }

}
