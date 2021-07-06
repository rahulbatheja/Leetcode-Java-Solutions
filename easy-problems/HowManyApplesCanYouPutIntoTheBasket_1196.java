class Solution {
    public int maxNumberOfApples(int[] arr) {
        if (arr.length == 0)
            return 0;

        Arrays.sort(arr);
        int countOfApples = 0;
        int currentIdx = 0;
        int totalWeightOfApples = 0;
        while (currentIdx < arr.length && totalWeightOfApples + arr[currentIdx] <= 5000) {
            countOfApples++;
            totalWeightOfApples += arr[currentIdx];
            currentIdx++;

        }

        return countOfApples;

    }
}