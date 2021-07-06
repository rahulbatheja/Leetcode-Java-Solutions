

class CountToWords {
    int count;
    String actualWord;

    public CountToWords(int count, String actualWord) {
        this.count = count;
        this.actualWord = actualWord;
    }
}


class ValidWordAbbr {
    private final HashMap<String, CountToWords> auxMap = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String currentString : dictionary) {

            String currentAbb = currentString.charAt(0) +
                    String.valueOf(currentString.length() - 2) +
                    currentString.charAt(currentString.length() - 1);

            if (this.auxMap.containsKey(currentAbb)) {

                if (!this.auxMap.get(currentAbb).actualWord.equals(currentString)) {

                    this.auxMap.get(currentAbb).count = 2;
                }

            } else
                this.auxMap.put(currentAbb, new CountToWords(1, currentString));

        }


    }

    public boolean isUnique(String word) {
        String currentAbb = word.charAt(0) +
                String.valueOf(word.length() - 2) +
                word.charAt(word.length() - 1);

        if (!this.auxMap.containsKey(currentAbb))
            return true;
        else {
            if (this.auxMap.get(currentAbb).count > 1)
                return false;
            else {
                if (this.auxMap.get(currentAbb).actualWord.equals(word))
                    return true;
                else return false;

            }
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */