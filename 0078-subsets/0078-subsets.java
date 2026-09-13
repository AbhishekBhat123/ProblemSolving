class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // create 2d Al
        List<List<Integer>> ans = new ArrayList<>();
        // create 1d AL
        List<Integer> current = new ArrayList<>();

        subsequence(nums, 0, ans, current);

        return ans;
    }

    private void subsequence(int nums[] , int index, List<List<Integer>> ans, List<Integer> current){
        // base case
        if(index == nums.length){
            // this ans.add(new ArrayList<>(current)); creates the copy of the current AL previously i wrote as ans.add(current) here it will just add the current to the 2dAL and if i modify current then 2dAL also changes
            // this is same as this List<Integer> copy = new ArrayList<>(current); ans.add(copy);
 
            ans.add(new ArrayList<>(current));
            return;
        }


        // Take
        current.add(nums[index]);
        subsequence(nums,index+1, ans, current);


        // Dont take
        current.remove(current.size()-1);
        subsequence(nums,index+1, ans, current);
    }
}