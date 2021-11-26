package interview;

import java.util.Arrays;
import java.util.concurrent.*;

public class MS03 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = null;
        try {
            future = executor.submit(() -> {
                try {
                    Thread.sleep(6000);
                    System.out.println("线程执行");
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }
            });
            future.get(5000, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("超时");
        } catch (Exception e) {
            System.out.println("异常:" + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }

    public int[] merge(int[] a, int[] b) {
        int lenA = a.length, lenB = b.length;
        int[] res = new int[lenA + lenB];
        int i = 0, p1 = 0, p2 = 0;
        while (p1 < lenA && p2 < lenB) {
            if (a[p1] <= b[p2]) {
                res[i] = a[p1];
                i++;
                p1++;
            } else {
                res[i] = b[p2];
                i++;
                p2++;
            }
        }
        while (p1 < lenA) {
            res[i] = a[p1];
            p1++;
            i++;
        }
        while (p2 < lenB) {
            res[i] = b[p2];
            p2++;
            i++;
        }
        return res;
    }

}
