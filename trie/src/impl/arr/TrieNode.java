package impl.arr;

public class TrieNode {
    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[26]; // 26 English lowercase letters
    }
}
