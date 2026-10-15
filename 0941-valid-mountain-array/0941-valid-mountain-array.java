class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        // Step 1: Minimum length
        if (n < 3) {
            return false;
        }

        int i = 0;

        // Step 2: Climb uphill
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Step 3: Peak cannot be at either end
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Step 4: Climb downhill
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // Step 5: Must reach the end
        return i == n - 1;
    }
}