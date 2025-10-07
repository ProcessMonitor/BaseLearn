package Interview.lcTest;

public class lc3701 {
    public int alternatingSum(int[] nums) {
        int length = nums.length;
        if (length == 1)
            return nums[0];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int step = i % 2 == 0 ? 1 : -1;
            sum = sum + nums[i] * step;
        }

        return sum;
    }
}
