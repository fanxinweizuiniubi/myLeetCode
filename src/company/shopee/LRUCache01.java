package company.shopee;

import java.util.*;

public class LRUCache01 {

    private int capacity;
    private Long max = 0L;
    private Map<Integer, Integer> cacheMap;
    private Map<Integer, Long> priorityMap;

    public LRUCache01(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        priorityMap = new HashMap<>();
    }

    public int get(int key) {
        if (Objects.isNull(cacheMap.get(key))) {
            return -1;
        } else {
            max += 1;
            priorityMap.put(key, max);
            return cacheMap.get(key);
        }
    }

    public void put(int key, int value) {
        int size = cacheMap.size();
        Long min = 999999999L;
        if (size == capacity) {
            if (Objects.isNull(cacheMap.get(key))) {
                int minIndex = 0;
                for (int i : priorityMap.keySet()) {
                    if (priorityMap.get(i) < min) {
                        min = priorityMap.get(i);
                        minIndex = i;
                    }
                }
                cacheMap.remove(minIndex);
                priorityMap.remove(minIndex);
            }
        }
        cacheMap.put(key, value);
        max += 1;
        priorityMap.put(key, max);
    }

}
