package multiThread;

public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        testJoin.blockedTest();
    }

    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(this::testMethod, "a");
        Thread b = new Thread(this::testMethod, "b");
        a.start();
        try {
            a.join(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.start();
        // Thread.sleep(1001L);
        // 输出？
        System.out.println(a.getName() + ":" + a.getState());
        // 输出？
        System.out.println(b.getName() + ":" + b.getState());
    }

    // 同步⽅法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
