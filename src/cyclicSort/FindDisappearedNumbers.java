package cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        findDisappearedNumbers.findDisappearedNumbersDiscuss(new int[]{4,3,2,7,8,2,3,1});
    }

    public List<Integer> findDisappearedNumbersDiscuss(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
        for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int[] record = new int[nums.length + 1];
        Arrays.fill(record, -1);
        for (int num : nums) {
            record[num] = 1;
        }
        for (int i = 1; i < record.length; i++) {
            if (record[i] == -1) {
                res.add(i);
            }
        }
        return res;
    }

}
