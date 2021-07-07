


class Solution {
    public int minSetSize(int[] arr) {
        if (arr.length <= 1)
            return arr.length;
        if (arr.length == 2)
            return 1;


        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> frequencies = new ArrayList<>(frequencyMap.keySet());
        list.sort(Collections.reverseOrder());
        int output = 0;
        int currentFreqIndexSelected = 0;

        int remainingNoOfElements = arr.length;
        while (true) {
            remainingNoOfElements -= frequencies.get(currentFreqIndexSelected);
            output++;
            if (remainingNoOfElements <= arr.length / 2)
                break;
            else
                currentFreqIndexSelected++;

        }

        return output;

    }
}