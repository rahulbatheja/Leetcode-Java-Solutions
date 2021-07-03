class Solution {
    public boolean isArmstrong(int inputNumber) {
        if (inputNumber <= 1)
            return true;

        int tempNumber = inputNumber;
        int digitsInNumber = countNoOfDigits(inputNumber);
        int sum = 0;
        while (tempNumber > 0) {
            sum += (int) Math.pow(tempNumber % 10, digitsInNumber);
            tempNumber = tempNumber / 10;
        }


        return sum == inputNumber;


    }

    private int countNoOfDigits(int inputNumber) {
        int count = 0;
        while (inputNumber > 0) {
            inputNumber = inputNumber / 10;
            count++;
        }
        return count;

    }


}