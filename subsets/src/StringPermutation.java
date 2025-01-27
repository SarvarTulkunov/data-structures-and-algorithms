import java.util.ArrayList;

public class StringPermutation {

    public static ArrayList<String> permuteWord(String word) {
        {
            ArrayList<String> results = new ArrayList<String>();
            permuteStringRec(word, 0, results);
            return results;
        }
    }

    public static void permuteStringRec(String word, int currentIndex, ArrayList<String> results) {
        if (currentIndex == word.length() - 1) {
            System.out.println("added: " + word);
            results.add(word);
            return;
        }

        for (int index = currentIndex; index < word.length(); index++) {
            String swappedStr = swapChar(word, currentIndex, index);
            System.out.println("currentIndex = " + currentIndex + ", index = " + index + ", swappedStr = " + swappedStr);
            permuteStringRec(swappedStr, currentIndex + 1, results);
        }
    }

    public static String swapChar(String word, int i, int j) {
        char[] swapIndex = word.toCharArray();
        char temp = swapIndex[i];
        swapIndex[i] = swapIndex[j];
        swapIndex[j] = temp;

        return new String(swapIndex);
    }

    public static void main(String[] args) {
        permuteWord("abdf");
    }
}
