package code;

public class baiduQuickSortFindK {
    // 主函数，快速选择第k大的元素
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    // 快速选择函数
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[k];
        }
        int pivotIndex = partition(nums, left, right);
        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    // 分区函数
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int partitionIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > pivot) {
                swap(nums, i, partitionIndex);
                partitionIndex++;
            }
        }
        swap(nums, partitionIndex, right);
        return partitionIndex;


    }

    // 交换元素
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        baiduQuickSortFindK quickSelect = new baiduQuickSortFindK();
        int[] nums = {10, 10, 9, 9, 8, 7, 6, 4, 3, 4, 2};
        int k = 3; // 查找第3大的数
        int result = quickSelect.findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is " + result);
    }
}

