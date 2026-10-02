class Solution {

    private int rearrange(int nums[], int s, int e){
        int r = s + (int)(Math.random() * (e - s + 1));
        swap(nums, r, s);
        int p1 = s+1;
        int p2 = e;

        while(p1 <= p2){
            if(nums[s] >= nums[p1]){
                p1++;
            }
            else if(nums[s] < nums[p2]){
                p2--;
            }

            else{
                swap(nums, p1, p2);
                p1++;
                p2--;
            }
        }

        swap(nums, p2, s);
        return p2;
    }

    private void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void quicksort(int nums[], int s, int e){
        if(s >= e){return;}
        int p = rearrange(nums, s, e);
        quicksort(nums, s, p-1);
        quicksort(nums, p+1, e);
    }
    
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
}