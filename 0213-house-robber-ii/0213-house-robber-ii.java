class Solution {
    private int house(int[] nums, int index, boolean isFirst, int[][] dp){
        if(index >= nums.length){
            return 0;
        }
        int state = isFirst ? 1 : 0;
        if(dp[index][state] != -1 ){
            return dp[index][state];
        }
        if(isFirst && index == nums.length - 1){
            return 0;
        }
        int skip = house(nums, index+1, isFirst, dp);
        if(index == 0){
            isFirst = true;
        }
        int pick = nums[index] + house(nums, index + 2, isFirst, dp);

        return dp[index][state] = Math.max(pick, skip);
    }
    public int rob(int[] nums) {    
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int dp[][] = new int[n][2];
        for(int row[] : dp){
            Arrays.fill(row, -1);
        }
        return house(nums, 0, false, dp);
    }
}