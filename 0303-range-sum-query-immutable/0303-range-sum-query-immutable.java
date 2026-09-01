// brute force approach to solve this problem
// class NumArray {
//     private int[] nums;
//     public NumArray(int[] nums) {
//         this.nums = nums;
        
//     }
    
//     public int sumRange(int left, int right) {
//         int sum = 0;

//         // letus remove the bf approach and try to make this work as optimal by adding prf sum
//         // for(int i = left; i<=right; i++){
//         //     sum += nums[i];
//         // }
        
//         // this code also works but here in the issue that i am creating pref array so that will be consming some time
//         int pref[] = new int[nums.length];
//         pref[0] = nums[0];
//         for(int i = 1; i<nums.length; i++){
//             pref[i] =  pref[i-1] + nums[i];
//         }

//         if (left == 0){return pref[right];}
//         else{return pref[right] - pref[left - 1];}
 
//     }
// }



// class NumArray {
//     private int[] pref;
//     public NumArray(int[] nums) {
//        pref = new int[nums.length];
//        pref[0] = nums[0];
//        for(int i = 1; i<nums.length; i++){
//         pref[i] = pref[i-1] + nums[i];
//        }
        
//     }
    
//     public int sumRange(int left, int right) {
//         if (left == 0){return pref[right];}
//         else{return pref[right] - pref[left - 1];}
 
//     }
// }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */






 class NumArray {
    private int[] pref;
    public NumArray(int[] nums) {
       pref = new int[nums.length];
       pref[0] = nums[0];
       for(int i = 1; i<nums.length; i++){
        pref[i] = pref[i-1] + nums[i];
       }
        
    }
    
    public int sumRange(int left, int right) {
        
        if(left == 0){return pref[right];}
        else{
            return pref[right] - pref[left-1];
        }
 
    }
}
