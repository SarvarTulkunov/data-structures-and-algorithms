package leetcode;


/**
 * 211. Design Add and Search Words Data Structure
 */
public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }

    private boolean dfs(TrieNode root, int idx, String word) {
        TrieNode cur = root;

        for (int i = idx; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (TrieNode child : cur.children.values()) {
                    if (child != null && dfs(child, i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }

        return cur.isWord;
    }
}
