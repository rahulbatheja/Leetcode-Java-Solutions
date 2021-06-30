class Solution {
    public boolean isPowerOfTwo(int inputNumber) {

        if(inputNumber == 0 || inputNumber < 0)
            return false;


        int setBitCount =0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;

            /**
             * checking whehter ith bit of input number is set or not
             */
            if ((inputNumber & mask) != 0)
                setBitCount++;

            /**
             * if set bit counts equals to 2 return false
             */
            if (setBitCount == 2)
                return false;

        }

        return true;
    }
}