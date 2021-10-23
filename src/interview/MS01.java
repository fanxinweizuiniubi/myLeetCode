package interview;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class MS01 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);
        // 迭代器
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 比较器
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
        // 线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3,5,60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        // 带有版本号的cas
        AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(0,0);
        new ArrayList<>();
        new HashMap<>();
    }

}
