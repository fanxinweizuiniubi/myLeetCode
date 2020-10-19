package multiThread;

public class NoneBlock {

    private static final Object obj = new Object();

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized(obj) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }

    }
    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized(obj) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }

}
