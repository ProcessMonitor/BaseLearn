package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC448 {

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int n = nums.length;
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
                    swap(nums, i, nums[i] - 1);
            }
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1)
                    ans.add(i + 1);
            }
            return ans;
        }

        void swap(int[] numbers, int i, int j) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
}
