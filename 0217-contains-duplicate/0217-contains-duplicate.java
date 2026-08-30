// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         int n = nums.length;
//         Arrays.sort(nums);
//         int prev  = nums[0];
//         for(int i = 1; i<n; i++){
//             if(nums[i] == prev){
//                 return true;
//             }
//             else{
//                 prev = nums[i];
//             }
//         }
//         return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int num:nums){
            hs.add(num);
        }

        if(hs.size() == n){return false;}
        else{return true;}
    }
}