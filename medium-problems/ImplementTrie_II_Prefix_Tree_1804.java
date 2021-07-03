class Trie {


    private class TrieNode {
        boolean isEnd;
        int sameWordCount;
        int prefixCount;
        TrieNode[] childs;

        TrieNode() {
            this.isEnd = false;
            this.sameWordCount = 0;
            childs = new TrieNode[26];
        }

    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        if (word.length() == 0)
            return;

        TrieNode currentNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (currentNode.childs[currentChar - 'a'] == null) {
                currentNode.childs[currentChar - 'a'] = new TrieNode();

            }
            currentNode.childs[currentChar - 'a'].prefixCount++;
            currentNode = currentNode.childs[currentChar - 'a'];
        }

        currentNode.isEnd = true;
        currentNode.sameWordCount++;


    }

    public int countWordsEqualTo(String word) {
        if (word.length() == 0)
            return 0;

        TrieNode curretNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (curretNode.childs[currentChar - 'a'] == null)
                return 0;

            curretNode = curretNode.childs[currentChar - 'a'];
        }

        return curretNode.sameWordCount;

    }

    public int countWordsStartingWith(String prefix) {

        if (prefix.length() == 0)
            return 0;

        TrieNode curretNode = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (curretNode.childs[currentChar - 'a'] == null)
                return 0;

            curretNode = curretNode.childs[currentChar - 'a'];
        }

        return curretNode.prefixCount;


    }

    public void erase(String word) {
        if (word.length() == 0)
            return;

        TrieNode curretNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (curretNode.childs[currentChar - 'a'] == null)
                return;
            else if (curretNode.childs[currentChar - 'a'].prefixCount == 1) {
                curretNode.childs[currentChar - 'a'] = null;
                return;
            }

            curretNode.childs[currentChar - 'a'].prefixCount--;
            curretNode = curretNode.childs[currentChar - 'a'];
        }

        curretNode.sameWordCount--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */