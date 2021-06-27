


class Solution {
    public List<List<Integer>> subsets(int[] nums) {


        if (nums.length == 0)
            return new ArrayList<>();
        return subsetsHelper(nums, 0);

    }

    private List<List<Integer>> subsetsHelper(int[] nums, int currentIndex) {

        if (currentIndex == nums.length) {
            List<List<Integer>> powerSet = new ArrayList<>();
            List<Integer> baseResult = new ArrayList<>();
            powerSet.add(baseResult);
            return powerSet;
        }

        List<List<Integer>> powerSet = new ArrayList<>();
        List<List<Integer>> subProblemResult = subsetsHelper(nums, currentIndex + 1);
        int currentNumber = nums[currentIndex];
        for (int i = 0; i < subProblemResult.size(); i++) {
            powerSet.add(new ArrayList<>(subProblemResult.get(i)));
            subProblemResult.get(i).add(0, currentNumber);
            powerSet.add(new ArrayList<>(subProblemResult.get(i)));
        }

        return powerSet;
    }


}