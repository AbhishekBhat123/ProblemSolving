// class Solution {
//     List<List<Integer>> result = new ArrayList<>();
//     private void combination(int sum, int[] candidates, int index, int target, List<Integer> ans){
//         if(sum == target){
//             // Collections.sort(ans);
//             // if(!result.contains(ans)){
//                 result.add(new ArrayList<>(ans));
//             // }
//             return;
//         }
//         else if(sum > target){
//             return;
//         }

//         for(int i = index; i<candidates.length; i++){
//             ans.add(candidates[i]);
//             combination(sum+candidates[i], candidates, i, target, ans);
//             // here i as index i means I can reuse the current element. i + 1 means I cannot reuse it. initially i wasnt passed any index it would be start from 0 so at that time we get non repaeated values so i wasnt choose i+1 because it will skip current element so choosed as i it will make same element on next choice and however we will not getting the previous value anymore if i move next
//             ans.remove(ans.size() - 1);
//         }
//     }
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result.clear();
//         combination(0, candidates, 0, target, new ArrayList<>());
//         return result;
//     }
// }


class Solution {

    List<List<Integer>> result = new ArrayList<>();

    private void combination(
        int[] candidates,
        int index,
        int target,
        List<Integer> ans
    ) {

        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Pruning
            if (candidates[i] > target) {
                break;
            }

            ans.add(candidates[i]);

            // Pass i because reuse is allowed
            combination(candidates, i, target - candidates[i], ans);

            // Backtrack
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result.clear();

        Arrays.sort(candidates);

        combination(candidates, 0, target, new ArrayList<>());

        return result;
    }
}