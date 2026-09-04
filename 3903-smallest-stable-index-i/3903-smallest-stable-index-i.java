class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minfin = Integer.MAX_VALUE;

        ans[n-1] = nums[n-1];
        min = ans[n-1];
        // storing min value from right to left
        for(int i = n-2; i>=0; i--){
            min = Math.min(min, nums[i]);
            ans[i] = min;
        }

        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            int instability = max - ans[i];
            minfin = Math.min(minfin, instability);
            if(minfin <= k){return i;}
            
        }

        return -1;
        
    }
}