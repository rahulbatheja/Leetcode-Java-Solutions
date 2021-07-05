class Solution {

    private class Trie {

        private class TrieNode {
            boolean isEnd;
            TrieNode[] childs;

            TrieNode() {
                this.isEnd = false;
                this.childs = new TrieNode[26];
            }
        }

        private final TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (word.length() == 0)
                return;
            TrieNode currentNode = this.root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (currentNode.childs[currentChar - 'a'] == null)
                    currentNode.childs[currentChar - 'a'] = new TrieNode();

                currentNode = currentNode.childs[currentChar - 'a'];
            }
            currentNode.isEnd = true;
        }


        public boolean isWordBreakPossible(String inputString) {
            if (inputString.length() == 0)
                return true;

            TrieNode currentNode = this.root;
            boolean isReAssigned = false;
            for (int i = 0; i < inputString.length(); i++) {
                char currentChar = inputString.charAt(i);
                if (currentNode.childs[currentChar - 'a'] == null) {
                    currentNode = this.root;
                    if (isReAssigned)
                        return false;
                    isReAssigned = true;
                    i--;
                } else {
                    currentNode = currentNode.childs[currentChar - 'a'];
                    isReAssigned = false;
                }


            }


            return true;
        }


    }


    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict.size() == 0)
            return false;


        Trie trie = new Trie();
        for (String dict : wordDict)
            trie.insert(dict);

        return trie.isWordBreakPossible(s);

    }
}