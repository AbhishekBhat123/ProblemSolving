class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find the minimum and maximum possible capacity
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }

        // Binary search for the minimum capacity
        while (left < right) {
            int mid = left + (right - left) / 2;

            int daysNeeded = 1;
            int currentWeight = 0;

            // Check how many days are needed for this capacity
            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    daysNeeded++;
                    currentWeight = weight;
                } else {
                    currentWeight += weight;
                }
            }

            if (daysNeeded <= days) {
                // Capacity works; try a smaller one
                right = mid;
            } else {
                // Capacity is too small
                left = mid + 1;
            }
        }

        return left;
    }
}