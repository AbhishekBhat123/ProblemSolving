// class Solution {
//     public int minSubArrayLen(int target, int[] nums) {
//         int n = nums.length;
//         int min = Integer.MAX_VALUE;
//         int sum = 0;
//         boolean present = false;

//         for(int i =0; i<n; i++){
//             sum = 0;
//             for(int j = i; j<n; j++){
//                 sum += nums[j];
//                 if(sum >= target){
//                     present = true;
//                     min = Math.min(min, j-i+1);
//                 }
//             }
//         }

//         return present?min : 0;


//     }
// }




// Optimal with sliding window
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        // first we have to iterate over aray to get the sum then once we get the some we have to store its lenth and reduce the window size to get future elements with less length

        for(int right = 0; right<n; right++){
            sum += nums[right];

            while(sum >= target){
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return min == Integer.MAX_VALUE?0: min;

    }
}