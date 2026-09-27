class Solution {
    private void replace(int[] nums, int[] ans, int max, int idx){
        if(idx == -1){return ;}
        ans[idx] = max;
        max = Math.max(max, nums[idx]);
        replace(nums,ans,max,idx-1);
    }
    public int[] replaceElements(int[] arr) {
        int ans[] = new int[arr.length];
        ans[arr.length-1] = -1;
        replace(arr, ans, arr[arr.length-1], arr.length-2);
        return ans;
    }
}