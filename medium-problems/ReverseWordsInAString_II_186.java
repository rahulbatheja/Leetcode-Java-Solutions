class Solution {
    public void reverseWords(char[] s) {
        if (s.length == 0 || s.length == 1)
            return;


        reverse(s, 0, s.length - 1);
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                end = i - 1;
                reverse(s, start, end);
                start = i + 1;
            }
        }
reverse(s,start,s.length-1);

    }


    private void reverse(char[] string, int startingIndex, int endingIndex) {
        int left = startingIndex;
        int right = endingIndex;
        while (left < right) {
            char temp = string[left];
            string[left] = string[right];
            string[right] = temp;
        }
    }


}