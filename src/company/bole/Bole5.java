package company.bole;

public class Bole5 {

    public static void main(String[] args) {
        boolean b = isValid(10);
        System.out.println(b);
    }

    private static boolean isValid(int x){
        while(x % 2 == 0){
            x /= 2;
        }
        while(x % 3 == 0){
            x /= 3;
        }
        while(x % 5 == 0){
            x /= 5;
        }
        return x == 1 ? true : false;
    }

}
