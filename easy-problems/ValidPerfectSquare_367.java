class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0)
            return false;
        if (num == 1)
            return true;

        long left = 2;
        long right = (long)num / 2;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num)
                left = mid + 1;
            else right = mid - 1;

        }

        return false;
    }
}