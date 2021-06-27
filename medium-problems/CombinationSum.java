


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0)
            return result;

        List<Integer> currentList = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, result, currentList);
        return result;


    }

    private void combinationSumHelper(int[] candidates, int target, int currentIndex,
                                      List<List<Integer>> result, List<Integer> currentList) {


        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        if (target < 0)
            return;
        if (currentIndex >= candidates.length)
            return;

        currentList.add(candidates[currentIndex]);
        combinationSumHelper(candidates, target - candidates[currentIndex], currentIndex, result, currentList);
        currentList.remove(currentList.size() - 1);

        combinationSumHelper(candidates, target, currentIndex + 1, result, currentList);


    }

}