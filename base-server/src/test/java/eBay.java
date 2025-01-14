import java.util.ArrayList;
import java.util.List;

public class eBay {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int num : nums) {
            if (current.contains(num)) {
                continue;
            }
            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        eBay ebay = new eBay();
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = ebay.permute(nums);
        
        System.out.println("Input: nums = [1,2,3]");
        System.out.println("Output: " + permutations);
    }
}
