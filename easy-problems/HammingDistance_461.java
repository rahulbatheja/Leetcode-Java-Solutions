class Solution {
    public int hammingDistance(int firstNumber, int secondNumber) {


        int number = firstNumber ^ secondNumber;
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