class Solution {
    public int totalHammingDistance(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return getSetBits(nums[0]);


        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count += getSetBits(nums[i] ^ nums[j]);
            }
        }


    }

    private int getSetBits(int number) {
        int count = 0;
        int mask;
        for (int i = 0; i < 32; i++) {
            mask = 1 << i;
            if ((mask & number) != 0)
                count++;

        }

        return count;
    }


}