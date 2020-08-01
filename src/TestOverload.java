public class TestOverload {

    TestOverload(){
        System.out.println("午餐");
    }

    TestOverload(int i){
        System.out.println(i);
    }

    public static void main(String[] args) {
        TestOverload testOverload = new Son();
    }

}
class Son extends TestOverload{



}