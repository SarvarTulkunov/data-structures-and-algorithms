package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestion {

    private Node root = new Node();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        for (String product : products) {
            insert(product);
        }
        return search(searchWord);
    }

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Node();
            }
            node = node.children[index];
            node.searchWords.offer(word);
            if (node.searchWords.size() > 3) {
                node.searchWords.pollLast();
            }
        }
    }

    public List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        Node node = root;
        for (char c : searchWord.toCharArray()) {
            int index = c - 'a';
            if (node != null) {
                node = node.children[index];
            }
            result.add(node == null ? Arrays.asList() : node.searchWords);
        }
        return result;
    }
}
