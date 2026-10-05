class Solution {
    public int[] frequencySort(int[] nums) {
        Integer arr[] = new Integer[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int i = 0; i<nums.length; i++){
            arr[i] = nums[i];
        }

        Arrays.sort(arr, (a,b) -> {
            if(!map.get(a).equals(map.get(b))){
                return Integer.compare(map.get(a),map.get(b));
            }
            return Integer.compare(b,a);
        });

        for(int i = 0; i<nums.length; i++){
            nums[i] = arr[i];
        }       
        return nums;
       }
}