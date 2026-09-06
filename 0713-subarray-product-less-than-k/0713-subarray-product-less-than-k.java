// brute force 
// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         int n = nums.length;
//         long prod;
//         int cnt  = 0;

//         for(int i = 0; i<n; i++){
//             prod = 1;
//             for(int j = i; j<n; j++){
//                 prod *= nums[j];

//                 if(prod <k){cnt++;}
//             }
//         }
//         return cnt;
//     }
// }





// Optimal  
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<= 1){return 0;}
        int n = nums.length;
        long prod = 1;
        int cnt  = 0;
        int left = 0;
        int len = 0;

        for(int right = 0; right<n; right++){
            prod *= nums[right];

            while(prod >= k){
                prod /= nums[left];
                left++; 
            }

            len+= right - left + 1;
        }
        return len;
    }
}



