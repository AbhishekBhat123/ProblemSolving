class Solution {
    private int BSleft(int nums[], int target){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == target){
                r = mid - 1;
                ans = mid;
            }
            else if(nums[mid] <target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return ans;
    }


        private int BSright(int nums[], int target){
        int l = 0;
        int r = nums.length - 1;
        int ans = -1;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] == target){
                l = mid + 1;
                ans = mid;
            }
            else if(nums[mid] <target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        // if(nums.length <=1){return new int[]{-1, -1};}
        int l = BSleft(nums, target);
        int r = BSright(nums, target);
        return new int[]{l,r}; 
    }
}