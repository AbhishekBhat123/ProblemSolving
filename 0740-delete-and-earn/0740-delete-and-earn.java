class Solution {

    public int fun(int[] points, int i, int[] dp) {

        if (i >= points.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Pick
        int pick = points[i] + fun(points, i + 2, dp);

        // Not Pick
        int notPick = fun(points, i + 1, dp);

        return dp[i] = Math.max(pick, notPick);
    }

    public int deleteAndEarn(int[] nums) {

        int max = 0;

        for (int x : nums) {
            max = Math.max(max, x);
        }

        int[] points = new int[max + 1];

        // Combine duplicate values
        for (int x : nums) {
            points[x] += x;
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, -1);

        return fun(points, 0, dp);
    }
}