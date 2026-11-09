class Solution {

    List<List<Integer>> result = new ArrayList<>();

    private void generate(int[] candidates, int index,
                          int target, List<Integer> ans) {

        if (target == 0) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Skip duplicates at the same recursion level
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Pruning
            if (candidates[i] > target) {
                break;
            }

            ans.add(candidates[i]);

            // i + 1 because each element can be used only once
            generate(candidates, i + 1, target - candidates[i], ans);

            // Backtracking
            ans.remove(ans.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        result.clear();

        Arrays.sort(candidates);

        generate(candidates, 0, target, new ArrayList<>());

        return result;
    }
}