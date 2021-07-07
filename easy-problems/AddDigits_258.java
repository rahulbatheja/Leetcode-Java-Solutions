class Solution {
    public int addDigits(int num) {
        if (num == 0)
            return 1;

        int currentNumber = num;
        int sum = 0;
        while (currentNumber / 10 != 0) {
            sum = 0;
            while (currentNumber != 0) {
                sum += currentNumber % 10;
                currentNumber = currentNumber / 10;
            }
            currentNumber = sum;
        }
        return sum;


    }
}