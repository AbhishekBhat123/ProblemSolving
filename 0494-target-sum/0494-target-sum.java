// class Solution {
//     private int solve(int nums[], int val, int index, int target){
//         if(val == target && index == nums.length){
//             return 1;
//         }
//         if(index >= nums.length){
//             return 0;
//         }

//         int add = solve(nums, val+nums[index], index+1, target);
//         int subtract = solve(nums, val-nums[index], index+1, target);
//         return add + subtract;
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         return solve(nums, 0, 0, target);
//     }
// }
// now above approach is works for the current problem but 2^n so we used memorization but here the issue is target is -ve so we added offset which is if i find all the array elem then i can say that the sum range from - to + ex: -6 to 6 so..


import java.util.Arrays;

class Solution {

    private int solve(int nums[], int val, int index, int target,
                      int offset, int[][] dp) {

        if (index == nums.length) {
            return val == target ? 1 : 0;
        }

        int column = val + offset;

        // Check memoization
        if (dp[index][column] != -1) {
            return dp[index][column];
        }

        int add = solve(nums, val + nums[index], index + 1,
                        target, offset, dp);

        int subtract = solve(nums, val - nums[index], index + 1,
                             target, offset, dp);

        return dp[index][column] = add + subtract;
    }

    public int findTargetSumWays(int[] nums, int target) {

        int offset = 0;

        for (int n : nums) {
            offset += n;
        }

        // Possible sums range from -offset to +offset
        int[][] dp = new int[nums.length][2 * offset + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, 0, target, offset, dp);
    }
}
