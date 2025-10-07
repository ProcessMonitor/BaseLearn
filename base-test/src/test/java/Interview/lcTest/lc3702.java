package Interview.lcTest;

public class lc3702 {


    public int longestSubsequence(int[] nums) {
        int sum_xor = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_xor ^= nums[i];
        }
        // 总异或
        if (sum_xor != 0)
            return nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) return nums.length - 1;
        }
        return 0;
    }

}
