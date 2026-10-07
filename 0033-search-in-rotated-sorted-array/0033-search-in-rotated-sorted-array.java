class Solution {
    private int pivot(int nums[], int target){
        int l = 0;
        int r = nums.length - 1;
        int pivot = 0;
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] >= nums[0]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
                pivot = mid;
            }
        }
        return pivot;
    }

    private int BSL(int nums[], int left, int right,int target){
        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) { 
        int p = pivot(nums, target);
        int searchL =  BSL(nums, 0, p-1, target);
        int searchR =  BSL(nums, p, nums.length - 1, target);

        return Math.max(searchL, searchR);
    }
}