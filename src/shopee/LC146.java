package shopee;

public class LC146 {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        int a = lRUCache.get(2);
        lRUCache.put(2, 6);
        int b = lRUCache.get(1);
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        int c = lRUCache.get(1);
        int d = lRUCache.get(2);
        System.out.println("end");
    }

}
