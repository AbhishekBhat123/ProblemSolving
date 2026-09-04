// class Solution {
//     public int numSubarrayBoundedMax(int[] nums, int left, int right) {
//      int n = nums.length;
//      int max = 0; 
//      int cnt = 0;

//      for(int i = 0; i<n; i++){
//         max = nums[i]; 

//         for(int j = i; j<n; j++){
//             max = Math.max(max, nums[j]); 

//             if(max>= left && max<= right){
//                 cnt++;
//             }
//         }
//      }   
//      return cnt;
//     }
// }


// Optimal 
class Solution {
    private long countsubarays(int nums[], int bound){
        long count = 0;
        long length = 0;

        for(int num: nums){
            if(num <= bound){
                length++;
                count += length;
            }
            else{length = 0;}
        }

        return count;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
     int n = nums.length;
     int max = 0; 
     long a= countsubarays(nums, right);
     long b = countsubarays(nums, left-1);

     return (int) (a - b);


    }
}