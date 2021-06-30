

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        if (nums.length == 1)
            return new ArrayList<>(Collections.singletonList(
                    new ArrayList<>(Collections.singletonList(nums[0]))));


        return permuteHelper(nums, 0);
    }

    private List<List<Integer>> permuteHelper(int[] nums, int currentIndex) {
        if (currentIndex == nums.length - 1) {
            return new ArrayList<>(Collections.singletonList(
                    new ArrayList<>(Collections.singletonList(nums[currentIndex]))));
        }


        int currentElement = nums[currentIndex];
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> subProblemAns = permuteHelper(nums, currentIndex + 1);
        for (List<Integer> singleSubProblemAns : subProblemAns) {
            for (int i = 0; i <= singleSubProblemAns.size(); i++) {
                List<Integer> currentOutput = new ArrayList<>(singleSubProblemAns);
                currentOutput.add(i, currentElement);
                result.add(currentOutput);
            }

        }

        return result;
    }

}