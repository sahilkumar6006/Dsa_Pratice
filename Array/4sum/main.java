import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate over the array to fix the first two numbers
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicates for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Step 3: Two-pointer approach for the remaining two numbers
                int left = j + 1;
                int right = nums.length - 1;
                long newTarget = (long) target - nums[i] - nums[j];

                while (left < right) {
                    int twoSum = nums[left] + nums[right];

                    if (twoSum == newTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // Skip duplicates for the third and fourth numbers
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (twoSum < newTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}
