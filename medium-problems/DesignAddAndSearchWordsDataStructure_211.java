class WordDictionary {

    private class TrieNode {
        boolean isEnd;
        TrieNode[] childs;

        TrieNode() {
            this.childs = new TrieNode[26];
            this.isEnd = false;
        }

    }


    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        if (word.length() == 0)
            return;

        TrieNode currentNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int pos = currentChar - 'a';

            if (currentNode.childs[pos] == null)
                currentNode.childs[pos] = new TrieNode();

            currentNode = currentNode.childs[pos];

        }
        currentNode.isEnd = true;

    }

    public boolean search(String word) {
        if (word.length() == 0)
            return true;

        return matchString(word, 0, this.root);
    }

    private boolean matchString(String word, int currentIndex, TrieNode currentNode) {

        if (currentIndex == word.length())
            return currentNode.isEnd;

        char currentChar = word.charAt(currentIndex);
        if (currentChar == '.') {
            for (int i = 0; i < 26; i++) {
                if (currentNode.childs[i] != null) {
                    boolean subProblem = matchString(word, currentIndex + 1, currentNode.childs[i]);
                    if (subProblem)
                        return true;

                }

            }
            return false;

        } else {
            int pos = currentChar - 'a';
            if (currentNode.childs[pos] != null)
                return matchString(word, currentIndex + 1, currentNode.childs[pos]);

            return false;
        }

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */