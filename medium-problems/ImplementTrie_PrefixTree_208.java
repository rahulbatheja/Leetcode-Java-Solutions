class Trie {

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
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word.length() == 0)
            return;

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentNode.childs[currentChar - 'a'] == null)
                currentNode.childs[currentChar - 'a'] = new TrieNode();

            currentNode = currentNode.childs[currentChar - 'a'];
        }
        currentNode.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word.length() == 0)
            return true;

        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (currentNode.childs[currentChar - 'a'] == null)
                return false;

            currentNode = currentNode.childs[currentChar - 'a'];
        }
        return currentNode.isEnd;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

        if (prefix.length() == 0)
            return true;

        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (currentNode.childs[currentChar - 'a'] == null)
                return false;

            currentNode = currentNode.childs[currentChar - 'a'];
        }
        return true;

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */