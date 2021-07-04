class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1)
            return arr[0];
        int currentWindowSize = 1;

        int output = 0;
        while (currentWindowSize <= arr.length) {

            int sumOfCurrentSubarrayOfCurrentWindow = 0;
            for (int i = 0; i < currentWindowSize; i++)
                sumOfCurrentSubarrayOfCurrentWindow += arr[i];

            output += sumOfCurrentSubarrayOfCurrentWindow;
            System.out.println(output);
            for (int i = currentWindowSize; i < arr.length; i++) {
                sumOfCurrentSubarrayOfCurrentWindow -= arr[i - currentWindowSize];
                sumOfCurrentSubarrayOfCurrentWindow += arr[i];

                output += sumOfCurrentSubarrayOfCurrentWindow;
                System.out.println(output);
            }

            currentWindowSize += 2;

        }


        return output;
    }
}