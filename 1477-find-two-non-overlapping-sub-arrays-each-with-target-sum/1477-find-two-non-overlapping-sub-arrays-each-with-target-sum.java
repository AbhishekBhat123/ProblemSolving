// class Solution {
//     public int minSumOfLengths(int[] arr, int target) {
//         int n = arr.length;
//         List<int[]> subarrays = new ArrayList<>();
//         int minLength = Integer.MAX_VALUE;
//         for(int i = 0; i<n; i++){
//             int sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += arr[j];
//                 if(sum == target){
//                     int length = j - i + 1;
//                     subarrays.add(new int[]{i, j, length});
//                 }
//             }
//         }

//         for(int i = 0; i<subarrays.size(); i++){
//             for(int j = i+1; j<subarrays.size(); j++){
//                 int a[] = subarrays.get(i);
//                 int b[] = subarrays.get(j);

//                 if(a[1] < b[0] || b[1] < a[0]){
//                     int totalLength = a[2] + b[2];
//                     minLength = Math.min(minLength, totalLength);
//                 }
//             }
//         }
//         return minLength == Integer.MAX_VALUE ? -1 : minLength;
//     }
// }

class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int INF = Integer.MAX_VALUE / 2;

        int[] best = new int[n];
        Arrays.fill(best, INF);

        int left = 0;
        int sum = 0;
        int minLen = INF;
        int ans = INF;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            // Shrink window if sum exceeds target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int len = right - left + 1;

                // Combine with a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                minLen = Math.min(minLen, len);
            }

            // Best subarray length found up to this index
            best[right] = minLen;
        }

        return ans == INF ? -1 : ans;
    }
}