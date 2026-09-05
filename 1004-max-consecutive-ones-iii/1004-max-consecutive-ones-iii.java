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



// Optimal using sliding window 
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int left = 0;
        int cnt = 0;
        int kval = k;

        for(int right = 0; right<n; right++){
            if(nums[right] == 1){
                cnt++;
                max = Math.max(max, cnt);
            }
            else if(nums[right] == 0 && kval!=0){
                cnt++;
                kval--;
                max = Math.max(max, cnt);
            }
            else{
                while(kval==0){
                    cnt--;
                    if(nums[left] == 0){kval++;}
                    left++;
                }
                if(kval >0){
                    cnt++;
                    max = Math.max(cnt,max);
                    kval--;
                }
            }
        }
        return max;
    }
}