package huawei;

import java.util.*;

public class LeetCode692 {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> ans = topKFrequent(words, k);
        System.out.println(ans);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        List<String> ans = new ArrayList<>(map.keySet());
        Collections.sort(ans, (a, b) -> map.get(a).equals(map.get(b)) ?
                a.compareTo(b) : map.get(b) - map.get(a));
        return ans.subList(0,k);
    }

}
