// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int n = nums.length;
//         int cnt = 0;
//         int max = 0;

//        for(int i = 0; i<n; i++){
//             cnt = 0;
//             int kval = k;
//          for(int j = i; j<n; j++){
//             if(nums[j] == 1){cnt++;}
//             else if(nums[j] == 0 && kval!= 0){
//                 kval--;
//                 cnt++;
//             }
//             else{break;}
//             max= Math.max(max, cnt);            
//          }
//        }

//         return max;
//     }
// }



// Optimal using sliding window my code 
// class Solution {
//     public int longestOnes(int[] nums, int k) {
//         int n = nums.length;
//         int max = 0;
//         int left = 0;
//         int cnt = 0;
//         int kval = k;

//         for(int right = 0; right<n; right++){
//             if(nums[right] == 1){
//                 cnt++;
//                 max = Math.max(max, cnt);
//             }
//             else if(nums[right] == 0 && kval!=0){
//                 cnt++;
//                 kval--;
//                 max = Math.max(max, cnt);
//             }
//             else{
//                 while(kval==0){
//                     cnt--;
//                     if(nums[left] == 0){kval++;}
//                     left++;
//                 }
//                 if(kval >0){
//                     cnt++;
//                     max = Math.max(cnt,max);
//                     kval--;
//                 }
//             }
//         }
//         return max;
//     }
// }




// optimal and improved code
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0;
        int cnt = 0; 

        
        
        // here first i have to check wheather 0 present if s then k-- if k -> 0 then i have loop till k->1 and then i have to find the length btn rigt to left

        for (int right = 0; right < nums.length; right++) {

        // Use a flip when we encounter 0
        if (nums[right] == 0) {
            k--;
        }

        // More than k zeros -> shrink window
        while (k < 0) {
            if (nums[left] == 0) {
                k++;
            }
            left++;
        }

        // Current window is valid
        max = Math.max(max, right - left + 1);
    }

    return max;
        
    
    }
    
}

