package interview;

import java.util.HashSet;
import java.util.concurrent.Callable;

public class MS02 {

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 10;
            }
        };
    }

}
