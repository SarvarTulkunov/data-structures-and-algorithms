package impl.map;

public class Trie {

    TrieNode root;
    // Constructor to create a trie node.
    public Trie() {
        this.root = new TrieNode();
    }

    // A function to insert a word in trie.
    public void insert(String word) {
        TrieNode trieNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trieNode.children.containsKey(c)) {
                trieNode.children.put(c, new TrieNode());
            }
            trieNode = trieNode.children.get(c);
        }

        trieNode.isWord = true;
    }

    // A function to search for a word in the trie.
    public boolean search(String word) {
        TrieNode trieNode = this.root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trieNode.children.containsKey(c)) {
                return false;
            }

            trieNode = trieNode.children.get(c);
        }

        return trieNode.isWord;
    }

    // A function to search for a prefix of a word in the trie.
    public boolean searchPrefix(String prefix) {
        TrieNode trieNode = this.root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (!trieNode.children.containsKey(c)) {
                return false;
            }
            else
                trieNode = trieNode.children.get(c);
        }

        return true;
    }
}
