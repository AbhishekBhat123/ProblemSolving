// class Solution {
//     public int[] runningSum(int[] nums) {
//        int n = nums.length;
//         int[] pref = new int[n];
//         pref[0] = nums[0];
//         for(int i =1; i<n; i++){
//             pref[i] = pref[i-1]+ nums[i];
//         }
//         return pref;
//     }
// }

// recursion
class Solution {
    private void helper(int[] nums, int[] ans, int i){
        if(i == nums.length){
            return;
        }
        ans[i] = nums[i] + ans[i-1];
        helper(nums,ans,i+1);
    }
    public int[] runningSum(int[] nums) {
       int n = nums.length;
        int[] pref = new int[n];
        pref[0] = nums[0];
        helper(nums, pref, 1);
        return pref;
    }
}