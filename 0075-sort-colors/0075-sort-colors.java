// // we use count sort as bf
// class Solution {
//     public void sortColors(int[] nums) {
//         int freq[] = new int[3];
//         for(int n: nums){
//             freq[n]++;
//         }
//         int k = 0;

//         for(int i = 0; i<3; i++){
//             int fr = freq[i];

//             for(int j = 0; j<fr; j++){
//                 nums[k] = i;
//                 k++;
//             }
//         }
//     }
// }



// we used Dutch national flag
class Solution {
    public void sortColors(int[] nums) {
       int low = 0;
       int mid = 0;
       int heigh = nums.length - 1;

       while(mid <= heigh){
            if(nums[mid] == 0){
                swap(nums, low, mid);
                mid++;
                low++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, heigh);
                heigh--;
            }
       }
    }


    private void swap(int n[], int A, int B){
        int temp = n[A];
        n[A] = n[B];
        n[B] = temp;
    }
}