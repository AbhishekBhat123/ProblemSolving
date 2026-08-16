// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int left = 0;
//         int right = 0;
        
//         for(int i =0; i<n; i++){
//             // left += nums[i];
//             right += nums[i];
//         }

//         for(int i =0; i<n; i++){
//              if(i!=0){
//                 left +=nums[i-1];
//             }
//             right -= nums[i];
            
//             if(left == right){
//                 return i;
//             }
           
//         }
//         return -1;
//     }
// }



// class Solution {
//     public int pivotIndex(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];

//         //finding the leftSum
//         int leftSum = 0;
//         for(int i = 0; i<n; i++){
//             ans[i] = leftSum;
//             leftSum += nums[i];
//         }
 

//         // for fiding the right sum and make that subtract it 
//         // int rightSum = 0;
//         // for(int i = n- 1; i>=0; i--){
//         //     leftSum -= nums[i];
//         //     if(leftSum == ans[i]){return i;}
//         // }

//         //above code doesnt worked so tried with below approach here i am going to check is value == rightsum
//         int rightSum = 0;
//         int pivot = -1;
//         for(int i = n-1; i>=0; i--){
//             if(ans[i] == rightSum){pivot = i;}
//             else{
//                 rightSum += nums[i];
//             }
//         }

//         return pivot;
//     }
// }

// here we can even reduce this space complexity from O(n) to O(1)


class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length; 
        int totalSum = 0;
        //finding the total sum first
        for(int num:nums){
            totalSum += num;
        }
        // int pivot = -1;
        int rightSum = 0;
        int leftSum = 0;

        for(int i = 0; i<n; i++){
            rightSum = totalSum - nums[i] - leftSum;

            if(leftSum == rightSum){return i;}
            else{leftSum += nums[i];}
        }


        return -1;
    }
}