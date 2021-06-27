


class Solution {
    public int numMatchingSubseq(String s, String[] words) {

        if (s.length() == 0 || words.length == 0)
            return 0;

        List<StringBuilder>[] buckets = new List[26];

        int count = 0;
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            char firstChar = words[i].charAt(0);
            buckets[firstChar - 'a'].add(new StringBuilder(words[i]));
        }

        int parentStringIndex = 0;
        while (parentStringIndex < s.length()) {
            char currentParentChar = s.charAt(parentStringIndex);

            List<StringBuilder> stringsToUpdate = buckets[currentParentChar - 'a'];
            buckets[currentParentChar - 'a'].clear();
            for (int i = 0; i < stringsToUpdate.size(); i++) {
                StringBuilder remainingStringBuilder = stringsToUpdate.get(i).substring(1);
                if (remainingStringBuilder.length() == 0)
                    count++;
                else {
                    buckets[remainingStringBuilder.charAt(0) - 'a'].add(remainingStringBuilder);
                }
            }

            parentStringIndex++;
        }

        return count;

    }
}