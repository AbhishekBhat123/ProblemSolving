
class Solution {
    private int fun(int[] array, int index, int[] dp) {

        if(index >= array.length) {
            return 0;
        }
        if(dp[index] != -1){return dp[index];}
        // Pick
        int pick = index * array[index] + fun(array, index + 2, dp);

        // Skip
        int skip = fun(array, index + 1, dp);

        dp[index] = Math.max(pick, skip);
        return dp[index];
    }

    public int deleteAndEarn(int[] nums) {
        int max = 0;

        for(int i : nums) {
            max = Math.max(max, i);
        }

        int[] count = new int[max + 1];

        for(int i : nums) {
            count[i]++;
        }

        int[] dp = new int[max+1];
        Arrays.fill(dp, -1);
        return fun(count, 0, dp);
    }
}
