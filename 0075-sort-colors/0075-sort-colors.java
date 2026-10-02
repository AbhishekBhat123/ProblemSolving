// we use count sort as bf
class Solution {
    public void sortColors(int[] nums) {
        int freq[] = new int[3];
        for(int n: nums){
            freq[n]++;
        }
        int k = 0;

        for(int i = 0; i<3; i++){
            int fr = freq[i];

            for(int j = 0; j<fr; j++){
                nums[k] = i;
                k++;
            }
        }
    }
}