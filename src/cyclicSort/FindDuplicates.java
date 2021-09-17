package cyclicSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicates {

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        findDuplicates.findDuplicatesDiscuss(new int[]{4,3,2,7,8,2,3,1});
    }

    public List<Integer> findDuplicatesDiscuss(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(num));
            }
            nums[index] = -nums[index];
        }
        return res;
    }

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> record = new HashMap<>();
        for (int num : nums) {
            record.put(num, record.getOrDefault(num, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer num : record.keySet()) {
            if (record.get(num) == 2) {
                res.add(num);
            }
        }
        return res;
    }

}
